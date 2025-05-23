package mqq.app;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.service.IDBMonitorService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mqq.app.Constants;
import mqq.inject.ILoginMainTicketCallback;
import mqq.inject.LoginTicketResult;
import mqq.inject.MqqInjectorManager;
import mqq.inject.SigInjectManager;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.listener.PrivacyListener;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WTLoginRecordSnapshot;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TicketManagerImpl implements TicketManager {
    public static final int APPID_QQ = 16;
    public static final int BUFLAG_OPEN_CONNECT = 1600001540;
    private static final String EVENT_CHANGE_TOKEN_SRC = "wt_change_token_src";
    private static final int FAIL_NOT_PSKEY_DOMAIN = -5;
    private static final int FAIL_SDK_EXCEPTION = -4;
    private static final int FAIL_TICKET_NULL = -2;
    private static final int FAIL_TICKET_SIG_NULL = -3;
    private static final int FAIL_UIN_NONE = -1;
    private static final String KEY_SRC = "src";
    private static final String TAG = "TicketManager";
    public static final int TEN_MINUTE = 600000;
    public static final String WTLOGIN_GET_A2_FAIL = "wtlogin_get_a2_fail";
    private long lastReportTime;
    private final AppRuntime mApp;
    private TicketManager.IPskeyManager mPskeyManager;
    private WtloginHelper mWtLoginHelper;
    private HashMap<String, String> mAlterTicketsMap = new HashMap<>();
    private ArrayList<TicketManagerListener> mTicketListeners = new ArrayList<>();

    public TicketManagerImpl(AppRuntime appRuntime) {
        this.mApp = appRuntime;
        WtloginHelper.setReportListener(WtloginReportListenerImpl.getSingleton());
        WtloginHelper.setSwitchListener(WtloginSwitchListenerImpl.getSingleton());
        WtloginHelper wtloginHelper = new WtloginHelper(BaseApplication.getContext(), this, WtloginPrivacyListenerImpl.getSingleton());
        this.mWtLoginHelper = wtloginHelper;
        wtloginHelper.SetMsfTransportFlag(1);
        util.LOGCAT_OUT = false;
    }

    private boolean canReport() {
        if (!MqqInjectorManager.instance().isPublicVersion()) {
            return true;
        }
        if (new Random().nextInt(100) == 1 && MqqInjectorManager.instance().getSwitch("103024", false)) {
            return true;
        }
        return false;
    }

    private String getA2Impl(String str, int i3, int i16, String str2) {
        int i17;
        QLog.d(TAG, 2, "getA2Impl key: " + str2);
        try {
            if (!TextUtils.isEmpty(str)) {
                Ticket GetLocalTicket = this.mWtLoginHelper.GetLocalTicket(str, i3, i16);
                if (GetLocalTicket != null) {
                    byte[] bArr = GetLocalTicket._sig;
                    if (bArr != null) {
                        reportGetTicketResult(true, str2, str, 0);
                        return HexUtil.bytes2HexStr(bArr);
                    }
                    QLog.d(TAG, 1, "get ticket failed, A2, sig is null, key: " + str2);
                    i17 = -3;
                } else {
                    QLog.d(TAG, 1, "get ticket failed, A2, ticket is null, key: " + str2);
                    i17 = -2;
                }
            } else {
                QLog.d(TAG, 1, "get ticket failed, A2, uin is empty!");
                i17 = -1;
            }
        } catch (Exception e16) {
            QLog.d(TAG, 1, "get ticket failed, A2, exception: " + e16.toString());
            i17 = -4;
        }
        if (this.mApp != null && !TextUtils.isEmpty(str) && str.equals(this.mApp.getAccount()) && !TextUtils.isEmpty(this.mAlterTicketsMap.get(str2))) {
            reportGetTicketResult(true, str2, str, i17);
            return this.mAlterTicketsMap.get(str2);
        }
        reportGetTicketResult(false, str2, str, i17);
        if (i3 == 16) {
            reportGetA2Fail(str, i17);
            return null;
        }
        return null;
    }

    private void reportChangeTokenSrc(String str, String str2) {
        try {
            if (!canReport()) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("src", str2);
            BaseApplication.getContext().getMSFInterfaceAdapter().beaconReport(str, EVENT_CHANGE_TOKEN_SRC, true, hashMap, false);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    private void reportGetA2Fail(String str, int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.lastReportTime) > 600000) {
            HashMap hashMap = new HashMap();
            hashMap.put("userId", str);
            hashMap.put("failReason", String.valueOf(i3));
            ((IDBMonitorService) QRoute.api(IDBMonitorService.class)).reportDBEventByBeacon(str, WTLOGIN_GET_A2_FAIL, hashMap);
            this.lastReportTime = currentTimeMillis;
        }
    }

    private void reportGetPskeyToPskeyManager(String[] strArr) {
        if (this.mPskeyManager == null) {
            return;
        }
        QLog.d(TAG, 2, "reportGetPskey");
        this.mPskeyManager.reportGetPskey(strArr);
    }

    private boolean useNewWt() {
        return MobileQQ.sMobileQQ.isLoginByNT();
    }

    @Override // mqq.manager.TicketManager
    public int addWTLoginRecordFromNT(WTLoginRecordSnapshot wTLoginRecordSnapshot) {
        QLog.d(TAG, 1, "addWTLoginRecordFromNT " + wTLoginRecordSnapshot);
        return this.mWtLoginHelper.addWTLoginRecordFromNT(wTLoginRecordSnapshot);
    }

    @Override // mqq.manager.TicketManager
    public void clearA1(long j3, int i3) {
        QLog.d(TAG, 1, "clearA1  uin: " + j3 + " appid:" + i3);
        this.mWtLoginHelper.clear_a1(j3, i3);
    }

    @Override // mqq.manager.TicketManager
    public byte[] getA1(long j3, long j16, byte[] bArr) {
        return this.mWtLoginHelper.getA1(j3, j16, bArr);
    }

    @Override // mqq.manager.TicketManager
    public void getA2(final long j3, final int i3, final MainTicketCallback mainTicketCallback) {
        if (useNewWt()) {
            SigInjectManager.instance().getLoginSig(j3, i3, new ILoginMainTicketCallback() { // from class: mqq.app.TicketManagerImpl.1
                @Override // mqq.inject.ILoginMainTicketCallback
                public void onResult(final int i16, final String str, final LoginTicketResult loginTicketResult) {
                    QLog.d(TicketManagerImpl.TAG, 1, "getMainTicket" + ("[uin: " + j3 + ", appId:" + i3 + "]") + ": result = [" + i16 + "], errMsg = [" + str + "], loginTicketResult = [" + loginTicketResult + "]");
                    ThreadManagerV2.excute(new Runnable() { // from class: mqq.app.TicketManagerImpl.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int i17 = i16;
                            if (i17 == 0) {
                                MainTicketInfo mainTicketInfo = new MainTicketInfo();
                                mainTicketInfo.setA2(HexUtil.bytes2HexStr(loginTicketResult.f417209a2));
                                mainTicketCallback.onSuccess(mainTicketInfo);
                                return;
                            }
                            mainTicketCallback.onFail(i17, str);
                        }
                    }, 16, null, false);
                }
            });
            return;
        }
        String a2Impl = getA2Impl(String.valueOf(j3), i3, 64, NowProxyConstants.AccountInfoKey.A2);
        if (TextUtils.isEmpty(a2Impl)) {
            mainTicketCallback.onFail(-1, "a2 is null");
            return;
        }
        MainTicketInfo mainTicketInfo = new MainTicketInfo();
        mainTicketInfo.setA2(a2Impl);
        mainTicketCallback.onSuccess(mainTicketInfo);
    }

    @Override // mqq.manager.TicketManager
    public void getD2(long j3, int i3, final MainTicketCallback mainTicketCallback) {
        Ticket ticket;
        byte[] bArr;
        byte[] bArr2;
        if (useNewWt()) {
            SigInjectManager.instance().getLoginSig(j3, i3, new ILoginMainTicketCallback() { // from class: mqq.app.TicketManagerImpl.2
                @Override // mqq.inject.ILoginMainTicketCallback
                public void onResult(final int i16, final String str, final LoginTicketResult loginTicketResult) {
                    QLog.d(TicketManagerImpl.TAG, 1, "getD2: result = [" + i16 + "], errMsg = [" + str + "], loginTicketResult = [" + loginTicketResult + "]");
                    ThreadManagerV2.excute(new Runnable() { // from class: mqq.app.TicketManagerImpl.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int i17 = i16;
                            if (i17 == 0) {
                                MainTicketInfo mainTicketInfo = new MainTicketInfo();
                                mainTicketInfo.setD2(loginTicketResult.f417210d2);
                                mainTicketInfo.setD2Key(loginTicketResult.d2Key);
                                mainTicketCallback.onSuccess(mainTicketInfo);
                                return;
                            }
                            mainTicketCallback.onFail(i17, str);
                        }
                    }, 16, null, false);
                }
            });
            return;
        }
        try {
            ticket = this.mWtLoginHelper.GetLocalTicket(String.valueOf(j3), i3, 262144);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "cannot getLocalTicket from helper", th5);
            ticket = null;
        }
        if (ticket != null && (bArr = ticket._sig) != null && bArr.length != 0 && (bArr2 = ticket._sig_key) != null && bArr2.length != 0) {
            MainTicketInfo mainTicketInfo = new MainTicketInfo();
            mainTicketInfo.setD2(ticket._sig);
            mainTicketInfo.setD2Key(ticket._sig_key);
            mainTicketCallback.onSuccess(mainTicketInfo);
            return;
        }
        mainTicketCallback.onFail(-1, "d2/d2key is null");
    }

    @Override // mqq.manager.TicketManager
    public Ticket getD2Ticket(String str) {
        if (useNewWt()) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final Ticket ticket = new Ticket();
            SigInjectManager.instance().getLoginSig(Long.parseLong(str), 16L, new ILoginMainTicketCallback() { // from class: mqq.app.TicketManagerImpl.5
                @Override // mqq.inject.ILoginMainTicketCallback
                public void onResult(int i3, String str2, LoginTicketResult loginTicketResult) {
                    QLog.d(TicketManagerImpl.TAG, 1, "onResult() called with: result = [" + i3 + "], errMsg = [" + str2 + "], loginTicketResult = [" + loginTicketResult + "]");
                    Ticket ticket2 = ticket;
                    ticket2._sig = loginTicketResult.f417210d2;
                    ticket2._sig_key = loginTicketResult.d2Key;
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await(500L, TimeUnit.MILLISECONDS);
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
            return ticket;
        }
        try {
            return this.mWtLoginHelper.GetLocalTicket(str, 16L, 262144);
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "cannot getLocalTicket from helper " + th5.toString());
            return null;
        }
    }

    @Override // mqq.manager.TicketManager
    public void getMainTicket(final long j3, final int i3, final MainTicketCallback mainTicketCallback) {
        Ticket ticket;
        byte[] bArr;
        byte[] bArr2;
        if (useNewWt()) {
            SigInjectManager.instance().getLoginSig(j3, i3, new ILoginMainTicketCallback() { // from class: mqq.app.TicketManagerImpl.3
                @Override // mqq.inject.ILoginMainTicketCallback
                public void onResult(final int i16, final String str, final LoginTicketResult loginTicketResult) {
                    QLog.d(TicketManagerImpl.TAG, 1, "getMainTicket" + ("[uin: " + j3 + ", appId:" + i3 + "]") + ": result = [" + i16 + "], errMsg = [" + str + "], loginTicketResult = [" + loginTicketResult + "]");
                    ThreadManagerV2.excute(new Runnable() { // from class: mqq.app.TicketManagerImpl.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int i17 = i16;
                            if (i17 == 0) {
                                MainTicketInfo mainTicketInfo = new MainTicketInfo();
                                mainTicketInfo.setA2(HexUtil.bytes2HexStr(loginTicketResult.f417209a2));
                                mainTicketInfo.setD2(loginTicketResult.f417210d2);
                                mainTicketInfo.setD2Key(loginTicketResult.d2Key);
                                mainTicketCallback.onSuccess(mainTicketInfo);
                                return;
                            }
                            mainTicketCallback.onFail(i17, str);
                        }
                    }, 16, null, false);
                }
            });
            return;
        }
        String a2Impl = getA2Impl(String.valueOf(j3), i3, 64, NowProxyConstants.AccountInfoKey.A2);
        try {
            ticket = this.mWtLoginHelper.GetLocalTicket(String.valueOf(j3), i3, 262144);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "cannot getLocalTicket from helper", th5);
            ticket = null;
        }
        if (TextUtils.isEmpty(a2Impl)) {
            mainTicketCallback.onFail(-1, "a2 is null");
            return;
        }
        if (ticket != null && (bArr = ticket._sig) != null && bArr.length != 0 && (bArr2 = ticket._sig_key) != null && bArr2.length != 0) {
            MainTicketInfo mainTicketInfo = new MainTicketInfo();
            mainTicketInfo.setA2(a2Impl);
            mainTicketInfo.setD2(ticket._sig);
            mainTicketInfo.setD2Key(ticket._sig_key);
            mainTicketCallback.onSuccess(mainTicketInfo);
            return;
        }
        mainTicketCallback.onFail(-1, "d2/d2key is null");
    }

    @Override // mqq.manager.TicketManager
    public String getOpenA2(String str) {
        if (useNewWt()) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final String[] strArr = {""};
            SigInjectManager.instance().getLoginSig(Long.parseLong(str), BaseConstants.OPEN_SDK_BUFLAG_B1, new ILoginMainTicketCallback() { // from class: mqq.app.TicketManagerImpl.6
                @Override // mqq.inject.ILoginMainTicketCallback
                public void onResult(int i3, String str2, LoginTicketResult loginTicketResult) {
                    QLog.d(TicketManagerImpl.TAG, 1, "onResult() called with: result = [" + i3 + "], errMsg = [" + str2 + "], loginTicketResult = [" + loginTicketResult + "]");
                    strArr[0] = HexUtil.bytes2HexStr(loginTicketResult.f417209a2);
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await(500L, TimeUnit.MILLISECONDS);
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
            return strArr[0];
        }
        return getA2Impl(str, BUFLAG_OPEN_CONNECT, 64, "OpenConnectA2");
    }

    @Override // mqq.manager.TicketManager
    public String getPskey(String str, String str2) {
        int i3;
        Map<String, byte[]> map;
        try {
            reportGetPskeyToPskeyManager(new String[]{str2});
            if (!TextUtils.isEmpty(str)) {
                Ticket GetLocalTicket = this.mWtLoginHelper.GetLocalTicket(str, 16L, 1048576);
                if (GetLocalTicket != null && (map = GetLocalTicket._pskey_map) != null) {
                    byte[] bArr = map.get(str2);
                    if (bArr != null) {
                        reportGetTicketResult(true, "PSKEY", str, 0);
                        return new String(bArr);
                    }
                    i3 = -3;
                } else {
                    QLog.d(TAG, 1, "get ticket failed, PSKEY, ticket is null");
                    i3 = -2;
                }
            } else {
                QLog.d(TAG, 1, "get ticket failed, PSKEY, uin is empty!");
                i3 = -1;
            }
        } catch (Exception e16) {
            QLog.d(TAG, 1, "get ticket failed, PSKEY, exception: " + e16.toString());
            i3 = -4;
        }
        reportGetTicketResult(false, "PSKEY", str, i3);
        return null;
    }

    @Override // mqq.manager.TicketManager
    public Ticket getPskeyForOpen(String str, long j3, String[] strArr, byte[] bArr, WtTicketPromise wtTicketPromise) {
        try {
            reportChangeTokenSrc(str, "getPskeyForOpen");
            return this.mWtLoginHelper.GetPskey(str, j3, strArr, bArr, wtTicketPromise);
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "cannot getpskey from helper ", th5);
            return null;
        }
    }

    @Override // mqq.manager.TicketManager
    public String getPt4Token(String str, String str2) {
        int i3;
        try {
            if (!TextUtils.isEmpty(str)) {
                Ticket GetLocalTicket = this.mWtLoginHelper.GetLocalTicket(str, 16L, 1048576);
                if (GetLocalTicket != null) {
                    String pt4Token = GetLocalTicket.getPt4Token(str2);
                    if (pt4Token != null) {
                        reportGetTicketResult(true, "PT4TOKEN", str, 0);
                        QLog.d(TAG, 1, "get ticket succ, pt!");
                        return pt4Token;
                    }
                    QLog.d(TAG, 1, "get ticket failed, PT4TOKEN, expired");
                    i3 = -3;
                } else {
                    QLog.d(TAG, 1, "get ticket failed, PT4TOKEN, ticket is null");
                    i3 = -2;
                }
            } else {
                QLog.d(TAG, 1, "get ticket failed, PT4TOKEN, uin is empty!");
                i3 = -1;
            }
        } catch (Exception e16) {
            QLog.d(TAG, 1, "get ticket failed, PT4TOKEN, exception: " + e16.toString());
            i3 = -4;
        }
        reportGetTicketResult(false, "PT4TOKEN", str, i3);
        return null;
    }

    @Override // mqq.manager.TicketManager
    public String getRealSkey(String str) {
        return getSkey(str, 16, true);
    }

    @Override // mqq.manager.TicketManager
    public String getSkey(String str) {
        return getSkey(str, 16, false);
    }

    @Override // mqq.manager.TicketManager
    public byte[] getSt(String str, int i3) {
        int i16;
        try {
            if (!TextUtils.isEmpty(str)) {
                Ticket GetLocalTicket = this.mWtLoginHelper.GetLocalTicket(str, i3, 128);
                if (GetLocalTicket != null) {
                    byte[] bArr = GetLocalTicket._sig;
                    if (bArr != null) {
                        reportGetTicketResult(true, "st", str, 0);
                        return bArr;
                    }
                    QLog.d(TAG, 1, "get ticket failed, st, sig is null");
                    i16 = -3;
                } else {
                    QLog.d(TAG, 1, "get ticket failed, st, ticket is null");
                    i16 = -2;
                }
            } else {
                QLog.d(TAG, 1, "get ticket failed, st, uin is empty!");
                i16 = -1;
            }
        } catch (Exception e16) {
            QLog.d(TAG, 1, "get ticket failed, st, exception: " + e16.toString());
            i16 = -4;
        }
        reportGetTicketResult(false, "st", str, i16);
        return null;
    }

    @Override // mqq.manager.TicketManager
    public byte[] getStkey(String str, int i3) {
        int i16;
        try {
            if (!TextUtils.isEmpty(str)) {
                Ticket GetLocalTicket = this.mWtLoginHelper.GetLocalTicket(str, i3, 128);
                if (GetLocalTicket != null) {
                    byte[] bArr = GetLocalTicket._sig_key;
                    if (bArr != null) {
                        reportGetTicketResult(true, "stKey", str, 0);
                        return bArr;
                    }
                    QLog.d(TAG, 1, "get ticket failed, stKey, sig is null");
                    i16 = -3;
                } else {
                    QLog.d(TAG, 1, "get ticket failed, stKey, ticket is null");
                    i16 = -2;
                }
            } else {
                QLog.d(TAG, 1, "get ticket failed, stKey, uin is empty!");
                i16 = -1;
            }
        } catch (Exception e16) {
            QLog.d(TAG, 1, "get ticket failed, stKey, exception: " + e16.toString());
            i16 = -4;
        }
        reportGetTicketResult(false, "stKey", str, i16);
        return null;
    }

    @Override // mqq.manager.TicketManager
    public String getStweb(String str) {
        int i3;
        try {
            if (!TextUtils.isEmpty(str)) {
                Ticket GetLocalTicket = this.mWtLoginHelper.GetLocalTicket(str, 16L, 32);
                if (GetLocalTicket != null) {
                    byte[] bArr = GetLocalTicket._sig;
                    if (bArr != null) {
                        reportGetTicketResult(true, "STWEB", str, 0);
                        return HexUtil.bytes2HexStr(bArr);
                    }
                    i3 = -3;
                } else {
                    i3 = -2;
                }
            } else {
                i3 = -1;
            }
        } catch (Exception e16) {
            QLog.d(TAG, 1, "get ticket failed, STWEB, exception: " + e16.toString());
            i3 = -4;
        }
        if (this.mApp != null && !TextUtils.isEmpty(str) && str.equals(this.mApp.getAccount()) && !TextUtils.isEmpty(this.mAlterTicketsMap.get("stweb"))) {
            reportGetTicketResult(true, "STWEB", str, i3);
            return this.mAlterTicketsMap.get("stweb");
        }
        reportGetTicketResult(false, "STWEB", str, i3);
        return null;
    }

    @Override // mqq.manager.TicketManager
    public WTLoginRecordSnapshot getWTLoginRecordSnapshot(long j3, int i3) {
        WTLoginRecordSnapshot wTLoginRecordSnapshot = this.mWtLoginHelper.getWTLoginRecordSnapshot(j3, i3);
        QLog.d(TAG, 1, "getWTLoginRecordSnapshot " + wTLoginRecordSnapshot);
        return wTLoginRecordSnapshot;
    }

    @Override // mqq.manager.TicketManager
    public boolean isQQNTSignToWTRefreshSuccess(long j3) {
        boolean isQQNTSignToWTRefreshSuccess = this.mWtLoginHelper.isQQNTSignToWTRefreshSuccess(j3);
        QLog.d(TAG, 1, "isQQNTSignToWTRefreshSuccess:" + j3 + ",ret:" + isQQNTSignToWTRefreshSuccess);
        return isQQNTSignToWTRefreshSuccess;
    }

    @Override // mqq.manager.TicketManager
    public void registTicketManagerListener(TicketManagerListener ticketManagerListener) {
        try {
            if (!this.mTicketListeners.contains(ticketManagerListener)) {
                this.mTicketListeners.add(ticketManagerListener);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @Override // mqq.manager.TicketManager
    public void reloadCache(Context context) {
        QLog.d(TAG, 1, "reload ticket cache");
        WtloginHelper wtloginHelper = this.mWtLoginHelper;
        if (wtloginHelper == null) {
            this.mWtLoginHelper = new WtloginHelper(context, true, (PrivacyListener) WtloginPrivacyListenerImpl.getSingleton());
        } else {
            wtloginHelper.RefreshMemorySig();
        }
        ArrayList<TicketManagerListener> arrayList = this.mTicketListeners;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<TicketManagerListener> it = this.mTicketListeners.iterator();
            while (it.hasNext()) {
                it.next().onTicketRefreshed();
            }
        }
    }

    @Override // mqq.manager.TicketManager
    public int sendRPCData(long j3, String str, String str2, byte[] bArr, int i3) {
        try {
            NewIntent newIntent = new NewIntent(this.mApp.getApplication(), BuiltInServlet.class);
            newIntent.putExtra("uin", str);
            newIntent.putExtra("cmd", str2);
            newIntent.putExtra("busBuf", bArr);
            newIntent.putExtra("timeout", i3);
            newIntent.putExtra("wtsdkseq", j3);
            newIntent.putExtra("action", Constants.Action.ACTION_SEND_WTPKG);
            this.mApp.getServletContainer().forward(this.mApp, newIntent);
            return 0;
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    @Override // mqq.manager.TicketManager
    public void setAlterTicket(HashMap<String, String> hashMap) {
        if (hashMap != null && this.mApp != null) {
            QLog.d(TAG, 1, "set alter tickets for " + MsfSdkUtils.getShortUin(this.mApp.getAccount()));
            String str = hashMap.get("uin");
            String str2 = hashMap.get(NowProxyConstants.AccountInfoKey.A2);
            String str3 = hashMap.get("vkey");
            String str4 = hashMap.get("skey");
            String str5 = hashMap.get("stweb");
            String str6 = hashMap.get("superkey");
            AppRuntime appRuntime = this.mApp;
            if (appRuntime != null && appRuntime.getAccount() != null && this.mApp.getAccount().equals(str)) {
                this.mAlterTicketsMap.put(NowProxyConstants.AccountInfoKey.A2, str2);
                this.mAlterTicketsMap.put("vkey", str3);
                this.mAlterTicketsMap.put("skey", str4);
                this.mAlterTicketsMap.put("stweb", str5);
                this.mAlterTicketsMap.put("superkey", str6);
            }
        }
    }

    @Override // mqq.manager.TicketManager
    public void setPskeyManager(TicketManager.IPskeyManager iPskeyManager) {
        QLog.d(TAG, 2, "setPskeyManager pskeyManager = " + iPskeyManager);
        this.mPskeyManager = iPskeyManager;
    }

    @Override // mqq.manager.TicketManager
    public void unregistTicketManagerListener(TicketManagerListener ticketManagerListener) {
        try {
            if (this.mTicketListeners.contains(ticketManagerListener)) {
                this.mTicketListeners.remove(ticketManagerListener);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @Override // mqq.manager.TicketManager
    public boolean useAsyncTicketInterface() {
        boolean z16;
        if (!MqqInjectorManager.instance().isPublicVersion()) {
            z16 = new Random().nextBoolean();
        } else {
            z16 = MqqInjectorManager.instance().getSwitch("103250", false);
        }
        QLog.d(TAG, 1, "useAsyncTicketInterface = " + z16);
        return z16;
    }

    private String getSkey(String str, int i3, boolean z16) {
        int i16;
        boolean banSkeyAccess = SigInjectManager.instance().banSkeyAccess();
        try {
            if (!TextUtils.isEmpty(str)) {
                Ticket GetLocalTicket = this.mWtLoginHelper.GetLocalTicket(str, i3, 4096);
                if (GetLocalTicket != null) {
                    byte[] bArr = GetLocalTicket._sig;
                    if (bArr != null) {
                        reportGetTicketResult(true, NowProxyConstants.AccountInfoKey.SKEY, str, 0);
                        if (banSkeyAccess && !z16) {
                            return SigInjectManager.instance().getFakeSkey(new String(bArr));
                        }
                        return new String(bArr);
                    }
                    QLog.d(TAG, 1, "get ticket failed, SKEY, sig is null");
                    i16 = -3;
                } else {
                    QLog.d(TAG, 1, "get ticket failed, SKEY, ticket is null");
                    i16 = -2;
                }
            } else {
                QLog.d(TAG, 1, "get ticket failed, SKEY, uin is empty!");
                i16 = -1;
            }
        } catch (Exception e16) {
            QLog.d(TAG, 1, "get ticket failed, SKEY, exception: " + e16.toString());
            i16 = -4;
        }
        if (this.mApp != null && !TextUtils.isEmpty(str) && str.equals(this.mApp.getAccount()) && !TextUtils.isEmpty(this.mAlterTicketsMap.get("skey"))) {
            reportGetTicketResult(true, NowProxyConstants.AccountInfoKey.SKEY, str, i16);
            String str2 = this.mAlterTicketsMap.get("skey");
            return (!banSkeyAccess || z16) ? str2 : SigInjectManager.instance().getFakeSkey(str2);
        }
        reportGetTicketResult(false, NowProxyConstants.AccountInfoKey.SKEY, str, i16);
        return null;
    }

    @Override // mqq.manager.TicketManager
    public String getA2(String str) {
        if (useNewWt()) {
            QLog.d(TAG, 2, "getA2 use new wt");
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final String[] strArr = {""};
            SigInjectManager.instance().getLoginSig(Long.parseLong(str), 16L, new ILoginMainTicketCallback() { // from class: mqq.app.TicketManagerImpl.4
                @Override // mqq.inject.ILoginMainTicketCallback
                public void onResult(int i3, String str2, LoginTicketResult loginTicketResult) {
                    QLog.d(TicketManagerImpl.TAG, 1, "onResult() called with: result = [" + i3 + "], errMsg = [" + str2 + "], loginTicketResult = [" + loginTicketResult + "]");
                    strArr[0] = HexUtil.bytes2HexStr(loginTicketResult.f417209a2);
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await(500L, TimeUnit.MILLISECONDS);
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
            return strArr[0];
        }
        return getA2Impl(str, 16, 64, NowProxyConstants.AccountInfoKey.A2);
    }

    @Override // mqq.manager.TicketManager
    public Ticket getPskey(String str, long j3, String[] strArr, WtTicketPromise wtTicketPromise) {
        try {
            reportChangeTokenSrc(str, "getPskey");
            reportGetPskeyToPskeyManager(strArr);
            return this.mWtLoginHelper.GetPskey(str, j3, strArr, wtTicketPromise);
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "cannot getpskey from helper ", th5);
            return null;
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }

    private void reportGetTicketResult(boolean z16, String str, String str2, int i3) {
    }
}

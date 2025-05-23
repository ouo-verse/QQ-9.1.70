package com.tencent.mobileqq.subaccount.api.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.h;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.api.IContactUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.AppRuntime;
import mqq.manager.ServerConfigManager;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SubAccountControlServiceImpl implements ISubAccountControlService {
    static IPatchRedirector $redirector_;
    public static String DateFormate;
    public static long sTroopDelayTime;
    AppInterface app;
    ArrayList<com.tencent.mobileqq.subaccount.d> associatedQQPairCache;
    Lock cacheLock;
    boolean isHeadIconLongClick;
    boolean isThirdQQDisplay;
    public boolean isThirdUnreadReqSkip;
    public long lastSpecialCareRequestTime;
    private ArrayList<QQCustomDialog> listDialog;
    ArrayList<Pair<String, Integer>> listWaittingHint;
    Lock lock;
    private Handler mCommonThreadHandler;
    Runnable mFetchSubAccountMsgRunnable;
    Runnable mFetchSubAccountTroopMsgRunnable;
    private long msgDelayTime;
    public long specialCareReqAdviseGap;
    private long thirdQQUnreadDelayTime;
    Runnable thirdQQUnreadRunable;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f291081d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f291082e;

        a(String str, int i3) {
            this.f291081d = str;
            this.f291082e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SubAccountControlServiceImpl.this, str, Integer.valueOf(i3));
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                SubAccountControlServiceImpl.this.cancelHintDialog(this.f291081d, this.f291082e, true);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26061);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 38)) {
            redirector.redirect((short) 38);
        } else {
            sTroopDelayTime = 600L;
            DateFormate = TuxDateStringUtils.TUX_COMMON_DATE_FORMAT;
        }
    }

    public SubAccountControlServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.lock = new ReentrantLock();
        this.msgDelayTime = 300L;
        this.thirdQQUnreadDelayTime = 300L;
        this.isThirdQQDisplay = true;
        this.isHeadIconLongClick = true;
        this.isThirdUnreadReqSkip = false;
        this.specialCareReqAdviseGap = 600L;
        this.lastSpecialCareRequestTime = 0L;
        this.associatedQQPairCache = new ArrayList<>();
        this.cacheLock = new ReentrantLock();
        this.mCommonThreadHandler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
        this.mFetchSubAccountMsgRunnable = new Runnable() { // from class: com.tencent.mobileqq.subaccount.api.impl.SubAccountControlServiceImpl.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SubAccountControlServiceImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Object valueOf;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("launchTimedMsgTask() run. startAllSubMessageAccountMsg(false) app.isRunning=");
                    AppInterface appInterface = SubAccountControlServiceImpl.this.app;
                    if (appInterface == null) {
                        valueOf = "null";
                    } else {
                        valueOf = Boolean.valueOf(appInterface.isRunning());
                    }
                    sb5.append(valueOf);
                    QLog.d("SUB_ACCOUNT", 2, sb5.toString());
                }
                AppInterface appInterface2 = SubAccountControlServiceImpl.this.app;
                if (appInterface2 != null && appInterface2.isRunning()) {
                    ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).startAllSubMessageAccountMsg(false, 1);
                }
            }
        };
        this.mFetchSubAccountTroopMsgRunnable = new Runnable() { // from class: com.tencent.mobileqq.subaccount.api.impl.SubAccountControlServiceImpl.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SubAccountControlServiceImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Object valueOf;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("launchTroopTimedMsgTask() run. startAllSubMessageAccountMsg(false) app.isRunning=");
                    AppInterface appInterface = SubAccountControlServiceImpl.this.app;
                    if (appInterface == null) {
                        valueOf = "null";
                    } else {
                        valueOf = Boolean.valueOf(appInterface.isRunning());
                    }
                    sb5.append(valueOf);
                    QLog.d("SUB_ACCOUNT", 2, sb5.toString());
                }
                AppInterface appInterface2 = SubAccountControlServiceImpl.this.app;
                if (appInterface2 != null && appInterface2.isRunning()) {
                    ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).startAllSubMessageAccountMsg(false, 2);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0() {
        String serverConfigValue = ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getServerConfigValue(ServerConfigManager.ConfigType.common, "subaccountMsgFreq");
        if (serverConfigValue != null && !TextUtils.isEmpty(serverConfigValue)) {
            this.msgDelayTime = Long.parseLong(serverConfigValue);
            if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "init msgDelayTime = " + this.msgDelayTime);
            }
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public Pair<String, Integer> addHintPair(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Pair) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "addHintPair() subUin=" + str + " type=" + i3);
        }
        if (str != null && str.length() >= 5) {
            if (i3 == 0 || i3 == 1) {
                Pair<String, Integer> pair = new Pair<>(str, Integer.valueOf(i3));
                this.lock.lock();
                try {
                    ArrayList<Pair<String, Integer>> arrayList = this.listWaittingHint;
                    if (arrayList != null) {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            Pair<String, Integer> pair2 = this.listWaittingHint.get(size);
                            if (str.equals(pair2.first)) {
                                this.listWaittingHint.remove(size);
                                if (QLog.isColorLevel()) {
                                    QLog.d("SUB_ACCOUNT", 2, "addHintPair() remove old, subUin=" + pair2.first + " type=" + pair2.second);
                                }
                            }
                        }
                    }
                    if (this.listWaittingHint == null) {
                        this.listWaittingHint = new ArrayList<>();
                    }
                    this.listWaittingHint.add(pair);
                    return pair;
                } finally {
                    this.lock.unlock();
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public void bindRecentItem(AppInterface appInterface, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, appInterface, str, Integer.valueOf(i3));
        } else {
            h.b(appInterface, str, i3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x009a, code lost:
    
        if (r10.equals(r7.first) != false) goto L35;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void cancelHintDialog(String str, int i3, boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "cancelUnbindDialog() subUin=" + str + " type=" + i3);
        }
        if (str != null && str.length() >= 5) {
            this.lock.lock();
            try {
                ArrayList<QQCustomDialog> arrayList = this.listDialog;
                if (arrayList != null) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        QQCustomDialog qQCustomDialog = this.listDialog.get(size);
                        if (qQCustomDialog != null) {
                            Object tag = qQCustomDialog.getTag();
                            if (tag != null && (tag instanceof Pair)) {
                                Pair pair = (Pair) tag;
                                if (z16) {
                                    if (str.equals(pair.first) && i3 == ((Integer) pair.second).intValue()) {
                                        z17 = true;
                                    }
                                    z17 = false;
                                }
                                if (z17) {
                                    if (qQCustomDialog.isShowing()) {
                                        try {
                                            qQCustomDialog.dismiss();
                                        } catch (Exception unused) {
                                        }
                                    }
                                    this.listDialog.remove(size);
                                    if (QLog.isColorLevel()) {
                                        QLog.d("SUB_ACCOUNT", 2, "cancelUnbindDialog() fit. subUin=" + ((String) pair.first) + " type=" + pair.second + " strict=" + z16);
                                    }
                                }
                            } else {
                                this.listDialog.remove(size);
                            }
                        } else {
                            this.listDialog.remove(size);
                        }
                    }
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public void cancelTimedMsgTask(AppInterface appInterface, int i3) {
        Object valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) appInterface, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("cancelTimedMsgTask() app.isRunning=");
            if (appInterface == null) {
                valueOf = "null";
            } else {
                valueOf = Boolean.valueOf(appInterface.isRunning());
            }
            sb5.append(valueOf);
            sb5.append(" fetchMsgType=");
            sb5.append(i3);
            QLog.d("SUB_ACCOUNT", 2, sb5.toString());
        }
        if (appInterface != null && appInterface.isRunning()) {
            if (i3 != 2) {
                this.mCommonThreadHandler.removeCallbacks(this.mFetchSubAccountMsgRunnable);
            }
            if (i3 != 1) {
                this.mCommonThreadHandler.removeCallbacks(this.mFetchSubAccountTroopMsgRunnable);
            }
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public void clearAllData(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) appInterface, (Object) str);
        } else {
            h.j(appInterface, str);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public String dealSysMsgContent(AppInterface appInterface, String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, this, appInterface, str, Integer.valueOf(i3), str2);
        }
        return h.k(appInterface, str, i3, str2);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public void destoryHintDialog(Activity activity) {
        ArrayList<QQCustomDialog> arrayList;
        String simpleName;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) activity);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("cancelUnbindDialog() act=");
            if (activity == null) {
                simpleName = "null";
            } else {
                simpleName = activity.getClass().getSimpleName();
            }
            sb5.append(simpleName);
            QLog.d("SUB_ACCOUNT", 2, sb5.toString());
        }
        if (activity != null && (arrayList = this.listDialog) != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                QQCustomDialog qQCustomDialog = this.listDialog.get(size);
                if (qQCustomDialog != null && qQCustomDialog.getOwnerActivity() == activity) {
                    if (qQCustomDialog.isShowing()) {
                        try {
                            qQCustomDialog.dismiss();
                        } catch (Exception unused) {
                        }
                    }
                    this.listDialog.remove(size);
                } else {
                    this.listDialog.remove(size);
                }
            }
        }
    }

    com.tencent.mobileqq.subaccount.d findAssociatedQQCacheItemByKey(String str) {
        com.tencent.mobileqq.subaccount.d dVar;
        ArrayList<com.tencent.mobileqq.subaccount.d> arrayList = this.associatedQQPairCache;
        if (arrayList != null) {
            try {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (i3 < this.associatedQQPairCache.size()) {
                        dVar = this.associatedQQPairCache.get(i3);
                    } else {
                        dVar = null;
                    }
                    if (dVar != null && TextUtils.equals(dVar.f291104a, str)) {
                        return dVar;
                    }
                }
            } catch (Exception e16) {
                QLog.i("SUB_ACCOUNT", 1, " findAssociatedQQCacheItemByKey error: " + e16.getMessage());
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public int getAssociatedQQCacheInt(String str) {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this, (Object) str)).intValue();
        }
        if (TextUtils.isEmpty(str) || (appInterface = this.app) == null || appInterface.getApp() == null) {
            return 0;
        }
        this.cacheLock.lock();
        try {
            com.tencent.mobileqq.subaccount.d findAssociatedQQCacheItemByKey = findAssociatedQQCacheItemByKey(str);
            if (findAssociatedQQCacheItemByKey != null) {
                return ((Integer) findAssociatedQQCacheItemByKey.f291105b).intValue();
            }
            SharedPreferences p16 = h.p(this.app);
            if (p16 == null) {
                return 0;
            }
            int i3 = p16.getInt(str, 0);
            ArrayList<com.tencent.mobileqq.subaccount.d> arrayList = this.associatedQQPairCache;
            if (arrayList != null) {
                arrayList.add(new com.tencent.mobileqq.subaccount.d(str, Integer.valueOf(i3)));
            }
            return i3;
        } finally {
            this.cacheLock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public String getAssociatedQQCacheString(String str) {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (String) iPatchRedirector.redirect((short) 37, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str) || (appInterface = this.app) == null || appInterface.getApp() == null) {
            return "";
        }
        this.cacheLock.lock();
        try {
            com.tencent.mobileqq.subaccount.d findAssociatedQQCacheItemByKey = findAssociatedQQCacheItemByKey(str);
            if (findAssociatedQQCacheItemByKey != null) {
                return (String) findAssociatedQQCacheItemByKey.f291105b;
            }
            SharedPreferences p16 = h.p(this.app);
            if (p16 == null) {
                return "";
            }
            String string = p16.getString(str, "");
            ArrayList<com.tencent.mobileqq.subaccount.d> arrayList = this.associatedQQPairCache;
            if (arrayList != null) {
                arrayList.add(new com.tencent.mobileqq.subaccount.d(str, string));
            }
            return string;
        } finally {
            this.cacheLock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public String getDateFormate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return DateFormate;
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public boolean getIsThirdUnreadReqSkip() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isThirdUnreadReqSkip;
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public long getLastSpecialCareRequestTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.lastSpecialCareRequestTime;
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public int getReqSubAccountSpecialCareListSysTime(AppInterface appInterface, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, this, appInterface, str, str2)).intValue();
        }
        return h.t(appInterface, str, str2);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public long getSpecialCareReqAdviseGap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return this.specialCareReqAdviseGap;
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public void getSubAccountSpecialCareList(ArrayList<String> arrayList, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) arrayList, (Object) str);
            return;
        }
        String str2 = this.app.getCurrentUin() + "_" + str + "_spcares";
        this.cacheLock.lock();
        try {
            com.tencent.mobileqq.subaccount.d findAssociatedQQCacheItemByKey = findAssociatedQQCacheItemByKey(str2);
            if (findAssociatedQQCacheItemByKey != null) {
                arrayList.addAll((ArrayList) findAssociatedQQCacheItemByKey.f291105b);
            } else {
                String[] split = h.p(this.app).getString(str2, "").split(";");
                if (split != null) {
                    for (int i3 = 0; i3 < split.length; i3++) {
                        if (!TextUtils.isEmpty(split[i3]) && !TextUtils.equals("0", split[i3])) {
                            arrayList.add(split[i3]);
                        }
                    }
                }
                this.associatedQQPairCache.add(new com.tencent.mobileqq.subaccount.d(str2, arrayList));
            }
        } finally {
            this.cacheLock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public byte[] getThirdQQUnreadNumReqCookie(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (byte[]) iPatchRedirector.redirect((short) 15, (Object) this, (Object) appInterface, (Object) str);
        }
        return h.x(appInterface, str);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public long getsTroopDelayTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Long) iPatchRedirector.redirect((short) 1, (Object) this)).longValue();
        }
        return sTroopDelayTime;
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public boolean handleListWaittingHint(String str) {
        ArrayList<String> arrayList;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, (Object) str)).booleanValue();
        }
        ISubAccountService iSubAccountService = (ISubAccountService) this.app.getRuntimeService(ISubAccountService.class, "");
        if (iSubAccountService != null) {
            arrayList = iSubAccountService.getAllSubUin();
        } else {
            arrayList = null;
        }
        this.lock.lock();
        try {
            ArrayList<Pair<String, Integer>> arrayList2 = this.listWaittingHint;
            if (arrayList2 != null && arrayList2.size() > 0) {
                z16 = true;
                if (arrayList != null && arrayList.size() > 0) {
                    for (int size = this.listWaittingHint.size() - 1; size >= 0; size--) {
                        Pair<String, Integer> pair = this.listWaittingHint.get(size);
                        if (arrayList.contains(pair.first)) {
                            if (pair.second.intValue() == 1) {
                                this.listWaittingHint.remove(size);
                            }
                        } else if (pair.second.intValue() == 0) {
                            this.listWaittingHint.remove(size);
                        }
                    }
                }
                ArrayList<Pair<String, Integer>> arrayList3 = this.listWaittingHint;
                if (arrayList3 != null && arrayList3.size() > 0) {
                    if (!ISubAccountControlService.UIN_ALL.equals(str)) {
                        Iterator<Pair<String, Integer>> it = this.listWaittingHint.iterator();
                        while (it.hasNext()) {
                            if (str.equals(it.next().first)) {
                                break;
                            }
                        }
                    }
                    return z16;
                }
            }
            z16 = false;
            return z16;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public boolean isHeadIconLongClickFunc(boolean z16) {
        String[] split;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this, z16)).booleanValue();
        }
        if (z16) {
            String featureValueWithoutAccountManager = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.aio_config.name());
            if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "aioConfig:" + featureValueWithoutAccountManager);
            }
            if (!TextUtils.isEmpty(featureValueWithoutAccountManager) && (split = featureValueWithoutAccountManager.split("\\|")) != null && split.length > 11 && !TextUtils.isEmpty(split[11])) {
                if (QLog.isColorLevel()) {
                    QLog.d("SUB_ACCOUNT", 2, "subAccountConfig:" + split[11]);
                }
                String[] split2 = split[11].split("_");
                if (split2 != null && split2.length > 0 && TextUtils.equals("1", split2[0])) {
                    this.isHeadIconLongClick = true;
                } else {
                    this.isHeadIconLongClick = false;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "isHeadIconLongClickFunc isHeadIconLongClick=" + this.isHeadIconLongClick);
        }
        return this.isHeadIconLongClick;
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public void launchTimedMsgTask(AppInterface appInterface, int i3) {
        Object valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) appInterface, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("launchTimedMsgTask() app.isRunning=");
            if (appInterface == null) {
                valueOf = "null";
            } else {
                valueOf = Boolean.valueOf(appInterface.isRunning());
            }
            sb5.append(valueOf);
            sb5.append(" fetchMsgType=");
            sb5.append(i3);
            QLog.d("SUB_ACCOUNT", 2, sb5.toString());
        }
        if (appInterface != null && appInterface.isRunning()) {
            cancelTimedMsgTask(appInterface, i3);
            if (i3 != 2) {
                this.mCommonThreadHandler.postDelayed(this.mFetchSubAccountMsgRunnable, this.msgDelayTime * 1000);
            }
            if (i3 != 1) {
                this.mCommonThreadHandler.postDelayed(this.mFetchSubAccountTroopMsgRunnable, sTroopDelayTime * 1000);
            }
            if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "launchTimedMsgTask() schedule msgTimer after " + this.msgDelayTime + "*1000 ms.");
            }
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public void launchTimedThirdQQUnreadNumTask(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) appInterface);
            return;
        }
        if (appInterface != null && appInterface.isRunning()) {
            Runnable runnable = this.thirdQQUnreadRunable;
            if (runnable != null) {
                this.mCommonThreadHandler.removeCallbacks(runnable);
            }
            if (this.thirdQQUnreadRunable == null) {
                this.thirdQQUnreadRunable = new Runnable(appInterface) { // from class: com.tencent.mobileqq.subaccount.api.impl.SubAccountControlServiceImpl.4
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ AppInterface f291080d;

                    {
                        this.f291080d = appInterface;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SubAccountControlServiceImpl.this, (Object) appInterface);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            h.P(this.f291080d, true);
                        }
                    }
                };
            }
            this.mCommonThreadHandler.postDelayed(this.thirdQQUnreadRunable, this.thirdQQUnreadDelayTime * 1000);
            if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "launchTimedThirdQQUnreadNumTask() next req after " + this.thirdQQUnreadDelayTime + "s.");
            }
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) appRuntime);
            return;
        }
        this.app = (AppInterface) appRuntime;
        this.associatedQQPairCache.clear();
        try {
            String stringSystem = DeviceInfoMonitor.getStringSystem(BaseApplication.getContext().getContentResolver(), "date_format");
            if (!TextUtils.isEmpty(stringSystem)) {
                DateFormate = stringSystem;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        try {
            this.mCommonThreadHandler.post(new Runnable() { // from class: com.tencent.mobileqq.subaccount.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    SubAccountControlServiceImpl.this.lambda$onCreate$0();
                }
            });
            int associatedQQCacheInt = getAssociatedQQCacheInt(this.app.getCurrentUin() + "_unread_msg_num_interval");
            if (associatedQQCacheInt != 0) {
                updateThirdQQUnreadDelayTime(associatedQQCacheInt);
            }
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        this.lock.lock();
        try {
            ArrayList<QQCustomDialog> arrayList = this.listDialog;
            if (arrayList != null) {
                Iterator<QQCustomDialog> it = arrayList.iterator();
                while (it.hasNext()) {
                    QQCustomDialog next = it.next();
                    try {
                        if (next.isShowing()) {
                            next.dismiss();
                        }
                    } catch (Exception unused) {
                    }
                }
                this.listDialog.clear();
            }
            this.listDialog = null;
            ArrayList<Pair<String, Integer>> arrayList2 = this.listWaittingHint;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            this.listWaittingHint = null;
            this.lock.unlock();
            this.mCommonThreadHandler.removeCallbacks(this.mFetchSubAccountMsgRunnable);
            this.mCommonThreadHandler.removeCallbacks(this.mFetchSubAccountTroopMsgRunnable);
            Runnable runnable = this.thirdQQUnreadRunable;
            if (runnable != null) {
                this.mCommonThreadHandler.removeCallbacks(runnable);
                this.thirdQQUnreadRunable = null;
            }
            ArrayList<com.tencent.mobileqq.subaccount.d> arrayList3 = this.associatedQQPairCache;
            if (arrayList3 != null) {
                arrayList3.clear();
            }
        } catch (Throwable th5) {
            this.lock.unlock();
            throw th5;
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public ArrayList<Pair<String, Integer>> popWaittingHintPair(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (ArrayList) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        }
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "popWaittingHintPair() subUin=" + str);
        }
        ArrayList<Pair<String, Integer>> arrayList = new ArrayList<>();
        if (str == null) {
            return arrayList;
        }
        this.lock.lock();
        try {
            if (this.listWaittingHint != null) {
                if (ISubAccountControlService.UIN_ALL.equals(str)) {
                    arrayList.addAll(this.listWaittingHint);
                    this.listWaittingHint.clear();
                } else {
                    for (int size = this.listWaittingHint.size() - 1; size >= 0; size--) {
                        Pair<String, Integer> pair = this.listWaittingHint.get(size);
                        if (str.equals(pair.first)) {
                            arrayList.add(pair);
                            this.listWaittingHint.remove(size);
                        }
                    }
                }
            }
            return arrayList;
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x007c, code lost:
    
        if (((java.lang.Integer) r3) != ((java.lang.Integer) r7)) goto L30;
     */
    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean putAssociatedQQCache(String str, Object obj) {
        AppInterface appInterface;
        SharedPreferences p16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) str, obj)).booleanValue();
        }
        boolean z16 = false;
        if (TextUtils.isEmpty(str) || (appInterface = this.app) == null || appInterface.getApp() == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "putAssociatedQQCache key=" + str + " value=" + obj);
        }
        this.cacheLock.lock();
        try {
            boolean z17 = true;
            if (this.associatedQQPairCache != null) {
                com.tencent.mobileqq.subaccount.d findAssociatedQQCacheItemByKey = findAssociatedQQCacheItemByKey(str);
                if (findAssociatedQQCacheItemByKey == null) {
                    this.associatedQQPairCache.add(new com.tencent.mobileqq.subaccount.d(str, obj));
                } else {
                    if (obj instanceof Integer) {
                        Object obj2 = findAssociatedQQCacheItemByKey.f291105b;
                        if (obj2 instanceof Integer) {
                        }
                    }
                    if (obj instanceof String) {
                        Object obj3 = findAssociatedQQCacheItemByKey.f291105b;
                        if ((obj3 instanceof String) && !TextUtils.equals((String) obj3, (String) obj)) {
                            z16 = true;
                        }
                    }
                    if (z16) {
                        findAssociatedQQCacheItemByKey.f291105b = obj;
                    }
                    z17 = z16;
                }
            }
            if (z17 && (p16 = h.p(this.app)) != null) {
                if (obj instanceof Integer) {
                    p16.edit().putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof String) {
                    p16.edit().putString(str, (String) obj);
                }
            }
            return z17;
        } finally {
            this.cacheLock.unlock();
        }
    }

    boolean requestThirdQQUnreadMsgNum(AppInterface appInterface, boolean z16) {
        if (appInterface == null || !appInterface.isRunning()) {
            return false;
        }
        ArrayList<SimpleAccount> arrayList = new ArrayList();
        List<SimpleAccount> allAccounts = appInterface.getApplication().getAllAccounts();
        if (allAccounts != null && allAccounts.size() > 0) {
            arrayList.addAll(allAccounts);
        }
        ISubAccountService iSubAccountService = (ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "");
        if (arrayList.size() < 1 || iSubAccountService == null) {
            return false;
        }
        ArrayList<SimpleAccount> arrayList2 = new ArrayList<>();
        String currentUin = appInterface.getCurrentUin();
        ArrayList<String> allSubUin = iSubAccountService.getAllSubUin();
        for (SimpleAccount simpleAccount : arrayList) {
            if (simpleAccount != null && !TextUtils.isEmpty(simpleAccount.getUin()) && !simpleAccount.getUin().equals(currentUin) && !allSubUin.contains(simpleAccount.getUin()) && simpleAccount.isLogined()) {
                arrayList2.add(simpleAccount);
            }
        }
        if (arrayList2.size() <= 0) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "requestThirdQQUnreadMsgNum() really start get other qq unread message mainUin=" + currentUin + " isCronJob=" + z16);
        }
        com.tencent.mobileqq.app.message.a processor = ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getProcessor(appInterface);
        if (processor != null) {
            processor.b1(z16, arrayList2);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public void setBindUinStatus(AppInterface appInterface, byte b16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, appInterface, Byte.valueOf(b16), str);
        } else {
            h.J(appInterface, b16, str);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public void setDateFormate(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            DateFormate = str;
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public void setIsThirdUnreadReqSkip(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.isThirdUnreadReqSkip = z16;
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public void setLastSpecialCareRequestTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.lastSpecialCareRequestTime = j3;
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public void setTroopDelayTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, j3);
        } else {
            sTroopDelayTime = j3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public void showHintDialog(AppInterface appInterface, QBaseActivity qBaseActivity, Pair<String, Integer> pair, DialogInterface.OnClickListener onClickListener) {
        String string;
        String str;
        String simpleName;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, appInterface, qBaseActivity, pair, onClickListener);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("showUnbindDialog() pair=");
            String str3 = "null";
            if (pair == null) {
                str = "null";
            } else {
                str = pair.first + "," + pair.second;
            }
            sb5.append(str);
            sb5.append(" activity=");
            if (qBaseActivity == null) {
                simpleName = "null";
            } else {
                simpleName = qBaseActivity.getClass().getSimpleName();
            }
            sb5.append(simpleName);
            sb5.append(" app:");
            if (appInterface == null) {
                str2 = "null";
            } else {
                str2 = "no null";
            }
            sb5.append(str2);
            sb5.append(" dlgLis:");
            if (onClickListener != null) {
                str3 = "no null";
            }
            sb5.append(str3);
            QLog.d("SUB_ACCOUNT", 2, sb5.toString());
        }
        if (appInterface != null && qBaseActivity != null && pair != null && onClickListener != null) {
            String str4 = pair.first;
            int intValue = pair.second.intValue();
            this.lock.lock();
            try {
                ArrayList<QQCustomDialog> arrayList = this.listDialog;
                if (arrayList != null) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        QQCustomDialog qQCustomDialog = this.listDialog.get(size);
                        if (qQCustomDialog != null && (qQCustomDialog.getTag() instanceof Pair)) {
                            Pair pair2 = (Pair) qQCustomDialog.getTag();
                            if (str4.equals(pair2.first)) {
                                if (qQCustomDialog.isShowing()) {
                                    try {
                                        qQCustomDialog.dismiss();
                                    } catch (Exception unused) {
                                    }
                                }
                                this.listDialog.remove(size);
                                if (QLog.isColorLevel()) {
                                    QLog.d("SUB_ACCOUNT", 2, "showUnbindDialog() there is already a Dialog, dismiss and remove. subUin=" + ((String) pair2.first));
                                }
                            }
                        }
                    }
                }
                String string2 = qBaseActivity.getString(R.string.f173180ht0);
                String buddyNickName = ((IContactUtils) QRoute.api(IContactUtils.class)).getBuddyNickName(appInterface, str4, false);
                if (buddyNickName == null || buddyNickName.length() == 0) {
                    buddyNickName = str4;
                }
                if (intValue == 0) {
                    string = qBaseActivity.getString(R.string.f173181ht1, buddyNickName);
                } else {
                    string = qBaseActivity.getString(R.string.f173182ht2, buddyNickName);
                }
                QQCustomDialog message = DialogUtil.createCustomDialog(qBaseActivity, 230).setTitle(string2).setMessage(string);
                message.setTag(pair);
                message.setOwnerActivity(qBaseActivity);
                message.setPositiveButton(qBaseActivity.getString(R.string.hsi), onClickListener);
                message.setOnCancelListener(new a(str4, intValue));
                message.show();
                if (this.listDialog == null) {
                    this.listDialog = new ArrayList<>();
                }
                this.listDialog.add(message);
            } finally {
                this.lock.unlock();
            }
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public boolean startGetThirdQQUnreadNum(boolean z16) {
        Runnable runnable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this, z16)).booleanValue();
        }
        boolean z17 = false;
        if (!this.isThirdQQDisplay) {
            return false;
        }
        if (QBaseActivity.mAppForground) {
            z17 = requestThirdQQUnreadMsgNum(this.app, z16);
            if (z17) {
                launchTimedThirdQQUnreadNumTask(this.app);
            }
        } else {
            this.isThirdUnreadReqSkip = true;
        }
        if (!z17 && (runnable = this.thirdQQUnreadRunable) != null) {
            this.mCommonThreadHandler.removeCallbacks(runnable);
        }
        return z17;
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public void storeSubAccountSpecialCareList(String str, String str2, ArrayList<String> arrayList, int i3, int i16) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, str, str2, arrayList, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        String str3 = str + "_" + str2 + "_spcares";
        this.cacheLock.lock();
        try {
            com.tencent.mobileqq.subaccount.d findAssociatedQQCacheItemByKey = findAssociatedQQCacheItemByKey(str3);
            if (findAssociatedQQCacheItemByKey != null && (obj = findAssociatedQQCacheItemByKey.f291105b) != null && (obj instanceof ArrayList)) {
                ArrayList arrayList2 = (ArrayList) obj;
                arrayList2.clear();
                arrayList2.addAll(arrayList);
            } else {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(arrayList);
                if (findAssociatedQQCacheItemByKey != null) {
                    findAssociatedQQCacheItemByKey.f291105b = arrayList3;
                } else {
                    this.associatedQQPairCache.add(new com.tencent.mobileqq.subaccount.d(str3, arrayList3));
                }
            }
            this.cacheLock.unlock();
            StringBuilder sb5 = new StringBuilder();
            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                if (i17 > 0) {
                    sb5.append(";");
                }
                sb5.append(arrayList.get(i17));
            }
            h.p(this.app).edit().putString(str3, sb5.toString()).commit();
            putAssociatedQQCache(str3 + "_sysTime", Integer.valueOf(i3));
            this.specialCareReqAdviseGap = (long) i16;
        } catch (Throwable th5) {
            this.cacheLock.unlock();
            throw th5;
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public void storeThirdQQUnreadInfo(String str, String str2, byte[] bArr, int i3, int i16, int i17, int i18, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, str, str2, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
            return;
        }
        String str3 = this.app.getCurrentUin() + "_" + str2;
        String hexStr = PkgTools.toHexStr(bArr);
        if (!TextUtils.isEmpty(hexStr)) {
            putAssociatedQQCache(str3 + "_last_cookie", hexStr);
        }
        putAssociatedQQCache(str3 + "_msgNum", Integer.valueOf(i3));
        putAssociatedQQCache(str3 + "_msgFlag", Integer.valueOf(i16));
        putAssociatedQQCache(str3 + "_redBagTime", Integer.valueOf(i17));
        putAssociatedQQCache(str3 + "_status", Integer.valueOf(i18));
        if (i19 != 0) {
            putAssociatedQQCache(str3 + "_lastMsgTime", Integer.valueOf(i19));
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public void storeThirdQQUnreadMsgNumInterval(AppInterface appInterface, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, appInterface, str, Integer.valueOf(i3));
        } else {
            h.Q(appInterface, str, i3);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControlService
    public void updateThirdQQUnreadDelayTime(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3);
            return;
        }
        long j3 = i3;
        if (j3 > 86400) {
            this.thirdQQUnreadDelayTime = 86400L;
        } else if (j3 < 60) {
            this.thirdQQUnreadDelayTime = 60L;
        } else {
            this.thirdQQUnreadDelayTime = j3;
        }
    }
}

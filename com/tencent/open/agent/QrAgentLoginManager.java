package com.tencent.open.agent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.qrcode.activity.QRLoginAuthActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.login.api.qrlogin.IQrLoginApi;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.QrAgentLoginManager;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqnt.kernel.nativeinterface.ScanQrRspInfo;
import com.tencent.qqnt.kernel.nativeinterface.ScanScene;
import com.tencent.qqnt.kernel.nativeinterface.SecCheckResult;
import com.tencent.qqnt.kernel.nativeinterface.SwitchOperation;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONException;
import org.json.JSONObject;
import wtlogin.qrlogin.scanresult.QrLogin$ScanResultInfo;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QrAgentLoginManager {

    /* renamed from: m, reason: collision with root package name */
    private static volatile QrAgentLoginManager f339968m;

    /* renamed from: a, reason: collision with root package name */
    private byte[] f339970a;

    /* renamed from: b, reason: collision with root package name */
    private long f339971b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<com.tencent.mobileqq.qrscan.k> f339972c;

    /* renamed from: d, reason: collision with root package name */
    private String f339973d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f339974e;

    /* renamed from: f, reason: collision with root package name */
    private String f339975f;

    /* renamed from: g, reason: collision with root package name */
    private int f339976g;

    /* renamed from: h, reason: collision with root package name */
    private int f339977h = 0;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.mobileqq.loginregister.servlet.a f339978i = null;

    /* renamed from: j, reason: collision with root package name */
    private final f72.a f339979j = new AnonymousClass2();

    /* renamed from: k, reason: collision with root package name */
    private final com.tencent.mobileqq.loginregister.servlet.h f339980k = new com.tencent.mobileqq.loginregister.servlet.h() { // from class: com.tencent.open.agent.QrAgentLoginManager.3
        private int G(byte[] bArr, int i3, int i16) {
            QrLogin$ScanResultInfo qrLogin$ScanResultInfo = new QrLogin$ScanResultInfo();
            int i17 = 0;
            try {
                byte[] bArr2 = new byte[i16];
                System.arraycopy(bArr, i3, bArr2, 0, i16);
                qrLogin$ScanResultInfo.mergeFrom(bArr2);
            } catch (Throwable th5) {
                QLog.e("QrAgentLoginManager", 1, th5, new Object[0]);
            }
            if (qrLogin$ScanResultInfo.scan_result.has()) {
                i17 = qrLogin$ScanResultInfo.scan_result.get();
            }
            QLog.d("QrAgentLoginManager", 1, "getScanResult, scanResult = " + i17);
            return i17;
        }

        private void H() {
            String s16 = QrAgentLoginManager.this.s();
            AppRuntime appRuntime = null;
            if (!TextUtils.isEmpty(s16)) {
                I(QBaseActivity.sTopActivity, s16);
                QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
                if (qBaseActivity != null) {
                    appRuntime = qBaseActivity.getAppRuntime();
                }
                ReportController.o(appRuntime, "dc00898", "", "", "0X800B5A6", "0X800B5A6", 0, 0, "", "", "", "");
                return;
            }
            QrAgentLoginManager qrAgentLoginManager = QrAgentLoginManager.this;
            qrAgentLoginManager.F(true, qrAgentLoginManager.v(), null);
        }

        private void I(QBaseActivity qBaseActivity, String str) {
            com.tencent.mobileqq.qrscan.k kVar;
            if (qBaseActivity == null) {
                QLog.d("QrAgentLoginManager", 1, "startOpenUrlWebView context is null");
                return;
            }
            if (qBaseActivity.getAppRuntime() != null) {
                QLog.d("QrAgentLoginManager", 1, "startOpenUrlWebView cancelCode");
                QrAgentLoginManager.this.n((QQAppInterface) qBaseActivity.getAppRuntime(), QrAgentLoginManager.this.f339970a);
            }
            QLog.d("QrAgentLoginManager", 1, "startOpenUrlWebView");
            Intent intent = new Intent(qBaseActivity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
            qBaseActivity.startActivity(intent);
            if (QrAgentLoginManager.this.f339972c == null) {
                kVar = null;
            } else {
                kVar = (com.tencent.mobileqq.qrscan.k) QrAgentLoginManager.this.f339972c.get();
            }
            if (kVar != null) {
                kVar.finish();
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void E(String str, byte[] bArr, long j3, ArrayList<String> arrayList, byte[] bArr2, int i3, ErrMsg errMsg) {
            String str2;
            String str3;
            boolean z16;
            int i16;
            int i17;
            Object[] objArr = new Object[6];
            int i18 = 0;
            objArr[0] = "OnVerifyCode userAccount=";
            objArr[1] = MsfSdkUtils.getShortUin(str);
            int i19 = 2;
            objArr[2] = " ret=";
            objArr[3] = Integer.valueOf(i3);
            int i26 = 4;
            objArr[4] = " appName: ";
            String str4 = "";
            if (bArr == null) {
                str2 = "";
            } else {
                str2 = new String(bArr);
            }
            objArr[5] = str2;
            QLog.d("QrAgentLoginManager", 1, objArr);
            if (bArr2 != null) {
                str3 = new String(bArr2);
            } else {
                str3 = null;
            }
            if (i3 != 0) {
                QrAgentLoginManager.this.C(str3);
                return;
            }
            if (arrayList != null && arrayList.size() > 0) {
                long j16 = 0;
                int i27 = 0;
                boolean z17 = false;
                int i28 = 0;
                while (i27 < arrayList.size()) {
                    try {
                        byte[] hexStr2Bytes = HexUtil.hexStr2Bytes(arrayList.get(i27));
                        int buf_to_int16 = util.buf_to_int16(hexStr2Bytes, i18);
                        int buf_to_int162 = util.buf_to_int16(hexStr2Bytes, i19);
                        if (buf_to_int16 == 54) {
                            try {
                                if (QrAgentLoginManager.this.f339974e) {
                                    try {
                                        if (QrAgentLoginManager.this.o()) {
                                            H();
                                            return;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        i16 = i26;
                                        i17 = 2;
                                        QLog.e("QrAgentLoginManager", 1, "OnVerifyCode: failed. ", th);
                                        i27++;
                                        i19 = i17;
                                        i18 = 0;
                                        i26 = i16;
                                    }
                                }
                                try {
                                    byte[] bArr3 = new byte[buf_to_int162];
                                    System.arraycopy(hexStr2Bytes, i26, bArr3, 0, buf_to_int162);
                                    String str5 = new String(bArr3);
                                    if (QLog.isColorLevel()) {
                                        i17 = 2;
                                        try {
                                            QLog.i("QrAgentLoginManager", 2, "OnVerifyCode: invoked.  appidJson: " + str5);
                                        } catch (Throwable th6) {
                                            th = th6;
                                            i16 = 4;
                                            z17 = true;
                                            QLog.e("QrAgentLoginManager", 1, "OnVerifyCode: failed. ", th);
                                            i27++;
                                            i19 = i17;
                                            i18 = 0;
                                            i26 = i16;
                                        }
                                    } else {
                                        i17 = 2;
                                    }
                                    JSONObject jSONObject = new JSONObject(str5);
                                    j16 = jSONObject.optLong("open_appid");
                                    str4 = jSONObject.optString("comefrom");
                                    if ("app".equals(str4)) {
                                        str4 = "android";
                                    }
                                    z17 = true;
                                } catch (Throwable th7) {
                                    th = th7;
                                    i17 = 2;
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                i17 = 2;
                                i16 = 4;
                            }
                        } else {
                            i17 = 2;
                        }
                        if (buf_to_int16 == 208) {
                            i16 = 4;
                            try {
                                i28 = G(hexStr2Bytes, 4, buf_to_int162);
                            } catch (Throwable th9) {
                                th = th9;
                                QLog.e("QrAgentLoginManager", 1, "OnVerifyCode: failed. ", th);
                                i27++;
                                i19 = i17;
                                i18 = 0;
                                i26 = i16;
                            }
                        } else {
                            i16 = 4;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        i16 = i26;
                        i17 = i19;
                    }
                    i27++;
                    i19 = i17;
                    i18 = 0;
                    i26 = i16;
                }
                if (z17 && i28 == 0) {
                    QrAgentLoginManager.this.E(j16, str4);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("KEY_QR_VERIFY_ACCOUNT", str);
                bundle.putByteArray("KEY_QR_VERIFY_APPNAME", bArr);
                bundle.putStringArrayList("KEY_QR_VERIFY_TLV", arrayList);
                bundle.putInt("KEY_QR_VERIFY_RET", i3);
                bundle.putByteArray("KEY_QR_VERIFY_ERROR_MSG", bArr2);
                bundle.putBoolean("KEY_QR_VERIFY_IS_OPEN", z17);
                QrAgentLoginManager qrAgentLoginManager = QrAgentLoginManager.this;
                if (!z17 && qrAgentLoginManager.f339974e && QrAgentLoginManager.this.p()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                qrAgentLoginManager.F(z16, QrAgentLoginManager.this.w(), bundle);
                return;
            }
            QLog.e("QrAgentLoginManager", 1, "onVerifyCode error data is null or empty");
            QrAgentLoginManager.this.C(str3);
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void h(String str, byte[] bArr, long j3, WUserSigInfo wUserSigInfo, byte[] bArr2, int i3, ErrMsg errMsg) {
            String qqStr;
            QLog.d("QrAgentLoginManager", 1, "OnCloseCode userAccount=", MsfSdkUtils.getShortUin(str), " ret=", Integer.valueOf(i3));
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (i3 == 0) {
                if (com.tencent.open.agent.util.g.F(qBaseActivity)) {
                    qBaseActivity.finish();
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.agent.QrAgentLoginManager.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QIPCClientHelper.getInstance().callServer("QR_LOGIN_QIPC_MODULE_NAME", "QIPC_SHOW_TOAST_ACTION", null, null);
                    }
                }, 16, null, true);
                return;
            }
            if (com.tencent.open.agent.util.g.F(qBaseActivity)) {
                if (bArr2 != null) {
                    qqStr = new String(bArr2);
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.rdq);
                }
                Intent intent = new Intent(qBaseActivity, (Class<?>) QRLoginAuthActivity.class);
                intent.putExtra("QR_CODE_STRING", BaseApplication.context.getSharedPreferences("SP_QR_AGENT_LOGIN", 4).getString("KEY_QR_AGENT_LOGIN_CODE" + str, ""));
                intent.putExtra("KEY_ERROR_MSG", qqStr);
                intent.putExtra("KEY_QR_VERIFY_SCAN_SCENE", QrAgentLoginManager.this.f339977h);
                qBaseActivity.startActivity(intent);
                qBaseActivity.finish();
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void j(String str, int i3) {
            QLog.d("QrAgentLoginManager", 1, "WtloginObserver OnException : " + str + " cmd = " + i3);
            QrAgentLoginManager.this.C(str);
        }
    };

    /* renamed from: l, reason: collision with root package name */
    private static final String f339967l = HardCodeUtil.qqStr(R.string.f216585yp);

    /* renamed from: n, reason: collision with root package name */
    public static boolean f339969n = true;

    /* compiled from: P */
    /* renamed from: com.tencent.open.agent.QrAgentLoginManager$2, reason: invalid class name */
    /* loaded from: classes22.dex */
    class AnonymousClass2 implements f72.a {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d() {
            QQToast.makeText(BaseApplication.context, HardCodeUtil.qqStr(R.string.rdp), 1).show();
        }

        @Override // f72.a
        public void a(int i3, @Nullable String str, @Nullable ScanQrRspInfo scanQrRspInfo) {
            boolean z16;
            if (i3 != 0 || scanQrRspInfo == null) {
                QrAgentLoginManager.this.C(str);
                return;
            }
            long openAppid = scanQrRspInfo.getDstOpenAppInfo().getOpenAppid();
            String dstAppName = scanQrRspInfo.getDstAppName();
            boolean z17 = true;
            if (openAppid > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            SecCheckResult secCheckResult = scanQrRspInfo.getSecCheckResult();
            if (z16 && secCheckResult == SecCheckResult.KSAFE) {
                String comeFrom = scanQrRspInfo.getDstOpenAppInfo().getComeFrom();
                if ("app".equals(comeFrom)) {
                    comeFrom = "android";
                }
                QrAgentLoginManager.this.E(openAppid, comeFrom);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("KEY_QR_VERIFY_ACCOUNT", MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin());
            bundle.putString("KEY_QR_VERIFY_DST_APP_NAME", dstAppName);
            bundle.putString("KEY_QR_VERIFY_ERROR_MSG_TIPS", str);
            QrAgentLoginManager qrAgentLoginManager = QrAgentLoginManager.this;
            if (z16 || !qrAgentLoginManager.f339974e || !QrAgentLoginManager.this.p()) {
                z17 = false;
            }
            qrAgentLoginManager.F(z17, QrAgentLoginManager.this.w(), bundle);
        }

        @Override // f72.a
        public void b(int i3, @Nullable String str, @Nullable String str2) {
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (i3 == 0) {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    QQToast.makeText(BaseApplication.context, HardCodeUtil.qqStr(R.string.rdp), 1).show();
                } else {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.agent.k
                        @Override // java.lang.Runnable
                        public final void run() {
                            QrAgentLoginManager.AnonymousClass2.d();
                        }
                    });
                }
                if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("scan_open_auth_finish_activity", false)) {
                    QLog.i("QrAgentLoginManager", 1, "call ACTION_FINISH_OPEN_AUTHORITY.");
                    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:openSdk", "ae_camera_get_info_client", "action_handle_qrlogin_result", null, null);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = HardCodeUtil.qqStr(R.string.rdq);
            }
            final Bundle bundle = new Bundle();
            bundle.putString("QR_CODE_STRING", QrAgentLoginManager.this.f339978i.a());
            bundle.putString("KEY_ERROR_MSG", str);
            bundle.putInt("KEY_QR_VERIFY_SCAN_SCENE", QrAgentLoginManager.this.f339977h);
            if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("scan_open_auth_finish_activity", false)) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.agent.QrAgentLoginManager.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QLog.i("QrAgentLoginManager", 1, "call ACTION_FINISH_OPEN_AUTHORITY.");
                        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:openSdk", "ae_camera_get_info_client", "action_handle_qrlogin_result", bundle, null);
                    }
                }, 16, null, false);
                return;
            }
            Intent intent = new Intent(qBaseActivity, (Class<?>) QRLoginAuthActivity.class);
            intent.putExtras(bundle);
            qBaseActivity.startActivity(intent);
        }
    }

    QrAgentLoginManager() {
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(String str) {
        com.tencent.mobileqq.qrscan.k kVar;
        if (str == null) {
            str = HardCodeUtil.qqStr(R.string.rdq);
        }
        QLog.i("QrAgentLoginManager", 1, "onQRCodeExpired: invoked.  error: " + str);
        WeakReference<com.tencent.mobileqq.qrscan.k> weakReference = this.f339972c;
        if (weakReference == null) {
            kVar = null;
        } else {
            kVar = weakReference.get();
        }
        if (kVar != null) {
            kVar.a(false);
        }
        Intent intent = new Intent();
        intent.putExtra("QR_CODE_STRING", this.f339973d);
        intent.putExtra("KEY_ERROR_MSG", str);
        Context context = QBaseActivity.sTopActivity;
        if (context == null) {
            context = BaseApplication.context;
        }
        intent.putExtra("KEY_QR_VERIFY_SCAN_SCENE", this.f339977h);
        intent.setClass(context, QRLoginAuthActivity.class);
        context.startActivity(intent);
        if (kVar != null) {
            kVar.finish();
        }
    }

    private void B() {
        boolean z16 = true;
        if (MobileQQ.sProcessId != 1) {
            z16 = false;
        }
        if (z16) {
            QIPCServerHelper.getInstance().register(new QIPCModule("QR_LOGIN_QIPC_MODULE_NAME") { // from class: com.tencent.open.agent.QrAgentLoginManager.1
                @Override // eipc.EIPCModule
                public EIPCResult onCall(String str, Bundle bundle, int i3) {
                    if ("QIPC_SHOW_TOAST_ACTION".equals(str)) {
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            QQToast.makeText(BaseApplication.context, HardCodeUtil.qqStr(R.string.rdp), 1).show();
                            return null;
                        }
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.agent.QrAgentLoginManager.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QQToast.makeText(BaseApplication.context, HardCodeUtil.qqStr(R.string.rdp), 1).show();
                            }
                        });
                        return null;
                    }
                    return null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(final String str) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.open.agent.j
            @Override // java.lang.Runnable
            public final void run() {
                QrAgentLoginManager.this.A(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(boolean z16, String str, Bundle bundle) {
        com.tencent.mobileqq.qrscan.k kVar;
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            QLog.e("QrAgentLoginManager", 1, "OnException null== QBaseActivity.sTopActivity");
            return;
        }
        Intent intent = new Intent(qBaseActivity, (Class<?>) QRLoginAuthActivity.class);
        intent.putExtra("QR_CODE_STRING", this.f339973d);
        if (z16) {
            intent.putExtra("KEY_ERROR_MSG", str);
            intent.putExtra("KEY_QR_IS_FORBID_LOCAL_PIC", true);
            intent.putExtra("KEY_QR_FORBID_LOCAL_PIC_FROM", this.f339976g);
            if (qBaseActivity.getAppRuntime() != null) {
                n((QQAppInterface) qBaseActivity.getAppRuntime(), this.f339970a);
            }
        } else {
            intent.putExtra("KEY_QR_VERIFY_CODE_DATA", bundle);
        }
        intent.putExtra("KEY_QR_VERIFY_SCAN_SCENE", this.f339977h);
        qBaseActivity.startActivity(intent);
        WeakReference<com.tencent.mobileqq.qrscan.k> weakReference = this.f339972c;
        if (weakReference == null) {
            kVar = null;
        } else {
            kVar = weakReference.get();
        }
        if (kVar != null) {
            kVar.finish();
        }
    }

    private void G(int i3, ScannerParams scannerParams) {
        int i16;
        int i17 = 0;
        this.f339977h = 0;
        if (i3 != 1) {
            if (i3 != 2) {
                if (scannerParams == null) {
                    QLog.e("QrAgentLoginManager", 1, "updateScanScene scannerParams is null");
                    return;
                }
                int i18 = scannerParams.D;
                if (i18 > 0) {
                    i17 = i18;
                }
                QLog.i("QrAgentLoginManager", 1, "updateScanScene fromType: " + i17);
                if (i17 == 8) {
                    i16 = 1;
                } else {
                    i16 = 6;
                }
                this.f339977h = i16;
            } else {
                this.f339977h = 5;
            }
        } else {
            this.f339977h = 4;
        }
        QLog.i("QrAgentLoginManager", 1, "updateScanScene: " + this.f339977h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(QQAppInterface qQAppInterface, byte[] bArr) {
        if (qQAppInterface == null) {
            QLog.d("QrAgentLoginManager", 1, "cancelCode, but app interface is null");
            return;
        }
        QLog.d("QrAgentLoginManager", 1, "cancelCode scanScene: " + this.f339977h);
        com.tencent.mobileqq.loginregister.servlet.a aVar = this.f339978i;
        if (aVar != null) {
            aVar.g();
        } else {
            ((ILoginServletService) qQAppInterface.getRuntimeService(ILoginServletService.class, "all")).cancelCode(qQAppInterface.getCurrentAccountUin(), 16L, bArr, com.tencent.open.agent.util.q.c(qQAppInterface, this.f339977h, false).toByteArray());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        if (TextUtils.isEmpty(this.f339975f)) {
            QLog.e("QrAgentLoginManager", 1, "configShieldOpenLogin, mLocalQrLoginConfig is null");
            return false;
        }
        try {
            return new JSONObject(this.f339975f).optBoolean("shield_open_login", false);
        } catch (JSONException e16) {
            QLog.e("QrAgentLoginManager", 1, "configShieldOpenLogin JSONException, ", e16);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        if (TextUtils.isEmpty(this.f339975f)) {
            QLog.e("QrAgentLoginManager", 1, "configShieldQQLogin, mLocalQrLoginConfig is null");
            return true;
        }
        try {
            return new JSONObject(this.f339975f).optBoolean("shield_qq_login", true);
        } catch (JSONException e16) {
            QLog.e("QrAgentLoginManager", 1, "configShieldQQLogin JSONException, ", e16);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String s() {
        if (TextUtils.isEmpty(this.f339975f)) {
            QLog.e("QrAgentLoginManager", 1, "getConfigOpenUrl, mLocalQrLoginConfig is null");
            return "";
        }
        try {
            return new JSONObject(this.f339975f).optString("open_url", "");
        } catch (JSONException e16) {
            QLog.e("QrAgentLoginManager", 1, "getConfigOpenUrl JSONException, ", e16);
            return "";
        }
    }

    public static QrAgentLoginManager t() {
        if (f339968m == null) {
            synchronized (QrAgentLoginManager.class) {
                if (f339968m == null) {
                    f339968m = new QrAgentLoginManager();
                }
            }
        }
        return f339968m;
    }

    @android.support.annotation.Nullable
    private static OpenSDKAppInterface u() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof OpenSDKAppInterface) {
            return (OpenSDKAppInterface) runtime;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String v() {
        if (TextUtils.isEmpty(this.f339975f)) {
            QLog.e("QrAgentLoginManager", 1, "configShieldOpenLogin, mLocalQrLoginConfig is null");
            return f339967l;
        }
        try {
            return new JSONObject(this.f339975f).optString("shield_open_login_tips", f339967l);
        } catch (JSONException e16) {
            QLog.e("QrAgentLoginManager", 1, "configShieldOpenLogin JSONException, ", e16);
            return f339967l;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String w() {
        if (TextUtils.isEmpty(this.f339975f)) {
            QLog.e("QrAgentLoginManager", 1, "configShieldOpenLogin, mLocalQrLoginConfig is null");
            return f339967l;
        }
        try {
            return new JSONObject(this.f339975f).optString("shield_qq_login_tips", f339967l);
        } catch (JSONException e16) {
            QLog.e("QrAgentLoginManager", 1, "configShieldOpenLogin JSONException, ", e16);
            return f339967l;
        }
    }

    private void x(ScannerParams scannerParams) {
        if (this.f339974e && "Conversation".equals(scannerParams.f276515e)) {
            this.f339976g = 2;
        } else if (z(scannerParams.D)) {
            this.f339976g = 1;
        } else {
            this.f339976g = 3;
        }
    }

    private boolean z(int i3) {
        if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
            switch (i3) {
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public void D(QQAppInterface qQAppInterface, String str, com.tencent.mobileqq.qrscan.k kVar, ScannerParams scannerParams) {
        QLog.d("QrAgentLoginManager", 1, "requestQRLogin: invoked");
        if (QLog.isColorLevel()) {
            QLog.i("QrAgentLoginManager", 2, "qrCodeStr: " + str);
        }
        this.f339971b = qQAppInterface.getOnlineStauts();
        this.f339972c = new WeakReference<>(kVar);
        this.f339973d = str;
        BaseApplication.context.getSharedPreferences("SP_QR_AGENT_LOGIN", 4).edit().putString("KEY_QR_AGENT_LOGIN_CODE" + qQAppInterface.getCurrentUin(), this.f339973d).apply();
        int indexOf = str.indexOf("?k=") + 3;
        String substring = str.substring(indexOf, indexOf + 32);
        this.f339970a = com.tencent.open.agent.util.q.a(substring.getBytes(), substring.length());
        if (!this.f339973d.contains("&n=1") && !MobileQQ.sMobileQQ.isLoginByNT()) {
            this.f339978i = null;
            String substring2 = str.substring(str.indexOf("&f=") + 3);
            int[] iArr = {3, 5, 32, 53, 54};
            String account = qQAppInterface.getAccount();
            if (QLog.isColorLevel()) {
                QLog.i("QrAgentLoginManager", 2, "requestQRLogin: invoked.  userAccount: " + account + " carAppIdString: " + substring2 + " content: " + substring);
            }
            this.f339974e = !TextUtils.isEmpty(scannerParams.f276517h);
            x(scannerParams);
            G(this.f339976g, scannerParams);
            if (this.f339974e) {
                this.f339975f = ea.C1(AppConstants.Preferences.LOCAL_QR_LOGIN_CONFIG);
            }
            QLog.i("QrAgentLoginManager", 1, "prepareQRLoginOnScaned scanScene: " + this.f339977h);
            Bundle bundle = new Bundle();
            bundle.putByteArray(BaseConstants.ATTRIBUTE_KEY_EXTRA_DEVICE_INFO, com.tencent.open.agent.util.q.b(qQAppInterface, this.f339977h, false).toByteArray());
            ((ILoginServletService) qQAppInterface.getRuntimeService(ILoginServletService.class, "all")).verifyCode(account, 16L, true, this.f339970a, iArr, 1, this.f339980k, bundle);
            return;
        }
        com.tencent.mobileqq.loginregister.servlet.a qrLoginManager = ((IQrLoginApi) QRoute.api(IQrLoginApi.class)).getQrLoginManager();
        this.f339978i = qrLoginManager;
        qrLoginManager.j(this.f339973d);
        this.f339978i.i(ScanScene.KUNKNOW, substring.getBytes(), this.f339979j);
    }

    public void E(long j3, String str) {
        com.tencent.mobileqq.qrscan.k kVar;
        Context context = QBaseActivity.sTopActivity;
        if (context == null) {
            context = BaseApplication.context;
        }
        Intent intent = new Intent(context, (Class<?>) AgentActivity.class);
        intent.putExtra("key_action", "action_login");
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_login_by_qr_scan", true);
        bundle.putString(CommonConstant.ReqAccessTokenParam.CLIENT_ID, String.valueOf(j3));
        bundle.putString("sdkp", str);
        bundle.putLong("KEY_ONLINE_STATUS", this.f339971b);
        bundle.putByteArray("key_qr_code", this.f339970a);
        bundle.putString("QR_CODE_STRING", this.f339973d);
        intent.putExtra("key_params", bundle);
        context.startActivity(intent);
        WeakReference<com.tencent.mobileqq.qrscan.k> weakReference = this.f339972c;
        if (weakReference == null) {
            kVar = null;
        } else {
            kVar = weakReference.get();
        }
        if (kVar != null) {
            kVar.finish();
        }
    }

    public void q() {
        QLog.i("QrAgentLoginManager", 2, "confirmNewQRLogin");
        com.tencent.mobileqq.loginregister.servlet.a aVar = this.f339978i;
        if (aVar != null) {
            aVar.f(SwitchOperation.KOPDEFAULT, this.f339979j);
        }
    }

    public void r(Bundle bundle, boolean z16) {
        String string = bundle.getString("QR_CODE_STRING");
        if ((string != null && string.contains("&n=1")) || MobileQQ.sMobileQQ.isLoginByNT()) {
            Bundle bundle2 = new Bundle();
            QLog.i("QrAgentLoginManager", 2, "confirmQRLogin nt");
            QIPCClientHelper.getInstance().getClient().callServer("open_sdk_qipc_module", "action_send_auth_qr_request", bundle2, null);
            return;
        }
        OpenSDKAppInterface u16 = u();
        if (u16 == null) {
            if (QLog.isColorLevel()) {
                QLog.i("QrAgentLoginManager", 2, " openSDKApp: " + u16);
                return;
            }
            return;
        }
        long j3 = bundle.getLong("KEY_ONLINE_STATUS");
        byte[] byteArray = bundle.getByteArray("key_qr_code");
        byte[] M = com.tencent.biz.qrcode.util.h.M(j3);
        ByteBuffer allocate = ByteBuffer.allocate(M.length + 4);
        allocate.putShort((short) 2);
        allocate.putShort((short) M.length);
        allocate.put(M);
        byte[] array = allocate.array();
        String account = u16.getAccount();
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty("") && !"".equals(account)) {
            byte[] bytes = "".getBytes();
            ByteBuffer allocate2 = ByteBuffer.allocate(bytes.length + 4);
            allocate2.putShort((short) 1);
            allocate2.putShort((short) bytes.length);
            allocate2.put(bytes);
            byte[] array2 = allocate2.array();
            ByteBuffer allocate3 = ByteBuffer.allocate(array2.length + 4);
            allocate3.putShort((short) 4);
            allocate3.putShort((short) array2.length);
            allocate3.put(array2);
            byte[] array3 = allocate3.array();
            arrayList.add(com.tencent.mobileqq.utils.HexUtil.bytes2HexStr(array));
            arrayList.add(com.tencent.mobileqq.utils.HexUtil.bytes2HexStr(array3));
        } else {
            arrayList.add(com.tencent.mobileqq.utils.HexUtil.bytes2HexStr(array));
        }
        ByteBuffer allocate4 = ByteBuffer.allocate(8);
        allocate4.putShort((short) 21);
        allocate4.putShort((short) 4);
        allocate4.putInt(z16 ? 1 : 0);
        arrayList.add(com.tencent.mobileqq.utils.HexUtil.bytes2HexStr(allocate4.array()));
        QLog.i("QrAgentLoginManager", 2, "confirmQRLogin scanScene: " + this.f339977h);
        Bundle bundle3 = new Bundle();
        bundle3.putByteArray(BaseConstants.ATTRIBUTE_KEY_EXTRA_DEVICE_INFO, com.tencent.open.agent.util.q.b(u16, this.f339977h, false).toByteArray());
        ((ILoginServletService) u16.getRuntimeService(ILoginServletService.class, "all")).closeCode(account, 16L, byteArray, 1, arrayList, this.f339980k, bundle3);
    }

    public void y(Bundle bundle) {
        QLog.i("QrAgentLoginManager", 1, "handleQRLoginCloseCodeForOpen.");
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (!com.tencent.open.agent.util.g.F(qBaseActivity)) {
            QLog.i("QrAgentLoginManager", 1, "handleQRLoginCloseCodeForOpen but top activity is wrong.");
        }
        if (qBaseActivity == null) {
            QLog.e("QrAgentLoginManager", 1, "handleQRLoginCloseCodeForOpen topActivity is null");
            return;
        }
        if (bundle != null) {
            Intent intent = new Intent(qBaseActivity, (Class<?>) QRLoginAuthActivity.class);
            intent.putExtras(bundle);
            qBaseActivity.startActivity(intent);
        }
        qBaseActivity.finish();
    }
}

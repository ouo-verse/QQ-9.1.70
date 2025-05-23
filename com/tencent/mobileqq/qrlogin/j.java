package com.tencent.mobileqq.qrlogin;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ILoginService;
import com.tencent.qqnt.kernel.nativeinterface.AuthQrReqInfo;
import com.tencent.qqnt.kernel.nativeinterface.AutoLoginInfo;
import com.tencent.qqnt.kernel.nativeinterface.AutoLoginSwitchState;
import com.tencent.qqnt.kernel.nativeinterface.ICommonCallback;
import com.tencent.qqnt.kernel.nativeinterface.IScanQRCodeCallback;
import com.tencent.qqnt.kernel.nativeinterface.LoginPlat;
import com.tencent.qqnt.kernel.nativeinterface.LoginRspInfo;
import com.tencent.qqnt.kernel.nativeinterface.OpenAppInfo;
import com.tencent.qqnt.kernel.nativeinterface.OpenAppType;
import com.tencent.qqnt.kernel.nativeinterface.QrAutoLoginInfo;
import com.tencent.qqnt.kernel.nativeinterface.QrAutoLoginSwitchState;
import com.tencent.qqnt.kernel.nativeinterface.QrLoginPlat;
import com.tencent.qqnt.kernel.nativeinterface.QrOpenAppInfo;
import com.tencent.qqnt.kernel.nativeinterface.QrOpenAppType;
import com.tencent.qqnt.kernel.nativeinterface.QrScanScene;
import com.tencent.qqnt.kernel.nativeinterface.QrSecCheckResult;
import com.tencent.qqnt.kernel.nativeinterface.QrSwitchOperation;
import com.tencent.qqnt.kernel.nativeinterface.QrTipsColor;
import com.tencent.qqnt.kernel.nativeinterface.QrTipsCtrl;
import com.tencent.qqnt.kernel.nativeinterface.ScanQrReq;
import com.tencent.qqnt.kernel.nativeinterface.ScanQrRsp;
import com.tencent.qqnt.kernel.nativeinterface.ScanQrRspInfo;
import com.tencent.qqnt.kernel.nativeinterface.ScanScene;
import com.tencent.qqnt.kernel.nativeinterface.SecCheckResult;
import com.tencent.qqnt.kernel.nativeinterface.SwitchOperation;
import com.tencent.qqnt.kernel.nativeinterface.TipsColor;
import com.tencent.qqnt.kernel.nativeinterface.TipsCtrl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\u0018\u0000 \u00132\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qrlogin/j;", "Lcom/tencent/mobileqq/loginregister/servlet/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/AuthQrReqInfo;", "reqInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/SwitchOperation;", "opSwitch", "Lf72/a;", "callback", "", "u", "Lcom/tencent/qqnt/kernel/nativeinterface/ScanQrRsp;", "ntQrInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/ScanQrRspInfo;", "w", "Lcom/tencent/qqnt/kernel/nativeinterface/ScanScene;", "scene", "", "qrSig", "i", "f", "g", tl.h.F, "<init>", "()V", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class j extends com.tencent.mobileqq.loginregister.servlet.a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qrlogin/j$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qrlogin.j$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f276421a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f276422b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f276423c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f276424d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int[] f276425e;

        /* renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int[] f276426f;

        /* renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int[] f276427g;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24657);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[ScanScene.values().length];
            try {
                iArr[ScanScene.KNORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScanScene.KUNKNOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScanScene.KWXONETAB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ScanScene.KNEWDEVAUTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ScanScene.KPRESSAIO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ScanScene.KPRESSPHOTO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ScanScene.KPRESSOTHER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f276421a = iArr;
            int[] iArr2 = new int[SwitchOperation.values().length];
            try {
                iArr2[SwitchOperation.KOPDEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[SwitchOperation.KOPDEFAULTOPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[SwitchOperation.KOPDEFAULTCLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            f276422b = iArr2;
            int[] iArr3 = new int[QrOpenAppType.values().length];
            try {
                iArr3[QrOpenAppType.KWEB.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[QrOpenAppType.KMOBILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[QrOpenAppType.KARK.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[QrOpenAppType.KMQQGAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[QrOpenAppType.KMQQAPP.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr3[QrOpenAppType.KCMSHOW.ordinal()] = 6;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr3[QrOpenAppType.KQQPAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr3[QrOpenAppType.KWINDOWSSDK.ordinal()] = 8;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr3[QrOpenAppType.KONLINEDOCS.ordinal()] = 9;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr3[QrOpenAppType.KMP.ordinal()] = 10;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr3[QrOpenAppType.KCAMP.ordinal()] = 11;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr3[QrOpenAppType.KROBOT.ordinal()] = 12;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr3[QrOpenAppType.KNATIVEAPI.ordinal()] = 13;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr3[QrOpenAppType.KAPPHELPER.ordinal()] = 14;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr3[QrOpenAppType.KDISCUZ.ordinal()] = 15;
            } catch (NoSuchFieldError unused25) {
            }
            f276423c = iArr3;
            int[] iArr4 = new int[QrSecCheckResult.values().length];
            try {
                iArr4[QrSecCheckResult.KSAFE.ordinal()] = 1;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr4[QrSecCheckResult.KRISK.ordinal()] = 2;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr4[QrSecCheckResult.KREJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused28) {
            }
            f276424d = iArr4;
            int[] iArr5 = new int[QrLoginPlat.values().length];
            try {
                iArr5[QrLoginPlat.KLOGINPLATDEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr5[QrLoginPlat.KLOGINPLATWINDOWS.ordinal()] = 2;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr5[QrLoginPlat.KLOGINPLATMAC.ordinal()] = 3;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr5[QrLoginPlat.KLOGINPLATIPAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr5[QrLoginPlat.KLOGINPLATIWATCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused33) {
            }
            f276425e = iArr5;
            int[] iArr6 = new int[QrAutoLoginSwitchState.values().length];
            try {
                iArr6[QrAutoLoginSwitchState.KAUTOLOGINSWITCHOPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr6[QrAutoLoginSwitchState.KAUTOLOGINSWITCHCLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused35) {
            }
            f276426f = iArr6;
            int[] iArr7 = new int[QrTipsColor.values().length];
            try {
                iArr7[QrTipsColor.KDEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr7[QrTipsColor.KRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused37) {
            }
            f276427g = iArr7;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24658);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(int i3, String str, LoginRspInfo loginRspInfo) {
        Integer num;
        if (loginRspInfo != null) {
            num = Integer.valueOf(loginRspInfo.errCode);
        } else {
            num = null;
        }
        QLog.d("QrNTLoginManager", 1, "sendCancelQrRequest result: " + i3 + ", errMsg: " + str + ", business code: " + num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(int i3, String str, LoginRspInfo loginRspInfo) {
        Integer num;
        if (loginRspInfo != null) {
            num = Integer.valueOf(loginRspInfo.errCode);
        } else {
            num = null;
        }
        QLog.d("QrNTLoginManager", 1, "sendRejectQrRequest result: " + i3 + ", errMsg: " + str + ", business code: " + num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(j this$0, f72.a callback, int i3, String str, ScanQrRsp info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.i("QrNTLoginManager", 2, "sendScanQrRequest " + i3 + ", " + str + ", " + info);
        Intrinsics.checkNotNullExpressionValue(info, "info");
        this$0.m(this$0.w(info));
        this$0.l(i3);
        if (i3 == -1) {
            str = HardCodeUtil.qqStr(R.string.f200584si);
        }
        callback.a(i3, str, this$0.e());
    }

    private final void u(AuthQrReqInfo reqInfo, SwitchOperation opSwitch, final f72.a callback) {
        int i3 = b.f276422b[opSwitch.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    reqInfo.opSwitch = QrSwitchOperation.KOPDEFAULTCLOSE;
                }
            } else {
                reqInfo.opSwitch = QrSwitchOperation.KOPDEFAULTOPEN;
            }
        } else {
            reqInfo.opSwitch = QrSwitchOperation.KOPDEFAULT;
        }
        ((ILoginService) QRoute.api(ILoginService.class)).sendAuthQrRequest(reqInfo, new ICommonCallback() { // from class: com.tencent.mobileqq.qrlogin.f
            @Override // com.tencent.qqnt.kernel.nativeinterface.ICommonCallback
            public final void onResult(int i16, String str, LoginRspInfo loginRspInfo) {
                j.v(f72.a.this, i16, str, loginRspInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(f72.a callback, int i3, String str, LoginRspInfo loginRspInfo) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (i3 == -1) {
            str = HardCodeUtil.qqStr(R.string.f200584si);
        }
        callback.b(i3, str, loginRspInfo.jumpUrl);
    }

    private final ScanQrRspInfo w(ScanQrRsp ntQrInfo) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        ScanQrRspInfo scanQrRspInfo = new ScanQrRspInfo();
        OpenAppInfo openAppInfo = new OpenAppInfo();
        QrOpenAppInfo qrOpenAppInfo = ntQrInfo.dstOpenAppInfo;
        openAppInfo.openAppid = qrOpenAppInfo.openAppid;
        openAppInfo.comeFrom = qrOpenAppInfo.comeFrom;
        QrOpenAppType qrOpenAppType = qrOpenAppInfo.appType;
        int i26 = -1;
        if (qrOpenAppType == null) {
            i3 = -1;
        } else {
            i3 = b.f276423c[qrOpenAppType.ordinal()];
        }
        switch (i3) {
            case 1:
                openAppInfo.appType = OpenAppType.KWEB;
                break;
            case 2:
                openAppInfo.appType = OpenAppType.KMOBILE;
                break;
            case 3:
                openAppInfo.appType = OpenAppType.KARK;
                break;
            case 4:
                openAppInfo.appType = OpenAppType.KMQQGAME;
                break;
            case 5:
                openAppInfo.appType = OpenAppType.KMQQAPP;
                break;
            case 6:
                openAppInfo.appType = OpenAppType.KCMSHOW;
                break;
            case 7:
                openAppInfo.appType = OpenAppType.KQQPAY;
                break;
            case 8:
                openAppInfo.appType = OpenAppType.KWINDOWSSDK;
                break;
            case 9:
                openAppInfo.appType = OpenAppType.KONLINEDOCS;
                break;
            case 10:
                openAppInfo.appType = OpenAppType.KMP;
                break;
            case 11:
                openAppInfo.appType = OpenAppType.KCAMP;
                break;
            case 12:
                openAppInfo.appType = OpenAppType.KROBOT;
                break;
            case 13:
                openAppInfo.appType = OpenAppType.KNATIVEAPI;
                break;
            case 14:
                openAppInfo.appType = OpenAppType.KAPPHELPER;
                break;
            case 15:
                openAppInfo.appType = OpenAppType.KDISCUZ;
                break;
        }
        scanQrRspInfo.dstOpenAppInfo = openAppInfo;
        QrSecCheckResult qrSecCheckResult = ntQrInfo.secCheckResult;
        if (qrSecCheckResult == null) {
            i16 = -1;
        } else {
            i16 = b.f276424d[qrSecCheckResult.ordinal()];
        }
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 == 3) {
                    scanQrRspInfo.secCheckResult = SecCheckResult.KREJECT;
                }
            } else {
                scanQrRspInfo.secCheckResult = SecCheckResult.KRISK;
            }
        } else {
            scanQrRspInfo.secCheckResult = SecCheckResult.KSAFE;
        }
        QrLoginPlat qrLoginPlat = ntQrInfo.loginPlat;
        if (qrLoginPlat == null) {
            i17 = -1;
        } else {
            i17 = b.f276425e[qrLoginPlat.ordinal()];
        }
        if (i17 != 1) {
            if (i17 != 2) {
                if (i17 != 3) {
                    if (i17 != 4) {
                        if (i17 == 5) {
                            scanQrRspInfo.loginPlat = LoginPlat.KLOGINPLATIWATCH;
                        }
                    } else {
                        scanQrRspInfo.loginPlat = LoginPlat.KLOGINPLATIPAD;
                    }
                } else {
                    scanQrRspInfo.loginPlat = LoginPlat.KLOGINPLATMAC;
                }
            } else {
                scanQrRspInfo.loginPlat = LoginPlat.KLOGINPLATWINDOWS;
            }
        } else {
            scanQrRspInfo.loginPlat = LoginPlat.KLOGINPLATDEFAULT;
        }
        AutoLoginInfo autoLoginInfo = new AutoLoginInfo();
        QrAutoLoginInfo qrAutoLoginInfo = ntQrInfo.autoLogin;
        autoLoginInfo.isShowAutoLoginSwitch = qrAutoLoginInfo.isShowAutoLoginSwitch;
        autoLoginInfo.tipsTitle = qrAutoLoginInfo.tipsTitle;
        autoLoginInfo.tipsContent = qrAutoLoginInfo.tipsContent;
        QrAutoLoginSwitchState qrAutoLoginSwitchState = qrAutoLoginInfo.autoLoginSwitchState;
        if (qrAutoLoginSwitchState == null) {
            i18 = -1;
        } else {
            i18 = b.f276426f[qrAutoLoginSwitchState.ordinal()];
        }
        if (i18 != 1) {
            if (i18 == 2) {
                autoLoginInfo.autoLoginSwitchState = AutoLoginSwitchState.KAUTOLOGINSWITCHCLOSE;
            }
        } else {
            autoLoginInfo.autoLoginSwitchState = AutoLoginSwitchState.KAUTOLOGINSWITCHOPEN;
        }
        scanQrRspInfo.autoLogin = autoLoginInfo;
        TipsCtrl tipsCtrl = new TipsCtrl();
        QrTipsColor qrTipsColor = ntQrInfo.tips.color;
        if (qrTipsColor == null) {
            i19 = -1;
        } else {
            i19 = b.f276427g[qrTipsColor.ordinal()];
        }
        if (i19 != 1) {
            if (i19 == 2) {
                tipsCtrl.color = TipsColor.KRED;
            }
        } else {
            tipsCtrl.color = TipsColor.KDEFAULT;
        }
        QrTipsColor qrTipsColor2 = ntQrInfo.tips.secCheckTipsColor;
        if (qrTipsColor2 != null) {
            i26 = b.f276427g[qrTipsColor2.ordinal()];
        }
        if (i26 != 1) {
            if (i26 == 2) {
                tipsCtrl.secCheckTipsColor = TipsColor.KRED;
            }
        } else {
            tipsCtrl.secCheckTipsColor = TipsColor.KDEFAULT;
        }
        QrTipsCtrl qrTipsCtrl = ntQrInfo.tips;
        tipsCtrl.tips = qrTipsCtrl.tips;
        tipsCtrl.needSecCheck = qrTipsCtrl.needSecCheck;
        tipsCtrl.secCheckConfirmTime = qrTipsCtrl.secCheckConfirmTime;
        tipsCtrl.secCheckTips = qrTipsCtrl.secCheckTips;
        scanQrRspInfo.tips = tipsCtrl;
        scanQrRspInfo.dstAppName = ntQrInfo.dstAppName;
        scanQrRspInfo.loginCity = ntQrInfo.loginCity;
        scanQrRspInfo.loginDevType = ntQrInfo.loginDevType;
        scanQrRspInfo.loginDevName = ntQrInfo.loginDevName;
        scanQrRspInfo.needA1 = ntQrInfo.needA1;
        return scanQrRspInfo;
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.a
    public void f(@NotNull SwitchOperation opSwitch, @NotNull f72.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) opSwitch, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(opSwitch, "opSwitch");
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean z16 = true;
        QLog.d("QrNTLoginManager", 1, "sendAuthQrRequest");
        ((ILoginService) QRoute.api(ILoginService.class)).setCurrentUin(MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
        AuthQrReqInfo authQrReqInfo = new AuthQrReqInfo();
        authQrReqInfo.qrSig = b();
        ScanQrRspInfo e16 = e();
        if (e16 == null || !e16.needA1) {
            z16 = false;
        }
        authQrReqInfo.needA1 = z16;
        u(authQrReqInfo, opSwitch, callback);
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.a
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ((ILoginService) QRoute.api(ILoginService.class)).sendCancleQrRequest(b(), new ICommonCallback() { // from class: com.tencent.mobileqq.qrlogin.g
                @Override // com.tencent.qqnt.kernel.nativeinterface.ICommonCallback
                public final void onResult(int i3, String str, LoginRspInfo loginRspInfo) {
                    j.r(i3, str, loginRspInfo);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.a
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            ((ILoginService) QRoute.api(ILoginService.class)).sendRejectQrRequest(b(), new ICommonCallback() { // from class: com.tencent.mobileqq.qrlogin.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.ICommonCallback
                public final void onResult(int i3, String str, LoginRspInfo loginRspInfo) {
                    j.s(i3, str, loginRspInfo);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.a
    public void i(@NotNull ScanScene scene, @NotNull byte[] qrSig, @NotNull final f72.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, scene, qrSig, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(qrSig, "qrSig");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d("QrNTLoginManager", 1, "sendScanQrRequest scene: " + scene);
        ((ILoginService) QRoute.api(ILoginService.class)).setCurrentUin(MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
        k(qrSig);
        ScanQrReq scanQrReq = new ScanQrReq();
        scanQrReq.qrSig = qrSig;
        switch (b.f276421a[scene.ordinal()]) {
            case 1:
                scanQrReq.scene = QrScanScene.KNORMAL;
                break;
            case 2:
                scanQrReq.scene = QrScanScene.KUNKNOW;
                break;
            case 3:
                scanQrReq.scene = QrScanScene.KWXONETAB;
                break;
            case 4:
                scanQrReq.scene = QrScanScene.KNEWDEVAUTH;
                break;
            case 5:
                scanQrReq.scene = QrScanScene.KPRESSAIO;
                break;
            case 6:
                scanQrReq.scene = QrScanScene.KPRESSPHOTO;
                break;
            case 7:
                scanQrReq.scene = QrScanScene.KPRESSOTHER;
                break;
        }
        ((ILoginService) QRoute.api(ILoginService.class)).sendScanQrRequest(scanQrReq, new IScanQRCodeCallback() { // from class: com.tencent.mobileqq.qrlogin.i
            @Override // com.tencent.qqnt.kernel.nativeinterface.IScanQRCodeCallback
            public final void onResult(int i3, String str, ScanQrRsp scanQrRsp) {
                j.t(j.this, callback, i3, str, scanQrRsp);
            }
        });
    }
}

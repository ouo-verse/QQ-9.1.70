package com.tencent.mobileqq.qrlogin;

import android.os.Build;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelQRService;
import com.tencent.qqnt.kernel.nativeinterface.IQRCallback;
import com.tencent.qqnt.kernel.nativeinterface.IScanQRCallback;
import com.tencent.qqnt.kernel.nativeinterface.InitQRConfig;
import com.tencent.qqnt.kernel.nativeinterface.ScanQrRspInfo;
import com.tencent.qqnt.kernel.nativeinterface.ScanScene;
import com.tencent.qqnt.kernel.nativeinterface.SwitchOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qrlogin/e;", "Lcom/tencent/mobileqq/loginregister/servlet/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelQRService;", "r", "Lcom/tencent/qqnt/kernel/nativeinterface/ScanScene;", "scene", "", "qrSig", "Lf72/a;", "callback", "", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/SwitchOperation;", "opSwitch", "f", "g", tl.h.F, "<init>", "()V", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class e extends com.tencent.mobileqq.loginregister.servlet.a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qrlogin/e$a;", "", "", "APP_ID", "I", "", "TAG", "Ljava/lang/String;", "VERSION", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qrlogin.e$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24649);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        InitQRConfig initQRConfig = new InitQRConfig(16, peekAppRuntime.getApplication().getPackageName(), "1", Build.MANUFACTURER + "." + DeviceInfoMonitor.getModel(), util.buf_to_string(com.tencent.mobileqq.guid.c.f213821a.c()));
        IKernelQRService r16 = r();
        if (r16 != null) {
            r16.initConfig(initQRConfig);
        }
    }

    private final IKernelQRService r() {
        IKernelQRService qRService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getQRService();
        if (qRService == null) {
            QLog.e("QrLoginManager", 1, "getQRService service is null");
        }
        return qRService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(f72.a callback, int i3, String str, String str2) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.i("QrLoginManager", 2, "sendAuthQrRequest " + i3 + ", " + str + ", " + str2);
        if (i3 == -1) {
            str = HardCodeUtil.qqStr(R.string.f200584si);
        }
        callback.b(i3, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(int i3, String str, String str2) {
        QLog.i("QrLoginManager", 2, "sendCancelQrRequest " + i3 + ", " + str + ", " + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(int i3, String str, String str2) {
        QLog.i("QrLoginManager", 2, "sendRejectQrRequest " + i3 + ", " + str + ", " + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(e this$0, f72.a callback, int i3, String str, ScanQrRspInfo scanQrRspInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.i("QrLoginManager", 2, "sendScanQrRequest " + i3 + ", " + str + ", " + scanQrRspInfo);
        this$0.m(scanQrRspInfo);
        this$0.l(i3);
        if (i3 == -1) {
            str = HardCodeUtil.qqStr(R.string.f200584si);
        }
        callback.a(i3, str, scanQrRspInfo);
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.a
    public void f(@NotNull SwitchOperation opSwitch, @NotNull final f72.a callback) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) opSwitch, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(opSwitch, "opSwitch");
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean z16 = true;
        QLog.i("QrLoginManager", 1, "sendAuthQrRequest");
        ScanQrRspInfo e16 = e();
        if (e16 == null || true != e16.needA1) {
            z16 = false;
        }
        if (z16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Manager manager = peekAppRuntime.getManager(2);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type mqq.manager.TicketManager");
            bArr = ((TicketManager) manager).getA1(peekAppRuntime.getLongAccountUin(), 16L, null);
            Intrinsics.checkNotNullExpressionValue(bArr, "{\n            val app = \u2026toLong(), null)\n        }");
        } else {
            bArr = new byte[0];
        }
        IKernelQRService r16 = r();
        if (r16 != null) {
            r16.sendAuthQrRequest(bArr, b(), opSwitch, new IQRCallback() { // from class: com.tencent.mobileqq.qrlogin.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IQRCallback
                public final void onResult(int i3, String str, String str2) {
                    e.s(f72.a.this, i3, str, str2);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.a
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.i("QrLoginManager", 1, "sendCancelQrRequest");
        IKernelQRService r16 = r();
        if (r16 != null) {
            r16.sendCancleQrRequest(b(), new IQRCallback() { // from class: com.tencent.mobileqq.qrlogin.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IQRCallback
                public final void onResult(int i3, String str, String str2) {
                    e.t(i3, str, str2);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.a
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.i("QrLoginManager", 1, "sendRejectQrRequest");
        IKernelQRService r16 = r();
        if (r16 != null) {
            r16.SendRejectQrRequest(b(), new IQRCallback() { // from class: com.tencent.mobileqq.qrlogin.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IQRCallback
                public final void onResult(int i3, String str, String str2) {
                    e.u(i3, str, str2);
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
        k(qrSig);
        QLog.i("QrLoginManager", 1, "sendScanQrRequest");
        IKernelQRService r16 = r();
        if (r16 != null) {
            r16.sendScanQrRequest(scene, qrSig, new IScanQRCallback() { // from class: com.tencent.mobileqq.qrlogin.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IScanQRCallback
                public final void onResult(int i3, String str, ScanQrRspInfo scanQrRspInfo) {
                    e.v(e.this, callback, i3, str, scanQrRspInfo);
                }
            });
        }
    }
}

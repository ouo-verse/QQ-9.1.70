package com.tencent.mobileqq.login.ntlogin;

import android.os.Bundle;
import android.text.TextUtils;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.login.api.ILoginReporter;
import com.tencent.mobileqq.login.verify.DevLockVerifyComponent;
import com.tencent.mobileqq.login.verify.t;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginStatus;
import com.tencent.mobileqq.util.as;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ErrorDetail;
import com.tencent.qqnt.kernel.nativeinterface.ErrorNeedVerifyNewDevice;
import com.tencent.qqnt.kernel.nativeinterface.LoginRspInfo;
import com.tencent.util.URLUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.login.GetLocalPhone$OIDBGetPhoneRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 -2\u00020\u0001:\u0003(.-B\u0007\u00a2\u0006\u0004\b+\u0010,J\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J5\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ=\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J4\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\tH\u0002J\"\u0010\u001c\u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J;\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eJR\u0010&\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u00022\b\u0010#\u001a\u0004\u0018\u00010\u00022\b\u0010$\u001a\u0004\u0018\u00010\u00022\b\u0010%\u001a\u0004\u0018\u00010\u0002R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/login/ntlogin/NTDevLockVerifyComponent;", "", "", "url", "wxBindingUin", "d", "", "phoneType", "serviceType", "Landroid/os/Bundle;", "extras", "Lcom/tencent/mobileqq/login/ntlogin/mainline/i;", "e", "(IILandroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", TangramHippyConstants.LOGIN_TYPE, "uin", "passThroughParams", "Lcom/tencent/qqnt/kernel/nativeinterface/LoginRspInfo;", "verifyInfo", "j", "(ILjava/lang/String;Landroid/os/Bundle;Lcom/tencent/qqnt/kernel/nativeinterface/LoginRspInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/login/ntlogin/NTDevLockVerifyComponent$b;", "callback", "", QAdLoginDefine$LoginStatus.IS_LOGIN, "bundle", "", tl.h.F, "g", "f", "(ILjava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/LoginRspInfo;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tValue", IProfileCardConst.KEY_FROM_TYPE, "result", "r2", "r3", "r4", "r5", "i", "", "a", "J", "mVerifyStartTime", "<init>", "()V", "b", "DevLockType", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NTDevLockVerifyComponent {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long mVerifyStartTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/login/ntlogin/NTDevLockVerifyComponent$DevLockType;", "", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes15.dex */
    public @interface DevLockType {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/login/ntlogin/NTDevLockVerifyComponent$a;", "", "", "TAG", "Ljava/lang/String;", "WECHAT_LOGIN_BIND_UIN", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.ntlogin.NTDevLockVerifyComponent$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\b\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/login/ntlogin/NTDevLockVerifyComponent$b;", "", "", QAdLoginDefine$LoginStatus.IS_LOGIN, "Landroid/os/Bundle;", "data", "", "b", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface b {
        void a();

        void b(boolean isLogin, @Nullable Bundle data);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/login/ntlogin/NTDevLockVerifyComponent$c", "Lne1/a;", "Ltencent/im/login/GetLocalPhone$OIDBGetPhoneRsp;", "data", "", "a", "", "errorCode", "", "errorMsg", "onFail", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements ne1.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<com.tencent.mobileqq.login.ntlogin.mainline.i<String>> f242213a;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super com.tencent.mobileqq.login.ntlogin.mainline.i<String>> cancellableContinuation) {
            this.f242213a = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuation);
            }
        }

        @Override // ne1.a
        public void a(@NotNull GetLocalPhone$OIDBGetPhoneRsp data) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            String str = data.msg_auth_device_succed_data.get().str_auth_device_succceed_sig.get();
            if (str != null) {
                if (str.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    CancellableContinuation<com.tencent.mobileqq.login.ntlogin.mainline.i<String>> cancellableContinuation = this.f242213a;
                    com.tencent.mobileqq.login.ntlogin.mainline.i iVar = new com.tencent.mobileqq.login.ntlogin.mainline.i(0, "success", str);
                    if (cancellableContinuation.isActive()) {
                        cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                        return;
                    }
                    QLog.e("NTLogin", 1, "local phone verifysafeResume call failed ");
                    return;
                }
            }
            QLog.e("NTDevLockVerifyComponent", 1, "startVerifyByECDH onSuccess succeedSig is null");
            CancellableContinuation<com.tencent.mobileqq.login.ntlogin.mainline.i<String>> cancellableContinuation2 = this.f242213a;
            com.tencent.mobileqq.login.ntlogin.mainline.i iVar2 = new com.tencent.mobileqq.login.ntlogin.mainline.i(-1, "verify sig is null", null);
            if (cancellableContinuation2.isActive()) {
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(iVar2));
                return;
            }
            QLog.e("NTLogin", 1, "local phone verifysafeResume call failed ");
        }

        @Override // ne1.a
        public void onFail(int errorCode, @Nullable String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
                return;
            }
            QLog.e("NTDevLockVerifyComponent", 1, "new dev local phone verify onFail: " + errorCode + ", error: " + errorMsg);
            CancellableContinuation<com.tencent.mobileqq.login.ntlogin.mainline.i<String>> cancellableContinuation = this.f242213a;
            com.tencent.mobileqq.login.ntlogin.mainline.i iVar = new com.tencent.mobileqq.login.ntlogin.mainline.i(errorCode, errorMsg, null);
            if (cancellableContinuation.isActive()) {
                cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                return;
            }
            QLog.e("NTLogin", 1, "local phone verifysafeResume call failed ");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/login/ntlogin/NTDevLockVerifyComponent$d", "Lcom/tencent/mobileqq/login/verify/t$b;", "", QAdLoginDefine$LoginStatus.IS_LOGIN, "Landroid/os/Bundle;", "data", "", "b", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class d implements t.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<com.tencent.mobileqq.login.ntlogin.mainline.i<String>> f242214a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ NTDevLockVerifyComponent f242215b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f242216c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f242217d;

        d(CancellableContinuation<? super com.tencent.mobileqq.login.ntlogin.mainline.i<String>> cancellableContinuation, NTDevLockVerifyComponent nTDevLockVerifyComponent, int i3, String str) {
            this.f242214a = cancellableContinuation;
            this.f242215b = nTDevLockVerifyComponent;
            this.f242216c = i3;
            this.f242217d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, cancellableContinuation, nTDevLockVerifyComponent, Integer.valueOf(i3), str);
            }
        }

        @Override // com.tencent.mobileqq.login.verify.t.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.d("NTDevLockVerifyComponent", 1, "WebAuxiliaryVerify onVerifyCancel");
            CancellableContinuation<com.tencent.mobileqq.login.ntlogin.mainline.i<String>> cancellableContinuation = this.f242214a;
            com.tencent.mobileqq.login.ntlogin.mainline.i iVar = new com.tencent.mobileqq.login.ntlogin.mainline.i(-1, "user cancel", null);
            if (cancellableContinuation.isActive()) {
                cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
            } else {
                QLog.e("NTLogin", 1, "new dev web verifysafeResume call failed ");
            }
            this.f242215b.g(null, this.f242216c, this.f242217d);
        }

        @Override // com.tencent.mobileqq.login.verify.t.b
        public void b(boolean isLogin, @Nullable Bundle data) {
            String string;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isLogin), data);
                return;
            }
            QLog.d("NTDevLockVerifyComponent", 1, "WebAuxiliaryVerify onVerifySuccess");
            String str = "";
            if (data != null && (string = data.getString("devlock_verify_sig")) != null) {
                str = string;
            }
            CancellableContinuation<com.tencent.mobileqq.login.ntlogin.mainline.i<String>> cancellableContinuation = this.f242214a;
            com.tencent.mobileqq.login.ntlogin.mainline.i iVar = new com.tencent.mobileqq.login.ntlogin.mainline.i(0, "new dev web verify", str);
            if (cancellableContinuation.isActive()) {
                cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
            } else {
                QLog.e("NTLogin", 1, "new dev web verifysafeResume call failed ");
            }
            this.f242215b.h(null, this.f242216c, this.f242217d, isLogin, data);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21272);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NTDevLockVerifyComponent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d(String url, String wxBindingUin) {
        if (!TextUtils.isEmpty(wxBindingUin)) {
            return URLUtil.addParameter(URLUtil.addParameter(url, "from", "2"), "wx_account", wxBindingUin);
        }
        return url;
    }

    private final Object e(int i3, int i16, Bundle bundle, Continuation<? super com.tencent.mobileqq.login.ntlogin.mainline.i<String>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        com.tencent.mobileqq.gateway.localphone.ecdh.g.m(i3, i16, new c(cancellableContinuationImpl), bundle);
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(b callback, int loginType, String uin) {
        i("0X800C283", uin, DevLockVerifyComponent.i(loginType), 2, String.valueOf(System.currentTimeMillis() - this.mVerifyStartTime), "", "", "");
        ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportLoginDevLockVerifyEnd(false);
        if (callback != null) {
            callback.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(b callback, int loginType, String uin, boolean isLogin, Bundle bundle) {
        i("0X800C283", uin, DevLockVerifyComponent.i(loginType), 0, String.valueOf(System.currentTimeMillis() - this.mVerifyStartTime), "", "", "");
        ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportLoginDevLockVerifyEnd(true);
        if (callback != null) {
            callback.b(isLogin, bundle);
        }
    }

    private final Object j(int i3, String str, Bundle bundle, LoginRspInfo loginRspInfo, Continuation<? super com.tencent.mobileqq.login.ntlogin.mainline.i<String>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        String str2;
        boolean z16;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QLog.d("NTDevLockVerifyComponent", 1, "startWebAuxiliaryVerify loginType=" + i3);
        String str3 = null;
        if (loginRspInfo != null && !TextUtils.isEmpty(loginRspInfo.jumpUrl)) {
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                str2 = bundle.getString("mainaccount");
            } else {
                str2 = null;
            }
            if (str2 != null && !Intrinsics.areEqual(str2, str)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                bundle2.putString("subAccountUin", str);
                bundle2.putBoolean("isSubaccount", z16);
                bundle2.putBoolean("avoidLoginWeb", z16);
            }
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            QLog.d("NTDevLockVerifyComponent", 1, "other_verify, mainAccount=" + str2 + " uin=" + str + " isSubaccount=" + z16);
            String str4 = loginRspInfo.jumpUrl;
            if (bundle != null) {
                str3 = bundle.getString("wechat_login_bind_uin");
            }
            String d16 = d(str4, str3);
            QBaseActivity sTopActivity = QBaseActivity.sTopActivity;
            Intrinsics.checkNotNullExpressionValue(sTopActivity, "sTopActivity");
            com.tencent.mobileqq.login.verify.t.e(sTopActivity, d16, bundle2, i3, str, true, new d(cancellableContinuationImpl, this, i3, str));
        } else {
            QLog.e("NTDevLockVerifyComponent", 1, "startWebAuxiliaryVerify, verifyInfo or url is null");
            com.tencent.mobileqq.login.ntlogin.mainline.i iVar = new com.tencent.mobileqq.login.ntlogin.mainline.i(-1, "jump url is null!", null);
            if (cancellableContinuationImpl.isActive()) {
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(iVar));
            } else {
                QLog.e("NTLogin", 1, "new dev web verifysafeResume call failed ");
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0106 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008f  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f(int i3, @NotNull String str, @NotNull LoginRspInfo loginRspInfo, @Nullable Bundle bundle, @NotNull Continuation<? super com.tencent.mobileqq.login.ntlogin.mainline.i<String>> continuation) {
        NTDevLockVerifyComponent$newDevVerify$1 nTDevLockVerifyComponent$newDevVerify$1;
        Object coroutine_suspended;
        int i16;
        String str2;
        Bundle bundle2;
        int i17;
        NTDevLockVerifyComponent nTDevLockVerifyComponent;
        ErrorNeedVerifyNewDevice errorNeedVerifyNewDevice;
        com.tencent.mobileqq.login.ntlogin.mainline.i iVar;
        LoginRspInfo loginRspInfo2 = loginRspInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, loginRspInfo2, bundle, continuation);
        }
        if (continuation instanceof NTDevLockVerifyComponent$newDevVerify$1) {
            nTDevLockVerifyComponent$newDevVerify$1 = (NTDevLockVerifyComponent$newDevVerify$1) continuation;
            int i18 = nTDevLockVerifyComponent$newDevVerify$1.label;
            if ((i18 & Integer.MIN_VALUE) != 0) {
                nTDevLockVerifyComponent$newDevVerify$1.label = i18 - Integer.MIN_VALUE;
                Object obj = nTDevLockVerifyComponent$newDevVerify$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = nTDevLockVerifyComponent$newDevVerify$1.label;
                if (i16 == 0) {
                    if (i16 != 1) {
                        if (i16 != 2) {
                            if (i16 != 3) {
                                if (i16 == 4) {
                                    ResultKt.throwOnFailure(obj);
                                    return obj;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        } else {
                            int i19 = nTDevLockVerifyComponent$newDevVerify$1.I$0;
                            Bundle bundle3 = (Bundle) nTDevLockVerifyComponent$newDevVerify$1.L$3;
                            loginRspInfo2 = (LoginRspInfo) nTDevLockVerifyComponent$newDevVerify$1.L$2;
                            String str3 = (String) nTDevLockVerifyComponent$newDevVerify$1.L$1;
                            NTDevLockVerifyComponent nTDevLockVerifyComponent2 = (NTDevLockVerifyComponent) nTDevLockVerifyComponent$newDevVerify$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            i17 = i19;
                            bundle2 = bundle3;
                            str2 = str3;
                            nTDevLockVerifyComponent = nTDevLockVerifyComponent2;
                            iVar = (com.tencent.mobileqq.login.ntlogin.mainline.i) obj;
                            if (iVar.c() != 0) {
                                return iVar;
                            }
                            nTDevLockVerifyComponent$newDevVerify$1.L$0 = null;
                            nTDevLockVerifyComponent$newDevVerify$1.L$1 = null;
                            nTDevLockVerifyComponent$newDevVerify$1.L$2 = null;
                            nTDevLockVerifyComponent$newDevVerify$1.L$3 = null;
                            nTDevLockVerifyComponent$newDevVerify$1.label = 3;
                            obj = nTDevLockVerifyComponent.j(i17, str2, bundle2, loginRspInfo2, nTDevLockVerifyComponent$newDevVerify$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    this.mVerifyStartTime = System.currentTimeMillis();
                    ErrorDetail errorDetail = loginRspInfo2.msgDetail;
                    if (errorDetail != null && (errorNeedVerifyNewDevice = errorDetail.msgNeedVerifyNewDevice) != null && errorNeedVerifyNewDevice.allowGateWayVerify) {
                        z16 = true;
                    }
                    if (z16) {
                        QLog.d("NTDevLockVerifyComponent", 1, "newDevVerify start gateway verify!!!");
                        String str4 = URLUtil.getArgumentsFromURL(loginRspInfo2.jumpUrl).get(PreloadTRTCPlayerParams.KEY_SIG);
                        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str)) {
                            Bundle bundle4 = new Bundle();
                            bundle4.putInt(IPublicAccountBrowser.KEY_UIN_TYPE, 1);
                            bundle4.putString("uin", str);
                            bundle4.putString("req_sig", str4);
                            nTDevLockVerifyComponent$newDevVerify$1.L$0 = this;
                            nTDevLockVerifyComponent$newDevVerify$1.L$1 = str;
                            nTDevLockVerifyComponent$newDevVerify$1.L$2 = loginRspInfo2;
                            nTDevLockVerifyComponent$newDevVerify$1.L$3 = bundle;
                            nTDevLockVerifyComponent$newDevVerify$1.I$0 = i3;
                            nTDevLockVerifyComponent$newDevVerify$1.label = 2;
                            obj = e(4, 13, bundle4, nTDevLockVerifyComponent$newDevVerify$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            str2 = str;
                            bundle2 = bundle;
                            i17 = i3;
                            nTDevLockVerifyComponent = this;
                            iVar = (com.tencent.mobileqq.login.ntlogin.mainline.i) obj;
                            if (iVar.c() != 0) {
                            }
                        } else {
                            nTDevLockVerifyComponent$newDevVerify$1.label = 1;
                            obj = j(i3, str, bundle, loginRspInfo, nTDevLockVerifyComponent$newDevVerify$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return obj;
                        }
                    } else {
                        NTDevLockVerifyComponent$newDevVerify$1 nTDevLockVerifyComponent$newDevVerify$12 = nTDevLockVerifyComponent$newDevVerify$1;
                        nTDevLockVerifyComponent$newDevVerify$12.label = 4;
                        obj = j(i3, str, bundle, loginRspInfo, nTDevLockVerifyComponent$newDevVerify$12);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj;
                    }
                }
                return obj;
            }
        }
        nTDevLockVerifyComponent$newDevVerify$1 = new NTDevLockVerifyComponent$newDevVerify$1(this, continuation);
        Object obj2 = nTDevLockVerifyComponent$newDevVerify$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = nTDevLockVerifyComponent$newDevVerify$1.label;
        if (i16 == 0) {
        }
        return obj2;
    }

    public final void i(@Nullable String tValue, @Nullable String uin, int fromType, int result, @Nullable String r26, @Nullable String r36, @Nullable String r46, @Nullable String r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, tValue, uin, Integer.valueOf(fromType), Integer.valueOf(result), r26, r36, r46, r56);
        } else {
            as.b("devlock_verify_component", tValue, uin, fromType, result, true, r26, r36, r46, r56);
        }
    }
}

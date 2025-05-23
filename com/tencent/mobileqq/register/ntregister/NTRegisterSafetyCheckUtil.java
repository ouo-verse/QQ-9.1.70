package com.tencent.mobileqq.register.ntregister;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.login.verify.PuzzleVerifyComponent;
import com.tencent.mobileqq.loginregister.sms.RegisterVerifyResult;
import com.tencent.mobileqq.loginregister.sms.SmsVerifyComponent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.register.i;
import com.tencent.mobileqq.register.o;
import com.tencent.mobileqq.register.q;
import com.tencent.mobileqq.util.cb;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.Iframe;
import com.tencent.qqnt.kernel.nativeinterface.RegisterIdentityLimit;
import com.tencent.qqnt.kernel.nativeinterface.RegisterIdentityRsp;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J)\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\u0006\u0010\u000e\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\n2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001bJ!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\n2\u0006\u0010\u001d\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010#\u001a\u0004\u0018\u00010\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/register/ntregister/NTRegisterSafetyCheckUtil;", "", "Ljava/lang/Runnable;", "runnable", "", "i", "Lcom/tencent/mobileqq/app/QBaseActivity;", "context", "", "unbindUinURL", "Lcom/tencent/mobileqq/register/ntregister/a;", "g", "(Lcom/tencent/mobileqq/app/QBaseActivity;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/nativeinterface/RegisterIdentityRsp;", "registerRsp", "Lcom/tencent/mobileqq/loginregister/sms/RegisterVerifyResult;", h.F, "(Lcom/tencent/qqnt/kernel/nativeinterface/RegisterIdentityRsp;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "f", "(Lcom/tencent/qqnt/kernel/nativeinterface/RegisterIdentityRsp;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/kernel/nativeinterface/RegisterIdentityLimit;", "identityLimit", "Lcom/tencent/mobileqq/register/bean/b;", "c", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/qqnt/kernel/nativeinterface/RegisterIdentityLimit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "verifyUrl", "Lcom/tencent/qqnt/kernel/nativeinterface/Iframe;", "e", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urlString", "parameterName", "b", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class NTRegisterSafetyCheckUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NTRegisterSafetyCheckUtil f280486a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27154);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f280486a = new NTRegisterSafetyCheckUtil();
        }
    }

    NTRegisterSafetyCheckUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(Runnable runnable) {
        if (!Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        } else {
            runnable.run();
        }
    }

    @Nullable
    public final String b(@NotNull String urlString, @NotNull String parameterName) {
        List split$default;
        List split$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) urlString, (Object) parameterName);
        }
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Intrinsics.checkNotNullParameter(parameterName, "parameterName");
        try {
            String query = new URL(urlString).getQuery();
            Intrinsics.checkNotNullExpressionValue(query, "query");
            split$default = StringsKt__StringsKt.split$default((CharSequence) query, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                if (split$default2.size() == 2 && Intrinsics.areEqual(split$default2.get(0), parameterName)) {
                    return (String) split$default2.get(1);
                }
            }
            return null;
        } catch (Exception e16) {
            QLog.e("NTRegisterSafetyCheckUtil", 1, "getParameterValue error: " + e16);
            return null;
        }
    }

    @Nullable
    public final Object c(@NotNull final QBaseActivity qBaseActivity, @NotNull final RegisterIdentityLimit registerIdentityLimit, @NotNull Continuation<? super a<com.tencent.mobileqq.register.bean.b>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            QLog.d("NTRegisterSafetyCheckUtil", 1, "requestFaceVerify ");
            f280486a.i(new Runnable(registerIdentityLimit, cancellableContinuationImpl) { // from class: com.tencent.mobileqq.register.ntregister.NTRegisterSafetyCheckUtil$requestFaceVerify$2$1
                static IPatchRedirector $redirector_;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ RegisterIdentityLimit f280488e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<com.tencent.mobileqq.register.bean.b>> f280489f;

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/register/ntregister/NTRegisterSafetyCheckUtil$requestFaceVerify$2$1$a", "Lam2/a;", "", "result", "Landroid/os/Bundle;", "data", "", "onResult", "a", "b", "onCancel", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes17.dex */
                public static final class a implements am2.a {
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<com.tencent.mobileqq.register.bean.b>> f280490a;

                    /* JADX WARN: Multi-variable type inference failed */
                    a(CancellableContinuation<? super com.tencent.mobileqq.register.ntregister.a<com.tencent.mobileqq.register.bean.b>> cancellableContinuation) {
                        this.f280490a = cancellableContinuation;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuation);
                        }
                    }

                    @Override // am2.a
                    public void a(@NotNull Bundle data) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(data, "data");
                        QLog.d("NTRegisterSafetyCheckUtil", 1, "requestFaceVerify callback");
                        com.tencent.mobileqq.register.bean.b b16 = q.c().b();
                        CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<com.tencent.mobileqq.register.bean.b>> cancellableContinuation = this.f280490a;
                        com.tencent.mobileqq.register.ntregister.a aVar = new com.tencent.mobileqq.register.ntregister.a(10000, "requestFaceVerify success", b16);
                        if (cancellableContinuation.isActive()) {
                            cancellableContinuation.resumeWith(Result.m476constructorimpl(aVar));
                            return;
                        }
                        QLog.e("NTLogin", 1, "requestFriendGuarantee successsafeResume call failed ");
                    }

                    @Override // am2.a
                    public void b() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                            iPatchRedirector.redirect((short) 4, (Object) this);
                            return;
                        }
                        QLog.d("NTRegisterSafetyCheckUtil", 1, "requestFaceVerify onException");
                        CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<com.tencent.mobileqq.register.bean.b>> cancellableContinuation = this.f280490a;
                        com.tencent.mobileqq.register.ntregister.a aVar = new com.tencent.mobileqq.register.ntregister.a(-1, "requestFaceVerify exception", null);
                        if (cancellableContinuation.isActive()) {
                            cancellableContinuation.resumeWith(Result.m476constructorimpl(aVar));
                            return;
                        }
                        QLog.e("NTLogin", 1, "requestFaceVerify exceptionsafeResume call failed ");
                    }

                    @Override // am2.a
                    public void onCancel() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                            iPatchRedirector.redirect((short) 5, (Object) this);
                            return;
                        }
                        QLog.d("NTRegisterSafetyCheckUtil", 1, "requestFaceVerify cancel");
                        CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<com.tencent.mobileqq.register.bean.b>> cancellableContinuation = this.f280490a;
                        com.tencent.mobileqq.register.ntregister.a aVar = new com.tencent.mobileqq.register.ntregister.a(-1, "requestFaceVerify cancel", null);
                        if (cancellableContinuation.isActive()) {
                            cancellableContinuation.resumeWith(Result.m476constructorimpl(aVar));
                            return;
                        }
                        QLog.e("NTLogin", 1, "requestFaceVerify cancelsafeResume call failed ");
                    }

                    @Override // am2.a
                    public void onResult(boolean result, @Nullable Bundle data) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(result), data);
                            return;
                        }
                        QLog.d("NTRegisterSafetyCheckUtil", 1, "onResult sms callback");
                        CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<com.tencent.mobileqq.register.bean.b>> cancellableContinuation = this.f280490a;
                        com.tencent.mobileqq.register.ntregister.a aVar = new com.tencent.mobileqq.register.ntregister.a(-1, "onResult sms callback", null);
                        if (cancellableContinuation.isActive()) {
                            cancellableContinuation.resumeWith(Result.m476constructorimpl(aVar));
                            return;
                        }
                        QLog.e("NTLogin", 1, "requestFaceVerify exceptionsafeResume call failed ");
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.f280488e = registerIdentityLimit;
                    this.f280489f = cancellableContinuationImpl;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QBaseActivity.this, registerIdentityLimit, cancellableContinuationImpl);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.mobileqq.register.h hVar = com.tencent.mobileqq.register.h.f280443a;
                    QBaseActivity qBaseActivity2 = QBaseActivity.this;
                    RegisterIdentityLimit registerIdentityLimit2 = this.f280488e;
                    int i3 = registerIdentityLimit2.type;
                    String str = registerIdentityLimit2.handleUrl;
                    Intrinsics.checkNotNullExpressionValue(str, "identityLimit.handleUrl");
                    hVar.b(qBaseActivity2, i3, str, this.f280488e.type, new a(this.f280489f));
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 5, this, qBaseActivity, registerIdentityLimit, continuation);
    }

    @Nullable
    public final Object d(@NotNull final QBaseActivity qBaseActivity, @NotNull final RegisterIdentityLimit registerIdentityLimit, @NotNull Continuation<? super a<String>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, this, qBaseActivity, registerIdentityLimit, continuation);
        }
        QLog.d("NTRegisterSafetyCheckUtil", 1, "requestFriendGuarantee ");
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        f280486a.i(new Runnable(registerIdentityLimit, cancellableContinuationImpl) { // from class: com.tencent.mobileqq.register.ntregister.NTRegisterSafetyCheckUtil$requestFriendGuarantee$2$1
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ RegisterIdentityLimit f280492e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<String>> f280493f;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/register/ntregister/NTRegisterSafetyCheckUtil$requestFriendGuarantee$2$1$a", "Lam2/a;", "", "result", "Landroid/os/Bundle;", "data", "", "onResult", "a", "b", "onCancel", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes17.dex */
            public static final class a implements am2.a {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<String>> f280494a;

                /* JADX WARN: Multi-variable type inference failed */
                a(CancellableContinuation<? super com.tencent.mobileqq.register.ntregister.a<String>> cancellableContinuation) {
                    this.f280494a = cancellableContinuation;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuation);
                    }
                }

                @Override // am2.a
                public void a(@NotNull Bundle data) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(data, "data");
                    QLog.d("NTRegisterSafetyCheckUtil", 1, "requestFriendGuarantee callback");
                    CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<String>> cancellableContinuation = this.f280494a;
                    com.tencent.mobileqq.register.ntregister.a aVar = new com.tencent.mobileqq.register.ntregister.a(10000, "requestFriendGuarantee success", "");
                    if (cancellableContinuation.isActive()) {
                        cancellableContinuation.resumeWith(Result.m476constructorimpl(aVar));
                        return;
                    }
                    QLog.e("NTLogin", 1, "requestFriendGuarantee successsafeResume call failed ");
                }

                @Override // am2.a
                public void b() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this);
                        return;
                    }
                    QLog.e("NTRegisterSafetyCheckUtil", 1, "requestFriendGuarantee onException");
                    CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<String>> cancellableContinuation = this.f280494a;
                    com.tencent.mobileqq.register.ntregister.a aVar = new com.tencent.mobileqq.register.ntregister.a(-1, "guarantee exception", "");
                    if (cancellableContinuation.isActive()) {
                        cancellableContinuation.resumeWith(Result.m476constructorimpl(aVar));
                        return;
                    }
                    QLog.e("NTLogin", 1, "guarantee exceptionsafeResume call failed ");
                }

                @Override // am2.a
                public void onCancel() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, (Object) this);
                        return;
                    }
                    QLog.e("NTRegisterSafetyCheckUtil", 1, "requestFriendGuarantee onCancel");
                    CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<String>> cancellableContinuation = this.f280494a;
                    com.tencent.mobileqq.register.ntregister.a aVar = new com.tencent.mobileqq.register.ntregister.a(-1, "guarantee cancel", "");
                    if (cancellableContinuation.isActive()) {
                        cancellableContinuation.resumeWith(Result.m476constructorimpl(aVar));
                        return;
                    }
                    QLog.e("NTLogin", 1, "guarantee cancelsafeResume call failed ");
                }

                @Override // am2.a
                public void onResult(boolean result, @Nullable Bundle data) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(result), data);
                    } else {
                        QLog.d("NTRegisterSafetyCheckUtil", 1, "onResult requestFriendGuarantee callback");
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Multi-variable type inference failed */
            {
                this.f280492e = registerIdentityLimit;
                this.f280493f = cancellableContinuationImpl;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, QBaseActivity.this, registerIdentityLimit, cancellableContinuationImpl);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                QBaseActivity qBaseActivity2 = QBaseActivity.this;
                RegisterIdentityLimit registerIdentityLimit2 = this.f280492e;
                int i3 = registerIdentityLimit2.type;
                i.a(qBaseActivity2, i3, registerIdentityLimit2.handleUrl, i3, new a(this.f280493f));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Nullable
    public final Object e(@NotNull final String str, @NotNull Continuation<? super a<Iframe>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            QLog.d("NTRegisterSafetyCheckUtil", 1, "startPuzzleVerify url: " + str);
            f280486a.i(new Runnable(str, cancellableContinuationImpl) { // from class: com.tencent.mobileqq.register.ntregister.NTRegisterSafetyCheckUtil$requestPuzzleVerify$2$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f280495d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<Iframe>> f280496e;

                @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/register/ntregister/NTRegisterSafetyCheckUtil$requestPuzzleVerify$2$1$a", "Lcom/tencent/mobileqq/login/verify/PuzzleVerifyComponent$b;", "", "result", "", "ticket", "randStr", "appId", "", "b", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes17.dex */
                public static final class a implements PuzzleVerifyComponent.b {
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ String f280497a;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<Iframe>> f280498b;

                    /* JADX WARN: Multi-variable type inference failed */
                    a(String str, CancellableContinuation<? super com.tencent.mobileqq.register.ntregister.a<Iframe>> cancellableContinuation) {
                        this.f280497a = str;
                        this.f280498b = cancellableContinuation;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) cancellableContinuation);
                        }
                    }

                    @Override // com.tencent.mobileqq.login.verify.PuzzleVerifyComponent.b
                    public void a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this);
                            return;
                        }
                        QLog.i("NTRegisterSafetyCheckUtil", 1, "PuzzleVerify cancel");
                        CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<Iframe>> cancellableContinuation = this.f280498b;
                        com.tencent.mobileqq.register.ntregister.a aVar = new com.tencent.mobileqq.register.ntregister.a(-1, "puzzle verify cancel", null);
                        if (cancellableContinuation.isActive()) {
                            cancellableContinuation.resumeWith(Result.m476constructorimpl(aVar));
                            return;
                        }
                        QLog.e("NTLogin", 1, "new puzzle verifysafeResume call failed ");
                    }

                    @Override // com.tencent.mobileqq.login.verify.PuzzleVerifyComponent.b
                    public void b(boolean result, @Nullable String ticket, @Nullable String randStr, @Nullable String appId) {
                        byte[] bArr;
                        byte[] bArr2;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(result), ticket, randStr, appId);
                            return;
                        }
                        QLog.i("NTRegisterSafetyCheckUtil", 1, "PuzzleVerify result=" + result);
                        Iframe iframe = new Iframe();
                        if (ticket != null) {
                            bArr = ticket.getBytes(Charsets.UTF_8);
                            Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
                        } else {
                            bArr = null;
                        }
                        iframe.iframeSig = bArr;
                        if (randStr != null) {
                            bArr2 = randStr.getBytes(Charsets.UTF_8);
                            Intrinsics.checkNotNullExpressionValue(bArr2, "this as java.lang.String).getBytes(charset)");
                        } else {
                            bArr2 = null;
                        }
                        iframe.iframeRandstr = bArr2;
                        String b16 = NTRegisterSafetyCheckUtil.f280486a.b(this.f280497a, "sid");
                        if (b16 == null) {
                            b16 = "test";
                        }
                        byte[] bytes = b16.getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                        iframe.iframeSid = bytes;
                        CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<Iframe>> cancellableContinuation = this.f280498b;
                        com.tencent.mobileqq.register.ntregister.a aVar = new com.tencent.mobileqq.register.ntregister.a(10000, null, iframe);
                        if (cancellableContinuation.isActive()) {
                            cancellableContinuation.resumeWith(Result.m476constructorimpl(aVar));
                            return;
                        }
                        QLog.e("NTLogin", 1, "new puzzle verifysafeResume call failed ");
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.f280495d = str;
                    this.f280496e = cancellableContinuationImpl;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) str, (Object) cancellableContinuationImpl);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    PuzzleVerifyComponent puzzleVerifyComponent = new PuzzleVerifyComponent();
                    String str2 = this.f280495d;
                    puzzleVerifyComponent.d(3, str2, new a(str2, this.f280496e));
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) continuation);
    }

    @Nullable
    public final Object f(@NotNull RegisterIdentityRsp registerIdentityRsp, @Nullable Bundle bundle, @NotNull Continuation<? super a<RegisterVerifyResult>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            final int i3 = 6;
            cb.g("0X800C3B3");
            final Bundle bundle2 = new Bundle();
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            bundle2.putByteArray(AppConstants.Key.KEY_NT_REGISTER_CONTEXT, registerIdentityRsp.context);
            final String string = bundle2.getString("key_phone_num", "");
            final String string2 = bundle2.getString("key_country_code", "");
            f280486a.i(new Runnable(i3, string, string2, bundle2, cancellableContinuationImpl) { // from class: com.tencent.mobileqq.register.ntregister.NTRegisterSafetyCheckUtil$requestSMSVerify$2$2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f280499d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f280500e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f280501f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ Bundle f280502h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<RegisterVerifyResult>> f280503i;

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/register/ntregister/NTRegisterSafetyCheckUtil$requestSMSVerify$2$2$a", "Lcom/tencent/mobileqq/loginregister/sms/SmsVerifyComponent$e;", "Landroid/os/Bundle;", "extra", "", "b", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes17.dex */
                public static final class a extends SmsVerifyComponent.e {
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<RegisterVerifyResult>> f280504a;

                    /* JADX WARN: Multi-variable type inference failed */
                    a(CancellableContinuation<? super com.tencent.mobileqq.register.ntregister.a<RegisterVerifyResult>> cancellableContinuation) {
                        this.f280504a = cancellableContinuation;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuation);
                        }
                    }

                    @Override // com.tencent.mobileqq.loginregister.sms.SmsVerifyComponent.f
                    public void a(@Nullable Bundle extra) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this, (Object) extra);
                            return;
                        }
                        QLog.i("NTRegisterSafetyCheckUtil", 1, "smsVerify user cancel");
                        cb.f("0X800C3B4", "0X800C3B3", 2, "");
                        CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<RegisterVerifyResult>> cancellableContinuation = this.f280504a;
                        com.tencent.mobileqq.register.ntregister.a aVar = new com.tencent.mobileqq.register.ntregister.a(-1, "smsVerify user cancel", null);
                        if (cancellableContinuation.isActive()) {
                            cancellableContinuation.resumeWith(Result.m476constructorimpl(aVar));
                            return;
                        }
                        QLog.e("NTLogin", 1, "smsVerify user cancelsafeResume call failed ");
                    }

                    @Override // com.tencent.mobileqq.loginregister.sms.SmsVerifyComponent.f
                    public void b(@Nullable Bundle extra) {
                        RegisterVerifyResult registerVerifyResult;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) extra);
                            return;
                        }
                        QLog.d("NTRegisterSafetyCheckUtil", 1, "smsVerify onSuccess");
                        String str = null;
                        if (extra != null) {
                            registerVerifyResult = (RegisterVerifyResult) extra.getParcelable("key_verify_result");
                        } else {
                            registerVerifyResult = null;
                        }
                        if (registerVerifyResult != null) {
                            str = registerVerifyResult.f242904f;
                        }
                        if (TextUtils.isEmpty(str)) {
                            CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<RegisterVerifyResult>> cancellableContinuation = this.f280504a;
                            com.tencent.mobileqq.register.ntregister.a aVar = new com.tencent.mobileqq.register.ntregister.a(10000, "success", registerVerifyResult);
                            if (cancellableContinuation.isActive()) {
                                cancellableContinuation.resumeWith(Result.m476constructorimpl(aVar));
                            } else {
                                QLog.e("NTLogin", 1, "need unbind accountsafeResume call failed ");
                            }
                        } else {
                            CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<RegisterVerifyResult>> cancellableContinuation2 = this.f280504a;
                            com.tencent.mobileqq.register.ntregister.a aVar2 = new com.tencent.mobileqq.register.ntregister.a(10001, "need unbind account", registerVerifyResult);
                            if (cancellableContinuation2.isActive()) {
                                cancellableContinuation2.resumeWith(Result.m476constructorimpl(aVar2));
                            } else {
                                QLog.e("NTLogin", 1, "need unbind accountsafeResume call failed ");
                            }
                        }
                        cb.f("0X800C3B4", "0X800C3B3", 0, "");
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f280499d = i3;
                    this.f280500e = string;
                    this.f280501f = string2;
                    this.f280502h = bundle2;
                    this.f280503i = cancellableContinuationImpl;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, Integer.valueOf(i3), string, string2, bundle2, cancellableContinuationImpl);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        SmsVerifyComponent.e(this.f280499d, this.f280500e, this.f280501f, this.f280502h, new a(this.f280503i));
                    }
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 4, this, registerIdentityRsp, bundle, continuation);
    }

    @Nullable
    public final Object g(@NotNull final QBaseActivity qBaseActivity, @NotNull final String str, @NotNull Continuation<? super a<String>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, qBaseActivity, str, continuation);
        }
        QLog.d("NTRegisterSafetyCheckUtil", 1, "onCheckGatewayRegister gotoPhoneProtectUinsUrl");
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        f280486a.i(new Runnable(str, cancellableContinuationImpl) { // from class: com.tencent.mobileqq.register.ntregister.NTRegisterSafetyCheckUtil$requestUnbindUin$2$1
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f280506e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<String>> f280507f;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/register/ntregister/NTRegisterSafetyCheckUtil$requestUnbindUin$2$1$a", "Lcom/tencent/mobileqq/register/o$a;", "", "onSuccess", "onCancel", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes17.dex */
            public static final class a implements o.a {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<String>> f280508a;

                /* JADX WARN: Multi-variable type inference failed */
                a(CancellableContinuation<? super com.tencent.mobileqq.register.ntregister.a<String>> cancellableContinuation) {
                    this.f280508a = cancellableContinuation;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuation);
                    }
                }

                @Override // com.tencent.mobileqq.register.o.a
                public void onCancel() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this);
                        return;
                    }
                    CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<String>> cancellableContinuation = this.f280508a;
                    com.tencent.mobileqq.register.ntregister.a aVar = new com.tencent.mobileqq.register.ntregister.a(-1, "user canceled", null);
                    if (cancellableContinuation.isActive()) {
                        cancellableContinuation.resumeWith(Result.m476constructorimpl(aVar));
                        return;
                    }
                    QLog.e("NTLogin", 1, "user canceledsafeResume call failed ");
                }

                @Override // com.tencent.mobileqq.register.o.a
                public void onSuccess() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    QLog.d("NTRegisterSafetyCheckUtil", 1, "gotoPhoneProtectUinUrl onSuccess");
                    CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<String>> cancellableContinuation = this.f280508a;
                    com.tencent.mobileqq.register.ntregister.a aVar = new com.tencent.mobileqq.register.ntregister.a(10000, "gotoPhoneProtectUinUrl onSuccess", null);
                    if (cancellableContinuation.isActive()) {
                        cancellableContinuation.resumeWith(Result.m476constructorimpl(aVar));
                        return;
                    }
                    QLog.e("NTLogin", 1, "unbind onSuccesssafeResume call failed ");
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Multi-variable type inference failed */
            {
                this.f280506e = str;
                this.f280507f = cancellableContinuationImpl;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, QBaseActivity.this, str, cancellableContinuationImpl);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    o.a(QBaseActivity.this, this.f280506e, new a(this.f280507f));
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Nullable
    public final Object h(@NotNull RegisterIdentityRsp registerIdentityRsp, @NotNull Continuation<? super a<RegisterVerifyResult>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            QLog.d("NTRegisterSafetyCheckUtil", 1, "requestUpSmsVerify");
            final int i3 = 4;
            cb.g("0X800C3B3");
            final Bundle bundle = new Bundle();
            bundle.putString(AppConstants.Key.KEY_REGISTER_PROMPT_UPMSG, registerIdentityRsp.limit.upSmsInfo.content);
            bundle.putString(AppConstants.Key.KEY_REGISTER_PROMPT_PHONE, registerIdentityRsp.limit.upSmsInfo.maskPhone);
            bundle.putString(AppConstants.Key.KEY_REGISTER_PROMPT_UPSMS_PORT, registerIdentityRsp.limit.upSmsInfo.port);
            bundle.putString(AppConstants.Key.KEY_REGISTER_PROMPT_TEXT, registerIdentityRsp.limit.upSmsInfo.prompt);
            bundle.putString(AppConstants.Key.KEY_REGISTER_TIPS, registerIdentityRsp.limit.upSmsInfo.tips);
            bundle.putByteArray(AppConstants.Key.KEY_NT_REGISTER_CONTEXT, registerIdentityRsp.context);
            bundle.putInt(AppConstants.Key.KEY_REGISTER_FROM, 7);
            final String string = bundle.getString("key_phone_num", "");
            final String string2 = bundle.getString("key_country_code", "");
            f280486a.i(new Runnable(i3, string, string2, bundle, cancellableContinuationImpl) { // from class: com.tencent.mobileqq.register.ntregister.NTRegisterSafetyCheckUtil$requestUpSmsVerify$2$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f280509d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f280510e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f280511f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ Bundle f280512h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<RegisterVerifyResult>> f280513i;

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/register/ntregister/NTRegisterSafetyCheckUtil$requestUpSmsVerify$2$1$a", "Lcom/tencent/mobileqq/loginregister/sms/SmsVerifyComponent$e;", "Landroid/os/Bundle;", "extra", "", "b", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes17.dex */
                public static final class a extends SmsVerifyComponent.e {
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<RegisterVerifyResult>> f280514a;

                    /* JADX WARN: Multi-variable type inference failed */
                    a(CancellableContinuation<? super com.tencent.mobileqq.register.ntregister.a<RegisterVerifyResult>> cancellableContinuation) {
                        this.f280514a = cancellableContinuation;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuation);
                        }
                    }

                    @Override // com.tencent.mobileqq.loginregister.sms.SmsVerifyComponent.f
                    public void a(@Nullable Bundle extra) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this, (Object) extra);
                            return;
                        }
                        QLog.i("NTRegisterSafetyCheckUtil", 1, "smsVerify user cancel");
                        CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<RegisterVerifyResult>> cancellableContinuation = this.f280514a;
                        com.tencent.mobileqq.register.ntregister.a aVar = new com.tencent.mobileqq.register.ntregister.a(-1, "smsVerify user cancel", null);
                        if (cancellableContinuation.isActive()) {
                            cancellableContinuation.resumeWith(Result.m476constructorimpl(aVar));
                        } else {
                            QLog.e("NTLogin", 1, "smsVerify user cancelsafeResume call failed ");
                        }
                        cb.f("0X800C3B4", "0X800C3B3", 2, "");
                    }

                    @Override // com.tencent.mobileqq.loginregister.sms.SmsVerifyComponent.f
                    public void b(@Nullable Bundle extra) {
                        RegisterVerifyResult registerVerifyResult;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) extra);
                            return;
                        }
                        QLog.d("NTRegisterSafetyCheckUtil", 1, "smsVerify onSuccess");
                        String str = null;
                        if (extra != null) {
                            registerVerifyResult = (RegisterVerifyResult) extra.getParcelable("key_verify_result");
                        } else {
                            registerVerifyResult = null;
                        }
                        if (registerVerifyResult != null) {
                            str = registerVerifyResult.f242904f;
                        }
                        if (TextUtils.isEmpty(str)) {
                            CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<RegisterVerifyResult>> cancellableContinuation = this.f280514a;
                            com.tencent.mobileqq.register.ntregister.a aVar = new com.tencent.mobileqq.register.ntregister.a(10000, "success", registerVerifyResult);
                            if (cancellableContinuation.isActive()) {
                                cancellableContinuation.resumeWith(Result.m476constructorimpl(aVar));
                            } else {
                                QLog.e("NTLogin", 1, "need unbind accountsafeResume call failed ");
                            }
                        } else {
                            CancellableContinuation<com.tencent.mobileqq.register.ntregister.a<RegisterVerifyResult>> cancellableContinuation2 = this.f280514a;
                            com.tencent.mobileqq.register.ntregister.a aVar2 = new com.tencent.mobileqq.register.ntregister.a(10001, "need unbind account", registerVerifyResult);
                            if (cancellableContinuation2.isActive()) {
                                cancellableContinuation2.resumeWith(Result.m476constructorimpl(aVar2));
                            } else {
                                QLog.e("NTLogin", 1, "need unbind accountsafeResume call failed ");
                            }
                        }
                        cb.f("0X800C3B4", "0X800C3B3", 0, "");
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f280509d = i3;
                    this.f280510e = string;
                    this.f280511f = string2;
                    this.f280512h = bundle;
                    this.f280513i = cancellableContinuationImpl;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, Integer.valueOf(i3), string, string2, bundle, cancellableContinuationImpl);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        SmsVerifyComponent.e(this.f280509d, this.f280510e, this.f280511f, this.f280512h, new a(this.f280513i));
                    }
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 3, (Object) this, (Object) registerIdentityRsp, (Object) continuation);
    }
}

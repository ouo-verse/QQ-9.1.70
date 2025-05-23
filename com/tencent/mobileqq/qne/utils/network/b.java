package com.tencent.mobileqq.qne.utils.network;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qne.utils.network.QneRequestHandler;
import com.tencent.mobileqq.qne.utils.network.f;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001j\u0002`\u0004B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0096B\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qne/utils/network/b;", "", "Lcom/tencent/mobileqq/qne/utils/network/c;", "Lcom/tencent/mobileqq/qne/utils/network/f;", "Lcom/tencent/mobileqq/qne/utils/network/IQneOidbRequest;", "req", "a", "(Lcom/tencent/mobileqq/qne/utils/network/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "qne-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f262083a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qne/utils/network/b$a", "Lcom/tencent/mobileqq/qne/utils/network/a;", "", "ssoErrorCode", "trpcErrorCode", "", "trpcErrorMsg", "", "rspData", "", "onResponse", "qne-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a implements com.tencent.mobileqq.qne.utils.network.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<f<?>> f262084a;

        /* JADX WARN: Multi-variable type inference failed */
        a(CancellableContinuation<? super f<?>> cancellableContinuation) {
            this.f262084a = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuation);
            }
        }

        @Override // com.tencent.mobileqq.qne.utils.network.a
        public void onResponse(int ssoErrorCode, int trpcErrorCode, @Nullable String trpcErrorMsg, @Nullable Object rspData) {
            byte[] bArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(ssoErrorCode), Integer.valueOf(trpcErrorCode), trpcErrorMsg, rspData);
                return;
            }
            byte[] bArr2 = (byte[]) rspData;
            if (bArr2 != null) {
                bArr = QneRequestHandler.INSTANCE.e(bArr2);
            } else {
                bArr = null;
            }
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            Intrinsics.checkNotNull(bArr, "null cannot be cast to non-null type kotlin.ByteArray");
            oidb_sso_oidbssopkg.mergeFrom(bArr);
            this.f262084a.resumeWith(Result.m476constructorimpl(new f.a(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray(), ssoErrorCode, trpcErrorCode, trpcErrorMsg)));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22404);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f262083a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public Object a(@NotNull c cVar, @NotNull Continuation<? super f<?>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            QneRequestHandler.Companion companion = QneRequestHandler.INSTANCE;
            QneRequestHandler c16 = companion.c();
            if (c16 == null) {
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new RuntimeException("QneRequestHandler null"))));
            } else {
                try {
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    oidb_sso_oidbssopkg.uint32_command.set(cVar.c());
                    oidb_sso_oidbssopkg.uint32_service_type.set(cVar.d());
                    oidb_sso_oidbssopkg.uint32_result.set(0);
                    oidb_sso_oidbssopkg.str_client_version.set(AppSetting.n());
                    oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(cVar.b()));
                    c16.F2(cVar.a(), companion.d(oidb_sso_oidbssopkg), new a(cancellableContinuationImpl));
                } catch (Throwable th5) {
                    Result.Companion companion3 = Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(th5)));
                }
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar, (Object) continuation);
    }
}

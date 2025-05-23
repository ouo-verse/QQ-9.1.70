package com.tencent.mobileqq.qne.utils.network;

import NS_QWEB_PROTOCAL.PROTOCAL;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qne.utils.network.QneRequestHandler;
import com.tencent.mobileqq.qne.utils.network.f;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001j\u0002`\u0004B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0096B\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qne/utils/network/d;", "", "Lcom/tencent/mobileqq/qne/utils/network/e;", "Lcom/tencent/mobileqq/qne/utils/network/f;", "Lcom/tencent/mobileqq/qne/utils/network/IQneRequest;", "req", "a", "(Lcom/tencent/mobileqq/qne/utils/network/e;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "qne-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f262087a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qne/utils/network/d$a", "Lcom/tencent/mobileqq/qne/utils/network/a;", "", "ssoErrorCode", "trpcErrorCode", "", "trpcErrorMsg", "", "rspData", "", "onResponse", "qne-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a implements com.tencent.mobileqq.qne.utils.network.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<f<?>> f262088a;

        /* JADX WARN: Multi-variable type inference failed */
        a(CancellableContinuation<? super f<?>> cancellableContinuation) {
            this.f262088a = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuation);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
        @Override // com.tencent.mobileqq.qne.utils.network.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResponse(int ssoErrorCode, int trpcErrorCode, @Nullable String trpcErrorMsg, @Nullable Object rspData) {
            byte[] bArr;
            IntRange until;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(ssoErrorCode), Integer.valueOf(trpcErrorCode), trpcErrorMsg, rspData);
                return;
            }
            byte[] bArr2 = null;
            if (rspData instanceof byte[]) {
                byte[] bArr3 = (byte[]) rspData;
                if (bArr3.length > 4) {
                    until = RangesKt___RangesKt.until(4, bArr3.length);
                    bArr = ArraysKt___ArraysKt.sliceArray(bArr3, until);
                    if (bArr != null) {
                        PROTOCAL.StQWebRsp mergeFrom = new PROTOCAL.StQWebRsp().mergeFrom(bArr);
                        mergeFrom.retCode.get();
                        mergeFrom.errMsg.get().toStringUtf8();
                        bArr2 = mergeFrom.busiBuff.get().toByteArray();
                    }
                    this.f262088a.resumeWith(Result.m476constructorimpl(new f.a(bArr2, ssoErrorCode, trpcErrorCode, trpcErrorMsg)));
                }
            }
            bArr = null;
            if (bArr != null) {
            }
            this.f262088a.resumeWith(Result.m476constructorimpl(new f.a(bArr2, ssoErrorCode, trpcErrorCode, trpcErrorMsg)));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22475);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f262087a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public Object a(@NotNull e eVar, @NotNull Continuation<? super f<?>> continuation) {
        Continuation intercepted;
        byte[] bArr;
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
                    String a16 = eVar.a();
                    byte[] b16 = eVar.b();
                    if (b16 != null) {
                        bArr = companion.f(b16);
                    } else {
                        bArr = null;
                    }
                    c16.F2(a16, bArr, new a(cancellableContinuationImpl));
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
        return iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar, (Object) continuation);
    }
}

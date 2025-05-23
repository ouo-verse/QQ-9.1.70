package com.tencent.mobileqq.sharepanel.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.sharepanel.model.ShareConfirmAction;
import com.tencent.mobileqq.sharepanel.o;
import com.tencent.mobileqq.sharepanel.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ%\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/util/ShareConfirmUtil;", "", "Lcom/tencent/mobileqq/sharepanel/p;", "checker", "Lcom/tencent/mobileqq/sharepanel/model/ShareConfirmAction;", "action", "", "a", "(Lcom/tencent/mobileqq/sharepanel/p;Lcom/tencent/mobileqq/sharepanel/model/ShareConfirmAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ShareConfirmUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ShareConfirmUtil f287597a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42867);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f287597a = new ShareConfirmUtil();
        }
    }

    ShareConfirmUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final Object a(@Nullable p pVar, @NotNull ShareConfirmAction shareConfirmAction, @NotNull Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Unit unit;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            if (pVar != null) {
                pVar.a(shareConfirmAction, new o(cancellableContinuationImpl) { // from class: com.tencent.mobileqq.sharepanel.util.ShareConfirmUtil$confirm$2$1
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ CancellableContinuation<Boolean> f287598a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        this.f287598a = cancellableContinuationImpl;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) cancellableContinuationImpl);
                        }
                    }

                    @Override // com.tencent.mobileqq.sharepanel.o
                    public void a() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                            iPatchRedirector2.redirect((short) 3, (Object) this);
                        } else {
                            this.f287598a.resume(Boolean.FALSE, ShareConfirmUtil$confirm$2$1$onRejected$1.INSTANCE);
                        }
                    }

                    @Override // com.tencent.mobileqq.sharepanel.o
                    public void b() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            this.f287598a.resume(Boolean.TRUE, ShareConfirmUtil$confirm$2$1$onConfirmed$1.INSTANCE);
                        }
                    }
                });
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                cancellableContinuationImpl.resume(Boxing.boxBoolean(true), ShareConfirmUtil$confirm$2$2$1.INSTANCE);
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 2, this, pVar, shareConfirmAction, continuation);
    }
}

package com.tencent.mobileqq.qroute.route;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TypeCastException;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qroute/route/QRouteThreadDispatcher;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/ContinuationInterceptor;", "InnerContinuation", "QRoute_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes17.dex */
public final class QRouteThreadDispatcher extends AbstractCoroutineContextElement implements ContinuationInterceptor {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003J \u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\u0006H\u0016R\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR!\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00f8\u0001\u0000\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qroute/route/QRouteThreadDispatcher$InnerContinuation;", "T", "Lkotlin/coroutines/Continuation;", "Ljava/lang/Runnable;", "Lkotlin/Result;", "result", "", "resumeWith", "(Ljava/lang/Object;)V", TencentLocation.RUN_MODE, "Lkotlin/coroutines/CoroutineContext;", "d", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "e", "Lkotlin/Result;", "f", "Lkotlin/coroutines/Continuation;", TtmlNode.ATTR_TTS_ORIGIN, "QRoute_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes17.dex */
    public final class InnerContinuation<T> implements Continuation<T>, Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CoroutineContext context;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private Result<? extends T> result;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final Continuation<T> origin;
        final /* synthetic */ QRouteThreadDispatcher this$0;

        @Override // kotlin.coroutines.Continuation
        @NotNull
        /* renamed from: getContext */
        public CoroutineContext get$context() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (CoroutineContext) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return this.context;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(@NotNull Object result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, result);
            } else {
                this.result = Result.m475boximpl(result);
                QRouteThreadDispatcher.a(null).submit(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            Continuation<T> continuation = this.origin;
            Result<? extends T> result = this.result;
            if (result != null) {
                continuation.resumeWith(result.getValue());
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Result<T>");
        }
    }

    public static final /* synthetic */ ExecutorService a(QRouteThreadDispatcher qRouteThreadDispatcher) {
        throw null;
    }
}

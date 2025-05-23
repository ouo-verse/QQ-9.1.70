package com.tencent.mvi.runtime.strategy;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u0003\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u001d\u0010\u0007\u001a\u0004\u0018\u00018\u00008FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "T", "", "a", "()Ljava/lang/Object;", "Lkotlin/Lazy;", "b", "service", "<init>", "()V", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public abstract class IStrategyFetcher<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Lazy service;

    public IStrategyFetcher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.service = LazyKt.lazy(new Function0<T>() { // from class: com.tencent.mvi.runtime.strategy.IStrategyFetcher$service$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) IStrategyFetcher.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final T invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        return (T) iPatchRedirector2.redirect((short) 1, (Object) this);
                    }
                    return (T) IStrategyFetcher.this.a();
                }
            });
        }
    }

    @Nullable
    public abstract T a();

    @Nullable
    public final T b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (T) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return (T) this.service.getValue();
    }
}

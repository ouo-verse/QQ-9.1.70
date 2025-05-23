package com.tencent.aio.runtime.emitter;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.runtime.lifeobserver.LifeCycleWrapperObserver;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\r\u001a\u00020\u00042\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/aio/runtime/emitter/AIOFunctionEmitter;", "T", "Lml3/a;", "callback", "", "a", "(Ljava/lang/Object;)V", "", "c", "(Ljava/lang/Object;)Z", "Lkotlin/Function1;", "", "dispatcher", "d", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "b", "(Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;)V", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mFunctionsCallBacks", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public abstract class AIOFunctionEmitter<T> implements ml3.a<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CopyOnWriteArrayList<T> mFunctionsCallBacks;

    public AIOFunctionEmitter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mFunctionsCallBacks = new CopyOnWriteArrayList<>();
        }
    }

    @Override // ml3.a
    public void a(T callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) callback);
        } else {
            if (this.mFunctionsCallBacks.contains(callback)) {
                return;
            }
            this.mFunctionsCallBacks.add(callback);
        }
    }

    @Override // ml3.a
    public void b(final T callback, @NotNull final LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) callback, (Object) lifecycleOwner);
            return;
        }
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        LifeCycleWrapperObserver lifeCycleWrapperObserver = new LifeCycleWrapperObserver(callback, lifecycleOwner, lifecycleOwner) { // from class: com.tencent.aio.runtime.emitter.AIOFunctionEmitter$addCallBack$lifeObserver$1
            static IPatchRedirector $redirector_;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Object f69815f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ LifecycleOwner f69816h;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(lifecycleOwner);
                this.f69815f = callback;
                this.f69816h = lifecycleOwner;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, AIOFunctionEmitter.this, callback, lifecycleOwner, lifecycleOwner);
                }
            }

            @Override // com.tencent.mvi.runtime.lifeobserver.LifeCycleWrapperObserver
            public void onDestroy() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                } else {
                    AIOFunctionEmitter.this.c(this.f69815f);
                }
            }
        };
        if (!lifeCycleWrapperObserver.a()) {
            return;
        }
        lifecycleOwner.getLifecycle().addObserver(lifeCycleWrapperObserver);
        a(callback);
    }

    @Override // ml3.a
    public boolean c(T callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) callback)).booleanValue();
        }
        if (this.mFunctionsCallBacks.contains(callback)) {
            this.mFunctionsCallBacks.remove(callback);
            return true;
        }
        return false;
    }

    public final void d(@NotNull Function1<? super T, ? extends Object> dispatcher) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dispatcher);
            return;
        }
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Iterator<T> it = this.mFunctionsCallBacks.iterator();
        while (it.hasNext()) {
            Intrinsics.areEqual(dispatcher.invoke(it.next()), Boolean.TRUE);
        }
    }
}

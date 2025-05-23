package com.tencent.aio.api.frame;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.aio.runtime.emitter.AIOFunctionEmitter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\f\b\u0001\u0010\u0004*\u0006\u0012\u0002\b\u00030\u00032\u00020\u0005B\u0007\u00a2\u0006\u0004\b%\u0010\u0018J\u001a\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0004\u0012\u00028\u00010\u0006H&J\u0017\u0010\u000b\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\tH&\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H&\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000eH\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001b\u0010$\u001a\u00028\u00008@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006&"}, d2 = {"Lcom/tencent/aio/api/frame/IAIOFramesProvider;", "Landroid/view/ViewGroup;", "T", "Lcom/tencent/aio/runtime/emitter/AIOFunctionEmitter;", "Controller", "", "Lkotlin/Pair;", "Ljava/lang/Class;", "d", "Landroid/content/Context;", "context", "g", "(Landroid/content/Context;)Landroid/view/ViewGroup;", "containerView", "", "f", "(Landroid/view/ViewGroup;)V", "Landroid/view/View;", "chatFrame", "Lcom/tencent/aio/api/frame/a;", "framesConfig", h.F, "(Landroid/view/ViewGroup;Landroid/view/View;Lcom/tencent/aio/api/frame/a;)V", "a", "()V", "main", "e", "(Landroid/view/View;Lcom/tencent/aio/api/frame/a;)V", "Landroid/content/Context;", "b", "()Landroid/content/Context;", "i", "(Landroid/content/Context;)V", "Lkotlin/Lazy;", "c", "()Landroid/view/ViewGroup;", "frameContainerView", "<init>", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public abstract class IAIOFramesProvider<T extends ViewGroup, Controller extends AIOFunctionEmitter<?>> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy frameContainerView;

    public IAIOFramesProvider() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<T>() { // from class: com.tencent.aio.api.frame.IAIOFramesProvider$frameContainerView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) IAIOFramesProvider.this);
                    }
                }

                /* JADX WARN: Incorrect return type in method signature: ()TT; */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final ViewGroup invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        return (ViewGroup) iPatchRedirector2.redirect((short) 1, (Object) this);
                    }
                    IAIOFramesProvider iAIOFramesProvider = IAIOFramesProvider.this;
                    return iAIOFramesProvider.g(iAIOFramesProvider.b());
                }
            });
            this.frameContainerView = lazy;
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            c().removeAllViewsInLayout();
            f(c());
        }
    }

    @NotNull
    public final Context b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Context) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        Context context = this.context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        }
        return context;
    }

    @NotNull
    public final T c() {
        Object value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            value = iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            value = this.frameContainerView.getValue();
        }
        return (T) value;
    }

    @NotNull
    public abstract Pair<Class<Controller>, Controller> d();

    public final void e(@NotNull View main, @NotNull a framesConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) main, (Object) framesConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(main, "main");
        Intrinsics.checkNotNullParameter(framesConfig, "framesConfig");
        if (Intrinsics.areEqual(main.getParent(), c())) {
            return;
        }
        ViewParent parent = main.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            viewGroup.removeView(main);
        }
        h(c(), main, framesConfig);
    }

    public abstract void f(@NotNull T containerView);

    @NotNull
    public abstract T g(@NotNull Context context);

    public abstract void h(@NotNull T containerView, @NotNull View chatFrame, @NotNull a framesConfig);

    public final void i(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            this.context = context;
        }
    }
}

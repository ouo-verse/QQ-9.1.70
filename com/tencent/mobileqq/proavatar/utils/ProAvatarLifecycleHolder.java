package com.tencent.mobileqq.proavatar.utils;

import android.os.Looper;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewKt;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/proavatar/utils/ProAvatarLifecycleHolder;", "", "Landroid/view/View;", "view", "Landroidx/lifecycle/LifecycleObserver;", "observer", "", "tag", "", "e", "d", "Landroidx/lifecycle/LifecycleOwner;", "a", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "<init>", "()V", "b", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class ProAvatarLifecycleHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f259703c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LifecycleOwner lifecycleOwner;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/proavatar/utils/ProAvatarLifecycleHolder$a;", "", "", "leakFixSwitch$delegate", "Lkotlin/Lazy;", "a", "()Z", "leakFixSwitch", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.proavatar.utils.ProAvatarLifecycleHolder$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return ((Boolean) ProAvatarLifecycleHolder.f259703c.getValue()).booleanValue();
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
        Lazy<Boolean> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33957);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(ProAvatarLifecycleHolder$Companion$leakFixSwitch$2.INSTANCE);
        f259703c = lazy;
    }

    public ProAvatarLifecycleHolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            this.lifecycleOwner = null;
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.proavatar.utils.ProAvatarLifecycleHolder$onDestroy$$inlined$runOnUiThread$1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProAvatarLifecycleHolder.this);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        ProAvatarLifecycleHolder.this.lifecycleOwner = null;
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public final void e(@NotNull final View view, @NotNull final LifecycleObserver observer, @NotNull String tag) {
        Lifecycle lifecycle;
        Lifecycle lifecycle2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, view, observer, tag);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            LifecycleOwner findViewTreeLifecycleOwner = ViewKt.findViewTreeLifecycleOwner(view);
            if (findViewTreeLifecycleOwner != null) {
                if (this.lifecycleOwner != null) {
                    if (!Intrinsics.areEqual(this.lifecycleOwner, findViewTreeLifecycleOwner)) {
                        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
                        if (lifecycleOwner != null && (lifecycle2 = lifecycleOwner.getLifecycle()) != null) {
                            lifecycle2.removeObserver(observer);
                        }
                    } else {
                        return;
                    }
                }
                this.lifecycleOwner = findViewTreeLifecycleOwner;
                LifecycleOwner lifecycleOwner2 = this.lifecycleOwner;
                if (lifecycleOwner2 != null && (lifecycle = lifecycleOwner2.getLifecycle()) != null) {
                    lifecycle.addObserver(observer);
                    return;
                }
                return;
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(view, this, observer) { // from class: com.tencent.mobileqq.proavatar.utils.ProAvatarLifecycleHolder$update$$inlined$runOnUiThread$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f259705d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ LifecycleObserver f259706e;
            final /* synthetic */ ProAvatarLifecycleHolder this$0;

            {
                this.f259705d = view;
                this.this$0 = this;
                this.f259706e = observer;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, view, this, observer);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                Lifecycle lifecycle3;
                Lifecycle lifecycle4;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                LifecycleOwner findViewTreeLifecycleOwner2 = ViewKt.findViewTreeLifecycleOwner(this.f259705d);
                if (findViewTreeLifecycleOwner2 != null) {
                    if (this.this$0.lifecycleOwner != null) {
                        if (!Intrinsics.areEqual(this.this$0.lifecycleOwner, findViewTreeLifecycleOwner2)) {
                            LifecycleOwner lifecycleOwner3 = this.this$0.lifecycleOwner;
                            if (lifecycleOwner3 != null && (lifecycle4 = lifecycleOwner3.getLifecycle()) != null) {
                                lifecycle4.removeObserver(this.f259706e);
                            }
                        } else {
                            return;
                        }
                    }
                    this.this$0.lifecycleOwner = findViewTreeLifecycleOwner2;
                    LifecycleOwner lifecycleOwner4 = this.this$0.lifecycleOwner;
                    if (lifecycleOwner4 != null && (lifecycle3 = lifecycleOwner4.getLifecycle()) != null) {
                        lifecycle3.addObserver(this.f259706e);
                    }
                }
            }
        });
    }
}

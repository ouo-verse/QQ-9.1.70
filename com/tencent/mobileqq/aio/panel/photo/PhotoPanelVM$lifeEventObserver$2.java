package com.tencent.mobileqq.aio.panel.photo;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LifecycleEventObserver;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class PhotoPanelVM$lifeEventObserver$2 extends Lambda implements Function0<LifecycleEventObserver> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ PhotoPanelVM this$0;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f193072a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64521);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f193072a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoPanelVM$lifeEventObserver$2(PhotoPanelVM photoPanelVM) {
        super(0);
        this.this$0 = photoPanelVM;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) photoPanelVM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PhotoPanelVM this$0, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i3 = a.f193072a[event.ordinal()];
        if (i3 == 1) {
            this$0.T();
            return;
        }
        if (i3 == 2) {
            z16 = this$0.isPanelShow;
            if (z16) {
                this$0.X();
                return;
            }
            return;
        }
        if (i3 == 3) {
            z17 = this$0.isPanelVisible;
            if (!z17) {
                return;
            }
            PhotoPanelVM.W(this$0, false, false, 2, null);
            return;
        }
        if (i3 == 4) {
            this$0.y();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final LifecycleEventObserver invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LifecycleEventObserver) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        final PhotoPanelVM photoPanelVM = this.this$0;
        return new LifecycleEventObserver() { // from class: com.tencent.mobileqq.aio.panel.photo.q
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                PhotoPanelVM$lifeEventObserver$2.b(PhotoPanelVM.this, lifecycleOwner, event);
            }
        };
    }
}

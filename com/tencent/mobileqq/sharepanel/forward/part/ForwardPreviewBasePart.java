package com.tencent.mobileqq.sharepanel.forward.part;

import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.sharepanel.forward.ForwardPreviewPanelFragment;
import com.tencent.mobileqq.sharepanel.fragment.DismissType;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0017\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/forward/part/ForwardPreviewBasePart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/sharepanel/fragment/DismissType;", "dismissType", "", "D9", "isForce", "", "x9", "A9", "z9", "Lcom/tencent/mobileqq/sharepanel/forward/d;", "d", "Lcom/tencent/mobileqq/sharepanel/forward/d;", "B9", "()Lcom/tencent/mobileqq/sharepanel/forward/d;", "param", "Lcom/tencent/mobileqq/sharepanel/forward/viewmodel/a;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "C9", "()Lcom/tencent/mobileqq/sharepanel/forward/viewmodel/a;", "viewModel", "<init>", "(Lcom/tencent/mobileqq/sharepanel/forward/d;)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class ForwardPreviewBasePart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.sharepanel.forward.d param;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    public ForwardPreviewBasePart(@NotNull com.tencent.mobileqq.sharepanel.forward.d param) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(param, "param");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
            return;
        }
        this.param = param;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.sharepanel.forward.viewmodel.a>() { // from class: com.tencent.mobileqq.sharepanel.forward.part.ForwardPreviewBasePart$viewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardPreviewBasePart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.sharepanel.forward.viewmodel.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.sharepanel.forward.viewmodel.a) ForwardPreviewBasePart.this.getViewModel(com.tencent.mobileqq.sharepanel.forward.viewmodel.a.class) : (com.tencent.mobileqq.sharepanel.forward.viewmodel.a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.viewModel = lazy;
    }

    public final void A9() {
        ForwardPreviewPanelFragment forwardPreviewPanelFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        IPartHost partHost = getPartHost();
        if (partHost instanceof ForwardPreviewPanelFragment) {
            forwardPreviewPanelFragment = (ForwardPreviewPanelFragment) partHost;
        } else {
            forwardPreviewPanelFragment = null;
        }
        if (forwardPreviewPanelFragment != null) {
            forwardPreviewPanelFragment.vh();
        }
    }

    @NotNull
    public final com.tencent.mobileqq.sharepanel.forward.d B9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.sharepanel.forward.d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.param;
    }

    public final com.tencent.mobileqq.sharepanel.forward.viewmodel.a C9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.sharepanel.forward.viewmodel.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (com.tencent.mobileqq.sharepanel.forward.viewmodel.a) this.viewModel.getValue();
    }

    public boolean D9(@NotNull DismissType dismissType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) dismissType)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(dismissType, "dismissType");
        return false;
    }

    public final void x9(boolean isForce) {
        ForwardPreviewPanelFragment forwardPreviewPanelFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, isForce);
            return;
        }
        IPartHost partHost = getPartHost();
        if (partHost instanceof ForwardPreviewPanelFragment) {
            forwardPreviewPanelFragment = (ForwardPreviewPanelFragment) partHost;
        } else {
            forwardPreviewPanelFragment = null;
        }
        if (forwardPreviewPanelFragment != null) {
            forwardPreviewPanelFragment.Nd(isForce);
        }
    }

    public final void z9() {
        ForwardPreviewPanelFragment forwardPreviewPanelFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        IPartHost partHost = getPartHost();
        if (partHost instanceof ForwardPreviewPanelFragment) {
            forwardPreviewPanelFragment = (ForwardPreviewPanelFragment) partHost;
        } else {
            forwardPreviewPanelFragment = null;
        }
        if (forwardPreviewPanelFragment != null) {
            forwardPreviewPanelFragment.uh();
        }
    }
}

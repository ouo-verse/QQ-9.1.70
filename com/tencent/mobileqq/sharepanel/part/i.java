package com.tencent.mobileqq.sharepanel.part;

import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.sharepanel.fragment.DismissType;
import com.tencent.mobileqq.sharepanel.fragment.SharePanelDialogFragment;
import com.tencent.mobileqq.sharepanel.launcher.SharePanelParam;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/part/i;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/sharepanel/fragment/DismissType;", "dismissType", "", "G9", "Lkotlin/Function0;", "", "block", "B9", "isForce", "z9", "E9", "A9", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "d", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "F9", "()Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "param", "<init>", "(Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class i extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SharePanelParam param;

    public i(@NotNull SharePanelParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
        } else {
            this.param = param;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void C9(i iVar, Function0 function0, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                function0 = null;
            }
            iVar.B9(function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dismiss");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public final void A9() {
        SharePanelDialogFragment sharePanelDialogFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        IPartHost partHost = getPartHost();
        if (partHost instanceof SharePanelDialogFragment) {
            sharePanelDialogFragment = (SharePanelDialogFragment) partHost;
        } else {
            sharePanelDialogFragment = null;
        }
        if (sharePanelDialogFragment != null) {
            sharePanelDialogFragment.sh();
        }
    }

    public final void B9(@Nullable final Function0<Unit> block) {
        SharePanelDialogFragment sharePanelDialogFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) block);
            return;
        }
        IPartHost partHost = getPartHost();
        if (partHost instanceof SharePanelDialogFragment) {
            sharePanelDialogFragment = (SharePanelDialogFragment) partHost;
        } else {
            sharePanelDialogFragment = null;
        }
        if (sharePanelDialogFragment != null) {
            sharePanelDialogFragment.dismiss();
        }
        if (block != null) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.part.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.D9(Function0.this);
                }
            }, 150L);
        }
    }

    public final void E9() {
        SharePanelDialogFragment sharePanelDialogFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        IPartHost partHost = getPartHost();
        if (partHost instanceof SharePanelDialogFragment) {
            sharePanelDialogFragment = (SharePanelDialogFragment) partHost;
        } else {
            sharePanelDialogFragment = null;
        }
        if (sharePanelDialogFragment != null) {
            sharePanelDialogFragment.th();
        }
    }

    @NotNull
    public final SharePanelParam F9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SharePanelParam) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.param;
    }

    public boolean G9(@NotNull DismissType dismissType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) dismissType)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(dismissType, "dismissType");
        return false;
    }

    public final void z9(boolean isForce) {
        SharePanelDialogFragment sharePanelDialogFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, isForce);
            return;
        }
        IPartHost partHost = getPartHost();
        if (partHost instanceof SharePanelDialogFragment) {
            sharePanelDialogFragment = (SharePanelDialogFragment) partHost;
        } else {
            sharePanelDialogFragment = null;
        }
        if (sharePanelDialogFragment != null) {
            sharePanelDialogFragment.Nd(isForce);
        }
    }
}

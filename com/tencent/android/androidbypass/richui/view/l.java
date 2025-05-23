package com.tencent.android.androidbypass.richui.view;

import android.view.ViewGroup;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/android/androidbypass/richui/view/l;", "Lcom/tencent/android/androidbypass/richui/view/h;", "Landroid/view/ViewGroup;", "Lcom/tencent/android/androidbypass/richui/view/e;", "b", "Lcom/tencent/android/androidbypass/richui/view/e;", "j", "()Lcom/tencent/android/androidbypass/richui/view/e;", "bgDelegate", "Lcom/tencent/android/androidbypass/richui/view/RoundLinearLayout;", "c", "Lcom/tencent/android/androidbypass/richui/view/RoundLinearLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/android/androidbypass/richui/view/RoundLinearLayout;", "roundLinearLayout", "Lcom/tencent/android/androidbypass/richui/view/RichUIFrameLayout;", "d", "Lcom/tencent/android/androidbypass/richui/view/RichUIFrameLayout;", "l", "()Lcom/tencent/android/androidbypass/richui/view/RichUIFrameLayout;", "roundFrameLayout", "e", "k", "frameLayout", "<init>", "(Lcom/tencent/android/androidbypass/richui/view/e;Lcom/tencent/android/androidbypass/richui/view/RoundLinearLayout;Lcom/tencent/android/androidbypass/richui/view/RichUIFrameLayout;Lcom/tencent/android/androidbypass/richui/view/RichUIFrameLayout;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class l implements h<ViewGroup> {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final e bgDelegate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final RoundLinearLayout roundLinearLayout;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final RichUIFrameLayout roundFrameLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final RichUIFrameLayout frameLayout;

    public l(@Nullable e eVar, @Nullable RoundLinearLayout roundLinearLayout, @Nullable RichUIFrameLayout richUIFrameLayout, @Nullable RichUIFrameLayout richUIFrameLayout2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, eVar, roundLinearLayout, richUIFrameLayout, richUIFrameLayout2);
            return;
        }
        this.bgDelegate = eVar;
        this.roundLinearLayout = roundLinearLayout;
        this.roundFrameLayout = richUIFrameLayout;
        this.frameLayout = richUIFrameLayout2;
    }

    @Nullable
    public final e j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (e) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.bgDelegate;
    }

    @Nullable
    public final RichUIFrameLayout k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (RichUIFrameLayout) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.frameLayout;
    }

    @Nullable
    public final RichUIFrameLayout l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RichUIFrameLayout) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.roundFrameLayout;
    }

    @Nullable
    public final RoundLinearLayout m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RoundLinearLayout) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.roundLinearLayout;
    }
}

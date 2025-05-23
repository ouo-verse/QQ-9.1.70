package com.tencent.android.androidbypass.richui.view;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/android/androidbypass/richui/view/a;", "Lcom/tencent/android/androidbypass/richui/view/h;", "Landroid/widget/FrameLayout;", "b", "Landroid/widget/FrameLayout;", "j", "()Landroid/widget/FrameLayout;", "frameLayout", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "k", "()Landroid/widget/TextView;", "textView", "<init>", "(Landroid/widget/FrameLayout;Landroid/widget/TextView;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class a implements h<FrameLayout> {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout frameLayout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView textView;

    public a(@NotNull FrameLayout frameLayout, @NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(frameLayout, "frameLayout");
        Intrinsics.checkNotNullParameter(textView, "textView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) frameLayout, (Object) textView);
        } else {
            this.frameLayout = frameLayout;
            this.textView = textView;
        }
    }

    @NotNull
    public final FrameLayout j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.frameLayout;
    }

    @NotNull
    public final TextView k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TextView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.textView;
    }
}

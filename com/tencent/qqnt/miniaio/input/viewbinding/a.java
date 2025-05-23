package com.tencent.qqnt.miniaio.input.viewbinding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.aio.input.edit.AIOEditText;
import com.tencent.mobileqq.aio.input.inputbar.viewbinding.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.PatchedButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import w71.ad;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/miniaio/input/viewbinding/a;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/b;", "Landroid/widget/LinearLayout;", "f", "Lw71/ad;", "a", "Lw71/ad;", "e", "()Lw71/ad;", "impl", "Lcom/tencent/mobileqq/aio/input/edit/AIOEditText;", "()Lcom/tencent/mobileqq/aio/input/edit/AIOEditText;", "input", "Landroid/view/View;", "d", "()Landroid/view/View;", "sendBtn", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ad impl;

    public a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        ad g16 = ad.g(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.impl = g16;
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.e
    @NotNull
    public View d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        PatchedButton patchedButton = this.impl.f444728d;
        Intrinsics.checkNotNullExpressionValue(patchedButton, "impl.sendBtn");
        return patchedButton;
    }

    @NotNull
    public final ad e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ad) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.impl;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LinearLayout) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        LinearLayout root = this.impl.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "impl.root");
        return root;
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.e
    @NotNull
    public AIOEditText a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AIOEditText) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        AIOEditText aIOEditText = this.impl.f444727c;
        Intrinsics.checkNotNullExpressionValue(aIOEditText, "impl.input");
        return aIOEditText;
    }
}

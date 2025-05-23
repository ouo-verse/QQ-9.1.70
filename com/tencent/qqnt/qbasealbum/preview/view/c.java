package com.tencent.qqnt.qbasealbum.preview.view;

import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/preview/view/c;", "", "Landroid/widget/ImageView;", "imageView", "", "b", "Landroid/widget/ImageView$ScaleType;", "scaleType", "c", "", "action", "a", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f361439a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44564);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f361439a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final int a(int action) {
        return (action & 65280) >> 8;
    }

    @JvmStatic
    public static final boolean b(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        if (imageView.getDrawable() != null) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean c(@Nullable ImageView.ScaleType scaleType) {
        boolean z16 = false;
        if (scaleType == null) {
            return false;
        }
        if (scaleType != ImageView.ScaleType.MATRIX) {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        throw new IllegalStateException("Matrix scale type is not supported".toString());
    }
}

package com.tencent.qqnt.qbasealbum.ktx;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PageType;
import com.tencent.qqnt.qbasealbum.utils.UriUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\t\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007\u001a\u0012\u0010\u000b\u001a\u00020\u0003*\u00020\n2\u0006\u0010\b\u001a\u00020\u0007\u001a\u0012\u0010\f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007\"\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0017\u0010\u0015\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011\"\u0015\u0010\u0017\u001a\u00020\u0007*\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0016\"\u0015\u0010\u0017\u001a\u00020\u0007*\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0019\u00a8\u0006\u001a"}, d2 = {"Landroid/widget/ImageView;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "", "c", "g", "Landroid/view/View;", "", "resId", "d", "Landroid/widget/TextView;", "f", "e", "Landroid/graphics/drawable/ColorDrawable;", "a", "Landroid/graphics/drawable/ColorDrawable;", "getThumbPlaceholderDrawable", "()Landroid/graphics/drawable/ColorDrawable;", "thumbPlaceholderDrawable", "b", "getPreviewPlaceholderDrawable", "previewPlaceholderDrawable", "(I)I", "dp", "", "(F)I", "nt_album_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final ColorDrawable f361236a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final ColorDrawable f361237b;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f361238a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41587);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[PageType.values().length];
            try {
                iArr[PageType.LOCAL_IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PageType.LOCAL_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f361238a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41589);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f361236a = new ColorDrawable(Color.parseColor("#F5F5F5"));
            f361237b = new ColorDrawable(Color.parseColor("#22000000"));
        }
    }

    public static final int a(float f16) {
        return com.tencent.qqnt.qbasealbum.utils.d.c(com.tencent.qqnt.qbasealbum.utils.d.f361649a, null, f16, 1, null);
    }

    public static final int b(int i3) {
        return a(i3);
    }

    public static final void c(@NotNull ImageView imageView, @NotNull LocalMediaInfo info) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(info, "info");
        if (b.g(info).isLocalMedia()) {
            UriUtil.f361640a.k(imageView, info);
        }
    }

    public static final void d(@NotNull View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setBackground(ContextCompat.getDrawable(com.tencent.qqnt.qbasealbum.inject.a.f361230a.a(), i3));
    }

    public static final void e(@NotNull ImageView imageView, int i3) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        imageView.setImageDrawable(ContextCompat.getDrawable(com.tencent.qqnt.qbasealbum.inject.a.f361230a.a(), i3));
    }

    public static final void f(@NotNull TextView textView, int i3) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setTextColor(ContextCompat.getColor(com.tencent.qqnt.qbasealbum.inject.a.f361230a.a(), i3));
    }

    public static final void g(@NotNull ImageView imageView, @NotNull LocalMediaInfo info) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(info, "info");
        int i3 = a.f361238a[b.g(info).ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                UriUtil.f361640a.i(imageView, info);
                return;
            }
            return;
        }
        UriUtil.f361640a.i(imageView, info);
    }
}

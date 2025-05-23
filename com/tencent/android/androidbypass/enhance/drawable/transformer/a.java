package com.tencent.android.androidbypass.enhance.drawable.transformer;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.android.androidbypass.enhance.h;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0004B\u000f\u0012\u0006\u0010\n\u001a\u00020\b\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/drawable/transformer/a;", "Lcom/tencent/android/androidbypass/enhance/h$b$b;", "Landroid/graphics/drawable/Drawable;", "drawable", "a", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "b", "Landroid/widget/ImageView$ScaleType;", "Landroid/widget/ImageView$ScaleType;", "scaleType", "<init>", "(Landroid/widget/ImageView$ScaleType;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class a implements h.b.InterfaceC0719b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static final C0717a f72139b;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ImageView.ScaleType scaleType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/drawable/transformer/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.enhance.drawable.transformer.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static final class C0717a {
        static IPatchRedirector $redirector_;

        C0717a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ C0717a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16939);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f72139b = new C0717a(null);
        }
    }

    public a(@NotNull ImageView.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) scaleType);
        } else {
            this.scaleType = scaleType;
        }
    }

    @Override // com.tencent.android.androidbypass.enhance.h.b.InterfaceC0719b
    @Nullable
    public Drawable a(@Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Drawable) iPatchRedirector.redirect((short) 1, (Object) this, (Object) drawable);
        }
        if (drawable == null) {
            return null;
        }
        return b(com.tencent.android.androidbypass.enhance.drawable.a.c(drawable));
    }

    @Override // com.tencent.android.androidbypass.enhance.h.b.InterfaceC0719b
    @Nullable
    public Drawable b(@Nullable Bitmap bitmap) {
        com.tencent.android.androidbypass.enhance.drawable.a d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
        }
        if (bitmap == null) {
            com.tencent.android.androidbypass.config.a.f72049a.w("CircleDrawableTransformer", "try to transform null bitmap to a drawable");
        }
        if (bitmap != null && (d16 = com.tencent.android.androidbypass.enhance.drawable.a.d(bitmap)) != null) {
            d16.j(true);
            d16.k(this.scaleType);
            return d16;
        }
        return null;
    }
}

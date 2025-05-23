package com.tencent.android.androidbypass.enhance.drawable.transformer;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0011\u0010\u0012J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/drawable/transformer/b;", "Lcom/tencent/android/androidbypass/enhance/h$b$b;", "Lcom/tencent/android/androidbypass/enhance/drawable/a;", "", "c", "Landroid/graphics/drawable/Drawable;", "drawable", "a", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "b", "", UserInfo.SEX_FEMALE, "radiusPx", "Landroid/widget/ImageView$ScaleType;", "Landroid/widget/ImageView$ScaleType;", "scaleType", "<init>", "(FLandroid/widget/ImageView$ScaleType;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class b implements h.b.InterfaceC0719b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static final a f72141c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float radiusPx;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ImageView.ScaleType scaleType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/drawable/transformer/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16950);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f72141c = new a(null);
        }
    }

    public b(float f16, @NotNull ImageView.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), scaleType);
        } else {
            this.radiusPx = f16;
            this.scaleType = scaleType;
        }
    }

    private final void c(com.tencent.android.androidbypass.enhance.drawable.a aVar) {
        aVar.h(this.radiusPx);
        aVar.k(this.scaleType);
    }

    @Override // com.tencent.android.androidbypass.enhance.h.b.InterfaceC0719b
    @Nullable
    public Drawable a(@Nullable Drawable drawable) {
        Bitmap c16;
        com.tencent.android.androidbypass.enhance.drawable.a d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Drawable) iPatchRedirector.redirect((short) 1, (Object) this, (Object) drawable);
        }
        if (drawable == null) {
            com.tencent.android.androidbypass.config.a.f72049a.w("RoundedDrawableTransformer", "try to transform null drawable to a drawable");
        }
        if (drawable != null && (c16 = com.tencent.android.androidbypass.enhance.drawable.a.c(drawable)) != null && (d16 = com.tencent.android.androidbypass.enhance.drawable.a.d(c16)) != null) {
            c(d16);
            return d16;
        }
        return null;
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
            com.tencent.android.androidbypass.config.a.f72049a.w("RoundedDrawableTransformer", "try to transform null bitmap to a drawable");
        }
        if (bitmap != null && (d16 = com.tencent.android.androidbypass.enhance.drawable.a.d(bitmap)) != null) {
            c(d16);
            return d16;
        }
        return null;
    }
}

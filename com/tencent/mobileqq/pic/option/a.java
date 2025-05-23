package com.tencent.mobileqq.pic.option;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\u000f\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0017\u001a\u0004\b\t\u0010\u0019R\u0019\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010$\u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 \u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/pic/option/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "url", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "c", "()Landroid/widget/ImageView;", "targetView", "Z", "()Z", "preDecode", "I", "e", "()I", "width", "height", "Landroid/graphics/drawable/Drawable;", "f", "Landroid/graphics/drawable/Drawable;", "getLoadingDrawable", "()Landroid/graphics/drawable/Drawable;", "loadingDrawable", "g", "getFailedDrawable", "failedDrawable", "<init>", "(Ljava/lang/String;Landroid/widget/ImageView;ZIILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "pic_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView targetView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean preDecode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int width;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int height;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Drawable loadingDrawable;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Drawable failedDrawable;

    public a(@NotNull String url, @NotNull ImageView targetView, boolean z16, int i3, int i16, @Nullable Drawable drawable, @Nullable Drawable drawable2) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, url, targetView, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), drawable, drawable2);
            return;
        }
        this.url = url;
        this.targetView = targetView;
        this.preDecode = z16;
        this.width = i3;
        this.height = i16;
        this.loadingDrawable = drawable;
        this.failedDrawable = drawable2;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.height;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.preDecode;
    }

    @NotNull
    public final ImageView c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ImageView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.targetView;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.url;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.width;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.url, aVar.url) && Intrinsics.areEqual(this.targetView, aVar.targetView) && this.preDecode == aVar.preDecode && this.width == aVar.width && this.height == aVar.height && Intrinsics.areEqual(this.loadingDrawable, aVar.loadingDrawable) && Intrinsics.areEqual(this.failedDrawable, aVar.failedDrawable)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        int hashCode2 = ((this.url.hashCode() * 31) + this.targetView.hashCode()) * 31;
        boolean z16 = this.preDecode;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (((((hashCode2 + i3) * 31) + this.width) * 31) + this.height) * 31;
        Drawable drawable = this.loadingDrawable;
        int i17 = 0;
        if (drawable == null) {
            hashCode = 0;
        } else {
            hashCode = drawable.hashCode();
        }
        int i18 = (i16 + hashCode) * 31;
        Drawable drawable2 = this.failedDrawable;
        if (drawable2 != null) {
            i17 = drawable2.hashCode();
        }
        return i18 + i17;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return "PicOption(url=" + this.url + ", targetView=" + this.targetView + ", preDecode=" + this.preDecode + ", width=" + this.width + ", height=" + this.height + ", loadingDrawable=" + this.loadingDrawable + ", failedDrawable=" + this.failedDrawable + ")";
    }

    public /* synthetic */ a(String str, ImageView imageView, boolean z16, int i3, int i16, Drawable drawable, Drawable drawable2, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, imageView, (i17 & 4) != 0 ? false : z16, (i17 & 8) != 0 ? 0 : i3, (i17 & 16) != 0 ? 0 : i16, (i17 & 32) != 0 ? null : drawable, (i17 & 64) != 0 ? null : drawable2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, imageView, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), drawable, drawable2, Integer.valueOf(i17), defaultConstructorMarker);
    }
}

package com.tencent.mobileqq.qqlive.sail.ui.background;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0018\u001a\u0004\b\u0013\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/background/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "bgDrawable", "b", "e", "topDrawable", "c", "bottomDrawable", "d", "I", "()I", "priority", "Landroid/widget/ImageView$ScaleType;", "Landroid/widget/ImageView$ScaleType;", "()Landroid/widget/ImageView$ScaleType;", "scaleType", "<init>", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;ILandroid/widget/ImageView$ScaleType;)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Drawable bgDrawable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Drawable topDrawable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Drawable bottomDrawable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int priority;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView.ScaleType scaleType;

    public a(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, int i3, @NotNull ImageView.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, drawable, drawable2, drawable3, Integer.valueOf(i3), scaleType);
            return;
        }
        this.bgDrawable = drawable;
        this.topDrawable = drawable2;
        this.bottomDrawable = drawable3;
        this.priority = i3;
        this.scaleType = scaleType;
    }

    @Nullable
    public final Drawable a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.bgDrawable;
    }

    @Nullable
    public final Drawable b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.bottomDrawable;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.priority;
    }

    @NotNull
    public final ImageView.ScaleType d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ImageView.ScaleType) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.scaleType;
    }

    @Nullable
    public final Drawable e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.topDrawable;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.bgDrawable, aVar.bgDrawable) && Intrinsics.areEqual(this.topDrawable, aVar.topDrawable) && Intrinsics.areEqual(this.bottomDrawable, aVar.bottomDrawable) && this.priority == aVar.priority && this.scaleType == aVar.scaleType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        Drawable drawable = this.bgDrawable;
        int i3 = 0;
        if (drawable == null) {
            hashCode = 0;
        } else {
            hashCode = drawable.hashCode();
        }
        int i16 = hashCode * 31;
        Drawable drawable2 = this.topDrawable;
        if (drawable2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = drawable2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        Drawable drawable3 = this.bottomDrawable;
        if (drawable3 != null) {
            i3 = drawable3.hashCode();
        }
        return ((((i17 + i3) * 31) + this.priority) * 31) + this.scaleType.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "BackgroundDrawableInfo(bgDrawable=" + this.bgDrawable + ", topDrawable=" + this.topDrawable + ", bottomDrawable=" + this.bottomDrawable + ", priority=" + this.priority + ", scaleType=" + this.scaleType + ")";
    }

    public /* synthetic */ a(Drawable drawable, Drawable drawable2, Drawable drawable3, int i3, ImageView.ScaleType scaleType, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawable, drawable2, drawable3, i3, (i16 & 16) != 0 ? ImageView.ScaleType.CENTER_CROP : scaleType);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, drawable, drawable2, drawable3, Integer.valueOf(i3), scaleType, Integer.valueOf(i16), defaultConstructorMarker);
    }
}

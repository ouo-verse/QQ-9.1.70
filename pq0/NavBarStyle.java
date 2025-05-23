package pq0;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u0011\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lpq0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/graphics/drawable/Drawable;", "b", "()Landroid/graphics/drawable/Drawable;", "e", "(Landroid/graphics/drawable/Drawable;)V", "iconDrawable", "d", "bgDrawable", "c", "I", "()I", "f", "(I)V", "textColor", "<init>", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: pq0.a, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class NavBarStyle {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Drawable iconDrawable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Drawable bgDrawable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int textColor;

    public NavBarStyle() {
        this(null, null, 0, 7, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Drawable getBgDrawable() {
        return this.bgDrawable;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Drawable getIconDrawable() {
        return this.iconDrawable;
    }

    /* renamed from: c, reason: from getter */
    public final int getTextColor() {
        return this.textColor;
    }

    public final void d(@Nullable Drawable drawable) {
        this.bgDrawable = drawable;
    }

    public final void e(@Nullable Drawable drawable) {
        this.iconDrawable = drawable;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NavBarStyle)) {
            return false;
        }
        NavBarStyle navBarStyle = (NavBarStyle) other;
        if (Intrinsics.areEqual(this.iconDrawable, navBarStyle.iconDrawable) && Intrinsics.areEqual(this.bgDrawable, navBarStyle.bgDrawable) && this.textColor == navBarStyle.textColor) {
            return true;
        }
        return false;
    }

    public final void f(int i3) {
        this.textColor = i3;
    }

    public int hashCode() {
        int hashCode;
        Drawable drawable = this.iconDrawable;
        int i3 = 0;
        if (drawable == null) {
            hashCode = 0;
        } else {
            hashCode = drawable.hashCode();
        }
        int i16 = hashCode * 31;
        Drawable drawable2 = this.bgDrawable;
        if (drawable2 != null) {
            i3 = drawable2.hashCode();
        }
        return ((i16 + i3) * 31) + this.textColor;
    }

    @NotNull
    public String toString() {
        return "NavBarStyle(iconDrawable=" + this.iconDrawable + ", bgDrawable=" + this.bgDrawable + ", textColor=" + this.textColor + ")";
    }

    public NavBarStyle(@Nullable Drawable drawable, @Nullable Drawable drawable2, int i3) {
        this.iconDrawable = drawable;
        this.bgDrawable = drawable2;
        this.textColor = i3;
    }

    public /* synthetic */ NavBarStyle(Drawable drawable, Drawable drawable2, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : drawable, (i16 & 2) != 0 ? null : drawable2, (i16 & 4) != 0 ? 0 : i3);
    }
}

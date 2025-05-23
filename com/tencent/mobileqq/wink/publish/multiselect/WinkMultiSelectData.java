package com.tencent.mobileqq.wink.publish.multiselect;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ3\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H\u00c6\u0001J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/multiselect/e;", "", "Landroid/graphics/drawable/Drawable;", "iconDrawable", "", "iconUrl", "text", "", "isChecked", "a", "toString", "", "hashCode", "other", "equals", "Landroid/graphics/drawable/Drawable;", "c", "()Landroid/graphics/drawable/Drawable;", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "e", "Z", "f", "()Z", "<init>", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;Z)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.publish.multiselect.e, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class WinkMultiSelectData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Drawable iconDrawable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String iconUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String text;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isChecked;

    public WinkMultiSelectData(@Nullable Drawable drawable, @NotNull String iconUrl, @NotNull String text, boolean z16) {
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(text, "text");
        this.iconDrawable = drawable;
        this.iconUrl = iconUrl;
        this.text = text;
        this.isChecked = z16;
    }

    public static /* synthetic */ WinkMultiSelectData b(WinkMultiSelectData winkMultiSelectData, Drawable drawable, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            drawable = winkMultiSelectData.iconDrawable;
        }
        if ((i3 & 2) != 0) {
            str = winkMultiSelectData.iconUrl;
        }
        if ((i3 & 4) != 0) {
            str2 = winkMultiSelectData.text;
        }
        if ((i3 & 8) != 0) {
            z16 = winkMultiSelectData.isChecked;
        }
        return winkMultiSelectData.a(drawable, str, str2, z16);
    }

    @NotNull
    public final WinkMultiSelectData a(@Nullable Drawable iconDrawable, @NotNull String iconUrl, @NotNull String text, boolean isChecked) {
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(text, "text");
        return new WinkMultiSelectData(iconDrawable, iconUrl, text, isChecked);
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Drawable getIconDrawable() {
        return this.iconDrawable;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkMultiSelectData)) {
            return false;
        }
        WinkMultiSelectData winkMultiSelectData = (WinkMultiSelectData) other;
        if (Intrinsics.areEqual(this.iconDrawable, winkMultiSelectData.iconDrawable) && Intrinsics.areEqual(this.iconUrl, winkMultiSelectData.iconUrl) && Intrinsics.areEqual(this.text, winkMultiSelectData.text) && this.isChecked == winkMultiSelectData.isChecked) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        Drawable drawable = this.iconDrawable;
        if (drawable == null) {
            hashCode = 0;
        } else {
            hashCode = drawable.hashCode();
        }
        int hashCode2 = ((((hashCode * 31) + this.iconUrl.hashCode()) * 31) + this.text.hashCode()) * 31;
        boolean z16 = this.isChecked;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode2 + i3;
    }

    @NotNull
    public String toString() {
        return "WinkMultiSelectData(iconDrawable=" + this.iconDrawable + ", iconUrl=" + this.iconUrl + ", text=" + this.text + ", isChecked=" + this.isChecked + ")";
    }

    public /* synthetic */ WinkMultiSelectData(Drawable drawable, String str, String str2, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : drawable, (i3 & 2) != 0 ? "" : str, str2, z16);
    }
}

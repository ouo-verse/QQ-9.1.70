package com.tencent.tavcut.core.render.builder.light.model.asset;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/model/asset/FontAsset;", "", "fontFamily", "", "fontStyle", "(Ljava/lang/String;Ljava/lang/String;)V", "getFontFamily", "()Ljava/lang/String;", "getFontStyle", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class FontAsset {

    @Nullable
    private final String fontFamily;

    @Nullable
    private final String fontStyle;

    public FontAsset() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ FontAsset copy$default(FontAsset fontAsset, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = fontAsset.fontFamily;
        }
        if ((i3 & 2) != 0) {
            str2 = fontAsset.fontStyle;
        }
        return fontAsset.copy(str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getFontFamily() {
        return this.fontFamily;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getFontStyle() {
        return this.fontStyle;
    }

    @NotNull
    public final FontAsset copy(@Nullable String fontFamily, @Nullable String fontStyle) {
        return new FontAsset(fontFamily, fontStyle);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof FontAsset) {
                FontAsset fontAsset = (FontAsset) other;
                if (!Intrinsics.areEqual(this.fontFamily, fontAsset.fontFamily) || !Intrinsics.areEqual(this.fontStyle, fontAsset.fontStyle)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final String getFontFamily() {
        return this.fontFamily;
    }

    @Nullable
    public final String getFontStyle() {
        return this.fontStyle;
    }

    public int hashCode() {
        int i3;
        String str = this.fontFamily;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        String str2 = this.fontStyle;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "FontAsset(fontFamily=" + this.fontFamily + ", fontStyle=" + this.fontStyle + ")";
    }

    public FontAsset(@Nullable String str, @Nullable String str2) {
        this.fontFamily = str;
        this.fontStyle = str2;
    }

    public /* synthetic */ FontAsset(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2);
    }
}

package com.tencent.state.view;

import android.graphics.drawable.Drawable;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0010Jv\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020\u0003H\u00d6\u0001J\t\u0010,\u001a\u00020\u0005H\u00d6\u0001R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u001b\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014\u00a8\u0006-"}, d2 = {"Lcom/tencent/state/view/ResStyle;", "", "resId", "", "resFilePath", "", "resDrawable", "Landroid/graphics/drawable/Drawable;", "width", "height", "imagePadding", NodeProps.MARGIN_BOTTOM, "contentMarginBottom", "bgResId", "(Ljava/lang/Integer;Ljava/lang/String;Landroid/graphics/drawable/Drawable;IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBgResId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getContentMarginBottom", "getHeight", "()I", "getImagePadding", "getMarginBottom", "getResDrawable", "()Landroid/graphics/drawable/Drawable;", "getResFilePath", "()Ljava/lang/String;", "getResId", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Landroid/graphics/drawable/Drawable;IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tencent/state/view/ResStyle;", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class ResStyle {
    private final Integer bgResId;
    private final Integer contentMarginBottom;
    private final int height;
    private final Integer imagePadding;
    private final Integer marginBottom;
    private final Drawable resDrawable;
    private final String resFilePath;
    private final Integer resId;
    private final int width;

    public ResStyle(Integer num, String str, Drawable drawable, int i3, int i16, Integer num2, Integer num3, Integer num4, Integer num5) {
        this.resId = num;
        this.resFilePath = str;
        this.resDrawable = drawable;
        this.width = i3;
        this.height = i16;
        this.imagePadding = num2;
        this.marginBottom = num3;
        this.contentMarginBottom = num4;
        this.bgResId = num5;
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getResId() {
        return this.resId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getResFilePath() {
        return this.resFilePath;
    }

    /* renamed from: component3, reason: from getter */
    public final Drawable getResDrawable() {
        return this.resDrawable;
    }

    /* renamed from: component4, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component5, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getImagePadding() {
        return this.imagePadding;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getMarginBottom() {
        return this.marginBottom;
    }

    /* renamed from: component8, reason: from getter */
    public final Integer getContentMarginBottom() {
        return this.contentMarginBottom;
    }

    /* renamed from: component9, reason: from getter */
    public final Integer getBgResId() {
        return this.bgResId;
    }

    public final ResStyle copy(Integer resId, String resFilePath, Drawable resDrawable, int width, int height, Integer imagePadding, Integer marginBottom, Integer contentMarginBottom, Integer bgResId) {
        return new ResStyle(resId, resFilePath, resDrawable, width, height, imagePadding, marginBottom, contentMarginBottom, bgResId);
    }

    public final Integer getBgResId() {
        return this.bgResId;
    }

    public final Integer getContentMarginBottom() {
        return this.contentMarginBottom;
    }

    public final int getHeight() {
        return this.height;
    }

    public final Integer getImagePadding() {
        return this.imagePadding;
    }

    public final Integer getMarginBottom() {
        return this.marginBottom;
    }

    public final Drawable getResDrawable() {
        return this.resDrawable;
    }

    public final String getResFilePath() {
        return this.resFilePath;
    }

    public final Integer getResId() {
        return this.resId;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        Integer num = this.resId;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.resFilePath;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Drawable drawable = this.resDrawable;
        int hashCode3 = (((((hashCode2 + (drawable != null ? drawable.hashCode() : 0)) * 31) + this.width) * 31) + this.height) * 31;
        Integer num2 = this.imagePadding;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.marginBottom;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.contentMarginBottom;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Integer num5 = this.bgResId;
        return hashCode6 + (num5 != null ? num5.hashCode() : 0);
    }

    public String toString() {
        return "ResStyle(resId=" + this.resId + ", resFilePath=" + this.resFilePath + ", resDrawable=" + this.resDrawable + ", width=" + this.width + ", height=" + this.height + ", imagePadding=" + this.imagePadding + ", marginBottom=" + this.marginBottom + ", contentMarginBottom=" + this.contentMarginBottom + ", bgResId=" + this.bgResId + ")";
    }

    public /* synthetic */ ResStyle(Integer num, String str, Drawable drawable, int i3, int i16, Integer num2, Integer num3, Integer num4, Integer num5, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, (i17 & 2) != 0 ? null : str, (i17 & 4) != 0 ? null : drawable, (i17 & 8) != 0 ? -2 : i3, (i17 & 16) == 0 ? i16 : -2, (i17 & 32) != 0 ? null : num2, (i17 & 64) != 0 ? null : num3, (i17 & 128) != 0 ? null : num4, (i17 & 256) == 0 ? num5 : null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResStyle)) {
            return false;
        }
        ResStyle resStyle = (ResStyle) other;
        return Intrinsics.areEqual(this.resId, resStyle.resId) && Intrinsics.areEqual(this.resFilePath, resStyle.resFilePath) && Intrinsics.areEqual(this.resDrawable, resStyle.resDrawable) && this.width == resStyle.width && this.height == resStyle.height && Intrinsics.areEqual(this.imagePadding, resStyle.imagePadding) && Intrinsics.areEqual(this.marginBottom, resStyle.marginBottom) && Intrinsics.areEqual(this.contentMarginBottom, resStyle.contentMarginBottom) && Intrinsics.areEqual(this.bgResId, resStyle.bgResId);
    }
}

package com.tencent.state.decode;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bH\u00c6\u0003J3\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0014\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/decode/DrawData;", "", "key", "", "viewRect", "Landroid/graphics/Rect;", "imageRect", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Bitmap;", "(ILandroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Bitmap;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "getImageRect", "()Landroid/graphics/Rect;", "getKey", "()I", "getViewRect", "setViewRect", "(Landroid/graphics/Rect;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes33.dex */
public final /* data */ class DrawData {
    private Bitmap bitmap;
    private final Rect imageRect;
    private final int key;
    private Rect viewRect;

    public DrawData(int i3, Rect viewRect, Rect imageRect, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(viewRect, "viewRect");
        Intrinsics.checkNotNullParameter(imageRect, "imageRect");
        this.key = i3;
        this.viewRect = viewRect;
        this.imageRect = imageRect;
        this.bitmap = bitmap;
    }

    /* renamed from: component1, reason: from getter */
    public final int getKey() {
        return this.key;
    }

    /* renamed from: component2, reason: from getter */
    public final Rect getViewRect() {
        return this.viewRect;
    }

    /* renamed from: component3, reason: from getter */
    public final Rect getImageRect() {
        return this.imageRect;
    }

    /* renamed from: component4, reason: from getter */
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final DrawData copy(int key, Rect viewRect, Rect imageRect, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(viewRect, "viewRect");
        Intrinsics.checkNotNullParameter(imageRect, "imageRect");
        return new DrawData(key, viewRect, imageRect, bitmap);
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final Rect getImageRect() {
        return this.imageRect;
    }

    public final int getKey() {
        return this.key;
    }

    public final Rect getViewRect() {
        return this.viewRect;
    }

    public int hashCode() {
        int i3 = this.key * 31;
        Rect rect = this.viewRect;
        int hashCode = (i3 + (rect != null ? rect.hashCode() : 0)) * 31;
        Rect rect2 = this.imageRect;
        int hashCode2 = (hashCode + (rect2 != null ? rect2.hashCode() : 0)) * 31;
        Bitmap bitmap = this.bitmap;
        return hashCode2 + (bitmap != null ? bitmap.hashCode() : 0);
    }

    public final void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public final void setViewRect(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<set-?>");
        this.viewRect = rect;
    }

    public String toString() {
        return "DrawData(key=" + this.key + ", viewRect=" + this.viewRect + ", imageRect=" + this.imageRect + ", bitmap=" + this.bitmap + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DrawData)) {
            return false;
        }
        DrawData drawData = (DrawData) other;
        return this.key == drawData.key && Intrinsics.areEqual(this.viewRect, drawData.viewRect) && Intrinsics.areEqual(this.imageRect, drawData.imageRect) && Intrinsics.areEqual(this.bitmap, drawData.bitmap);
    }

    public static /* synthetic */ DrawData copy$default(DrawData drawData, int i3, Rect rect, Rect rect2, Bitmap bitmap, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = drawData.key;
        }
        if ((i16 & 2) != 0) {
            rect = drawData.viewRect;
        }
        if ((i16 & 4) != 0) {
            rect2 = drawData.imageRect;
        }
        if ((i16 & 8) != 0) {
            bitmap = drawData.bitmap;
        }
        return drawData.copy(i3, rect, rect2, bitmap);
    }
}

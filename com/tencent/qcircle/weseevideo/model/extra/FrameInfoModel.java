package com.tencent.qcircle.weseevideo.model.extra;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tJ\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003JE\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0010\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/extra/FrameInfoModel;", "Ljava/io/Serializable;", "mWidth", "", "mHeight", "left", "top", "right", "bottom", "(IIIIII)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* data */ class FrameInfoModel implements Serializable {

    @JvmField
    public final int bottom;

    @JvmField
    public final int left;

    @JvmField
    public final int mHeight;

    @JvmField
    public final int mWidth;

    @JvmField
    public final int right;

    @JvmField
    public final int top;

    public FrameInfoModel() {
        this(0, 0, 0, 0, 0, 0, 63, null);
    }

    public static /* synthetic */ FrameInfoModel copy$default(FrameInfoModel frameInfoModel, int i3, int i16, int i17, int i18, int i19, int i26, int i27, Object obj) {
        if ((i27 & 1) != 0) {
            i3 = frameInfoModel.mWidth;
        }
        if ((i27 & 2) != 0) {
            i16 = frameInfoModel.mHeight;
        }
        int i28 = i16;
        if ((i27 & 4) != 0) {
            i17 = frameInfoModel.left;
        }
        int i29 = i17;
        if ((i27 & 8) != 0) {
            i18 = frameInfoModel.top;
        }
        int i36 = i18;
        if ((i27 & 16) != 0) {
            i19 = frameInfoModel.right;
        }
        int i37 = i19;
        if ((i27 & 32) != 0) {
            i26 = frameInfoModel.bottom;
        }
        return frameInfoModel.copy(i3, i28, i29, i36, i37, i26);
    }

    /* renamed from: component1, reason: from getter */
    public final int getMWidth() {
        return this.mWidth;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMHeight() {
        return this.mHeight;
    }

    /* renamed from: component3, reason: from getter */
    public final int getLeft() {
        return this.left;
    }

    /* renamed from: component4, reason: from getter */
    public final int getTop() {
        return this.top;
    }

    /* renamed from: component5, reason: from getter */
    public final int getRight() {
        return this.right;
    }

    /* renamed from: component6, reason: from getter */
    public final int getBottom() {
        return this.bottom;
    }

    @NotNull
    public final FrameInfoModel copy(int mWidth, int mHeight, int left, int top, int right, int bottom) {
        return new FrameInfoModel(mWidth, mHeight, left, top, right, bottom);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof FrameInfoModel) {
                FrameInfoModel frameInfoModel = (FrameInfoModel) other;
                if (this.mWidth != frameInfoModel.mWidth || this.mHeight != frameInfoModel.mHeight || this.left != frameInfoModel.left || this.top != frameInfoModel.top || this.right != frameInfoModel.right || this.bottom != frameInfoModel.bottom) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((((this.mWidth * 31) + this.mHeight) * 31) + this.left) * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    @NotNull
    public String toString() {
        return "FrameInfoModel(mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ")";
    }

    public FrameInfoModel(int i3, int i16, int i17, int i18, int i19, int i26) {
        this.mWidth = i3;
        this.mHeight = i16;
        this.left = i17;
        this.top = i18;
        this.right = i19;
        this.bottom = i26;
    }

    public /* synthetic */ FrameInfoModel(int i3, int i16, int i17, int i18, int i19, int i26, int i27, DefaultConstructorMarker defaultConstructorMarker) {
        this((i27 & 1) != 0 ? 0 : i3, (i27 & 2) != 0 ? 0 : i16, (i27 & 4) != 0 ? 0 : i17, (i27 & 8) != 0 ? 0 : i18, (i27 & 16) != 0 ? 0 : i19, (i27 & 32) != 0 ? 0 : i26);
    }
}

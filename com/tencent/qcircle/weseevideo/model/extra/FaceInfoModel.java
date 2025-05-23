package com.tencent.qcircle.weseevideo.model.extra;

import android.graphics.PointF;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u0017\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0006H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\tH\u00c6\u0003J?\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/extra/FaceInfoModel;", "Ljava/io/Serializable;", "mWidth", "", "mHeight", "mFacePoints", "", "Landroid/graphics/PointF;", "mFaceDetectScale", "", "(IILjava/util/List;D)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* data */ class FaceInfoModel implements Serializable {

    @JvmField
    public final double mFaceDetectScale;

    @JvmField
    @Nullable
    public final List<List<PointF>> mFacePoints;

    @JvmField
    public final int mHeight;

    @JvmField
    public final int mWidth;

    public FaceInfoModel() {
        this(0, 0, null, 0.0d, 15, null);
    }

    public static /* synthetic */ FaceInfoModel copy$default(FaceInfoModel faceInfoModel, int i3, int i16, List list, double d16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = faceInfoModel.mWidth;
        }
        if ((i17 & 2) != 0) {
            i16 = faceInfoModel.mHeight;
        }
        int i18 = i16;
        if ((i17 & 4) != 0) {
            list = faceInfoModel.mFacePoints;
        }
        List list2 = list;
        if ((i17 & 8) != 0) {
            d16 = faceInfoModel.mFaceDetectScale;
        }
        return faceInfoModel.copy(i3, i18, list2, d16);
    }

    /* renamed from: component1, reason: from getter */
    public final int getMWidth() {
        return this.mWidth;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMHeight() {
        return this.mHeight;
    }

    @Nullable
    public final List<List<PointF>> component3() {
        return this.mFacePoints;
    }

    /* renamed from: component4, reason: from getter */
    public final double getMFaceDetectScale() {
        return this.mFaceDetectScale;
    }

    @NotNull
    public final FaceInfoModel copy(int mWidth, int mHeight, @Nullable List<? extends List<? extends PointF>> mFacePoints, double mFaceDetectScale) {
        return new FaceInfoModel(mWidth, mHeight, mFacePoints, mFaceDetectScale);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof FaceInfoModel) {
                FaceInfoModel faceInfoModel = (FaceInfoModel) other;
                if (this.mWidth != faceInfoModel.mWidth || this.mHeight != faceInfoModel.mHeight || !Intrinsics.areEqual(this.mFacePoints, faceInfoModel.mFacePoints) || Double.compare(this.mFaceDetectScale, faceInfoModel.mFaceDetectScale) != 0) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16 = ((this.mWidth * 31) + this.mHeight) * 31;
        List<List<PointF>> list = this.mFacePoints;
        if (list != null) {
            i3 = list.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = (i16 + i3) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.mFaceDetectScale);
        return i17 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    @NotNull
    public String toString() {
        return "FaceInfoModel(mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mFacePoints=" + this.mFacePoints + ", mFaceDetectScale=" + this.mFaceDetectScale + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FaceInfoModel(int i3, int i16, @Nullable List<? extends List<? extends PointF>> list, double d16) {
        this.mWidth = i3;
        this.mHeight = i16;
        this.mFacePoints = list;
        this.mFaceDetectScale = d16;
    }

    public /* synthetic */ FaceInfoModel(int i3, int i16, List list, double d16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) == 0 ? i16 : 0, (i17 & 4) != 0 ? null : list, (i17 & 8) != 0 ? 0.0d : d16);
    }
}

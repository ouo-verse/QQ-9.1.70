package com.tencent.mobileqq.wink.editor.crop.model;

import com.tencent.mobileqq.wink.editor.crop.WinkEditorCropRatioView;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0007H\u00c6\u0003J\t\u0010 \u001a\u00020\u0007H\u00c6\u0003J\t\u0010!\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\"\u001a\u00020\rH\u00c6\u0003J\t\u0010#\u001a\u00020\rH\u00c6\u0003Jc\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u00c6\u0001J\u0013\u0010%\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010'H\u0096\u0002J\b\u0010(\u001a\u00020)H\u0016J\t\u0010*\u001a\u00020+H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0015R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/model/SerializableCropInfo;", "Ljava/io/Serializable;", "matrixValues", "", "ratioType", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView$RatioType;", "rotateDegree", "", "cropRectTop", "cropRectBottom", "cropRectRight", "cropRectLeft", "isRotate90", "", "isEmpty", "([FLcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView$RatioType;FFFFFZZ)V", "getCropRectBottom", "()F", "getCropRectLeft", "getCropRectRight", "getCropRectTop", "()Z", "getMatrixValues", "()[F", "getRatioType", "()Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView$RatioType;", "getRotateDegree", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class SerializableCropInfo implements Serializable {
    private final float cropRectBottom;
    private final float cropRectLeft;
    private final float cropRectRight;
    private final float cropRectTop;
    private final boolean isEmpty;
    private final boolean isRotate90;

    @NotNull
    private final float[] matrixValues;

    @NotNull
    private final WinkEditorCropRatioView.RatioType ratioType;
    private final float rotateDegree;

    public SerializableCropInfo() {
        this(null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, false, 511, null);
    }

    public static /* synthetic */ SerializableCropInfo copy$default(SerializableCropInfo serializableCropInfo, float[] fArr, WinkEditorCropRatioView.RatioType ratioType, float f16, float f17, float f18, float f19, float f26, boolean z16, boolean z17, int i3, Object obj) {
        float[] fArr2;
        WinkEditorCropRatioView.RatioType ratioType2;
        float f27;
        float f28;
        float f29;
        float f36;
        float f37;
        boolean z18;
        boolean z19;
        if ((i3 & 1) != 0) {
            fArr2 = serializableCropInfo.matrixValues;
        } else {
            fArr2 = fArr;
        }
        if ((i3 & 2) != 0) {
            ratioType2 = serializableCropInfo.ratioType;
        } else {
            ratioType2 = ratioType;
        }
        if ((i3 & 4) != 0) {
            f27 = serializableCropInfo.rotateDegree;
        } else {
            f27 = f16;
        }
        if ((i3 & 8) != 0) {
            f28 = serializableCropInfo.cropRectTop;
        } else {
            f28 = f17;
        }
        if ((i3 & 16) != 0) {
            f29 = serializableCropInfo.cropRectBottom;
        } else {
            f29 = f18;
        }
        if ((i3 & 32) != 0) {
            f36 = serializableCropInfo.cropRectRight;
        } else {
            f36 = f19;
        }
        if ((i3 & 64) != 0) {
            f37 = serializableCropInfo.cropRectLeft;
        } else {
            f37 = f26;
        }
        if ((i3 & 128) != 0) {
            z18 = serializableCropInfo.isRotate90;
        } else {
            z18 = z16;
        }
        if ((i3 & 256) != 0) {
            z19 = serializableCropInfo.isEmpty;
        } else {
            z19 = z17;
        }
        return serializableCropInfo.copy(fArr2, ratioType2, f27, f28, f29, f36, f37, z18, z19);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final float[] getMatrixValues() {
        return this.matrixValues;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final WinkEditorCropRatioView.RatioType getRatioType() {
        return this.ratioType;
    }

    /* renamed from: component3, reason: from getter */
    public final float getRotateDegree() {
        return this.rotateDegree;
    }

    /* renamed from: component4, reason: from getter */
    public final float getCropRectTop() {
        return this.cropRectTop;
    }

    /* renamed from: component5, reason: from getter */
    public final float getCropRectBottom() {
        return this.cropRectBottom;
    }

    /* renamed from: component6, reason: from getter */
    public final float getCropRectRight() {
        return this.cropRectRight;
    }

    /* renamed from: component7, reason: from getter */
    public final float getCropRectLeft() {
        return this.cropRectLeft;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsRotate90() {
        return this.isRotate90;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsEmpty() {
        return this.isEmpty;
    }

    @NotNull
    public final SerializableCropInfo copy(@NotNull float[] matrixValues, @NotNull WinkEditorCropRatioView.RatioType ratioType, float rotateDegree, float cropRectTop, float cropRectBottom, float cropRectRight, float cropRectLeft, boolean isRotate90, boolean isEmpty) {
        Intrinsics.checkNotNullParameter(matrixValues, "matrixValues");
        Intrinsics.checkNotNullParameter(ratioType, "ratioType");
        return new SerializableCropInfo(matrixValues, ratioType, rotateDegree, cropRectTop, cropRectBottom, cropRectRight, cropRectLeft, isRotate90, isEmpty);
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(SerializableCropInfo.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.crop.model.SerializableCropInfo");
        SerializableCropInfo serializableCropInfo = (SerializableCropInfo) other;
        if (!Arrays.equals(this.matrixValues, serializableCropInfo.matrixValues) || this.ratioType != serializableCropInfo.ratioType) {
            return false;
        }
        if (this.rotateDegree == serializableCropInfo.rotateDegree) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        if (this.cropRectTop == serializableCropInfo.cropRectTop) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            return false;
        }
        if (this.cropRectBottom == serializableCropInfo.cropRectBottom) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z18) {
            return false;
        }
        if (this.cropRectRight == serializableCropInfo.cropRectRight) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (!z19) {
            return false;
        }
        if (this.cropRectLeft == serializableCropInfo.cropRectLeft) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (z26 && this.isRotate90 == serializableCropInfo.isRotate90 && this.isEmpty == serializableCropInfo.isEmpty) {
            return true;
        }
        return false;
    }

    public final float getCropRectBottom() {
        return this.cropRectBottom;
    }

    public final float getCropRectLeft() {
        return this.cropRectLeft;
    }

    public final float getCropRectRight() {
        return this.cropRectRight;
    }

    public final float getCropRectTop() {
        return this.cropRectTop;
    }

    @NotNull
    public final float[] getMatrixValues() {
        return this.matrixValues;
    }

    @NotNull
    public final WinkEditorCropRatioView.RatioType getRatioType() {
        return this.ratioType;
    }

    public final float getRotateDegree() {
        return this.rotateDegree;
    }

    public int hashCode() {
        return (((((((((((((((Arrays.hashCode(this.matrixValues) * 31) + this.ratioType.hashCode()) * 31) + Float.floatToIntBits(this.rotateDegree)) * 31) + Float.floatToIntBits(this.cropRectTop)) * 31) + Float.floatToIntBits(this.cropRectBottom)) * 31) + Float.floatToIntBits(this.cropRectRight)) * 31) + Float.floatToIntBits(this.cropRectLeft)) * 31) + com.tencent.aio.widget.textView.param.a.a(this.isRotate90)) * 31) + com.tencent.aio.widget.textView.param.a.a(this.isEmpty);
    }

    public final boolean isEmpty() {
        return this.isEmpty;
    }

    public final boolean isRotate90() {
        return this.isRotate90;
    }

    @NotNull
    public String toString() {
        return "SerializableCropInfo(matrixValues=" + Arrays.toString(this.matrixValues) + ", ratioType=" + this.ratioType + ", rotateDegree=" + this.rotateDegree + ", cropRectTop=" + this.cropRectTop + ", cropRectBottom=" + this.cropRectBottom + ", cropRectRight=" + this.cropRectRight + ", cropRectLeft=" + this.cropRectLeft + ", isRotate90=" + this.isRotate90 + ", isEmpty=" + this.isEmpty + ")";
    }

    public SerializableCropInfo(@NotNull float[] matrixValues, @NotNull WinkEditorCropRatioView.RatioType ratioType, float f16, float f17, float f18, float f19, float f26, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(matrixValues, "matrixValues");
        Intrinsics.checkNotNullParameter(ratioType, "ratioType");
        this.matrixValues = matrixValues;
        this.ratioType = ratioType;
        this.rotateDegree = f16;
        this.cropRectTop = f17;
        this.cropRectBottom = f18;
        this.cropRectRight = f19;
        this.cropRectLeft = f26;
        this.isRotate90 = z16;
        this.isEmpty = z17;
    }

    public /* synthetic */ SerializableCropInfo(float[] fArr, WinkEditorCropRatioView.RatioType ratioType, float f16, float f17, float f18, float f19, float f26, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new float[9] : fArr, (i3 & 2) != 0 ? WinkEditorCropRatioView.RatioType.FreeRatio : ratioType, (i3 & 4) != 0 ? 0.0f : f16, (i3 & 8) != 0 ? 0.0f : f17, (i3 & 16) != 0 ? 0.0f : f18, (i3 & 32) != 0 ? 0.0f : f19, (i3 & 64) == 0 ? f26 : 0.0f, (i3 & 128) != 0 ? false : z16, (i3 & 256) != 0 ? true : z17);
    }
}

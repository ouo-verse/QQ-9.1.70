package androidx.core.graphics;

import android.graphics.Matrix;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003\u001a\u001a\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u001a\u0015\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0001H\u0086\b\u00a8\u0006\u0010"}, d2 = {"rotationMatrix", "Landroid/graphics/Matrix;", "degrees", "", "px", "py", "scaleMatrix", "sx", "sy", "translationMatrix", "tx", AdParam.TY, Element.ELEMENT_NAME_TIMES, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "values", "", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class MatrixKt {
    @NotNull
    public static final Matrix rotationMatrix(float f16, float f17, float f18) {
        Matrix matrix = new Matrix();
        matrix.setRotate(f16, f17, f18);
        return matrix;
    }

    public static /* synthetic */ Matrix rotationMatrix$default(float f16, float f17, float f18, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f17 = 0.0f;
        }
        if ((i3 & 4) != 0) {
            f18 = 0.0f;
        }
        return rotationMatrix(f16, f17, f18);
    }

    @NotNull
    public static final Matrix scaleMatrix(float f16, float f17) {
        Matrix matrix = new Matrix();
        matrix.setScale(f16, f17);
        return matrix;
    }

    public static /* synthetic */ Matrix scaleMatrix$default(float f16, float f17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 1.0f;
        }
        if ((i3 & 2) != 0) {
            f17 = 1.0f;
        }
        return scaleMatrix(f16, f17);
    }

    @NotNull
    public static final Matrix times(@NotNull Matrix times, @NotNull Matrix m3) {
        Intrinsics.checkNotNullParameter(times, "$this$times");
        Intrinsics.checkNotNullParameter(m3, "m");
        Matrix matrix = new Matrix(times);
        matrix.preConcat(m3);
        return matrix;
    }

    @NotNull
    public static final Matrix translationMatrix(float f16, float f17) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(f16, f17);
        return matrix;
    }

    public static /* synthetic */ Matrix translationMatrix$default(float f16, float f17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 0.0f;
        }
        if ((i3 & 2) != 0) {
            f17 = 0.0f;
        }
        return translationMatrix(f16, f17);
    }

    @NotNull
    public static final float[] values(@NotNull Matrix values) {
        Intrinsics.checkNotNullParameter(values, "$this$values");
        float[] fArr = new float[9];
        values.getValues(fArr);
        return fArr;
    }
}

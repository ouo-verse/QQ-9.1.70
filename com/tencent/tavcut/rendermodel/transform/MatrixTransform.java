package com.tencent.tavcut.rendermodel.transform;

import android.graphics.Matrix;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/tavcut/rendermodel/transform/MatrixTransform;", "", "()V", "MIN_MATRIX_LENGTH", "", "transListMatrixToMatrix", "Landroid/graphics/Matrix;", "srcMatrix", "", "", "transMatrixToListMatrix", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class MatrixTransform {
    public static final MatrixTransform INSTANCE = new MatrixTransform();
    private static final int MIN_MATRIX_LENGTH = 9;

    MatrixTransform() {
    }

    @JvmStatic
    @NotNull
    public static final Matrix transListMatrixToMatrix(@NotNull List<Float> srcMatrix) {
        float[] floatArray;
        Intrinsics.checkParameterIsNotNull(srcMatrix, "srcMatrix");
        Matrix matrix = new Matrix();
        if (srcMatrix.size() >= 9) {
            floatArray = CollectionsKt___CollectionsKt.toFloatArray(srcMatrix);
            matrix.setValues(floatArray);
            return matrix;
        }
        return matrix;
    }

    @JvmStatic
    @NotNull
    public static final List<Float> transMatrixToListMatrix(@NotNull Matrix srcMatrix) {
        Intrinsics.checkParameterIsNotNull(srcMatrix, "srcMatrix");
        ArrayList arrayList = new ArrayList();
        float[] fArr = new float[9];
        srcMatrix.getValues(fArr);
        for (int i3 = 0; i3 < 9; i3++) {
            arrayList.add(Float.valueOf(fArr[i3]));
        }
        return arrayList;
    }
}

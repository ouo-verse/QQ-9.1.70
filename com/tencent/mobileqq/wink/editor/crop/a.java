package com.tencent.mobileqq.wink.editor.crop;

import android.graphics.Matrix;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\b\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0002*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0002*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0002*\u00020\u0000\u001a\n\u0010\b\u001a\u00020\u0002*\u00020\u0000\u001a\n\u0010\t\u001a\u00020\u0002*\u00020\u0000\u00a8\u0006\n"}, d2 = {"Landroid/graphics/Matrix;", "", "", "a", "b", "c", "d", "e", "f", "g", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {
    @NotNull
    public static final List<Float> a(@NotNull Matrix matrix) {
        List<Float> list;
        Intrinsics.checkNotNullParameter(matrix, "<this>");
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        list = ArraysKt___ArraysKt.toList(fArr);
        return list;
    }

    public static final float b(@NotNull Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "<this>");
        return (float) (-(Math.atan2(a(matrix).get(1).floatValue(), a(matrix).get(0).floatValue()) * 57.29577951308232d));
    }

    public static final float c(@NotNull Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "<this>");
        return (float) Math.sqrt(Math.pow(a(matrix).get(0).floatValue(), 2.0d) + Math.pow(a(matrix).get(3).floatValue(), 2.0d));
    }

    public static final float d(@NotNull Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "<this>");
        return a(matrix).get(0).floatValue();
    }

    public static final float e(@NotNull Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "<this>");
        return a(matrix).get(4).floatValue();
    }

    public static final float f(@NotNull Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "<this>");
        return a(matrix).get(2).floatValue();
    }

    public static final float g(@NotNull Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "<this>");
        return a(matrix).get(5).floatValue();
    }
}

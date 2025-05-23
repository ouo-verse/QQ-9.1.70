package com.tencent.mobileqq.qqvideoedit.editor.crop;

import android.graphics.Matrix;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"Landroid/graphics/Matrix;", "", "", "a", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
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
}

package com.tencent.state.square.media.utils;

import android.opengl.GLES20;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/square/media/utils/GlFloatArray;", "", "()V", HippyControllerProps.ARRAY, "", "getArray", "()[F", "floatBuffer", "Ljava/nio/FloatBuffer;", "setArray", "", "setVertexAttribPointer", "attributeLocation", "", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class GlFloatArray {
    private final float[] array;
    private FloatBuffer floatBuffer;

    public GlFloatArray() {
        float[] fArr = new float[8];
        this.array = fArr;
        FloatBuffer put = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr);
        Intrinsics.checkNotNullExpressionValue(put, "ByteBuffer\n        .allo\u2026fer()\n        .put(array)");
        this.floatBuffer = put;
    }

    public final float[] getArray() {
        return this.array;
    }

    public final void setArray(float[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.floatBuffer.position(0);
        this.floatBuffer.put(array);
    }

    public final void setVertexAttribPointer(int attributeLocation) {
        this.floatBuffer.position(0);
        GLES20.glVertexAttribPointer(attributeLocation, 2, 5126, false, 0, (Buffer) this.floatBuffer);
        GLES20.glEnableVertexAttribArray(attributeLocation);
    }
}

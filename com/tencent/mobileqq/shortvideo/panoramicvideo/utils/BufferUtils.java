package com.tencent.mobileqq.shortvideo.panoramicvideo.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class BufferUtils {
    public static FloatBuffer getFloatBuffer(float[] fArr, int i3) {
        FloatBuffer put = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr);
        put.position(i3);
        return put;
    }

    public static ShortBuffer getShortBuffer(short[] sArr, int i3) {
        ShortBuffer put = ByteBuffer.allocateDirect(sArr.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer().put(sArr);
        put.position(i3);
        return put;
    }
}

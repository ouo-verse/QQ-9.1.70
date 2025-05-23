package com.tencent.liteav.videobase.utils;

import com.tencent.liteav.base.annotations.JNINamespace;
import java.nio.ByteBuffer;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class YUVReadTools {
    public static native void nativeReadYUVPlanesForByteArray(int i3, int i16, byte[] bArr);

    public static native void nativeReadYUVPlanesForByteBuffer(int i3, int i16, ByteBuffer byteBuffer);
}

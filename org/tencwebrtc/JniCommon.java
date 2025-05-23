package org.tencwebrtc;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class JniCommon {
    public static native void nativeAddRef(long j3);

    public static native ByteBuffer nativeAllocateByteBuffer(int i3);

    public static native void nativeFreeByteBuffer(ByteBuffer byteBuffer);

    public static native void nativeReleaseRef(long j3);
}

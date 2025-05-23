package com.google.android.filament;

import androidx.annotation.NonNull;
import com.google.android.filament.proguard.UsedByNative;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

/* compiled from: P */
@UsedByNative("NioUtils.cpp")
/* loaded from: classes2.dex */
final class NioUtils {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    enum BufferType {
        BYTE,
        CHAR,
        SHORT,
        INT,
        LONG,
        FLOAT,
        DOUBLE
    }

    NioUtils() {
    }

    @UsedByNative("NioUtils.cpp")
    static Object getBaseArray(@NonNull Buffer buffer) {
        if (buffer.hasArray()) {
            return buffer.array();
        }
        return null;
    }

    @UsedByNative("NioUtils.cpp")
    static int getBaseArrayOffset(@NonNull Buffer buffer, int i3) {
        if (buffer.hasArray()) {
            return (buffer.arrayOffset() + buffer.position()) << i3;
        }
        return 0;
    }

    @UsedByNative("NioUtils.cpp")
    static long getBasePointer(@NonNull Buffer buffer, long j3, int i3) {
        if (j3 == 0) {
            return 0L;
        }
        return (buffer.position() << i3) + j3;
    }

    @UsedByNative("NioUtils.cpp")
    static int getBufferType(@NonNull Buffer buffer) {
        if (buffer instanceof ByteBuffer) {
            return BufferType.BYTE.ordinal();
        }
        if (buffer instanceof CharBuffer) {
            return BufferType.CHAR.ordinal();
        }
        if (buffer instanceof ShortBuffer) {
            return BufferType.SHORT.ordinal();
        }
        if (buffer instanceof IntBuffer) {
            return BufferType.INT.ordinal();
        }
        if (buffer instanceof LongBuffer) {
            return BufferType.LONG.ordinal();
        }
        if (buffer instanceof FloatBuffer) {
            return BufferType.FLOAT.ordinal();
        }
        return BufferType.DOUBLE.ordinal();
    }
}

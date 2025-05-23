package com.tencent.filament.zplanservice.nativebuffer;

import java.nio.ByteBuffer;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082 J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0082 J\u001b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0082 \u00a8\u0006\r"}, d2 = {"Lcom/tencent/filament/zplanservice/nativebuffer/NativeBuffer;", "", "", "size", "", "nNativeAllocate", "nativeHandle", "", "nNativeFree", "bufferSize", "Ljava/nio/ByteBuffer;", "nNativeGetBuffer", "a", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class NativeBuffer {
    private final native long nNativeAllocate(int size);

    private final native void nNativeFree(long nativeHandle);

    private final native ByteBuffer nNativeGetBuffer(long nativeHandle, int bufferSize);
}

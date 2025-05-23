package com.tencent.mobileqq.triton.internal.script;

import com.tencent.mobileqq.triton.internal.utils.Consts;
import io.github.landerlyoung.jenny.NativeClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@NativeClass(namespace = Consts.JNI_NAMESPACE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003J)\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0082 J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0006J\u0019\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0082 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/script/NativeBufferManager;", "", "scriptRuntimeHandle", "", "(J)V", "createBuffer", "", "buffer", "", "offset", "length", "createNativeBuffer", "getBuffer", "bufferHandle", "getNativeBuffer", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class NativeBufferManager {
    private final long scriptRuntimeHandle;

    public NativeBufferManager(long j3) {
        this.scriptRuntimeHandle = j3;
    }

    private final native int createNativeBuffer(long scriptRuntimeHandle, byte[] buffer, long offset, long length);

    private final native byte[] getNativeBuffer(long scriptRuntimeHandle, int bufferHandle);

    public final int createBuffer(@NotNull byte[] buffer, long offset, long length) {
        Intrinsics.checkParameterIsNotNull(buffer, "buffer");
        try {
            return createNativeBuffer(this.scriptRuntimeHandle, buffer, offset, length);
        } catch (UnsatisfiedLinkError unused) {
            return createNativeBuffer(this.scriptRuntimeHandle, buffer, offset, length);
        }
    }

    @NotNull
    public final byte[] getBuffer(int bufferHandle) {
        try {
            return getNativeBuffer(this.scriptRuntimeHandle, bufferHandle);
        } catch (UnsatisfiedLinkError unused) {
            return getNativeBuffer(this.scriptRuntimeHandle, bufferHandle);
        }
    }
}

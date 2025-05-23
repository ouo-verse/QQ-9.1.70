package com.tencent.mm.appbrand.commonjni;

import androidx.annotation.Keep;
import com.tencent.luggage.wxa.a9.b;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016JS\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0086 J\u0011\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0002H\u0086 J\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0002H\u0086 J\u0011\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0002H\u0086 \u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mm/appbrand/commonjni/TWasmCacheManagerJni;", "", "", "isolatePtr", "contextPtr", "", "appId", "packageMD5", "Ljava/nio/ByteBuffer;", "wasmBuffer", "wasmPath", "wasmCachePath", "", "threadNum", "funcListBuffer", "createTask", "task", "", "destroyTask", "start", "stop", "<init>", "()V", "Companion", "a", "lib-wxa-common-binding_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class TWasmCacheManagerJni {

    @NotNull
    public static final String TAG = "TWasmCacheManagerJni";

    static {
        b.a("wxa-runtime-binding");
    }

    public final native long createTask(long isolatePtr, long contextPtr, @NotNull String appId, @NotNull String packageMD5, @NotNull ByteBuffer wasmBuffer, @NotNull String wasmPath, @NotNull String wasmCachePath, int threadNum, @Nullable ByteBuffer funcListBuffer);

    public final native void destroyTask(long task);

    @Nullable
    public final native String start(long task);

    public final native void stop(long task);
}

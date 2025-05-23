package com.tencent.filament.zplan.data;

import com.tencent.filament.zplanservice.util.log.FLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003H\u00c2\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0082 J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/filament/zplan/data/NativeBuffer;", "", "pointer", "", "size", "(JJ)V", "data", "", "getData", "()[B", "getSize", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "nGetBytes", "toString", "", "Companion", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class NativeBuffer {
    private static final String ARRAY_BUFFER = "__ArrayBuffer__";
    private static final String ARRAY_BUFFER_DATA = "data";
    private static final String ARRAY_BUFFER_SIZE = "size";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "NativeBuffer";

    @NotNull
    private final byte[] data;
    private final long pointer;
    private final long size;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/filament/zplan/data/NativeBuffer$Companion;", "", "()V", "ARRAY_BUFFER", "", "ARRAY_BUFFER_DATA", "ARRAY_BUFFER_SIZE", "TAG", "from", "Lcom/tencent/filament/zplan/data/NativeBuffer;", "bufferDesc", "buffer", "Lorg/json/JSONObject;", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final NativeBuffer from(@NotNull String bufferDesc) {
            Intrinsics.checkNotNullParameter(bufferDesc, "bufferDesc");
            try {
                return from(new JSONObject(bufferDesc));
            } catch (JSONException unused) {
                return null;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final NativeBuffer from(@NotNull JSONObject buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            if (!buffer.optBoolean(NativeBuffer.ARRAY_BUFFER)) {
                return null;
            }
            try {
                String optString = buffer.optString("data");
                Intrinsics.checkNotNullExpressionValue(optString, "buffer.optString(ARRAY_BUFFER_DATA)");
                long parseLong = Long.parseLong(optString);
                String optString2 = buffer.optString("size");
                Intrinsics.checkNotNullExpressionValue(optString2, "buffer.optString(ARRAY_BUFFER_SIZE)");
                long parseLong2 = Long.parseLong(optString2);
                if (parseLong2 <= 0) {
                    return null;
                }
                try {
                    return new NativeBuffer(parseLong, parseLong2);
                } catch (OutOfMemoryError e16) {
                    FLog.INSTANCE.e(NativeBuffer.TAG, "create NativeBuffer OOM, from:" + buffer + " exception", e16);
                    return null;
                } catch (RuntimeException e17) {
                    FLog.INSTANCE.e(NativeBuffer.TAG, "create NativeBuffer RuntimeException, from:" + buffer + " exception", e17);
                    return null;
                }
            } catch (NumberFormatException unused) {
                return null;
            }
        }
    }

    public NativeBuffer(long j3, long j16) {
        this.pointer = j3;
        this.size = j16;
        byte[] nGetBytes = nGetBytes(j3, j16);
        if (nGetBytes != null) {
            this.data = (byte[]) nGetBytes.clone();
            return;
        }
        throw new RuntimeException("NativeBuffer nGetBytes fail, " + this);
    }

    /* renamed from: component1, reason: from getter */
    private final long getPointer() {
        return this.pointer;
    }

    public static /* synthetic */ NativeBuffer copy$default(NativeBuffer nativeBuffer, long j3, long j16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = nativeBuffer.pointer;
        }
        if ((i3 & 2) != 0) {
            j16 = nativeBuffer.size;
        }
        return nativeBuffer.copy(j3, j16);
    }

    private final native byte[] nGetBytes(long data, long size);

    /* renamed from: component2, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    @NotNull
    public final NativeBuffer copy(long pointer, long size) {
        return new NativeBuffer(pointer, size);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof NativeBuffer) {
                NativeBuffer nativeBuffer = (NativeBuffer) other;
                if (this.pointer != nativeBuffer.pointer || this.size != nativeBuffer.size) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final byte[] getData() {
        return this.data;
    }

    public final long getSize() {
        return this.size;
    }

    public int hashCode() {
        long j3 = this.pointer;
        int i3 = ((int) (j3 ^ (j3 >>> 32))) * 31;
        long j16 = this.size;
        return i3 + ((int) ((j16 >>> 32) ^ j16));
    }

    @NotNull
    public String toString() {
        return "NativeBuffer(pointer=" + this.pointer + ", size=" + this.size + ")";
    }
}

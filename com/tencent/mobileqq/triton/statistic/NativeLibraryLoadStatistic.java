package com.tencent.mobileqq.triton.statistic;

import com.tencent.ams.dsdk.monitor.metric.event.TagValue;
import com.tencent.mobileqq.triton.exception.TritonException;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\nH\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\fH\u00c6\u0003JI\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/triton/statistic/NativeLibraryLoadStatistic;", "", "success", "", "name", "", "file", "Ljava/io/File;", "isOptional", "loadTimeMs", "", TagValue.LOAD_EXCEPTION, "Lcom/tencent/mobileqq/triton/exception/TritonException;", "(ZLjava/lang/String;Ljava/io/File;ZJLcom/tencent/mobileqq/triton/exception/TritonException;)V", "getFile", "()Ljava/io/File;", "()Z", "getLoadException", "()Lcom/tencent/mobileqq/triton/exception/TritonException;", "getLoadTimeMs", "()J", "getName", "()Ljava/lang/String;", "getSuccess", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final /* data */ class NativeLibraryLoadStatistic {

    @Nullable
    private final File file;
    private final boolean isOptional;

    @Nullable
    private final TritonException loadException;
    private final long loadTimeMs;

    @NotNull
    private final String name;
    private final boolean success;

    public NativeLibraryLoadStatistic(boolean z16, @NotNull String name, @Nullable File file, boolean z17, long j3, @Nullable TritonException tritonException) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        this.success = z16;
        this.name = name;
        this.file = file;
        this.isOptional = z17;
        this.loadTimeMs = j3;
        this.loadException = tritonException;
    }

    public static /* synthetic */ NativeLibraryLoadStatistic copy$default(NativeLibraryLoadStatistic nativeLibraryLoadStatistic, boolean z16, String str, File file, boolean z17, long j3, TritonException tritonException, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = nativeLibraryLoadStatistic.success;
        }
        if ((i3 & 2) != 0) {
            str = nativeLibraryLoadStatistic.name;
        }
        String str2 = str;
        if ((i3 & 4) != 0) {
            file = nativeLibraryLoadStatistic.file;
        }
        File file2 = file;
        if ((i3 & 8) != 0) {
            z17 = nativeLibraryLoadStatistic.isOptional;
        }
        boolean z18 = z17;
        if ((i3 & 16) != 0) {
            j3 = nativeLibraryLoadStatistic.loadTimeMs;
        }
        long j16 = j3;
        if ((i3 & 32) != 0) {
            tritonException = nativeLibraryLoadStatistic.loadException;
        }
        return nativeLibraryLoadStatistic.copy(z16, str2, file2, z18, j16, tritonException);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final File getFile() {
        return this.file;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsOptional() {
        return this.isOptional;
    }

    /* renamed from: component5, reason: from getter */
    public final long getLoadTimeMs() {
        return this.loadTimeMs;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final TritonException getLoadException() {
        return this.loadException;
    }

    @NotNull
    public final NativeLibraryLoadStatistic copy(boolean success, @NotNull String name, @Nullable File file, boolean isOptional, long loadTimeMs, @Nullable TritonException loadException) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        return new NativeLibraryLoadStatistic(success, name, file, isOptional, loadTimeMs, loadException);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof NativeLibraryLoadStatistic) {
                NativeLibraryLoadStatistic nativeLibraryLoadStatistic = (NativeLibraryLoadStatistic) other;
                if (this.success != nativeLibraryLoadStatistic.success || !Intrinsics.areEqual(this.name, nativeLibraryLoadStatistic.name) || !Intrinsics.areEqual(this.file, nativeLibraryLoadStatistic.file) || this.isOptional != nativeLibraryLoadStatistic.isOptional || this.loadTimeMs != nativeLibraryLoadStatistic.loadTimeMs || !Intrinsics.areEqual(this.loadException, nativeLibraryLoadStatistic.loadException)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final File getFile() {
        return this.file;
    }

    @Nullable
    public final TritonException getLoadException() {
        return this.loadException;
    }

    public final long getLoadTimeMs() {
        return this.loadTimeMs;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public int hashCode() {
        int i3;
        int i16;
        boolean z16 = this.success;
        int i17 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i18 = r06 * 31;
        String str = this.name;
        int i19 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i26 = (i18 + i3) * 31;
        File file = this.file;
        if (file != null) {
            i16 = file.hashCode();
        } else {
            i16 = 0;
        }
        int i27 = (i26 + i16) * 31;
        boolean z17 = this.isOptional;
        if (!z17) {
            i17 = z17 ? 1 : 0;
        }
        int i28 = (i27 + i17) * 31;
        long j3 = this.loadTimeMs;
        int i29 = (i28 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        TritonException tritonException = this.loadException;
        if (tritonException != null) {
            i19 = tritonException.hashCode();
        }
        return i29 + i19;
    }

    public final boolean isOptional() {
        return this.isOptional;
    }

    @NotNull
    public String toString() {
        return "NativeLibraryLoadStatistic(success=" + this.success + ", name=" + this.name + ", file=" + this.file + ", isOptional=" + this.isOptional + ", loadTimeMs=" + this.loadTimeMs + ", loadException=" + this.loadException + ")";
    }
}

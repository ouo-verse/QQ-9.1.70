package cl0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcl0/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "surfaceDestroyTimeout", "J", "b", "()J", "sceneDestroyDelayTimeMillis", "a", "<init>", "(JJ)V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: cl0.h, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class FilamentTextureViewConfig {

    @SerializedName("sceneDestroyDelayTimeMillis")
    private final long sceneDestroyDelayTimeMillis;

    @SerializedName("surfaceDestroyTimeout")
    private final long surfaceDestroyTimeout;

    public FilamentTextureViewConfig() {
        this(0L, 0L, 3, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getSceneDestroyDelayTimeMillis() {
        return this.sceneDestroyDelayTimeMillis;
    }

    /* renamed from: b, reason: from getter */
    public final long getSurfaceDestroyTimeout() {
        return this.surfaceDestroyTimeout;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof FilamentTextureViewConfig) {
                FilamentTextureViewConfig filamentTextureViewConfig = (FilamentTextureViewConfig) other;
                if (this.surfaceDestroyTimeout != filamentTextureViewConfig.surfaceDestroyTimeout || this.sceneDestroyDelayTimeMillis != filamentTextureViewConfig.sceneDestroyDelayTimeMillis) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j3 = this.surfaceDestroyTimeout;
        int i3 = ((int) (j3 ^ (j3 >>> 32))) * 31;
        long j16 = this.sceneDestroyDelayTimeMillis;
        return i3 + ((int) ((j16 >>> 32) ^ j16));
    }

    @NotNull
    public String toString() {
        return "FilamentTextureViewConfig(surfaceDestroyTimeout=" + this.surfaceDestroyTimeout + ", sceneDestroyDelayTimeMillis=" + this.sceneDestroyDelayTimeMillis + ")";
    }

    public FilamentTextureViewConfig(long j3, long j16) {
        this.surfaceDestroyTimeout = j3;
        this.sceneDestroyDelayTimeMillis = j16;
    }

    public /* synthetic */ FilamentTextureViewConfig(long j3, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 200L : j3, (i3 & 2) != 0 ? 2000L : j16);
    }
}

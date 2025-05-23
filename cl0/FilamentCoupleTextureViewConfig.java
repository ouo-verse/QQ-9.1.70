package cl0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcl0/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "surfaceDestroyTimeout", "J", "a", "()J", "<init>", "(J)V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: cl0.b, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class FilamentCoupleTextureViewConfig {

    @SerializedName("surfaceDestroyTimeout")
    private final long surfaceDestroyTimeout;

    public FilamentCoupleTextureViewConfig() {
        this(0L, 1, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getSurfaceDestroyTimeout() {
        return this.surfaceDestroyTimeout;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (!(other instanceof FilamentCoupleTextureViewConfig) || this.surfaceDestroyTimeout != ((FilamentCoupleTextureViewConfig) other).surfaceDestroyTimeout) {
                return false;
            }
            return true;
        }
        return true;
    }

    public int hashCode() {
        long j3 = this.surfaceDestroyTimeout;
        return (int) (j3 ^ (j3 >>> 32));
    }

    @NotNull
    public String toString() {
        return "FilamentCoupleTextureViewConfig(surfaceDestroyTimeout=" + this.surfaceDestroyTimeout + ")";
    }

    public FilamentCoupleTextureViewConfig(long j3) {
        this.surfaceDestroyTimeout = j3;
    }

    public /* synthetic */ FilamentCoupleTextureViewConfig(long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 600L : j3);
    }
}

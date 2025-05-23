package cl0;

import com.google.gson.annotations.SerializedName;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcl0/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "enableShadow", "Z", "c", "()Z", "enableFxaa", "b", "enableBloom", "a", "", "renderTargetScale", UserInfo.SEX_FEMALE, "d", "()F", "<init>", "(ZZZF)V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: cl0.i, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class GpuOptimizeOptions {

    @SerializedName("enableBloom")
    private final boolean enableBloom;

    @SerializedName("enableFxaa")
    private final boolean enableFxaa;

    @SerializedName("enableShadow")
    private final boolean enableShadow;

    @SerializedName("renderTargetScale")
    private final float renderTargetScale;

    public GpuOptimizeOptions() {
        this(false, false, false, 0.0f, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getEnableBloom() {
        return this.enableBloom;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getEnableFxaa() {
        return this.enableFxaa;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getEnableShadow() {
        return this.enableShadow;
    }

    /* renamed from: d, reason: from getter */
    public final float getRenderTargetScale() {
        return this.renderTargetScale;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof GpuOptimizeOptions) {
                GpuOptimizeOptions gpuOptimizeOptions = (GpuOptimizeOptions) other;
                if (this.enableShadow != gpuOptimizeOptions.enableShadow || this.enableFxaa != gpuOptimizeOptions.enableFxaa || this.enableBloom != gpuOptimizeOptions.enableBloom || Float.compare(this.renderTargetScale, gpuOptimizeOptions.renderTargetScale) != 0) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.enableShadow;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.enableFxaa;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        boolean z17 = this.enableBloom;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((i18 + i3) * 31) + Float.floatToIntBits(this.renderTargetScale);
    }

    @NotNull
    public String toString() {
        return "GpuOptimizeOptions(enableShadow=" + this.enableShadow + ", enableFxaa=" + this.enableFxaa + ", enableBloom=" + this.enableBloom + ", renderTargetScale=" + this.renderTargetScale + ")";
    }

    public GpuOptimizeOptions(boolean z16, boolean z17, boolean z18, float f16) {
        this.enableShadow = z16;
        this.enableFxaa = z17;
        this.enableBloom = z18;
        this.renderTargetScale = f16;
    }

    public /* synthetic */ GpuOptimizeOptions(boolean z16, boolean z17, boolean z18, float f16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? true : z17, (i3 & 4) != 0 ? true : z18, (i3 & 8) != 0 ? 1.0f : f16);
    }
}

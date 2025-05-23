package com.tencent.tavcut.core.render.builder.light.model.asset;

import androidx.fragment.app.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\"\u001a\u00020\rH\u00c6\u0003J[\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u00c6\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010'\u001a\u00020\u0005H\u00d6\u0001J\t\u0010(\u001a\u00020)H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006*"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/model/asset/MaterialConfig;", "", "type", "Lcom/tencent/tavcut/core/render/builder/light/model/asset/MediaType;", "minAssetCount", "", "maxAssetCount", "minVideoDuration", "minImageDuration", "maxImageDuration", "preferredCoverTime", "", "preferredCoverTimePercent", "", "(Lcom/tencent/tavcut/core/render/builder/light/model/asset/MediaType;IIIIIJF)V", "getMaxAssetCount", "()I", "getMaxImageDuration", "getMinAssetCount", "getMinImageDuration", "getMinVideoDuration", "getPreferredCoverTime", "()J", "getPreferredCoverTimePercent", "()F", "getType", "()Lcom/tencent/tavcut/core/render/builder/light/model/asset/MediaType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class MaterialConfig {
    private final int maxAssetCount;
    private final int maxImageDuration;
    private final int minAssetCount;
    private final int minImageDuration;
    private final int minVideoDuration;
    private final long preferredCoverTime;
    private final float preferredCoverTimePercent;

    @Nullable
    private final MediaType type;

    public MaterialConfig(@Nullable MediaType mediaType, int i3, int i16, int i17, int i18, int i19, long j3, float f16) {
        this.type = mediaType;
        this.minAssetCount = i3;
        this.maxAssetCount = i16;
        this.minVideoDuration = i17;
        this.minImageDuration = i18;
        this.maxImageDuration = i19;
        this.preferredCoverTime = j3;
        this.preferredCoverTimePercent = f16;
    }

    public static /* synthetic */ MaterialConfig copy$default(MaterialConfig materialConfig, MediaType mediaType, int i3, int i16, int i17, int i18, int i19, long j3, float f16, int i26, Object obj) {
        MediaType mediaType2;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        long j16;
        float f17;
        if ((i26 & 1) != 0) {
            mediaType2 = materialConfig.type;
        } else {
            mediaType2 = mediaType;
        }
        if ((i26 & 2) != 0) {
            i27 = materialConfig.minAssetCount;
        } else {
            i27 = i3;
        }
        if ((i26 & 4) != 0) {
            i28 = materialConfig.maxAssetCount;
        } else {
            i28 = i16;
        }
        if ((i26 & 8) != 0) {
            i29 = materialConfig.minVideoDuration;
        } else {
            i29 = i17;
        }
        if ((i26 & 16) != 0) {
            i36 = materialConfig.minImageDuration;
        } else {
            i36 = i18;
        }
        if ((i26 & 32) != 0) {
            i37 = materialConfig.maxImageDuration;
        } else {
            i37 = i19;
        }
        if ((i26 & 64) != 0) {
            j16 = materialConfig.preferredCoverTime;
        } else {
            j16 = j3;
        }
        if ((i26 & 128) != 0) {
            f17 = materialConfig.preferredCoverTimePercent;
        } else {
            f17 = f16;
        }
        return materialConfig.copy(mediaType2, i27, i28, i29, i36, i37, j16, f17);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final MediaType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMinAssetCount() {
        return this.minAssetCount;
    }

    /* renamed from: component3, reason: from getter */
    public final int getMaxAssetCount() {
        return this.maxAssetCount;
    }

    /* renamed from: component4, reason: from getter */
    public final int getMinVideoDuration() {
        return this.minVideoDuration;
    }

    /* renamed from: component5, reason: from getter */
    public final int getMinImageDuration() {
        return this.minImageDuration;
    }

    /* renamed from: component6, reason: from getter */
    public final int getMaxImageDuration() {
        return this.maxImageDuration;
    }

    /* renamed from: component7, reason: from getter */
    public final long getPreferredCoverTime() {
        return this.preferredCoverTime;
    }

    /* renamed from: component8, reason: from getter */
    public final float getPreferredCoverTimePercent() {
        return this.preferredCoverTimePercent;
    }

    @NotNull
    public final MaterialConfig copy(@Nullable MediaType type, int minAssetCount, int maxAssetCount, int minVideoDuration, int minImageDuration, int maxImageDuration, long preferredCoverTime, float preferredCoverTimePercent) {
        return new MaterialConfig(type, minAssetCount, maxAssetCount, minVideoDuration, minImageDuration, maxImageDuration, preferredCoverTime, preferredCoverTimePercent);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof MaterialConfig) {
                MaterialConfig materialConfig = (MaterialConfig) other;
                if (!Intrinsics.areEqual(this.type, materialConfig.type) || this.minAssetCount != materialConfig.minAssetCount || this.maxAssetCount != materialConfig.maxAssetCount || this.minVideoDuration != materialConfig.minVideoDuration || this.minImageDuration != materialConfig.minImageDuration || this.maxImageDuration != materialConfig.maxImageDuration || this.preferredCoverTime != materialConfig.preferredCoverTime || Float.compare(this.preferredCoverTimePercent, materialConfig.preferredCoverTimePercent) != 0) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getMaxAssetCount() {
        return this.maxAssetCount;
    }

    public final int getMaxImageDuration() {
        return this.maxImageDuration;
    }

    public final int getMinAssetCount() {
        return this.minAssetCount;
    }

    public final int getMinImageDuration() {
        return this.minImageDuration;
    }

    public final int getMinVideoDuration() {
        return this.minVideoDuration;
    }

    public final long getPreferredCoverTime() {
        return this.preferredCoverTime;
    }

    public final float getPreferredCoverTimePercent() {
        return this.preferredCoverTimePercent;
    }

    @Nullable
    public final MediaType getType() {
        return this.type;
    }

    public int hashCode() {
        int i3;
        MediaType mediaType = this.type;
        if (mediaType != null) {
            i3 = mediaType.hashCode();
        } else {
            i3 = 0;
        }
        return (((((((((((((i3 * 31) + this.minAssetCount) * 31) + this.maxAssetCount) * 31) + this.minVideoDuration) * 31) + this.minImageDuration) * 31) + this.maxImageDuration) * 31) + a.a(this.preferredCoverTime)) * 31) + Float.floatToIntBits(this.preferredCoverTimePercent);
    }

    @NotNull
    public String toString() {
        return "MaterialConfig(type=" + this.type + ", minAssetCount=" + this.minAssetCount + ", maxAssetCount=" + this.maxAssetCount + ", minVideoDuration=" + this.minVideoDuration + ", minImageDuration=" + this.minImageDuration + ", maxImageDuration=" + this.maxImageDuration + ", preferredCoverTime=" + this.preferredCoverTime + ", preferredCoverTimePercent=" + this.preferredCoverTimePercent + ")";
    }

    public /* synthetic */ MaterialConfig(MediaType mediaType, int i3, int i16, int i17, int i18, int i19, long j3, float f16, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this((i26 & 1) != 0 ? null : mediaType, i3, i16, i17, i18, i19, j3, f16);
    }
}

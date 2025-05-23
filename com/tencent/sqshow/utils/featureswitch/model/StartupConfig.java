package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0016\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "characterMemoryThreshold", UserInfo.SEX_FEMALE, "a", "()F", "fpsMemoryThreshold", "b", "minFps", "I", "f", "()I", "maxFps", "d", "minCharacters", "e", "maxCharacters", "c", "<init>", "(FFIIII)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.m, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class StartupConfig {

    @SerializedName("characterMemoryThreshold")
    private final float characterMemoryThreshold;

    @SerializedName("fpsMemoryThreshold")
    private final float fpsMemoryThreshold;

    @SerializedName("maxCharacters")
    private final int maxCharacters;

    @SerializedName("maxFps")
    private final int maxFps;

    @SerializedName("minCharacters")
    private final int minCharacters;

    @SerializedName("minFps")
    private final int minFps;

    public StartupConfig() {
        this(0.0f, 0.0f, 0, 0, 0, 0, 63, null);
    }

    /* renamed from: a, reason: from getter */
    public final float getCharacterMemoryThreshold() {
        return this.characterMemoryThreshold;
    }

    /* renamed from: b, reason: from getter */
    public final float getFpsMemoryThreshold() {
        return this.fpsMemoryThreshold;
    }

    /* renamed from: c, reason: from getter */
    public final int getMaxCharacters() {
        return this.maxCharacters;
    }

    /* renamed from: d, reason: from getter */
    public final int getMaxFps() {
        return this.maxFps;
    }

    /* renamed from: e, reason: from getter */
    public final int getMinCharacters() {
        return this.minCharacters;
    }

    /* renamed from: f, reason: from getter */
    public final int getMinFps() {
        return this.minFps;
    }

    public int hashCode() {
        return (((((((((Float.floatToIntBits(this.characterMemoryThreshold) * 31) + Float.floatToIntBits(this.fpsMemoryThreshold)) * 31) + this.minFps) * 31) + this.maxFps) * 31) + this.minCharacters) * 31) + this.maxCharacters;
    }

    public String toString() {
        return "StartupConfig(characterMemoryThreshold=" + this.characterMemoryThreshold + ", fpsMemoryThreshold=" + this.fpsMemoryThreshold + ", minFps=" + this.minFps + ", maxFps=" + this.maxFps + ", minCharacters=" + this.minCharacters + ", maxCharacters=" + this.maxCharacters + ')';
    }

    public StartupConfig(float f16, float f17, int i3, int i16, int i17, int i18) {
        this.characterMemoryThreshold = f16;
        this.fpsMemoryThreshold = f17;
        this.minFps = i3;
        this.maxFps = i16;
        this.minCharacters = i17;
        this.maxCharacters = i18;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StartupConfig)) {
            return false;
        }
        StartupConfig startupConfig = (StartupConfig) other;
        return Float.compare(this.characterMemoryThreshold, startupConfig.characterMemoryThreshold) == 0 && Float.compare(this.fpsMemoryThreshold, startupConfig.fpsMemoryThreshold) == 0 && this.minFps == startupConfig.minFps && this.maxFps == startupConfig.maxFps && this.minCharacters == startupConfig.minCharacters && this.maxCharacters == startupConfig.maxCharacters;
    }

    public /* synthetic */ StartupConfig(float f16, float f17, int i3, int i16, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? 0.0f : f16, (i19 & 2) == 0 ? f17 : 0.0f, (i19 & 4) != 0 ? 15 : i3, (i19 & 8) != 0 ? 30 : i16, (i19 & 16) != 0 ? 2 : i17, (i19 & 32) != 0 ? 3 : i18);
    }
}

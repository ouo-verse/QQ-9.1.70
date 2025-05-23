package com.tencent.karaoke.audiobasesdk.audiofx;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\tH\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003JE\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010'\u001a\u00020\u0003H\u00d6\u0001J\t\u0010(\u001a\u00020)H\u00d6\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f\u00a8\u0006*"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/audiofx/OneMixStrategy;", "", "denoiseLevel", "", "vocalScale", "", "accompanyScale", "timbreScale", "pitchCorrectionEnabled", "", "onemixReverbType", "(IFFFZI)V", "getAccompanyScale", "()F", "setAccompanyScale", "(F)V", "getDenoiseLevel", "()I", "setDenoiseLevel", "(I)V", "getOnemixReverbType", "setOnemixReverbType", "getPitchCorrectionEnabled", "()Z", "setPitchCorrectionEnabled", "(Z)V", "getTimbreScale", "setTimbreScale", "getVocalScale", "setVocalScale", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final /* data */ class OneMixStrategy {
    private float accompanyScale;
    private int denoiseLevel;
    private int onemixReverbType;
    private boolean pitchCorrectionEnabled;
    private float timbreScale;
    private float vocalScale;

    public OneMixStrategy(int i3, float f16, float f17, float f18, boolean z16, int i16) {
        this.denoiseLevel = i3;
        this.vocalScale = f16;
        this.accompanyScale = f17;
        this.timbreScale = f18;
        this.pitchCorrectionEnabled = z16;
        this.onemixReverbType = i16;
    }

    @NotNull
    public static /* synthetic */ OneMixStrategy copy$default(OneMixStrategy oneMixStrategy, int i3, float f16, float f17, float f18, boolean z16, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = oneMixStrategy.denoiseLevel;
        }
        if ((i17 & 2) != 0) {
            f16 = oneMixStrategy.vocalScale;
        }
        float f19 = f16;
        if ((i17 & 4) != 0) {
            f17 = oneMixStrategy.accompanyScale;
        }
        float f26 = f17;
        if ((i17 & 8) != 0) {
            f18 = oneMixStrategy.timbreScale;
        }
        float f27 = f18;
        if ((i17 & 16) != 0) {
            z16 = oneMixStrategy.pitchCorrectionEnabled;
        }
        boolean z17 = z16;
        if ((i17 & 32) != 0) {
            i16 = oneMixStrategy.onemixReverbType;
        }
        return oneMixStrategy.copy(i3, f19, f26, f27, z17, i16);
    }

    /* renamed from: component1, reason: from getter */
    public final int getDenoiseLevel() {
        return this.denoiseLevel;
    }

    /* renamed from: component2, reason: from getter */
    public final float getVocalScale() {
        return this.vocalScale;
    }

    /* renamed from: component3, reason: from getter */
    public final float getAccompanyScale() {
        return this.accompanyScale;
    }

    /* renamed from: component4, reason: from getter */
    public final float getTimbreScale() {
        return this.timbreScale;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getPitchCorrectionEnabled() {
        return this.pitchCorrectionEnabled;
    }

    /* renamed from: component6, reason: from getter */
    public final int getOnemixReverbType() {
        return this.onemixReverbType;
    }

    @NotNull
    public final OneMixStrategy copy(int denoiseLevel, float vocalScale, float accompanyScale, float timbreScale, boolean pitchCorrectionEnabled, int onemixReverbType) {
        return new OneMixStrategy(denoiseLevel, vocalScale, accompanyScale, timbreScale, pitchCorrectionEnabled, onemixReverbType);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (this != other) {
            if (other instanceof OneMixStrategy) {
                OneMixStrategy oneMixStrategy = (OneMixStrategy) other;
                if (this.denoiseLevel == oneMixStrategy.denoiseLevel) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && Float.compare(this.vocalScale, oneMixStrategy.vocalScale) == 0 && Float.compare(this.accompanyScale, oneMixStrategy.accompanyScale) == 0 && Float.compare(this.timbreScale, oneMixStrategy.timbreScale) == 0) {
                    if (this.pitchCorrectionEnabled == oneMixStrategy.pitchCorrectionEnabled) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        if (this.onemixReverbType == oneMixStrategy.onemixReverbType) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (z18) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final float getAccompanyScale() {
        return this.accompanyScale;
    }

    public final int getDenoiseLevel() {
        return this.denoiseLevel;
    }

    public final int getOnemixReverbType() {
        return this.onemixReverbType;
    }

    public final boolean getPitchCorrectionEnabled() {
        return this.pitchCorrectionEnabled;
    }

    public final float getTimbreScale() {
        return this.timbreScale;
    }

    public final float getVocalScale() {
        return this.vocalScale;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = ((((((this.denoiseLevel * 31) + Float.floatToIntBits(this.vocalScale)) * 31) + Float.floatToIntBits(this.accompanyScale)) * 31) + Float.floatToIntBits(this.timbreScale)) * 31;
        boolean z16 = this.pitchCorrectionEnabled;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((floatToIntBits + i3) * 31) + this.onemixReverbType;
    }

    public final void setAccompanyScale(float f16) {
        this.accompanyScale = f16;
    }

    public final void setDenoiseLevel(int i3) {
        this.denoiseLevel = i3;
    }

    public final void setOnemixReverbType(int i3) {
        this.onemixReverbType = i3;
    }

    public final void setPitchCorrectionEnabled(boolean z16) {
        this.pitchCorrectionEnabled = z16;
    }

    public final void setTimbreScale(float f16) {
        this.timbreScale = f16;
    }

    public final void setVocalScale(float f16) {
        this.vocalScale = f16;
    }

    @NotNull
    public String toString() {
        return "OneMixStrategy(denoiseLevel=" + this.denoiseLevel + ", vocalScale=" + this.vocalScale + ", accompanyScale=" + this.accompanyScale + ", timbreScale=" + this.timbreScale + ", pitchCorrectionEnabled=" + this.pitchCorrectionEnabled + ", onemixReverbType=" + this.onemixReverbType + ")";
    }
}

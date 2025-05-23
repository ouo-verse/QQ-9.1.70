package com.tencent.karaoke.audiobasesdk.scorer;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0006H\u00c6\u0003J\t\u0010!\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\"\u001a\u00020\tH\u00c6\u0003J\t\u0010#\u001a\u00020\u0006H\u00c6\u0003JE\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010'\u001a\u00020\u0006H\u00d6\u0001J\t\u0010(\u001a\u00020)H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013\u00a8\u0006*"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/scorer/Policy;", "", "acfWeight", "", "pYinWeight", "hitValueNumerator", "", "hitValueDenominator", "originalSpeaker", "", "stcIndex", "(FFIIZI)V", "getAcfWeight", "()F", "setAcfWeight", "(F)V", "getHitValueDenominator", "()I", "setHitValueDenominator", "(I)V", "getHitValueNumerator", "setHitValueNumerator", "getOriginalSpeaker", "()Z", "setOriginalSpeaker", "(Z)V", "getPYinWeight", "setPYinWeight", "getStcIndex", "setStcIndex", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final /* data */ class Policy {
    private float acfWeight;
    private int hitValueDenominator;
    private int hitValueNumerator;
    private boolean originalSpeaker;
    private float pYinWeight;
    private int stcIndex;

    public Policy() {
        this(0.0f, 0.0f, 0, 0, false, 0, 63, null);
    }

    @NotNull
    public static /* synthetic */ Policy copy$default(Policy policy, float f16, float f17, int i3, int i16, boolean z16, int i17, int i18, Object obj) {
        if ((i18 & 1) != 0) {
            f16 = policy.acfWeight;
        }
        if ((i18 & 2) != 0) {
            f17 = policy.pYinWeight;
        }
        float f18 = f17;
        if ((i18 & 4) != 0) {
            i3 = policy.hitValueNumerator;
        }
        int i19 = i3;
        if ((i18 & 8) != 0) {
            i16 = policy.hitValueDenominator;
        }
        int i26 = i16;
        if ((i18 & 16) != 0) {
            z16 = policy.originalSpeaker;
        }
        boolean z17 = z16;
        if ((i18 & 32) != 0) {
            i17 = policy.stcIndex;
        }
        return policy.copy(f16, f18, i19, i26, z17, i17);
    }

    /* renamed from: component1, reason: from getter */
    public final float getAcfWeight() {
        return this.acfWeight;
    }

    /* renamed from: component2, reason: from getter */
    public final float getPYinWeight() {
        return this.pYinWeight;
    }

    /* renamed from: component3, reason: from getter */
    public final int getHitValueNumerator() {
        return this.hitValueNumerator;
    }

    /* renamed from: component4, reason: from getter */
    public final int getHitValueDenominator() {
        return this.hitValueDenominator;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getOriginalSpeaker() {
        return this.originalSpeaker;
    }

    /* renamed from: component6, reason: from getter */
    public final int getStcIndex() {
        return this.stcIndex;
    }

    @NotNull
    public final Policy copy(float acfWeight, float pYinWeight, int hitValueNumerator, int hitValueDenominator, boolean originalSpeaker, int stcIndex) {
        return new Policy(acfWeight, pYinWeight, hitValueNumerator, hitValueDenominator, originalSpeaker, stcIndex);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (this != other) {
            if (other instanceof Policy) {
                Policy policy = (Policy) other;
                if (Float.compare(this.acfWeight, policy.acfWeight) == 0 && Float.compare(this.pYinWeight, policy.pYinWeight) == 0) {
                    if (this.hitValueNumerator == policy.hitValueNumerator) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        if (this.hitValueDenominator == policy.hitValueDenominator) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            if (this.originalSpeaker == policy.originalSpeaker) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            if (z18) {
                                if (this.stcIndex == policy.stcIndex) {
                                    z19 = true;
                                } else {
                                    z19 = false;
                                }
                                if (z19) {
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final float getAcfWeight() {
        return this.acfWeight;
    }

    public final int getHitValueDenominator() {
        return this.hitValueDenominator;
    }

    public final int getHitValueNumerator() {
        return this.hitValueNumerator;
    }

    public final boolean getOriginalSpeaker() {
        return this.originalSpeaker;
    }

    public final float getPYinWeight() {
        return this.pYinWeight;
    }

    public final int getStcIndex() {
        return this.stcIndex;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = ((((((Float.floatToIntBits(this.acfWeight) * 31) + Float.floatToIntBits(this.pYinWeight)) * 31) + this.hitValueNumerator) * 31) + this.hitValueDenominator) * 31;
        boolean z16 = this.originalSpeaker;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((floatToIntBits + i3) * 31) + this.stcIndex;
    }

    public final void setAcfWeight(float f16) {
        this.acfWeight = f16;
    }

    public final void setHitValueDenominator(int i3) {
        this.hitValueDenominator = i3;
    }

    public final void setHitValueNumerator(int i3) {
        this.hitValueNumerator = i3;
    }

    public final void setOriginalSpeaker(boolean z16) {
        this.originalSpeaker = z16;
    }

    public final void setPYinWeight(float f16) {
        this.pYinWeight = f16;
    }

    public final void setStcIndex(int i3) {
        this.stcIndex = i3;
    }

    @NotNull
    public String toString() {
        return "Policy(acfWeight=" + this.acfWeight + ", pYinWeight=" + this.pYinWeight + ", hitValueNumerator=" + this.hitValueNumerator + ", hitValueDenominator=" + this.hitValueDenominator + ", originalSpeaker=" + this.originalSpeaker + ", stcIndex=" + this.stcIndex + ")";
    }

    public Policy(float f16, float f17, int i3, int i16, boolean z16, int i17) {
        this.acfWeight = f16;
        this.pYinWeight = f17;
        this.hitValueNumerator = i3;
        this.hitValueDenominator = i16;
        this.originalSpeaker = z16;
        this.stcIndex = i17;
    }

    public /* synthetic */ Policy(float f16, float f17, int i3, int i16, boolean z16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 1.0f : f16, (i18 & 2) == 0 ? f17 : 1.0f, (i18 & 4) != 0 ? 4 : i3, (i18 & 8) != 0 ? 5 : i16, (i18 & 16) != 0 ? false : z16, (i18 & 32) != 0 ? 0 : i17);
    }
}

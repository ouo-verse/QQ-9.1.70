package com.tencent.karaoke.audiobasesdk.scorer;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\bH\u00c6\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u00d6\u0003J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001J\t\u0010!\u001a\u00020\"H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006#"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/scorer/LoudnessItem;", "Ljava/io/Serializable;", "startMs", "", "endMs", "loudness", "", "valid", "", "(IIFZ)V", "getEndMs", "()I", "setEndMs", "(I)V", "getLoudness", "()F", "setLoudness", "(F)V", "getStartMs", "setStartMs", "getValid", "()Z", "setValid", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final /* data */ class LoudnessItem implements Serializable {
    private int endMs;
    private float loudness;
    private int startMs;
    private boolean valid;

    public LoudnessItem() {
        this(0, 0, 0.0f, false, 15, null);
    }

    @NotNull
    public static /* synthetic */ LoudnessItem copy$default(LoudnessItem loudnessItem, int i3, int i16, float f16, boolean z16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = loudnessItem.startMs;
        }
        if ((i17 & 2) != 0) {
            i16 = loudnessItem.endMs;
        }
        if ((i17 & 4) != 0) {
            f16 = loudnessItem.loudness;
        }
        if ((i17 & 8) != 0) {
            z16 = loudnessItem.valid;
        }
        return loudnessItem.copy(i3, i16, f16, z16);
    }

    /* renamed from: component1, reason: from getter */
    public final int getStartMs() {
        return this.startMs;
    }

    /* renamed from: component2, reason: from getter */
    public final int getEndMs() {
        return this.endMs;
    }

    /* renamed from: component3, reason: from getter */
    public final float getLoudness() {
        return this.loudness;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getValid() {
        return this.valid;
    }

    @NotNull
    public final LoudnessItem copy(int startMs, int endMs, float loudness, boolean valid) {
        return new LoudnessItem(startMs, endMs, loudness, valid);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (this != other) {
            if (other instanceof LoudnessItem) {
                LoudnessItem loudnessItem = (LoudnessItem) other;
                if (this.startMs == loudnessItem.startMs) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (this.endMs == loudnessItem.endMs) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17 && Float.compare(this.loudness, loudnessItem.loudness) == 0) {
                        if (this.valid == loudnessItem.valid) {
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

    public final int getEndMs() {
        return this.endMs;
    }

    public final float getLoudness() {
        return this.loudness;
    }

    public final int getStartMs() {
        return this.startMs;
    }

    public final boolean getValid() {
        return this.valid;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = ((((this.startMs * 31) + this.endMs) * 31) + Float.floatToIntBits(this.loudness)) * 31;
        boolean z16 = this.valid;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return floatToIntBits + i3;
    }

    public final void setEndMs(int i3) {
        this.endMs = i3;
    }

    public final void setLoudness(float f16) {
        this.loudness = f16;
    }

    public final void setStartMs(int i3) {
        this.startMs = i3;
    }

    public final void setValid(boolean z16) {
        this.valid = z16;
    }

    @NotNull
    public String toString() {
        return "LoudnessItem(startMs=" + this.startMs + ", endMs=" + this.endMs + ", loudness=" + this.loudness + ", valid=" + this.valid + ")";
    }

    public LoudnessItem(int i3, int i16, float f16, boolean z16) {
        this.startMs = i3;
        this.endMs = i16;
        this.loudness = f16;
        this.valid = z16;
    }

    public /* synthetic */ LoudnessItem(int i3, int i16, float f16, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? 0 : i16, (i17 & 4) != 0 ? 0.0f : f16, (i17 & 8) != 0 ? false : z16);
    }
}

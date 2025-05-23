package com.tencent.qcircle.weishi.module.publisher.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.autotemplate.model.TAVVolumeAutomaticEffect;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001%B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0007H\u00c6\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0018H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006&"}, d2 = {"Lcom/tencent/qcircle/weishi/module/publisher/data/VolumeAutomaticEffect;", "Landroid/os/Parcelable;", "startOffset", "", "endOffset", "duration", "volumeRange", "Lcom/tencent/qcircle/weishi/module/publisher/data/VolumeRange;", "(JJJLcom/tencent/qcircle/weishi/module/publisher/data/VolumeRange;)V", "getDuration", "()J", "getEndOffset", "getStartOffset", "getVolumeRange", "()Lcom/tencent/qcircle/weishi/module/publisher/data/VolumeRange;", "component1", "component2", "component3", "component4", "convertToAudioVolumeEdge", "Lcom/tencent/tavkit/composition/model/TAVAudioConfiguration$VolumeEdge;", "allDuration", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "Companion", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* data */ class VolumeAutomaticEffect implements Parcelable {

    @NotNull
    public static final String TAG = "VolumeAutomaticEffect";
    private final long duration;
    private final long endOffset;
    private final long startOffset;

    @NotNull
    private final VolumeRange volumeRange;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator CREATOR = new Creator();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qcircle/weishi/module/publisher/data/VolumeAutomaticEffect$Companion;", "", "()V", "TAG", "", "from", "Lcom/tencent/qcircle/weishi/module/publisher/data/VolumeAutomaticEffect;", "it", "Lcom/tencent/autotemplate/model/TAVVolumeAutomaticEffect;", "genEndOutVolumeAutomaticEffect", "duration", "", "genStartInVolumeAutomaticEffect", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final VolumeAutomaticEffect from(@NotNull TAVVolumeAutomaticEffect it) {
            Intrinsics.checkParameterIsNotNull(it, "it");
            return new VolumeAutomaticEffect(it.getStartOffset(), it.getEndOffset(), it.getDuration(), new VolumeRange(it.getStartVolume(), it.getEndVolume()));
        }

        @NotNull
        public final VolumeAutomaticEffect genEndOutVolumeAutomaticEffect(long duration) {
            return new VolumeAutomaticEffect(-1L, 0L, duration, new VolumeRange(1.0f, 0.0f));
        }

        @NotNull
        public final VolumeAutomaticEffect genStartInVolumeAutomaticEffect(long duration) {
            return new VolumeAutomaticEffect(0L, -1L, duration, new VolumeRange(0.0f, 1.0f));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel in5) {
            Intrinsics.checkParameterIsNotNull(in5, "in");
            return new VolumeAutomaticEffect(in5.readLong(), in5.readLong(), in5.readLong(), (VolumeRange) VolumeRange.CREATOR.createFromParcel(in5));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i3) {
            return new VolumeAutomaticEffect[i3];
        }
    }

    public VolumeAutomaticEffect(long j3, long j16, long j17, @NotNull VolumeRange volumeRange) {
        Intrinsics.checkParameterIsNotNull(volumeRange, "volumeRange");
        this.startOffset = j3;
        this.endOffset = j16;
        this.duration = j17;
        this.volumeRange = volumeRange;
    }

    public static /* synthetic */ VolumeAutomaticEffect copy$default(VolumeAutomaticEffect volumeAutomaticEffect, long j3, long j16, long j17, VolumeRange volumeRange, int i3, Object obj) {
        long j18;
        long j19;
        long j26;
        VolumeRange volumeRange2;
        if ((i3 & 1) != 0) {
            j18 = volumeAutomaticEffect.startOffset;
        } else {
            j18 = j3;
        }
        if ((i3 & 2) != 0) {
            j19 = volumeAutomaticEffect.endOffset;
        } else {
            j19 = j16;
        }
        if ((i3 & 4) != 0) {
            j26 = volumeAutomaticEffect.duration;
        } else {
            j26 = j17;
        }
        if ((i3 & 8) != 0) {
            volumeRange2 = volumeAutomaticEffect.volumeRange;
        } else {
            volumeRange2 = volumeRange;
        }
        return volumeAutomaticEffect.copy(j18, j19, j26, volumeRange2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getStartOffset() {
        return this.startOffset;
    }

    /* renamed from: component2, reason: from getter */
    public final long getEndOffset() {
        return this.endOffset;
    }

    /* renamed from: component3, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final VolumeRange getVolumeRange() {
        return this.volumeRange;
    }

    @Nullable
    public final TAVAudioConfiguration.VolumeEdge convertToAudioVolumeEdge(long allDuration) {
        long j3 = this.duration;
        long j16 = this.startOffset;
        if (j16 <= -1 || this.endOffset != -1) {
            if (j16 == -1 && this.endOffset > -1) {
                j16 = allDuration - j3;
            } else {
                if (j16 > -1) {
                    long j17 = this.endOffset;
                    if (j17 > -1) {
                        j3 = (allDuration - j16) - j17;
                    }
                }
                Logger.e(TAG, "effect's startOffset and endOffset is wrong.");
                return null;
            }
        }
        if (j3 <= 0) {
            return null;
        }
        return new TAVAudioConfiguration.VolumeEdge(new CMTimeRange(CMTime.fromMs(j16), CMTime.fromMs(j3)), this.volumeRange.getStart(), this.volumeRange.getEnd());
    }

    @NotNull
    public final VolumeAutomaticEffect copy(long startOffset, long endOffset, long duration, @NotNull VolumeRange volumeRange) {
        Intrinsics.checkParameterIsNotNull(volumeRange, "volumeRange");
        return new VolumeAutomaticEffect(startOffset, endOffset, duration, volumeRange);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof VolumeAutomaticEffect) {
                VolumeAutomaticEffect volumeAutomaticEffect = (VolumeAutomaticEffect) other;
                if (this.startOffset != volumeAutomaticEffect.startOffset || this.endOffset != volumeAutomaticEffect.endOffset || this.duration != volumeAutomaticEffect.duration || !Intrinsics.areEqual(this.volumeRange, volumeAutomaticEffect.volumeRange)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getEndOffset() {
        return this.endOffset;
    }

    public final long getStartOffset() {
        return this.startOffset;
    }

    @NotNull
    public final VolumeRange getVolumeRange() {
        return this.volumeRange;
    }

    public int hashCode() {
        int i3;
        long j3 = this.startOffset;
        long j16 = this.endOffset;
        int i16 = ((((int) (j3 ^ (j3 >>> 32))) * 31) + ((int) (j16 ^ (j16 >>> 32)))) * 31;
        long j17 = this.duration;
        int i17 = (i16 + ((int) ((j17 >>> 32) ^ j17))) * 31;
        VolumeRange volumeRange = this.volumeRange;
        if (volumeRange != null) {
            i3 = volumeRange.hashCode();
        } else {
            i3 = 0;
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "VolumeAutomaticEffect(startOffset=" + this.startOffset + ", endOffset=" + this.endOffset + ", duration=" + this.duration + ", volumeRange=" + this.volumeRange + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeLong(this.startOffset);
        parcel.writeLong(this.endOffset);
        parcel.writeLong(this.duration);
        this.volumeRange.writeToParcel(parcel, 0);
    }
}

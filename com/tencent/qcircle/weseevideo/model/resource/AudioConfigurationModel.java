package com.tencent.qcircle.weseevideo.model.resource;

import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/resource/AudioConfigurationModel;", "Ljava/io/Serializable;", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "", "startVolumeEdgeModel", "Lcom/tencent/qcircle/weseevideo/model/resource/VolumeEdgeModel;", "endVolumeEdgeModel", "(FLcom/tencent/qcircle/weseevideo/model/resource/VolumeEdgeModel;Lcom/tencent/qcircle/weseevideo/model/resource/VolumeEdgeModel;)V", "getEndVolumeEdgeModel", "()Lcom/tencent/qcircle/weseevideo/model/resource/VolumeEdgeModel;", "getStartVolumeEdgeModel", "getVolume", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* data */ class AudioConfigurationModel implements Serializable {

    @Nullable
    private final VolumeEdgeModel endVolumeEdgeModel;

    @Nullable
    private final VolumeEdgeModel startVolumeEdgeModel;
    private final float volume;

    public AudioConfigurationModel() {
        this(0.0f, null, null, 7, null);
    }

    public static /* synthetic */ AudioConfigurationModel copy$default(AudioConfigurationModel audioConfigurationModel, float f16, VolumeEdgeModel volumeEdgeModel, VolumeEdgeModel volumeEdgeModel2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = audioConfigurationModel.volume;
        }
        if ((i3 & 2) != 0) {
            volumeEdgeModel = audioConfigurationModel.startVolumeEdgeModel;
        }
        if ((i3 & 4) != 0) {
            volumeEdgeModel2 = audioConfigurationModel.endVolumeEdgeModel;
        }
        return audioConfigurationModel.copy(f16, volumeEdgeModel, volumeEdgeModel2);
    }

    /* renamed from: component1, reason: from getter */
    public final float getVolume() {
        return this.volume;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final VolumeEdgeModel getStartVolumeEdgeModel() {
        return this.startVolumeEdgeModel;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final VolumeEdgeModel getEndVolumeEdgeModel() {
        return this.endVolumeEdgeModel;
    }

    @NotNull
    public final AudioConfigurationModel copy(float volume, @Nullable VolumeEdgeModel startVolumeEdgeModel, @Nullable VolumeEdgeModel endVolumeEdgeModel) {
        return new AudioConfigurationModel(volume, startVolumeEdgeModel, endVolumeEdgeModel);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof AudioConfigurationModel) {
                AudioConfigurationModel audioConfigurationModel = (AudioConfigurationModel) other;
                if (Float.compare(this.volume, audioConfigurationModel.volume) != 0 || !Intrinsics.areEqual(this.startVolumeEdgeModel, audioConfigurationModel.startVolumeEdgeModel) || !Intrinsics.areEqual(this.endVolumeEdgeModel, audioConfigurationModel.endVolumeEdgeModel)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final VolumeEdgeModel getEndVolumeEdgeModel() {
        return this.endVolumeEdgeModel;
    }

    @Nullable
    public final VolumeEdgeModel getStartVolumeEdgeModel() {
        return this.startVolumeEdgeModel;
    }

    public final float getVolume() {
        return this.volume;
    }

    public int hashCode() {
        int i3;
        int floatToIntBits = Float.floatToIntBits(this.volume) * 31;
        VolumeEdgeModel volumeEdgeModel = this.startVolumeEdgeModel;
        int i16 = 0;
        if (volumeEdgeModel != null) {
            i3 = volumeEdgeModel.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = (floatToIntBits + i3) * 31;
        VolumeEdgeModel volumeEdgeModel2 = this.endVolumeEdgeModel;
        if (volumeEdgeModel2 != null) {
            i16 = volumeEdgeModel2.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "AudioConfigurationModel(volume=" + this.volume + ", startVolumeEdgeModel=" + this.startVolumeEdgeModel + ", endVolumeEdgeModel=" + this.endVolumeEdgeModel + ")";
    }

    public AudioConfigurationModel(float f16, @Nullable VolumeEdgeModel volumeEdgeModel, @Nullable VolumeEdgeModel volumeEdgeModel2) {
        this.volume = f16;
        this.startVolumeEdgeModel = volumeEdgeModel;
        this.endVolumeEdgeModel = volumeEdgeModel2;
    }

    public /* synthetic */ AudioConfigurationModel(float f16, VolumeEdgeModel volumeEdgeModel, VolumeEdgeModel volumeEdgeModel2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? null : volumeEdgeModel, (i3 & 4) != 0 ? null : volumeEdgeModel2);
    }
}

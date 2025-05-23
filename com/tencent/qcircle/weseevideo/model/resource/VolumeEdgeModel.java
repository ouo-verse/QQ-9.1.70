package com.tencent.qcircle.weseevideo.model.resource;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/resource/VolumeEdgeModel;", "Ljava/io/Serializable;", "timeStart", "", "timeDuration", "startVolume", "", "endVolume", "(JJFF)V", "getEndVolume", "()F", "getStartVolume", "getTimeDuration", "()J", "getTimeStart", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class VolumeEdgeModel implements Serializable {
    private final float endVolume;
    private final float startVolume;
    private final long timeDuration;
    private final long timeStart;

    public VolumeEdgeModel() {
        this(0L, 0L, 0.0f, 0.0f, 15, null);
    }

    public final float getEndVolume() {
        return this.endVolume;
    }

    public final float getStartVolume() {
        return this.startVolume;
    }

    public final long getTimeDuration() {
        return this.timeDuration;
    }

    public final long getTimeStart() {
        return this.timeStart;
    }

    public VolumeEdgeModel(long j3, long j16, float f16, float f17) {
        this.timeStart = j3;
        this.timeDuration = j16;
        this.startVolume = f16;
        this.endVolume = f17;
    }

    public /* synthetic */ VolumeEdgeModel(long j3, long j16, float f16, float f17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) == 0 ? j16 : 0L, (i3 & 4) != 0 ? 0.0f : f16, (i3 & 8) != 0 ? 0.0f : f17);
    }
}

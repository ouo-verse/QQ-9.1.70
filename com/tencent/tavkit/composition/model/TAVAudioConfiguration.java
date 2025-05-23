package com.tencent.tavkit.composition.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import com.tencent.tavkit.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVAudioConfiguration {
    private VolumeEdge endVolumeEdge;
    private final List<TAVAudioProcessorNode> nodes;
    private VolumeEdge startVolumeEdge;
    private float volume;
    private List<VolumeEdge> volumeEdges;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class VolumeEdge {
        private float endVolume;
        private float startVolume;
        private CMTimeRange timeRange;

        public VolumeEdge() {
        }

        public CMTime getDuration() {
            CMTimeRange cMTimeRange = this.timeRange;
            if (cMTimeRange != null) {
                return cMTimeRange.getDuration();
            }
            return CMTime.CMTimeZero;
        }

        public float getEndVolume() {
            return this.endVolume;
        }

        public float getStartVolume() {
            return this.startVolume;
        }

        public CMTimeRange getTimeRange() {
            return this.timeRange;
        }

        public float getVolume(CMTime cMTime) {
            long timeUs = cMTime.getTimeUs();
            float f16 = this.startVolume;
            return f16 + ((this.endVolume - f16) * ((((float) timeUs) * 1.0f) / ((float) getDuration().getTimeUs())));
        }

        public void setDuration(@NonNull CMTime cMTime) {
            this.timeRange = new CMTimeRange(CMTime.CMTimeZero, cMTime);
        }

        public void setEndVolume(float f16) {
            this.endVolume = f16;
        }

        public void setStartVolume(float f16) {
            this.startVolume = f16;
        }

        public void setTimeRange(CMTimeRange cMTimeRange) {
            this.timeRange = cMTimeRange;
        }

        public VolumeEdge(@NonNull CMTime cMTime, float f16, float f17) {
            this.timeRange = new CMTimeRange(CMTime.CMTimeZero, cMTime);
            this.startVolume = f16;
            this.endVolume = f17;
        }

        public VolumeEdge(CMTimeRange cMTimeRange, float f16, float f17) {
            this.timeRange = cMTimeRange;
            this.startVolume = f16;
            this.endVolume = f17;
        }
    }

    public TAVAudioConfiguration() {
        this(1.0f);
    }

    private Float getEdgesVolume(@NonNull CMTime cMTime) {
        List<VolumeEdge> list = this.volumeEdges;
        if (list != null && !list.isEmpty()) {
            return Utils.getEdgesVolume(cMTime, this.volumeEdges, this.volume);
        }
        return null;
    }

    private Float getStartEndVolume(@NonNull CMTime cMTime) {
        if (Utils.containsTime(cMTime, this.startVolumeEdge)) {
            return Float.valueOf(Utils.getEdgeVolumeByTime(cMTime, this.startVolumeEdge, this.volume));
        }
        if (Utils.containsTime(cMTime, this.endVolumeEdge)) {
            return Float.valueOf(Utils.getEdgeVolumeByTime(cMTime, this.endVolumeEdge, this.volume));
        }
        return null;
    }

    public void addAudioProcessorNode(@NonNull TAVAudioProcessorNode tAVAudioProcessorNode) {
        this.nodes.add(tAVAudioProcessorNode);
    }

    public void addVolumeEdge(VolumeEdge volumeEdge) {
        if (volumeEdge == null) {
            return;
        }
        if (this.volumeEdges == null) {
            this.volumeEdges = new ArrayList();
        }
        this.volumeEdges.add(0, volumeEdge);
    }

    public VolumeEdge getEndVolumeEdge() {
        return this.endVolumeEdge;
    }

    public List<TAVAudioProcessorNode> getNodes() {
        return this.nodes;
    }

    public VolumeEdge getStartVolumeEdge() {
        return this.startVolumeEdge;
    }

    public float getVolume(@NonNull CMTime cMTime) {
        Float startEndVolume = getStartEndVolume(cMTime);
        if (startEndVolume != null) {
            return startEndVolume.floatValue();
        }
        Float edgesVolume = getEdgesVolume(cMTime);
        if (edgesVolume != null) {
            return edgesVolume.floatValue();
        }
        return this.volume;
    }

    public void setAudioProcessorNodes(@Nullable List<TAVAudioProcessorNode> list) {
        this.nodes.clear();
        if (list != null) {
            this.nodes.addAll(list);
        }
    }

    public void setEndVolumeEdge(VolumeEdge volumeEdge) {
        this.endVolumeEdge = volumeEdge;
    }

    public void setStartVolumeEdge(VolumeEdge volumeEdge) {
        this.startVolumeEdge = volumeEdge;
    }

    public void setVolume(float f16) {
        this.volume = f16;
    }

    public String toString() {
        return "TAVAudioConfiguration{volume=" + this.volume + ", startVolumeEdge=" + this.startVolumeEdge + ", endVolumeEdge=" + this.endVolumeEdge + ", nodes=" + this.nodes + '}';
    }

    public TAVAudioConfiguration(float f16) {
        this(f16, null, null);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TAVAudioConfiguration m270clone() {
        return new TAVAudioConfiguration(this.volume, this.nodes);
    }

    public TAVAudioConfiguration(List<VolumeEdge> list) {
        this(1.0f, null, list);
    }

    public TAVAudioConfiguration(float f16, List<TAVAudioProcessorNode> list) {
        this(f16, list, null);
    }

    public TAVAudioConfiguration(float f16, List<TAVAudioProcessorNode> list, List<VolumeEdge> list2) {
        this.volume = f16;
        ArrayList arrayList = new ArrayList();
        this.nodes = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
        ArrayList arrayList2 = new ArrayList();
        this.volumeEdges = arrayList2;
        if (list2 != null) {
            arrayList2.addAll(list2);
        }
    }

    public float getVolume() {
        return this.volume;
    }
}

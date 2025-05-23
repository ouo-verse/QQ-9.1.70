package com.tencent.tavkit.composition.audio;

import androidx.annotation.NonNull;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.MutableAudioMixInputParameters;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes26.dex */
public class TAVAudioMixInputParameters extends MutableAudioMixInputParameters {

    @NonNull
    private final List<TAVAudioConfigurationSegment> audioConfigurationSegmentList;
    private final String mTAG;
    private int reportCount;

    public TAVAudioMixInputParameters(AssetTrack assetTrack) {
        super(assetTrack);
        this.mTAG = "TAVAudioMixInputParamet@" + Integer.toHexString(hashCode());
        this.audioConfigurationSegmentList = new ArrayList();
        this.reportCount = 0;
    }

    private void errorReport(String str, String str2, Throwable th5) {
        if (this.reportCount < 1) {
            Logger.e(str, str2, th5);
            this.reportCount++;
        }
    }

    private Float getVolume(@NonNull CMTime cMTime, TAVAudioConfigurationSegment tAVAudioConfigurationSegment) {
        if (tAVAudioConfigurationSegment != null && tAVAudioConfigurationSegment.compositionTimeRange.containsTime(cMTime)) {
            TAVAudioConfiguration.VolumeEdge startVolumeEdge = tAVAudioConfigurationSegment.audioConfiguration.getStartVolumeEdge();
            CMTime start = tAVAudioConfigurationSegment.compositionTimeRange.getStart();
            if (startVolumeEdge != null && start.add(startVolumeEdge.getDuration()).bigThan(cMTime)) {
                return Float.valueOf(startVolumeEdge.getVolume(cMTime.sub(start)));
            }
            TAVAudioConfiguration.VolumeEdge endVolumeEdge = tAVAudioConfigurationSegment.audioConfiguration.getEndVolumeEdge();
            CMTime end = tAVAudioConfigurationSegment.compositionTimeRange.getEnd();
            if (endVolumeEdge != null && end.sub(endVolumeEdge.getDuration()).smallThan(cMTime)) {
                return Float.valueOf(endVolumeEdge.getVolume(cMTime.sub(end.sub(endVolumeEdge.getDuration()))));
            }
            return Float.valueOf(tAVAudioConfigurationSegment.audioConfiguration.getVolume(cMTime));
        }
        return null;
    }

    public void addAudioConfiguration(@NonNull CMTimeRange cMTimeRange, @NonNull TAVAudioConfiguration tAVAudioConfiguration) {
        this.audioConfigurationSegmentList.add(new TAVAudioConfigurationSegment(cMTimeRange, tAVAudioConfiguration));
    }

    public List<TAVAudioConfigurationSegment> getAudioConfigurationSegmentList() {
        return this.audioConfigurationSegmentList;
    }

    @Override // com.tencent.tav.core.AudioMixInputParameters
    public float getVolumeAtTime(@NonNull CMTime cMTime) {
        Iterator<TAVAudioConfigurationSegment> it = this.audioConfigurationSegmentList.iterator();
        while (it.hasNext()) {
            Float volume = getVolume(cMTime, it.next());
            if (volume != null) {
                return volume.floatValue();
            }
        }
        errorReport(this.mTAG, "\u6ca1\u6709\u8bbe\u7f6e\u6b63\u786eaudioConfiguration\uff0c\u8d70\u5230\u4e86\u975e\u9884\u60f3\u7684\u5206\u652f", null);
        return super.getVolumeAtTime(cMTime);
    }

    public void setAudioConfigurationSegments(@NonNull List<TAVAudioConfigurationSegment> list) {
        this.audioConfigurationSegmentList.clear();
        this.audioConfigurationSegmentList.addAll(list);
    }
}

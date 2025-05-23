package com.tencent.tavkit.composition.builder;

import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.audio.TAVAudioMixInputParameters;
import com.tencent.tavkit.composition.audio.TAVAudioTapProcessor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class AudioParamsBuilder {
    private HashMap<Integer, TAVAudioMixInputParameters> audioMixInputParametersHashMap = new HashMap<>();
    private final BuilderModel builderModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioParamsBuilder(BuilderModel builderModel) {
        this.builderModel = builderModel;
    }

    private void buildAudioParametersByTrackInfo(AudioParamsInfo audioParamsInfo) {
        for (AudioInfo audioInfo : audioParamsInfo.audioInfos) {
            int trackID = audioInfo.compositionTrack.getTrackID();
            TAVAudioMixInputParameters tAVAudioMixInputParameters = this.audioMixInputParametersHashMap.get(Integer.valueOf(trackID));
            if (tAVAudioMixInputParameters == null) {
                tAVAudioMixInputParameters = new TAVAudioMixInputParameters(audioInfo.compositionTrack);
                this.audioMixInputParametersHashMap.put(Integer.valueOf(trackID), tAVAudioMixInputParameters);
            }
            tAVAudioMixInputParameters.addAudioConfiguration(new CMTimeRange(audioInfo.audio.getStartTime(), audioInfo.audio.getDuration()), audioInfo.audio.getAudioConfiguration());
            tAVAudioMixInputParameters.setAudioTapProcessor(new TAVAudioTapProcessor(tAVAudioMixInputParameters.getAudioConfigurationSegmentList()));
        }
    }

    private void buildBgAudioInputParameters() {
        for (AudioMixInfo audioMixInfo : this.builderModel.getAudioTrackInfo()) {
            int trackID = audioMixInfo.track.getTrackID();
            TAVAudioMixInputParameters tAVAudioMixInputParameters = this.audioMixInputParametersHashMap.get(Integer.valueOf(trackID));
            if (tAVAudioMixInputParameters == null) {
                tAVAudioMixInputParameters = new TAVAudioMixInputParameters(audioMixInfo.track);
                this.audioMixInputParametersHashMap.put(Integer.valueOf(trackID), tAVAudioMixInputParameters);
            }
            tAVAudioMixInputParameters.addAudioConfiguration(new CMTimeRange(audioMixInfo.audio.getStartTime(), audioMixInfo.audio.getDuration()), audioMixInfo.audio.getAudioConfiguration());
            tAVAudioMixInputParameters.setAudioTapProcessor(new TAVAudioTapProcessor(tAVAudioMixInputParameters.getAudioConfigurationSegmentList()));
        }
    }

    private void buildMainAudioInputParameters() {
        List<AudioParamsInfo> mainAudioTrackInfo = this.builderModel.getMainAudioTrackInfo();
        for (int i3 = 0; i3 < mainAudioTrackInfo.size(); i3++) {
            buildAudioParametersByTrackInfo(mainAudioTrackInfo.get(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<TAVAudioMixInputParameters> build() {
        buildMainAudioInputParameters();
        buildBgAudioInputParameters();
        return new ArrayList(this.audioMixInputParametersHashMap.values());
    }
}

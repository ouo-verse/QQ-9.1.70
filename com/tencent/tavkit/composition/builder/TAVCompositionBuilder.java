package com.tencent.tavkit.composition.builder;

import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AudioMix;
import com.tencent.tav.core.AudioMixInputParameters;
import com.tencent.tav.core.MutableAudioMix;
import com.tencent.tav.core.composition.MutableVideoComposition;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.audio.TAVAudioMixInputParameters;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.video.TAVVideoCompositing;
import com.tencent.tavkit.utils.CompositionUtils;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVCompositionBuilder {
    private static final String TAG = "TAVCompositionBuilder";
    private final BuilderModel builderModel;
    private boolean isVideoTracksMerge = true;
    private boolean isAudioTracksMerge = true;
    private boolean isReloadChannels = true;

    public TAVCompositionBuilder(TAVComposition tAVComposition) {
        this.builderModel = new BuilderModel(tAVComposition);
    }

    private AudioMix<? extends AudioMixInputParameters> buildAudioMix() {
        List<TAVAudioMixInputParameters> build = new AudioParamsBuilder(this.builderModel).build();
        if (build.size() == 0) {
            return null;
        }
        return new MutableAudioMix(build);
    }

    private Asset buildComposition() {
        if (this.isReloadChannels) {
            reloadChannels();
        }
        return new CompositionBuilder(this.builderModel, this.isVideoTracksMerge, this.isAudioTracksMerge).build();
    }

    private VideoComposition buildVideoComposition() {
        MutableVideoComposition mutableVideoComposition = new MutableVideoComposition();
        mutableVideoComposition.setFrameDuration(this.builderModel.getFrameDuration());
        mutableVideoComposition.setRenderSize(this.builderModel.getRenderSize());
        mutableVideoComposition.setRenderLayoutMode(this.builderModel.getRenderLayoutMode());
        mutableVideoComposition.setCustomVideoCompositorClass(TAVVideoCompositing.class);
        mutableVideoComposition.setInstructions(new VideoInstructionsBuilder(this.builderModel).build());
        return mutableVideoComposition;
    }

    private void reloadChannels() {
        Iterator<List<? extends TAVTransitionableVideo>> it = this.builderModel.getVideoChannels().iterator();
        while (it.hasNext()) {
            CompositionUtils.reloadVideoStartTimeWithTransitionableVideo(it.next());
        }
        Logger.d(TAG, "buildComposition: reloadVideoChannels = " + this.builderModel.getVideoChannels());
        Iterator<List<? extends TAVTransitionableAudio>> it5 = this.builderModel.getAudioChannels().iterator();
        while (it5.hasNext()) {
            CompositionUtils.reloadAudioStartTimeWithTransitionableAudio(it5.next());
        }
        Logger.d(TAG, "buildComposition: reloadAudioChannels = " + this.builderModel.getAudioChannels());
    }

    public TAVSource buildSource() {
        Logger.i(TAG, "buildSource: begin, tavComposition = " + this.builderModel.getTavComposition());
        TAVSource tAVSource = new TAVSource();
        tAVSource.setAsset(buildComposition());
        tAVSource.setVideoComposition(buildVideoComposition());
        tAVSource.setAudioMix(buildAudioMix());
        Logger.i(TAG, "buildSource: end, return source = " + tAVSource);
        return tAVSource;
    }

    public void setAudioTracksMerge(boolean z16) {
        this.isAudioTracksMerge = z16;
    }

    public void setReloadChannels(boolean z16) {
        this.isReloadChannels = z16;
    }

    public void setVideoTracksMerge(boolean z16) {
        this.isVideoTracksMerge = z16;
    }
}

package com.tencent.tavkit.composition.builder;

import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.model.TAVVideo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public class BuilderModel {
    private final TAVComposition tavComposition;
    private final List<List<VideoInfo>> mainVideoTrackInfo = new ArrayList();
    private final List<AudioParamsInfo> mainAudioTrackInfo = new ArrayList();
    private final List<VideoOverlayInfo> overlayTrackInfo = new ArrayList();
    private final List<AudioMixInfo> audioTrackInfo = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public BuilderModel(TAVComposition tAVComposition) {
        this.tavComposition = tAVComposition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addAudioTrackInfo(AudioMixInfo audioMixInfo) {
        this.audioTrackInfo.add(audioMixInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addMainAudioTrackInfo(AudioParamsInfo audioParamsInfo) {
        this.mainAudioTrackInfo.add(audioParamsInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addMainVideoTrackInfo(List<VideoInfo> list) {
        this.mainVideoTrackInfo.add(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addOverlayTrackInfo(VideoOverlayInfo videoOverlayInfo) {
        this.overlayTrackInfo.add(videoOverlayInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<List<? extends TAVTransitionableAudio>> getAudioChannels() {
        return this.tavComposition.getAudioChannels();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<AudioMixInfo> getAudioTrackInfo() {
        return this.audioTrackInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBackgroundColor() {
        return this.tavComposition.getBackgroundColor();
    }

    public CMTime getFrameDuration() {
        return this.tavComposition.getFrameDuration();
    }

    TAVVideoEffect getGlobalVideoEffect() {
        return this.tavComposition.getGlobalVideoEffect();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<AudioParamsInfo> getMainAudioTrackInfo() {
        return this.mainAudioTrackInfo;
    }

    public List<List<VideoInfo>> getMainVideoTrackInfo() {
        return this.mainVideoTrackInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<? extends TAVAudio> getMixAudios() {
        return this.tavComposition.getAudios();
    }

    public List<VideoOverlayInfo> getOverlayTrackInfo() {
        return this.overlayTrackInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<? extends TAVVideo> getOverlays() {
        return this.tavComposition.getOverlays();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoComposition.RenderLayoutMode getRenderLayoutMode() {
        return this.tavComposition.getRenderLayoutMode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CGSize getRenderSize() {
        return this.tavComposition.getRenderSize();
    }

    public TAVComposition getTavComposition() {
        return this.tavComposition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<List<? extends TAVTransitionableVideo>> getVideoChannels() {
        return this.tavComposition.getVideoChannels();
    }

    public TAVVideoMixEffect getVideoMixEffect() {
        return this.tavComposition.getVideoMixEffect();
    }
}

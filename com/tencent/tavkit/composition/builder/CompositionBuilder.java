package com.tencent.tavkit.composition.builder;

import androidx.annotation.NonNull;
import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tav.asset.MutableComposition;
import com.tencent.tavkit.composition.audio.TAVAudioTransition;
import com.tencent.tavkit.composition.model.TAVAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.model.TAVVideo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public class CompositionBuilder {
    private BuilderModel builderModel;
    private MutableComposition composition = new MutableComposition();
    private boolean isAudioTracksMerge;
    private boolean isVideoTracksMerge;

    public CompositionBuilder(BuilderModel builderModel, boolean z16, boolean z17) {
        this.builderModel = builderModel;
        this.isVideoTracksMerge = z16;
        this.isAudioTracksMerge = z17;
    }

    @NonNull
    private AudioTransitionInfo getAudioTransitionInfo(List<? extends TAVTransitionableAudio> list, TAVAudioTransition tAVAudioTransition, TAVTransitionableAudio tAVTransitionableAudio, int i3) {
        if (i3 == 0 && list.size() > 1) {
            return new AudioTransitionInfo(null, tAVTransitionableAudio.getAudioTransition());
        }
        if (i3 == list.size() - 1) {
            return new AudioTransitionInfo(tAVAudioTransition, null);
        }
        return new AudioTransitionInfo(tAVAudioTransition, tAVTransitionableAudio.getAudioTransition());
    }

    private void initCompositionWithAudioChannels() {
        for (List<? extends TAVTransitionableAudio> list : this.builderModel.getAudioChannels()) {
            ArrayList arrayList = new ArrayList();
            HashMap<String, AudioTransitionInfo> hashMap = new HashMap<>();
            traverseAudioChannel(list, null, arrayList, hashMap);
            this.builderModel.addMainAudioTrackInfo(new AudioParamsInfo(arrayList, hashMap));
        }
    }

    private void initCompositionWithMixAudios(List<? extends TAVAudio> list) {
        if (list == null) {
            return;
        }
        for (TAVAudio tAVAudio : list) {
            for (int i3 = 0; i3 < tAVAudio.numberOfAudioTracks(); i3++) {
                CompositionTrack audioCompositionTrackForComposition = tAVAudio.audioCompositionTrackForComposition(this.composition, i3, this.isAudioTracksMerge);
                if (audioCompositionTrackForComposition != null) {
                    this.builderModel.addAudioTrackInfo(new AudioMixInfo(audioCompositionTrackForComposition, tAVAudio));
                }
            }
        }
    }

    private void initCompositionWithOverlays(List<? extends TAVVideo> list) {
        if (list == null) {
            return;
        }
        for (TAVVideo tAVVideo : list) {
            for (int i3 = 0; i3 < tAVVideo.numberOfVideoTracks(); i3++) {
                CompositionTrack videoCompositionTrackForComposition = tAVVideo.videoCompositionTrackForComposition(this.composition, i3, this.isVideoTracksMerge);
                if (videoCompositionTrackForComposition != null) {
                    this.builderModel.addOverlayTrackInfo(new VideoOverlayInfo(videoCompositionTrackForComposition, tAVVideo));
                }
            }
        }
    }

    private void initCompositionWithVideoChannels() {
        for (List<? extends TAVTransitionableVideo> list : this.builderModel.getVideoChannels()) {
            ArrayList arrayList = new ArrayList();
            traverseVideoChannel(list, arrayList);
            this.builderModel.addMainVideoTrackInfo(arrayList);
        }
    }

    private void traverseAudioChannel(List<? extends TAVTransitionableAudio> list, TAVAudioTransition tAVAudioTransition, List<AudioInfo> list2, HashMap<String, AudioTransitionInfo> hashMap) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            TAVTransitionableAudio tAVTransitionableAudio = list.get(i3);
            traverseAudioClip(list2, tAVTransitionableAudio);
            hashMap.put(String.valueOf(i3), getAudioTransitionInfo(list, tAVAudioTransition, tAVTransitionableAudio, i3));
            tAVAudioTransition = tAVTransitionableAudio.getAudioTransition();
        }
    }

    private void traverseAudioClip(List<AudioInfo> list, TAVTransitionableAudio tAVTransitionableAudio) {
        for (int i3 = 0; i3 < tAVTransitionableAudio.numberOfAudioTracks(); i3++) {
            CompositionTrack audioCompositionTrackForComposition = tAVTransitionableAudio.audioCompositionTrackForComposition(this.composition, i3, this.isAudioTracksMerge);
            if (audioCompositionTrackForComposition != null) {
                list.add(new AudioInfo(audioCompositionTrackForComposition, tAVTransitionableAudio));
            }
        }
    }

    private void traverseVideoChannel(List<? extends TAVTransitionableVideo> list, List<VideoInfo> list2) {
        Iterator<? extends TAVTransitionableVideo> it = list.iterator();
        while (it.hasNext()) {
            traverseVideoClip(list2, it.next());
        }
    }

    private void traverseVideoClip(List<VideoInfo> list, TAVTransitionableVideo tAVTransitionableVideo) {
        for (int i3 = 0; i3 < tAVTransitionableVideo.numberOfVideoTracks(); i3++) {
            CompositionTrack videoCompositionTrackForComposition = tAVTransitionableVideo.videoCompositionTrackForComposition(this.composition, i3, this.isVideoTracksMerge);
            if (videoCompositionTrackForComposition != null) {
                list.add(new VideoInfo(videoCompositionTrackForComposition, tAVTransitionableVideo));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public MutableComposition build() {
        initCompositionWithVideoChannels();
        initCompositionWithAudioChannels();
        initCompositionWithOverlays(this.builderModel.getOverlays());
        initCompositionWithMixAudios(this.builderModel.getMixAudios());
        return this.composition;
    }
}

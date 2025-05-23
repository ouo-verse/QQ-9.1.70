package com.tencent.tavkit.composition;

import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tavkit.component.effectchain.IVideoEffectContext;
import com.tencent.tavkit.composition.model.TAVAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.model.TAVVideo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.utils.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVComposition implements Cloneable {
    private List<List<? extends TAVTransitionableAudio>> audioChannels;
    private AudioInfo audioInfo;
    private List<? extends TAVAudio> audios;
    private int backgroundColor;
    private CMTime frameDuration;
    private TAVVideoEffect globalVideoEffect;
    private List<? extends TAVVideo> overlays;
    private VideoComposition.RenderLayoutMode renderLayoutMode;
    private CGSize renderSize;
    private TAVVideoEffect sourceVideoEffect;
    private List<List<? extends TAVTransitionableVideo>> videoChannels;
    private TAVVideoMixEffect videoMixEffect;

    public TAVComposition(TAVClip... tAVClipArr) {
        this((List<TAVClip>) ListUtils.listWithObjects(tAVClipArr));
    }

    public void addAudioChannel(List<? extends TAVTransitionableAudio> list) {
        if (this.audioChannels == null) {
            this.audioChannels = new ArrayList();
        }
        this.audioChannels.add(new ArrayList(list));
    }

    public void addVideoChannel(List<? extends TAVTransitionableVideo> list) {
        if (this.videoChannels == null) {
            this.videoChannels = new ArrayList();
        }
        this.videoChannels.add(new ArrayList(list));
    }

    public void attachVideoEffectChain(IVideoEffectContext iVideoEffectContext) {
        this.sourceVideoEffect = iVideoEffectContext.getSourceVideoEffect();
        this.videoMixEffect = iVideoEffectContext.getVideoMixEffect();
        this.globalVideoEffect = iVideoEffectContext.getGlobalVideoEffect();
    }

    public List<List<? extends TAVTransitionableAudio>> getAudioChannels() {
        return this.audioChannels;
    }

    public AudioInfo getAudioInfo() {
        return this.audioInfo;
    }

    public List<? extends TAVAudio> getAudios() {
        return this.audios;
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public CMTime getDuration() {
        List<List<? extends TAVTransitionableVideo>> list = this.videoChannels;
        if (list == null) {
            return CMTime.CMTimeZero;
        }
        CMTime cMTime = CMTime.CMTimeZero;
        Iterator<List<? extends TAVTransitionableVideo>> it = list.iterator();
        while (it.hasNext()) {
            cMTime = getDuration(cMTime, it.next());
        }
        return cMTime;
    }

    public CMTime getFrameDuration() {
        return this.frameDuration;
    }

    public TAVVideoEffect getGlobalVideoEffect() {
        return this.globalVideoEffect;
    }

    public List<? extends TAVVideo> getOverlays() {
        return this.overlays;
    }

    public VideoComposition.RenderLayoutMode getRenderLayoutMode() {
        return this.renderLayoutMode;
    }

    public CGSize getRenderSize() {
        return this.renderSize;
    }

    public TAVVideoEffect getSourceVideoEffect() {
        return this.sourceVideoEffect;
    }

    public List<List<? extends TAVTransitionableVideo>> getVideoChannels() {
        return this.videoChannels;
    }

    public TAVVideoMixEffect getVideoMixEffect() {
        return this.videoMixEffect;
    }

    public void setAudioChannels(List<List<? extends TAVTransitionableAudio>> list) {
        this.audioChannels = list;
    }

    public void setAudioInfo(AudioInfo audioInfo) {
        this.audioInfo = audioInfo;
    }

    public void setAudios(List<? extends TAVAudio> list) {
        this.audios = list;
    }

    public void setBackgroundColor(int i3) {
        this.backgroundColor = i3;
    }

    public void setFrameDuration(CMTime cMTime) {
        this.frameDuration = cMTime;
    }

    public void setGlobalVideoEffect(TAVVideoEffect tAVVideoEffect) {
        this.globalVideoEffect = tAVVideoEffect;
    }

    public void setOverlays(List<? extends TAVVideo> list) {
        this.overlays = list;
    }

    public void setRenderLayoutMode(VideoComposition.RenderLayoutMode renderLayoutMode) {
        this.renderLayoutMode = renderLayoutMode;
    }

    public void setRenderSize(CGSize cGSize) {
        this.renderSize = cGSize;
    }

    public void setSourceVideoEffect(TAVVideoEffect tAVVideoEffect) {
        this.sourceVideoEffect = tAVVideoEffect;
    }

    public void setVideoChannels(List<List<? extends TAVTransitionableVideo>> list) {
        this.videoChannels = list;
    }

    public void setVideoMixEffect(TAVVideoMixEffect tAVVideoMixEffect) {
        this.videoMixEffect = tAVVideoMixEffect;
    }

    public String toString() {
        return "TAVComposition{\nrenderSize=" + this.renderSize + ", renderLayoutMode=" + this.renderLayoutMode + ", backgroundColor=" + this.backgroundColor + ", frameDuration=" + this.frameDuration + "\nvideoChannels=" + this.videoChannels + "\naudioChannels=" + this.audioChannels + "\noverlays=" + this.overlays + "\naudios=" + this.audios + '}';
    }

    public TAVComposition(List<TAVClip> list) {
        this(list, list);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TAVComposition m269clone() {
        TAVComposition tAVComposition = new TAVComposition();
        tAVComposition.renderSize = this.renderSize;
        tAVComposition.renderLayoutMode = this.renderLayoutMode;
        tAVComposition.backgroundColor = this.backgroundColor;
        tAVComposition.frameDuration = this.frameDuration;
        tAVComposition.videoChannels = new ArrayList(this.videoChannels);
        tAVComposition.audioChannels = new ArrayList(this.audioChannels);
        tAVComposition.overlays = new ArrayList(this.overlays);
        tAVComposition.audios = new ArrayList(this.audios);
        tAVComposition.sourceVideoEffect = this.sourceVideoEffect;
        tAVComposition.videoMixEffect = this.videoMixEffect;
        tAVComposition.globalVideoEffect = this.globalVideoEffect;
        return tAVComposition;
    }

    public TAVComposition(List<? extends TAVTransitionableVideo> list, List<? extends TAVTransitionableAudio> list2) {
        this();
        addVideoChannel(list);
        addAudioChannel(list2);
    }

    public TAVComposition() {
        this.frameDuration = new CMTime(1L, 30);
        this.videoChannels = new ArrayList();
        this.audioChannels = new ArrayList();
        this.backgroundColor = -16777216;
    }

    private CMTime getDuration(CMTime cMTime, List<? extends TAVTransitionableVideo> list) {
        if (list == null) {
            return cMTime;
        }
        CMTime duration = getDuration(list);
        return duration.bigThan(cMTime) ? duration : cMTime;
    }

    private CMTime getDuration(List<? extends TAVTransitionableVideo> list) {
        CMTime cMTime = CMTime.CMTimeZero;
        for (TAVTransitionableVideo tAVTransitionableVideo : list) {
            if (tAVTransitionableVideo != null) {
                cMTime = cMTime.add(tAVTransitionableVideo.getDuration());
            }
        }
        return cMTime;
    }
}

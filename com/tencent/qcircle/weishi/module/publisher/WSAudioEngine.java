package com.tencent.qcircle.weishi.module.publisher;

import com.tencent.qcircle.weseevideo.composition.effectnode.LightSdkAudioNode;
import com.tencent.qcircle.weseevideo.composition.effectnode.WSBGMEffectNode;
import com.tencent.qcircle.weseevideo.model.utils.AudioUtils;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import com.tencent.tavkit.utils.ListUtils;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.List;
import org.light.AudioOutput;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WSAudioEngine {
    public static final int SAMPLE_COUNT = 2048;
    private static final String TAG = "WSAudioEngine";
    private LightSdkAudioNode audioNode;
    private AudioOutput audioReader;
    private WSBGMEffectNode bgmNode = new WSBGMEffectNode();
    private TAVComposition composition;

    public WSAudioEngine(TAVComposition tAVComposition, AudioOutput audioOutput) {
        this.composition = tAVComposition;
        this.audioReader = audioOutput;
        this.audioNode = new LightSdkAudioNode(this.audioReader);
    }

    public void initBgm(List<? extends TAVClip> list, float f16) {
        if (CollectionUtil.isEmptyList(list)) {
            return;
        }
        this.bgmNode.updateBgmVolume(f16);
        for (TAVClip tAVClip : list) {
            TAVAudioConfiguration tAVAudioConfiguration = new TAVAudioConfiguration();
            tAVAudioConfiguration.setVolume(f16);
            tAVAudioConfiguration.setAudioProcessorNodes(ListUtils.listWithObjects(this.bgmNode));
            tAVClip.setAudioConfiguration(tAVAudioConfiguration);
        }
        AudioUtils.AudioSymbol audioSymbol = AudioUtils.AudioSymbol.BGM;
        AudioUtils.markAudioSymbol(audioSymbol, list);
        AudioUtils.updateCompositionAudiosBySymbol(this.composition, list, audioSymbol);
    }

    public void initEmptyClip(float f16) {
        this.audioNode.updateVideoVolume(f16);
        TAVClip tAVClip = new TAVClip(this.composition.getDuration(), true);
        TAVAudioConfiguration tAVAudioConfiguration = new TAVAudioConfiguration();
        tAVAudioConfiguration.setVolume(f16);
        tAVAudioConfiguration.setAudioProcessorNodes(ListUtils.listWithObjects(this.audioNode));
        tAVClip.setAudioConfiguration(tAVAudioConfiguration);
        ArrayList arrayList = new ArrayList();
        arrayList.add(tAVClip);
        this.composition.addAudioChannel(arrayList);
    }

    public void initTTS(List<? extends TAVClip> list) {
        if (CollectionUtil.isEmptyList(list)) {
            return;
        }
        AudioUtils.updateCompositionAudiosBySymbol(this.composition, list, AudioUtils.AudioSymbol.TTS);
    }

    public void updateBgm(List<? extends TAVClip> list) {
        if (CollectionUtil.isEmptyList(list)) {
            return;
        }
        this.composition.setAudios(null);
        for (TAVClip tAVClip : list) {
            TAVAudioConfiguration tAVAudioConfiguration = new TAVAudioConfiguration();
            tAVAudioConfiguration.setAudioProcessorNodes(ListUtils.listWithObjects(this.bgmNode));
            tAVClip.setAudioConfiguration(tAVAudioConfiguration);
        }
        this.composition.setAudios(list);
    }

    public void updateBgmVolume(float f16) {
        this.bgmNode.updateBgmVolume(f16);
    }

    public void updateVideoVolume(float f16) {
        this.audioNode.updateVideoVolume(f16);
    }
}

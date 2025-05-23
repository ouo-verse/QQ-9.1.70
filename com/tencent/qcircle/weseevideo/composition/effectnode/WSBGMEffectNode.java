package com.tencent.qcircle.weseevideo.composition.effectnode;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.AudioMixer;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WSBGMEffectNode implements TAVAudioProcessorNode {
    public static final String TAG = "WSBGMEffectNode";
    private float bgmVolume = 1.0f;

    @Override // com.tencent.tavkit.composition.audio.TAVAudioProcessorNode
    public TAVAudioProcessorNode.TAVAudioProcessorEffect createAudioProcessor() {
        return new TAVAudioProcessorNode.TAVAudioProcessorEffect() { // from class: com.tencent.qcircle.weseevideo.composition.effectnode.WSBGMEffectNode.1
            AudioMixer audioMixer = new AudioMixer();

            @Override // com.tencent.tav.core.AudioTapProcessor
            public ByteBuffer processAudioPCM(CMTime cMTime, ByteBuffer byteBuffer, AudioInfo audioInfo) {
                return this.audioMixer.processBytes(byteBuffer, 1.0f, WSBGMEffectNode.this.bgmVolume, 1.0f);
            }

            @Override // com.tencent.tav.core.AudioTapProcessor
            public void release() {
            }
        };
    }

    public float getBgmVolume() {
        return this.bgmVolume;
    }

    @Override // com.tencent.tavkit.composition.audio.TAVAudioProcessorNode
    public String getIdentifier() {
        return TAG;
    }

    public void updateBgmVolume(float f16) {
        this.bgmVolume = f16;
    }
}

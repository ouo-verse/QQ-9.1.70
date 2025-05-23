package com.tencent.qcircle.weseevideo.composition.effectnode;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.AudioMixer;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.light.AudioFrame;
import org.light.AudioOutput;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LightSdkAudioNode implements TAVAudioProcessorNode {
    public static final String TAG = "LightSdkAudioNode";
    private AudioOutput audioReader;
    private float videoVolume = 1.0f;

    public LightSdkAudioNode(AudioOutput audioOutput) {
        this.audioReader = audioOutput;
    }

    @Override // com.tencent.tavkit.composition.audio.TAVAudioProcessorNode
    public TAVAudioProcessorNode.TAVAudioProcessorEffect createAudioProcessor() {
        return new TAVAudioProcessorNode.TAVAudioProcessorEffect() { // from class: com.tencent.qcircle.weseevideo.composition.effectnode.LightSdkAudioNode.1
            AudioMixer audioMixer = new AudioMixer();

            @Override // com.tencent.tav.core.AudioTapProcessor
            public ByteBuffer processAudioPCM(CMTime cMTime, ByteBuffer byteBuffer, AudioInfo audioInfo) {
                AudioFrame copyNextSample = LightSdkAudioNode.this.audioReader.copyNextSample();
                if (copyNextSample == null) {
                    return null;
                }
                if (EffectNodeOrderUtils.shouldSeek(cMTime, copyNextSample.pts)) {
                    LightSdkAudioNode.this.audioReader.seekTo(cMTime.getTimeUs());
                    copyNextSample = LightSdkAudioNode.this.audioReader.copyNextSample();
                }
                ByteBuffer byteBuffer2 = copyNextSample.data;
                byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
                return this.audioMixer.processBytes(byteBuffer2, 1.0f, LightSdkAudioNode.this.videoVolume, 1.0f);
            }

            @Override // com.tencent.tav.core.AudioTapProcessor
            public void release() {
            }
        };
    }

    @Override // com.tencent.tavkit.composition.audio.TAVAudioProcessorNode
    public String getIdentifier() {
        return TAG;
    }

    public float getVideoVolume() {
        return this.videoVolume;
    }

    public void updateVideoVolume(float f16) {
        this.videoVolume = f16;
    }
}

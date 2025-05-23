package com.tencent.tavkit.composition.audio;

import androidx.annotation.NonNull;
import com.tencent.tav.core.AudioTapProcessor;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes26.dex */
public class TAVAudioTapProcessor implements AudioTapProcessor {
    private final List<TAVAudioConfigurationSegment> audioConfigurationSegmentList;
    private final HashMap<String, AudioTapProcessor> audioTapProcessorHashMap = new HashMap<>();

    public TAVAudioTapProcessor(@NonNull List<TAVAudioConfigurationSegment> list) {
        this.audioConfigurationSegmentList = list;
    }

    public AudioTapProcessor getAudioTapProcessor(TAVAudioProcessorNode tAVAudioProcessorNode) {
        String identifier = tAVAudioProcessorNode.getIdentifier();
        AudioTapProcessor audioTapProcessor = this.audioTapProcessorHashMap.get(identifier);
        if (audioTapProcessor == null) {
            TAVAudioProcessorNode.TAVAudioProcessorEffect createAudioProcessor = tAVAudioProcessorNode.createAudioProcessor();
            this.audioTapProcessorHashMap.put(identifier, createAudioProcessor);
            return createAudioProcessor;
        }
        return audioTapProcessor;
    }

    @Override // com.tencent.tav.core.AudioTapProcessor
    public ByteBuffer processAudioPCM(CMTime cMTime, ByteBuffer byteBuffer, AudioInfo audioInfo) {
        Iterator<TAVAudioConfigurationSegment> it = this.audioConfigurationSegmentList.iterator();
        while (it.hasNext()) {
            byteBuffer = processAudioPCM(cMTime, byteBuffer, audioInfo, it.next());
        }
        return byteBuffer;
    }

    public ByteBuffer processAudioPcm(CMTime cMTime, ByteBuffer byteBuffer, AudioInfo audioInfo, TAVAudioProcessorNode tAVAudioProcessorNode) {
        AudioTapProcessor audioTapProcessor = getAudioTapProcessor(tAVAudioProcessorNode);
        if (audioTapProcessor != null) {
            return audioTapProcessor.processAudioPCM(cMTime, byteBuffer, audioInfo);
        }
        return byteBuffer;
    }

    @Override // com.tencent.tav.core.AudioTapProcessor
    public void release() {
        Iterator<AudioTapProcessor> it = this.audioTapProcessorHashMap.values().iterator();
        while (it.hasNext()) {
            it.next().release();
        }
    }

    @Override // com.tencent.tav.core.AudioTapProcessor
    public void seekTo(CMTime cMTime) {
        Iterator<AudioTapProcessor> it = this.audioTapProcessorHashMap.values().iterator();
        while (it.hasNext()) {
            it.next().seekTo(cMTime);
        }
    }

    public String toString() {
        return "TAVAudioTapProcessor{audioConfigurationSegmentList=" + this.audioConfigurationSegmentList + ", audioTapProcessorHashMap=" + this.audioTapProcessorHashMap + '}';
    }

    public ByteBuffer processAudioPCM(CMTime cMTime, ByteBuffer byteBuffer, AudioInfo audioInfo, TAVAudioConfigurationSegment tAVAudioConfigurationSegment) {
        if (tAVAudioConfigurationSegment != null && tAVAudioConfigurationSegment.compositionTimeRange.containsTime(cMTime)) {
            TAVAudioConfiguration tAVAudioConfiguration = tAVAudioConfigurationSegment.audioConfiguration;
            if (tAVAudioConfiguration.getNodes() == null) {
                return byteBuffer;
            }
            Iterator<TAVAudioProcessorNode> it = tAVAudioConfiguration.getNodes().iterator();
            while (it.hasNext()) {
                byteBuffer = processAudioPcm(cMTime, byteBuffer, audioInfo, it.next());
            }
        }
        return byteBuffer;
    }
}

package com.tencent.tavcut.core.render.audio.extractor;

import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.Timeline;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J4\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/tavcut/core/render/audio/extractor/AudioExtractorProcessor;", "Lcom/tencent/tavcut/core/render/audio/extractor/IAudioExtractorProcessor;", "()V", "extractorMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/tavcut/core/render/audio/extractor/IAudioExtractor;", "cancelExtractAudio", "", "extractorId", "extractAudioFromRenderData", "clipSourceList", "", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "timelineList", "Lcom/tencent/tavcut/core/render/builder/light/model/Timeline;", "outputAudioPath", "listener", "Lcom/tencent/tavcut/core/render/audio/extractor/OnAudioExtractorListener;", "extractAudioFromVideo", "inputVideoPath", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class AudioExtractorProcessor implements IAudioExtractorProcessor {
    private final ConcurrentHashMap<String, IAudioExtractor> extractorMap = new ConcurrentHashMap<>();

    @Override // com.tencent.tavcut.core.render.audio.extractor.IAudioExtractorProcessor
    public void cancelExtractAudio(@NotNull String extractorId) {
        Intrinsics.checkParameterIsNotNull(extractorId, "extractorId");
        IAudioExtractor iAudioExtractor = this.extractorMap.get(extractorId);
        if (iAudioExtractor != null) {
            iAudioExtractor.cancelExtractAudio();
        }
        this.extractorMap.remove(extractorId);
    }

    @Override // com.tencent.tavcut.core.render.audio.extractor.IAudioExtractorProcessor
    @NotNull
    public String extractAudioFromRenderData(@NotNull List<ClipSource> clipSourceList, @NotNull List<Timeline> timelineList, @NotNull String outputAudioPath, @NotNull final OnAudioExtractorListener listener) {
        Intrinsics.checkParameterIsNotNull(clipSourceList, "clipSourceList");
        Intrinsics.checkParameterIsNotNull(timelineList, "timelineList");
        Intrinsics.checkParameterIsNotNull(outputAudioPath, "outputAudioPath");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        final String uuid = UUID.randomUUID().toString();
        Intrinsics.checkExpressionValueIsNotNull(uuid, "UUID.randomUUID().toString()");
        final TavAudioExtractor tavAudioExtractor = new TavAudioExtractor();
        tavAudioExtractor.extractAudioFromClipSources(clipSourceList, timelineList, outputAudioPath, new OnAudioExtractorListener() { // from class: com.tencent.tavcut.core.render.audio.extractor.AudioExtractorProcessor$extractAudioFromRenderData$1
            @Override // com.tencent.tavcut.core.render.audio.extractor.OnAudioExtractorListener
            public void onExtractError(int errCode, @NotNull String errMsg) {
                ConcurrentHashMap concurrentHashMap;
                Intrinsics.checkParameterIsNotNull(errMsg, "errMsg");
                concurrentHashMap = AudioExtractorProcessor.this.extractorMap;
                concurrentHashMap.remove(uuid);
                listener.onExtractError(errCode, errMsg);
            }

            @Override // com.tencent.tavcut.core.render.audio.extractor.OnAudioExtractorListener
            public void onExtractFinish(@NotNull String audioPath) {
                ConcurrentHashMap concurrentHashMap;
                Intrinsics.checkParameterIsNotNull(audioPath, "audioPath");
                concurrentHashMap = AudioExtractorProcessor.this.extractorMap;
                concurrentHashMap.remove(uuid);
                listener.onExtractFinish(audioPath);
            }

            @Override // com.tencent.tavcut.core.render.audio.extractor.OnAudioExtractorListener
            public void onExtractStart() {
                ConcurrentHashMap concurrentHashMap;
                concurrentHashMap = AudioExtractorProcessor.this.extractorMap;
                concurrentHashMap.put(uuid, tavAudioExtractor);
                listener.onExtractStart();
            }

            @Override // com.tencent.tavcut.core.render.audio.extractor.OnAudioExtractorListener
            public void onExtracting(int progress) {
                ConcurrentHashMap concurrentHashMap;
                concurrentHashMap = AudioExtractorProcessor.this.extractorMap;
                if (concurrentHashMap.containsKey(uuid)) {
                    listener.onExtracting(progress);
                }
            }
        });
        return uuid;
    }

    @Override // com.tencent.tavcut.core.render.audio.extractor.IAudioExtractorProcessor
    @NotNull
    public String extractAudioFromVideo(@NotNull String inputVideoPath, @NotNull String outputAudioPath, @NotNull final OnAudioExtractorListener listener) {
        Intrinsics.checkParameterIsNotNull(inputVideoPath, "inputVideoPath");
        Intrinsics.checkParameterIsNotNull(outputAudioPath, "outputAudioPath");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        final String uuid = UUID.randomUUID().toString();
        Intrinsics.checkExpressionValueIsNotNull(uuid, "UUID.randomUUID().toString()");
        final AudioExtractor audioExtractor = new AudioExtractor();
        audioExtractor.extractAudioFromVideo(inputVideoPath, outputAudioPath, new OnAudioExtractorListener() { // from class: com.tencent.tavcut.core.render.audio.extractor.AudioExtractorProcessor$extractAudioFromVideo$1
            @Override // com.tencent.tavcut.core.render.audio.extractor.OnAudioExtractorListener
            public void onExtractError(int errCode, @NotNull String errMsg) {
                ConcurrentHashMap concurrentHashMap;
                Intrinsics.checkParameterIsNotNull(errMsg, "errMsg");
                concurrentHashMap = AudioExtractorProcessor.this.extractorMap;
                concurrentHashMap.remove(uuid);
                listener.onExtractError(errCode, errMsg);
            }

            @Override // com.tencent.tavcut.core.render.audio.extractor.OnAudioExtractorListener
            public void onExtractFinish(@NotNull String audioPath) {
                ConcurrentHashMap concurrentHashMap;
                Intrinsics.checkParameterIsNotNull(audioPath, "audioPath");
                concurrentHashMap = AudioExtractorProcessor.this.extractorMap;
                concurrentHashMap.remove(uuid);
                listener.onExtractFinish(audioPath);
            }

            @Override // com.tencent.tavcut.core.render.audio.extractor.OnAudioExtractorListener
            public void onExtractStart() {
                ConcurrentHashMap concurrentHashMap;
                concurrentHashMap = AudioExtractorProcessor.this.extractorMap;
                concurrentHashMap.put(uuid, audioExtractor);
                listener.onExtractStart();
            }

            @Override // com.tencent.tavcut.core.render.audio.extractor.OnAudioExtractorListener
            public void onExtracting(int progress) {
                ConcurrentHashMap concurrentHashMap;
                concurrentHashMap = AudioExtractorProcessor.this.extractorMap;
                if (concurrentHashMap.containsKey(uuid)) {
                    listener.onExtracting(progress);
                }
            }
        });
        return uuid;
    }
}

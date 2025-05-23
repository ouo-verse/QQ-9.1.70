package com.tencent.tavcut.core.render.audio.extractor;

import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.Timeline;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J4\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&J \u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/tavcut/core/render/audio/extractor/IAudioExtractorProcessor;", "", "cancelExtractAudio", "", "extractorId", "", "extractAudioFromRenderData", "clipSourceList", "", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "timelineList", "Lcom/tencent/tavcut/core/render/builder/light/model/Timeline;", "outputAudioPath", "listener", "Lcom/tencent/tavcut/core/render/audio/extractor/OnAudioExtractorListener;", "extractAudioFromVideo", "inputVideoPath", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public interface IAudioExtractorProcessor {
    void cancelExtractAudio(@NotNull String extractorId);

    @NotNull
    String extractAudioFromRenderData(@NotNull List<ClipSource> clipSourceList, @NotNull List<Timeline> timelineList, @NotNull String outputAudioPath, @NotNull OnAudioExtractorListener listener);

    @NotNull
    String extractAudioFromVideo(@NotNull String inputVideoPath, @NotNull String outputAudioPath, @NotNull OnAudioExtractorListener listener);
}

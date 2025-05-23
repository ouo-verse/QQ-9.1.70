package com.tencent.tavcut.core.render.util;

import com.tencent.tav.core.audio.AudioExportSession;
import com.tencent.tav.core.audio.ExportCallback;
import com.tencent.tav.core.audio.IAudioExportTask;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.core.render.log.TavLogger;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import com.tencent.tavkit.composition.model.TAVVideo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u001e\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/tavcut/core/render/util/TavExtractAudioHelper;", "", "()V", "exportTask", "Lcom/tencent/tav/core/audio/IAudioExportTask;", "cancelExtract", "", "configExtractAudioSegmentDuration", "composition", "Lcom/tencent/tavkit/composition/TAVComposition;", "extractSingleAudioByComposition", "exportPath", "", "exportListener", "Lcom/tencent/tav/core/audio/ExportCallback;", "Companion", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class TavExtractAudioHelper {
    private static final int MAX_SEGMENT_COUNT = 10;
    private static final int MIN_AUDIO_DURATION = 5000000;
    private static final String TAG = "ExtractAudioUtils";
    private IAudioExportTask exportTask;

    public TavExtractAudioHelper() {
        AudioExportSession.MAX_THREAD_COUNT = 3;
    }

    private final void configExtractAudioSegmentDuration(TAVComposition composition) {
        Object obj;
        List<? extends TAVVideo> overlays = composition.getOverlays();
        Intrinsics.checkExpressionValueIsNotNull(overlays, "composition.overlays");
        Iterator<T> it = overlays.iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object next = it.next();
            if (it.hasNext()) {
                TAVVideo it5 = (TAVVideo) next;
                Intrinsics.checkExpressionValueIsNotNull(it5, "it");
                CMTime startTime = it5.getStartTime();
                Intrinsics.checkExpressionValueIsNotNull(startTime, "it.startTime");
                long timeUs = startTime.getTimeUs();
                CMTime duration = it5.getDuration();
                Intrinsics.checkExpressionValueIsNotNull(duration, "it.duration");
                long timeUs2 = timeUs + duration.getTimeUs();
                do {
                    Object next2 = it.next();
                    TAVVideo it6 = (TAVVideo) next2;
                    Intrinsics.checkExpressionValueIsNotNull(it6, "it");
                    CMTime startTime2 = it6.getStartTime();
                    Intrinsics.checkExpressionValueIsNotNull(startTime2, "it.startTime");
                    long timeUs3 = startTime2.getTimeUs();
                    CMTime duration2 = it6.getDuration();
                    Intrinsics.checkExpressionValueIsNotNull(duration2, "it.duration");
                    long timeUs4 = timeUs3 + duration2.getTimeUs();
                    if (timeUs2 < timeUs4) {
                        next = next2;
                        timeUs2 = timeUs4;
                    }
                } while (it.hasNext());
            }
            obj = next;
        }
        TAVVideo tAVVideo = (TAVVideo) obj;
        if (tAVVideo != null) {
            CMTime duration3 = tAVVideo.getDuration();
            long j3 = 0;
            if (duration3 != null) {
                long timeUs5 = duration3.getTimeUs();
                CMTime startTime3 = tAVVideo.getStartTime();
                if (startTime3 != null) {
                    j3 = startTime3.getTimeUs();
                }
                j3 += timeUs5;
            }
            if (j3 <= MIN_AUDIO_DURATION) {
                AudioExportSession.SEGMENT_DURATION_US = (int) j3;
            } else if (j3 < 50000000) {
                AudioExportSession.SEGMENT_DURATION_US = MIN_AUDIO_DURATION;
            } else {
                AudioExportSession.SEGMENT_DURATION_US = (int) (j3 / 10);
            }
            TavLogger.d(TAG, "configExtractAudioSegmentDuration config:" + AudioExportSession.SEGMENT_DURATION_US);
        }
    }

    public final void cancelExtract() {
        IAudioExportTask iAudioExportTask = this.exportTask;
        if (iAudioExportTask != null) {
            iAudioExportTask.cancel();
        }
    }

    public final void extractSingleAudioByComposition(@NotNull TAVComposition composition, @NotNull String exportPath, @NotNull ExportCallback exportListener) {
        Intrinsics.checkParameterIsNotNull(composition, "composition");
        Intrinsics.checkParameterIsNotNull(exportPath, "exportPath");
        Intrinsics.checkParameterIsNotNull(exportListener, "exportListener");
        configExtractAudioSegmentDuration(composition);
        TAVSource buildSource = new TAVCompositionBuilder(composition).buildSource();
        Intrinsics.checkExpressionValueIsNotNull(buildSource, "builder.buildSource()");
        IAudioExportTask generateAudioAssetExportTask = AudioExportSession.generateAudioAssetExportTask(buildSource.getAsset(), exportPath);
        this.exportTask = generateAudioAssetExportTask;
        if (generateAudioAssetExportTask != null) {
            generateAudioAssetExportTask.setExportCallback(exportListener);
        }
        IAudioExportTask iAudioExportTask = this.exportTask;
        if (iAudioExportTask != null) {
            iAudioExportTask.start();
        }
    }
}

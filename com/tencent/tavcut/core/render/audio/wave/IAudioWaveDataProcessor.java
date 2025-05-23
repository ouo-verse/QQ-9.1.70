package com.tencent.tavcut.core.render.audio.wave;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/tavcut/core/render/audio/wave/IAudioWaveDataProcessor;", "", "decodeForWaveData", "", "path", "", "perSecondSampleCnt", "", "gapDurationUs", "", "listener", "Lcom/tencent/tavcut/core/render/audio/wave/IWaveDataCaptureListener;", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public interface IAudioWaveDataProcessor {
    void decodeForWaveData(@NotNull String path, int perSecondSampleCnt, long gapDurationUs, @NotNull IWaveDataCaptureListener listener);
}

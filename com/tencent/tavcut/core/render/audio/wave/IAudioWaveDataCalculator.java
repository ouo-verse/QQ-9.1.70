package com.tencent.tavcut.core.render.audio.wave;

import java.nio.ByteBuffer;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/tavcut/core/render/audio/wave/IAudioWaveDataCalculator;", "", "audioPcmToWaveData", "", "", "pcmByteBuffer", "Ljava/nio/ByteBuffer;", "getWaveDataList", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public interface IAudioWaveDataCalculator {
    @NotNull
    List<Float> audioPcmToWaveData(@NotNull ByteBuffer pcmByteBuffer);

    @NotNull
    List<Float> getWaveDataList();
}

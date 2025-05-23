package com.tencent.tavcut.core.render.audio.wave;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/tavcut/core/render/audio/wave/IAudioWaveDataManager;", "", "getWaveData", "", "audioPath", "", "perSecondSampleCnt", "", "gapDurationUs", "", "listener", "Lcom/tencent/tavcut/core/render/audio/wave/IWaveDataCaptureListener;", "getWaveDataByCache", "", "", "removeListener", "Companion", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public interface IAudioWaveDataManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/tavcut/core/render/audio/wave/IAudioWaveDataManager$Companion;", "", "()V", "DEFAULT_GAP_DURATION_US", "", "DEFAULT_PER_SECOND_SAMPLE_COUNT", "", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final long DEFAULT_GAP_DURATION_US = 500000;
        private static final int DEFAULT_PER_SECOND_SAMPLE_COUNT = 30;

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getWaveData$default(IAudioWaveDataManager iAudioWaveDataManager, String str, int i3, long j3, IWaveDataCaptureListener iWaveDataCaptureListener, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 30;
                }
                int i17 = i3;
                if ((i16 & 4) != 0) {
                    j3 = 500000;
                }
                iAudioWaveDataManager.getWaveData(str, i17, j3, iWaveDataCaptureListener);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWaveData");
        }

        public static /* synthetic */ List getWaveDataByCache$default(IAudioWaveDataManager iAudioWaveDataManager, String str, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 30;
                }
                return iAudioWaveDataManager.getWaveDataByCache(str, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWaveDataByCache");
        }

        public static /* synthetic */ void removeListener$default(IAudioWaveDataManager iAudioWaveDataManager, String str, int i3, IWaveDataCaptureListener iWaveDataCaptureListener, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 30;
                }
                iAudioWaveDataManager.removeListener(str, i3, iWaveDataCaptureListener);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeListener");
        }
    }

    void getWaveData(@NotNull String audioPath, int perSecondSampleCnt, long gapDurationUs, @NotNull IWaveDataCaptureListener listener);

    @Nullable
    List<Float> getWaveDataByCache(@NotNull String audioPath, int perSecondSampleCnt);

    void removeListener(@NotNull String audioPath, int perSecondSampleCnt, @NotNull IWaveDataCaptureListener listener);
}

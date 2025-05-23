package com.tencent.tavcut.core.render.audio.wave;

import androidx.collection.LruCache;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0002J(\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0016J \u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J \u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R&\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\n\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\u000f\u001a \u0012\u0004\u0012\u00020\u0007\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000b0\b0\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/tavcut/core/render/audio/wave/AudioWaveDataManager;", "Lcom/tencent/tavcut/core/render/audio/wave/IAudioWaveDataManager;", "()V", "MAX_CACHE_SIZE", "", "decoderMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Lcom/tencent/tavcut/core/render/audio/wave/IAudioWaveDataProcessor;", "listenerMap", "", "Lcom/tencent/tavcut/core/render/audio/wave/IWaveDataCaptureListener;", JoinPoint.SYNCHRONIZATION_LOCK, "", "waveDataMemCache", "Landroidx/collection/LruCache;", "", "decodeForWaveData", "", "audioPath", "perSecondSampleCnt", "gapDurationUs", "", "listener", "getWaveData", "getWaveDataByCache", "removeListener", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class AudioWaveDataManager implements IAudioWaveDataManager {
    private static final int MAX_CACHE_SIZE = 20;
    public static final AudioWaveDataManager INSTANCE = new AudioWaveDataManager();
    private static final LruCache<String, Pair<Integer, List<Float>>> waveDataMemCache = new LruCache<>(20);
    private static final ConcurrentHashMap<Pair<String, Integer>, List<IWaveDataCaptureListener>> listenerMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Pair<Integer, IAudioWaveDataProcessor>> decoderMap = new ConcurrentHashMap<>();
    private static final Object lock = new Object();

    AudioWaveDataManager() {
    }

    private final void decodeForWaveData(final String audioPath, final int perSecondSampleCnt, long gapDurationUs, IWaveDataCaptureListener listener) {
        ArrayList arrayListOf;
        List<IWaveDataCaptureListener> mutableList;
        ConcurrentHashMap<String, Pair<Integer, IAudioWaveDataProcessor>> concurrentHashMap = decoderMap;
        Pair<Integer, IAudioWaveDataProcessor> pair = concurrentHashMap.get(audioPath);
        final Pair<String, Integer> pair2 = new Pair<>(audioPath, Integer.valueOf(perSecondSampleCnt));
        if (pair != null && pair.getFirst().intValue() == perSecondSampleCnt) {
            synchronized (lock) {
                ConcurrentHashMap<Pair<String, Integer>, List<IWaveDataCaptureListener>> concurrentHashMap2 = listenerMap;
                List<IWaveDataCaptureListener> listeners = concurrentHashMap2.get(pair2);
                if (listeners != null) {
                    Intrinsics.checkExpressionValueIsNotNull(listeners, "listeners");
                    mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) listeners);
                    mutableList.add(listener);
                    concurrentHashMap2.put(pair2, mutableList);
                    Unit unit = Unit.INSTANCE;
                }
            }
            return;
        }
        MediaCodecAudioWaveDataProcessor mediaCodecAudioWaveDataProcessor = new MediaCodecAudioWaveDataProcessor();
        mediaCodecAudioWaveDataProcessor.decodeForWaveData(audioPath, perSecondSampleCnt, gapDurationUs, new IWaveDataCaptureListener() { // from class: com.tencent.tavcut.core.render.audio.wave.AudioWaveDataManager$decodeForWaveData$2
            @Override // com.tencent.tavcut.core.render.audio.wave.IWaveDataCaptureListener
            public void onCaptureError(int errCode, @NotNull String errMsg) {
                ConcurrentHashMap concurrentHashMap3;
                Object obj;
                ConcurrentHashMap concurrentHashMap4;
                Intrinsics.checkParameterIsNotNull(errMsg, "errMsg");
                AudioWaveDataManager audioWaveDataManager = AudioWaveDataManager.INSTANCE;
                concurrentHashMap3 = AudioWaveDataManager.decoderMap;
                concurrentHashMap3.remove(audioPath);
                obj = AudioWaveDataManager.lock;
                synchronized (obj) {
                    concurrentHashMap4 = AudioWaveDataManager.listenerMap;
                    List list = (List) concurrentHashMap4.remove(Pair.this);
                    if (list != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ((IWaveDataCaptureListener) it.next()).onCaptureError(errCode, errMsg);
                        }
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            }

            @Override // com.tencent.tavcut.core.render.audio.wave.IWaveDataCaptureListener
            public void onWaveFormDataCapture(@NotNull List<Float> data) {
                Object obj;
                ConcurrentHashMap concurrentHashMap3;
                Intrinsics.checkParameterIsNotNull(data, "data");
                AudioWaveDataManager audioWaveDataManager = AudioWaveDataManager.INSTANCE;
                obj = AudioWaveDataManager.lock;
                synchronized (obj) {
                    concurrentHashMap3 = AudioWaveDataManager.listenerMap;
                    List list = (List) concurrentHashMap3.get(Pair.this);
                    if (list != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ((IWaveDataCaptureListener) it.next()).onWaveFormDataCapture(data);
                        }
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            }

            @Override // com.tencent.tavcut.core.render.audio.wave.IWaveDataCaptureListener
            public void onWaveFormDataCaptureFinished(@NotNull List<Float> allData) {
                ConcurrentHashMap concurrentHashMap3;
                Object obj;
                ConcurrentHashMap concurrentHashMap4;
                LruCache lruCache;
                Intrinsics.checkParameterIsNotNull(allData, "allData");
                AudioWaveDataManager audioWaveDataManager = AudioWaveDataManager.INSTANCE;
                concurrentHashMap3 = AudioWaveDataManager.decoderMap;
                concurrentHashMap3.remove(audioPath);
                obj = AudioWaveDataManager.lock;
                synchronized (obj) {
                    concurrentHashMap4 = AudioWaveDataManager.listenerMap;
                    List list = (List) concurrentHashMap4.remove(Pair.this);
                    if (list != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ((IWaveDataCaptureListener) it.next()).onWaveFormDataCaptureFinished(allData);
                        }
                    }
                    AudioWaveDataManager audioWaveDataManager2 = AudioWaveDataManager.INSTANCE;
                    lruCache = AudioWaveDataManager.waveDataMemCache;
                }
            }
        });
        concurrentHashMap.put(audioPath, new Pair<>(Integer.valueOf(perSecondSampleCnt), mediaCodecAudioWaveDataProcessor));
        ConcurrentHashMap<Pair<String, Integer>, List<IWaveDataCaptureListener>> concurrentHashMap3 = listenerMap;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(listener);
        concurrentHashMap3.put(pair2, arrayListOf);
    }

    @Override // com.tencent.tavcut.core.render.audio.wave.IAudioWaveDataManager
    public void getWaveData(@NotNull String audioPath, int perSecondSampleCnt, long gapDurationUs, @NotNull IWaveDataCaptureListener listener) {
        Intrinsics.checkParameterIsNotNull(audioPath, "audioPath");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        Pair<Integer, List<Float>> pair = waveDataMemCache.get(audioPath);
        if (pair != null && pair.getFirst().intValue() == perSecondSampleCnt) {
            listener.onWaveFormDataCaptureFinished(pair.getSecond());
        } else {
            decodeForWaveData(audioPath, perSecondSampleCnt, gapDurationUs, listener);
        }
    }

    @Override // com.tencent.tavcut.core.render.audio.wave.IAudioWaveDataManager
    @Nullable
    public List<Float> getWaveDataByCache(@NotNull String audioPath, int perSecondSampleCnt) {
        Intrinsics.checkParameterIsNotNull(audioPath, "audioPath");
        Pair<Integer, List<Float>> pair = waveDataMemCache.get(audioPath);
        if (pair != null && pair.getFirst().intValue() == perSecondSampleCnt) {
            return pair.getSecond();
        }
        return null;
    }

    @Override // com.tencent.tavcut.core.render.audio.wave.IAudioWaveDataManager
    public void removeListener(@NotNull String audioPath, int perSecondSampleCnt, @NotNull IWaveDataCaptureListener listener) {
        List<IWaveDataCaptureListener> mutableList;
        Intrinsics.checkParameterIsNotNull(audioPath, "audioPath");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        synchronized (lock) {
            Pair<String, Integer> pair = new Pair<>(audioPath, Integer.valueOf(perSecondSampleCnt));
            ConcurrentHashMap<Pair<String, Integer>, List<IWaveDataCaptureListener>> concurrentHashMap = listenerMap;
            List<IWaveDataCaptureListener> it = concurrentHashMap.get(pair);
            if (it != null) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) it);
                mutableList.remove(listener);
                concurrentHashMap.put(pair, mutableList);
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}

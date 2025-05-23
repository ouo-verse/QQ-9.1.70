package com.tencent.qqlive.tvkplayer.qqliveasset.strategy;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.TVKBaseAccompanyFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.TVKBaseInterruptFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.nestm3u8.TVKNestM3u8SelectAudioTrackFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.TVKRegularAdaptiveDefinitionFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.TVKRegularSelectAudioTrackFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.TVKRegularSelectSubtitleTrackFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.TVKRegularSwitchDefinitionFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKUniversalDataTransportUnavailableFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKUniversalMediaAssetExpiredFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKUniversalMediaAssetExpiredWithReopenFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKUniversalPlayerErrorRetryFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKUniversalRefreshPlayerFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKUniversalRefreshPlayerWithReopenFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKUniversalReopenSwitchDefinitionFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKUniversalSeekLiveFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKUniversalSimulatedLiveFunction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class TVKFunctionOverrideRegister {
    private static final Map<Class<? extends TVKBaseInterruptFunction>, Map<Class<? extends TVKBaseAccompanyFunction>, Boolean>> sInterruptToOverrideAccompanyMap = new HashMap();
    private static final Map<Class<? extends TVKBaseAccompanyFunction>, Map<Class<? extends TVKBaseAccompanyFunction>, Boolean>> sAccompanyToOverrideAccompanyMap = new HashMap();
    private static final Map<Class<? extends TVKBaseAccompanyFunction>, Map<Class<? extends TVKBaseAccompanyFunction>, Boolean>> sAccompanyToWaitAccompanyMap = new HashMap();

    static {
        registerInterruptToOverrideAccompanyMap(TVKUniversalReopenSwitchDefinitionFunction.class, TVKUniversalSimulatedLiveFunction.class, true);
        registerInterruptToOverrideAccompanyMap(TVKUniversalReopenSwitchDefinitionFunction.class, TVKRegularSwitchDefinitionFunction.class, true);
        registerInterruptToOverrideAccompanyMap(TVKUniversalReopenSwitchDefinitionFunction.class, TVKRegularAdaptiveDefinitionFunction.class, true);
        registerInterruptToOverrideAccompanyMap(TVKUniversalReopenSwitchDefinitionFunction.class, TVKNestM3u8SelectAudioTrackFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalReopenSwitchDefinitionFunction.class, TVKRegularSelectSubtitleTrackFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalReopenSwitchDefinitionFunction.class, TVKRegularSelectAudioTrackFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalReopenSwitchDefinitionFunction.class, TVKUniversalRefreshPlayerFunction.class, true);
        registerInterruptToOverrideAccompanyMap(TVKUniversalReopenSwitchDefinitionFunction.class, TVKUniversalMediaAssetExpiredFunction.class, true);
        registerInterruptToOverrideAccompanyMap(TVKUniversalPlayerErrorRetryFunction.class, TVKUniversalSimulatedLiveFunction.class, true);
        registerInterruptToOverrideAccompanyMap(TVKUniversalPlayerErrorRetryFunction.class, TVKRegularSwitchDefinitionFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalPlayerErrorRetryFunction.class, TVKRegularAdaptiveDefinitionFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalPlayerErrorRetryFunction.class, TVKNestM3u8SelectAudioTrackFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalPlayerErrorRetryFunction.class, TVKRegularSelectSubtitleTrackFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalPlayerErrorRetryFunction.class, TVKRegularSelectAudioTrackFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalPlayerErrorRetryFunction.class, TVKUniversalRefreshPlayerFunction.class, true);
        registerInterruptToOverrideAccompanyMap(TVKUniversalPlayerErrorRetryFunction.class, TVKUniversalMediaAssetExpiredFunction.class, true);
        registerInterruptToOverrideAccompanyMap(TVKUniversalRefreshPlayerWithReopenFunction.class, TVKUniversalSimulatedLiveFunction.class, true);
        registerInterruptToOverrideAccompanyMap(TVKUniversalRefreshPlayerWithReopenFunction.class, TVKRegularSwitchDefinitionFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalRefreshPlayerWithReopenFunction.class, TVKRegularAdaptiveDefinitionFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalRefreshPlayerWithReopenFunction.class, TVKNestM3u8SelectAudioTrackFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalRefreshPlayerWithReopenFunction.class, TVKRegularSelectSubtitleTrackFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalRefreshPlayerWithReopenFunction.class, TVKRegularSelectAudioTrackFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalRefreshPlayerWithReopenFunction.class, TVKUniversalRefreshPlayerFunction.class, true);
        registerInterruptToOverrideAccompanyMap(TVKUniversalRefreshPlayerWithReopenFunction.class, TVKUniversalMediaAssetExpiredFunction.class, true);
        registerInterruptToOverrideAccompanyMap(TVKUniversalSeekLiveFunction.class, TVKUniversalSimulatedLiveFunction.class, true);
        registerInterruptToOverrideAccompanyMap(TVKUniversalSeekLiveFunction.class, TVKRegularSwitchDefinitionFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalSeekLiveFunction.class, TVKRegularAdaptiveDefinitionFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalSeekLiveFunction.class, TVKNestM3u8SelectAudioTrackFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalSeekLiveFunction.class, TVKRegularSelectSubtitleTrackFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalSeekLiveFunction.class, TVKRegularSelectAudioTrackFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalSeekLiveFunction.class, TVKUniversalRefreshPlayerFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalSeekLiveFunction.class, TVKUniversalMediaAssetExpiredFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalDataTransportUnavailableFunction.class, TVKUniversalSimulatedLiveFunction.class, true);
        registerInterruptToOverrideAccompanyMap(TVKUniversalDataTransportUnavailableFunction.class, TVKRegularSwitchDefinitionFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalDataTransportUnavailableFunction.class, TVKRegularAdaptiveDefinitionFunction.class, true);
        registerInterruptToOverrideAccompanyMap(TVKUniversalDataTransportUnavailableFunction.class, TVKNestM3u8SelectAudioTrackFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalDataTransportUnavailableFunction.class, TVKRegularSelectSubtitleTrackFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalDataTransportUnavailableFunction.class, TVKRegularSelectAudioTrackFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalDataTransportUnavailableFunction.class, TVKUniversalRefreshPlayerFunction.class, true);
        registerInterruptToOverrideAccompanyMap(TVKUniversalDataTransportUnavailableFunction.class, TVKUniversalMediaAssetExpiredFunction.class, true);
        registerInterruptToOverrideAccompanyMap(TVKUniversalMediaAssetExpiredWithReopenFunction.class, TVKUniversalSimulatedLiveFunction.class, true);
        registerInterruptToOverrideAccompanyMap(TVKUniversalMediaAssetExpiredWithReopenFunction.class, TVKRegularSwitchDefinitionFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalMediaAssetExpiredWithReopenFunction.class, TVKRegularAdaptiveDefinitionFunction.class, false);
        registerInterruptToOverrideAccompanyMap(TVKUniversalMediaAssetExpiredWithReopenFunction.class, TVKNestM3u8SelectAudioTrackFunction.class, true);
        registerInterruptToOverrideAccompanyMap(TVKUniversalMediaAssetExpiredWithReopenFunction.class, TVKRegularSelectSubtitleTrackFunction.class, true);
        registerInterruptToOverrideAccompanyMap(TVKUniversalMediaAssetExpiredWithReopenFunction.class, TVKRegularSelectAudioTrackFunction.class, true);
        registerInterruptToOverrideAccompanyMap(TVKUniversalMediaAssetExpiredWithReopenFunction.class, TVKUniversalRefreshPlayerFunction.class, true);
        registerInterruptToOverrideAccompanyMap(TVKUniversalMediaAssetExpiredWithReopenFunction.class, TVKUniversalMediaAssetExpiredFunction.class, true);
        registerAccompanyToOverrideAccompanyMap(TVKRegularSwitchDefinitionFunction.class, TVKRegularAdaptiveDefinitionFunction.class, true);
        registerAccompanyToOverrideAccompanyMap(TVKRegularSwitchDefinitionFunction.class, TVKUniversalSimulatedLiveFunction.class, true);
        registerAccompanyToWaitAccompanyMap(TVKNestM3u8SelectAudioTrackFunction.class, TVKRegularSwitchDefinitionFunction.class, true);
        registerAccompanyToWaitAccompanyMap(TVKNestM3u8SelectAudioTrackFunction.class, TVKRegularAdaptiveDefinitionFunction.class, true);
        registerAccompanyToWaitAccompanyMap(TVKRegularSelectSubtitleTrackFunction.class, TVKRegularSwitchDefinitionFunction.class, true);
        registerAccompanyToWaitAccompanyMap(TVKRegularSelectSubtitleTrackFunction.class, TVKRegularAdaptiveDefinitionFunction.class, true);
        registerAccompanyToWaitAccompanyMap(TVKRegularSelectAudioTrackFunction.class, TVKRegularSwitchDefinitionFunction.class, true);
        registerAccompanyToWaitAccompanyMap(TVKRegularSelectAudioTrackFunction.class, TVKRegularAdaptiveDefinitionFunction.class, true);
        registerAccompanyToWaitAccompanyMap(TVKRegularSwitchDefinitionFunction.class, TVKRegularSelectAudioTrackFunction.class, true);
        registerAccompanyToWaitAccompanyMap(TVKRegularAdaptiveDefinitionFunction.class, TVKRegularSelectAudioTrackFunction.class, true);
    }

    public static void checkFunctionOverrideRegisterValid(List<Class<? extends TVKBaseInterruptFunction>> list, List<Class<? extends TVKBaseAccompanyFunction>> list2) {
        for (Class<? extends TVKBaseInterruptFunction> cls : list) {
            Map<Class<? extends TVKBaseAccompanyFunction>, Boolean> map = sInterruptToOverrideAccompanyMap.get(cls);
            if (map != null) {
                if (map.size() == list2.size()) {
                    Set<Class<? extends TVKBaseAccompanyFunction>> keySet = map.keySet();
                    for (Class<? extends TVKBaseAccompanyFunction> cls2 : list2) {
                        if (!keySet.contains(cls2)) {
                            throw new RuntimeException("interruptFunction=" + cls.getSimpleName() + " has not register accompany function=" + cls2.getSimpleName());
                        }
                    }
                } else {
                    throw new RuntimeException("interruptFunction=" + cls.getSimpleName() + " has not register all accompany function override record");
                }
            } else {
                throw new RuntimeException("interruptFunction=" + cls.getSimpleName() + " has not register override function map!!!");
            }
        }
    }

    public static Map<Class<? extends TVKBaseInterruptFunction>, Map<Class<? extends TVKBaseAccompanyFunction>, Boolean>> getInterruptToOverrideAccompanyMap() {
        return sInterruptToOverrideAccompanyMap;
    }

    public static boolean isAccompanyFunctionOverrideByExecuteAccompanyFunction(@NonNull Class<? extends TVKBaseAccompanyFunction> cls, @NonNull Class<? extends TVKBaseAccompanyFunction> cls2) {
        Boolean bool;
        Map<Class<? extends TVKBaseAccompanyFunction>, Boolean> map = sAccompanyToOverrideAccompanyMap.get(cls);
        if (map == null || (bool = map.get(cls2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static boolean isAccompanyFunctionOverrideByExecuteInterruptFunction(@NonNull Class<? extends TVKBaseInterruptFunction> cls, @NonNull Class<? extends TVKBaseAccompanyFunction> cls2) {
        Boolean bool;
        Map<Class<? extends TVKBaseAccompanyFunction>, Boolean> map = sInterruptToOverrideAccompanyMap.get(cls);
        if (map == null || (bool = map.get(cls2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static boolean isNeedWaitActivatedFunctionBeforeExecuteFunction(@NonNull Class<? extends TVKBaseAccompanyFunction> cls, @NonNull Class<? extends TVKBaseAccompanyFunction> cls2) {
        Boolean bool;
        Map<Class<? extends TVKBaseAccompanyFunction>, Boolean> map = sAccompanyToWaitAccompanyMap.get(cls);
        if (map == null || (bool = map.get(cls2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private static void registerAccompanyToOverrideAccompanyMap(Class<? extends TVKBaseAccompanyFunction> cls, Class<? extends TVKBaseAccompanyFunction> cls2, boolean z16) {
        Map<Class<? extends TVKBaseAccompanyFunction>, Boolean> hashMap;
        Map<Class<? extends TVKBaseAccompanyFunction>, Map<Class<? extends TVKBaseAccompanyFunction>, Boolean>> map = sAccompanyToOverrideAccompanyMap;
        if (map.containsKey(cls)) {
            hashMap = map.get(cls);
        } else {
            hashMap = new HashMap<>();
        }
        hashMap.put(cls2, Boolean.valueOf(z16));
        map.put(cls, hashMap);
    }

    private static void registerAccompanyToWaitAccompanyMap(Class<? extends TVKBaseAccompanyFunction> cls, Class<? extends TVKBaseAccompanyFunction> cls2, boolean z16) {
        Map<Class<? extends TVKBaseAccompanyFunction>, Boolean> hashMap;
        Map<Class<? extends TVKBaseAccompanyFunction>, Map<Class<? extends TVKBaseAccompanyFunction>, Boolean>> map = sAccompanyToWaitAccompanyMap;
        if (map.containsKey(cls)) {
            hashMap = map.get(cls);
        } else {
            hashMap = new HashMap<>();
        }
        hashMap.put(cls2, Boolean.valueOf(z16));
        map.put(cls, hashMap);
    }

    private static void registerInterruptToOverrideAccompanyMap(Class<? extends TVKBaseInterruptFunction> cls, Class<? extends TVKBaseAccompanyFunction> cls2, boolean z16) {
        Map<Class<? extends TVKBaseAccompanyFunction>, Boolean> hashMap;
        Map<Class<? extends TVKBaseInterruptFunction>, Map<Class<? extends TVKBaseAccompanyFunction>, Boolean>> map = sInterruptToOverrideAccompanyMap;
        if (map.containsKey(cls)) {
            hashMap = map.get(cls);
        } else {
            hashMap = new HashMap<>();
        }
        hashMap.put(cls2, Boolean.valueOf(z16));
        map.put(cls, hashMap);
    }
}

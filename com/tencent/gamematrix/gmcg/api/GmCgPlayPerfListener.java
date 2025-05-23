package com.tencent.gamematrix.gmcg.api;

import androidx.annotation.MainThread;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameStreamQualityCfg;
import com.tencent.gamematrix.gmcg.api.model.GmCgPlayPerfInfo;
import java.util.Map;

/* loaded from: classes6.dex */
public interface GmCgPlayPerfListener {
    @MainThread
    void onGmCgPlayCumulativeDelayedUpdate(long j3, double d16);

    @MainThread
    void onGmCgPlayPerfStreamQualityAdjust(boolean z16, GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg);

    @MainThread
    void onGmCgPlayPerfStreamShutterLatency(int i3, long j3, int i16);

    @MainThread
    void onGmCgPlayPerfStreamStutterHappen();

    @MainThread
    void onGmCgPlayPerfUpdate(GmCgPlayPerfInfo gmCgPlayPerfInfo);

    @MainThread
    void onGmCgPlayVDecoderPerfData(String str, Map<String, String> map);
}

package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class UploadVisitor implements PerformanceTracer.Visitor, Collectable {
    private HashMap<String, Long> prefInfos = new HashMap<>();

    @Override // com.tencent.qqmusic.mediaplayer.perf.Collectable
    public void accept(ErrorUploadCollector errorUploadCollector) {
    }

    @Override // com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer.Visitor
    public void visitSpeedCheck(List<PerformanceTracer.SpeedCheck> list, PerformanceTracer.OverallInfo overallInfo) {
        for (PerformanceTracer.SpeedCheck speedCheck : list) {
            this.prefInfos.put(speedCheck.getName() + ".ms", Long.valueOf(speedCheck.getTotalTimeMs()));
            this.prefInfos.put(speedCheck.getName() + ".bytes", Long.valueOf(speedCheck.getTotalBufferLength()));
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.perf.Collectable
    public void accept(PlayerInfoCollector playerInfoCollector) {
        if (this.prefInfos.entrySet().isEmpty()) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.prefInfos.entrySet()) {
            playerInfoCollector.putLong(entry.getKey(), entry.getValue().longValue());
        }
    }
}

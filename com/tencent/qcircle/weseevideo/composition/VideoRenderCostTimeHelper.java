package com.tencent.qcircle.weseevideo.composition;

import android.support.annotation.NonNull;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.tavkit.report.FilterChainReportSession;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoRenderCostTimeHelper {
    private static final String TAG = "VideoRenderCostTimeHelper";

    /* JADX INFO: Access modifiers changed from: private */
    public static void printfAllCostTime(@NonNull Map<String, Long> map) {
        for (String str : map.keySet()) {
            if (str != null) {
                Logger.i(TAG, "effectNode: " + str + ", cost time(us): " + map.get(str));
            }
        }
    }

    public static HashMap<String, Long> reportCostTime() {
        final HashMap<String, Long> hashMap = new HashMap<>();
        FilterChainReportSession.setReporter(new FilterChainReportSession.IReporter() { // from class: com.tencent.qcircle.weseevideo.composition.VideoRenderCostTimeHelper.1
            @Override // com.tencent.tavkit.report.FilterChainReportSession.IReporter
            public void onCommit(Map<String, Long> map) {
                hashMap.putAll(map);
                VideoRenderCostTimeHelper.printfAllCostTime(hashMap);
            }
        });
        return hashMap;
    }
}

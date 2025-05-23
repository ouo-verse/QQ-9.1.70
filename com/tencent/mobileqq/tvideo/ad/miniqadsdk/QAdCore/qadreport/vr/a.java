package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.vr;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.vr.IVRPlayReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.f;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    public static IVRPlayReport a(f fVar, Map<String, ?> map) {
        if (fVar == null) {
            return null;
        }
        int i3 = fVar.f304100a;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4 && i3 != 5) {
                        if (i3 != 8) {
                            if (i3 != 9) {
                                return null;
                            }
                        }
                    }
                    return new VRFinishPlayReport(fVar, map);
                }
            } else {
                return new VRPausePlayReport(fVar, map);
            }
        }
        return new VRStartPlayReport(fVar, map);
    }
}

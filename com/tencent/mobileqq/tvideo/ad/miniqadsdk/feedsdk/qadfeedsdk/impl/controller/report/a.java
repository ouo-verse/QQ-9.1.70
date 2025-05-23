package com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.report;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.f;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.h;
import java.util.Map;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    public static void a(Object obj, int i3, long j3, int i16, int i17, Object obj2) {
        b(obj, i3, j3, i16, i17, obj2, null);
    }

    public static void b(Object obj, int i3, long j3, int i16, int i17, Object obj2, Map<String, ?> map) {
        n.e("[MERGE][REPORT]", "FocusEventId = " + i3);
        f fVar = new f();
        fVar.f304100a = i3;
        fVar.f304101b = j3;
        fVar.f304102c = i16;
        fVar.f304103d = i17;
        fVar.f304104e = obj2;
        fVar.f304105f = map;
        h.a().b(obj, fVar);
    }
}

package com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyTechReporterKt {
    public static final String currentPageId() {
        try {
            return c.f117352a.k(BridgeManager.f117344a.u()).getPageName();
        } catch (Exception unused) {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("unknown(");
            m3.append(BridgeManager.f117344a.u());
            m3.append(')');
            return m3.toString();
        }
    }
}

package com.tencent.hippykotlin.demo.pages.foundation.lib;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class LaunchCost {
    public final long fetchContextCost;
    public final long firstFrameAllCost;
    public final long firstFramePaintCost;
    public final long initRenderContextCost;
    public final long initRenderLayerReadCacheCost;
    public final long initRenderLayerRenderCacheCost;
    public final boolean isForceUpdate;
    public final long pageBuildCost;
    public final long pageLayoutCost;

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.firstFrameAllCost, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.firstFramePaintCost, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.pageLayoutCost, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.pageBuildCost, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.initRenderContextCost, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.initRenderLayerRenderCacheCost, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.initRenderLayerReadCacheCost, d.a(this.fetchContextCost) * 31, 31), 31), 31), 31), 31), 31), 31);
        boolean z16 = this.isForceUpdate;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return m3 + i3;
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[LaunchCost]:isForceUpdate:");
        m3.append(this.isForceUpdate);
        m3.append(",fetchContextCost:");
        m3.append(this.fetchContextCost);
        m3.append(",initRenderLayerReadCacheCost: ");
        m3.append(this.initRenderLayerReadCacheCost);
        m3.append(",initRenderLayerRenderCacheCost: ");
        m3.append(this.initRenderLayerRenderCacheCost);
        m3.append(",initRenderContextCost: ");
        m3.append(this.initRenderContextCost);
        m3.append(",pageBuildCost: ");
        m3.append(this.pageBuildCost);
        m3.append(",pageLayoutCost: ");
        m3.append(this.pageLayoutCost);
        m3.append(",firstFramePaintCost: ");
        m3.append(this.firstFramePaintCost);
        m3.append(",firstFrameAllCost: ");
        m3.append(this.firstFrameAllCost);
        return m3.toString();
    }

    public LaunchCost(long j3, long j16, long j17, long j18, long j19, long j26, long j27, long j28, boolean z16) {
        this.fetchContextCost = j3;
        this.initRenderLayerReadCacheCost = j16;
        this.initRenderLayerRenderCacheCost = j17;
        this.initRenderContextCost = j18;
        this.pageBuildCost = j19;
        this.pageLayoutCost = j26;
        this.firstFramePaintCost = j27;
        this.firstFrameAllCost = j28;
        this.isForceUpdate = z16;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LaunchCost)) {
            return false;
        }
        LaunchCost launchCost = (LaunchCost) obj;
        return this.fetchContextCost == launchCost.fetchContextCost && this.initRenderLayerReadCacheCost == launchCost.initRenderLayerReadCacheCost && this.initRenderLayerRenderCacheCost == launchCost.initRenderLayerRenderCacheCost && this.initRenderContextCost == launchCost.initRenderContextCost && this.pageBuildCost == launchCost.pageBuildCost && this.pageLayoutCost == launchCost.pageLayoutCost && this.firstFramePaintCost == launchCost.firstFramePaintCost && this.firstFrameAllCost == launchCost.firstFrameAllCost && this.isForceUpdate == launchCost.isForceUpdate;
    }
}

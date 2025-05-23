package com.tencent.hippykotlin.demo.pages.foundation.lib;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class LaunchTimestamps {
    public final long contentViewCreated;
    public final long fetchContextEnd;
    public final long fetchContextStart;
    public final boolean isForceUpdate;
    public final long layoutEnd;
    public final long layoutStart;
    public final long openPage;
    public final long renderContextEnd;
    public final long renderContextStart;
    public final long renderLayerReadCacheEnd;
    public final long renderLayerReadCacheStart;
    public final long renderLayerRenderCacheEnd;
    public final long renderLayerRenderCacheStart;
    public final long viewLoadEnd;
    public final long viewLoadStart;

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.contentViewCreated, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.layoutEnd, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.layoutStart, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.viewLoadEnd, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.viewLoadStart, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.renderContextEnd, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.renderContextStart, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.renderLayerRenderCacheEnd, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.renderLayerRenderCacheStart, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.renderLayerReadCacheEnd, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.renderLayerReadCacheStart, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.fetchContextEnd, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.fetchContextStart, d.a(this.openPage) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
        boolean z16 = this.isForceUpdate;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return m3 + i3;
    }

    public final String toString() {
        return "LaunchTimestamps(openPage=" + this.openPage + ", fetchContextStart=" + this.fetchContextStart + ", fetchContextEnd=" + this.fetchContextEnd + ", renderLayerReadCacheStart=" + this.renderLayerReadCacheStart + ", renderLayerReadCacheEnd=" + this.renderLayerReadCacheEnd + ", renderLayerRenderCacheStart=" + this.renderLayerRenderCacheStart + ", renderLayerRenderCacheEnd=" + this.renderLayerRenderCacheEnd + ", renderContextStart=" + this.renderContextStart + ", renderContextEnd=" + this.renderContextEnd + ", viewLoadStart=" + this.viewLoadStart + ", viewLoadEnd=" + this.viewLoadEnd + ", layoutStart=" + this.layoutStart + ", layoutEnd=" + this.layoutEnd + ", contentViewCreated=" + this.contentViewCreated + ", isForceUpdate=" + this.isForceUpdate + ')';
    }

    public LaunchTimestamps(long j3, long j16, long j17, long j18, long j19, long j26, long j27, long j28, long j29, long j36, long j37, long j38, long j39, long j46, boolean z16) {
        this.openPage = j3;
        this.fetchContextStart = j16;
        this.fetchContextEnd = j17;
        this.renderLayerReadCacheStart = j18;
        this.renderLayerReadCacheEnd = j19;
        this.renderLayerRenderCacheStart = j26;
        this.renderLayerRenderCacheEnd = j27;
        this.renderContextStart = j28;
        this.renderContextEnd = j29;
        this.viewLoadStart = j36;
        this.viewLoadEnd = j37;
        this.layoutStart = j38;
        this.layoutEnd = j39;
        this.contentViewCreated = j46;
        this.isForceUpdate = z16;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LaunchTimestamps)) {
            return false;
        }
        LaunchTimestamps launchTimestamps = (LaunchTimestamps) obj;
        return this.openPage == launchTimestamps.openPage && this.fetchContextStart == launchTimestamps.fetchContextStart && this.fetchContextEnd == launchTimestamps.fetchContextEnd && this.renderLayerReadCacheStart == launchTimestamps.renderLayerReadCacheStart && this.renderLayerReadCacheEnd == launchTimestamps.renderLayerReadCacheEnd && this.renderLayerRenderCacheStart == launchTimestamps.renderLayerRenderCacheStart && this.renderLayerRenderCacheEnd == launchTimestamps.renderLayerRenderCacheEnd && this.renderContextStart == launchTimestamps.renderContextStart && this.renderContextEnd == launchTimestamps.renderContextEnd && this.viewLoadStart == launchTimestamps.viewLoadStart && this.viewLoadEnd == launchTimestamps.viewLoadEnd && this.layoutStart == launchTimestamps.layoutStart && this.layoutEnd == launchTimestamps.layoutEnd && this.contentViewCreated == launchTimestamps.contentViewCreated && this.isForceUpdate == launchTimestamps.isForceUpdate;
    }
}

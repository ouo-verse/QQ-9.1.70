package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchChainReporter {
    public static boolean isSearching;
    public static final QSearchChainReporter INSTANCE = new QSearchChainReporter();
    public static final SearchChain searchChain = new SearchChain(0, null, 0, 0, 0, 0, 0, 0, false, 511, null);

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static final class SearchChain {
        public long endReqCtx;
        public long endReqGps;
        public long endReqTab;
        public boolean isFromActivePage;
        public String keyword;
        public long reqCtx;
        public long reqGps;
        public long reqTab;
        public long startTime;

        public SearchChain() {
            this(0L, null, 0L, 0L, 0L, 0L, 0L, 0L, false, 511, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int m3 = AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.endReqGps, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.reqGps, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.endReqCtx, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.reqCtx, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.endReqTab, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.reqTab, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.keyword, d.a(this.startTime) * 31, 31), 31), 31), 31), 31), 31), 31);
            boolean z16 = this.isFromActivePage;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return m3 + i3;
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("SearchChain(startTime=");
            m3.append(this.startTime);
            m3.append(", keyword=");
            m3.append(this.keyword);
            m3.append(", reqTab=");
            m3.append(this.reqTab);
            m3.append(", endReqTab=");
            m3.append(this.endReqTab);
            m3.append(", reqCtx=");
            m3.append(this.reqCtx);
            m3.append(", endReqCtx=");
            m3.append(this.endReqCtx);
            m3.append(", reqGps=");
            m3.append(this.reqGps);
            m3.append(", endReqGps=");
            m3.append(this.endReqGps);
            m3.append(", isFromActivePage=");
            return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.isFromActivePage, ')');
        }

        public SearchChain(long j3, String str, long j16, long j17, long j18, long j19, long j26, long j27, boolean z16) {
            this.startTime = j3;
            this.keyword = str;
            this.reqTab = j16;
            this.endReqTab = j17;
            this.reqCtx = j18;
            this.endReqCtx = j19;
            this.reqGps = j26;
            this.endReqGps = j27;
            this.isFromActivePage = z16;
        }

        public final void reset() {
            this.startTime = 0L;
            this.keyword = "";
            this.reqTab = 0L;
            this.endReqTab = 0L;
            this.reqCtx = 0L;
            this.endReqCtx = 0L;
            this.reqGps = 0L;
            this.endReqGps = 0L;
            this.isFromActivePage = true;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SearchChain)) {
                return false;
            }
            SearchChain searchChain = (SearchChain) obj;
            return this.startTime == searchChain.startTime && Intrinsics.areEqual(this.keyword, searchChain.keyword) && this.reqTab == searchChain.reqTab && this.endReqTab == searchChain.endReqTab && this.reqCtx == searchChain.reqCtx && this.endReqCtx == searchChain.endReqCtx && this.reqGps == searchChain.reqGps && this.endReqGps == searchChain.endReqGps && this.isFromActivePage == searchChain.isFromActivePage;
        }

        public /* synthetic */ SearchChain(long j3, String str, long j16, long j17, long j18, long j19, long j26, long j27, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(0L, "", 0L, 0L, 0L, 0L, 0L, 0L, true);
        }
    }

    public final void updateSearchStartTime(long j3, String str, boolean z16) {
        if (isSearching) {
            return;
        }
        SearchChain searchChain2 = searchChain;
        searchChain2.reset();
        isSearching = true;
        searchChain2.startTime = j3;
        searchChain2.keyword = str;
        searchChain2.isFromActivePage = z16;
    }
}

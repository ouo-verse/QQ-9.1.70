package com.tencent.mobileqq.search.searchdetail.searchbox;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.util.ak;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002J\u0016\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002J\u0016\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/searchbox/f;", "", "", "startTime", "", "keyword", "", "isFromActivePage", "tabMask", "", "i", "g", "c", "renderCost", tl.h.F, "f", "b", "e", "a", "isSucc", "d", "Lcom/tencent/mobileqq/search/searchdetail/searchbox/f$a;", "Lcom/tencent/mobileqq/search/searchdetail/searchbox/f$a;", "searchChain", "Z", "isSearching", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f284591a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SearchChain searchChain = new SearchChain(0, 0, null, 0, 0, 0, 0, 0, 0, false, 0, 2047, null);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isSearching;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b-\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u0012\b\b\u0002\u0010 \u001a\u00020\u000b\u0012\b\b\u0002\u0010#\u001a\u00020\u000b\u0012\b\b\u0002\u0010&\u001a\u00020\u000b\u0012\b\b\u0002\u0010)\u001a\u00020\u000b\u0012\b\b\u0002\u0010+\u001a\u00020\u000b\u0012\b\b\u0002\u0010-\u001a\u00020\u000b\u0012\b\b\u0002\u00103\u001a\u00020\t\u0012\b\b\u0002\u00105\u001a\u00020\u000b\u00a2\u0006\u0004\b6\u00107J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010 \u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\"\u0010#\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\r\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\"\u0010\u0011R\"\u0010&\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\r\u001a\u0004\b$\u0010\u000f\"\u0004\b%\u0010\u0011R\"\u0010)\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\r\u001a\u0004\b\f\u0010\u000f\"\u0004\b(\u0010\u0011R\"\u0010+\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\r\u001a\u0004\b'\u0010\u000f\"\u0004\b*\u0010\u0011R\"\u0010-\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b,\u0010\u0011R\"\u00103\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00105\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\r\u001a\u0004\b!\u0010\u000f\"\u0004\b4\u0010\u0011\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/searchbox/f$a;", "", "", "l", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "j", "()J", "w", "(J)V", "tabMask", "b", "i", "v", "startTime", "c", "Ljava/lang/String;", "d", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/String;)V", "keyword", tl.h.F, "u", "reqTab", "e", "o", "endReqTab", "f", ReportConstant.COSTREPORT_PREFIX, "reqCtx", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "endReqCtx", "t", "reqGps", DomainData.DOMAIN_NAME, "endReqGps", "Z", "k", "()Z", "p", "(Z)V", "isFromActivePage", "r", "renderCost", "<init>", "(JJLjava/lang/String;JJJJJJZJ)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.searchbox.f$a, reason: from toString */
    /* loaded from: classes18.dex */
    public static final /* data */ class SearchChain {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private long tabMask;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private long startTime;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String keyword;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private long reqTab;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private long endReqTab;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private long reqCtx;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private long endReqCtx;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private long reqGps;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        private long endReqGps;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isFromActivePage;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
        private long renderCost;

        public SearchChain() {
            this(0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, false, 0L, 2047, null);
        }

        /* renamed from: a, reason: from getter */
        public final long getEndReqCtx() {
            return this.endReqCtx;
        }

        /* renamed from: b, reason: from getter */
        public final long getEndReqGps() {
            return this.endReqGps;
        }

        /* renamed from: c, reason: from getter */
        public final long getEndReqTab() {
            return this.endReqTab;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getKeyword() {
            return this.keyword;
        }

        /* renamed from: e, reason: from getter */
        public final long getRenderCost() {
            return this.renderCost;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchChain)) {
                return false;
            }
            SearchChain searchChain = (SearchChain) other;
            if (this.tabMask == searchChain.tabMask && this.startTime == searchChain.startTime && Intrinsics.areEqual(this.keyword, searchChain.keyword) && this.reqTab == searchChain.reqTab && this.endReqTab == searchChain.endReqTab && this.reqCtx == searchChain.reqCtx && this.endReqCtx == searchChain.endReqCtx && this.reqGps == searchChain.reqGps && this.endReqGps == searchChain.endReqGps && this.isFromActivePage == searchChain.isFromActivePage && this.renderCost == searchChain.renderCost) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final long getReqCtx() {
            return this.reqCtx;
        }

        /* renamed from: g, reason: from getter */
        public final long getReqGps() {
            return this.reqGps;
        }

        /* renamed from: h, reason: from getter */
        public final long getReqTab() {
            return this.reqTab;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int a16 = ((((((((((((((((androidx.fragment.app.a.a(this.tabMask) * 31) + androidx.fragment.app.a.a(this.startTime)) * 31) + this.keyword.hashCode()) * 31) + androidx.fragment.app.a.a(this.reqTab)) * 31) + androidx.fragment.app.a.a(this.endReqTab)) * 31) + androidx.fragment.app.a.a(this.reqCtx)) * 31) + androidx.fragment.app.a.a(this.endReqCtx)) * 31) + androidx.fragment.app.a.a(this.reqGps)) * 31) + androidx.fragment.app.a.a(this.endReqGps)) * 31;
            boolean z16 = this.isFromActivePage;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((a16 + i3) * 31) + androidx.fragment.app.a.a(this.renderCost);
        }

        /* renamed from: i, reason: from getter */
        public final long getStartTime() {
            return this.startTime;
        }

        /* renamed from: j, reason: from getter */
        public final long getTabMask() {
            return this.tabMask;
        }

        /* renamed from: k, reason: from getter */
        public final boolean getIsFromActivePage() {
            return this.isFromActivePage;
        }

        public final void l() {
            this.startTime = 0L;
            this.keyword = "";
            this.reqTab = 0L;
            this.endReqTab = 0L;
            this.reqCtx = 0L;
            this.endReqCtx = 0L;
            this.reqGps = 0L;
            this.endReqGps = 0L;
            this.isFromActivePage = true;
            this.tabMask = -1L;
        }

        public final void m(long j3) {
            this.endReqCtx = j3;
        }

        public final void n(long j3) {
            this.endReqGps = j3;
        }

        public final void o(long j3) {
            this.endReqTab = j3;
        }

        public final void p(boolean z16) {
            this.isFromActivePage = z16;
        }

        public final void q(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.keyword = str;
        }

        public final void r(long j3) {
            this.renderCost = j3;
        }

        public final void s(long j3) {
            this.reqCtx = j3;
        }

        public final void t(long j3) {
            this.reqGps = j3;
        }

        @NotNull
        public String toString() {
            return "SearchChain(tabMask=" + this.tabMask + ", startTime=" + this.startTime + ", keyword=" + this.keyword + ", reqTab=" + this.reqTab + ", endReqTab=" + this.endReqTab + ", reqCtx=" + this.reqCtx + ", endReqCtx=" + this.endReqCtx + ", reqGps=" + this.reqGps + ", endReqGps=" + this.endReqGps + ", isFromActivePage=" + this.isFromActivePage + ", renderCost=" + this.renderCost + ")";
        }

        public final void u(long j3) {
            this.reqTab = j3;
        }

        public final void v(long j3) {
            this.startTime = j3;
        }

        public final void w(long j3) {
            this.tabMask = j3;
        }

        public SearchChain(long j3, long j16, @NotNull String keyword, long j17, long j18, long j19, long j26, long j27, long j28, boolean z16, long j29) {
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            this.tabMask = j3;
            this.startTime = j16;
            this.keyword = keyword;
            this.reqTab = j17;
            this.endReqTab = j18;
            this.reqCtx = j19;
            this.endReqCtx = j26;
            this.reqGps = j27;
            this.endReqGps = j28;
            this.isFromActivePage = z16;
            this.renderCost = j29;
        }

        public /* synthetic */ SearchChain(long j3, long j16, String str, long j17, long j18, long j19, long j26, long j27, long j28, boolean z16, long j29, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? -1L : j3, (i3 & 2) != 0 ? 0L : j16, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? 0L : j17, (i3 & 16) != 0 ? 0L : j18, (i3 & 32) != 0 ? 0L : j19, (i3 & 64) != 0 ? 0L : j26, (i3 & 128) != 0 ? 0L : j27, (i3 & 256) != 0 ? 0L : j28, (i3 & 512) != 0 ? true : z16, (i3 & 1024) != 0 ? 0L : j29);
        }
    }

    f() {
    }

    public final void a(long tabMask) {
        SearchChain searchChain2 = searchChain;
        if (searchChain2.getTabMask() == tabMask) {
            searchChain2.m(System.currentTimeMillis());
        }
    }

    public final void b(long tabMask) {
        SearchChain searchChain2 = searchChain;
        if (searchChain2.getTabMask() == tabMask) {
            searchChain2.n(System.currentTimeMillis());
        }
    }

    public final void c(long tabMask) {
        SearchChain searchChain2 = searchChain;
        if (searchChain2.getTabMask() == tabMask) {
            searchChain2.o(System.currentTimeMillis());
        }
    }

    public final void d(boolean isSucc, long tabMask) {
        if (!isSearching) {
            return;
        }
        SearchChain searchChain2 = searchChain;
        if (searchChain2.getTabMask() != tabMask) {
            return;
        }
        isSearching = false;
        ak.e(searchChain2.getStartTime(), System.currentTimeMillis(), searchChain2.getKeyword(), searchChain2.getReqTab(), searchChain2.getEndReqTab(), searchChain2.getReqCtx(), searchChain2.getEndReqCtx(), searchChain2.getReqGps(), searchChain2.getEndReqGps(), searchChain2.getIsFromActivePage(), searchChain2.getRenderCost(), isSucc);
        searchChain2.l();
    }

    public final void e(long tabMask) {
        SearchChain searchChain2 = searchChain;
        if (searchChain2.getTabMask() == tabMask) {
            searchChain2.s(System.currentTimeMillis());
        }
    }

    public final void f(long tabMask) {
        SearchChain searchChain2 = searchChain;
        if (searchChain2.getTabMask() == tabMask) {
            searchChain2.t(System.currentTimeMillis());
        }
    }

    public final void g(long tabMask) {
        SearchChain searchChain2 = searchChain;
        if (searchChain2.getTabMask() == tabMask) {
            searchChain2.u(System.currentTimeMillis());
        }
    }

    public final void h(long renderCost, long tabMask) {
        SearchChain searchChain2 = searchChain;
        if (searchChain2.getTabMask() == tabMask) {
            searchChain2.r(renderCost);
        }
    }

    public final void i(long startTime, @NotNull String keyword, boolean isFromActivePage, long tabMask) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        if (isSearching) {
            return;
        }
        SearchChain searchChain2 = searchChain;
        searchChain2.l();
        isSearching = true;
        searchChain2.v(startTime);
        searchChain2.w(tabMask);
        searchChain2.q(keyword);
        searchChain2.p(isFromActivePage);
    }
}

package com.tencent.mobileqq.search.searchdetail.content.wxminapp.report;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.SearchWXMiniAppExposeReportManager;
import com.tencent.mobileqq.search.util.af;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0002$<B\u0017\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010*\u001a\u00020'\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J@\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J0\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J \u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J(\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0002J\u0014\u0010\u001e\u001a\u00020\u001d*\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH\u0002J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\u0002H\u0016J\b\u0010\"\u001a\u00020\u0002H\u0016R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R,\u00101\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0/0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u00100R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u0006028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u00103R\u001f\u00109\u001a\u000605R\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u00106\u001a\u0004\b7\u00108\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/SearchWXMiniAppExposeReportManager;", "Lqp2/c;", "", "e", "Landroid/view/View;", "view", "", "docId", "", "currentMask", "miniAppType", "position", "pageNum", "Lqp2/a;", "backEndReportInfo", "l", "docView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "i", "cacheMask", "", "timeStamps", "d", "Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/b;", "g", "Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/a;", "f", "mask", "", "k", "start", "resume", "pause", "stop", "Landroidx/recyclerview/widget/RecyclerView;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lqp2/b;", "b", "Lqp2/b;", "searchCardIOC", "c", "Z", "isRunning", "", "Lkotlin/Pair;", "Ljava/util/Map;", "cacheDocReportMap", "", "Ljava/util/Set;", "cacheItemReportSet", "Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/SearchWXMiniAppExposeReportManager$InternalTask;", "Lkotlin/Lazy;", tl.h.F, "()Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/SearchWXMiniAppExposeReportManager$InternalTask;", "innerTask", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lqp2/b;)V", "InternalTask", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchWXMiniAppExposeReportManager implements qp2.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView recyclerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private qp2.b searchCardIOC;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isRunning;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Pair<Long, Integer>> cacheDocReportMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> cacheItemReportSet;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy innerTask;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/SearchWXMiniAppExposeReportManager$InternalTask;", "Ljava/lang/Runnable;", "(Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/SearchWXMiniAppExposeReportManager;)V", TencentLocation.RUN_MODE, "", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public final class InternalTask implements Runnable {
        public InternalTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchWXMiniAppExposeReportManager.this.e();
            if (SearchWXMiniAppExposeReportManager.this.isRunning) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(SearchWXMiniAppExposeReportManager.this.h(), 200L);
            }
        }
    }

    public SearchWXMiniAppExposeReportManager(@NotNull RecyclerView recyclerView, @NotNull qp2.b searchCardIOC) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(searchCardIOC, "searchCardIOC");
        this.recyclerView = recyclerView;
        this.searchCardIOC = searchCardIOC;
        this.cacheDocReportMap = new LinkedHashMap();
        this.cacheItemReportSet = new LinkedHashSet();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<InternalTask>() { // from class: com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.SearchWXMiniAppExposeReportManager$innerTask$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SearchWXMiniAppExposeReportManager.InternalTask invoke() {
                return new SearchWXMiniAppExposeReportManager.InternalTask();
            }
        });
        this.innerTask = lazy;
    }

    private final int d(int currentMask, int cacheMask, long timeStamps) {
        int i3 = 4;
        if (!k(currentMask, 4) || k(cacheMask, 4)) {
            i3 = 0;
        }
        if (k(currentMask, 2) && !k(cacheMask, 2) && System.currentTimeMillis() - timeStamps >= 1000) {
            i3 |= 2;
        }
        if (k(currentMask, 1) && !k(cacheMask, 1)) {
            return i3 | 1;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        LinearLayoutManager linearLayoutManager;
        int findFirstVisibleItemPosition;
        int findLastVisibleItemPosition;
        com.tencent.mobileqq.search.searchdetail.content.template.model.a o16;
        int v3;
        qp2.a j3;
        int j16;
        int i3;
        RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        } else {
            linearLayoutManager = null;
        }
        LinearLayoutManager linearLayoutManager2 = linearLayoutManager;
        if (linearLayoutManager2 != null && (findFirstVisibleItemPosition = linearLayoutManager2.findFirstVisibleItemPosition()) <= (findLastVisibleItemPosition = linearLayoutManager2.findLastVisibleItemPosition())) {
            int i16 = findFirstVisibleItemPosition;
            while (true) {
                View findViewByPosition = linearLayoutManager2.findViewByPosition(i16);
                if (findViewByPosition != null) {
                    Intrinsics.checkNotNullExpressionValue(findViewByPosition, "it.findViewByPosition(i) ?: continue");
                    if (findViewByPosition.getVisibility() == 0 && findViewByPosition.isShown() && (o16 = j.o(findViewByPosition)) != null && (v3 = j.v(findViewByPosition)) != 0 && (j3 = j.j(findViewByPosition)) != null && j3.p() && (j16 = j(findViewByPosition)) != 0) {
                        String str = j3.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID java.lang.String();
                        if (this.cacheDocReportMap.get(str) == null) {
                            this.cacheDocReportMap.put(str, new Pair<>(Long.valueOf(System.currentTimeMillis()), 0));
                        }
                        if (o16.getWithoutTitlePosition() >= 0) {
                            i3 = o16.getWithoutTitlePosition();
                        } else {
                            i3 = i16;
                        }
                        int i17 = i3;
                        l(findViewByPosition, str, j16, v3, i17, o16.getPageNum(), j3);
                        m(findViewByPosition, v3, o16.getPageNum(), j3, i17);
                    }
                }
                if (i16 != findLastVisibleItemPosition) {
                    i16++;
                } else {
                    return;
                }
            }
        }
    }

    private final AdReportParam f(qp2.a backEndReportInfo, int position, int pageNum) {
        return new AdReportParam(position, backEndReportInfo.getExtBackComm(), backEndReportInfo.getSearchAdExtraData(), backEndReportInfo.getSearchId(), this.searchCardIOC.getKeyword(), Long.valueOf(this.searchCardIOC.getStartSearchTimeStamps()), this.recyclerView.getChildCount(), pageNum, position, j.A(this.searchCardIOC.getQuerySource()));
    }

    private final SearchNormalReportParam g(qp2.a backEndReportInfo, int miniAppType, int pageNum, int position) {
        return j.y(backEndReportInfo, this.searchCardIOC.getKeyword(), this.searchCardIOC.getQuerySource(), this.searchCardIOC.getTabMask(), miniAppType, pageNum, this.searchCardIOC.getMiniAppSessionId(), null, position, 64, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InternalTask h() {
        return (InternalTask) this.innerTask.getValue();
    }

    private final int i(int miniAppType) {
        if (miniAppType == 3) {
            return 2;
        }
        return 1;
    }

    private final int j(View view) {
        int i3;
        double percentageOfGlobalVisibleRect = AdUIUtils.getPercentageOfGlobalVisibleRect(view);
        if (percentageOfGlobalVisibleRect <= 0.0d) {
            return 0;
        }
        if (percentageOfGlobalVisibleRect >= 1.0d) {
            i3 = 5;
        } else {
            i3 = 1;
        }
        if (percentageOfGlobalVisibleRect >= 0.5d) {
            return i3 | 2;
        }
        return i3;
    }

    private final boolean k(int i3, int i16) {
        if ((i3 & i16) != 0) {
            return true;
        }
        return false;
    }

    private final void l(View view, String docId, int currentMask, int miniAppType, int position, int pageNum, qp2.a backEndReportInfo) {
        Throwable th5;
        String str;
        Throwable th6;
        String str2;
        SearchNormalReportParam a16;
        boolean z16;
        SearchNormalReportParam a17;
        SearchNormalReportParam a18;
        Pair<Long, Integer> pair = this.cacheDocReportMap.get(docId);
        if (pair == null) {
            return;
        }
        long longValue = pair.component1().longValue();
        int intValue = pair.component2().intValue();
        int i3 = i(miniAppType);
        int d16 = d(currentMask, intValue, longValue);
        if (d16 == 0) {
            return;
        }
        SearchNormalReportParam g16 = g(backEndReportInfo, miniAppType, pageNum, position);
        AdReportParam f16 = f(backEndReportInfo, position, pageNum);
        int i16 = 2;
        if (k(d16, 1) && i3 == 2) {
            j.I(view, f16);
            af afVar = af.f284993a;
            th5 = null;
            QLog.i("QS.SearchWXMiniAppReportManager", 1, "reportImp 1px, traceId=" + docId, null);
            i16 = 2;
        } else {
            th5 = null;
        }
        if (!k(d16, i16)) {
            str = "SearchWXMiniAppReportManager";
            th6 = th5;
            str2 = "QS.";
        } else {
            if (i3 == i16) {
                j.G(view, f16);
            }
            str = "SearchWXMiniAppReportManager";
            th6 = th5;
            str2 = "QS.";
            a18 = g16.a((r38 & 1) != 0 ? g16.query : null, (r38 & 2) != 0 ? g16.searchId : null, (r38 & 4) != 0 ? g16.scene : 0, (r38 & 8) != 0 ? g16.parentSearchId : null, (r38 & 16) != 0 ? g16.reqBusinessType : 0, (r38 & 32) != 0 ? g16.businessType : 0, (r38 & 64) != 0 ? g16.subType : 0, (r38 & 128) != 0 ? g16.boxInfo : null, (r38 & 256) != 0 ? g16.docInfo : null, (r38 & 512) != 0 ? g16.itemInfo : null, (r38 & 1024) != 0 ? g16.itemPos : null, (r38 & 2048) != 0 ? g16.resultType : 0, (r38 & 4096) != 0 ? g16.actionType : 2004, (r38 & 8192) != 0 ? g16.clickId : null, (r38 & 16384) != 0 ? g16.pageNumber : 0, (r38 & 32768) != 0 ? g16.sessionId : null, (r38 & 65536) != 0 ? g16.svrBoxExtInfo : null, (r38 & 131072) != 0 ? g16.svrDocExtInfo : null, (r38 & 262144) != 0 ? g16.qqClientVersion : null, (r38 & 524288) != 0 ? g16.netWorkType : null);
            j.K(a18, "doc 50%");
            af afVar2 = af.f284993a;
            QLog.i(str2 + str, 1, "reportImp 50%, traceId=" + docId, th6);
        }
        if (k(d16, 4)) {
            a16 = g16.a((r38 & 1) != 0 ? g16.query : null, (r38 & 2) != 0 ? g16.searchId : null, (r38 & 4) != 0 ? g16.scene : 0, (r38 & 8) != 0 ? g16.parentSearchId : null, (r38 & 16) != 0 ? g16.reqBusinessType : 0, (r38 & 32) != 0 ? g16.businessType : 0, (r38 & 64) != 0 ? g16.subType : 0, (r38 & 128) != 0 ? g16.boxInfo : null, (r38 & 256) != 0 ? g16.docInfo : null, (r38 & 512) != 0 ? g16.itemInfo : null, (r38 & 1024) != 0 ? g16.itemPos : null, (r38 & 2048) != 0 ? g16.resultType : 0, (r38 & 4096) != 0 ? g16.actionType : 2000, (r38 & 8192) != 0 ? g16.clickId : null, (r38 & 16384) != 0 ? g16.pageNumber : 0, (r38 & 32768) != 0 ? g16.sessionId : null, (r38 & 65536) != 0 ? g16.svrBoxExtInfo : null, (r38 & 131072) != 0 ? g16.svrDocExtInfo : null, (r38 & 262144) != 0 ? g16.qqClientVersion : null, (r38 & 524288) != 0 ? g16.netWorkType : null);
            j.K(a16, "doc 100%");
            if (backEndReportInfo.getItemInfo().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                a17 = g16.a((r38 & 1) != 0 ? g16.query : null, (r38 & 2) != 0 ? g16.searchId : null, (r38 & 4) != 0 ? g16.scene : 0, (r38 & 8) != 0 ? g16.parentSearchId : null, (r38 & 16) != 0 ? g16.reqBusinessType : 0, (r38 & 32) != 0 ? g16.businessType : 0, (r38 & 64) != 0 ? g16.subType : 0, (r38 & 128) != 0 ? g16.boxInfo : null, (r38 & 256) != 0 ? g16.docInfo : null, (r38 & 512) != 0 ? g16.itemInfo : backEndReportInfo.getItemInfo(), (r38 & 1024) != 0 ? g16.itemPos : "0:" + j.B(backEndReportInfo.getItemInfo()), (r38 & 2048) != 0 ? g16.resultType : 0, (r38 & 4096) != 0 ? g16.actionType : 2001, (r38 & 8192) != 0 ? g16.clickId : null, (r38 & 16384) != 0 ? g16.pageNumber : 0, (r38 & 32768) != 0 ? g16.sessionId : null, (r38 & 65536) != 0 ? g16.svrBoxExtInfo : null, (r38 & 131072) != 0 ? g16.svrDocExtInfo : null, (r38 & 262144) != 0 ? g16.qqClientVersion : null, (r38 & 524288) != 0 ? g16.netWorkType : null);
                j.K(a17, "big item 100%");
            }
            af afVar3 = af.f284993a;
            QLog.i(str2 + str, 1, "reportImp 100%, traceId=" + docId, th6);
        }
        this.cacheDocReportMap.put(docId, new Pair<>(Long.valueOf(longValue), Integer.valueOf(intValue | d16)));
    }

    private final void m(View docView, int miniAppType, int pageNum, qp2.a backEndReportInfo, int position) {
        boolean z16;
        boolean z17;
        if (miniAppType == 0) {
            return;
        }
        ArrayList<View> arrayList = new ArrayList();
        View p16 = j.p(docView);
        if (p16 != null) {
            arrayList.add(p16);
        }
        List<View> n3 = j.n(docView);
        if (n3 != null) {
            arrayList.addAll(n3);
        }
        for (View view : arrayList) {
            String q16 = j.q(view);
            String s16 = j.s(view);
            String u16 = j.u(view);
            boolean z18 = false;
            if (q16 != null && q16.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (s16 != null && s16.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    if (u16 == null || u16.length() == 0) {
                        z18 = true;
                    }
                    if (!z18 && k(j(view), 4) && !this.cacheItemReportSet.contains(q16)) {
                        SearchNormalReportParam g16 = g(backEndReportInfo, miniAppType, pageNum, position);
                        g16.e(2001);
                        g16.j(s16);
                        g16.k(u16);
                        j.K(g16, "sub item 100%");
                        this.cacheItemReportSet.add(q16);
                        af afVar = af.f284993a;
                        QLog.i("QS.SearchWXMiniAppReportManager", 1, "reportItemImp 100%, itemId=" + q16, null);
                    }
                }
            }
        }
    }

    @Override // qp2.c
    public void pause() {
        if (!this.isRunning) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(h());
        this.isRunning = false;
    }

    @Override // qp2.c
    public void resume() {
        start();
    }

    @Override // qp2.c
    public void start() {
        if (this.isRunning) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(h());
        this.isRunning = true;
    }

    @Override // qp2.c
    public void stop() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(h());
        this.isRunning = false;
    }
}

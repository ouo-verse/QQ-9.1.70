package com.tencent.mobileqq.search.searchdetail.content.wxminapp.report;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.search.util.af;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \"2\u00020\u0001:\u0001\nB7\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\u001b\u0010\r\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/SearchWXMiniAppStayReportManager;", "Lqp2/d;", "", "clickId", "", "onClickMiniApp", "onFirstFrame", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/k;", "a", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/k;", "stayReportParam", "b", "Ljava/lang/String;", "miniAppClickId", "", "c", "J", "lastPauseTimeStamps", "", "d", "Z", "hasPause", "keyword", "", QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "tabMask", "sessionId", "searchId", "parentSearchId", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "e", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchWXMiniAppStayReportManager implements qp2.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy stayReportParam;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String miniAppClickId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long lastPauseTimeStamps;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean hasPause;

    public SearchWXMiniAppStayReportManager(@NotNull String keyword, int i3, int i16, @NotNull String sessionId, @NotNull String searchId, @NotNull String parentSearchId) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(searchId, "searchId");
        Intrinsics.checkNotNullParameter(parentSearchId, "parentSearchId");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SearchStayReportParam>() { // from class: com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.SearchWXMiniAppStayReportManager$stayReportParam$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SearchStayReportParam invoke() {
                return new SearchStayReportParam(null, null, 0, null, 0, 0, 0L, 0L, 0, null, null, 2047, null);
            }
        });
        this.stayReportParam = lazy;
        this.miniAppClickId = "";
        SearchStayReportParam a16 = a();
        a16.e(keyword);
        a16.h(searchId);
        a16.d(parentSearchId);
        a16.g(qp2.f.b(i3));
        a16.f(j.S(i16));
        a16.i(sessionId);
    }

    private final SearchStayReportParam a() {
        return (SearchStayReportParam) this.stayReportParam.getValue();
    }

    @Override // qp2.d
    public void onClickMiniApp(@NotNull String clickId) {
        Intrinsics.checkNotNullParameter(clickId, "clickId");
        this.miniAppClickId = clickId;
    }

    @Override // qp2.d
    public void onFirstFrame() {
        af afVar = af.f284993a;
        QLog.i("QS.SearchWXMiniAppStayReportManager", 1, "onFirstFrame", null);
        j.M(SearchStayReportParam.b(a(), null, null, 0, null, 0, 1, System.currentTimeMillis(), 0L, 0, null, null, 1951, null));
    }

    @Override // qp2.d
    public void onPause() {
        af afVar = af.f284993a;
        QLog.i("QS.SearchWXMiniAppStayReportManager", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, null);
        j.M(SearchStayReportParam.b(a(), null, null, 0, null, 0, 2, System.currentTimeMillis(), 0L, 0, null, null, 1951, null));
        this.lastPauseTimeStamps = System.currentTimeMillis();
        this.hasPause = true;
    }

    @Override // qp2.d
    public void onResume() {
        af afVar = af.f284993a;
        boolean z16 = true;
        QLog.i("QS.SearchWXMiniAppStayReportManager", 1, "onResume", null);
        if (this.hasPause) {
            if (this.miniAppClickId.length() <= 0) {
                z16 = false;
            }
            if (z16) {
                j.M(SearchStayReportParam.b(a(), null, null, 0, null, 0, 4, System.currentTimeMillis(), 0L, 0, null, this.miniAppClickId, com.tencent.luggage.wxa.b7.a.CTRL_INDEX, null));
                this.miniAppClickId = "";
            } else {
                j.M(SearchStayReportParam.b(a(), null, null, 0, null, 0, 3, System.currentTimeMillis(), System.currentTimeMillis() - this.lastPauseTimeStamps, 0, null, null, 1823, null));
            }
        }
        this.hasPause = false;
    }
}

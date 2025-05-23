package com.tencent.mobileqq.search.searchdetail.content.wxminapp.report;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.searchdetail.content.view.QSearchMiniAppDetailView;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.QQSearchWXAdReport;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.a;
import com.tencent.mobileqq.search.util.af;
import com.tencent.mobileqq.search.util.n;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService;
import com.tencent.qqnt.kernel.nativeinterface.IWxSearchReportCallback;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import com.tencent.qqnt.kernel.nativeinterface.UfsWxaSearchCommParams;
import com.tencent.qqnt.kernel.nativeinterface.UfsWxaSearchReportReq;
import com.tencent.qqnt.kernel.nativeinterface.UfsWxaSearchReportResp;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt__StringsKt;
import np2.a;
import okhttp3.internal.connection.RealConnection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import qp2.SearchActionReportParam;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a2\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b\u001a\u0014\u0010\u0010\u001a\u00020\u0003*\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\t\u001a\n\u0010\u0012\u001a\u00020\u0003*\u00020\u0011\u001a\n\u0010\u0014\u001a\u00020\u0003*\u00020\u0013\u001a\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\tH\u0002\u001a\n\u0010\u0017\u001a\u00020\t*\u00020\t\u001a\f\u0010\u0019\u001a\u0004\u0018\u00010\u0018*\u00020\u0000\u001a\n\u0010\u001b\u001a\u00020\u001a*\u00020\u0000\u001a\f\u0010\u001d\u001a\u0004\u0018\u00010\u001c*\u00020\u0000\u001a\f\u0010\u001e\u001a\u0004\u0018\u00010\u0000*\u00020\u0000\u001a\u0012\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u001f*\u00020\u0000\u001a\f\u0010!\u001a\u0004\u0018\u00010\t*\u00020\u0000\u001a\f\u0010\"\u001a\u0004\u0018\u00010\t*\u00020\u0000\u001a\f\u0010#\u001a\u0004\u0018\u00010\t*\u00020\u0000\u001a\n\u0010$\u001a\u00020\u001a*\u00020\u001a\u001a\f\u0010&\u001a\u0004\u0018\u00010\u001c*\u00020%\u001a\n\u0010(\u001a\u00020\u000b*\u00020'\u001a\n\u0010)\u001a\u00020\t*\u00020'\u001a\n\u0010*\u001a\u00020\t*\u00020'\u001a\f\u0010,\u001a\u0004\u0018\u00010\u0001*\u00020+\u001a\u001c\u0010.\u001a\u0004\u0018\u00010\u000e*\u00020+2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u001a\u001aL\u00105\u001a\u00020\u000e*\u00020\u001c2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u001a\u001aL\u0010=\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u00107\u001a\u00020626\u0010<\u001a2\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u000308\u001a\u001e\u0010@\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t\u001a\n\u0010A\u001a\u00020\u001a*\u00020\u001a\u001a\n\u0010B\u001a\u00020\t*\u00020\t\u001a\u0012\u0010D\u001a\u0004\u0018\u00010%*\b\u0012\u0004\u0012\u00020C0\u001f\u00a8\u0006E"}, d2 = {"Landroid/view/View;", "Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/a;", "params", "", "I", "G", "Landroid/view/MotionEvent;", "clickEvent", "parentView", "", "clickId", "Lnp2/b;", "componentInfo", "E", "Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/b;", "from", "K", "Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/k;", "M", "Lqp2/e;", BdhLogUtil.LogTag.Tag_Conn, "reqJson", "O", tl.h.F, "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;", "o", "", "v", "Lqp2/a;", "j", "p", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "u", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/b;", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", "l", "r", "t", "Lcom/tencent/mobileqq/search/searchdetail/content/view/QSearchMiniAppDetailView;", "i", "position", "w", "keyword", QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "tabMask", "appType", "pageNum", "sessionId", HippyTKDListViewAdapter.X, "", "result", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "event", "listener", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "parentType", "perSearchId", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.LATITUDE_SOUTH, "B", "Lcom/tencent/mobileqq/search/searchdetail/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqsearch-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class j {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/wxminapp/report/j$a", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "d", "Z", "isDown", "()Z", "setDown", "(Z)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isDown;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function2<View, MotionEvent, Unit> f284426e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f284427f;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function2<? super View, ? super MotionEvent, Unit> function2, boolean z16) {
            this.f284426e = function2;
            this.f284427f = z16;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@NotNull View v3, @NotNull MotionEvent event) {
            Intrinsics.checkNotNullParameter(v3, "v");
            Intrinsics.checkNotNullParameter(event, "event");
            int action = event.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 3) {
                        this.isDown = false;
                    }
                } else {
                    if (this.isDown && !FastClickUtils.isFastDoubleClick("OnTouchClickListener")) {
                        this.f284426e.invoke(v3, event);
                    }
                    this.isDown = false;
                }
            } else {
                this.isDown = true;
            }
            return this.f284427f;
        }
    }

    public static final int A(int i3) {
        if (i3 != 2 && i3 != 34) {
            return 0;
        }
        return 1;
    }

    @NotNull
    public static final String B(@NotNull String str) {
        boolean z16;
        List split$default;
        Object orNull;
        Intrinsics.checkNotNullParameter(str, "<this>");
        boolean z17 = false;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{":"}, false, 0, 6, (Object) null);
            orNull = CollectionsKt___CollectionsKt.getOrNull(split$default, 1);
            String str2 = (String) orNull;
            if (str2 == null || str2.length() == 0) {
                z17 = true;
            }
            if (z17) {
                return "";
            }
            return str2;
        }
        return "";
    }

    public static final void C(@NotNull final SearchActionReportParam searchActionReportParam) {
        Intrinsics.checkNotNullParameter(searchActionReportParam, "<this>");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.c
            @Override // java.lang.Runnable
            public final void run() {
                j.D(SearchActionReportParam.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(SearchActionReportParam this_reportAction) {
        Intrinsics.checkNotNullParameter(this_reportAction, "$this_reportAction");
        String c16 = op2.b.c(this_reportAction.getQuery(), "UTF-8", null);
        Intrinsics.checkNotNullExpressionValue(c16, "urlEncode(query, \"UTF-8\", null)");
        this_reportAction.f(c16);
        String e16 = op2.a.e(this_reportAction, "{}");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.mo162put(new JSONObject(e16));
        Unit unit = Unit.INSTANCE;
        jSONObject.put("item_report_list", jSONArray);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026  })\n        }.toString()");
        O(jSONObject2);
    }

    public static final void E(@NotNull final View view, @NotNull final MotionEvent clickEvent, @NotNull final View parentView, @NotNull final AdReportParam params, @NotNull final String clickId, @NotNull final np2.b componentInfo) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(clickEvent, "clickEvent");
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(clickId, "clickId");
        Intrinsics.checkNotNullParameter(componentInfo, "componentInfo");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.i
            @Override // java.lang.Runnable
            public final void run() {
                j.F(clickEvent, view, params, clickId, componentInfo, parentView);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(MotionEvent clickEvent, View this_reportAdClick, AdReportParam params, String clickId, np2.b componentInfo, View parentView) {
        long j3;
        Intrinsics.checkNotNullParameter(clickEvent, "$clickEvent");
        Intrinsics.checkNotNullParameter(this_reportAdClick, "$this_reportAdClick");
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(clickId, "$clickId");
        Intrinsics.checkNotNullParameter(componentInfo, "$componentInfo");
        Intrinsics.checkNotNullParameter(parentView, "$parentView");
        int floor = (int) Math.floor(clickEvent.getRawX());
        int floor2 = (int) Math.floor(clickEvent.getRawY());
        QQSearchWXAdReport.b bVar = new QQSearchWXAdReport.b();
        bVar.f284370a = params.getKeyword();
        a.C10860a c10860a = new a.C10860a();
        c10860a.f420655a = params.getExtBackComm();
        c10860a.f420656b = params.getSearchAdExtraData();
        bVar.f284371b = np2.a.a(c10860a);
        bVar.f284372c = params.getBoxPos() + 1;
        bVar.f284369f = clickId;
        bVar.f284368e = componentInfo;
        a.C8543a c8543a = new a.C8543a(this_reportAdClick.getContext());
        c8543a.adWidth = this_reportAdClick.getWidth();
        c8543a.adHeight = this_reportAdClick.getHeight();
        Long startSearchTimestamp = params.getStartSearchTimestamp();
        if (startSearchTimestamp != null) {
            j3 = startSearchTimestamp.longValue();
        } else {
            j3 = 0;
        }
        c8543a.searchTimestamp = j3;
        c8543a.resultNum = params.getResultNum();
        c8543a.inputManually = params.getInputManually();
        c8543a.adPositionOnPage = params.getAdPositionOnPage();
        c8543a.queryResultPage = params.getQueryResultPage();
        c8543a.scrollTop = 0;
        c8543a.screenX = floor;
        c8543a.screenY = floor2;
        int[] iArr = {0, 0};
        parentView.getLocationOnScreen(iArr);
        c8543a.posX = floor - iArr[0];
        c8543a.posY = floor2 - iArr[1];
        bVar.f284367d = c8543a;
        if (!bVar.g()) {
            af afVar = af.f284993a;
            QLog.e("QS.SearchReportExt", 1, "reportAdClick failed", (Throwable) null);
            return;
        }
        QQSearchWXAdReport.d(this_reportAdClick.getContext(), bVar);
    }

    public static final void G(@NotNull final View view, @NotNull final AdReportParam params) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(params, "params");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.g
            @Override // java.lang.Runnable
            public final void run() {
                j.H(view, params);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(View this_reportAdImpression, AdReportParam params) {
        long j3;
        Intrinsics.checkNotNullParameter(this_reportAdImpression, "$this_reportAdImpression");
        Intrinsics.checkNotNullParameter(params, "$params");
        QQSearchWXAdReport.d dVar = new QQSearchWXAdReport.d();
        dVar.f284370a = params.getKeyword();
        a.C10860a c10860a = new a.C10860a();
        c10860a.f420655a = params.getExtBackComm();
        c10860a.f420656b = params.getSearchAdExtraData();
        dVar.f284371b = np2.a.a(c10860a);
        dVar.f284372c = params.getBoxPos() + 1;
        a.c cVar = new a.c(this_reportAdImpression.getContext());
        cVar.adWidth = this_reportAdImpression.getWidth();
        cVar.adHeight = this_reportAdImpression.getHeight();
        Long startSearchTimestamp = params.getStartSearchTimestamp();
        if (startSearchTimestamp != null) {
            j3 = startSearchTimestamp.longValue();
        } else {
            j3 = 0;
        }
        cVar.searchTimestamp = j3;
        cVar.resultNum = params.getResultNum();
        cVar.inputManually = params.getInputManually();
        cVar.adPositionOnPage = params.getAdPositionOnPage();
        cVar.queryResultPage = params.getQueryResultPage();
        cVar.scrollTop = 0;
        dVar.f284373d = cVar;
        if (!dVar.g()) {
            af afVar = af.f284993a;
            QLog.e("QS.SearchReportExt", 1, "reportAdImpression failed", (Throwable) null);
            return;
        }
        QQSearchWXAdReport.e(this_reportAdImpression.getContext(), dVar);
    }

    public static final void I(@NotNull final View view, @NotNull final AdReportParam params) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(params, "params");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.d
            @Override // java.lang.Runnable
            public final void run() {
                j.J(view, params);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(View this_reportAdOriginalImpression, AdReportParam params) {
        long j3;
        Intrinsics.checkNotNullParameter(this_reportAdOriginalImpression, "$this_reportAdOriginalImpression");
        Intrinsics.checkNotNullParameter(params, "$params");
        QQSearchWXAdReport.e eVar = new QQSearchWXAdReport.e();
        eVar.f284370a = params.getKeyword();
        a.C10860a c10860a = new a.C10860a();
        c10860a.f420655a = params.getExtBackComm();
        c10860a.f420656b = params.getSearchAdExtraData();
        eVar.f284371b = np2.a.a(c10860a);
        eVar.f284372c = params.getBoxPos() + 1;
        a.d dVar = new a.d(this_reportAdOriginalImpression.getContext());
        dVar.adWidth = this_reportAdOriginalImpression.getWidth();
        dVar.adHeight = this_reportAdOriginalImpression.getHeight();
        Long startSearchTimestamp = params.getStartSearchTimestamp();
        if (startSearchTimestamp != null) {
            j3 = startSearchTimestamp.longValue();
        } else {
            j3 = 0;
        }
        dVar.searchTimestamp = j3;
        dVar.resultNum = params.getResultNum();
        dVar.inputManually = params.getInputManually();
        dVar.adPositionOnPage = params.getAdPositionOnPage();
        dVar.queryResultPage = params.getQueryResultPage();
        dVar.scrollTop = 0;
        eVar.f284374d = dVar;
        if (!eVar.g()) {
            af afVar = af.f284993a;
            QLog.e("QS.SearchReportExt", 1, "reportAdOriginalImpression failed", (Throwable) null);
            return;
        }
        QQSearchWXAdReport.f(this_reportAdOriginalImpression.getContext(), eVar);
    }

    public static final void K(@NotNull final SearchNormalReportParam searchNormalReportParam, @Nullable final String str) {
        Intrinsics.checkNotNullParameter(searchNormalReportParam, "<this>");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.e
            @Override // java.lang.Runnable
            public final void run() {
                j.L(SearchNormalReportParam.this, str);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(SearchNormalReportParam this_reportNormal, String str) {
        Intrinsics.checkNotNullParameter(this_reportNormal, "$this_reportNormal");
        String c16 = op2.b.c(this_reportNormal.getQuery(), "UTF-8", null);
        Intrinsics.checkNotNullExpressionValue(c16, "urlEncode(query, \"UTF-8\", null)");
        this_reportNormal.n(c16);
        this_reportNormal.l(this_reportNormal.getPageNumber() + 1);
        String e16 = op2.a.e(this_reportNormal, "{}");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.mo162put(new JSONObject(e16));
        Unit unit = Unit.INSTANCE;
        jSONObject.put("item_report_list", jSONArray);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026  })\n        }.toString()");
        O(jSONObject2);
    }

    public static final void M(@NotNull final SearchStayReportParam searchStayReportParam) {
        Intrinsics.checkNotNullParameter(searchStayReportParam, "<this>");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.f
            @Override // java.lang.Runnable
            public final void run() {
                j.N(SearchStayReportParam.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(SearchStayReportParam this_reportStay) {
        Intrinsics.checkNotNullParameter(this_reportStay, "$this_reportStay");
        String c16 = op2.b.c(this_reportStay.getQuery(), "UTF-8", null);
        Intrinsics.checkNotNullExpressionValue(c16, "urlEncode(query, \"UTF-8\", null)");
        this_reportStay.e(c16);
        String e16 = op2.a.e(this_reportStay, "{}");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("item_staytime_report", new JSONObject(e16));
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026nt))\n        }.toString()");
        O(jSONObject2);
    }

    private static final void O(final String str) {
        UfsWxaSearchReportReq ufsWxaSearchReportReq = new UfsWxaSearchReportReq();
        UfsWxaSearchCommParams ufsWxaSearchCommParams = ufsWxaSearchReportReq.commParams;
        String str2 = null;
        if (ufsWxaSearchCommParams != null) {
            try {
                ufsWxaSearchCommParams.requestId = UUID.randomUUID().toString();
            } catch (Throwable th5) {
                af afVar = af.f284993a;
                QLog.e("QS.SearchReportExt", 1, "reportNormal requestId failed, " + th5, (Throwable) null);
            }
        }
        ufsWxaSearchReportReq.reqActionType = 1;
        ufsWxaSearchReportReq.reqJson = str;
        com.tencent.mobileqq.wxmini.api.data.d bindingWeChatUserInfo = ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).getBindingWeChatUserInfo();
        if (bindingWeChatUserInfo != null) {
            str2 = bindingWeChatUserInfo.h();
        }
        ufsWxaSearchReportReq.wxFuncToken = str2;
        IKernelUnifySearchService c16 = n.c();
        if (c16 != null) {
            c16.wxSearchReport(ufsWxaSearchReportReq, new IWxSearchReportCallback() { // from class: com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.IWxSearchReportCallback
                public final void onResult(int i3, String str3, UfsWxaSearchReportResp ufsWxaSearchReportResp) {
                    j.P(str, i3, str3, ufsWxaSearchReportResp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(String reqJson, int i3, String str, UfsWxaSearchReportResp ufsWxaSearchReportResp) {
        Intrinsics.checkNotNullParameter(reqJson, "$reqJson");
        if (i3 != 0) {
            af afVar = af.f284993a;
            QLog.e("QS.SearchReportExt", 1, "sendReportReq code=" + i3 + " msg=" + str + ", reqJson=" + reqJson, (Throwable) null);
        }
    }

    public static final void Q(@NotNull View view, boolean z16, @NotNull Function2<? super View, ? super MotionEvent, Unit> listener) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(listener, "listener");
        view.setOnTouchListener(new a(listener, z16));
    }

    public static /* synthetic */ void R(View view, boolean z16, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        Q(view, z16, function2);
    }

    public static final int S(int i3) {
        if (i3 == 1) {
            return 0;
        }
        if (i3 != 7) {
            if (i3 != 11) {
                return 0;
            }
            return 524288;
        }
        return 64;
    }

    @NotNull
    public static final String h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str + "-" + System.currentTimeMillis() + "-" + Random.INSTANCE.nextLong(1000000000L, RealConnection.IDLE_CONNECTION_HEALTHY_NS);
    }

    @Nullable
    public static final AdReportParam i(@NotNull QSearchMiniAppDetailView qSearchMiniAppDetailView) {
        com.tencent.mobileqq.search.searchdetail.content.wxminapp.b bVar;
        qp2.a backEndReportInfo;
        String str;
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(qSearchMiniAppDetailView, "<this>");
        com.tencent.mobileqq.search.searchdetail.content.template.model.a dataModel = qSearchMiniAppDetailView.getDataModel();
        Long l3 = null;
        if (dataModel instanceof com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) {
            bVar = (com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) dataModel;
        } else {
            bVar = null;
        }
        if (bVar == null || (backEndReportInfo = bVar.getBackEndReportInfo()) == null) {
            return null;
        }
        int withoutTitlePosition = qSearchMiniAppDetailView.getWithoutTitlePosition();
        String extBackComm = backEndReportInfo.getExtBackComm();
        String searchAdExtraData = backEndReportInfo.getSearchAdExtraData();
        String searchId = backEndReportInfo.getSearchId();
        com.tencent.mobileqq.search.searchdetail.d pageIOC = qSearchMiniAppDetailView.getPageIOC();
        if (pageIOC == null || (str = pageIOC.getKeyword()) == null) {
            str = "";
        }
        String str2 = str;
        com.tencent.mobileqq.search.searchdetail.d pageIOC2 = qSearchMiniAppDetailView.getPageIOC();
        if (pageIOC2 != null) {
            l3 = Long.valueOf(pageIOC2.getStartSearchTimeStamps());
        }
        Long l16 = l3;
        com.tencent.mobileqq.search.searchdetail.d pageIOC3 = qSearchMiniAppDetailView.getPageIOC();
        if (pageIOC3 != null) {
            i3 = pageIOC3.getAllItemNums();
        } else {
            i3 = 0;
        }
        int i17 = i3;
        int pageNum = bVar.getPageNum();
        int withoutTitlePosition2 = qSearchMiniAppDetailView.getWithoutTitlePosition();
        com.tencent.mobileqq.search.searchdetail.d pageIOC4 = qSearchMiniAppDetailView.getPageIOC();
        if (pageIOC4 != null) {
            i16 = A(pageIOC4.getQuerySource());
        } else {
            i16 = 2;
        }
        return new AdReportParam(withoutTitlePosition, extBackComm, searchAdExtraData, searchId, str2, l16, i17, pageNum, withoutTitlePosition2, i16);
    }

    @Nullable
    public static final qp2.a j(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag(R.id.f11954775);
        if (tag instanceof qp2.a) {
            return (qp2.a) tag;
        }
        return null;
    }

    @Nullable
    public static final qp2.a k(@NotNull com.tencent.mobileqq.search.searchdetail.content.wxminapp.b bVar) {
        String str;
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        SearchReportInfo searchReportInfo = bVar.getMiniAppDetail().backendReportInfo;
        if (searchReportInfo != null) {
            str = searchReportInfo.reportInfo;
        } else {
            str = null;
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return qp2.a.INSTANCE.a(str);
    }

    @NotNull
    public static final np2.b l(@NotNull SearchReportInfo searchReportInfo) {
        Intrinsics.checkNotNullParameter(searchReportInfo, "<this>");
        np2.b bVar = new np2.b();
        if (TextUtils.isEmpty(searchReportInfo.reportInfo)) {
            return bVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(searchReportInfo.reportInfo);
            bVar.f420657a = jSONObject.optString("componentId", "");
            bVar.f420658b = jSONObject.optLong("componentType", WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
        } catch (Exception unused) {
        }
        return bVar;
    }

    @Nullable
    public static final com.tencent.mobileqq.search.searchdetail.content.wxminapp.b m(@NotNull List<? extends com.tencent.mobileqq.search.searchdetail.c> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((com.tencent.mobileqq.search.searchdetail.c) obj) instanceof com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        com.tencent.mobileqq.search.searchdetail.c cVar = (com.tencent.mobileqq.search.searchdetail.c) obj;
        if (!(cVar instanceof com.tencent.mobileqq.search.searchdetail.content.wxminapp.b)) {
            return null;
        }
        return (com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) cVar;
    }

    @Nullable
    public static final List<View> n(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag(R.id.f1194876z);
        if (tag instanceof List) {
            return (List) tag;
        }
        return null;
    }

    @Nullable
    public static final com.tencent.mobileqq.search.searchdetail.content.template.model.a o(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag(R.id.f1194776y);
        if (tag instanceof com.tencent.mobileqq.search.searchdetail.content.template.model.a) {
            return (com.tencent.mobileqq.search.searchdetail.content.template.model.a) tag;
        }
        return null;
    }

    @Nullable
    public static final View p(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag(R.id.f11949770);
        if (tag instanceof View) {
            return (View) tag;
        }
        return null;
    }

    @Nullable
    public static final String q(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag(R.id.f11950771);
        if (tag instanceof String) {
            return (String) tag;
        }
        return null;
    }

    @NotNull
    public static final String r(@NotNull SearchReportInfo searchReportInfo) {
        Intrinsics.checkNotNullParameter(searchReportInfo, "<this>");
        try {
            String optString = new JSONObject(searchReportInfo.reportInfo).optString("itemId", "");
            Intrinsics.checkNotNullExpressionValue(optString, "{\n        val reportJson\u2026tring(\"itemId\", \"\")\n    }");
            return optString;
        } catch (Exception unused) {
            return "";
        }
    }

    @Nullable
    public static final String s(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag(R.id.f11951772);
        if (tag instanceof String) {
            return (String) tag;
        }
        return null;
    }

    @NotNull
    public static final String t(@NotNull SearchReportInfo searchReportInfo) {
        Intrinsics.checkNotNullParameter(searchReportInfo, "<this>");
        try {
            String optString = new JSONObject(searchReportInfo.reportInfo).optString("itemInfo", "");
            Intrinsics.checkNotNullExpressionValue(optString, "{\n        val reportJson\u2026ing(\"itemInfo\", \"\")\n    }");
            return optString;
        } catch (Exception unused) {
            return "";
        }
    }

    @Nullable
    public static final String u(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag(R.id.f11952773);
        if (tag instanceof String) {
            return (String) tag;
        }
        return null;
    }

    public static final int v(@NotNull View view) {
        Integer num;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag(R.id.f11953774);
        if (tag instanceof Integer) {
            num = (Integer) tag;
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Nullable
    public static final SearchNormalReportParam w(@NotNull QSearchMiniAppDetailView qSearchMiniAppDetailView, @NotNull String clickId, int i3) {
        com.tencent.mobileqq.search.searchdetail.content.wxminapp.b bVar;
        qp2.a backEndReportInfo;
        String str;
        int i16;
        String str2;
        String miniAppSessionId;
        String keyword;
        Intrinsics.checkNotNullParameter(qSearchMiniAppDetailView, "<this>");
        Intrinsics.checkNotNullParameter(clickId, "clickId");
        com.tencent.mobileqq.search.searchdetail.content.template.model.a dataModel = qSearchMiniAppDetailView.getDataModel();
        if (dataModel instanceof com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) {
            bVar = (com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) dataModel;
        } else {
            bVar = null;
        }
        if (bVar == null || (backEndReportInfo = bVar.getBackEndReportInfo()) == null) {
            return null;
        }
        com.tencent.mobileqq.search.searchdetail.d pageIOC = qSearchMiniAppDetailView.getPageIOC();
        if (pageIOC == null || (keyword = pageIOC.getKeyword()) == null) {
            str = "";
        } else {
            str = keyword;
        }
        com.tencent.mobileqq.search.searchdetail.d pageIOC2 = qSearchMiniAppDetailView.getPageIOC();
        int i17 = 0;
        if (pageIOC2 != null) {
            i16 = pageIOC2.getQuerySource();
        } else {
            i16 = 0;
        }
        com.tencent.mobileqq.search.searchdetail.d pageIOC3 = qSearchMiniAppDetailView.getPageIOC();
        if (pageIOC3 != null) {
            i17 = (int) pageIOC3.getTabMask();
        }
        int i18 = i17;
        int i19 = bVar.getMiniAppDetail().miniAppType;
        int pageNum = bVar.getPageNum();
        com.tencent.mobileqq.search.searchdetail.d pageIOC4 = qSearchMiniAppDetailView.getPageIOC();
        if (pageIOC4 == null || (miniAppSessionId = pageIOC4.getMiniAppSessionId()) == null) {
            str2 = "";
        } else {
            str2 = miniAppSessionId;
        }
        return x(backEndReportInfo, str, i16, i18, i19, pageNum, str2, clickId, i3);
    }

    @NotNull
    public static final SearchNormalReportParam x(@NotNull qp2.a aVar, @NotNull String keyword, int i3, int i16, int i17, int i18, @NotNull String sessionId, @NotNull String clickId, int i19) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(clickId, "clickId");
        SearchNormalReportParam searchNormalReportParam = new SearchNormalReportParam(null, null, 0, null, 0, 0, 0, null, null, null, null, 0, 0, null, 0, null, null, null, null, null, 1048575, null);
        searchNormalReportParam.n(keyword);
        searchNormalReportParam.r(aVar.getSearchId());
        searchNormalReportParam.m(aVar.getParentSearchId());
        searchNormalReportParam.q(qp2.f.b(i3));
        searchNormalReportParam.o(S(i16));
        searchNormalReportParam.g(aVar.getBusinessType());
        searchNormalReportParam.t(aVar.getCooperation.qqcircle.report.QCircleLpReportDc010001.KEY_SUBTYPE java.lang.String());
        searchNormalReportParam.f(aVar.getBoxInfo() + ":" + (i19 + 1));
        searchNormalReportParam.i(aVar.getDocInfo());
        searchNormalReportParam.p(aVar.getCom.tencent.mobileqq.vas.api.RemoteProxy.KEY_RESULT_TYPE java.lang.String());
        searchNormalReportParam.h(clickId);
        searchNormalReportParam.l(i18);
        searchNormalReportParam.s(sessionId);
        searchNormalReportParam.u(aVar.getSvrBoxExtInfo());
        searchNormalReportParam.v(aVar.getSvrDocExtInfo());
        aVar.E(aVar.getSvrItemExtInfo());
        return searchNormalReportParam;
    }

    public static /* synthetic */ SearchNormalReportParam y(qp2.a aVar, String str, int i3, int i16, int i17, int i18, String str2, String str3, int i19, int i26, Object obj) {
        String str4;
        if ((i26 & 64) != 0) {
            str4 = "";
        } else {
            str4 = str3;
        }
        return x(aVar, str, i3, i16, i17, i18, str2, str4, i19);
    }

    @NotNull
    public static final String z(int i3, @NotNull String perSearchId, @NotNull String keyword) {
        Intrinsics.checkNotNullParameter(perSearchId, "perSearchId");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        String str = i3 + ":" + URLEncoder.encode(perSearchId) + ":";
        if (i3 != 1 && i3 != 13 && i3 != 56 && i3 != 7 && i3 != 8) {
            return str;
        }
        return str + URLEncoder.encode(keyword);
    }
}

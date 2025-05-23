package com.tencent.mobileqq.zplan.card.impl.view.smallhome.dialog;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.adapter.SmallHomeVisitCommonAdapter;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.data.b;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.dialog.SmallHomeDataPageView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.view.pull2refresh.androidx.XPullToRefreshViewV2;
import com.tencent.state.report.SquareReportConst;
import fi3.j;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import tl.h;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002&*\u0018\u0000 22\u00020\u0001:\u00013B\u0017\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\"R\u0016\u0010%\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/dialog/SmallHomeDataPageView;", "Landroid/widget/RelativeLayout;", "", DomainData.DOMAIN_NAME, "o", "k", "i", "t", "r", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "type", "setPageType", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "j", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "d", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "Lfi3/j;", "e", "Lfi3/j;", "viewBinding", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/data/b;", "f", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/data/b;", "dataHelper", h.F, "I", "pageType", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/adapter/SmallHomeVisitCommonAdapter;", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/adapter/SmallHomeVisitCommonAdapter;", "adapter", "Z", "isRefreshing", "com/tencent/mobileqq/zplan/card/impl/view/smallhome/dialog/SmallHomeDataPageView$c", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/dialog/SmallHomeDataPageView$c;", "loadMoreCallback", "com/tencent/mobileqq/zplan/card/impl/view/smallhome/dialog/SmallHomeDataPageView$d", "D", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/dialog/SmallHomeDataPageView$d;", "refreshCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;)V", "E", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SmallHomeDataPageView extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final c loadMoreCallback;

    /* renamed from: D, reason: from kotlin metadata */
    private final d refreshCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ZplanViewReportHelper reportHelper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final j viewBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final b dataHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int pageType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final SmallHomeVisitCommonAdapter adapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isRefreshing;

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/smallhome/dialog/SmallHomeDataPageView$a", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            outRect.top = i.b(20);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/smallhome/dialog/SmallHomeDataPageView$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lzu4/h;", "result", "", "d", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<zu4.h> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(SmallHomeDataPageView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.viewBinding.f399291h.F(false, true);
            this$0.isRefreshing = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(SmallHomeDataPageView this$0, zu4.h result) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(result, "$result");
            SmallHomeVisitCommonAdapter smallHomeVisitCommonAdapter = this$0.adapter;
            pv4.d[] dVarArr = result.f453439a;
            Intrinsics.checkNotNullExpressionValue(dVarArr, "result.wordList");
            smallHomeVisitCommonAdapter.i0(dVarArr);
            this$0.viewBinding.f399291h.F(true, !result.f453440b);
            this$0.isRefreshing = false;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(final zu4.h result) {
            Intrinsics.checkNotNullParameter(result, "result");
            final SmallHomeDataPageView smallHomeDataPageView = SmallHomeDataPageView.this;
            smallHomeDataPageView.post(new Runnable() { // from class: wf3.d
                @Override // java.lang.Runnable
                public final void run() {
                    SmallHomeDataPageView.c.e(SmallHomeDataPageView.this, result);
                }
            });
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            final SmallHomeDataPageView smallHomeDataPageView = SmallHomeDataPageView.this;
            smallHomeDataPageView.post(new Runnable() { // from class: wf3.c
                @Override // java.lang.Runnable
                public final void run() {
                    SmallHomeDataPageView.c.c(SmallHomeDataPageView.this);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/smallhome/dialog/SmallHomeDataPageView$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lzu4/h;", "result", "", "d", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.api.e<zu4.h> {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(SmallHomeDataPageView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.s();
            this$0.viewBinding.f399291h.s(false);
            this$0.isRefreshing = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final void e(SmallHomeDataPageView this$0, zu4.h result) {
            boolean z16;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(result, "$result");
            this$0.adapter.clearData();
            pv4.d[] dVarArr = result.f453439a;
            if (dVarArr != null) {
                if (!(dVarArr.length == 0)) {
                    z16 = false;
                    if (!z16) {
                        this$0.r();
                        return;
                    }
                    this$0.q();
                    this$0.adapter.clearData();
                    SmallHomeVisitCommonAdapter smallHomeVisitCommonAdapter = this$0.adapter;
                    pv4.d[] dVarArr2 = result.f453439a;
                    Intrinsics.checkNotNullExpressionValue(dVarArr2, "result.wordList");
                    smallHomeVisitCommonAdapter.i0(dVarArr2);
                    this$0.viewBinding.f399291h.s(true);
                    this$0.viewBinding.f399291h.F(true, !result.f453440b);
                    this$0.isRefreshing = false;
                    return;
                }
            }
            z16 = true;
            if (!z16) {
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(final zu4.h result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("SmallHomeDataPageView", 1, "refreshPage onResultSuccess");
            final SmallHomeDataPageView smallHomeDataPageView = SmallHomeDataPageView.this;
            smallHomeDataPageView.post(new Runnable() { // from class: wf3.f
                @Override // java.lang.Runnable
                public final void run() {
                    SmallHomeDataPageView.d.e(SmallHomeDataPageView.this, result);
                }
            });
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("SmallHomeDataPageView", 1, "refreshPage onResultFailure");
            final SmallHomeDataPageView smallHomeDataPageView = SmallHomeDataPageView.this;
            smallHomeDataPageView.post(new Runnable() { // from class: wf3.e
                @Override // java.lang.Runnable
                public final void run() {
                    SmallHomeDataPageView.d.c(SmallHomeDataPageView.this);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmallHomeDataPageView(Context context, ZplanViewReportHelper reportHelper) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reportHelper, "reportHelper");
        this.reportHelper = reportHelper;
        j f16 = j.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.viewBinding = f16;
        this.dataHelper = new b();
        this.pageType = 15;
        SmallHomeVisitCommonAdapter smallHomeVisitCommonAdapter = new SmallHomeVisitCommonAdapter(context, reportHelper);
        this.adapter = smallHomeVisitCommonAdapter;
        this.loadMoreCallback = new c();
        this.refreshCallback = new d();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(1);
        f16.f399291h.E().setAdapter(smallHomeVisitCommonAdapter);
        f16.f399291h.E().setLayoutManager(linearLayoutManager);
        f16.f399291h.G(true);
        f16.f399291h.setPullRefreshMode(1);
        f16.f399291h.E().addItemDecoration(new a());
    }

    private final void i() {
        String replace$default;
        replace$default = StringsKt__StringsJVMKt.replace$default("mqqapi://zplan/enterAvatarScene?src_type=app&version=1.0&subReferer=${subReferer}&sceneType=7&pageData={\"needDownload\":true,\"mapId\":200001,\"openDetailNotReady\":true}&sceneData={\"SceneType\":\"1\"}", "${subReferer}", "smallhome_card", false, 4, (Object) null);
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iZPlanApi.launchScheme(context, replace$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        QLog.i("SmallHomeDataPageView", 1, FeedManager.LOAD_MORE);
        if (this.pageType == 15) {
            this.dataHelper.j(this.loadMoreCallback);
        } else {
            this.dataHelper.i(this.loadMoreCallback);
        }
        this.isRefreshing = true;
    }

    private final void n() {
        Map<String, ? extends Object> mutableMapOf;
        ZplanViewReportHelper zplanViewReportHelper = this.reportHelper;
        TextView textView = this.viewBinding.f399285b;
        Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.btnBottom");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ZootopiaSource.INSTANCE.g()));
        zplanViewReportHelper.e(textView, "em_zplan_xw_jump", mutableMapOf);
    }

    private final void o() {
        Map mutableMapOf;
        ZplanViewReportHelper zplanViewReportHelper = this.reportHelper;
        TextView textView = this.viewBinding.f399285b;
        Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.btnBottom");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ZootopiaSource.INSTANCE.g()));
        zplanViewReportHelper.g(textView, "em_zplan_xw_jump", (r16 & 4) != 0 ? null : mutableMapOf, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(SmallHomeDataPageView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i();
        this$0.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        this.viewBinding.f399291h.setVisibility(0);
        this.viewBinding.f399285b.setVisibility(this.pageType == 15 ? 8 : 0);
        this.viewBinding.f399289f.setVisibility(8);
        this.viewBinding.f399288e.setVisibility(8);
        this.viewBinding.f399290g.setVisibility(8);
        this.viewBinding.f399290g.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        String str;
        this.viewBinding.f399291h.setVisibility(8);
        this.viewBinding.f399285b.setVisibility(8);
        this.viewBinding.f399289f.setVisibility(8);
        this.viewBinding.f399288e.setVisibility(0);
        TextView textView = this.viewBinding.f399287d;
        if (this.pageType == 15) {
            str = "\u8fd8\u6ca1\u6709\u4eba\u70b9\u8d5e\u54e6\uff0c\u56db\u5904\u901b\u901b\u8ba4\u8bc6\u66f4\u591a\u670b\u53cb\u5427";
        } else {
            str = "\u8fd8\u6ca1\u6709\u4eba\u7559\u8a00\u54e6\uff0c\u56db\u5904\u901b\u901b\u8ba4\u8bc6\u66f4\u591a\u670b\u53cb\u5427";
        }
        textView.setText(str);
        this.viewBinding.f399290g.setVisibility(8);
        this.viewBinding.f399290g.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        this.viewBinding.f399291h.setVisibility(8);
        this.viewBinding.f399285b.setVisibility(8);
        this.viewBinding.f399289f.setVisibility(0);
        this.viewBinding.f399288e.setVisibility(8);
        this.viewBinding.f399290g.setVisibility(8);
        this.viewBinding.f399290g.g();
    }

    private final void t() {
        this.viewBinding.f399291h.setVisibility(8);
        this.viewBinding.f399285b.setVisibility(8);
        this.viewBinding.f399289f.setVisibility(8);
        this.viewBinding.f399288e.setVisibility(8);
        this.viewBinding.f399290g.setVisibility(0);
        this.viewBinding.f399290g.f();
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsRefreshing() {
        return this.isRefreshing;
    }

    public final void l() {
        m();
        t();
    }

    public final void m() {
        QLog.i("SmallHomeDataPageView", 1, "refreshPage");
        if (this.pageType == 15) {
            this.dataHelper.p(this.refreshCallback);
        } else {
            this.dataHelper.o(this.refreshCallback);
        }
        this.isRefreshing = true;
    }

    public final void setPageType(int type) {
        QLog.i("SmallHomeDataPageView", 1, "setPageType type:" + type);
        this.pageType = type;
        this.viewBinding.f399285b.setVisibility(type == 15 ? 8 : 0);
        if (this.viewBinding.f399285b.getVisibility() == 0) {
            o();
        }
        this.viewBinding.f399285b.setOnClickListener(new View.OnClickListener() { // from class: wf3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmallHomeDataPageView.p(SmallHomeDataPageView.this, view);
            }
        });
        this.viewBinding.f399291h.setRefreshCallback(new e());
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/smallhome/dialog/SmallHomeDataPageView$e", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/androidx/XPullToRefreshViewV2$c;", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/androidx/XPullToRefreshViewV2;", "recyclerView", "", "isMachineRefresh", "", "e", "", "reqType", "b", "endOfRefresh", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements XPullToRefreshViewV2.c {
        e() {
        }

        @Override // com.tencent.sqshow.zootopia.view.pull2refresh.androidx.XPullToRefreshViewV2.c
        public void b(XPullToRefreshViewV2 recyclerView, int reqType) {
            SmallHomeDataPageView.this.k();
        }

        @Override // com.tencent.sqshow.zootopia.view.pull2refresh.androidx.XPullToRefreshViewV2.c
        public void e(XPullToRefreshViewV2 recyclerView, boolean isMachineRefresh) {
            SmallHomeDataPageView.this.m();
        }

        @Override // com.tencent.sqshow.zootopia.view.pull2refresh.androidx.XPullToRefreshViewV2.c
        public void endOfRefresh() {
        }
    }
}

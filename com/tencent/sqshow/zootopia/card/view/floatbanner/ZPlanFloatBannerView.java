package com.tencent.sqshow.zootopia.card.view.floatbanner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.card.view.ZPlanBaseWidgetView;
import com.tencent.sqshow.zootopia.card.view.floatbanner.ZPlanFloatBannerView;
import com.tencent.sqshow.zootopia.portal.home.banner.Banner;
import com.tencent.sqshow.zootopia.portal.home.banner.indicator.Direction;
import com.tencent.sqshow.zootopia.recommend.characterV2.data.ZPlanFloatBannerData;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.bf;
import pu4.g;
import pv4.s;
import qa4.d;
import sa4.a;
import tl.h;

@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u00011\u0018\u0000 <2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001=B'\b\u0007\u0012\u0006\u00106\u001a\u000205\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107\u0012\b\b\u0002\u00109\u001a\u00020\u000f\u00a2\u0006\u0004\b:\u0010;J\u001c\u0010\n\u001a\u00020\t2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\"\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J6\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u0016j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0004`\u00172\u0006\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\b\u0010\u001f\u001a\u00020\tH\u0016R\u0014\u0010\"\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010&R\"\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u0006>"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/view/floatbanner/ZPlanFloatBannerView;", "Lcom/tencent/sqshow/zootopia/card/view/ZPlanBaseWidgetView;", "Ln74/bf;", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/b;", "", "Lcom/tencent/sqshow/zootopia/portal/home/banner/Banner;", "Lpv4/s;", "Ln84/b;", "bannerView", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "u", "r", "Landroid/view/View;", "itemView", "", "itemPos", "", "activityId", "o", "position", "id", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "g", "data", DomainData.DOMAIN_NAME, "i", ReportConstant.COSTREPORT_PREFIX, "t", "f", "I", "itemWidth", h.F, "itemHeight", "Landroidx/viewpager2/widget/MarginPageTransformer;", "Landroidx/viewpager2/widget/MarginPageTransformer;", "marginTransformer", "Lcom/tencent/sqshow/zootopia/portal/home/banner/Banner;", "banner", BdhLogUtil.LogTag.Tag_Conn, "Ln84/b;", "bannerAdapter", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "D", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "com/tencent/sqshow/zootopia/card/view/floatbanner/ZPlanFloatBannerView$c", "E", "Lcom/tencent/sqshow/zootopia/card/view/floatbanner/ZPlanFloatBannerView$c;", "bannerClickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanFloatBannerView extends ZPlanBaseWidgetView<bf, ZPlanFloatBannerData> {

    /* renamed from: C, reason: from kotlin metadata */
    private n84.b bannerAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    private final ZplanViewReportHelper reportHelper;

    /* renamed from: E, reason: from kotlin metadata */
    private final c bannerClickListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int itemWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int itemHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private MarginPageTransformer marginTransformer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Banner<s, n84.b> banner;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/card/view/floatbanner/ZPlanFloatBannerView$c", "Lqa4/d;", "Lpv4/s;", "Landroid/view/View;", "view", "data", "", "position", "", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements d<s> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f370223b;

        c(Context context) {
            this.f370223b = context;
        }

        @Override // qa4.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(View view, s data, int position) {
            String str;
            Intrinsics.checkNotNullParameter(view, "view");
            ZPlanFloatBannerView.this.h("clickBanner - " + position + " - " + (data != null ? data.f427683d : null) + " - " + (data != null ? data.f427682c : null), false);
            if (data == null || (str = data.f427682c) == null) {
                return;
            }
            Context context = this.f370223b;
            ZPlanFloatBannerView zPlanFloatBannerView = ZPlanFloatBannerView.this;
            ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(context, str);
            zPlanFloatBannerView.reportHelper.e(view, "em_zplan_activity_banner", zPlanFloatBannerView.q(position, data.f427694o));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanFloatBannerView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void m(Banner<s, n84.b> bannerView) {
        bannerView.v(new b(bannerView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(View itemView, int itemPos, String activityId) {
        this.reportHelper.g(itemView, "em_zplan_activity_banner", (r16 & 4) != 0 ? null : q(itemPos, activityId), (r16 & 8) != 0 ? true : true, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, Object> q(int position, String id5) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("zplan_elem_pos", Integer.valueOf(position));
        if (id5 == null) {
            id5 = "";
        }
        hashMap.put("zplan_act_id", id5);
        return hashMap;
    }

    private final void r() {
        List<s> b16;
        Banner<s, n84.b> banner = this.banner;
        if (banner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("banner");
            banner = null;
        }
        Context context = banner.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ImageIndicator imageIndicator = new ImageIndicator(context);
        com.tencent.sqshow.zootopia.portal.home.banner.indicator.b helper = imageIndicator.getHelper();
        helper.x(i.b(9));
        helper.s(i.b(9));
        helper.u(i.b(-1));
        helper.z(R.drawable.ifp);
        helper.B(R.drawable.ifq);
        ZPlanFloatBannerData f16 = f();
        helper.o(!((f16 == null || (b16 = f16.b()) == null || b16.size() != 1) ? false : true));
        banner.setIndicator(imageIndicator);
        banner.setIndicatorMargin(new com.tencent.sqshow.zootopia.portal.home.banner.indicator.c(0, i.b(-3), 0, 0));
        banner.setIndicatorGravity(Direction.BELOW_BANNER);
    }

    private final void u() {
        r();
        Banner<s, n84.b> banner = this.banner;
        if (banner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("banner");
            banner = null;
        }
        banner.setLayoutParams(new FrameLayout.LayoutParams(this.itemWidth, this.itemHeight));
        banner.K(this.marginTransformer);
        MarginPageTransformer marginPageTransformer = new MarginPageTransformer(0);
        this.marginTransformer = marginPageTransformer;
        banner.w(marginPageTransformer);
        ViewPager2 E = banner.E();
        E.setOffscreenPageLimit(4);
        E.setClipToPadding(false);
        E.setClipChildren(false);
        View childAt = E.getChildAt(0);
        RecyclerView recyclerView = childAt instanceof RecyclerView ? (RecyclerView) childAt : null;
        if (recyclerView != null) {
            recyclerView.setClipToPadding(false);
            recyclerView.setClipChildren(false);
        }
    }

    @Override // com.tencent.sqshow.zootopia.card.view.ZPlanBaseWidgetView
    public void g() {
        FrameLayout root = e().getRoot();
        Intrinsics.checkNotNull(root, "null cannot be cast to non-null type android.view.ViewGroup");
        root.removeAllViews();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Banner<s, n84.b> banner = new Banner<>(context);
        this.banner = banner;
        m(banner);
        FrameLayout root2 = e().getRoot();
        Intrinsics.checkNotNull(root2, "null cannot be cast to non-null type android.view.ViewGroup");
        Banner<s, n84.b> banner2 = this.banner;
        if (banner2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("banner");
            banner2 = null;
        }
        root2.addView(banner2);
    }

    @Override // com.tencent.sqshow.zootopia.card.view.ZPlanBaseWidgetView
    public String i() {
        return "ZPlanFloatBannerView";
    }

    @Override // com.tencent.sqshow.zootopia.card.view.ZPlanBaseWidgetView
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void a(ZPlanFloatBannerData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Banner<s, n84.b> banner = this.banner;
        Banner<s, n84.b> banner2 = null;
        if (banner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("banner");
            banner = null;
        }
        u();
        if (data.getTurnInterval() <= 0) {
            banner.setAutoLoop(false);
        } else {
            banner.setMLoopTime(data.getTurnInterval() * 1000);
            banner.setAutoLoop(true);
        }
        if (data.b().size() == 1) {
            banner.setAutoLoop(false);
            banner.setInfiniteLoop(false);
        } else {
            banner.setInfiniteLoop(true);
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        n84.b bVar = new n84.b(context, data.b());
        this.bannerAdapter = bVar;
        bVar.o0(this.bannerClickListener);
        Banner<s, n84.b> banner3 = this.banner;
        if (banner3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("banner");
        } else {
            banner2 = banner3;
        }
        n84.b bVar2 = this.bannerAdapter;
        Intrinsics.checkNotNull(bVar2);
        banner2.setAdapter(bVar2);
    }

    @Override // com.tencent.sqshow.zootopia.card.view.ZPlanBaseWidgetView
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public bf b() {
        bf g16 = bf.g(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        return g16;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanFloatBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void s() {
        QLog.i("ZPlanFloatBannerView", 1, "onStartAutoPlay");
        Banner<s, n84.b> banner = this.banner;
        if (banner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("banner");
            banner = null;
        }
        banner.P();
    }

    public void t() {
        QLog.i("ZPlanFloatBannerView", 1, "onStopAutoPlay");
        Banner<s, n84.b> banner = this.banner;
        if (banner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("banner");
            banner = null;
        }
        banner.Q();
    }

    public /* synthetic */ ZPlanFloatBannerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanFloatBannerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.itemWidth = getResources().getDimensionPixelSize(R.dimen.f12186s);
        this.itemHeight = getResources().getDimensionPixelSize(R.dimen.f12166q);
        this.reportHelper = new ZplanViewReportHelper();
        this.bannerClickListener = new c(context);
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/sqshow/zootopia/card/view/floatbanner/ZPlanFloatBannerView$b", "Lcom/tencent/sqshow/zootopia/portal/home/banner/c;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "", "isFakeEdgeItem", "c", "state", "onPageScrollStateChanged", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.sqshow.zootopia.portal.home.banner.c {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Banner<s, n84.b> f370221e;

        b(Banner<s, n84.b> banner) {
            this.f370221e = banner;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(RecyclerView recyclerView, int i3, ZPlanFloatBannerView this$0, int i16) {
            List<s> b16;
            s sVar;
            s sVar2;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            String str = null;
            View findViewByPosition = layoutManager != null ? layoutManager.findViewByPosition(i3) : null;
            RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
            this$0.h("onPageSelected: virtualPos- " + i3 + " itemView- " + findViewByPosition + ProgressTracer.SEPARATOR + (layoutManager2 != null ? Integer.valueOf(layoutManager2.getChildCount()) : null), true);
            RecyclerView.LayoutManager layoutManager3 = recyclerView.getLayoutManager();
            int childCount = layoutManager3 != null ? layoutManager3.getChildCount() : 0;
            for (int i17 = 0; i17 < childCount; i17++) {
                RecyclerView.LayoutManager layoutManager4 = recyclerView.getLayoutManager();
                View childAt = layoutManager4 != null ? layoutManager4.getChildAt(i17) : null;
                ZPlanMediaView zPlanMediaView = childAt instanceof ZPlanMediaView ? (ZPlanMediaView) childAt : null;
                if (zPlanMediaView != null && !Intrinsics.areEqual(zPlanMediaView, findViewByPosition)) {
                    zPlanMediaView.setProgress(0.0d);
                    zPlanMediaView.stop();
                }
            }
            ZPlanMediaView zPlanMediaView2 = findViewByPosition instanceof ZPlanMediaView ? (ZPlanMediaView) findViewByPosition : null;
            if (zPlanMediaView2 != null) {
                ZPlanFloatBannerData f16 = this$0.f();
                List<s> b17 = f16 != null ? f16.b() : null;
                if ((b17 != null ? b17.size() : 0) > i16) {
                    g gVar = (b17 == null || (sVar2 = b17.get(i16)) == null) ? null : sVar2.f427681b;
                    if (gVar != null) {
                        zPlanMediaView2.e(gVar);
                    }
                }
            }
            if (findViewByPosition != null) {
                ZPlanFloatBannerData f17 = this$0.f();
                if (f17 != null && (b16 = f17.b()) != null && (sVar = b16.get(i16)) != null) {
                    str = sVar.f427694o;
                }
                this$0.o(findViewByPosition, i16, str);
            }
        }

        @Override // com.tencent.sqshow.zootopia.portal.home.banner.c
        public void c(final int position, boolean isFakeEdgeItem) {
            ZPlanFloatBannerView.this.h("onPageSelected: onPageSelected " + position + ", isFakeEdgeItem = " + isFakeEdgeItem, true);
            View childAt = this.f370221e.E().getChildAt(0);
            final RecyclerView recyclerView = childAt instanceof RecyclerView ? (RecyclerView) childAt : null;
            final int c16 = a.f433598a.c(this.f370221e.getIsInfiniteLooper(), position);
            if (recyclerView != null) {
                final ZPlanFloatBannerView zPlanFloatBannerView = ZPlanFloatBannerView.this;
                recyclerView.post(new Runnable() { // from class: n84.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanFloatBannerView.b.f(RecyclerView.this, c16, zPlanFloatBannerView, position);
                    }
                });
            }
        }

        @Override // com.tencent.sqshow.zootopia.portal.home.banner.c
        public void onPageScrollStateChanged(int state) {
        }

        @Override // com.tencent.sqshow.zootopia.portal.home.banner.c
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }
}

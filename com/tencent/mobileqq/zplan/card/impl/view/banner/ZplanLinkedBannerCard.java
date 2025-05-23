package com.tencent.mobileqq.zplan.card.impl.view.banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;
import com.tencent.mobileqq.zplan.card.impl.view.ZootopiaBaseGuideViewCard;
import com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanLinkedBannerCard;
import com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView;
import com.tencent.mobileqq.zplan.card.impl.view.banner.adapter.ZplanLinkedBannerAdapter;
import com.tencent.mobileqq.zplan.card.impl.view.banner.adapter.ZplanPagFrameAdapter;
import com.tencent.mobileqq.zplan.card.impl.view.banner.itemView.ZplanBaseDownloadButtonItemView;
import com.tencent.mobileqq.zplan.widget.impl.button.ZplanCommonButton;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.widget.pag.ZPlanPAGLoader;
import com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.card.view.banner.ZplanInnerIndicatorView;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.data.ZootopiaTabConfigData;
import com.tencent.sqshow.zootopia.guide.ZplanGuideManager;
import com.tencent.sqshow.zootopia.guide.i;
import com.tencent.sqshow.zootopia.portal.home.banner.Banner;
import com.tencent.sqshow.zootopia.portal.home.banner.indicator.Direction;
import com.tencent.sqshow.zootopia.utils.PagLoader;
import com.tencent.sqshow.zootopia.utils.ZplanImageDownloader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import pu4.t;
import pv4.s;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 W2\u00020\u0001:\u0001XB/\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010Q\u001a\u00020P\u0012\u0006\u0010S\u001a\u00020R\u0012\u0006\u0010T\u001a\u00020\u0010\u00a2\u0006\u0004\bU\u0010VJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J(\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J \u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J4\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0017`\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0016J \u0010!\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0014JB\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0017`\u00182\u0006\u0010$\u001a\u00020#2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010&\u001a\u00020\u0004H\u0016R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010(R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\"\u00104\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000202018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u00103R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001a\u0010@\u001a\u00020\u00108\u0014X\u0094D\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010=R\u001b\u0010H\u001a\u00020C8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001b\u0010M\u001a\u00020I8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u0010E\u001a\u0004\bK\u0010L\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanLinkedBannerCard;", "Lcom/tencent/mobileqq/zplan/card/impl/view/ZootopiaBaseGuideViewCard;", "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", "", "b0", "zootopiaCardData", "Y", "Z", "", "Lpv4/s;", "data", "", "a0", "Landroid/view/View;", "view", "", "position", "", "cardType", "e0", "d0", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "U", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "viewParent", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "totalCount", "f", NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/mobileqq/zplan/widget/impl/button/ZplanCommonButton;", "it", "V", "c", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView;", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView;", "pagFrameView", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanBannerBottomIndicatorView;", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanBannerBottomIndicatorView;", "indicationView", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZPlanPagInnerIndicatorView;", "c0", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZPlanPagInnerIndicatorView;", "innerIndicationView", "Lcom/tencent/sqshow/zootopia/portal/home/banner/Banner;", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/adapter/ZplanLinkedBannerAdapter;", "Lcom/tencent/sqshow/zootopia/portal/home/banner/Banner;", "linkedBanner", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "preloadImageRunnable", "Landroid/widget/TextView;", "f0", "Landroid/widget/TextView;", "tipsTextView", "g0", "I", "E", "()I", "groupId", "h0", "cardPos", "Lcom/tencent/sqshow/zootopia/card/report/a;", "i0", "Lkotlin/Lazy;", "W", "()Lcom/tencent/sqshow/zootopia/card/report/a;", "cardReporter", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "j0", "X", "()Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "viewReporter", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "itemViewType", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;I)V", "k0", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanLinkedBannerCard extends ZootopiaBaseGuideViewCard {

    /* renamed from: l0, reason: collision with root package name */
    private static final int f332114l0;

    /* renamed from: m0, reason: collision with root package name */
    private static final int f332115m0;

    /* renamed from: n0, reason: collision with root package name */
    private static final int f332116n0;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private ZplanPagFrameView pagFrameView;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ZplanBannerBottomIndicatorView indicationView;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private ZPlanPagInnerIndicatorView innerIndicationView;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private Banner<s, ZplanLinkedBannerAdapter> linkedBanner;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private Runnable preloadImageRunnable;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private TextView tipsTextView;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private final int groupId;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private int cardPos;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private final Lazy cardReporter;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewReporter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/banner/ZplanLinkedBannerCard$c", "Lqa4/d;", "Lpv4/s;", "Landroid/view/View;", "view", "data", "", "position", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements qa4.d<s> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZootopiaCardData f332130b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<s> f332131c;

        c(ZootopiaCardData zootopiaCardData, List<s> list) {
            this.f332130b = zootopiaCardData;
            this.f332131c = list;
        }

        @Override // qa4.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(View view, s data, int position) {
            Intrinsics.checkNotNullParameter(view, "view");
            ZootopiaBaseCard.w(ZplanLinkedBannerCard.this, data != null ? data.f427682c : null, false, 2, null);
            QLog.i("ZplanBannerCard", 1, "click " + position + " - " + (data != null ? data.f427682c : null));
            i.a.b(ZplanGuideManager.INSTANCE.a(), 6, ZplanLinkedBannerCard.this.getGroupId(), 0, 4, null);
            ZplanLinkedBannerCard.this.W().a(view, ZplanLinkedBannerCard.this.cardPos, position, "1", this.f332130b, this.f332131c.get(position), (r20 & 64) != 0 ? new HashMap() : null, (r20 & 128) != 0 ? "em_zplan_element" : null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/banner/ZplanLinkedBannerCard$d", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView$c;", "", "position", "Landroid/view/View;", "view", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements ZplanPagFrameView.c {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZootopiaCardData f332133e;

        d(ZootopiaCardData zootopiaCardData) {
            this.f332133e = zootopiaCardData;
        }

        @Override // com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView.c
        public void a(int position, View view) {
            ZplanBannerBottomIndicatorView zplanBannerBottomIndicatorView = ZplanLinkedBannerCard.this.indicationView;
            if (zplanBannerBottomIndicatorView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indicationView");
                zplanBannerBottomIndicatorView = null;
            }
            zplanBannerBottomIndicatorView.c(position);
            if (view != null) {
                ZplanLinkedBannerCard.this.e0(view, position, this.f332133e, "1");
            }
        }

        @Override // com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView.c
        public void b(int i3, int i16) {
            ZplanPagFrameView.c.a.a(this, i3, i16);
        }

        @Override // com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView.c
        public void c(int i3, float f16) {
            ZplanPagFrameView.c.a.b(this, i3, f16);
        }
    }

    static {
        int dpToPx = ViewUtils.dpToPx(16.0f);
        f332114l0 = dpToPx;
        int screenWidth = ViewUtils.getScreenWidth() - (dpToPx * 2);
        f332115m0 = screenWidth;
        f332116n0 = (int) (screenWidth * 0.521613832853026d);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanLinkedBannerCard(Context context, LifecycleOwner owner, oa4.a mapResViewModel, ZootopiaSource sourceCurrent, int i3) {
        super(context, owner, mapResViewModel, sourceCurrent, i3);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.groupId = 13;
        this.cardPos = -1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.sqshow.zootopia.card.report.a>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanLinkedBannerCard$cardReporter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.sqshow.zootopia.card.report.a invoke() {
                return new com.tencent.sqshow.zootopia.card.report.a();
            }
        });
        this.cardReporter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ZplanViewReportHelper>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanLinkedBannerCard$viewReporter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZplanViewReportHelper invoke() {
                return new ZplanViewReportHelper();
            }
        });
        this.viewReporter = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.sqshow.zootopia.card.report.a W() {
        return (com.tencent.sqshow.zootopia.card.report.a) this.cardReporter.getValue();
    }

    private final ZplanViewReportHelper X() {
        return (ZplanViewReportHelper) this.viewReporter.getValue();
    }

    private final void Y(final ZootopiaCardData zootopiaCardData) {
        List<s> c16 = zootopiaCardData.c();
        if (c16 == null) {
            return;
        }
        Banner<s, ZplanLinkedBannerAdapter> banner = this.linkedBanner;
        if (banner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linkedBanner");
            banner = null;
        }
        Banner<s, ZplanLinkedBannerAdapter> banner2 = banner;
        Context context = banner2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        banner2.setIndicator(new ZplanInnerIndicatorView(context));
        banner2.setIndicatorMargin(new com.tencent.sqshow.zootopia.portal.home.banner.indicator.c(0, 0, 0, ViewUtils.dpToPx(6.0f)));
        banner2.setIndicatorGravity(Direction.CENTER);
        banner2.t(o());
        banner2.v(new b(zootopiaCardData));
        banner2.setInfiniteLoop(false);
        banner2.setAutoLoop(false);
        banner2.setMStartPosition(0);
        Context context2 = banner2.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        banner2.setAdapter(new ZplanLinkedBannerAdapter(context2, c16, p(), o(), r(), 5, new Function2<View, Integer, Unit>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanLinkedBannerCard$initBannerView$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num) {
                invoke(view, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, int i3) {
                Intrinsics.checkNotNullParameter(view, "view");
                ZplanLinkedBannerCard.this.d0(view, i3, zootopiaCardData);
                i.a.b(ZplanGuideManager.INSTANCE.a(), 6, ZplanLinkedBannerCard.this.getGroupId(), 0, 4, null);
            }
        }));
        banner2.setOnBannerListener(new c(zootopiaCardData, c16));
    }

    private final void Z(final ZootopiaCardData dataInfo) {
        final ZplanPagFrameView zplanPagFrameView;
        final List<s> c16 = dataInfo.c();
        ZplanPagFrameView zplanPagFrameView2 = null;
        ZPlanPagInnerIndicatorView zPlanPagInnerIndicatorView = null;
        if (c16 != null && !c16.isEmpty()) {
            ZPlanPagInnerIndicatorView zPlanPagInnerIndicatorView2 = this.innerIndicationView;
            if (zPlanPagInnerIndicatorView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("innerIndicationView");
                zPlanPagInnerIndicatorView2 = null;
            }
            zPlanPagInnerIndicatorView2.setVisibility(0);
            ZplanPagFrameView zplanPagFrameView3 = this.pagFrameView;
            if (zplanPagFrameView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pagFrameView");
                zplanPagFrameView = null;
            } else {
                zplanPagFrameView = zplanPagFrameView3;
            }
            zplanPagFrameView.setAutoLoop(false);
            zplanPagFrameView.setInfiniteLooper(false);
            ZPlanPagInnerIndicatorView zPlanPagInnerIndicatorView3 = this.innerIndicationView;
            if (zPlanPagInnerIndicatorView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("innerIndicationView");
            } else {
                zPlanPagInnerIndicatorView = zPlanPagInnerIndicatorView3;
            }
            zplanPagFrameView.h(zPlanPagInnerIndicatorView);
            zplanPagFrameView.h(new d(dataInfo));
            ZplanPagFrameAdapter zplanPagFrameAdapter = new ZplanPagFrameAdapter(c16, p(), o(), r(), 5, new Function2<View, Integer, Unit>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanLinkedBannerCard$initPagView$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public final void invoke(View view, int i3) {
                    ZplanPagFrameView zplanPagFrameView4;
                    Intrinsics.checkNotNullParameter(view, "view");
                    zplanPagFrameView4 = ZplanLinkedBannerCard.this.pagFrameView;
                    if (zplanPagFrameView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pagFrameView");
                        zplanPagFrameView4 = null;
                    }
                    zplanPagFrameView4.setSkipAutoLoop();
                    ZplanLinkedBannerCard.this.d0(view, i3, dataInfo);
                    i.a.b(ZplanGuideManager.INSTANCE.a(), 6, ZplanLinkedBannerCard.this.getGroupId(), 0, 4, null);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num) {
                    invoke(view, num.intValue());
                    return Unit.INSTANCE;
                }
            });
            zplanPagFrameAdapter.g(new Function3<Integer, s, View, Unit>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanLinkedBannerCard$initPagView$1$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, s sVar, View view) {
                    invoke(num.intValue(), sVar, view);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, s data, View view) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    Intrinsics.checkNotNullParameter(view, "view");
                    QLog.i("ZplanBannerCard", 1, "pagView click " + i3 + " - " + data.f427682c);
                    ZplanPagFrameView.this.setSkipAutoLoop();
                    ZootopiaBaseCard.w(this, data.f427682c, false, 2, null);
                    i.a.b(ZplanGuideManager.INSTANCE.a(), 6, this.getGroupId(), 0, 4, null);
                    this.W().a(view, this.cardPos, i3, "1", dataInfo, c16.get(i3), (r20 & 64) != 0 ? new HashMap() : null, (r20 & 128) != 0 ? "em_zplan_element" : null);
                }
            });
            zplanPagFrameAdapter.h(new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanLinkedBannerCard$initPagView$1$3$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    ZplanPagFrameView zplanPagFrameView4;
                    zplanPagFrameView4 = ZplanLinkedBannerCard.this.pagFrameView;
                    if (zplanPagFrameView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pagFrameView");
                        zplanPagFrameView4 = null;
                    }
                    zplanPagFrameView4.C(i3);
                }
            });
            zplanPagFrameView.setAdapter(zplanPagFrameAdapter);
            return;
        }
        ZplanPagFrameView zplanPagFrameView4 = this.pagFrameView;
        if (zplanPagFrameView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagFrameView");
        } else {
            zplanPagFrameView2 = zplanPagFrameView4;
        }
        zplanPagFrameView2.setVisibility(8);
    }

    private final boolean a0(List<s> data) {
        for (s sVar : data) {
            String[] strArr = sVar.f427681b.f427438e.f427523a;
            if (strArr != null && strArr.length >= 2) {
                ZPlanPAGLoader zPlanPAGLoader = ZPlanPAGLoader.f369875a;
                String str = strArr[0];
                Intrinsics.checkNotNullExpressionValue(str, "it.material.pagInfo.pagList[0]");
                String h16 = ZPlanPAGLoader.h(zPlanPAGLoader, str, false, 2, null);
                String str2 = sVar.f427681b.f427438e.f427523a[1];
                Intrinsics.checkNotNullExpressionValue(str2, "it.material.pagInfo.pagList[1]");
                String h17 = ZPlanPAGLoader.h(zPlanPAGLoader, str2, false, 2, null);
                if (h16 != null) {
                    if (!(h16.length() == 0)) {
                        if (h17 != null) {
                            if (h17.length() == 0) {
                            }
                        }
                        QLog.d("ZplanBannerCard", 1, "right pag not exit !! " + h17 + " " + sVar.f427681b.f427438e.f427523a[1]);
                        return false;
                    }
                }
                QLog.d("ZplanBannerCard", 1, "left pag not exit !! " + h16 + " " + sVar.f427681b.f427438e.f427523a[0]);
                return false;
            }
            QLog.e("ZplanBannerCard", 1, "invalid pagInfo " + strArr);
            return false;
        }
        if (!PagLoader.c().e()) {
            QLog.d("ZplanBannerCard", 1, "pag File not exit, show default viewpager view");
        }
        return false;
    }

    private final void b0(final ZootopiaCardData dataInfo) {
        Runnable runnable = this.preloadImageRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.e
            @Override // java.lang.Runnable
            public final void run() {
                ZplanLinkedBannerCard.c0(ZootopiaCardData.this);
            }
        };
        this.preloadImageRunnable = runnable2;
        postDelayed(runnable2, 15000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(ZootopiaCardData dataInfo) {
        IntRange indices;
        t tVar;
        Intrinsics.checkNotNullParameter(dataInfo, "$dataInfo");
        List<s> c16 = dataInfo.c();
        if (c16 == null) {
            return;
        }
        Iterator<T> it = c16.iterator();
        while (it.hasNext()) {
            pu4.g gVar = ((s) it.next()).f427681b;
            String[] strArr = (gVar == null || (tVar = gVar.f427438e) == null) ? null : tVar.f427524b;
            if (strArr == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(strArr, "it.material?.pagInfo?.picList ?: return@Runnable");
            indices = ArraysKt___ArraysKt.getIndices(strArr);
            Iterator<Integer> it5 = indices.iterator();
            while (it5.hasNext()) {
                int nextInt = ((IntIterator) it5).nextInt();
                ZplanImageDownloader zplanImageDownloader = ZplanImageDownloader.f373239a;
                String str = strArr[nextInt];
                Intrinsics.checkNotNullExpressionValue(str, "picList[i]");
                zplanImageDownloader.g(str);
                QLog.d("ZplanBannerCard", 1, "preload Image " + strArr[nextInt]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.zplan.card.impl.view.ZootopiaBaseGuideViewCard
    /* renamed from: E, reason: from getter */
    public int getGroupId() {
        return this.groupId;
    }

    public final HashMap<String, Object> V(ZplanCommonButton it, View view, ZootopiaCardData dataInfo, int position) {
        ZootopiaDownloadButton zootopiaDownloadButton;
        String str;
        HashMap<String, Object> hashMapOf;
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataInfo, "dataInfo");
        if (it.p() instanceof ZootopiaDownloadButton) {
            View p16 = it.p();
            Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton");
            zootopiaDownloadButton = (ZootopiaDownloadButton) p16;
        } else {
            zootopiaDownloadButton = null;
        }
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("zplan_map_id", ((ZplanBaseDownloadButtonItemView) view).d());
        pairArr[1] = TuplesKt.to("zplan_btn_status", Integer.valueOf(ButtonStatus.INSTANCE.b(zootopiaDownloadButton != null ? zootopiaDownloadButton.getStatus() : null)));
        if (zootopiaDownloadButton == null || (str = zootopiaDownloadButton.r()) == null) {
            str = "";
        }
        pairArr[2] = TuplesKt.to("zplan_btn_context", str);
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        hashMapOf.putAll(U(dataInfo, position));
        return hashMapOf;
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.ZootopiaBaseGuideViewCard, l84.a
    public void f(final ZootopiaCardData dataInfo, int position, int totalCount) {
        Intrinsics.checkNotNullParameter(dataInfo, "dataInfo");
        final List<s> c16 = dataInfo.c();
        if (c16 == null) {
            return;
        }
        final boolean z16 = true;
        if (c16.isEmpty()) {
            QLog.e("ZplanBannerCard", 1, "data can`t be null");
            return;
        }
        this.cardPos = position;
        ZplanBannerBottomIndicatorView zplanBannerBottomIndicatorView = this.indicationView;
        ZplanBannerBottomIndicatorView zplanBannerBottomIndicatorView2 = null;
        if (zplanBannerBottomIndicatorView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indicationView");
            zplanBannerBottomIndicatorView = null;
        }
        zplanBannerBottomIndicatorView.setData(dataInfo.c(), 5);
        if (a0(c16)) {
            Banner<s, ZplanLinkedBannerAdapter> banner = this.linkedBanner;
            if (banner == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkedBanner");
                banner = null;
            }
            banner.removeAllViews();
            Banner<s, ZplanLinkedBannerAdapter> banner2 = this.linkedBanner;
            if (banner2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkedBanner");
                banner2 = null;
            }
            banner2.setVisibility(8);
            ZplanPagFrameView zplanPagFrameView = this.pagFrameView;
            if (zplanPagFrameView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pagFrameView");
                zplanPagFrameView = null;
            }
            zplanPagFrameView.setVisibility(0);
            QLog.i("ZplanBannerCard", 1, "use pag frame view");
            Z(dataInfo);
        } else {
            ZplanPagFrameView zplanPagFrameView2 = this.pagFrameView;
            if (zplanPagFrameView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pagFrameView");
                zplanPagFrameView2 = null;
            }
            zplanPagFrameView2.removeAllViews();
            ZplanPagFrameView zplanPagFrameView3 = this.pagFrameView;
            if (zplanPagFrameView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pagFrameView");
                zplanPagFrameView3 = null;
            }
            zplanPagFrameView3.setVisibility(8);
            ZPlanPagInnerIndicatorView zPlanPagInnerIndicatorView = this.innerIndicationView;
            if (zPlanPagInnerIndicatorView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("innerIndicationView");
                zPlanPagInnerIndicatorView = null;
            }
            zPlanPagInnerIndicatorView.setVisibility(8);
            Banner<s, ZplanLinkedBannerAdapter> banner3 = this.linkedBanner;
            if (banner3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkedBanner");
                banner3 = null;
            }
            banner3.setVisibility(0);
            Y(dataInfo);
            QLog.i("ZplanBannerCard", 1, "use viewpager view");
            z16 = false;
        }
        ZplanBannerBottomIndicatorView zplanBannerBottomIndicatorView3 = this.indicationView;
        if (zplanBannerBottomIndicatorView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indicationView");
            zplanBannerBottomIndicatorView3 = null;
        }
        zplanBannerBottomIndicatorView3.setOnClickListener(new Function2<Integer, View, Unit>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanLinkedBannerCard$bindItemInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, View view) {
                invoke(num.intValue(), view);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, View view) {
                ZplanPagFrameView zplanPagFrameView4;
                Intrinsics.checkNotNullParameter(view, "view");
                QLog.i("ZplanBannerCard", 1, "bindItemInfo: pos " + i3);
                ZplanPagFrameView zplanPagFrameView5 = null;
                if (z16) {
                    zplanPagFrameView4 = this.pagFrameView;
                    if (zplanPagFrameView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pagFrameView");
                    } else {
                        zplanPagFrameView5 = zplanPagFrameView4;
                    }
                    zplanPagFrameView5.setCurrentIndexOutSide(i3);
                } else {
                    Banner banner4 = this.linkedBanner;
                    if (banner4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("linkedBanner");
                        banner4 = null;
                    }
                    Banner.setCurrentItemOutSide$default(banner4, i3, false, 2, null);
                }
                this.W().a(view, this.cardPos, i3, "2", dataInfo, c16.get(i3), (r20 & 64) != 0 ? new HashMap() : null, (r20 & 128) != 0 ? "em_zplan_element" : null);
            }
        });
        ZplanBannerBottomIndicatorView zplanBannerBottomIndicatorView4 = this.indicationView;
        if (zplanBannerBottomIndicatorView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indicationView");
        } else {
            zplanBannerBottomIndicatorView2 = zplanBannerBottomIndicatorView4;
        }
        zplanBannerBottomIndicatorView2.setOnRenderListener(new Function2<Integer, View, Unit>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanLinkedBannerCard$bindItemInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, View view) {
                invoke(num.intValue(), view);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                ZplanLinkedBannerCard.this.W().c(view, ZplanLinkedBannerCard.this.cardPos, i3, "2", dataInfo, c16.get(i3), (r24 & 64) != 0 ? new HashMap() : null, (r24 & 128) != 0 ? "em_zplan_element" : null, (r24 & 256) != 0 ? null : null, (r24 & 512) != 0);
            }
        });
        TextView textView = this.tipsTextView;
        if (textView != null) {
            textView.setText(R.string.xpt);
        }
        super.f(dataInfo, position, totalCount);
        b0(dataInfo);
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.ZootopiaBaseGuideViewCard, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.preloadImageRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.preloadImageRunnable = null;
        }
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public View s(Context context, ViewGroup viewParent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewParent, "viewParent");
        viewParent.setClipChildren(false);
        View view = LayoutInflater.from(context).inflate(R.layout.dae, viewParent, true);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.r3_);
        Banner<s, ZplanLinkedBannerAdapter> banner = new Banner<>(context);
        int i3 = f332115m0;
        int i16 = f332116n0;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i16);
        int i17 = f332114l0;
        layoutParams.setMargins(i17, 0, i17, 0);
        banner.setLayoutParams(layoutParams);
        banner.setBackgroundRadius(i17);
        this.linkedBanner = banner;
        frameLayout.addView(banner);
        ZplanPagFrameView zplanPagFrameView = new ZplanPagFrameView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i3, i16);
        layoutParams2.setMargins(i17, 0, i17, 0);
        zplanPagFrameView.setLayoutParams(layoutParams2);
        this.pagFrameView = zplanPagFrameView;
        frameLayout.addView(zplanPagFrameView);
        View findViewById = view.findViewById(R.id.r5u);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.zplan_indicator_view)");
        this.indicationView = (ZplanBannerBottomIndicatorView) findViewById;
        View findViewById2 = view.findViewById(R.id.r3a);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.z\u2026ner_inner_indicator_view)");
        this.innerIndicationView = (ZPlanPagInnerIndicatorView) findViewById2;
        J(view.findViewById(R.id.r8s));
        this.tipsTextView = (TextView) view.findViewById(R.id.r9a);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return view;
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public String z() {
        return "ZplanBannerCard";
    }

    private final HashMap<String, Object> U(ZootopiaCardData dataInfo, int position) {
        HashMap hashMapOf;
        HashMap<String, Object> hashMapOf2;
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to("zplan_card_type", Integer.valueOf(dataInfo.getType()));
        pairArr[1] = TuplesKt.to("zplan_card_id", Integer.valueOf(dataInfo.getCardId()));
        pairArr[2] = TuplesKt.to("zplan_card_pos", Integer.valueOf(this.cardPos));
        pairArr[3] = TuplesKt.to("zplan_elem_pos", Integer.valueOf(position));
        Pair[] pairArr2 = new Pair[2];
        ZootopiaTabConfigData parentListTabConfig = dataInfo.getParentListTabConfig();
        pairArr2[0] = TuplesKt.to("scene_abtest", parentListTabConfig != null ? parentListTabConfig.getTabConfig() : null);
        ZootopiaTabConfigData tabConfig = dataInfo.getTabConfig();
        pairArr2[1] = TuplesKt.to("abtest_info", tabConfig != null ? tabConfig.getTabConfig() : null);
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr2);
        pairArr[4] = TuplesKt.to("abtest_info", hashMapOf);
        hashMapOf2 = MapsKt__MapsKt.hashMapOf(pairArr);
        return hashMapOf2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(View view, int position, ZootopiaCardData dataInfo) {
        ZplanCommonButton zplanCommonButton = (ZplanCommonButton) view.findViewById(R.id.r46);
        if (zplanCommonButton != null) {
            QLog.d("ZplanBannerCard", 1, " report button  click " + view + " " + position);
            X().e(zplanCommonButton, "em_zplan_mod_btn", V(zplanCommonButton, view, dataInfo, position));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(View view, int position, ZootopiaCardData dataInfo, String cardType) {
        ZootopiaCardData zootopiaCardData;
        List<s> c16 = dataInfo.c();
        if (c16 == null) {
            return;
        }
        if (c16.size() <= position) {
            QLog.d("ZplanBannerCard", 1, "invalid data, ignore report: " + position + " " + c16.size());
            return;
        }
        QLog.d("ZplanBannerCard", 1, " report view " + view + " " + position);
        W().c(view, this.cardPos, position, cardType, dataInfo, c16.get(position), (r24 & 64) != 0 ? new HashMap() : null, (r24 & 128) != 0 ? "em_zplan_element" : null, (r24 & 256) != 0 ? null : null, (r24 & 512) != 0);
        ZplanCommonButton zplanCommonButton = (ZplanCommonButton) view.findViewById(R.id.r46);
        if (zplanCommonButton != null) {
            QLog.d("ZplanBannerCard", 1, " report button  view " + view + " " + position);
            zootopiaCardData = dataInfo;
            X().g(zplanCommonButton, "em_zplan_mod_btn", (r16 & 4) != 0 ? null : V(zplanCommonButton, view, zootopiaCardData, position), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        } else {
            zootopiaCardData = dataInfo;
        }
        ZplanBaseDownloadButtonItemView zplanBaseDownloadButtonItemView = view instanceof ZplanBaseDownloadButtonItemView ? (ZplanBaseDownloadButtonItemView) view : null;
        if (zplanBaseDownloadButtonItemView != null) {
            zplanBaseDownloadButtonItemView.h(U(zootopiaCardData, position));
        }
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard, l84.a
    public void c() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/banner/ZplanLinkedBannerCard$b", "Lcom/tencent/sqshow/zootopia/portal/home/banner/c;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "", "isFakeEdgeItem", "c", "state", "onPageScrollStateChanged", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.sqshow.zootopia.portal.home.banner.c {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZootopiaCardData f332128e;

        b(ZootopiaCardData zootopiaCardData) {
            this.f332128e = zootopiaCardData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(RecyclerView recyclerView, int i3, ZplanLinkedBannerCard this$0, int i16, ZootopiaCardData zootopiaCardData) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(zootopiaCardData, "$zootopiaCardData");
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            View findViewByPosition = layoutManager != null ? layoutManager.findViewByPosition(i3) : null;
            Object tag = findViewByPosition != null ? findViewByPosition.getTag() : null;
            RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
            QLog.i("ZplanBannerCard", 1, "onPageSelected: realPos " + i3 + " view pos " + tag + ProgressTracer.SEPARATOR + (layoutManager2 != null ? Integer.valueOf(layoutManager2.getChildCount()) : null));
            if (findViewByPosition != null) {
                this$0.e0(findViewByPosition, i16, zootopiaCardData, "1");
            }
        }

        @Override // com.tencent.sqshow.zootopia.portal.home.banner.c
        public void c(final int position, boolean isFakeEdgeItem) {
            QLog.i("ZplanBannerCard", 1, "onPageSelected: onPageSelected " + position);
            ZplanBannerBottomIndicatorView zplanBannerBottomIndicatorView = ZplanLinkedBannerCard.this.indicationView;
            Banner banner = null;
            if (zplanBannerBottomIndicatorView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indicationView");
                zplanBannerBottomIndicatorView = null;
            }
            zplanBannerBottomIndicatorView.c(position);
            Banner banner2 = ZplanLinkedBannerCard.this.linkedBanner;
            if (banner2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkedBanner");
                banner2 = null;
            }
            View childAt = banner2.E().getChildAt(0);
            RecyclerView recyclerView = childAt instanceof RecyclerView ? (RecyclerView) childAt : null;
            sa4.a aVar = sa4.a.f433598a;
            Banner banner3 = ZplanLinkedBannerCard.this.linkedBanner;
            if (banner3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkedBanner");
            } else {
                banner = banner3;
            }
            final int c16 = aVar.c(banner.getIsInfiniteLooper(), position);
            if (recyclerView != null) {
                final ZplanLinkedBannerCard zplanLinkedBannerCard = ZplanLinkedBannerCard.this;
                final ZootopiaCardData zootopiaCardData = this.f332128e;
                final RecyclerView recyclerView2 = recyclerView;
                recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZplanLinkedBannerCard.b.f(RecyclerView.this, c16, zplanLinkedBannerCard, position, zootopiaCardData);
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

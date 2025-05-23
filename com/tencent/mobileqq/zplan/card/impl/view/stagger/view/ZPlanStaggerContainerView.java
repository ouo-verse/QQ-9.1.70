package com.tencent.mobileqq.zplan.card.impl.view.stagger.view;

import ag3.c;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import bg3.StaggerShowRecorder;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.zootopia.recommend.common.ZplanCardFeedsListView;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.mobileqq.zplan.card.impl.view.stagger.view.ZPlanStaggerContainerView;
import com.tencent.mobileqq.zplan.utils.aa;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaPullRefreshLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import t74.u;
import tl.h;
import yf3.a;
import zf3.StaggerItemData;
import zf3.d;

@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001L\u0018\u0000 `2\u00020\u0001:\u0001aB'\b\u0007\u0012\u0006\u0010Z\u001a\u00020)\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010[\u0012\b\b\u0002\u0010]\u001a\u00020\u0011\u00a2\u0006\u0004\b^\u0010_J\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002JV\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001e\u0010\u001e\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u001d\u001a\u00020\u0011H\u0002J\u001e\u0010 \u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u001f\u001a\u00020\u0011H\u0002J\b\u0010!\u001a\u00020\u0002H\u0002J\b\u0010\"\u001a\u00020\u0002H\u0002J\b\u0010#\u001a\u00020\u0002H\u0002J\b\u0010$\u001a\u00020\u0002H\u0002J\u0016\u0010&\u001a\u00020\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u0010\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u000eH\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010*\u001a\u00020)H\u0002J\b\u0010-\u001a\u00020\u0002H\u0002J\b\u0010.\u001a\u00020\u0002H\u0002J$\u0010/\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\b\u00100\u001a\u00020\u0002H\u0014J\b\u00101\u001a\u00020\u0002H\u0015J\u0006\u00102\u001a\u00020\u0002R\u0014\u00104\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u00103R\u0014\u00105\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u00103R$\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u001406j\b\u0012\u0004\u0012\u00020\u0014`78\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u00108R$\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u001406j\b\u0012\u0004\u0012\u00020\u0014`78\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u00108R$\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\u001406j\b\u0012\u0004\u0012\u00020\u0014`78\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u00108R\u0016\u0010=\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010<R\u0016\u0010?\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010<R\u0016\u0010A\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010<R&\u0010G\u001a\u0012\u0012\u0004\u0012\u00020C0Bj\b\u0012\u0004\u0012\u00020C`D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010R\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010T\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b<\u0010SR\u0018\u0010W\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010S\u00a8\u0006b"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/ZPlanStaggerContainerView;", "Landroid/widget/FrameLayout;", "", "g", "Lyf3/a;", IndividuationUrlHelper.UrlId.CARD_HOME, "", "scrolling", "dataInit", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "w", "Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "", "containerName", HippyTKDListViewAdapter.X, "", "index", "", "Lzf3/e;", "dataList", "contentHeightBefore", "selfTop", "staggerItemContainer", "Lbg3/d;", "currentShowRecorder", "screenHeight", "i", "targetIndex", "j", "targetHeight", "k", "d", DomainData.DOMAIN_NAME, "y", "f", "newData", h.F, "defaultJumpUrl", "e", "Landroid/content/Context;", "ctx", "Landroid/support/v7/widget/RecyclerView;", "l", "r", "v", "p", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "o", "Landroid/widget/LinearLayout;", "mLeftStaggerContainer", "mRightStaggerContainer", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mData", "mLeftData", "mRightData", "I", "mLeftContentHeight", BdhLogUtil.LogTag.Tag_Conn, "mRightContentHeight", "D", "mTotalContentHeight", "Ljava/util/HashSet;", "Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/StaggerItemContentContainer;", "Lkotlin/collections/HashSet;", "E", "Ljava/util/HashSet;", "mInScreenViews", "Lag3/c;", UserInfo.SEX_FEMALE, "Lag3/c;", "mStaggerItemContentCache", "com/tencent/mobileqq/zplan/card/impl/view/stagger/view/ZPlanStaggerContainerView$b", "G", "Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/ZPlanStaggerContainerView$b;", "mScrollerListener", "H", "Lbg3/d;", "mLastShowRecorder", "Z", "mEnableUILog", "J", "Lyf3/a;", "mCard", "K", "forceUpdateWhenNextTime", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "L", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanStaggerContainerView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private int mRightContentHeight;

    /* renamed from: D, reason: from kotlin metadata */
    private int mTotalContentHeight;

    /* renamed from: E, reason: from kotlin metadata */
    private HashSet<StaggerItemContentContainer> mInScreenViews;

    /* renamed from: F, reason: from kotlin metadata */
    private final c mStaggerItemContentCache;

    /* renamed from: G, reason: from kotlin metadata */
    private final b mScrollerListener;

    /* renamed from: H, reason: from kotlin metadata */
    private StaggerShowRecorder mLastShowRecorder;

    /* renamed from: I, reason: from kotlin metadata */
    private final boolean mEnableUILog;

    /* renamed from: J, reason: from kotlin metadata */
    private a mCard;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean forceUpdateWhenNextTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout mLeftStaggerContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout mRightStaggerContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<StaggerItemData> mData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<StaggerItemData> mLeftData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<StaggerItemData> mRightData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mLeftContentHeight;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/stagger/view/ZPlanStaggerContainerView$b", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            a aVar = ZPlanStaggerContainerView.this.mCard;
            if (aVar != null) {
                ZPlanStaggerContainerView.t(ZPlanStaggerContainerView.this, aVar, newState != 0, false, 4, null);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            a aVar;
            if (Math.abs(dy5) <= 0 || (aVar = ZPlanStaggerContainerView.this.mCard) == null) {
                return;
            }
            ZPlanStaggerContainerView.t(ZPlanStaggerContainerView.this, aVar, false, false, 6, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanStaggerContainerView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void d() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(d.f452428a.l(), this.mTotalContentHeight);
        }
        layoutParams.width = d.f452428a.l();
        layoutParams.height = this.mTotalContentHeight;
        setLayoutParams(layoutParams);
        requestLayout();
    }

    private final void f() {
        this.mData.clear();
        this.mLeftData.clear();
        this.mRightData.clear();
        this.mLastShowRecorder = new StaggerShowRecorder(0, 0, 0, 7, null);
    }

    private final void g() {
        this.mInScreenViews.clear();
        w();
        this.mLeftStaggerContainer.removeAllViews();
        this.mRightStaggerContainer.removeAllViews();
    }

    private final boolean h(List<StaggerItemData> newData) {
        if (this.mData.size() != newData.size()) {
            return true;
        }
        int size = this.mData.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!Intrinsics.areEqual(this.mData.get(i3), newData.get(i3))) {
                return true;
            }
        }
        return false;
    }

    private final RecyclerView l(Context ctx) {
        ZootopiaPullRefreshLayout d16;
        Object cache = ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).getCache(ctx, ZplanCacheComponentType.CARD_LIST_VIEW);
        ZplanCardFeedsListView zplanCardFeedsListView = cache instanceof ZplanCardFeedsListView ? (ZplanCardFeedsListView) cache : null;
        if (zplanCardFeedsListView == null || (d16 = zplanCardFeedsListView.d()) == null) {
            return null;
        }
        return d16.E();
    }

    private final void n() {
        d dVar = d.f452428a;
        setPadding(dVar.i(), 0, dVar.k(), 0);
        addView(this.mLeftStaggerContainer, new FrameLayout.LayoutParams(dVar.m(), -2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dVar.m(), -2);
        layoutParams.gravity = 5;
        addView(this.mRightStaggerContainer, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(ZPlanStaggerContainerView this$0, a card) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(card, "$card");
        this$0.s(card, false, true);
    }

    private final void r() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        RecyclerView l3 = l(context);
        if (l3 != null) {
            l3.removeOnScrollListener(this.mScrollerListener);
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        RecyclerView l16 = l(context2);
        if (l16 != null) {
            l16.addOnScrollListener(this.mScrollerListener);
        }
    }

    private final void s(a card, final boolean scrolling, boolean dataInit) {
        int i3;
        int i16;
        int i17;
        StaggerShowRecorder staggerShowRecorder;
        int i18;
        String str;
        int i19;
        int i26;
        int i27;
        int i28;
        int coerceAtLeast;
        int coerceAtLeast2;
        int coerceAtLeast3;
        int coerceAtLeast4;
        int coerceAtLeast5;
        int coerceAtLeast6;
        int e16 = e84.a.f395879a.e();
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i29 = iArr[1];
        aa a16 = aa.b().a();
        String str2 = "ZPlanStaggerContainerView_";
        QLog.i("ZPlanStaggerContainerView_", 1, "showViewAccordingSelfPos screenHeight:" + e16 + ", posInWindow[1]:" + iArr[1]);
        int i36 = i29 - e16;
        d dVar = d.f452428a;
        int i37 = 0;
        if (i36 > dVar.j() || i36 > 0) {
            i3 = 0;
            i16 = 0;
            i17 = 0;
        } else {
            int j3 = (e16 - i29) + dVar.j();
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(k(this.mLeftData, j3) - 1, 0);
            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(k(this.mRightData, j3) - 1, 0);
            if (i29 >= 0 || dataInit) {
                i16 = coerceAtLeast2;
                i17 = coerceAtLeast;
                i3 = 0;
            } else {
                coerceAtLeast3 = RangesKt___RangesKt.coerceAtLeast(k(this.mLeftData, Math.abs(i29)) - 1, 0);
                coerceAtLeast4 = RangesKt___RangesKt.coerceAtLeast(coerceAtLeast3 - 1, 0);
                coerceAtLeast5 = RangesKt___RangesKt.coerceAtLeast(k(this.mRightData, Math.abs(i29)) - 1, 0);
                coerceAtLeast6 = RangesKt___RangesKt.coerceAtLeast(coerceAtLeast5 - 1, 0);
                i16 = coerceAtLeast2;
                i17 = coerceAtLeast;
                i3 = coerceAtLeast6;
                i37 = coerceAtLeast4;
            }
        }
        this.mInScreenViews.clear();
        if (this.mEnableUILog) {
            QLog.d("ZPlanStaggerContainerView_", 4, "maxLeftShowNum:" + i17 + ", maxRightShowNum:" + i16);
        }
        int j16 = j(this.mLeftData, i37 - 1);
        int j17 = j(this.mRightData, i3 - 1);
        if (this.mEnableUILog) {
            QLog.d("ZPlanStaggerContainerView_", 4, "showViewAccordingSelfPos leftShowItemStartIndex:" + i37 + ", leftShowItemEndIndex:" + i17 + ",rightShowItemStartIndex:" + i3 + ",rightShowItemEndIndex:" + i16);
        }
        StaggerShowRecorder staggerShowRecorder2 = new StaggerShowRecorder(0, 0, 0, 7, null);
        if (this.mEnableUILog) {
            a16.d("showViewAccordingSelfPos - before loop");
        }
        if (i37 <= i17) {
            int i38 = j16;
            int i39 = i37;
            while (true) {
                if (i39 < 0 || i39 >= this.mLeftData.size()) {
                    i27 = i39;
                    staggerShowRecorder = staggerShowRecorder2;
                    i18 = i3;
                    i28 = i17;
                    str = str2;
                    i19 = i29;
                    i26 = i16;
                } else {
                    i27 = i39;
                    staggerShowRecorder = staggerShowRecorder2;
                    int i46 = i29;
                    i19 = i29;
                    i26 = i16;
                    i18 = i3;
                    i28 = i17;
                    str = str2;
                    i38 = i(card, i39, this.mLeftData, i38, i46, this.mLeftStaggerContainer, staggerShowRecorder, e16, "leftContainer");
                }
                if (i27 == i28) {
                    break;
                }
                i39 = i27 + 1;
                staggerShowRecorder2 = staggerShowRecorder;
                i17 = i28;
                i16 = i26;
                i29 = i19;
                i3 = i18;
                str2 = str;
            }
        } else {
            staggerShowRecorder = staggerShowRecorder2;
            i18 = i3;
            str = "ZPlanStaggerContainerView_";
            i19 = i29;
            i26 = i16;
        }
        if (this.mEnableUILog) {
            a16.d("showViewAccordingSelfPos - left loop end");
        }
        int i47 = i18;
        if (i47 <= i26) {
            int i48 = i47;
            int i49 = j17;
            while (true) {
                if (i48 >= 0 && i48 < this.mRightData.size()) {
                    i49 = i(card, i48, this.mRightData, i49, i19, this.mRightStaggerContainer, staggerShowRecorder, e16, "rightContainer");
                }
                if (i48 == i26) {
                    break;
                } else {
                    i48++;
                }
            }
        }
        if (this.mEnableUILog) {
            a16.d("showViewAccordingSelfPos - after loop");
        }
        requestLayout();
        if (this.mEnableUILog) {
            a16.d("showViewAccordingSelfPos - requestLayout");
        }
        StaggerShowRecorder staggerShowRecorder3 = staggerShowRecorder;
        if (!Intrinsics.areEqual(staggerShowRecorder3, this.mLastShowRecorder)) {
            this.mLastShowRecorder = staggerShowRecorder3;
        }
        w();
        if (this.mEnableUILog) {
            a16.d("showViewAccordingSelfPos - unavailableItemIntoCache");
        }
        post(new Runnable() { // from class: bg3.e
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanStaggerContainerView.u(ZPlanStaggerContainerView.this, scrolling);
            }
        });
        if (a16.c() >= 5000000) {
            a16.d("showViewAccordingSelfPos - end(" + scrolling + "). total end");
        }
        QLog.i(str, 1, "showViewAccordingSelfPos end\uff1acacheSize:" + this.mStaggerItemContentCache.b() + ", createCounter:" + this.mStaggerItemContentCache.getCreateCounter());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(ZPlanStaggerContainerView this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m(z16);
    }

    private final void v() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        RecyclerView l3 = l(context);
        if (l3 != null) {
            l3.removeOnScrollListener(this.mScrollerListener);
        }
    }

    private final void w() {
        x(this.mLeftStaggerContainer, "leftContainer");
        x(this.mRightStaggerContainer, "rightContainer");
    }

    private final void x(LinearLayout container, String containerName) {
        boolean contains;
        int childCount = container.getChildCount();
        if (childCount > 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = container.getChildAt(i3);
                if (childAt != null) {
                    contains = CollectionsKt___CollectionsKt.contains(this.mInScreenViews, childAt);
                    if (!contains) {
                        if (this.mEnableUILog) {
                            QLog.d("ZPlanStaggerContainerView_", 4, "unbindItemNotInScreen container:" + containerName + ", pos:" + i3);
                        }
                        StaggerItemContentContainer staggerItemContentContainer = childAt instanceof StaggerItemContentContainer ? (StaggerItemContentContainer) childAt : null;
                        if (staggerItemContentContainer != null) {
                            staggerItemContentContainer.d();
                        }
                    }
                }
            }
        }
    }

    private final void y() {
        LinearLayout linearLayout = this.mLeftStaggerContainer;
        d dVar = d.f452428a;
        m84.b.c(linearLayout, dVar.m(), -2, null, 4, null);
        m84.b.c(this.mRightStaggerContainer, dVar.m(), -2, null, 4, null);
    }

    public final void o() {
        QLog.e("ZPlanStaggerContainerView_", 1, "notifyConfigurationChanged " + this.forceUpdateWhenNextTime);
        y();
        this.forceUpdateWhenNextTime = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        r();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v();
    }

    public final void p(final a card, String defaultJumpUrl, List<StaggerItemData> dataList) {
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(defaultJumpUrl, "defaultJumpUrl");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        QLog.i("ZPlanStaggerContainerView_", 1, "refreshData in  - forceUpdateWhenNextTime = " + this.forceUpdateWhenNextTime);
        this.mCard = card;
        r();
        if (!h(dataList) && !this.forceUpdateWhenNextTime) {
            QLog.i("ZPlanStaggerContainerView_", 1, "refreshData dataset is same!");
            return;
        }
        this.forceUpdateWhenNextTime = false;
        f();
        this.mData.addAll(dataList);
        e(defaultJumpUrl);
        d();
        g();
        post(new Runnable() { // from class: bg3.f
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanStaggerContainerView.q(ZPlanStaggerContainerView.this, card);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanStaggerContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void e(String defaultJumpUrl) {
        int h16;
        int coerceAtLeast;
        this.mLeftContentHeight = 0;
        this.mRightContentHeight = 0;
        Iterator<StaggerItemData> it = this.mData.iterator();
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        while (it.hasNext()) {
            int i18 = i3 + 1;
            StaggerItemData next = it.next();
            int measureHeight = next.getMeasureHeight();
            if (this.mLeftContentHeight > this.mRightContentHeight) {
                int h17 = this.mRightData.size() == 0 ? 0 : d.f452428a.h();
                this.mRightData.add(next);
                i17 = h17 + measureHeight;
                this.mRightContentHeight += i17;
                QLog.i("ZPlanStaggerContainerView_", 1, "index:" + i3 + ", measureHeight:" + measureHeight + " ,to right");
            } else {
                int h18 = this.mLeftData.size() == 0 ? 0 : d.f452428a.h();
                this.mLeftData.add(next);
                i16 = h18 + measureHeight;
                this.mLeftContentHeight += i16;
                QLog.i("ZPlanStaggerContainerView_", 1, "index:" + i3 + ", measureHeight:" + measureHeight + " ,to left");
            }
            i3 = i18;
        }
        int i19 = this.mLeftContentHeight;
        int i26 = this.mRightContentHeight;
        if (i19 > i26) {
            if (i19 - i26 >= i16 / 2) {
                d dVar = d.f452428a;
                int f16 = dVar.f();
                h16 = this.mRightData.size() != 0 ? dVar.h() : 0;
                this.mRightData.add(StaggerItemData.INSTANCE.c(defaultJumpUrl));
                this.mRightContentHeight += f16 + h16;
                QLog.i("ZPlanStaggerContainerView_", 1, "insert empty item to right, defaultJumpUrl:" + defaultJumpUrl);
            }
        } else if (i26 > i19 && i26 - i19 >= i17 / 2) {
            d dVar2 = d.f452428a;
            int f17 = dVar2.f();
            h16 = this.mLeftData.size() != 0 ? dVar2.h() : 0;
            this.mLeftData.add(StaggerItemData.INSTANCE.c(defaultJumpUrl));
            this.mLeftContentHeight += f17 + h16;
            QLog.i("ZPlanStaggerContainerView_", 1, "insert empty item to left, defaultJumpUrl:" + defaultJumpUrl);
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.mLeftContentHeight, this.mRightContentHeight);
        this.mTotalContentHeight = coerceAtLeast;
        QLog.i("ZPlanStaggerContainerView_", 1, "splitData end, leftTotalHeight:" + this.mLeftContentHeight + ", rightTotalHeight:" + this.mRightContentHeight);
    }

    public /* synthetic */ ZPlanStaggerContainerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final int k(List<StaggerItemData> dataList, int targetHeight) {
        int i3 = 0;
        int i16 = 0;
        while (i3 < dataList.size() && i16 < targetHeight) {
            i16 += dataList.get(i3).getMeasureHeight();
            i3++;
        }
        return i3;
    }

    private final void m(boolean scrolling) {
        if (scrolling) {
            Iterator<StaggerItemContentContainer> it = this.mInScreenViews.iterator();
            while (it.hasNext()) {
                it.next().e();
            }
            return;
        }
        int b16 = u.INSTANCE.b(getContext());
        int i3 = b16 / 2;
        QLog.i("ZPlanStaggerContainerView_", 4, "handleFocusLogic mInScreenViews size:" + this.mInScreenViews.size() + ", screenHeight:" + b16);
        Iterator<StaggerItemContentContainer> it5 = this.mInScreenViews.iterator();
        StaggerItemContentContainer staggerItemContentContainer = null;
        int i16 = Integer.MAX_VALUE;
        while (it5.hasNext()) {
            StaggerItemContentContainer next = it5.next();
            Rect rect = new Rect();
            next.getGlobalVisibleRect(rect);
            int height = rect.height();
            int i17 = next.getLayoutParams().height;
            QLog.i("ZPlanStaggerContainerView_", 4, "itemHeight:" + i17 + ", visibleHeight:" + height);
            if (height >= i17 * 0.5d) {
                next.b(false);
                boolean c16 = next.c();
                int i18 = rect.top;
                int abs = Math.abs(i18 - i3);
                QLog.i("ZPlanStaggerContainerView_", 4, "distance:" + abs + ", top:" + i18 + ", currentDis:" + i16 + ", materialCanPlay:" + c16);
                if (c16 && i16 > abs) {
                    staggerItemContentContainer = next;
                    i16 = abs;
                }
            } else {
                next.e();
            }
        }
        if (staggerItemContentContainer != null) {
            staggerItemContentContainer.b(true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanStaggerContainerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        this.mLeftStaggerContainer = linearLayout;
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        this.mRightStaggerContainer = linearLayout2;
        this.mData = new ArrayList<>();
        this.mLeftData = new ArrayList<>();
        this.mRightData = new ArrayList<>();
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.mLeftContentHeight, this.mRightContentHeight);
        this.mTotalContentHeight = coerceAtLeast;
        this.mInScreenViews = new HashSet<>();
        this.mStaggerItemContentCache = new c(context);
        this.mScrollerListener = new b();
        this.mLastShowRecorder = new StaggerShowRecorder(0, 0, 0, 7, null);
        n();
    }

    private final int j(List<StaggerItemData> dataList, int targetIndex) {
        int coerceAtMost;
        int i3 = 0;
        if (targetIndex < 0) {
            return 0;
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(targetIndex, dataList.size() - 1);
        if (coerceAtMost >= 0) {
            int i16 = 0;
            while (true) {
                i3 += dataList.get(i16).getMeasureHeight();
                if (i16 != 0) {
                    i3 += d.f452428a.h();
                }
                if (i16 == coerceAtMost) {
                    break;
                }
                i16++;
            }
        }
        return i3;
    }

    static /* synthetic */ void t(ZPlanStaggerContainerView zPlanStaggerContainerView, a aVar, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        zPlanStaggerContainerView.s(aVar, z16, z17);
    }

    private final int i(a card, int index, List<StaggerItemData> dataList, int contentHeightBefore, int selfTop, LinearLayout staggerItemContainer, StaggerShowRecorder currentShowRecorder, int screenHeight, String containerName) {
        StaggerItemData staggerItemData = dataList.get(index);
        d dVar = d.f452428a;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dVar.m(), staggerItemData.getMeasureHeight());
        if (index != 0) {
            layoutParams.topMargin = dVar.h();
        }
        int i3 = contentHeightBefore + selfTop;
        int measureHeight = staggerItemData.getMeasureHeight() + i3;
        int i16 = contentHeightBefore + layoutParams.height + layoutParams.topMargin;
        View childAt = staggerItemContainer.getChildAt(index);
        StaggerItemContentContainer staggerItemContentContainer = childAt instanceof StaggerItemContentContainer ? (StaggerItemContentContainer) childAt : null;
        if (staggerItemContentContainer != null) {
            currentShowRecorder.f(currentShowRecorder.getViewReuseNum() + 1);
            staggerItemContentContainer.setLayoutParams(layoutParams);
            if (measureHeight >= 0 && i3 <= screenHeight) {
                boolean a16 = staggerItemContentContainer.a(card, staggerItemData, this.mData.indexOf(staggerItemData));
                QLog.d("ZPlanStaggerContainerView_", 4, "fillItemIntoContainer[reuse] bind container:" + containerName + ", pos:" + index);
                this.mInScreenViews.add(staggerItemContentContainer);
                if (a16) {
                    currentShowRecorder.d(currentShowRecorder.getViewBindNum() + 1);
                }
            }
            return i16;
        }
        currentShowRecorder.e(currentShowRecorder.getViewCreateNum() + 1);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        StaggerItemContentContainer staggerItemContentContainer2 = new StaggerItemContentContainer(context, this.mStaggerItemContentCache);
        staggerItemContentContainer2.setLayoutParams(layoutParams);
        staggerItemContainer.addView(staggerItemContentContainer2, layoutParams);
        if (measureHeight < 0 || i3 > screenHeight) {
            return i16;
        }
        boolean a17 = staggerItemContentContainer2.a(card, staggerItemData, this.mData.indexOf(staggerItemData));
        QLog.d("ZPlanStaggerContainerView_", 4, "fillItemIntoContainer[create] bind container:" + containerName + ", pos:" + index);
        this.mInScreenViews.add(staggerItemContentContainer2);
        if (!a17) {
            return i16;
        }
        currentShowRecorder.d(currentShowRecorder.getViewBindNum() + 1);
        return i16;
    }
}

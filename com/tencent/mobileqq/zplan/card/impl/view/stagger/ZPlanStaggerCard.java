package com.tencent.mobileqq.zplan.card.impl.view.stagger;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.card.impl.view.stagger.view.StaggerItemLabelContainer;
import com.tencent.mobileqq.zplan.card.impl.view.stagger.view.ZPlanStaggerContainerView;
import com.tencent.mobileqq.zplan.utils.aa;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.utils.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pv4.s;
import pv4.u;
import tl.h;
import zf3.StaggerItemData;
import zf3.StaggerLabelItemData;
import zf3.a;
import zf3.c;
import zf3.d;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 R2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001 B/\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010J\u001a\u00020I\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010N\u001a\u00020M\u0012\u0006\u0010O\u001a\u00020\u0015\u00a2\u0006\u0004\bP\u0010QJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J \u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u001e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\b\u0010 \u001a\u00020\u0013H\u0016J\b\u0010!\u001a\u00020\u0011H\u0016R$\u0010'\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R$\u0010)\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010&R$\u0010,\u001a\u0012\u0012\u0004\u0012\u00020*0\"j\b\u0012\u0004\u0012\u00020*`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010&R\u0016\u0010/\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/ZPlanStaggerCard;", "Lcom/tencent/sqshow/zootopia/card/base/ZootopiaBaseCard;", "Lzf3/a;", "Lzf3/c;", "Lyf3/a;", "", "E", "D", "H", "G", UserInfo.SEX_FEMALE, "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "viewParent", "Landroid/view/View;", ReportConstant.COSTREPORT_PREFIX, "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", "", "position", "totalCount", "f", "selectedPos", "", "idList", "g", "dx", h.F, "b", "a", "e", "Ljava/util/ArrayList;", "Lzf3/e;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Req, "Ljava/util/ArrayList;", "mAllStaggerItemList", ExifInterface.LATITUDE_SOUTH, "mCurrentShowingItemList", "Lzf3/f;", "T", "mLabelList", "U", "Lcom/tencent/sqshow/zootopia/data/c;", "mDataInfo", "V", "I", "mCardPos", "W", "mCurrentTabId", "Landroid/widget/LinearLayout;", "a0", "Landroid/widget/LinearLayout;", "mRootContent", "Landroid/widget/HorizontalScrollView;", "b0", "Landroid/widget/HorizontalScrollView;", "mTopScrollView", "Landroid/widget/FrameLayout;", "c0", "Landroid/widget/FrameLayout;", "mLabelContainer", "Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/StaggerItemLabelContainer;", "d0", "Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/StaggerItemLabelContainer;", "mLabelAreaContent", "Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/ZPlanStaggerContainerView;", "e0", "Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/ZPlanStaggerContainerView;", "mStaggerContainer", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "itemViewType", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;I)V", "f0", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanStaggerCard extends ZootopiaBaseCard implements a, c, yf3.a {

    /* renamed from: R, reason: from kotlin metadata */
    private final ArrayList<StaggerItemData> mAllStaggerItemList;

    /* renamed from: S, reason: from kotlin metadata */
    private final ArrayList<StaggerItemData> mCurrentShowingItemList;

    /* renamed from: T, reason: from kotlin metadata */
    private final ArrayList<StaggerLabelItemData> mLabelList;

    /* renamed from: U, reason: from kotlin metadata */
    private ZootopiaCardData mDataInfo;

    /* renamed from: V, reason: from kotlin metadata */
    private int mCardPos;

    /* renamed from: W, reason: from kotlin metadata */
    private int mCurrentTabId;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout mRootContent;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final HorizontalScrollView mTopScrollView;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final FrameLayout mLabelContainer;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final StaggerItemLabelContainer mLabelAreaContent;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private final ZPlanStaggerContainerView mStaggerContainer;

    private final void D() {
        d dVar = d.f452428a;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, dVar.q());
        layoutParams.leftMargin = dVar.i();
        this.mRootContent.addView(this.mTopScrollView, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, dVar.s());
        layoutParams2.gravity = 16;
        this.mTopScrollView.addView(this.mLabelContainer, layoutParams2);
        this.mLabelContainer.addView(this.mLabelAreaContent, new FrameLayout.LayoutParams(-1, -1));
    }

    private final void E() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(d.f452428a.l(), -2);
        layoutParams.topMargin = i.b(7);
        this.mRootContent.addView(this.mStaggerContainer, layoutParams);
    }

    private final void F() {
        this.mCurrentShowingItemList.clear();
        this.mLabelList.clear();
        H();
        G();
    }

    private final void G() {
        List<StaggerLabelItemData> emptyList;
        StaggerItemLabelContainer staggerItemLabelContainer = this.mLabelAreaContent;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        staggerItemLabelContainer.f(this, emptyList);
    }

    private final void H() {
        ZPlanStaggerContainerView zPlanStaggerContainerView = this.mStaggerContainer;
        u moreInfo = this.mDataInfo.getTitleData().getMoreInfo();
        String str = moreInfo != null ? moreInfo.f427703b : null;
        if (str == null) {
            str = "";
        }
        zPlanStaggerContainerView.p(this, str, this.mCurrentShowingItemList);
    }

    @Override // yf3.a
    /* renamed from: a, reason: from getter */
    public ZootopiaCardData getMDataInfo() {
        return this.mDataInfo;
    }

    @Override // yf3.a
    /* renamed from: b, reason: from getter */
    public int getMCardPos() {
        return this.mCardPos;
    }

    @Override // yf3.a
    public String e() {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.mLabelList, this.mCurrentTabId);
        StaggerLabelItemData staggerLabelItemData = (StaggerLabelItemData) orNull;
        if (staggerLabelItemData == null) {
            return "";
        }
        String str = staggerLabelItemData.getLabelBtnInfo().f427648f;
        Intrinsics.checkNotNullExpressionValue(str, "data.labelBtnInfo.id");
        return str;
    }

    @Override // l84.a
    public void f(ZootopiaCardData dataInfo, int position, int totalCount) {
        Intrinsics.checkNotNullParameter(dataInfo, "dataInfo");
        this.mCardPos = position;
        this.mDataInfo = dataInfo;
        d dVar = d.f452428a;
        if (dVar.l() != t74.u.INSTANCE.c(getContext())) {
            QLog.e("ZPlanStaggerCard_", 1, "bindItemInfo ScreenSizeChanged!!! ");
            dVar.t();
            this.mStaggerContainer.o();
        }
        List<s> c16 = dataInfo.c();
        if (c16 == null || c16.isEmpty()) {
            F();
            return;
        }
        aa a16 = aa.b().a();
        StaggerItemData.Companion companion = StaggerItemData.INSTANCE;
        List<s> c17 = dataInfo.c();
        Intrinsics.checkNotNull(c17);
        List<StaggerItemData> b16 = companion.b(c17);
        a16.d("ZPlanStaggerCard_-bindItemInfo-convert StaggerItemData List");
        this.mAllStaggerItemList.clear();
        this.mAllStaggerItemList.addAll(b16);
        List<StaggerLabelItemData> a17 = StaggerLabelItemData.INSTANCE.a(dataInfo.g());
        a16.d("ZPlanStaggerCard_-bindItemInfo-convert StaggerLabelItemData List");
        this.mLabelList.clear();
        this.mLabelList.addAll(a17);
        this.mLabelAreaContent.f(this, this.mLabelList);
        this.mLabelAreaContent.setObserver(this);
        this.mLabelAreaContent.setScroller(this);
        StaggerItemLabelContainer staggerItemLabelContainer = this.mLabelAreaContent;
        staggerItemLabelContainer.setSelectedItem(this, staggerItemLabelContainer.getMSelectedItem());
        a16.d("ZPlanStaggerCard_-bindItemInfo-setSelectedItem ");
    }

    @Override // zf3.a
    public void g(int selectedPos, List<Integer> idList) {
        Intrinsics.checkNotNullParameter(idList, "idList");
        this.mCurrentTabId = selectedPos;
        ArrayList<StaggerItemData> arrayList = this.mAllStaggerItemList;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (idList.contains(Integer.valueOf(((StaggerItemData) obj).getId()))) {
                arrayList2.add(obj);
            }
        }
        this.mCurrentShowingItemList.clear();
        this.mCurrentShowingItemList.addAll(arrayList2);
        ZPlanStaggerContainerView zPlanStaggerContainerView = this.mStaggerContainer;
        u moreInfo = this.mDataInfo.getTitleData().getMoreInfo();
        String str = moreInfo != null ? moreInfo.f427703b : null;
        if (str == null) {
            str = "";
        }
        zPlanStaggerContainerView.p(this, str, this.mCurrentShowingItemList);
    }

    @Override // zf3.c
    public void h(int dx5) {
        this.mTopScrollView.smoothScrollBy(dx5, 0);
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public View s(Context context, ViewGroup viewParent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewParent, "viewParent");
        D();
        E();
        viewParent.addView(this.mRootContent);
        return this.mRootContent;
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public String z() {
        return "ZPlanStaggerCard_";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanStaggerCard(Context context, LifecycleOwner owner, oa4.a mapResViewModel, ZootopiaSource sourceCurrent, int i3) {
        super(context, owner, mapResViewModel, sourceCurrent, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.mAllStaggerItemList = new ArrayList<>();
        this.mCurrentShowingItemList = new ArrayList<>();
        this.mLabelList = new ArrayList<>();
        this.mDataInfo = new ZootopiaCardData(0, 0, 0, 0, null, null, null, null, null, null, null, 0, null, null, null, 32764, null);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setBackground(new ColorDrawable(0));
        this.mRootContent = linearLayout;
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context);
        horizontalScrollView.setOverScrollMode(2);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        this.mTopScrollView = horizontalScrollView;
        this.mLabelContainer = new FrameLayout(context);
        this.mLabelAreaContent = new StaggerItemLabelContainer(context);
        this.mStaggerContainer = new ZPlanStaggerContainerView(context, null, 0, 6, null);
    }
}

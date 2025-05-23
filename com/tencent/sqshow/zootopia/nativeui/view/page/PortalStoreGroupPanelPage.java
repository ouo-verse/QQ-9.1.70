package com.tencent.sqshow.zootopia.nativeui.view.page;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.sqshow.zootopia.nativeui.data.title.PortalStorePanelCategoryData;
import com.tencent.sqshow.zootopia.nativeui.data.title.PortalStorePanelSectionData;
import com.tencent.sqshow.zootopia.nativeui.view.PortalStoreGroupPanelPageData;
import com.tencent.sqshow.zootopia.nativeui.view.page.a;
import com.tencent.sqshow.zootopia.nativeui.view.title.PortalStorePanelSectionView;
import com.tencent.sqshow.zootopia.widget.tab.BaseZPlanTabTitleData;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import n74.bx;
import uv4.ao;
import uv4.bg;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 S2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u00020\u00052\u00020\u0006:\u0001\u001fB/\b\u0007\u0012\u0006\u0010M\u001a\u00020L\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010N\u0012\b\b\u0002\u0010P\u001a\u00020\u0011\u0012\u0006\u0010-\u001a\u00020+\u00a2\u0006\u0004\bQ\u0010RJ\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J \u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0011H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016J\u0016\u0010%\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0011H\u0016J\b\u0010(\u001a\u00020\u0007H\u0016J\u0006\u0010)\u001a\u00020\u0011J\u0006\u0010*\u001a\u00020\u0011R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010/R\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u00102R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u00105R\u0016\u00109\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010:R\u0016\u0010D\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010CR\u001c\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010H0G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010J\u00a8\u0006T"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/page/PortalStoreGroupPanelPage;", "Landroid/widget/FrameLayout;", "Lcom/tencent/sqshow/zootopia/nativeui/view/page/a;", "", "Lcom/tencent/sqshow/zootopia/nativeui/view/PortalStoreGroupPanelPageData;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Lha4/a;", "", "p", "t", ReportConstant.COSTREPORT_PREFIX, "Luv4/ao;", "o", "k", "data", "setData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "getPosition", "position", "setPosition", "Landroid/view/View;", "getView", "", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "c", "a", "d", "f", tl.h.F, "categoryId", "typeId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "itemIndex", "b", "e", "l", DomainData.DOMAIN_NAME, "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "mChannel", "Ln74/bx;", "Ln74/bx;", "mBinding", "Ld94/e;", "Ld94/e;", "mAdapter", "Lha4/b;", "Lha4/b;", "mEntranceController", "i", "Lcom/tencent/sqshow/zootopia/nativeui/view/PortalStoreGroupPanelPageData;", "mData", "I", "mPosition", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "mPageIsShowing", "D", "mCurrentSelectedPos", "E", "Ljava/lang/String;", "mCurrentSelectedId", UserInfo.SEX_FEMALE, "mPendingTypeId", "Landroidx/lifecycle/Observer;", "Lcom/tencent/sqshow/zootopia/nativeui/data/title/PortalStorePanelCategoryData;", "G", "Landroidx/lifecycle/Observer;", "mCurCategoryCfgObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "H", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStoreGroupPanelPage extends FrameLayout implements a<String, PortalStoreGroupPanelPageData>, ViewPager.OnPageChangeListener, ha4.a {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mPageIsShowing;

    /* renamed from: D, reason: from kotlin metadata */
    private int mCurrentSelectedPos;

    /* renamed from: E, reason: from kotlin metadata */
    private String mCurrentSelectedId;

    /* renamed from: F, reason: from kotlin metadata */
    private String mPendingTypeId;

    /* renamed from: G, reason: from kotlin metadata */
    private final Observer<PortalStorePanelCategoryData> mCurCategoryCfgObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final bx mBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final d94.e mAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ha4.b mEntranceController;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private PortalStoreGroupPanelPageData mData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mPosition;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStoreGroupPanelPage(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j mChannel) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mChannel, "mChannel");
        this.mChannel = mChannel;
        bx f16 = bx.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        this.mAdapter = new d94.e(context, this.mChannel);
        this.mEntranceController = new ha4.b(this.mChannel, context);
        this.mData = new PortalStoreGroupPanelPageData(null, null, null, 0, false, null, 63, null);
        this.mPosition = -1;
        this.mCurrentSelectedPos = -1;
        this.mCurrentSelectedId = "";
        this.mPendingTypeId = "";
        this.mCurCategoryCfgObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.page.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PortalStoreGroupPanelPage.r(PortalStoreGroupPanelPage.this, (PortalStorePanelCategoryData) obj);
            }
        };
        f16.f418949e.Z(this.mChannel);
        f16.f418946b.d(this.mChannel);
        p();
    }

    private final void k() {
        this.mChannel.h().removeObserver(this.mCurCategoryCfgObserver);
    }

    private final ao o() {
        Object orNull;
        List<PortalStorePanelCategoryData> categoryList;
        Object orNull2;
        ao categoryCfg;
        PortalStorePanelCategoryData value = this.mChannel.h().getValue();
        if (value != null && (categoryCfg = value.getCategoryCfg()) != null) {
            return categoryCfg;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.mData.getSectionData(), this.mCurrentSelectedPos);
        PortalStorePanelSectionData portalStorePanelSectionData = (PortalStorePanelSectionData) orNull;
        if (portalStorePanelSectionData != null && (categoryList = portalStorePanelSectionData.getCategoryList()) != null) {
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(categoryList, 0);
            PortalStorePanelCategoryData portalStorePanelCategoryData = (PortalStorePanelCategoryData) orNull2;
            if (portalStorePanelCategoryData != null) {
                return portalStorePanelCategoryData.getCategoryCfg();
            }
        }
        return null;
    }

    private final void p() {
        LifecycleOwner lifecycleOwner = this.mChannel.getLifecycleOwner();
        if (lifecycleOwner == null) {
            return;
        }
        this.mChannel.h().observe(lifecycleOwner, this.mCurCategoryCfgObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(PortalStoreGroupPanelPage this$0, PortalStorePanelCategoryData portalStorePanelCategoryData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (portalStorePanelCategoryData != null) {
            this$0.s();
        }
    }

    private final void s() {
        ao o16 = o();
        if (o16 == null) {
            return;
        }
        if (this.mEntranceController.a(o16)) {
            this.mBinding.f418946b.g();
        } else {
            this.mBinding.f418946b.c();
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void a() {
        this.mAdapter.i();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void c() {
        Object orNull;
        if (this.mPageIsShowing) {
            QLog.w("PortalStoreGroupPanelPage_", 1, "pageShow type:" + this.mData.getIndex() + ", filtered!");
            return;
        }
        this.mPageIsShowing = true;
        QLog.i("PortalStoreGroupPanelPage_", 1, "pageShow type:" + this.mData.getIndex());
        d94.e eVar = this.mAdapter;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.mData.getSectionData(), this.mBinding.f418947c.getCurrentItem());
        eVar.j((BaseZPlanTabTitleData) orNull);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void d() {
        this.mBinding.f418949e.d0();
        this.mAdapter.h();
    }

    @Override // ha4.a
    public void e() {
        ao o16 = o();
        if (o16 == null) {
            return;
        }
        this.mEntranceController.e(o16, l());
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void f() {
        QLog.i("PortalStoreGroupPanelPage_", 1, "pageHide type:" + this.mData.getIndex());
        if (this.mPageIsShowing) {
            this.mBinding.f418949e.d0();
        }
        this.mPageIsShowing = false;
        this.mAdapter.j(null);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void g() {
        a.C9831a.a(this);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    /* renamed from: getPosition, reason: from getter */
    public int getMPosition() {
        return this.mPosition;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void h() {
        this.mBinding.f418949e.d0();
        this.mAdapter.destroy();
        k();
    }

    public final int l() {
        Integer currentOrderType = this.mChannel.getPanelSortData().getCurrentOrderType();
        if (currentOrderType != null) {
            return currentOrderType.intValue();
        }
        return n();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    /* renamed from: m, reason: from getter */
    public PortalStoreGroupPanelPageData getMData() {
        return this.mData;
    }

    public final int n() {
        Object orNull;
        bg sectionCfgV1;
        ao[] aoVarArr;
        Object orNull2;
        List list;
        Object orNull3;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.mData.getSectionData(), this.mCurrentSelectedPos);
        PortalStorePanelSectionData portalStorePanelSectionData = (PortalStorePanelSectionData) orNull;
        if (portalStorePanelSectionData == null || (sectionCfgV1 = portalStorePanelSectionData.getSectionCfgV1()) == null || (aoVarArr = sectionCfgV1.f440337g) == null) {
            return 0;
        }
        orNull2 = ArraysKt___ArraysKt.getOrNull(aoVarArr, 0);
        ao aoVar = (ao) orNull2;
        if (aoVar == null) {
            return 0;
        }
        int[] iArr = aoVar.f440194l;
        Intrinsics.checkNotNullExpressionValue(iArr, "categoryCfg.orderTypes");
        list = ArraysKt___ArraysKt.toList(iArr);
        orNull3 = CollectionsKt___CollectionsKt.getOrNull(list, 0);
        Integer num = (Integer) orNull3;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int position) {
        Object orNull;
        bg sectionCfgV1;
        this.mCurrentSelectedPos = position;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.mData.getSectionData(), position);
        PortalStorePanelSectionData portalStorePanelSectionData = (PortalStorePanelSectionData) orNull;
        String str = (portalStorePanelSectionData == null || (sectionCfgV1 = portalStorePanelSectionData.getSectionCfgV1()) == null) ? null : sectionCfgV1.f440331a;
        if (str == null) {
            str = "";
        }
        this.mCurrentSelectedId = str;
        this.mChannel.i().setValue(null);
        if (this.mPageIsShowing) {
            this.mAdapter.n(portalStorePanelSectionData, this.mPendingTypeId);
            this.mPendingTypeId = "";
            VideoReport.traversePage(this.mBinding.getMRv());
            return;
        }
        this.mAdapter.j(null);
    }

    public final void q(String categoryId, String typeId) {
        Object obj;
        int indexOf;
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        Intrinsics.checkNotNullParameter(typeId, "typeId");
        QLog.i("PortalStoreGroupPanelPage_", 1, "jumpToTargetPage categoryId:" + categoryId);
        Iterator<T> it = this.mData.getSectionData().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((PortalStorePanelSectionData) obj).getSectionCfgV1().f440331a, categoryId)) {
                    break;
                }
            }
        }
        indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends PortalStorePanelSectionData>) ((List<? extends Object>) this.mData.getSectionData()), (PortalStorePanelSectionData) obj);
        if (indexOf < 0) {
            return;
        }
        QLog.i("PortalStoreGroupPanelPage_", 1, "jumpToTargetPage targetIndex:" + indexOf);
        this.mPendingTypeId = typeId;
        this.mBinding.f418947c.setCurrentItem(indexOf);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void setPosition(int position) {
        this.mPosition = position;
    }

    private final void t() {
        Object obj;
        Object obj2;
        int indexOf;
        setMotionEventSplittingEnabled(false);
        String str = this.mData.getStoreGrpupCfgV1().f440271g;
        Iterator<T> it = this.mData.getSectionData().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            } else {
                obj2 = it.next();
                if (Intrinsics.areEqual(((PortalStorePanelSectionData) obj2).getSectionCfgV1().f440331a, str)) {
                    break;
                }
            }
        }
        PortalStorePanelSectionData portalStorePanelSectionData = (PortalStorePanelSectionData) obj2;
        Iterator<T> it5 = this.mData.getSectionData().iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            if (Intrinsics.areEqual(((PortalStorePanelSectionData) next).getSectionCfgV1().f440331a, this.mCurrentSelectedId)) {
                obj = next;
                break;
            }
        }
        PortalStorePanelSectionData portalStorePanelSectionData2 = (PortalStorePanelSectionData) obj;
        if (portalStorePanelSectionData2 != null) {
            indexOf = this.mData.getSectionData().indexOf(portalStorePanelSectionData2);
        } else {
            indexOf = portalStorePanelSectionData == null ? 0 : this.mData.getSectionData().indexOf(portalStorePanelSectionData);
        }
        this.mCurrentSelectedPos = indexOf;
        this.mChannel.j().postValue(this.mData.getSectionData().get(this.mCurrentSelectedPos));
        this.mBinding.f418946b.setClickListener(this);
        this.mBinding.f418949e.o(this.mChannel.getLifecycleOwner());
        this.mBinding.f418949e.setTitleData(this.mData.getSectionData(), indexOf);
        bx bxVar = this.mBinding;
        PortalStorePanelSectionView portalStorePanelSectionView = bxVar.f418949e;
        HorizontalScrollView horizontalScrollView = bxVar.f418948d;
        Intrinsics.checkNotNullExpressionValue(horizontalScrollView, "mBinding.sectionScrollview");
        portalStorePanelSectionView.p(horizontalScrollView, 0);
        this.mBinding.f418947c.setAdapter(this.mAdapter);
        this.mBinding.f418947c.removeOnPageChangeListener(this);
        this.mBinding.f418947c.addOnPageChangeListener(this);
        this.mAdapter.k(this.mData.getSectionData());
        bx bxVar2 = this.mBinding;
        PortalStorePanelSectionView portalStorePanelSectionView2 = bxVar2.f418949e;
        ViewPager viewPager = bxVar2.f418947c;
        Intrinsics.checkNotNullExpressionValue(viewPager, "mBinding.panelViewPager");
        portalStorePanelSectionView2.b(viewPager);
        this.mBinding.f418947c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.page.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PortalStoreGroupPanelPage.u(view);
            }
        });
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(View view) {
        QLog.i("PortalStoreGroupPanelPage_", 1, "panelViewPager clicked");
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void setData(PortalStoreGroupPanelPageData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (Intrinsics.areEqual(this.mData, data)) {
            return;
        }
        this.mData = data;
        t();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public View getView() {
        return this;
    }

    @Override // ha4.a
    public void b(int itemIndex) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int state) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }
}

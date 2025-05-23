package com.tencent.mobileqq.zootopia.portal.detail.v2;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.portal.detail.ZootopiaDetailFragment;
import com.tencent.mobileqq.zootopia.portal.detail.ah;
import com.tencent.mobileqq.zootopia.portal.detail.am;
import com.tencent.mobileqq.zootopia.portal.detail.main.ZootopiaDetailMainFragment;
import com.tencent.mobileqq.zootopia.portal.detail.rank.ZootopiaDetailRankFragment;
import com.tencent.mobileqq.zootopia.view.ZootopiaSelfRankFloatBar;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaMapTab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import xc3.b;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 k2\u00020\u0001:\u0002lmB\u0019\u0012\u0006\u0010f\u001a\u00020e\u0012\b\u0010h\u001a\u0004\u0018\u00010g\u00a2\u0006\u0004\bi\u0010jJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002JL\u0010\u001d\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\fJ6\u0010)\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\fJ\u0012\u0010,\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010-\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010.\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010*H\u0016R$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR$\u0010Q\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u0018\u0010Z\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u001c\u0010^\u001a\b\u0018\u00010[R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\"\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010c\u00a8\u0006n"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailTabViewPager;", "Landroidx/viewpager/widget/ViewPager;", "", "enableGesture", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "l", "Lxc3/b;", "rankFragment", "Lcom/tencent/sqshow/zootopia/data/n;", "tab", "", "position", "k", "Lcom/tencent/mobileqq/zootopia/portal/detail/am;", "vm", "Loa4/a;", "mapResVm", "Lcom/tencent/mobileqq/zootopia/portal/detail/ah;", "reportHelper", "Lcom/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailV2HeaderView;", "headerView", "Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragment$Config;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/zootopia/view/ZootopiaSelfRankFloatBar;", "rankBootFloatBar", "Lxc3/a;", HippyNestedScrollComponent.PRIORITY_PARENT, "i", com.tencent.luggage.wxa.c8.c.G, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/fragment/app/FragmentManager;", "fm", "", "mapTabList", "Lcom/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailTabView;", "contentViewpagerTitleLayout", "Landroid/view/View;", "appBarContainer", "appBarNormalMinHeight", "setDataTem", "Landroid/view/MotionEvent;", "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onTouchEvent", "dispatchTouchEvent", "d", "Lcom/tencent/mobileqq/zootopia/portal/detail/am;", "r", "()Lcom/tencent/mobileqq/zootopia/portal/detail/am;", "setVm", "(Lcom/tencent/mobileqq/zootopia/portal/detail/am;)V", "e", "Loa4/a;", "o", "()Loa4/a;", "setMapResVm", "(Loa4/a;)V", "f", "Lcom/tencent/mobileqq/zootopia/portal/detail/ah;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/zootopia/portal/detail/ah;", "setReportHelper", "(Lcom/tencent/mobileqq/zootopia/portal/detail/ah;)V", h.F, "Lcom/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailV2HeaderView;", "getHeaderView", "()Lcom/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailV2HeaderView;", "setHeaderView", "(Lcom/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailV2HeaderView;)V", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaSelfRankFloatBar;", "p", "()Lcom/tencent/mobileqq/zootopia/view/ZootopiaSelfRankFloatBar;", "setRankBootFloatBar", "(Lcom/tencent/mobileqq/zootopia/view/ZootopiaSelfRankFloatBar;)V", "Lxc3/a;", "getViewpagerParent", "()Lxc3/a;", "setViewpagerParent", "(Lxc3/a;)V", "viewpagerParent", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragment$Config;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragment$Config;", "setConfig", "(Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragment$Config;)V", "D", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "topGestureLayout", "Lcom/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailTabViewPager$c;", "E", "Lcom/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailTabViewPager$c;", "viewPagerAdapter", UserInfo.SEX_FEMALE, "Ljava/util/List;", "", "G", "Ljava/util/Map;", "tabFragmentMap", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "H", "b", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDetailTabViewPager extends ViewPager {
    private static final String I = "ViewPagerAdapter";

    /* renamed from: C, reason: from kotlin metadata */
    private ZootopiaDetailFragment.Config config;

    /* renamed from: D, reason: from kotlin metadata */
    private TopGestureLayout topGestureLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private c viewPagerAdapter;

    /* renamed from: F, reason: from kotlin metadata */
    private List<ZootopiaMapTab> mapTabList;

    /* renamed from: G, reason: from kotlin metadata */
    private Map<Integer, b> tabFragmentMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private am vm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private oa4.a mapResVm;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ah reportHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ZootopiaDetailV2HeaderView headerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ZootopiaSelfRankFloatBar rankBootFloatBar;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private xc3.a viewpagerParent;

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\u0012\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0016H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailTabViewPager$c;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "Lcom/tencent/mobileqq/zootopia/portal/detail/main/ZootopiaDetailMainFragment;", "d", "", "getCount", "position", "Landroidx/fragment/app/Fragment;", "getItem", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "", "instantiateItem", "object", "", "destroyItem", "", "getPageWidth", "setPrimaryItem", "obj", "getItemPosition", "startUpdate", "Landroid/view/View;", "finishUpdate", "Landroidx/fragment/app/Fragment;", "mCurrentPrimaryItem", "", "e", "Z", "mHasFinishUpdate", "Landroidx/fragment/app/FragmentManager;", "fm", "<init>", "(Lcom/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailTabViewPager;Landroidx/fragment/app/FragmentManager;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    private final class c extends FragmentStatePagerAdapter {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private Fragment mCurrentPrimaryItem;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean mHasFinishUpdate;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ZootopiaDetailTabViewPager f328856f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ZootopiaDetailTabViewPager zootopiaDetailTabViewPager, FragmentManager fm5) {
            super(fm5);
            Intrinsics.checkNotNullParameter(fm5, "fm");
            this.f328856f = zootopiaDetailTabViewPager;
        }

        private final ZootopiaDetailMainFragment d() {
            ZootopiaDetailMainFragment zootopiaDetailMainFragment = new ZootopiaDetailMainFragment();
            zootopiaDetailMainFragment.Qh(this.f328856f.getVm(), this.f328856f.getMapResVm(), this.f328856f.getReportHelper(), this.f328856f.getConfig());
            return zootopiaDetailMainFragment;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int position, Object object) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(object, "object");
            if (QLog.isColorLevel()) {
                QLog.d(ZootopiaDetailTabViewPager.I, 2, "destroyItem() called with: container = [" + container + "], position = [" + position + "], object = [" + object + "]");
            }
            super.destroyItem(container, position, object);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(View container) {
            Intrinsics.checkNotNullParameter(container, "container");
            super.finishUpdate(container);
            this.mHasFinishUpdate = true;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return Math.max(this.f328856f.mapTabList.size(), 1);
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int position) {
            if (position < this.f328856f.mapTabList.size()) {
                ZootopiaMapTab zootopiaMapTab = (ZootopiaMapTab) this.f328856f.mapTabList.get(position);
                if (zootopiaMapTab.getType() == 1) {
                    if (zootopiaMapTab.h()) {
                        ZootopiaDetailRankFragment zootopiaDetailRankFragment = new ZootopiaDetailRankFragment();
                        zootopiaDetailRankFragment.Wh(this.f328856f.getRankBootFloatBar());
                        this.f328856f.k(zootopiaDetailRankFragment, zootopiaMapTab, position);
                        this.f328856f.tabFragmentMap.put(Integer.valueOf(position), zootopiaDetailRankFragment);
                        return zootopiaDetailRankFragment;
                    }
                    ZootopiaDetailMainFragment zootopiaDetailMainFragment = new ZootopiaDetailMainFragment();
                    zootopiaDetailMainFragment.Qh(this.f328856f.getVm(), this.f328856f.getMapResVm(), this.f328856f.getReportHelper(), this.f328856f.getConfig());
                    this.f328856f.k(zootopiaDetailMainFragment, zootopiaMapTab, position);
                    this.f328856f.tabFragmentMap.put(Integer.valueOf(position), zootopiaDetailMainFragment);
                    return zootopiaDetailMainFragment;
                }
                return d();
            }
            return d();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            if (!(obj instanceof b)) {
                return -2;
            }
            b bVar = (b) obj;
            if (bVar.getTabPos() >= this.f328856f.mapTabList.size()) {
                return -2;
            }
            ZootopiaMapTab zootopiaMapTab = (ZootopiaMapTab) this.f328856f.mapTabList.get(bVar.getTabPos());
            ZootopiaMapTab mapTabInfo = bVar.getMapTabInfo();
            boolean z16 = false;
            if (mapTabInfo != null && zootopiaMapTab.getTabId() == mapTabInfo.getTabId()) {
                z16 = true;
            }
            if (!z16) {
                return -2;
            }
            String tabName = zootopiaMapTab.getTabName();
            ZootopiaMapTab mapTabInfo2 = bVar.getMapTabInfo();
            return TextUtils.equals(tabName, mapTabInfo2 != null ? mapTabInfo2.getTabName() : null) ? -1 : -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public float getPageWidth(int position) {
            return super.getPageWidth(position);
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup container, int position) {
            Intrinsics.checkNotNullParameter(container, "container");
            if (QLog.isColorLevel()) {
                QLog.d(ZootopiaDetailTabViewPager.I, 2, "instantiateItem() called with: container = [" + container + "], position = [" + position + "]");
            }
            Object instantiateItem = super.instantiateItem(container, position);
            Intrinsics.checkNotNullExpressionValue(instantiateItem, "super.instantiateItem(container, position)");
            return instantiateItem;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup container, int position, Object object) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(object, "object");
            super.setPrimaryItem(container, position, object);
            this.mCurrentPrimaryItem = (Fragment) object;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void startUpdate(ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            super.startUpdate(container);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaDetailTabViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mapTabList = new ArrayList();
        this.tabFragmentMap = new LinkedHashMap();
        addOnPageChangeListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(b rankFragment, ZootopiaMapTab tab, int position) {
        am amVar = this.vm;
        rankFragment.r7(amVar != null ? amVar.T1() : 0, tab, position, this.mapTabList.size());
        rankFragment.zd(this.viewpagerParent);
    }

    private final TopGestureLayout l() {
        TopGestureLayout topGestureLayout = this.topGestureLayout;
        if (topGestureLayout != null) {
            return topGestureLayout;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return null;
        }
        View decorView = activity.getWindow().getDecorView();
        ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        KeyEvent.Callback callback = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            callback = viewGroup.getChildAt(i3);
            boolean z16 = callback instanceof DragFrameLayout;
            if (z16) {
                DragFrameLayout dragFrameLayout = z16 ? (DragFrameLayout) callback : null;
                callback = dragFrameLayout != null ? dragFrameLayout.getChildAt(0) : null;
            }
            if (callback instanceof TopGestureLayout) {
                break;
            }
        }
        TopGestureLayout topGestureLayout2 = callback instanceof TopGestureLayout ? (TopGestureLayout) callback : null;
        this.topGestureLayout = topGestureLayout2;
        return topGestureLayout2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(boolean enableGesture) {
        TopGestureLayout l3 = l();
        if (l3 != null) {
            l3.setInterceptTouchFlag(enableGesture);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev5) {
        return super.dispatchTouchEvent(ev5);
    }

    public final void i(am vm5, oa4.a mapResVm, ah reportHelper, ZootopiaDetailV2HeaderView headerView, ZootopiaDetailFragment.Config config, ZootopiaSelfRankFloatBar rankBootFloatBar, xc3.a parent) {
        this.vm = vm5;
        this.mapResVm = mapResVm;
        this.reportHelper = reportHelper;
        this.headerView = headerView;
        this.config = config;
        this.rankBootFloatBar = rankBootFloatBar;
        this.viewpagerParent = parent;
        QLog.i(I, 1, "bindParam - " + (vm5 != null ? Integer.valueOf(vm5.T1()) : null));
    }

    public final b m(int pos) {
        return this.tabFragmentMap.get(Integer.valueOf(pos));
    }

    /* renamed from: n, reason: from getter */
    public final ZootopiaDetailFragment.Config getConfig() {
        return this.config;
    }

    /* renamed from: o, reason: from getter */
    public final oa4.a getMapResVm() {
        return this.mapResVm;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev5) {
        try {
            return super.onInterceptTouchEvent(ev5);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent ev5) {
        try {
            return super.onTouchEvent(ev5);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    /* renamed from: p, reason: from getter */
    public final ZootopiaSelfRankFloatBar getRankBootFloatBar() {
        return this.rankBootFloatBar;
    }

    /* renamed from: q, reason: from getter */
    public final ah getReportHelper() {
        return this.reportHelper;
    }

    /* renamed from: r, reason: from getter */
    public final am getVm() {
        return this.vm;
    }

    public final void setConfig(ZootopiaDetailFragment.Config config) {
        this.config = config;
    }

    public final void setDataTem(FragmentManager fm5, List<ZootopiaMapTab> mapTabList, ZootopiaDetailTabView contentViewpagerTitleLayout, View appBarContainer, int appBarNormalMinHeight) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(fm5, "fm");
        Intrinsics.checkNotNullParameter(contentViewpagerTitleLayout, "contentViewpagerTitleLayout");
        Intrinsics.checkNotNullParameter(appBarContainer, "appBarContainer");
        this.mapTabList = mapTabList == null ? new ArrayList<>() : mapTabList;
        c cVar = this.viewPagerAdapter;
        if (cVar == null) {
            c cVar2 = new c(this, fm5);
            this.viewPagerAdapter = cVar2;
            setAdapter(cVar2);
        } else if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
        List<ZootopiaMapTab> list = mapTabList;
        if (!(list == null || list.isEmpty()) && mapTabList.size() >= 2) {
            contentViewpagerTitleLayout.setVisibility(0);
            List<ZootopiaMapTab> list2 = mapTabList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((ZootopiaMapTab) it.next()).getTabName());
            }
            contentViewpagerTitleLayout.setMapTabList(mapTabList);
            contentViewpagerTitleLayout.setData(arrayList, 0);
        } else {
            contentViewpagerTitleLayout.setVisibility(8);
        }
        if (contentViewpagerTitleLayout.getVisibility() != 0) {
            appBarNormalMinHeight = 0;
        }
        if (appBarContainer.getMinimumHeight() != appBarNormalMinHeight) {
            appBarContainer.setMinimumHeight(appBarNormalMinHeight);
        }
    }

    public final void setHeaderView(ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView) {
        this.headerView = zootopiaDetailV2HeaderView;
    }

    public final void setMapResVm(oa4.a aVar) {
        this.mapResVm = aVar;
    }

    public final void setRankBootFloatBar(ZootopiaSelfRankFloatBar zootopiaSelfRankFloatBar) {
        this.rankBootFloatBar = zootopiaSelfRankFloatBar;
    }

    public final void setReportHelper(ah ahVar) {
        this.reportHelper = ahVar;
    }

    public final void setViewpagerParent(xc3.a aVar) {
        this.viewpagerParent = aVar;
    }

    public final void setVm(am amVar) {
        this.vm = amVar;
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailTabViewPager$a", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            ZootopiaDetailTabViewPager.this.s(position == 0);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }
}

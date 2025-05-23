package com.tencent.now.linkpkanchorplay.rankpkhistory.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.now.app.common.widget.BaseViewPager;
import com.tencent.now.linkpkanchorplay.invite.model.AnchorTabPageContext;
import com.tencent.now.linkpkanchorplay.rankpkhistory.view.RankPKHistoryTitleTabData;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u00013B=\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u0012\u0006\u0010\"\u001a\u00020 \u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060-\u00a2\u0006\u0004\b0\u00101J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u001c\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019R\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00064"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/rankpkhistory/view/c;", "Landroidx/viewpager/widget/PagerAdapter;", "Landroidx/lifecycle/ViewModelStoreOwner;", "viewModelStoreOwner", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/now/linkpkanchorplay/rankpkhistory/view/RankPKHistoryTitleTabData;", "tabInfo", "Landroid/view/View;", "d", "", "getCount", "view", "", "object", "", "isViewFromObject", "position", "", "getPageTitle", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "instantiateItem", "Lcom/tencent/now/app/common/widget/BaseViewPager;", "viewPager", "", "tabsInfo", "", "e", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/tencent/now/linkpkanchorplay/event/b;", "Lcom/tencent/now/linkpkanchorplay/event/b;", "eventTrigger", "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "f", "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "pageContext", h.F, "Landroidx/lifecycle/ViewModelStoreOwner;", "getViewModelStoreOwner", "()Landroidx/lifecycle/ViewModelStoreOwner;", "i", "Landroidx/lifecycle/LifecycleOwner;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "<init>", "(Landroid/content/Context;Lcom/tencent/now/linkpkanchorplay/event/b;Lcom/tencent/now/linkpkanchorplay/invite/model/a;Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/lifecycle/LifecycleOwner;Ljava/util/List;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c extends PagerAdapter {

    @NotNull
    private static Map<RankPKHistoryTitleTabData.TabId, View> D = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.now.linkpkanchorplay.event.b eventTrigger;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AnchorTabPageContext pageContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewModelStoreOwner viewModelStoreOwner;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<RankPKHistoryTitleTabData> tabsInfo;

    public c(@NotNull Context context, @NotNull com.tencent.now.linkpkanchorplay.event.b eventTrigger, @NotNull AnchorTabPageContext pageContext, @NotNull ViewModelStoreOwner viewModelStoreOwner, @NotNull LifecycleOwner lifecycleOwner, @NotNull List<RankPKHistoryTitleTabData> tabsInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(eventTrigger, "eventTrigger");
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(tabsInfo, "tabsInfo");
        this.context = context;
        this.eventTrigger = eventTrigger;
        this.pageContext = pageContext;
        this.viewModelStoreOwner = viewModelStoreOwner;
        this.lifecycleOwner = lifecycleOwner;
        this.tabsInfo = tabsInfo;
    }

    private final View d(ViewModelStoreOwner viewModelStoreOwner, LifecycleOwner lifecycleOwner, RankPKHistoryTitleTabData tabInfo) {
        ViewModel viewModel = new ViewModelProvider(viewModelStoreOwner).get(wm3.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(viewMo\u2026oryViewModel::class.java)");
        return new RankPKHistoryPage(this.context, this.pageContext.getRoomInfo().getRoomID(), tabInfo, lifecycleOwner, (wm3.a) viewModel);
    }

    public final void e(@NotNull BaseViewPager viewPager, @NotNull List<RankPKHistoryTitleTabData> tabsInfo) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        Intrinsics.checkNotNullParameter(tabsInfo, "tabsInfo");
        this.tabsInfo.clear();
        this.tabsInfo.addAll(tabsInfo);
        int size = tabsInfo.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (tabsInfo.get(i3).getSelected()) {
                viewPager.setCurrentItem(i3);
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.tabsInfo.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public CharSequence getPageTitle(int position) {
        return this.tabsInfo.get(position).getTabTitle();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Object instantiateItem(@NotNull ViewGroup container, int position) {
        Intrinsics.checkNotNullParameter(container, "container");
        View view = D.get(this.tabsInfo.get(position).getTabID());
        if (view == null) {
            view = d(this.viewModelStoreOwner, this.lifecycleOwner, this.tabsInfo.get(position));
            D.get(this.tabsInfo.get(position).getTabID());
        }
        container.addView(view);
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NotNull View view, @NotNull Object object) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(object, "object");
        return Intrinsics.areEqual(view, object);
    }
}

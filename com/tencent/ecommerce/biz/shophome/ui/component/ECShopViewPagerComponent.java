package com.tencent.ecommerce.biz.shophome.ui.component;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeCategoryListFragment;
import com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListFragment;
import com.tencent.ecommerce.biz.shophome.model.ECShopTabInfo;
import com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\n,B;\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\"\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0014R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopViewPagerComponent;", "Lcom/tencent/ecommerce/biz/shophome/ui/component/IECShopHomeComponent;", "", "c", "Landroid/view/View;", "getComponentView", "Lcom/tencent/ecommerce/biz/shophome/model/d;", "tabInfo", "d", "Landroidx/viewpager2/widget/ViewPager2;", "a", "Landroidx/viewpager2/widget/ViewPager2;", "componentView", "b", "Lcom/tencent/ecommerce/biz/shophome/model/d;", "selectedTabInfo", "Lcom/tencent/ecommerce/biz/shophome/fragment/ECShopHomeProductListFragment;", "Lcom/tencent/ecommerce/biz/shophome/fragment/ECShopHomeProductListFragment;", "productListFragment", "Lcom/tencent/ecommerce/biz/shophome/fragment/ECShopHomeCategoryListFragment;", "Lcom/tencent/ecommerce/biz/shophome/fragment/ECShopHomeCategoryListFragment;", "categoryListFragment", "Landroid/os/Bundle;", "e", "Landroid/os/Bundle;", "fragmentArguments", "Landroid/content/Context;", "f", "Landroid/content/Context;", "context", "Landroidx/fragment/app/FragmentActivity;", "g", "Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "", h.F, "Ljava/util/List;", "tabInfoList", "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopViewPagerComponent$IViewPagerChangeListener;", "i", "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopViewPagerComponent$IViewPagerChangeListener;", "viewPagerChangeListener", "<init>", "(Landroid/os/Bundle;Landroid/content/Context;Landroidx/fragment/app/FragmentActivity;Ljava/util/List;Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopViewPagerComponent$IViewPagerChangeListener;)V", "IViewPagerChangeListener", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopViewPagerComponent implements IECShopHomeComponent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ViewPager2 componentView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ECShopTabInfo selectedTabInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ECShopHomeProductListFragment productListFragment;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ECShopHomeCategoryListFragment categoryListFragment;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Bundle fragmentArguments;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final FragmentActivity fragmentActivity;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final List<ECShopTabInfo> tabInfoList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private IViewPagerChangeListener viewPagerChangeListener;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopViewPagerComponent$IViewPagerChangeListener;", "", "", "position", "Lcom/tencent/ecommerce/biz/shophome/model/d;", "tabInfo", "", "onPageSelected", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public interface IViewPagerChangeListener {
        void onPageSelected(int position, ECShopTabInfo tabInfo);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/shophome/ui/component/ECShopViewPagerComponent$b", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends ViewPager2.OnPageChangeCallback {
        b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            IViewPagerChangeListener iViewPagerChangeListener;
            super.onPageSelected(position);
            if (position >= ECShopViewPagerComponent.this.tabInfoList.size() || (iViewPagerChangeListener = ECShopViewPagerComponent.this.viewPagerChangeListener) == null) {
                return;
            }
            iViewPagerChangeListener.onPageSelected(position, (ECShopTabInfo) ECShopViewPagerComponent.this.tabInfoList.get(position));
        }
    }

    public ECShopViewPagerComponent(Bundle bundle, Context context, FragmentActivity fragmentActivity, List<ECShopTabInfo> list, IViewPagerChangeListener iViewPagerChangeListener) {
        this.fragmentArguments = bundle;
        this.context = context;
        this.fragmentActivity = fragmentActivity;
        this.tabInfoList = list;
        this.viewPagerChangeListener = iViewPagerChangeListener;
        this.componentView = new ViewPager2(context);
        c();
    }

    private final void c() {
        List listOf;
        if (!this.tabInfoList.isEmpty()) {
            this.selectedTabInfo = this.tabInfoList.get(0);
        }
        this.componentView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.componentView.setOrientation(0);
        this.componentView.setBackgroundColor(ECSkin.INSTANCE.getColor(R.color.f6491p));
        this.componentView.registerOnPageChangeCallback(new b());
        ECShopHomeProductListFragment eCShopHomeProductListFragment = new ECShopHomeProductListFragment();
        eCShopHomeProductListFragment.setArguments(this.fragmentArguments);
        Unit unit = Unit.INSTANCE;
        this.productListFragment = eCShopHomeProductListFragment;
        ECShopHomeCategoryListFragment eCShopHomeCategoryListFragment = new ECShopHomeCategoryListFragment();
        eCShopHomeCategoryListFragment.setArguments(this.fragmentArguments);
        this.categoryListFragment = eCShopHomeCategoryListFragment;
        ViewPager2 viewPager2 = this.componentView;
        List<ECShopTabInfo> list = this.tabInfoList;
        ECBaseFragment[] eCBaseFragmentArr = new ECBaseFragment[2];
        ECShopHomeProductListFragment eCShopHomeProductListFragment2 = this.productListFragment;
        if (eCShopHomeProductListFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productListFragment");
        }
        eCBaseFragmentArr[0] = eCShopHomeProductListFragment2;
        ECShopHomeCategoryListFragment eCShopHomeCategoryListFragment2 = this.categoryListFragment;
        if (eCShopHomeCategoryListFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryListFragment");
        }
        eCBaseFragmentArr[1] = eCShopHomeCategoryListFragment2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) eCBaseFragmentArr);
        viewPager2.setAdapter(new a(list, listOf, this.fragmentActivity, this.fragmentArguments));
    }

    public final void d(ECShopTabInfo tabInfo) {
        ECShopTabInfo eCShopTabInfo = this.selectedTabInfo;
        if (Intrinsics.areEqual(eCShopTabInfo != null ? eCShopTabInfo.id : null, tabInfo.id)) {
            return;
        }
        Iterator<T> it = this.tabInfoList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((ECShopTabInfo) it.next()).id, tabInfo.id)) {
                this.selectedTabInfo = tabInfo;
                this.componentView.setCurrentItem(i3, true);
            }
            i3++;
        }
    }

    @Override // com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent
    public View getComponentView() {
        return this.componentView;
    }

    @Override // com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent
    public void setComponentViewVisibility(int i3) {
        IECShopHomeComponent.a.a(this, i3);
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B5\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopViewPagerComponent$a;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", "", "Lcom/tencent/ecommerce/biz/shophome/model/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "tabInfoList", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", BdhLogUtil.LogTag.Tag_Conn, "fragmentList", "Landroid/os/Bundle;", "D", "Landroid/os/Bundle;", "fragmentArguments", "Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "<init>", "(Ljava/util/List;Ljava/util/List;Landroidx/fragment/app/FragmentActivity;Landroid/os/Bundle;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a extends FragmentStateAdapter {

        /* renamed from: C, reason: from kotlin metadata */
        private final List<ECBaseFragment> fragmentList;

        /* renamed from: D, reason: from kotlin metadata */
        private final Bundle fragmentArguments;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final List<ECShopTabInfo> tabInfoList;

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<ECShopTabInfo> list, List<? extends ECBaseFragment> list2, FragmentActivity fragmentActivity, Bundle bundle) {
            super(fragmentActivity);
            this.tabInfoList = list;
            this.fragmentList = list2;
            this.fragmentArguments = bundle;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.tabInfoList.size();
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int position) {
            if (position >= 0 && position < this.fragmentList.size()) {
                return this.fragmentList.get(position);
            }
            ECShopHomeProductListFragment eCShopHomeProductListFragment = new ECShopHomeProductListFragment();
            eCShopHomeProductListFragment.setArguments(this.fragmentArguments);
            return eCShopHomeProductListFragment;
        }
    }
}

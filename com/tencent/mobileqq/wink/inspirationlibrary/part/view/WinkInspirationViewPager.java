package com.tencent.mobileqq.wink.inspirationlibrary.part.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.inspirationlibrary.part.WinkInspirationTemplateUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 32\u00020\u00012\u00020\u00022\u00020\u0003:\u000245B%\b\u0007\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\"\u0010\f\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J \u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0014H\u0016R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationViewPager;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/a;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "initView", "A0", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "categories", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationTemplateCategoryView;", "pages", "setData", "", "showLine", "z0", "showDynamicCover", "K", "refresh", "release", "", "position", "", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationTemplateUtils$Companion$SIZE;", "d", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationTemplateUtils$Companion$SIZE;", "templateSize", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationPageTabBar;", "e", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationPageTabBar;", "tabLayout", "Landroidx/viewpager/widget/ViewPager;", "f", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationViewPager$a;", tl.h.F, "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationViewPager$a;", "adapter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationTemplateUtils$Companion$SIZE;Landroid/util/AttributeSet;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes21.dex */
public final class WinkInspirationViewPager extends ConstraintLayout implements com.tencent.mobileqq.wink.inspirationlibrary.part.view.a, ViewPager.OnPageChangeListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkInspirationTemplateUtils.Companion.SIZE templateSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkInspirationPageTabBar tabLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewPager viewPager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a adapter;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f323063i;

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\rH\u0016J \u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001eR\u0016\u0010 \u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationViewPager$a;", "Landroidx/viewpager/widget/PagerAdapter;", "", "show", "", tl.h.F, "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "categories", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationTemplateCategoryView;", "pages", "e", "g", "", "position", "f", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "", "instantiateItem", "categoryView", "destroyItem", "Landroid/view/View;", "view", "obj", "isViewFromObject", "getCount", "", "d", "Ljava/util/List;", "()Ljava/util/List;", "I", "selectedPosition", "<init>", "()V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends PagerAdapter {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<WinkInspirationTemplateCategoryView> pages = new ArrayList();

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int selectedPosition;

        private final void h(boolean show) {
            int i3 = 0;
            for (Object obj : this.pages) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                WinkInspirationTemplateCategoryView winkInspirationTemplateCategoryView = (WinkInspirationTemplateCategoryView) obj;
                if (i3 == this.selectedPosition) {
                    winkInspirationTemplateCategoryView.K(show);
                } else {
                    winkInspirationTemplateCategoryView.K(false);
                }
                i3 = i16;
            }
        }

        @NotNull
        public final List<WinkInspirationTemplateCategoryView> d() {
            return this.pages;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object categoryView) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(categoryView, "categoryView");
            container.removeView((WinkInspirationTemplateCategoryView) categoryView);
        }

        public final void e(@NotNull List<MetaCategory> categories, @NotNull List<WinkInspirationTemplateCategoryView> pages) {
            Intrinsics.checkNotNullParameter(categories, "categories");
            Intrinsics.checkNotNullParameter(pages, "pages");
            this.pages.clear();
            this.pages.addAll(pages);
            w53.b.f("CategoryViewPagerAdapter", "new categories ==> " + categories.size());
            notifyDataSetChanged();
        }

        public final void f(int position) {
            this.selectedPosition = position;
            h(true);
        }

        public final void g(boolean show) {
            h(show);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return this.pages.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NotNull
        public Object instantiateItem(@NotNull ViewGroup container, int position) {
            Intrinsics.checkNotNullParameter(container, "container");
            WinkInspirationTemplateCategoryView winkInspirationTemplateCategoryView = this.pages.get(position);
            container.addView(winkInspirationTemplateCategoryView);
            return winkInspirationTemplateCategoryView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NotNull View view, @NotNull Object obj) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(obj, "obj");
            if (view == obj) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkInspirationViewPager(@NotNull Context context, @NotNull WinkInspirationTemplateUtils.Companion.SIZE templateSize, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(templateSize, "templateSize");
        this.f323063i = new LinkedHashMap();
        this.templateSize = templateSize;
        initView();
    }

    private final void A0() {
        WinkInspirationPageTabBar winkInspirationPageTabBar = this.tabLayout;
        if (winkInspirationPageTabBar != null) {
            ViewGroup.LayoutParams layoutParams = winkInspirationPageTabBar.getLayoutParams();
            layoutParams.height = ViewUtils.dip2px(40.0f);
            winkInspirationPageTabBar.setLayoutParams(layoutParams);
        }
    }

    private final void initView() {
        View inflate = View.inflate(getContext(), R.layout.i5o, this);
        this.tabLayout = (WinkInspirationPageTabBar) inflate.findViewById(R.id.f122907f8);
        A0();
        ViewPager viewPager = (ViewPager) inflate.findViewById(R.id.f122917f9);
        this.viewPager = viewPager;
        if (viewPager != null) {
            this.adapter = new a();
            viewPager.addOnPageChangeListener(this);
            viewPager.setAdapter(this.adapter);
            ViewGroup.LayoutParams layoutParams = viewPager.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = WinkInspirationTemplateUtils.INSTANCE.c(this.templateSize);
            viewPager.setLayoutParams(layoutParams);
        }
        WinkInspirationPageTabBar winkInspirationPageTabBar = this.tabLayout;
        if (winkInspirationPageTabBar != null) {
            winkInspirationPageTabBar.setViewPager(this.viewPager);
        }
    }

    @Override // com.tencent.mobileqq.wink.inspirationlibrary.part.view.a
    public void K(boolean showDynamicCover) {
        a aVar = this.adapter;
        if (aVar != null) {
            aVar.g(showDynamicCover);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int position) {
        com.tencent.xaction.log.b.a("WinkInspirationViewPager", 1, "onPageSelected position:" + position);
        a aVar = this.adapter;
        if (aVar != null) {
            aVar.f(position);
        }
    }

    @Override // com.tencent.mobileqq.wink.inspirationlibrary.part.view.a
    public void refresh() {
        List<WinkInspirationTemplateCategoryView> d16;
        a aVar = this.adapter;
        if (aVar != null && (d16 = aVar.d()) != null) {
            Iterator<T> it = d16.iterator();
            while (it.hasNext()) {
                ((WinkInspirationTemplateCategoryView) it.next()).refresh();
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.inspirationlibrary.part.view.a
    public void release() {
        List<WinkInspirationTemplateCategoryView> d16;
        a aVar = this.adapter;
        if (aVar != null && (d16 = aVar.d()) != null) {
            Iterator<T> it = d16.iterator();
            while (it.hasNext()) {
                ((WinkInspirationTemplateCategoryView) it.next()).release();
            }
        }
    }

    public final void setData(@NotNull List<MetaCategory> categories, @NotNull List<WinkInspirationTemplateCategoryView> pages) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(pages, "pages");
        a aVar = this.adapter;
        if (aVar != null) {
            aVar.e(categories, pages);
        }
        a aVar2 = this.adapter;
        if (aVar2 != null) {
            aVar2.notifyDataSetChanged();
        }
        WinkInspirationPageTabBar winkInspirationPageTabBar = this.tabLayout;
        if (winkInspirationPageTabBar != null) {
            List<MetaCategory> list = categories;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((MetaCategory) it.next()).name);
            }
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            winkInspirationPageTabBar.setTabData((String[]) array);
        }
        WinkInspirationPageTabBar winkInspirationPageTabBar2 = this.tabLayout;
        if (winkInspirationPageTabBar2 != null) {
            winkInspirationPageTabBar2.q();
        }
        ViewPager viewPager = this.viewPager;
        if (viewPager != null) {
            viewPager.setCurrentItem(0);
        }
    }

    public final void z0(boolean showLine) {
        WinkInspirationPageTabBar winkInspirationPageTabBar = this.tabLayout;
        if (winkInspirationPageTabBar != null) {
            winkInspirationPageTabBar.setIsShowLine(showLine);
        }
    }

    public /* synthetic */ WinkInspirationViewPager(Context context, WinkInspirationTemplateUtils.Companion.SIZE size, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, size, (i3 & 4) != 0 ? null : attributeSet);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int state) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }
}

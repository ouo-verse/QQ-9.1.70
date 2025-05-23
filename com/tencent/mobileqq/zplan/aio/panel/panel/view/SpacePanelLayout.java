package com.tencent.mobileqq.zplan.aio.panel.panel.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zplan.aio.panel.page.Page;
import com.tencent.mobileqq.zplan.aio.panel.tab.view.SpaceTabLayout;
import fi3.br;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.g;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0011\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u00128\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\r\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/panel/view/SpacePanelLayout;", "Lcom/tencent/mobileqq/zplan/aio/panel/panel/view/AbstractPanelLayout;", "Lfi3/br;", "e", "Lfi3/br;", "binding", "Lcom/tencent/mobileqq/zplan/aio/panel/tab/view/SpaceTabLayout;", "f", "Lcom/tencent/mobileqq/zplan/aio/panel/tab/view/SpaceTabLayout;", "i", "()Lcom/tencent/mobileqq/zplan/aio/panel/tab/view/SpaceTabLayout;", "tabLayout", "Landroidx/viewpager2/widget/ViewPager2;", h.F, "Landroidx/viewpager2/widget/ViewPager2;", "j", "()Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Lcom/google/android/material/tabs/d$b;", "Lcom/google/android/material/tabs/d$b;", "()Lcom/google/android/material/tabs/d$b;", "tabConfigurationStrategy", "Landroidx/constraintlayout/widget/ConstraintLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/constraintlayout/widget/ConstraintLayout;", "g", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "spaceCloseBtn", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SpacePanelLayout extends AbstractPanelLayout {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final br binding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final SpaceTabLayout tabLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ViewPager2 viewPager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final d.b tabConfigurationStrategy;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ConstraintLayout spaceCloseBtn;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/aio/panel/panel/view/SpacePanelLayout$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), g.c(SpacePanelLayout.this, 8.0f));
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/aio/panel/panel/view/SpacePanelLayout$b", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends ViewPager2.OnPageChangeCallback {
        b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            SpacePanelLayout.this.d(positionOffsetPixels, 0);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            int i3 = 0;
            for (Object obj : SpacePanelLayout.this.b().b()) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                ((Page) obj).u(i3 == position);
                i3 = i16;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aio/panel/panel/view/SpacePanelLayout$c", "Landroid/view/TouchDelegate;", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends TouchDelegate {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Page f331306a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(TabLayout.TabView tabView, Page page) {
            super(null, tabView);
            this.f331306a = page;
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getAction() != 0) {
                return false;
            }
            this.f331306a.e().invoke();
            return false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpacePanelLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(SpacePanelLayout this$0, TabLayout.g tab, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tab, "tab");
        Page page = this$0.b().b().get(i3);
        tab.t(page.getTabName());
        TabLayout.TabView tabView = tab.f34288i;
        Intrinsics.checkNotNullExpressionValue(tabView, "tab.view");
        tabView.setTouchDelegate(new c(tabView, page));
        page.t(true);
    }

    /* renamed from: g, reason: from getter */
    public final ConstraintLayout getSpaceCloseBtn() {
        return this.spaceCloseBtn;
    }

    /* renamed from: h, reason: from getter */
    public d.b getTabConfigurationStrategy() {
        return this.tabConfigurationStrategy;
    }

    /* renamed from: i, reason: from getter */
    public SpaceTabLayout getTabLayout() {
        return this.tabLayout;
    }

    /* renamed from: j, reason: from getter */
    public ViewPager2 getViewPager() {
        return this.viewPager;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpacePanelLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SpacePanelLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpacePanelLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        br g16 = br.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        SpaceTabLayout spaceTabLayout = g16.f399145d;
        Intrinsics.checkNotNullExpressionValue(spaceTabLayout, "binding.spacePanelTabLayout");
        this.tabLayout = spaceTabLayout;
        ViewPager2 viewPager2 = g16.f399144c;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.spacePanelPages");
        this.viewPager = viewPager2;
        this.tabConfigurationStrategy = new d.b() { // from class: com.tencent.mobileqq.zplan.aio.panel.panel.view.d
            @Override // com.google.android.material.tabs.d.b
            public final void a(TabLayout.g gVar, int i16) {
                SpacePanelLayout.k(SpacePanelLayout.this, gVar, i16);
            }
        };
        ConstraintLayout constraintLayout = g16.f399143b;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.spaceCloseBtn");
        this.spaceCloseBtn = constraintLayout;
        setClipToOutline(true);
        setOutlineProvider(new a());
        setBackgroundColor(getResources().getColor(R.color.qui_common_fill_light_primary));
        getViewPager().registerOnPageChangeCallback(new b());
        getTabLayout().setTabTextColors(new ColorStateList(new int[][]{new int[]{android.R.attr.state_selected}, new int[]{-16842913}}, new int[]{getResources().getColor(R.color.qui_common_icon_aio_toolbar_active), getResources().getColor(R.color.qui_common_text_primary)}));
        setId(R.id.f163642r74);
    }
}

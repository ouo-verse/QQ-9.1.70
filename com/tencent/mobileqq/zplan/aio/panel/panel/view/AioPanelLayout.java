package com.tencent.mobileqq.zplan.aio.panel.panel.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.aio.panel.page.EmoticonPageBuilder;
import com.tencent.mobileqq.zplan.aio.panel.page.Page;
import com.tencent.mobileqq.zplan.aio.panel.panel.PanelAdapter;
import com.tencent.mobileqq.zplan.aio.panel.panel.view.AioPanelLayout;
import com.tencent.mobileqq.zplan.aio.panel.tab.view.AioTabIcon;
import com.tencent.mobileqq.zplan.aio.panel.tab.view.AioTabLayout;
import com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonInfoHelper;
import fi3.bo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0017\u001a\u00020\u00138\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001c\u001a\u00020\u00188\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/panel/view/AioPanelLayout;", "Lcom/tencent/mobileqq/zplan/aio/panel/panel/view/AbstractPanelLayout;", "Landroid/widget/ListView;", "", "j", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "c", "Lfi3/bo;", "e", "Lfi3/bo;", "binding", "Lcom/tencent/mobileqq/zplan/aio/panel/tab/view/AioTabLayout;", "f", "Lcom/tencent/mobileqq/zplan/aio/panel/tab/view/AioTabLayout;", h.F, "()Lcom/tencent/mobileqq/zplan/aio/panel/tab/view/AioTabLayout;", "tabLayout", "Landroidx/viewpager2/widget/ViewPager2;", "Landroidx/viewpager2/widget/ViewPager2;", "i", "()Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Lcom/google/android/material/tabs/d$b;", "Lcom/google/android/material/tabs/d$b;", "g", "()Lcom/google/android/material/tabs/d$b;", "tabConfigurationStrategy", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AioPanelLayout extends AbstractPanelLayout {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final bo binding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final AioTabLayout tabLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ViewPager2 viewPager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final d.b tabConfigurationStrategy;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/aio/panel/panel/view/AioPanelLayout$a", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends ViewPager2.OnPageChangeCallback {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f331298c;

        a(Context context) {
            this.f331298c = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p0(Context context, AioPanelLayout this$0) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            com.tencent.mobileqq.zplan.aio.panel.panel.view.a.f331307a.d(context, this$0.getViewPager());
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            AioPanelLayout.this.d(positionOffsetPixels, 0);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            TabLayout.g B = AioPanelLayout.this.getTabLayout().B(position);
            Intrinsics.checkNotNull(B);
            View e16 = B.e();
            Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aio.panel.tab.view.AioTabIcon");
            ((AioTabIcon) e16).setRedDotHint(false);
            int i3 = 0;
            for (Object obj : AioPanelLayout.this.b().b()) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                ((Page) obj).u(i3 == position);
                i3 = i16;
            }
            if (com.tencent.mobileqq.zplan.aio.panel.panel.view.a.f331307a.b(position)) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final Context context = this.f331298c;
                final AioPanelLayout aioPanelLayout = AioPanelLayout.this;
                uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.panel.panel.view.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        AioPanelLayout.a.p0(context, aioPanelLayout);
                    }
                }, 500L);
            }
            ((IZPlanEmoticonInfoHelper) QRoute.api(IZPlanEmoticonInfoHelper.class)).setEmoticonNextOpenPage(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AioPanelLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean j(ListView listView) {
        return listView.getChildCount() > 0 && listView.getFirstVisiblePosition() == 0 && listView.getChildAt(0) != null && listView.getChildAt(0).getTop() >= listView.getPaddingTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(AioPanelLayout this$0, TabLayout.g tab, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tab, "tab");
        View e16 = tab.e();
        Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aio.panel.tab.view.AioTabIcon");
        AioTabIcon aioTabIcon = (AioTabIcon) e16;
        final Page page = this$0.b().b().get(i3);
        aioTabIcon.setIconResInt(page.getTabIconResInt());
        aioTabIcon.setRedDotHint(page.getRedDotHint());
        aioTabIcon.setOnClickListener(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aio.panel.panel.view.AioPanelLayout$tabConfigurationStrategy$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Page.this.e().invoke();
            }
        });
        page.t(true);
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.panel.view.AbstractPanelLayout
    public boolean c() {
        RecyclerView recyclerView = (RecyclerView) getViewPager().getChildAt(0);
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = recyclerView != null ? recyclerView.findViewHolderForLayoutPosition(getViewPager().getCurrentItem()) : null;
        if (findViewHolderForLayoutPosition instanceof PanelAdapter.a) {
            PanelAdapter.a aVar = (PanelAdapter.a) findViewHolderForLayoutPosition;
            if (aVar.getVh() instanceof EmoticonPageBuilder.b) {
                return j(((EmoticonPageBuilder.b) aVar.getVh()).getView());
            }
        }
        return super.c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev5) {
        this.binding.getRoot().dispatchTouchEvent(ev5);
        return super.dispatchTouchEvent(ev5);
    }

    /* renamed from: g, reason: from getter */
    public d.b getTabConfigurationStrategy() {
        return this.tabConfigurationStrategy;
    }

    /* renamed from: h, reason: from getter */
    public AioTabLayout getTabLayout() {
        return this.tabLayout;
    }

    /* renamed from: i, reason: from getter */
    public ViewPager2 getViewPager() {
        return this.viewPager;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AioPanelLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AioPanelLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AioPanelLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        bo g16 = bo.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        AioTabLayout aioTabLayout = g16.f399135c;
        Intrinsics.checkNotNullExpressionValue(aioTabLayout, "binding.aioPanelTabLayout");
        this.tabLayout = aioTabLayout;
        ViewPager2 viewPager2 = g16.f399134b;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.aioPanelPages");
        this.viewPager = viewPager2;
        this.tabConfigurationStrategy = new d.b() { // from class: com.tencent.mobileqq.zplan.aio.panel.panel.view.b
            @Override // com.google.android.material.tabs.d.b
            public final void a(TabLayout.g gVar, int i16) {
                AioPanelLayout.k(AioPanelLayout.this, gVar, i16);
            }
        };
        getViewPager().registerOnPageChangeCallback(new a(context));
        g16.getRoot().setZ(-1.0f);
    }
}

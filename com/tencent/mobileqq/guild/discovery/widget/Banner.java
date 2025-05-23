package com.tencent.mobileqq.guild.discovery.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.component.banner.viewpager2.ProxySmoothScrollerLayoutManager;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u00104\u001a\u000203\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0006J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000bJ\u001e\u0010\u001a\u001a\u00020\u0002\"\b\b\u0000\u0010\u0017*\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018J\u0012\u0010\u001d\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u000e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010!\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010#R\u0016\u0010(\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010*R\u0014\u0010.\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/widget/Banner;", "Landroid/widget/FrameLayout;", "", "f", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "", "duration", "i", "l", "k", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "smoothScroll", "setCurrentItem", "count", "setShowItemCount", WidgetCacheConstellationData.INTERVAL, "setAutoScrollInterval", "margin", "setItemMargin", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "setAdapter", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "setScrollDurationPerItem", "d", "J", "loopInterval", "e", "I", "showItemNum", "itemMargin", tl.h.F, "Z", "stopLoop", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "runnable", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/viewpager2/widget/ViewPager2;", "viewpager", "Landroidx/recyclerview/widget/RecyclerView;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class Banner extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private RecyclerView recyclerView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long loopInterval;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int showItemNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int itemMargin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean stopLoop;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Runnable runnable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewPager2 viewpager;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0004H\u0016J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/discovery/widget/Banner$a", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemCount", "holder", "position", "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "onViewAttachedToWindow", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "onViewDetachedFromWindow", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a<T> extends RecyclerView.Adapter<T> {
        final /* synthetic */ Banner C;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ RecyclerView.Adapter<T> f216800m;

        a(RecyclerView.Adapter<T> adapter, Banner banner) {
            this.f216800m = adapter;
            this.C = banner;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            if (this.f216800m.getNUM_BACKGOURND_ICON() <= 0) {
                return 0;
            }
            return this.f216800m.getNUM_BACKGOURND_ICON() + this.C.showItemNum + 1;
        }

        /* JADX WARN: Incorrect types in method signature: (TT;I)V */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (this.f216800m.getNUM_BACKGOURND_ICON() > 0) {
                RecyclerView.Adapter<T> adapter = this.f216800m;
                adapter.onBindViewHolder(holder, position % adapter.getNUM_BACKGOURND_ICON());
            }
        }

        /* JADX WARN: Incorrect return type in method signature: (Landroid/view/ViewGroup;I)TT; */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            T onCreateViewHolder = this.f216800m.onCreateViewHolder(parent, viewType);
            Intrinsics.checkNotNullExpressionValue(onCreateViewHolder, "adapter.onCreateViewHolder(parent,viewType)");
            return onCreateViewHolder;
        }

        /* JADX WARN: Incorrect types in method signature: (TT;)V */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            super.onViewAttachedToWindow(holder);
            this.f216800m.onViewAttachedToWindow(holder);
        }

        /* JADX WARN: Incorrect types in method signature: (TT;)V */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(@NotNull RecyclerView.ViewHolder holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            super.onViewDetachedFromWindow(holder);
            this.f216800m.onViewDetachedFromWindow(holder);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/discovery/widget/Banner$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0, 0, 0, Banner.this.itemMargin);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/discovery/widget/Banner$c", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "state", "", "onPageScrollStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends ViewPager2.OnPageChangeCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPager2 f216802b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Banner f216803c;

        c(ViewPager2 viewPager2, Banner banner) {
            this.f216802b = viewPager2;
            this.f216803c = banner;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
            if (this.f216802b.getAdapter() == null) {
                return;
            }
            if (state == 0) {
                int currentItem = this.f216802b.getCurrentItem();
                RecyclerView.Adapter adapter = this.f216802b.getAdapter();
                Intrinsics.checkNotNull(adapter);
                if (currentItem == adapter.getNUM_BACKGOURND_ICON() - 2) {
                    this.f216803c.setCurrentItem(1, false);
                }
            }
            if (state == 0) {
                int currentItem2 = this.f216802b.getCurrentItem();
                RecyclerView.Adapter adapter2 = this.f216802b.getAdapter();
                Intrinsics.checkNotNull(adapter2);
                if (currentItem2 == adapter2.getNUM_BACKGOURND_ICON() - 1) {
                    this.f216803c.setCurrentItem(2, false);
                }
            }
            if (state == 0 && this.f216802b.getCurrentItem() == 0) {
                Banner banner = this.f216803c;
                RecyclerView.Adapter adapter3 = this.f216802b.getAdapter();
                Intrinsics.checkNotNull(adapter3);
                banner.setCurrentItem((adapter3.getNUM_BACKGOURND_ICON() - this.f216803c.showItemNum) - 1, false);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Banner(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void f() {
        this.viewpager.postDelayed(this.runnable, this.loopInterval);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Banner this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.stopLoop) {
            ViewPager2 viewPager2 = this$0.viewpager;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            this$0.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Banner this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.recyclerView;
        int height = this$0.getHeight();
        int height2 = this$0.getHeight();
        int i3 = this$0.showItemNum;
        int i16 = this$0.itemMargin;
        recyclerView.setPadding(0, 0, 0, (height - ((height2 - ((i3 - 1) * i16)) / i3)) - i16);
        this$0.recyclerView.setClipToPadding(false);
    }

    private final void i(final ViewPager2 viewPager2, long duration) {
        final int currentItem = viewPager2.getCurrentItem();
        com.tencent.mobileqq.guild.component.banner.viewpager2.b bVar = com.tencent.mobileqq.guild.component.banner.viewpager2.b.f215854a;
        bVar.e(viewPager2, duration);
        View childAt = viewPager2.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        boolean z16 = ((RecyclerView) childAt).getLayoutManager() instanceof ProxySmoothScrollerLayoutManager;
        bVar.c(viewPager2, duration);
        if (!z16 && currentItem != 0) {
            viewPager2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.discovery.widget.b
                @Override // java.lang.Runnable
                public final void run() {
                    Banner.j(ViewPager2.this, currentItem);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ViewPager2 viewPager2, int i3) {
        Intrinsics.checkNotNullParameter(viewPager2, "$viewPager2");
        viewPager2.setCurrentItem(i3, false);
    }

    public static /* synthetic */ void setCurrentItem$default(Banner banner, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = true;
        }
        banner.setCurrentItem(i3, z16);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        boolean z16;
        getParent().requestDisallowInterceptTouchEvent(true);
        boolean z17 = false;
        if (ev5 != null && ev5.getActionMasked() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.recyclerView.setNestedScrollingEnabled(false);
            l();
        }
        if (ev5 != null && ev5.getActionMasked() == 1) {
            z17 = true;
        }
        if (z17) {
            this.recyclerView.setNestedScrollingEnabled(true);
            k();
        }
        return super.dispatchTouchEvent(ev5);
    }

    public final void k() {
        if (!this.stopLoop) {
            return;
        }
        this.stopLoop = false;
        f();
    }

    public final void l() {
        this.stopLoop = true;
        this.viewpager.removeCallbacks(this.runnable);
    }

    public final <T extends RecyclerView.ViewHolder> void setAdapter(@NotNull RecyclerView.Adapter<T> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.viewpager.setAdapter(new a(adapter, this));
        k();
    }

    public final void setAutoScrollInterval(long interval) {
        this.loopInterval = interval;
    }

    public final void setCurrentItem(int item, boolean smoothScroll) {
        if (this.viewpager.isFakeDragging()) {
            this.viewpager.endFakeDrag();
        }
        this.viewpager.setCurrentItem(item, smoothScroll);
    }

    public final void setItemMargin(int margin) {
        if (this.viewpager.getItemDecorationCount() > 0) {
            return;
        }
        this.itemMargin = margin;
        this.viewpager.addItemDecoration(new b());
    }

    public final void setScrollDurationPerItem(long duration) {
        i(this.viewpager, duration);
    }

    public final void setShowItemCount(int count) {
        this.showItemNum = count;
        this.recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.discovery.widget.d
            @Override // java.lang.Runnable
            public final void run() {
                Banner.h(Banner.this);
            }
        });
    }

    public /* synthetic */ Banner(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Banner(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.loopInterval = 3000L;
        this.showItemNum = 2;
        this.itemMargin = (int) cw.d(8);
        this.stopLoop = true;
        this.runnable = new Runnable() { // from class: com.tencent.mobileqq.guild.discovery.widget.c
            @Override // java.lang.Runnable
            public final void run() {
                Banner.g(Banner.this);
            }
        };
        ViewPager2 viewPager2 = new ViewPager2(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        viewPager2.setOrientation(1);
        viewPager2.registerOnPageChangeCallback(new c(viewPager2, this));
        addView(viewPager2, layoutParams);
        this.viewpager = viewPager2;
        View childAt = viewPager2.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.recyclerView = (RecyclerView) childAt;
    }
}

package bh1;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.discover.widget.tab.TabLayout;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\f\u000fB?\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b+\u0010,J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lbh1/a;", "", "", "a", "b", "Lcom/tencent/mobileqq/guild/discover/widget/tab/TabLayout;", "Lcom/tencent/mobileqq/guild/discover/widget/tab/TabLayout;", "tabLayout", "Landroidx/viewpager2/widget/ViewPager2;", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "", "c", "Z", "autoRefresh", "d", "smoothScroll", "e", "scrollWithPage", "Lbh1/a$b;", "f", "Lbh1/a$b;", "tabConfigurationStrategy", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "g", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "<set-?>", h.F, "isAttached", "()Z", "Lbh1/a$c;", "i", "Lbh1/a$c;", "onPageChangeCallback", "Lcom/tencent/mobileqq/guild/discover/widget/tab/TabLayout$d;", "j", "Lcom/tencent/mobileqq/guild/discover/widget/tab/TabLayout$d;", "onTabSelectedListener", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "k", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "pagerAdapterObserver", "<init>", "(Lcom/tencent/mobileqq/guild/discover/widget/tab/TabLayout;Landroidx/viewpager2/widget/ViewPager2;ZZZLbh1/a$b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TabLayout tabLayout;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewPager2 viewPager;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean autoRefresh;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean smoothScroll;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean scrollWithPage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b tabConfigurationStrategy;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView.Adapter<?> adapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isAttached;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c onPageChangeCallback;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TabLayout.d onTabSelectedListener;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView.AdapterDataObserver pagerAdapterObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\t\b\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\"\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lbh1/a$a;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "onChanged", "", "positionStart", "itemCount", "onItemRangeChanged", "", "payload", "onItemRangeInserted", "onItemRangeRemoved", "fromPosition", "toPosition", "onItemRangeMoved", "<init>", "(Lbh1/a;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: bh1.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private final class C0127a extends RecyclerView.AdapterDataObserver {
        public C0127a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            a.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int positionStart, int itemCount) {
            a.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int positionStart, int itemCount) {
            a.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            a.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            a.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int positionStart, int itemCount, @Nullable Object payload) {
            a.this.b();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lbh1/a$b;", "", "Lcom/tencent/mobileqq/guild/discover/widget/tab/TabLayout$g;", "tab", "", "position", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        void a(@NotNull TabLayout.g tab, int position);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u001b\u001a\u00020\u0012\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0006\u0010\f\u001a\u00020\u0004R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lbh1/a$c;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "state", "", "onPageScrollStateChanged", "position", "", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "o0", "", "b", "Z", "scrollWithPage", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/guild/discover/widget/tab/TabLayout;", "c", "Ljava/lang/ref/WeakReference;", "tabLayoutRef", "d", "I", "previousScrollState", "e", HippyTKDListViewAdapter.SCROLL_STATE, "tabLayout", "<init>", "(Lcom/tencent/mobileqq/guild/discover/widget/tab/TabLayout;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class c extends ViewPager2.OnPageChangeCallback {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final boolean scrollWithPage;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<TabLayout> tabLayoutRef;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int previousScrollState;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int scrollState;

        public c(@NotNull TabLayout tabLayout, boolean z16) {
            Intrinsics.checkNotNullParameter(tabLayout, "tabLayout");
            this.scrollWithPage = z16;
            this.tabLayoutRef = new WeakReference<>(tabLayout);
            o0();
        }

        public final void o0() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            this.previousScrollState = this.scrollState;
            this.scrollState = state;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            TabLayout tabLayout;
            boolean z16;
            if (this.scrollWithPage && (tabLayout = this.tabLayoutRef.get()) != null) {
                int i3 = this.scrollState;
                boolean z17 = false;
                if (i3 == 2 && this.previousScrollState != 1) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (i3 != 2 || this.previousScrollState != 0) {
                    z17 = true;
                }
                tabLayout.setScrollPosition(position, positionOffset, z16, z17);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            boolean z16;
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null && tabLayout.y() != position && position < tabLayout.A()) {
                int i3 = this.scrollState;
                if (i3 != 0 && (i3 != 2 || this.previousScrollState != 0)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                tabLayout.N(tabLayout.z(position), z16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lbh1/a$d;", "Lcom/tencent/mobileqq/guild/discover/widget/tab/TabLayout$d;", "Lcom/tencent/mobileqq/guild/discover/widget/tab/TabLayout$g;", "tab", "", "mf", "Nb", "h8", "Landroidx/viewpager2/widget/ViewPager2;", "d", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "", "e", "Z", "smoothScroll", "<init>", "(Landroidx/viewpager2/widget/ViewPager2;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class d implements TabLayout.d {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ViewPager2 viewPager;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean smoothScroll;

        public d(@NotNull ViewPager2 viewPager, boolean z16) {
            Intrinsics.checkNotNullParameter(viewPager, "viewPager");
            this.viewPager = viewPager;
            this.smoothScroll = z16;
        }

        @Override // com.tencent.mobileqq.guild.discover.widget.tab.TabLayout.c
        public void Nb(@NotNull TabLayout.g tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
        }

        @Override // com.tencent.mobileqq.guild.discover.widget.tab.TabLayout.c
        public void h8(@NotNull TabLayout.g tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
        }

        @Override // com.tencent.mobileqq.guild.discover.widget.tab.TabLayout.c
        public void mf(@NotNull TabLayout.g tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            this.viewPager.setCurrentItem(tab.g(), this.smoothScroll);
        }
    }

    @JvmOverloads
    public a(@NotNull TabLayout tabLayout, @NotNull ViewPager2 viewPager, boolean z16, boolean z17, boolean z18, @NotNull b tabConfigurationStrategy) {
        Intrinsics.checkNotNullParameter(tabLayout, "tabLayout");
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        Intrinsics.checkNotNullParameter(tabConfigurationStrategy, "tabConfigurationStrategy");
        this.tabLayout = tabLayout;
        this.viewPager = viewPager;
        this.autoRefresh = z16;
        this.smoothScroll = z17;
        this.scrollWithPage = z18;
        this.tabConfigurationStrategy = tabConfigurationStrategy;
    }

    public final void a() {
        if (!this.isAttached) {
            RecyclerView.Adapter<?> adapter = this.viewPager.getAdapter();
            this.adapter = adapter;
            if (adapter != null) {
                this.isAttached = true;
                c cVar = new c(this.tabLayout, this.scrollWithPage);
                this.onPageChangeCallback = cVar;
                ViewPager2 viewPager2 = this.viewPager;
                Intrinsics.checkNotNull(cVar);
                viewPager2.registerOnPageChangeCallback(cVar);
                d dVar = new d(this.viewPager, this.smoothScroll);
                this.onTabSelectedListener = dVar;
                TabLayout tabLayout = this.tabLayout;
                Intrinsics.checkNotNull(dVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.discover.widget.tab.TabLayoutMediator.ViewPagerOnTabSelectedListener");
                tabLayout.d(dVar);
                if (this.autoRefresh) {
                    this.pagerAdapterObserver = new C0127a();
                    RecyclerView.Adapter<?> adapter2 = this.adapter;
                    Intrinsics.checkNotNull(adapter2);
                    RecyclerView.AdapterDataObserver adapterDataObserver = this.pagerAdapterObserver;
                    Intrinsics.checkNotNull(adapterDataObserver);
                    adapter2.registerAdapterDataObserver(adapterDataObserver);
                }
                b();
                this.tabLayout.setScrollPosition(this.viewPager.getCurrentItem(), 0.0f, true);
                return;
            }
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter".toString());
        }
        throw new IllegalStateException("TabLayoutMediator is already attached".toString());
    }

    public final void b() {
        this.tabLayout.J();
        RecyclerView.Adapter<?> adapter = this.adapter;
        if (adapter != null) {
            Intrinsics.checkNotNull(adapter);
            int itemCount = adapter.getItemCount();
            for (int i3 = 0; i3 < itemCount; i3++) {
                TabLayout.g G = this.tabLayout.G();
                Intrinsics.checkNotNullExpressionValue(G, "tabLayout.newTab()");
                this.tabConfigurationStrategy.a(G, i3);
                this.tabLayout.g(G, false);
            }
            if (itemCount > 0) {
                int min = Math.min(this.viewPager.getCurrentItem(), this.tabLayout.A() - 1);
                if (min != this.tabLayout.y()) {
                    TabLayout tabLayout = this.tabLayout;
                    tabLayout.M(tabLayout.z(min));
                }
            }
        }
    }
}

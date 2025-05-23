package com.tencent.mobileqq.guild.component.banner;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.qphone.base.util.QLog;
import kotlin.C11734b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import pg1.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ&\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/component/banner/a;", "", "Log1/a;", "Options", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "Log1/b;", "bannerIndicator", "", "a", "<init>", "()V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f215813a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0013\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B%\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002J*\u0010\u0010\u001a\u00020\u000f2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002J \u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0006H\u0016R\u0014\u0010\u001a\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/component/banner/a$a;", "Log1/a;", "Options", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "", "position", "p0", "Log1/b;", "bannerIndicator", "", "r0", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "", "q0", "", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "b", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "callback", "c", "Landroidx/viewpager2/widget/ViewPager2;", "d", "Log1/b;", "e", "Z", "updateItemCountResult", "<init>", "(Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;Landroidx/viewpager2/widget/ViewPager2;Log1/b;)V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.component.banner.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    private static final class C7701a<Options extends og1.a> extends ViewPager2.OnPageChangeCallback {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ViewPager2.OnPageChangeCallback callback;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ViewPager2 viewPager2;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final og1.b<Options> bannerIndicator;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean updateItemCountResult;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/component/banner/a$a$a", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "onChanged", "", "positionStart", "itemCount", "onItemRangeInserted", "onItemRangeRemoved", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.component.banner.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public static final class C7702a extends RecyclerView.AdapterDataObserver {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ C7701a<Options> f215818d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ViewPager2 f215819e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ og1.b<Options> f215820f;

            C7702a(C7701a<Options> c7701a, ViewPager2 viewPager2, og1.b<Options> bVar) {
                this.f215818d = c7701a;
                this.f215819e = viewPager2;
                this.f215820f = bVar;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                this.f215818d.r0(this.f215819e, this.f215820f);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                this.f215818d.r0(this.f215819e, this.f215820f);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int positionStart, int itemCount) {
                super.onItemRangeRemoved(positionStart, itemCount);
                this.f215818d.r0(this.f215819e, this.f215820f);
            }
        }

        public C7701a(@NotNull ViewPager2.OnPageChangeCallback callback, @NotNull ViewPager2 viewPager2, @NotNull og1.b<Options> bannerIndicator) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
            Intrinsics.checkNotNullParameter(bannerIndicator, "bannerIndicator");
            this.callback = callback;
            this.viewPager2 = viewPager2;
            this.bannerIndicator = bannerIndicator;
            this.updateItemCountResult = r0(viewPager2, bannerIndicator);
        }

        private final int p0(ViewPager2 viewPager2, int position) {
            Object adapter = viewPager2.getAdapter();
            if (!(adapter instanceof g)) {
                return position;
            }
            return ((g) adapter).R(position);
        }

        private final void q0(RecyclerView.Adapter<?> adapter, ViewPager2 viewPager2, og1.b<Options> bannerIndicator) {
            C11734b c11734b = C11734b.f433780a;
            QLog.i("Guild.component.BannerHelper", 1, "registerItemCountChangeObserver", null);
            adapter.registerAdapterDataObserver(new C7702a(this, viewPager2, bannerIndicator));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [androidx.recyclerview.widget.RecyclerView$Adapter] */
        public final boolean r0(ViewPager2 viewPager2, og1.b<Options> bannerIndicator) {
            ?? adapter = viewPager2.getAdapter();
            if (adapter == 0) {
                return false;
            }
            boolean z16 = adapter instanceof g;
            RecyclerView.Adapter<?> adapter2 = adapter;
            if (z16) {
                adapter2 = ((g) adapter).m();
            }
            C11734b c11734b = C11734b.f433780a;
            QLog.i("Guild.component.BannerHelper", 1, "updateIndicatorItemCount: " + adapter2.getItemCount(), null);
            Options options = bannerIndicator.getOptions();
            options.b(adapter2.getItemCount());
            bannerIndicator.setOptions(options);
            if (!this.updateItemCountResult) {
                q0(adapter2, viewPager2, bannerIndicator);
            }
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            this.callback.onPageScrollStateChanged(state);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            this.callback.onPageScrolled(p0(this.viewPager2, position), positionOffset, positionOffsetPixels);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            if (!this.updateItemCountResult) {
                this.updateItemCountResult = r0(this.viewPager2, this.bannerIndicator);
            }
            this.callback.onPageSelected(p0(this.viewPager2, position));
        }
    }

    a() {
    }

    public final <Options extends og1.a> void a(@NotNull ViewPager2 viewPager2, @NotNull og1.b<Options> bannerIndicator) {
        Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
        Intrinsics.checkNotNullParameter(bannerIndicator, "bannerIndicator");
        viewPager2.registerOnPageChangeCallback(new C7701a(bannerIndicator.a(), viewPager2, bannerIndicator));
    }
}

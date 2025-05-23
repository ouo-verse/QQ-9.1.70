package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final TabLayout f34294a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final ViewPager2 f34295b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f34296c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f34297d;

    /* renamed from: e, reason: collision with root package name */
    private final b f34298e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private RecyclerView.Adapter<?> f34299f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f34300g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private c f34301h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private TabLayout.d f34302i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private RecyclerView.AdapterDataObserver f34303j;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.AdapterDataObserver {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            d.this.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i16) {
            d.this.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i3, int i16) {
            d.this.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i3, int i16, int i17) {
            d.this.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i3, int i16) {
            d.this.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i16, @Nullable Object obj) {
            d.this.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface b {
        void a(@NonNull TabLayout.g gVar, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c extends ViewPager2.OnPageChangeCallback {

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        private final WeakReference<TabLayout> f34305b;

        /* renamed from: c, reason: collision with root package name */
        private int f34306c;

        /* renamed from: d, reason: collision with root package name */
        private int f34307d;

        c(TabLayout tabLayout) {
            this.f34305b = new WeakReference<>(tabLayout);
            o0();
        }

        void o0() {
            this.f34307d = 0;
            this.f34306c = 0;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i3) {
            this.f34306c = this.f34307d;
            this.f34307d = i3;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i3, float f16, int i16) {
            boolean z16;
            TabLayout tabLayout = this.f34305b.get();
            if (tabLayout != null) {
                int i17 = this.f34307d;
                boolean z17 = false;
                if (i17 == 2 && this.f34306c != 1) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (i17 != 2 || this.f34306c != 0) {
                    z17 = true;
                }
                tabLayout.setScrollPosition(i3, f16, z16, z17);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            boolean z16;
            TabLayout tabLayout = this.f34305b.get();
            if (tabLayout != null && tabLayout.A() != i3 && i3 < tabLayout.C()) {
                int i16 = this.f34307d;
                if (i16 != 0 && (i16 != 2 || this.f34306c != 0)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                tabLayout.R(tabLayout.B(i3), z16);
            }
        }
    }

    public d(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, @NonNull b bVar) {
        this(tabLayout, viewPager2, true, bVar);
    }

    public void a() {
        if (!this.f34300g) {
            RecyclerView.Adapter<?> adapter = this.f34295b.getAdapter();
            this.f34299f = adapter;
            if (adapter != null) {
                this.f34300g = true;
                c cVar = new c(this.f34294a);
                this.f34301h = cVar;
                this.f34295b.registerOnPageChangeCallback(cVar);
                C0239d c0239d = new C0239d(this.f34295b, this.f34297d);
                this.f34302i = c0239d;
                this.f34294a.f(c0239d);
                if (this.f34296c) {
                    a aVar = new a();
                    this.f34303j = aVar;
                    this.f34299f.registerAdapterDataObserver(aVar);
                }
                c();
                this.f34294a.setScrollPosition(this.f34295b.getCurrentItem(), 0.0f, true);
                return;
            }
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }

    public void b() {
        RecyclerView.Adapter<?> adapter;
        if (this.f34296c && (adapter = this.f34299f) != null) {
            adapter.unregisterAdapterDataObserver(this.f34303j);
            this.f34303j = null;
        }
        this.f34294a.O(this.f34302i);
        this.f34295b.unregisterOnPageChangeCallback(this.f34301h);
        this.f34302i = null;
        this.f34301h = null;
        this.f34299f = null;
        this.f34300g = false;
    }

    void c() {
        this.f34294a.M();
        RecyclerView.Adapter<?> adapter = this.f34299f;
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            for (int i3 = 0; i3 < itemCount; i3++) {
                TabLayout.g J = this.f34294a.J();
                this.f34298e.a(J, i3);
                this.f34294a.i(J, false);
            }
            if (itemCount > 0) {
                int min = Math.min(this.f34295b.getCurrentItem(), this.f34294a.C() - 1);
                if (min != this.f34294a.A()) {
                    TabLayout tabLayout = this.f34294a;
                    tabLayout.Q(tabLayout.B(min));
                }
            }
        }
    }

    public d(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, boolean z16, @NonNull b bVar) {
        this(tabLayout, viewPager2, z16, true, bVar);
    }

    public d(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, boolean z16, boolean z17, @NonNull b bVar) {
        this.f34294a = tabLayout;
        this.f34295b = viewPager2;
        this.f34296c = z16;
        this.f34297d = z17;
        this.f34298e = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.google.android.material.tabs.d$d, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0239d implements TabLayout.d {

        /* renamed from: d, reason: collision with root package name */
        private final ViewPager2 f34308d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f34309e;

        C0239d(ViewPager2 viewPager2, boolean z16) {
            this.f34308d = viewPager2;
            this.f34309e = z16;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabSelected(@NonNull TabLayout.g gVar) {
            this.f34308d.setCurrentItem(gVar.g(), this.f34309e);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabReselected(TabLayout.g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabUnselected(TabLayout.g gVar) {
        }
    }
}

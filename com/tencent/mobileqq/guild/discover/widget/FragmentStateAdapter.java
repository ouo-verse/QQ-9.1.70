package com.tencent.mobileqq.guild.discover.widget;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.StatefulAdapter;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes13.dex */
public abstract class FragmentStateAdapter extends RecyclerView.Adapter<com.tencent.mobileqq.guild.discover.widget.a> implements StatefulAdapter {
    final FragmentManager C;
    final LongSparseArray<Fragment> D;
    private final LongSparseArray<Fragment.SavedState> E;
    private final LongSparseArray<Integer> F;
    private FragmentMaxLifecycleEnforcer G;
    boolean H;
    private boolean I;

    /* renamed from: m, reason: collision with root package name */
    final Lifecycle f216541m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class FragmentMaxLifecycleEnforcer {

        /* renamed from: a, reason: collision with root package name */
        private ViewPager2.OnPageChangeCallback f216547a;

        /* renamed from: b, reason: collision with root package name */
        private RecyclerView.AdapterDataObserver f216548b;

        /* renamed from: c, reason: collision with root package name */
        private LifecycleEventObserver f216549c;

        /* renamed from: d, reason: collision with root package name */
        private ViewPager2 f216550d;

        /* renamed from: e, reason: collision with root package name */
        private long f216551e = -1;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes13.dex */
        public class a extends ViewPager2.OnPageChangeCallback {
            a() {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i3) {
                FragmentMaxLifecycleEnforcer.this.d(false);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i3) {
                FragmentMaxLifecycleEnforcer.this.d(false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes13.dex */
        public class b extends c {
            b() {
            }

            @Override // com.tencent.mobileqq.guild.discover.widget.FragmentStateAdapter.c, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                FragmentMaxLifecycleEnforcer.this.d(true);
            }
        }

        FragmentMaxLifecycleEnforcer() {
        }

        @NonNull
        private ViewPager2 a(@NonNull RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        void b(@NonNull RecyclerView recyclerView) {
            this.f216550d = a(recyclerView);
            a aVar = new a();
            this.f216547a = aVar;
            this.f216550d.registerOnPageChangeCallback(aVar);
            b bVar = new b();
            this.f216548b = bVar;
            FragmentStateAdapter.this.registerAdapterDataObserver(bVar);
            LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.discover.widget.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.3
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    FragmentMaxLifecycleEnforcer.this.d(false);
                }
            };
            this.f216549c = lifecycleEventObserver;
            FragmentStateAdapter.this.f216541m.addObserver(lifecycleEventObserver);
        }

        void c(@NonNull RecyclerView recyclerView) {
            a(recyclerView).unregisterOnPageChangeCallback(this.f216547a);
            FragmentStateAdapter.this.unregisterAdapterDataObserver(this.f216548b);
            FragmentStateAdapter.this.f216541m.removeObserver(this.f216549c);
            this.f216550d = null;
        }

        void d(boolean z16) {
            int currentItem;
            Fragment fragment;
            boolean z17;
            if (FragmentStateAdapter.this.shouldDelayFragmentTransactions() || this.f216550d.getScrollState() != 0 || FragmentStateAdapter.this.D.isEmpty() || FragmentStateAdapter.this.getNUM_BACKGOURND_ICON() == 0 || (currentItem = this.f216550d.getCurrentItem()) >= FragmentStateAdapter.this.getNUM_BACKGOURND_ICON()) {
                return;
            }
            long itemId = FragmentStateAdapter.this.getItemId(currentItem);
            if ((itemId != this.f216551e || z16) && (fragment = FragmentStateAdapter.this.D.get(itemId)) != null && fragment.isAdded()) {
                this.f216551e = itemId;
                FragmentTransaction beginTransaction = FragmentStateAdapter.this.C.beginTransaction();
                Fragment fragment2 = null;
                for (int i3 = 0; i3 < FragmentStateAdapter.this.D.size(); i3++) {
                    long keyAt = FragmentStateAdapter.this.D.keyAt(i3);
                    Fragment valueAt = FragmentStateAdapter.this.D.valueAt(i3);
                    if (valueAt.isAdded()) {
                        if (keyAt != this.f216551e) {
                            beginTransaction.setMaxLifecycle(valueAt, Lifecycle.State.STARTED);
                        } else {
                            fragment2 = valueAt;
                        }
                        if (keyAt == this.f216551e) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        valueAt.setMenuVisibility(z17);
                    }
                }
                if (fragment2 != null) {
                    beginTransaction.setMaxLifecycle(fragment2, Lifecycle.State.RESUMED);
                }
                if (!beginTransaction.isEmpty()) {
                    beginTransaction.commitNow();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements View.OnLayoutChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrameLayout f216556d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.discover.widget.a f216557e;

        a(FrameLayout frameLayout, com.tencent.mobileqq.guild.discover.widget.a aVar) {
            this.f216556d = frameLayout;
            this.f216557e = aVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            if (this.f216556d.getParent() != null) {
                this.f216556d.removeOnLayoutChangeListener(this);
                FragmentStateAdapter.this.p0(this.f216557e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b extends FragmentManager.FragmentLifecycleCallbacks {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Fragment f216559d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FrameLayout f216560e;

        b(Fragment fragment, FrameLayout frameLayout) {
            this.f216559d = fragment;
            this.f216560e = frameLayout;
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle) {
            if (fragment == this.f216559d) {
                fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                FragmentStateAdapter.this.addViewToContainer(view, this.f216560e);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    private static abstract class c extends RecyclerView.AdapterDataObserver {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i3, int i16) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i3, int i16) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i3, int i16, int i17) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i3, int i16) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i3, int i16, @Nullable Object obj) {
            onChanged();
        }
    }

    public FragmentStateAdapter(@NonNull Fragment fragment) {
        this(fragment.getChildFragmentManager(), fragment.getLifecycle());
    }

    @NonNull
    private static String createKey(@NonNull String str, long j3) {
        return str + j3;
    }

    private void ensureFragment(int i3) {
        long itemId = getItemId(i3);
        if (!this.D.containsKey(itemId)) {
            Fragment createFragment = createFragment(i3);
            createFragment.setInitialSavedState(this.E.get(itemId));
            this.D.put(itemId, createFragment);
        }
    }

    private boolean isFragmentViewBound(long j3) {
        View view;
        if (this.F.containsKey(j3)) {
            return true;
        }
        Fragment fragment = this.D.get(j3);
        if (fragment != null && (view = fragment.getView()) != null && view.getParent() != null) {
            return true;
        }
        return false;
    }

    private static boolean isValidKey(@NonNull String str, @NonNull String str2) {
        if (str.startsWith(str2) && str.length() > str2.length()) {
            return true;
        }
        return false;
    }

    private Long itemForViewHolder(int i3) {
        Long l3 = null;
        for (int i16 = 0; i16 < this.F.size(); i16++) {
            if (this.F.valueAt(i16).intValue() == i3) {
                if (l3 == null) {
                    l3 = Long.valueOf(this.F.keyAt(i16));
                } else {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
            }
        }
        return l3;
    }

    private static long parseIdFromKey(@NonNull String str, @NonNull String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    private void removeFragment(long j3) {
        ViewParent parent;
        Fragment fragment = this.D.get(j3);
        if (fragment == null) {
            return;
        }
        if (fragment.getView() != null && (parent = fragment.getView().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!containsItem(j3)) {
            this.E.remove(j3);
        }
        if (!fragment.isAdded()) {
            m0(fragment);
            this.D.remove(j3);
        } else {
            if (shouldDelayFragmentTransactions()) {
                this.I = true;
                return;
            }
            if (fragment.isAdded() && containsItem(j3)) {
                this.E.put(j3, this.C.saveFragmentInstanceState(fragment));
            }
            m0(fragment);
            this.C.beginTransaction().remove(fragment).commitNow();
            this.D.remove(j3);
        }
    }

    private void scheduleGracePeriodEnd() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.guild.discover.widget.FragmentStateAdapter.4
            @Override // java.lang.Runnable
            public void run() {
                FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
                fragmentStateAdapter.H = false;
                fragmentStateAdapter.gcFragments();
            }
        };
        this.f216541m.addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.discover.widget.FragmentStateAdapter.5
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    handler.removeCallbacks(runnable);
                    lifecycleOwner.getLifecycle().removeObserver(this);
                }
            }
        });
        handler.postDelayed(runnable, 10000L);
    }

    private void scheduleViewAttach(Fragment fragment, @NonNull FrameLayout frameLayout) {
        this.C.registerFragmentLifecycleCallbacks(new b(fragment, frameLayout), false);
    }

    void addViewToContainer(@NonNull View view, @NonNull FrameLayout frameLayout) {
        if (frameLayout.getChildCount() <= 1) {
            if (view.getParent() == frameLayout) {
                return;
            }
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public boolean containsItem(long j3) {
        if (j3 >= 0 && j3 < getNUM_BACKGOURND_ICON()) {
            return true;
        }
        return false;
    }

    @NonNull
    public abstract Fragment createFragment(int i3);

    void gcFragments() {
        if (this.I && !shouldDelayFragmentTransactions()) {
            ArraySet arraySet = new ArraySet();
            for (int i3 = 0; i3 < this.D.size(); i3++) {
                long keyAt = this.D.keyAt(i3);
                if (!containsItem(keyAt)) {
                    arraySet.add(Long.valueOf(keyAt));
                    this.F.remove(keyAt);
                }
            }
            if (!this.H) {
                this.I = false;
                for (int i16 = 0; i16 < this.D.size(); i16++) {
                    long keyAt2 = this.D.keyAt(i16);
                    if (!isFragmentViewBound(keyAt2)) {
                        arraySet.add(Long.valueOf(keyAt2));
                    }
                }
            }
            Iterator<E> it = arraySet.iterator();
            while (it.hasNext()) {
                removeFragment(((Long) it.next()).longValue());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Nullable
    public Fragment i0(int i3) {
        return this.D.get(getItemId(i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(@NonNull com.tencent.mobileqq.guild.discover.widget.a aVar, int i3) {
        long itemId = aVar.getItemId();
        int id5 = aVar.getContainer().getId();
        Long itemForViewHolder = itemForViewHolder(id5);
        if (itemForViewHolder != null && itemForViewHolder.longValue() != itemId) {
            removeFragment(itemForViewHolder.longValue());
            this.F.remove(itemForViewHolder.longValue());
        }
        this.F.put(itemId, Integer.valueOf(id5));
        ensureFragment(i3);
        FrameLayout container = aVar.getContainer();
        if (ViewCompat.isAttachedToWindow(container)) {
            if (container.getParent() == null) {
                container.addOnLayoutChangeListener(new a(container, aVar));
            } else {
                throw new IllegalStateException("Design assumption violated.");
            }
        }
        gcFragments();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public final com.tencent.mobileqq.guild.discover.widget.a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return com.tencent.mobileqq.guild.discover.widget.a.l(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public final boolean onFailedToRecycleView(@NonNull com.tencent.mobileqq.guild.discover.widget.a aVar) {
        return true;
    }

    protected abstract void m0(@NonNull Fragment fragment);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public final void onViewAttachedToWindow(@NonNull com.tencent.mobileqq.guild.discover.widget.a aVar) {
        p0(aVar);
        gcFragments();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public final void onViewRecycled(@NonNull com.tencent.mobileqq.guild.discover.widget.a aVar) {
        Long itemForViewHolder = itemForViewHolder(aVar.getContainer().getId());
        if (itemForViewHolder != null) {
            removeFragment(itemForViewHolder.longValue());
            this.F.remove(itemForViewHolder.longValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"RestrictedApi"})
    @CallSuper
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        boolean z16;
        if (this.G == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkArgument(z16);
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.G = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.b(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        this.G.c(recyclerView);
        this.G = null;
    }

    void p0(@NonNull final com.tencent.mobileqq.guild.discover.widget.a aVar) {
        Fragment fragment = this.D.get(aVar.getItemId());
        if (fragment != null) {
            FrameLayout container = aVar.getContainer();
            View view = fragment.getView();
            if (!fragment.isAdded() && view != null) {
                throw new IllegalStateException("Design assumption violated.");
            }
            if (fragment.isAdded() && view == null) {
                scheduleViewAttach(fragment, container);
                return;
            }
            if (fragment.isAdded() && view != null && view.getParent() != null) {
                if (view.getParent() != container) {
                    addViewToContainer(view, container);
                    return;
                }
                return;
            }
            if (fragment.isAdded()) {
                addViewToContainer(view, container);
                return;
            }
            if (!shouldDelayFragmentTransactions()) {
                scheduleViewAttach(fragment, container);
                this.C.beginTransaction().add(fragment, "f" + aVar.getItemId()).setMaxLifecycle(fragment, Lifecycle.State.STARTED).commitNow();
                this.G.d(false);
                return;
            }
            if (this.C.isDestroyed()) {
                return;
            }
            this.f216541m.addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.discover.widget.FragmentStateAdapter.2
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    if (FragmentStateAdapter.this.shouldDelayFragmentTransactions()) {
                        return;
                    }
                    lifecycleOwner.getLifecycle().removeObserver(this);
                    if (ViewCompat.isAttachedToWindow(aVar.getContainer())) {
                        FragmentStateAdapter.this.p0(aVar);
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final void restoreState(@NonNull Parcelable parcelable) {
        if (this.E.isEmpty() && this.D.isEmpty()) {
            Bundle bundle = (Bundle) parcelable;
            if (bundle.getClassLoader() == null) {
                bundle.setClassLoader(getClass().getClassLoader());
            }
            for (String str : bundle.keySet()) {
                if (isValidKey(str, "f#")) {
                    this.D.put(parseIdFromKey(str, "f#"), this.C.getFragment(bundle, str));
                } else if (isValidKey(str, "s#")) {
                    long parseIdFromKey = parseIdFromKey(str, "s#");
                    Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(str);
                    if (containsItem(parseIdFromKey)) {
                        this.E.put(parseIdFromKey, savedState);
                    }
                } else {
                    throw new IllegalArgumentException("Unexpected key in savedState: " + str);
                }
            }
            if (!this.D.isEmpty()) {
                this.I = true;
                this.H = true;
                gcFragments();
                scheduleGracePeriodEnd();
                return;
            }
            return;
        }
        throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    @NonNull
    public final Parcelable saveState() {
        Bundle bundle = new Bundle(this.D.size() + this.E.size());
        for (int i3 = 0; i3 < this.D.size(); i3++) {
            long keyAt = this.D.keyAt(i3);
            Fragment fragment = this.D.get(keyAt);
            if (fragment != null && fragment.isAdded()) {
                this.C.putFragment(bundle, createKey("f#", keyAt), fragment);
            }
        }
        for (int i16 = 0; i16 < this.E.size(); i16++) {
            long keyAt2 = this.E.keyAt(i16);
            if (containsItem(keyAt2)) {
                bundle.putParcelable(createKey("s#", keyAt2), this.E.get(keyAt2));
            }
        }
        return bundle;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean z16) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    boolean shouldDelayFragmentTransactions() {
        return this.C.isStateSaved();
    }

    public FragmentStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        this.D = new LongSparseArray<>();
        this.E = new LongSparseArray<>();
        this.F = new LongSparseArray<>();
        this.H = false;
        this.I = false;
        this.C = fragmentManager;
        this.f216541m = lifecycle;
        super.setHasStableIds(true);
    }
}

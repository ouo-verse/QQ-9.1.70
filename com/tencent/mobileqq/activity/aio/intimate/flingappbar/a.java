package com.tencent.mobileqq.activity.aio.intimate.flingappbar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.activity.aio.intimate.flingappbar.FlingAppBarLayout;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f178974a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<NestedScrollView> f178975b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<RecyclerView> f178976c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<View> f178977d;

    /* renamed from: e, reason: collision with root package name */
    private int f178978e = 0;

    public a(View view) {
        this.f178977d = new WeakReference<>(view);
        d(view);
    }

    private boolean a(View view) {
        if (view instanceof NestedScrollView) {
            this.f178974a = 1;
            WeakReference<NestedScrollView> weakReference = new WeakReference<>((NestedScrollView) view);
            this.f178975b = weakReference;
            h(weakReference.get());
            return true;
        }
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            this.f178976c = new WeakReference<>(recyclerView);
            this.f178974a = 2;
            i(recyclerView);
            return true;
        }
        return false;
    }

    public static View b(ViewPager viewPager) {
        int currentItem = viewPager.getCurrentItem();
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter instanceof FragmentStatePagerAdapter) {
            return ((FragmentStatePagerAdapter) adapter).getItem(currentItem).getView();
        }
        if (adapter instanceof FragmentPagerAdapter) {
            return ((FragmentPagerAdapter) adapter).getItem(currentItem).getView();
        }
        return null;
    }

    @Nullable
    public static a c(CoordinatorLayout coordinatorLayout) {
        int childCount = coordinatorLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = coordinatorLayout.getChildAt(i3);
            if (((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).getBehavior() instanceof FlingAppBarLayout.ScrollingViewBehavior) {
                return new a(childAt);
            }
        }
        return null;
    }

    public static Field e(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private void h(NestedScrollView nestedScrollView) {
        try {
            Field e16 = e(nestedScrollView, "mScroller");
            if (e16 == null) {
                return;
            }
            e16.setAccessible(true);
            OverScroller overScroller = (OverScroller) e16.get(nestedScrollView);
            if (overScroller != null) {
                overScroller.abortAnimation();
            }
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    private void i(RecyclerView recyclerView) {
        this.f178978e = 0;
        try {
            Field e16 = e(recyclerView, "mViewFlinger");
            if (e16 == null) {
                return;
            }
            e16.setAccessible(true);
            Object obj = e16.get(recyclerView);
            if (obj == null) {
                return;
            }
            Method declaredMethod = obj.getClass().getDeclaredMethod("stop", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, new Object[0]);
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    protected boolean d(View view) {
        if (a(view)) {
            return true;
        }
        if (view instanceof ViewPager) {
            View b16 = b((ViewPager) view);
            if (b16 != null) {
                return a(b16.findViewWithTag("fling"));
            }
        } else if (view instanceof ViewGroup) {
            View findViewWithTag = view.findViewWithTag("fling");
            if (findViewWithTag != null) {
                return a(findViewWithTag);
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (a(viewGroup.getChildAt(i3))) {
                    return true;
                }
            }
        }
        return false;
    }

    public int f() {
        int computeVerticalScrollRange;
        int i3 = this.f178974a;
        if (i3 == 1) {
            NestedScrollView nestedScrollView = this.f178975b.get();
            if (nestedScrollView == null || nestedScrollView.getChildCount() <= 0) {
                return 0;
            }
            computeVerticalScrollRange = Math.max(0, nestedScrollView.getChildAt(0).getHeight() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()));
        } else if (i3 == 2) {
            RecyclerView recyclerView = this.f178976c.get();
            if (recyclerView == null) {
                return 0;
            }
            computeVerticalScrollRange = recyclerView.computeVerticalScrollRange();
        } else {
            if (this.f178977d.get() == null) {
                return 0;
            }
            return this.f178977d.get().getHeight();
        }
        return computeVerticalScrollRange;
    }

    public void g(int i3) {
        if (this.f178974a == 1 && this.f178975b.get() != null) {
            this.f178975b.get().scrollTo(0, i3);
        } else if (this.f178974a == 2 && this.f178976c.get() != null) {
            this.f178976c.get().scrollBy(0, i3 - this.f178978e);
            this.f178978e = i3;
        }
    }
}

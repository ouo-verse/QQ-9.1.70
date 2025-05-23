package androidx.viewpager.widget;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Argus;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\b"}, d2 = {"Landroidx/viewpager/widget/ViewPagerLifecycleCompat;", "", "()V", "getCurrentView", "Landroid/view/View;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "PageChangeListener", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class ViewPagerLifecycleCompat {

    @NotNull
    public static final ViewPagerLifecycleCompat INSTANCE = new ViewPagerLifecycleCompat();

    ViewPagerLifecycleCompat() {
    }

    @Nullable
    public final View getCurrentView(@NotNull ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        int currentItem = viewPager.getCurrentItem();
        int childCount = viewPager.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View child = viewPager.getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(child, "child");
            ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
            if (layoutParams != null) {
                ViewPager.LayoutParams layoutParams2 = (ViewPager.LayoutParams) layoutParams;
                int i16 = layoutParams2.position;
                if (!layoutParams2.isDecor && currentItem == i16) {
                    return child;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.viewpager.widget.ViewPager.LayoutParams");
            }
        }
        return null;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Landroidx/viewpager/widget/ViewPagerLifecycleCompat$PageChangeListener;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "mViewPager", "Landroidx/viewpager/widget/ViewPager;", "mChildView", "Landroid/view/View;", "(Landroidx/viewpager/widget/ViewPager;Landroid/view/View;)V", "onPageScrollStateChanged", "", "state", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes.dex */
    public static final class PageChangeListener implements ViewPager.OnPageChangeListener {
        private final View mChildView;
        private final ViewPager mViewPager;

        public PageChangeListener(@NotNull ViewPager mViewPager, @NotNull View mChildView) {
            Intrinsics.checkNotNullParameter(mViewPager, "mViewPager");
            Intrinsics.checkNotNullParameter(mChildView, "mChildView");
            this.mViewPager = mViewPager;
            this.mChildView = mChildView;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            View currentView = ViewPagerLifecycleCompat.INSTANCE.getCurrentView(this.mViewPager);
            if (currentView == this.mChildView) {
                Intrinsics.checkNotNullExpressionValue(FragmentManager.findFragment(currentView), "FragmentManager.findFragment(currentView)");
                Log.i(Argus.TAG, "onPageSelected:" + position + " view:" + this.mChildView + " ViewPager:" + this.mViewPager);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }
}

package androidx.viewpager.widget;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes.dex */
public class ViewPagerUtils {
    public static View getCurrentView(ViewPager viewPager) {
        int currentItem = viewPager.getCurrentItem();
        for (int i3 = 0; i3 < viewPager.getChildCount(); i3++) {
            View childAt = viewPager.getChildAt(i3);
            ViewPager.LayoutParams layoutParams = (ViewPager.LayoutParams) childAt.getLayoutParams();
            if (!layoutParams.isDecor && currentItem == layoutParams.position) {
                return childAt;
            }
        }
        return null;
    }
}

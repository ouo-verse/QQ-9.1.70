package androidx.viewpager2.widget;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class ViewPager2Util {
    public static void interceptAccessibility(ViewPager2 viewPager2) {
        ViewCompat.setAccessibilityDelegate(viewPager2.mRecyclerView, new AccessibilityDelegateCompat() { // from class: androidx.viewpager2.widget.ViewPager2Util.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
                if (i3 != 4096 && i3 != 8192) {
                    return super.performAccessibilityAction(view, i3, bundle);
                }
                return true;
            }
        });
    }
}

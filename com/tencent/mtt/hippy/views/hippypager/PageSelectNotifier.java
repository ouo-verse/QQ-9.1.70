package com.tencent.mtt.hippy.views.hippypager;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes20.dex */
class PageSelectNotifier {
    private List<ViewPager.OnPageChangeListener> onPageChangeListeners;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addOnPageChangeListener(@NonNull ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.onPageChangeListeners == null) {
            this.onPageChangeListeners = new ArrayList();
        }
        if (!this.onPageChangeListeners.contains(onPageChangeListener)) {
            this.onPageChangeListeners.add(onPageChangeListener);
        }
    }

    public void clearOnPageChangeListeners() {
        List<ViewPager.OnPageChangeListener> list = this.onPageChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyPageSelected(int i3) {
        List<ViewPager.OnPageChangeListener> list = this.onPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i16 = 0; i16 < size; i16++) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.onPageChangeListeners.get(i16);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeOnPageChangeListener(@NonNull ViewPager.OnPageChangeListener onPageChangeListener) {
        List<ViewPager.OnPageChangeListener> list = this.onPageChangeListeners;
        if (list != null) {
            list.remove(onPageChangeListener);
        }
    }
}

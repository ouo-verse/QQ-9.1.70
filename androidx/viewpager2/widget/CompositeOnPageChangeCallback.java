package androidx.viewpager2.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class CompositeOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {

    @NonNull
    private final List<ViewPager2.OnPageChangeCallback> mCallbacks;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositeOnPageChangeCallback(int i3) {
        this.mCallbacks = new ArrayList(i3);
    }

    private void throwCallbackListModifiedWhileInUse(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addOnPageChangeCallback(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.mCallbacks.add(onPageChangeCallback);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i3) {
        try {
            Iterator<ViewPager2.OnPageChangeCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onPageScrollStateChanged(i3);
            }
        } catch (ConcurrentModificationException e16) {
            throwCallbackListModifiedWhileInUse(e16);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i3, float f16, @Px int i16) {
        try {
            Iterator<ViewPager2.OnPageChangeCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onPageScrolled(i3, f16, i16);
            }
        } catch (ConcurrentModificationException e16) {
            throwCallbackListModifiedWhileInUse(e16);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i3) {
        try {
            Iterator<ViewPager2.OnPageChangeCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onPageSelected(i3);
            }
        } catch (ConcurrentModificationException e16) {
            throwCallbackListModifiedWhileInUse(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeOnPageChangeCallback(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.mCallbacks.remove(onPageChangeCallback);
    }
}

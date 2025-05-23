package com.tencent.richframework.gallery.widget;

import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.richframework.gallery.adapter.RFWBaseLayerAdapter;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/richframework/gallery/widget/RFWGalleryViewPager$createBaseOnPageChangeCallback$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageScrollStateChanged", "", "state", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWGalleryViewPager$createBaseOnPageChangeCallback$1 extends ViewPager2.OnPageChangeCallback {
    final /* synthetic */ RFWGalleryViewPager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RFWGalleryViewPager$createBaseOnPageChangeCallback$1(RFWGalleryViewPager rFWGalleryViewPager) {
        this.this$0 = rFWGalleryViewPager;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int state) {
        List list;
        RFWBaseLayerAdapter rFWBaseLayerAdapter;
        RFWBaseLayerAdapter rFWBaseLayerAdapter2;
        int totalSize;
        int totalSize2;
        list = this.this$0.mExternalPageChangeCallbacks;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ViewPager2.OnPageChangeCallback) it.next()).onPageScrollStateChanged(state);
        }
        if (state == 0) {
            rFWBaseLayerAdapter = this.this$0.mAdapter;
            if (rFWBaseLayerAdapter != null) {
                rFWBaseLayerAdapter2 = this.this$0.mAdapter;
                Intrinsics.checkNotNull(rFWBaseLayerAdapter2);
                if (rFWBaseLayerAdapter2.isCanLoop()) {
                    int currentItem = this.this$0.getViewPager2().getCurrentItem();
                    totalSize = this.this$0.getTotalSize();
                    if (currentItem == totalSize - 1) {
                        RFWLog.e("RFWGalleryViewPager", RFWLog.USR, "[onPageScrollStateChanged] -> reset to starPos");
                        this.this$0.getViewPager2().setCurrentItem(1, false);
                    } else if (this.this$0.getViewPager2().getCurrentItem() == 0) {
                        RFWLog.e("RFWGalleryViewPager", RFWLog.USR, "[onPageScrollStateChanged] -> reset to endPos");
                        ViewPager2 viewPager2 = this.this$0.getViewPager2();
                        totalSize2 = this.this$0.getTotalSize();
                        viewPager2.setCurrentItem(totalSize2 - 2, false);
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int realPosition;
        List list;
        realPosition = this.this$0.getRealPosition(position);
        list = this.this$0.mExternalPageChangeCallbacks;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ViewPager2.OnPageChangeCallback) it.next()).onPageScrolled(realPosition, positionOffset, positionOffsetPixels);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int position) {
        int i3;
        int realPosition;
        List<ViewPager2.OnPageChangeCallback> list;
        int i16;
        RFWBaseLayerAdapter unused;
        i3 = this.this$0.mCurrentPos;
        if (i3 == -1 && this.this$0.isCanLoop()) {
            this.this$0.getViewPager2().post(new Runnable() { // from class: com.tencent.richframework.gallery.widget.RFWGalleryViewPager$createBaseOnPageChangeCallback$1$onPageSelected$1
                @Override // java.lang.Runnable
                public final void run() {
                    int i17;
                    int i18;
                    i17 = RFWGalleryViewPager$createBaseOnPageChangeCallback$1.this.this$0.mCurrentPos;
                    if (i17 == -1) {
                        RFWGalleryViewPager$createBaseOnPageChangeCallback$1.this.this$0.mCurrentPos = 0;
                        RFWGalleryViewPager rFWGalleryViewPager = RFWGalleryViewPager$createBaseOnPageChangeCallback$1.this.this$0;
                        i18 = rFWGalleryViewPager.mCurrentPos;
                        rFWGalleryViewPager.setCurrentItem(i18, false);
                    }
                }
            });
            return;
        }
        RFWGalleryViewPager rFWGalleryViewPager = this.this$0;
        realPosition = rFWGalleryViewPager.getRealPosition(position);
        rFWGalleryViewPager.mCurrentPos = realPosition;
        list = this.this$0.mExternalPageChangeCallbacks;
        for (ViewPager2.OnPageChangeCallback onPageChangeCallback : list) {
            i16 = this.this$0.mCurrentPos;
            onPageChangeCallback.onPageSelected(i16);
        }
        unused = this.this$0.mAdapter;
    }
}

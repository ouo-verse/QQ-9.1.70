package com.tencent.mtt.hippy.views.viewpager;

import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.views.hippypager.HippyPagerPageChangeListener;
import com.tencent.mtt.hippy.views.viewpager.event.HippyPageItemExposureEvent;
import com.tencent.mtt.hippy.views.viewpager.event.HippyPageScrollEvent;
import com.tencent.mtt.hippy.views.viewpager.event.HippyPageScrollStateChangedEvent;
import com.tencent.mtt.hippy.views.viewpager.event.HippyPageSelectedEvent;
import com.tencent.mtt.supportui.views.viewpager.ViewPager;

/* loaded from: classes20.dex */
public class ViewPagerPageChangeListener implements ViewPager.OnPageChangeListener {
    private final HippyPageScrollEvent mPageScrollEmitter;
    private final HippyPageScrollStateChangedEvent mPageScrollStateChangeEmitter;
    private final HippyPageSelectedEvent mPageSelectedEmitter;
    private final HippyViewPager mPager;
    private int mLastPageIndex = 0;
    private int mCurrPageIndex = 0;

    public ViewPagerPageChangeListener(HippyViewPager hippyViewPager) {
        this.mPager = hippyViewPager;
        this.mPageScrollEmitter = new HippyPageScrollEvent(hippyViewPager);
        this.mPageScrollStateChangeEmitter = new HippyPageScrollStateChangedEvent(hippyViewPager);
        this.mPageSelectedEmitter = new HippyPageSelectedEvent(hippyViewPager);
    }

    private void onScrollStateChangeToIdle() {
        HippyViewPager hippyViewPager = this.mPager;
        if (hippyViewPager != null && this.mCurrPageIndex != this.mLastPageIndex) {
            Promise callBackPromise = hippyViewPager.getCallBackPromise();
            if (callBackPromise != null) {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushString("msg", "on set index successful!");
                callBackPromise.resolve(hippyMap);
                this.mPager.setCallBackPromise(null);
            }
            new HippyPageItemExposureEvent(HippyPageItemExposureEvent.EVENT_PAGER_ITEM_DID_APPEAR).send(this.mPager.getViewFromAdapter(this.mCurrPageIndex), this.mCurrPageIndex);
            new HippyPageItemExposureEvent(HippyPageItemExposureEvent.EVENT_PAGER_ITEM_DID_DISAPPEAR).send(this.mPager.getViewFromAdapter(this.mLastPageIndex), this.mLastPageIndex);
            this.mLastPageIndex = this.mCurrPageIndex;
        }
    }

    @Override // com.tencent.mtt.supportui.views.viewpager.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3, int i16) {
        String str;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 == 2) {
                    str = HippyPagerPageChangeListener.SETTLING;
                } else {
                    throw new IllegalStateException("Unsupported pageScrollState");
                }
            } else {
                str = HippyPagerPageChangeListener.DRAGGING;
            }
        } else {
            onScrollStateChangeToIdle();
            str = HippyPagerPageChangeListener.IDLE;
        }
        this.mPageScrollStateChangeEmitter.send(str);
    }

    @Override // com.tencent.mtt.supportui.views.viewpager.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
        int i17;
        int i18 = this.mLastPageIndex;
        float f17 = (i3 - i18) + f16;
        if (f17 > 0.0f) {
            int ceil = (int) Math.ceil(f17);
            i18 = this.mLastPageIndex + ceil;
            if (ceil > 1) {
                i17 = ceil - 1;
                f17 -= i17;
            }
        } else if (f17 < 0.0f) {
            int floor = (int) Math.floor(f17);
            i18 = this.mLastPageIndex + floor;
            if (floor < -1) {
                i17 = floor + 1;
                f17 -= i17;
            }
        }
        this.mPageScrollEmitter.send(i18, f17);
    }

    @Override // com.tencent.mtt.supportui.views.viewpager.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        this.mCurrPageIndex = i3;
        this.mPageSelectedEmitter.send(i3);
        HippyViewPager hippyViewPager = this.mPager;
        if (hippyViewPager != null) {
            new HippyPageItemExposureEvent("onWillAppear").send(hippyViewPager.getViewFromAdapter(this.mCurrPageIndex), this.mCurrPageIndex);
            new HippyPageItemExposureEvent(HippyPageItemExposureEvent.EVENT_PAGER_ITEM_WILL_DISAPPEAR).send(this.mPager.getViewFromAdapter(this.mLastPageIndex), this.mLastPageIndex);
        }
    }
}

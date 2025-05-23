package com.tencent.mtt.hippy.views.hippypager;

import androidx.viewpager.widget.ViewPager;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.views.viewpager.event.HippyPageItemExposureEvent;
import com.tencent.mtt.hippy.views.viewpager.event.HippyPageScrollEvent;
import com.tencent.mtt.hippy.views.viewpager.event.HippyPageScrollStateChangedEvent;
import com.tencent.mtt.hippy.views.viewpager.event.HippyPageSelectedEvent;

/* loaded from: classes20.dex */
public class HippyPagerPageChangeListener implements ViewPager.OnPageChangeListener {
    public static final String DRAGGING = "dragging";
    public static final String IDLE = "idle";
    public static final String SETTLING = "settling";
    private HippyPager hippyPager;
    private HippyPageScrollEvent pageScrollEmitter;
    private HippyPageScrollStateChangedEvent pageScrollStateChangeEmitter;
    private HippyPageSelectedEvent pageSelectedEmitter;
    private int lastPageIndex = 0;
    private int currPageIndex = 0;

    public HippyPagerPageChangeListener(HippyPager hippyPager) {
        this.hippyPager = hippyPager;
        this.pageScrollEmitter = new HippyPageScrollEvent(hippyPager);
        this.pageScrollStateChangeEmitter = new HippyPageScrollStateChangedEvent(hippyPager);
        this.pageSelectedEmitter = new HippyPageSelectedEvent(hippyPager);
    }

    private void onScrollStateChangeToIdle() {
        HippyPager hippyPager = this.hippyPager;
        if (hippyPager != null && this.currPageIndex != this.lastPageIndex) {
            Promise callBackPromise = hippyPager.getCallBackPromise();
            if (callBackPromise != null) {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushString("msg", "on set index successful!");
                callBackPromise.resolve(hippyMap);
                this.hippyPager.setCallBackPromise(null);
            }
            new HippyPageItemExposureEvent(HippyPageItemExposureEvent.EVENT_PAGER_ITEM_DID_APPEAR).send(this.hippyPager.getViewFromAdapter(this.currPageIndex), this.currPageIndex);
            new HippyPageItemExposureEvent(HippyPageItemExposureEvent.EVENT_PAGER_ITEM_DID_DISAPPEAR).send(this.hippyPager.getViewFromAdapter(this.lastPageIndex), this.lastPageIndex);
            this.lastPageIndex = this.currPageIndex;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
        String str;
        LogUtils.i("HippyPagerStateChanged", "onPageScrollStateChanged newState=" + i3);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    str = SETTLING;
                } else {
                    throw new IllegalStateException("Unsupported pageScrollState");
                }
            } else {
                str = DRAGGING;
            }
        } else {
            onScrollStateChangeToIdle();
            str = IDLE;
        }
        this.pageScrollStateChangeEmitter.send(str);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
        this.pageScrollEmitter.send(i3, f16);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        this.currPageIndex = i3;
        this.pageSelectedEmitter.send(i3);
        HippyPager hippyPager = this.hippyPager;
        if (hippyPager != null) {
            new HippyPageItemExposureEvent("onWillAppear").send(hippyPager.getViewFromAdapter(this.currPageIndex), this.currPageIndex);
            new HippyPageItemExposureEvent(HippyPageItemExposureEvent.EVENT_PAGER_ITEM_WILL_DISAPPEAR).send(this.hippyPager.getViewFromAdapter(this.lastPageIndex), this.lastPageIndex);
        }
    }
}

package com.tencent.mtt.hippy.views.list;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyListItemView extends HippyViewGroup {
    public static final String EXPOSURE_EVENT_APPEAR = "onAppear";
    public static final String EXPOSURE_EVENT_DISAPPEAR = "onDisAppear";
    public static final String EXPOSURE_EVENT_WILL_APPEAR = "onWillAppear";
    public static final String EXPOSURE_EVENT_WILL_DISAPPEAR = "onWillDisappear";
    public static final int EXPOSURE_STATE_APPEAR = 1;
    public static final int EXPOSURE_STATE_DISAPPEAR = 2;
    public static final int EXPOSURE_STATE_FULL_VISIBLE = 1;
    public static final int EXPOSURE_STATE_INVISIBLE = 2;
    public static final int EXPOSURE_STATE_PART_VISIBLE = 3;
    public static final int EXPOSURE_STATE_WILL_APPEAR = 0;
    public static final int EXPOSURE_STATE_WILL_DISAPPEAR = 3;
    private static final boolean VIEW_LEVEL_MONITOR_ENABLE = false;
    private int mExposureState;
    private Paint mPaint;

    public HippyListItemView(Context context) {
        super(context);
        this.mExposureState = 2;
    }

    private int calculateChildLevel(View view) {
        int childCount;
        if (!(view instanceof ViewGroup) || (childCount = getChildCount()) == 0) {
            return 1;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            i3 = Math.max(i3, calculateChildLevel(((ViewGroup) view).getChildAt(i16)));
        }
        return 1 + i3;
    }

    private int calculateHippyLevel() {
        int i3 = 0;
        View view = this;
        while (view.getParent() != null && (view.getParent() instanceof View) && !(view.getParent() instanceof HippyRootView)) {
            view = (View) view.getParent();
            i3++;
        }
        if (view.getParent() instanceof HippyRootView) {
            return i3 + 1;
        }
        return i3;
    }

    private int calculateSelfLevel() {
        int i3 = 0;
        View view = this;
        while (view.getParent() != null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
            i3++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.views.view.HippyViewGroup, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public int getExposureState() {
        return this.mExposureState;
    }

    public void moveToExposureState(int i3) {
        String str;
        int i16 = this.mExposureState;
        if (i3 == i16) {
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    if (i16 == 1) {
                        sendExposureEvent(EXPOSURE_EVENT_WILL_DISAPPEAR);
                    } else {
                        sendExposureEvent("onWillAppear");
                    }
                }
                this.mExposureState = i3;
            }
            if (i16 == 1) {
                sendExposureEvent(EXPOSURE_EVENT_WILL_DISAPPEAR);
            }
            str = EXPOSURE_EVENT_DISAPPEAR;
        } else {
            if (i16 == 2) {
                sendExposureEvent("onWillAppear");
            }
            str = EXPOSURE_EVENT_APPEAR;
        }
        sendExposureEvent(str);
        this.mExposureState = i3;
    }

    protected void sendExposureEvent(String str) {
        if (str.equals(EXPOSURE_EVENT_APPEAR) || str.equals(EXPOSURE_EVENT_DISAPPEAR) || str.equals("onWillAppear") || str.equals(EXPOSURE_EVENT_WILL_DISAPPEAR)) {
            new HippyViewEvent(str).send(this, null);
        }
    }

    public void setExposureState(int i3) {
        this.mExposureState = i3;
    }
}

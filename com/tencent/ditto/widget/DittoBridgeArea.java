package com.tencent.ditto.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.annoations.SourceCode.DittoJsonElement;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.DittoAreaEnv;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.utils.DittoLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DittoBridgeArea extends DittoArea implements DittoHost {

    @DittoJsonElement("\u5185\u5d4cView\u7684\u7c7b\u578b, \u5982:android.widget.ImageView")
    public static final String VIEW_CLASS = "view";
    public View mContainedView;
    public Class mViewClass;

    public DittoBridgeArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        String str;
        this.mViewClass = null;
        if (layoutAttrSet.hasAttr("view")) {
            str = layoutAttrSet.getAttr("view", (String) null);
        } else {
            str = null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(layoutAttrSet.width, layoutAttrSet.height);
                Class findAreaClass = DittoAreaEnv.findAreaClass(str);
                this.mViewClass = findAreaClass;
                View view = (View) findAreaClass.getConstructor(Context.class, AttributeSet.class).newInstance(DittoUIEngine.g().getContext(), null);
                this.mContainedView = view;
                view.setLayoutParams(layoutParams);
                View view2 = this.mContainedView;
                if (view2 instanceof DittoAreaView) {
                    ((DittoAreaView) view2).setHost(this);
                }
            }
        } catch (Exception e16) {
            DittoLog.i("DittoBridgeArea:" + e16.getMessage());
            this.mContainedView = new View(DittoUIEngine.g().getContext());
        }
    }

    @Override // com.tencent.ditto.area.DittoArea, com.tencent.ditto.area.DittoElement
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View view = this.mContainedView;
        if (view != null && view.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public View getContainedView() {
        return this.mContainedView;
    }

    @Override // com.tencent.ditto.area.DittoHost
    public View getContainerView() {
        DittoHost dittoHost = this.mHost;
        if (dittoHost != null) {
            return dittoHost.getContainerView();
        }
        return null;
    }

    @Override // com.tencent.ditto.area.DittoHost
    public Object getCurrentViewModel() {
        DittoHost dittoHost = this.mHost;
        if (dittoHost != null) {
            dittoHost.getCurrentViewModel();
            return null;
        }
        return null;
    }

    @Override // com.tencent.ditto.area.DittoHost
    public void handleSilentRequest(String str, String str2, int i3, DittoArea dittoArea, MotionEvent motionEvent) {
        DittoHost dittoHost = this.mHost;
        if (dittoHost != null) {
            dittoHost.handleSilentRequest(str, str2, i3, dittoArea, motionEvent);
        }
    }

    @Override // com.tencent.ditto.area.DittoHost
    public void handleSilentUri(String str, DittoArea dittoArea, MotionEvent motionEvent) {
        DittoHost dittoHost = this.mHost;
        if (dittoHost != null) {
            dittoHost.handleSilentUri(str, dittoArea, motionEvent);
        }
    }

    @Override // com.tencent.ditto.area.DittoHost
    public void handleUri(String str, DittoArea dittoArea, MotionEvent motionEvent) {
        DittoHost dittoHost = this.mHost;
        if (dittoHost != null) {
            dittoHost.handleUri(str, dittoArea, motionEvent);
        }
    }

    @Override // com.tencent.ditto.area.DittoHost
    public void invalidate(int i3, int i16, int i17, int i18) {
        DittoHost dittoHost = this.mHost;
        if (dittoHost != null) {
            dittoHost.invalidate(i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.ditto.area.DittoHost
    public void invokeAreaClick(String str, MotionEvent motionEvent) {
        DittoHost dittoHost = this.mHost;
        if (dittoHost != null) {
            dittoHost.invokeAreaClick(str, motionEvent);
        }
    }

    @Override // com.tencent.ditto.area.DittoHost
    public void onContentDescriptionChanged(DittoArea dittoArea) {
        DittoHost dittoHost = this.mHost;
        if (dittoHost != null) {
            dittoHost.onContentDescriptionChanged(dittoArea);
        }
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        this.mContainedView.draw(canvas);
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onLayout(int i3, int i16, int i17, int i18) {
        this.mContainedView.layout(i3, i16, i17, i18);
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onMeasure(int i3, int i16) {
        this.mContainedView.measure(i3, i16);
        setMeasuredDimension(this.mContainedView.getMeasuredWidth(), this.mContainedView.getMeasuredHeight());
    }

    @Override // com.tencent.ditto.area.DittoHost
    public void postInvalidate() {
        DittoHost dittoHost = this.mHost;
        if (dittoHost != null) {
            dittoHost.postInvalidate();
        }
    }

    @Override // com.tencent.ditto.area.DittoHost
    public void postInvalidateDelayed(long j3) {
        DittoHost dittoHost = this.mHost;
        if (dittoHost != null) {
            dittoHost.postInvalidateDelayed(j3);
        }
    }

    @Override // com.tencent.ditto.area.DittoHost
    public void removeAccessibilityArea(List<DittoArea> list) {
        DittoHost dittoHost = this.mHost;
        if (dittoHost != null) {
            dittoHost.removeAccessibilityArea(list);
        }
    }

    @Override // com.tencent.ditto.area.DittoHost
    public void storageViewModel(boolean z16) {
        DittoHost dittoHost = this.mHost;
        if (dittoHost != null) {
            dittoHost.storageViewModel(z16);
        }
    }

    @Override // com.tencent.ditto.area.DittoHost
    public void turnOffHardwareAcceleration() {
        DittoHost dittoHost = this.mHost;
        if (dittoHost != null) {
            dittoHost.turnOffHardwareAcceleration();
        }
    }
}

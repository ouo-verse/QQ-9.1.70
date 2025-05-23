package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarLinearLayout;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes10.dex */
public class PanelIconLinearLayout extends ChatPanelBarLinearLayout {

    /* renamed from: e, reason: collision with root package name */
    public static int f179565e;

    /* renamed from: d, reason: collision with root package name */
    public int f179566d;

    public PanelIconLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f179566d = 100;
        setOrientation(0);
        setBackgroundResource(R.drawable.skin_aio_panel_icon_bg);
        f179565e = BaseAIOUtils.f(40.0f, context.getResources());
    }

    private void a(View view, boolean z16) {
        if (view instanceof RedTouch) {
            RedTouch redTouch = (RedTouch) view;
            for (int i3 = 0; i3 < redTouch.getChildCount(); i3++) {
                redTouch.getChildAt(i3).setEnabled(z16);
            }
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        EventCollector.getInstance().onViewLongClickedBefore(view);
        EventCollector.getInstance().onViewLongClicked(view);
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(this.f179566d, 1073741824));
        setMeasuredDimension(getMeasuredWidth(), this.f179566d);
        if (QLog.isColorLevel()) {
            QLog.d("PanelIconLinearLayout", 2, System.identityHashCode(this) + " onMeasure() called with: w = [" + getMeasuredWidth() + "], h = [" + getMeasuredHeight() + "]");
        }
    }

    public void setCustomHeight(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("PanelIconLinearLayout", 2, "setCustomHeight() called with: height = [" + i3 + "]");
        }
        this.f179566d = i3;
        requestLayout();
    }

    public void setEnable(int i3, boolean z16) {
        View findViewWithTag = findViewWithTag(Integer.valueOf(i3));
        if (findViewWithTag != null) {
            findViewWithTag.setEnabled(z16);
            a(findViewWithTag, z16);
        }
    }

    public void setSelected(int i3) {
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getTag().equals(Integer.valueOf(i3))) {
                childAt.setSelected(true);
            } else {
                childAt.setSelected(false);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}

package com.qzone.reborn.feedx.presenter.ad.multipicture;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.app.FrameHelperActivity;
import cooperation.qzone.QZoneTopGestureLayout;

/* loaded from: classes37.dex */
public class QZoneAdMDPARecyclerView extends RecyclerView {
    public QZoneAdMDPARecyclerView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            QZoneTopGestureLayout.setBackEnabled(false);
            FrameHelperActivity.gj(false, "QZoneAdMDPARecyclerView");
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            QZoneTopGestureLayout.setBackEnabled(true);
            FrameHelperActivity.gj(true, "QZoneAdMDPARecyclerView");
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public QZoneAdMDPARecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QZoneAdMDPARecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}

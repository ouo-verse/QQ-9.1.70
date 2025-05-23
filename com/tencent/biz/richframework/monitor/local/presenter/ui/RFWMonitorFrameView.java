package com.tencent.biz.richframework.monitor.local.presenter.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.monitor.local.fps.RFWDropFrameCollector;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWMonitorFrameView {
    private TextView mMonitorFpsInfoView;
    private TextView mMonitorSmInfoView;

    private void updateFPSText(float f16) {
        TextView textView = this.mMonitorFpsInfoView;
        if (textView == null) {
            RFWLog.d("FAM-RFWMonitorFrameView", RFWLog.USR, "[updateFPSText] monitor fps info view should not be null.");
            return;
        }
        textView.setText("FPS\uff1a" + f16);
    }

    private void updateSMText(float f16) {
        TextView textView = this.mMonitorSmInfoView;
        if (textView == null) {
            RFWLog.d("FAM-RFWMonitorFrameView", RFWLog.USR, "[updateSMText] monitor sm info view should not be null.");
            return;
        }
        textView.setText("SM: " + f16 + "%");
    }

    public void onInitView(View view) {
        this.mMonitorFpsInfoView = (TextView) view.findViewById(R.id.zde);
        this.mMonitorSmInfoView = (TextView) view.findViewById(R.id.zdi);
    }

    public void updateData(RFWDropFrameCollector.DropFrameInfo dropFrameInfo) {
        if (dropFrameInfo == null) {
            return;
        }
        updateFPSText(dropFrameInfo.getFps());
        updateSMText(dropFrameInfo.getTotalSmoothRate());
    }
}

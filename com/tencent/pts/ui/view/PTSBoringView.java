package com.tencent.pts.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSViewDecorationUtil;

/* loaded from: classes22.dex */
public class PTSBoringView extends FrameLayout implements IView {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PTSBoringView";
    private Paint borderPaint;
    private PTSViewDecorationUtil.RoundedCorner mRoundedCorner;
    private String nodeKey;
    private TextView textView;

    public PTSBoringView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mRoundedCorner = new PTSViewDecorationUtil.RoundedCorner(this);
            initUI();
        }
    }

    private void bindData() {
        if (!PTSLog.isDebug()) {
            PTSLog.i(TAG, "[bindData] is not debug version.");
            return;
        }
        TextView textView = this.textView;
        if (textView != null) {
            textView.setText("custom view");
        }
        setBackgroundColor(-1294411560);
        PTSLog.i(TAG, "[bindData], nodeKey = " + this.nodeKey);
    }

    private void drawDashBorder(Canvas canvas) {
        if (!PTSLog.isDebug()) {
            PTSLog.i(TAG, "[drawDashBorder] is not debug version.");
            return;
        }
        float dp2px = PTSDeviceUtil.dp2px(3.0f);
        if (this.borderPaint == null) {
            Paint paint = new Paint(1);
            this.borderPaint = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.borderPaint.setColor(-16465569);
            this.borderPaint.setStrokeWidth(dp2px);
            this.borderPaint.setPathEffect(new DashPathEffect(new float[]{15.0f, 15.0f}, 0.0f));
        }
        setLayerType(1, null);
        PTSViewDecorationUtil.drawBorderImp(canvas, this.borderPaint, getWidth(), getHeight(), dp2px, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    private void initUI() {
        if (!PTSLog.isDebug()) {
            PTSLog.i(TAG, "[initUI] is not debug version, do not show text.");
            return;
        }
        this.textView = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int dp2pxInt = PTSDeviceUtil.dp2pxInt(3.0f);
        layoutParams.topMargin = dp2pxInt;
        layoutParams.leftMargin = dp2pxInt;
        addView(this.textView, layoutParams);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        int saveCount = this.mRoundedCorner.getSaveCount(canvas);
        super.draw(canvas);
        this.mRoundedCorner.drawCorner(canvas, saveCount);
        this.mRoundedCorner.drawBorder(canvas);
        drawDashBorder(canvas);
    }

    @Override // com.tencent.pts.ui.view.IView
    public void onBindNodeInfo(PTSNodeInfo pTSNodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) pTSNodeInfo);
        } else {
            this.mRoundedCorner.onBindNodeInfo(pTSNodeInfo);
            bindData();
        }
    }

    public void setNodeKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.nodeKey = str;
        }
    }
}

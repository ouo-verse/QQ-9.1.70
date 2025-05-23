package com.tencent.mobileqq.fpsreport;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.util.QQUIFPSCalculator;
import com.tencent.util.QQUIPerformanceReportUtils;

/* loaded from: classes12.dex */
public class FPSSlideDetectListView extends SlideDetectListView {
    static IPatchRedirector $redirector_;
    private QQUIFPSCalculator Q;
    private boolean R;
    private long S;
    private String T;

    public FPSSlideDetectListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.R = false;
            this.S = 0L;
        }
    }

    @Override // com.tencent.widget.XListView, com.tencent.widget.AbsListView, android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        super.draw(canvas);
        QQUIFPSCalculator qQUIFPSCalculator = this.Q;
        if (qQUIFPSCalculator != null) {
            qQUIFPSCalculator.framAdd();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.R) {
            this.R = false;
            QQUIPerformanceReportUtils.saveCompleteTime(this.T, SystemClock.uptimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AbsListView
    public void reportScrollStateChange(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        super.reportScrollStateChange(i3);
        QQUIFPSCalculator qQUIFPSCalculator = this.Q;
        if (qQUIFPSCalculator != null) {
            qQUIFPSCalculator.calculateFPS(i3);
        }
    }

    public void setActTAG(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        this.T = str;
        QQUIFPSCalculator qQUIFPSCalculator = new QQUIFPSCalculator();
        this.Q = qQUIFPSCalculator;
        qQUIFPSCalculator.setActTAG(str);
        setStartTime(SystemClock.uptimeMillis());
    }

    public void setStartTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        } else {
            this.R = true;
            this.S = j3;
        }
    }
}

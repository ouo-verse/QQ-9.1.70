package com.tencent.mobileqq.fpsreport;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.util.QQUIFPSCalculator;
import com.tencent.util.QQUIPerformanceReportUtils;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;

/* loaded from: classes12.dex */
public class FPSPinnedHeaderExpandableListView extends SwipPinnedHeaderExpandableListView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQUIFPSCalculator f211098d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f211099e;

    /* renamed from: f, reason: collision with root package name */
    private long f211100f;

    /* renamed from: h, reason: collision with root package name */
    private String f211101h;

    public FPSPinnedHeaderExpandableListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f211099e = false;
            this.f211100f = 0L;
        }
    }

    public void d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QQUIFPSCalculator qQUIFPSCalculator = this.f211098d;
        if (qQUIFPSCalculator != null) {
            qQUIFPSCalculator.printLog();
        }
    }

    @Override // com.tencent.widget.AbsListView, android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        super.draw(canvas);
        QQUIFPSCalculator qQUIFPSCalculator = this.f211098d;
        if (qQUIFPSCalculator != null) {
            qQUIFPSCalculator.framAdd();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.f211099e) {
            this.f211099e = false;
            QQUIPerformanceReportUtils.saveCompleteTime(this.f211101h, SystemClock.uptimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AbsListView
    public void reportScrollStateChange(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        super.reportScrollStateChange(i3);
        QQUIFPSCalculator qQUIFPSCalculator = this.f211098d;
        if (qQUIFPSCalculator != null) {
            qQUIFPSCalculator.calculateFPS(i3);
        }
    }

    public void setActTAG(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        this.f211101h = str;
        QQUIFPSCalculator qQUIFPSCalculator = new QQUIFPSCalculator();
        this.f211098d = qQUIFPSCalculator;
        qQUIFPSCalculator.setActTAG(str);
        setStartTime(SystemClock.uptimeMillis());
    }

    public void setStartTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.f211099e = true;
            this.f211100f = j3;
        }
    }

    public FPSPinnedHeaderExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f211099e = false;
            this.f211100f = 0L;
        }
    }

    public FPSPinnedHeaderExpandableListView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            this.f211099e = false;
            this.f211100f = 0L;
        }
    }
}

package com.tencent.mobileqq.fpsreport;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.util.QQUIDropFrameMonitor;
import com.tencent.util.QQUIFPSCalculator;
import com.tencent.widget.XListView;

/* loaded from: classes12.dex */
public class FPSXListView extends XListView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQUIFPSCalculator f211104d;

    /* renamed from: e, reason: collision with root package name */
    private String f211105e;

    /* renamed from: f, reason: collision with root package name */
    private int f211106f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f211107h;

    public FPSXListView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public void b0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.f211107h = z16;
        }
    }

    @Override // com.tencent.widget.XListView, com.tencent.widget.AbsListView, android.view.View
    public void draw(Canvas canvas) {
        QQUIFPSCalculator qQUIFPSCalculator;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        super.draw(canvas);
        if (this.f211107h && (qQUIFPSCalculator = this.f211104d) != null) {
            qQUIFPSCalculator.framAdd();
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
        QQUIFPSCalculator qQUIFPSCalculator = this.f211104d;
        if (qQUIFPSCalculator != null) {
            qQUIFPSCalculator.calculateFPS(i3);
        }
        int i16 = this.f211106f;
        if (i16 == 1) {
            if (i3 == 0) {
                QQUIDropFrameMonitor.stopMonitorScene("list_leba_new", false);
                return;
            } else {
                QQUIDropFrameMonitor.startMonitorScene("list_leba_new");
                return;
            }
        }
        if (i16 == 2) {
            if (i3 == 0) {
                QQUIDropFrameMonitor.stopMonitorScene("list_leba_new", false);
            } else {
                QQUIDropFrameMonitor.startMonitorScene("list_leba_new");
            }
        }
    }

    public void setActTAG(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        this.f211105e = str;
        QQUIFPSCalculator qQUIFPSCalculator = new QQUIFPSCalculator();
        this.f211104d = qQUIFPSCalculator;
        qQUIFPSCalculator.setActTAG(str);
    }

    public void setReportType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.f211106f = i3;
        }
    }

    public FPSXListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public FPSXListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f211106f = 0;
            this.f211107h = true;
        }
    }
}

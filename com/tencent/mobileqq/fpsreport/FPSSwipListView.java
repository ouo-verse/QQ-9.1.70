package com.tencent.mobileqq.fpsreport;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.util.QQUIFPSCalculator;
import com.tencent.widget.SwipListView;

/* loaded from: classes12.dex */
public class FPSSwipListView extends SwipListView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQUIFPSCalculator f211102d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f211103e;

    public FPSSwipListView(Context context) {
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
            this.f211103e = z16;
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
        if (this.f211103e && (qQUIFPSCalculator = this.f211102d) != null) {
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
        QQUIFPSCalculator qQUIFPSCalculator = this.f211102d;
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
        QQUIFPSCalculator qQUIFPSCalculator = new QQUIFPSCalculator();
        this.f211102d = qQUIFPSCalculator;
        qQUIFPSCalculator.setActTAG(str);
    }

    public FPSSwipListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public FPSSwipListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f211103e = true;
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}

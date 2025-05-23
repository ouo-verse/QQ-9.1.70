package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class SoftInputDetectView extends RelativeLayout {
    static IPatchRedirector $redirector_;
    private a C;

    /* renamed from: d, reason: collision with root package name */
    private Rect f260483d;

    /* renamed from: e, reason: collision with root package name */
    private int f260484e;

    /* renamed from: f, reason: collision with root package name */
    private int f260485f;

    /* renamed from: h, reason: collision with root package name */
    private int f260486h;

    /* renamed from: i, reason: collision with root package name */
    private int f260487i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f260488m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void s6(boolean z16, int i3);
    }

    public SoftInputDetectView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        getWindowVisibleDisplayFrame(this.f260483d);
        int i17 = this.f260486h;
        boolean z17 = this.f260488m;
        Rect rect = this.f260483d;
        int i18 = rect.bottom;
        if (z17) {
            i18 -= rect.top;
        }
        if (this.f260485f <= 0) {
            this.f260485f = i18;
        }
        if (this.f260487i < 0) {
            this.f260487i = this.f260483d.top;
        }
        this.f260486h = i18;
        if (i18 >= 0 && i17 >= 0 && i18 != i17) {
            int i19 = this.f260487i;
            int i26 = this.f260483d.top;
            if (i19 != i26) {
                if (z17) {
                    this.f260485f -= i26 - i19;
                }
                this.f260487i = i26;
            }
            int i27 = this.f260485f;
            if (i18 >= i27) {
                z16 = false;
            }
            if (z16) {
                this.f260484e = i27 - i18;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SoftInputDetectView", 2, "Detected layout change. Input Method is showing? " + z16 + " Input Method Height is " + this.f260484e);
            }
            a aVar = this.C;
            if (aVar != null) {
                aVar.s6(z16, this.f260484e);
            }
        }
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(this.f260485f, 1073741824));
    }

    public void setExcludeStatusBar(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.f260488m = z16;
        }
    }

    public void setOnImStateChangedListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.C = aVar;
        }
    }

    public SoftInputDetectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f260483d = new Rect();
        this.f260484e = 0;
        this.f260485f = 0;
        this.f260486h = 0;
        this.f260487i = -1;
        this.f260488m = true;
        this.C = null;
    }
}

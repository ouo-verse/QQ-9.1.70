package com.tencent.mobileqq.app.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.utils.NumberWheelView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.VerticalGallery;

/* loaded from: classes11.dex */
public class TimeWheelPanel extends LinearLayout implements NumberWheelView.b {
    static IPatchRedirector $redirector_;
    private int C;
    private int D;
    public int E;
    public int F;
    public int G;
    private int H;
    private int I;
    private int J;
    private Context K;
    private LayoutInflater L;
    private NumberWheelView M;
    private NumberWheelView N;
    private NumberWheelView P;
    private TextView Q;
    private TextView R;
    private TextView S;
    private TextView T;
    private b U;
    private View V;
    private FrameLayout W;

    /* renamed from: a0, reason: collision with root package name */
    private FrameLayout f196622a0;

    /* renamed from: b0, reason: collision with root package name */
    private FrameLayout f196623b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f196624c0;

    /* renamed from: d, reason: collision with root package name */
    private final int f196625d;

    /* renamed from: d0, reason: collision with root package name */
    private String f196626d0;

    /* renamed from: e, reason: collision with root package name */
    private final int f196627e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f196628e0;

    /* renamed from: f, reason: collision with root package name */
    private final int f196629f;

    /* renamed from: h, reason: collision with root package name */
    private final int f196630h;

    /* renamed from: i, reason: collision with root package name */
    private int f196631i;

    /* renamed from: m, reason: collision with root package name */
    private int f196632m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends AccessibilityDelegateCompat {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TimeWheelPanel.this);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) accessibilityNodeInfoCompat);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setSelected(true);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) accessibilityEvent);
                return;
            }
            if (32768 == accessibilityEvent.getEventType()) {
                TimeWheelPanel.this.f();
            }
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        void i(NumberWheelView numberWheelView, VerticalGallery verticalGallery);
    }

    public TimeWheelPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f196625d = 30;
        this.f196627e = 24;
        this.f196629f = 60;
        this.f196630h = 60;
        this.f196624c0 = false;
        this.f196628e0 = false;
        this.K = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.Q != null && this.R != null && this.S != null && this.V != null && this.W != null && this.f196622a0 != null && this.f196623b0 != null) {
            StringBuilder sb5 = new StringBuilder();
            if (this.W.getVisibility() == 0) {
                sb5.append(this.E);
                sb5.append(this.Q.getText());
            }
            if (this.f196622a0.getVisibility() == 0) {
                sb5.append(this.F);
                sb5.append(this.R.getText());
            }
            if (this.f196623b0.getVisibility() == 0) {
                sb5.append(this.G);
                sb5.append(this.S.getText());
            }
            sb5.append("\uff0c");
            sb5.append(this.T.getText());
            sb5.append(this.S.getText());
            this.V.setContentDescription(sb5.toString());
        }
    }

    private void j() {
        if (this.L == null || this.M == null || this.N == null || this.P == null) {
            LayoutInflater from = LayoutInflater.from(this.K);
            this.L = from;
            from.inflate(R.layout.arz, this);
            this.M = (NumberWheelView) findViewById(R.id.bdz);
            this.N = (NumberWheelView) findViewById(R.id.d9k);
            this.P = (NumberWheelView) findViewById(R.id.ey7);
            this.Q = (TextView) findViewById(R.id.f164952be0);
            this.R = (TextView) findViewById(R.id.d9l);
            this.S = (TextView) findViewById(R.id.ey8);
            TextView textView = (TextView) findViewById(R.id.bxc);
            this.T = textView;
            ViewCompat.setImportantForAccessibility(textView, 2);
            this.W = (FrameLayout) findViewById(R.id.bdv);
            this.f196622a0 = (FrameLayout) findViewById(R.id.d9g);
            this.f196623b0 = (FrameLayout) findViewById(R.id.f166294ey4);
            this.V = findViewById(R.id.f82784ht);
            this.M.setScrollStateListener(this);
            this.N.setScrollStateListener(this);
            this.P.setScrollStateListener(this);
            this.M.setmMaxRotationAngle(0);
            this.N.setmMaxRotationAngle(0);
            this.P.setmMaxRotationAngle(0);
            this.M.setRange(0, this.f196631i - 1);
            this.N.setRange(0, 23);
            this.P.setRange(0, 59);
        }
        setValues(true);
        if (AppSetting.f99565y) {
            k();
            f();
        }
    }

    private void k() {
        ViewCompat.setAccessibilityDelegate(this.V, new a());
    }

    public void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.f196624c0 = z16;
        }
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return ((((this.E * 24) + this.F) * 60) + this.G) * 60;
    }

    public void h(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (i18 <= 0) {
            i18 = 30;
        }
        this.f196631i = i18;
        if (i3 < 0 || i3 >= i18) {
            i3 = 0;
        }
        this.f196632m = i3;
        if (i16 < 0 || i16 >= 24) {
            i16 = 0;
        }
        this.C = i16;
        if (i17 < 0 || i17 >= 60) {
            i17 = 0;
        }
        this.D = i17;
        this.E = i3;
        this.F = i16;
        this.G = i17;
        this.H = 1;
        this.I = 1;
        this.J = 1;
        j();
    }

    @Override // com.tencent.mobileqq.app.utils.NumberWheelView.b
    public void i(NumberWheelView numberWheelView, VerticalGallery verticalGallery) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) numberWheelView, (Object) verticalGallery);
            return;
        }
        this.E = this.M.D();
        this.F = this.N.D();
        this.G = this.P.D();
        setValues(false);
        b bVar = this.U;
        if (bVar != null) {
            bVar.i(numberWheelView, verticalGallery);
        }
    }

    public void setEndTime(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            setEndTime(str, null);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
    }

    public void setScrollerStateListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
        } else {
            this.U = bVar;
        }
    }

    public void setValues(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        if (this.H == 1 && this.I == 1 && this.J == 1) {
            if (this.E == 0 && this.F == 0 && this.G == 0 && !this.f196624c0) {
                this.G = 1;
                this.P.setValue(1);
            }
            if (z16) {
                this.M.setValue(this.E);
                this.N.setValue(this.F);
                this.P.setValue(this.G);
            }
        }
    }

    public void setViewVisibility(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 == 0) {
            findViewById(R.id.bdv).setVisibility(i16);
            return;
        }
        if (i3 == 1) {
            findViewById(R.id.d9g).setVisibility(i16);
        } else if (i3 == 2) {
            findViewById(R.id.f166294ey4).setVisibility(i16);
        } else if (i3 == 3) {
            this.T.setVisibility(i16);
        }
    }

    public void setEndTime(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.f196626d0 = str2;
        if (str2 == null) {
            this.T.setText(str);
            this.f196628e0 = false;
        } else {
            if (this.f196628e0) {
                this.T.setText(str2);
            } else {
                this.T.setText(str);
            }
            this.T.post(new Runnable() { // from class: com.tencent.mobileqq.app.utils.TimeWheelPanel.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TimeWheelPanel.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (TimeWheelPanel.this.T.getLayout().getEllipsisCount(TimeWheelPanel.this.T.getLineCount() - 1) > 0 && TimeWheelPanel.this.f196626d0 != null && !TimeWheelPanel.this.T.getText().toString().equals(TimeWheelPanel.this.f196626d0)) {
                        TimeWheelPanel.this.f196628e0 = true;
                        TimeWheelPanel.this.T.setText(TimeWheelPanel.this.f196626d0);
                    }
                }
            });
        }
    }
}

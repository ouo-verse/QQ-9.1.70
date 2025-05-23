package com.tencent.mobileqq.webview.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WebViewTopTabView extends RadioGroup {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    RadioButton f314841d;

    /* renamed from: e, reason: collision with root package name */
    RadioButton f314842e;

    /* renamed from: f, reason: collision with root package name */
    LayoutInflater f314843f;

    /* renamed from: h, reason: collision with root package name */
    public int[] f314844h;

    public WebViewTopTabView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f314844h = null;
        super.setOrientation(0);
        this.f314843f = LayoutInflater.from(context);
    }

    RadioButton a(int i3) {
        RadioButton webViewTopTabRadioButton;
        LayoutInflater layoutInflater = this.f314843f;
        if (layoutInflater != null) {
            webViewTopTabRadioButton = (RadioButton) layoutInflater.inflate(R.layout.c3p, (ViewGroup) this, false);
        } else {
            webViewTopTabRadioButton = new WebViewTopTabRadioButton(super.getContext(), null);
            webViewTopTabRadioButton.setButtonDrawable(super.getContext().getResources().getDrawable(17170445));
            webViewTopTabRadioButton.setTextSize(14.0f);
            webViewTopTabRadioButton.setGravity(17);
        }
        webViewTopTabRadioButton.setId(i3);
        return webViewTopTabRadioButton;
    }

    public int[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (int[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        int childCount = super.getChildCount();
        if (childCount > 0) {
            int[] iArr = new int[childCount];
            Arrays.fill(iArr, -1);
            for (int i3 = 0; i3 < childCount; i3++) {
                iArr[i3] = ((WebViewTopTabRadioButton) super.getChildAt(i3)).f314839h ? 1 : 0;
            }
            return iArr;
        }
        return null;
    }

    public void setButtonBackgroundResource(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        RadioButton radioButton = this.f314841d;
        if (radioButton != null) {
            radioButton.setBackgroundResource(i3);
        }
        for (int i18 = 1; i18 < super.getChildCount() - 1; i18++) {
            super.getChildAt(i18).setBackgroundResource(i16);
        }
        RadioButton radioButton2 = this.f314842e;
        if (radioButton2 != null) {
            radioButton2.setBackgroundResource(i17);
        }
    }

    public void setButtonNum(int i3, int i16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 < 2) {
            i3 = 2;
        }
        if (i16 < 0 || i16 >= i3) {
            i16 = 0;
        }
        this.f314844h = new int[i3];
        for (int i18 = 0; i18 < i3; i18++) {
            this.f314844h[i18] = i18;
        }
        super.removeAllViews();
        RadioButton a16 = a(this.f314844h[0]);
        this.f314841d = a16;
        if (a16.getLayoutParams() == null) {
            super.addView(this.f314841d, new LinearLayout.LayoutParams(-2, x.c(super.getContext(), 30.0f)));
        } else {
            super.addView(this.f314841d);
        }
        int i19 = 1;
        while (true) {
            i17 = i3 - 1;
            if (i19 >= i17) {
                break;
            }
            RadioButton a17 = a(this.f314844h[i19]);
            if (a17.getLayoutParams() == null) {
                super.addView(a17, new LinearLayout.LayoutParams(-2, x.c(super.getContext(), 30.0f)));
            } else {
                super.addView(a17);
            }
            i19++;
        }
        RadioButton a18 = a(this.f314844h[i17]);
        this.f314842e = a18;
        if (a18 == null) {
            super.addView(this.f314842e, new LinearLayout.LayoutParams(-2, x.c(super.getContext(), 30.0f)));
        } else {
            super.addView(a18);
        }
        super.setGravity(16);
        ((RadioButton) super.getChildAt(i16)).setChecked(true);
    }

    public void setButtonText(String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) strArr);
            return;
        }
        if (super.getChildCount() > 0 && strArr != null && strArr.length > 0) {
            for (int i3 = 0; i3 < super.getChildCount(); i3++) {
                RadioButton radioButton = (RadioButton) super.getChildAt(i3);
                if (i3 < strArr.length) {
                    radioButton.setText(strArr[i3]);
                } else {
                    return;
                }
            }
        }
    }

    public void setButtonTextColorStateList(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        for (int i16 = 0; i16 < super.getChildCount(); i16++) {
            ((RadioButton) super.getChildAt(i16)).setTextColor(super.getContext().getResources().getColorStateList(i3));
        }
    }

    public void setLeftAndRightPaddingByDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        for (int i16 = 0; i16 < super.getChildCount(); i16++) {
            float f16 = i3;
            super.getChildAt(i16).setPadding(x.c(super.getContext(), f16), super.getPaddingTop(), x.c(super.getContext(), f16), super.getPaddingBottom());
        }
    }

    public void setRedHotStatus(int[] iArr, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, iArr, Boolean.valueOf(z16));
            return;
        }
        if (iArr != null && iArr.length > 0) {
            for (int i3 : iArr) {
                if (i3 >= 0 && i3 < super.getChildCount()) {
                    WebViewTopTabRadioButton webViewTopTabRadioButton = (WebViewTopTabRadioButton) super.getChildAt(i3);
                    if (webViewTopTabRadioButton.f314839h != z16) {
                        webViewTopTabRadioButton.f314839h = z16;
                        webViewTopTabRadioButton.invalidate();
                    }
                }
            }
        }
    }

    public void setSelectedTab(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else if (super.getChildCount() > 0) {
            if (i3 < 0 || i3 >= super.getChildCount()) {
                i3 = 0;
            }
            ((RadioButton) super.getChildAt(i3)).setChecked(true);
        }
    }

    public void setTextSize(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
        } else if (super.getChildCount() > 0) {
            for (int i3 = 0; i3 < super.getChildCount(); i3++) {
                ((RadioButton) super.getChildAt(i3)).setTextSize(f16);
            }
        }
    }
}

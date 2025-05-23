package com.tencent.fastertextview.wrapper;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FasterTextView;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private FasterTextView f105530a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f105531b;

    public a(TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) textView);
        } else {
            this.f105531b = textView;
        }
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        TextView textView = this.f105531b;
        if (textView != null) {
            return textView.getMinHeight();
        }
        FasterTextView fasterTextView = this.f105530a;
        if (fasterTextView != null) {
            return fasterTextView.getMinHeight();
        }
        return -1;
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        TextView textView = this.f105531b;
        if (textView != null) {
            return textView.getMinWidth();
        }
        FasterTextView fasterTextView = this.f105530a;
        if (fasterTextView != null) {
            return fasterTextView.getMinWidth();
        }
        return -1;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        TextView textView = this.f105531b;
        if (textView != null) {
            return textView.getPaddingBottom();
        }
        FasterTextView fasterTextView = this.f105530a;
        if (fasterTextView != null) {
            return fasterTextView.getPaddingBottom();
        }
        return 0;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        TextView textView = this.f105531b;
        if (textView != null) {
            return textView.getPaddingLeft();
        }
        FasterTextView fasterTextView = this.f105530a;
        if (fasterTextView != null) {
            return fasterTextView.getPaddingLeft();
        }
        return 0;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        TextView textView = this.f105531b;
        if (textView != null) {
            return textView.getPaddingRight();
        }
        FasterTextView fasterTextView = this.f105530a;
        if (fasterTextView != null) {
            return fasterTextView.getPaddingRight();
        }
        return 0;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        TextView textView = this.f105531b;
        if (textView != null) {
            return textView.getPaddingTop();
        }
        FasterTextView fasterTextView = this.f105530a;
        if (fasterTextView != null) {
            return fasterTextView.getPaddingTop();
        }
        return 0;
    }

    @Nullable
    public View g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        TextView textView = this.f105531b;
        if (textView == null) {
            return this.f105530a;
        }
        return textView;
    }

    public void h(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) drawable);
            return;
        }
        TextView textView = this.f105531b;
        if (textView != null) {
            textView.setBackground(drawable);
            return;
        }
        FasterTextView fasterTextView = this.f105530a;
        if (fasterTextView != null) {
            fasterTextView.setBackground(drawable);
        }
    }

    public void i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
            return;
        }
        TextView textView = this.f105531b;
        if (textView != null) {
            textView.setHighlightColor(i3);
            return;
        }
        FasterTextView fasterTextView = this.f105530a;
        if (fasterTextView != null) {
            fasterTextView.setHighlightColor(i3);
        }
    }

    public void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        TextView textView = this.f105531b;
        if (textView != null) {
            textView.setMinHeight(i3);
            return;
        }
        FasterTextView fasterTextView = this.f105530a;
        if (fasterTextView != null) {
            fasterTextView.setMinHeight(i3);
        }
    }

    public void k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        TextView textView = this.f105531b;
        if (textView != null) {
            textView.setMinWidth(i3);
            return;
        }
        FasterTextView fasterTextView = this.f105530a;
        if (fasterTextView != null) {
            fasterTextView.setMinWidth(i3);
        }
    }

    public void l(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        TextView textView = this.f105531b;
        if (textView != null) {
            textView.setPadding(i3, i16, i17, i18);
            return;
        }
        FasterTextView fasterTextView = this.f105530a;
        if (fasterTextView != null) {
            fasterTextView.setPadding(i3, i16, i17, i18);
        }
    }

    public void m(@NotNull CharSequence charSequence, @NotNull TextView.BufferType bufferType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) charSequence, (Object) bufferType);
            return;
        }
        TextView textView = this.f105531b;
        if (textView != null) {
            textView.setText(charSequence, bufferType);
            return;
        }
        FasterTextView fasterTextView = this.f105530a;
        if (fasterTextView != null) {
            fasterTextView.setText(charSequence, bufferType);
        }
    }

    public void n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
            return;
        }
        TextView textView = this.f105531b;
        if (textView != null) {
            textView.setTextColor(i3);
            return;
        }
        FasterTextView fasterTextView = this.f105530a;
        if (fasterTextView != null) {
            fasterTextView.setTextColor(i3);
        }
    }

    public void o(ColorStateList colorStateList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) colorStateList);
            return;
        }
        TextView textView = this.f105531b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
            return;
        }
        FasterTextView fasterTextView = this.f105530a;
        if (fasterTextView != null) {
            fasterTextView.setTextColor(colorStateList);
        }
    }

    public void p(int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Float.valueOf(f16));
            return;
        }
        TextView textView = this.f105531b;
        if (textView != null) {
            textView.setTextSize(i3, f16);
            return;
        }
        FasterTextView fasterTextView = this.f105530a;
        if (fasterTextView != null) {
            fasterTextView.setTextSize(i3, f16);
        }
    }
}

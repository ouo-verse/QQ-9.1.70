package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes25.dex */
public class Dashboard extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final StringBuilder f368785a;

    /* renamed from: b, reason: collision with root package name */
    TextView f368786b;

    /* renamed from: c, reason: collision with root package name */
    TextView f368787c;

    /* renamed from: d, reason: collision with root package name */
    private final SimpleDateFormat f368788d;

    /* renamed from: e, reason: collision with root package name */
    private ScrollView f368789e;

    /* renamed from: f, reason: collision with root package name */
    private int f368790f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f368791g;

    public Dashboard(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public final void a(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        TextView textView = this.f368786b;
        if (textView != null) {
            textView.setPadding(i3, i16, i17, 0);
        }
        ScrollView scrollView = this.f368789e;
        if (scrollView != null) {
            scrollView.setPadding(i3, 0, i17, i18);
        }
    }

    public void setEventTextSize(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
            return;
        }
        TextView textView = this.f368787c;
        if (textView != null) {
            textView.setTextSize(f16);
        }
    }

    public void setMessageMaxLength(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.f368790f = i3;
        }
    }

    public void setShowLevel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                a();
                this.f368786b.setVisibility(0);
                this.f368789e.setVisibility(0);
                setVisibility(0);
                return;
            }
            a();
            this.f368786b.setVisibility(0);
            this.f368789e.setVisibility(4);
            setVisibility(0);
            return;
        }
        TextView textView = this.f368786b;
        if (textView != null) {
            textView.setVisibility(4);
        }
        ScrollView scrollView = this.f368789e;
        if (scrollView != null) {
            scrollView.setVisibility(4);
        }
        setVisibility(4);
    }

    public void setStatusText(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) charSequence);
            return;
        }
        TextView textView = this.f368786b;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setStatusTextSize(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
            return;
        }
        TextView textView = this.f368786b;
        if (textView != null) {
            textView.setTextSize(f16);
        }
    }

    public Dashboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f368785a = new StringBuilder();
        this.f368788d = new SimpleDateFormat("HH:mm:ss.SSS", Locale.ENGLISH);
        this.f368790f = 3000;
        this.f368791g = false;
        setOrientation(1);
        setVisibility(8);
    }

    private void a() {
        if (this.f368786b != null) {
            return;
        }
        this.f368786b = new TextView(getContext());
        this.f368787c = new TextView(getContext());
        this.f368789e = new ScrollView(getContext());
        this.f368786b.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f368786b.setTextColor(-49023);
        this.f368786b.setTypeface(Typeface.MONOSPACE);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f368789e.setPadding(0, 10, 0, 0);
        this.f368789e.setLayoutParams(layoutParams);
        this.f368789e.setVerticalScrollBarEnabled(true);
        this.f368789e.setScrollbarFadingEnabled(true);
        this.f368787c.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f368787c.setTextColor(-49023);
        this.f368789e.addView(this.f368787c);
        addView(this.f368786b);
        addView(this.f368789e);
        if (this.f368785a.length() <= 0) {
            this.f368785a.append("liteav sdk version:\n");
        }
        this.f368787c.setText(this.f368785a.toString());
    }
}

package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.microapp.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class d extends ReportDialog implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    TextView f246115a;

    /* renamed from: b, reason: collision with root package name */
    TextView f246116b;

    /* renamed from: c, reason: collision with root package name */
    TextView f246117c;

    /* renamed from: d, reason: collision with root package name */
    TextView f246118d;

    /* renamed from: e, reason: collision with root package name */
    View f246119e;

    /* renamed from: f, reason: collision with root package name */
    Bundle f246120f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f246121g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f246122h;

    public d(@NonNull Context context) {
        super(context, R.style.a);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            a(context);
        }
    }

    private void a(@NonNull Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.a, (ViewGroup) null);
        setContentView(inflate);
        this.f246115a = (TextView) inflate.findViewById(R.id.h);
        this.f246116b = (TextView) inflate.findViewById(R.id.g);
        this.f246117c = (TextView) inflate.findViewById(R.id.e);
        this.f246118d = (TextView) inflate.findViewById(R.id.f);
        this.f246119e = inflate.findViewById(R.id.d);
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f246122h : ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f246121g;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else if (view.getId() == R.id.e) {
            b(true);
            dismiss();
        } else if (view.getId() == R.id.f) {
            a(true);
            dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            this.f246121g = z16;
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        }
    }

    public void a(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f246120f = bundle;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
        }
    }

    public Bundle a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f246120f : (Bundle) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z16, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, str3, str4, str5, str6, Boolean.valueOf(z16), onClickListener);
            return;
        }
        this.f246122h = false;
        this.f246121g = false;
        TextView textView = this.f246115a;
        if (textView != null) {
            textView.setText(str);
            this.f246115a.setContentDescription(str);
        }
        TextView textView2 = this.f246116b;
        if (textView2 != null) {
            textView2.setText(str2);
            this.f246116b.setContentDescription(str2);
        }
        if (this.f246117c != null) {
            if (!TextUtils.isEmpty(str4)) {
                try {
                    this.f246117c.setTextColor(Color.parseColor(str4));
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f246117c.setText(str3);
            this.f246117c.setContentDescription(str3);
            if (onClickListener != null) {
                this.f246117c.setOnClickListener(onClickListener);
            } else {
                this.f246117c.setOnClickListener(this);
            }
        }
        if (z16) {
            if (this.f246118d != null) {
                if (!TextUtils.isEmpty(str6)) {
                    try {
                        this.f246118d.setTextColor(Color.parseColor(str6));
                    } catch (IllegalArgumentException unused2) {
                    }
                }
                this.f246118d.setText(str5);
                this.f246118d.setContentDescription(str5);
                if (onClickListener != null) {
                    this.f246118d.setOnClickListener(onClickListener);
                } else {
                    this.f246118d.setOnClickListener(this);
                }
            }
        } else {
            TextView textView3 = this.f246118d;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            View view = this.f246119e;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        show();
    }

    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            this.f246122h = z16;
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        }
    }
}

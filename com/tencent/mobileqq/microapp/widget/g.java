package com.tencent.mobileqq.microapp.widget;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.microapp.R;
import com.tencent.mobileqq.microapp.apkg.j;
import com.tencent.mobileqq.microapp.apkg.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.widget.ToastView;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    View f246129a;

    /* renamed from: b, reason: collision with root package name */
    ViewGroup f246130b;

    /* renamed from: c, reason: collision with root package name */
    Handler f246131c;

    /* renamed from: d, reason: collision with root package name */
    Runnable f246132d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f246133e;

    /* renamed from: f, reason: collision with root package name */
    public String f246134f;

    /* renamed from: g, reason: collision with root package name */
    public j f246135g;

    /* renamed from: h, reason: collision with root package name */
    public k f246136h;

    /* renamed from: i, reason: collision with root package name */
    public List f246137i;

    /* renamed from: j, reason: collision with root package name */
    private Resources f246138j;

    /* renamed from: k, reason: collision with root package name */
    private LayoutInflater f246139k;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f246140l;

    /* renamed from: m, reason: collision with root package name */
    private CharSequence f246141m;

    /* renamed from: n, reason: collision with root package name */
    private int f246142n;

    /* renamed from: o, reason: collision with root package name */
    private Map f246143o;

    private void a(Drawable drawable) {
        this.f246140l = drawable;
    }

    private void b(int i3) {
        this.f246142n = i3;
    }

    private int c(String str) {
        if ("success".equals(str)) {
            return R.drawable.a;
        }
        if ("warn".equals(str)) {
            return R.drawable.b;
        }
        if (ToastView.ICON_LOADING.equals(str)) {
            return R.drawable.d;
        }
        "none".equals(str);
        return 0;
    }

    private void a(int i3) {
        if (i3 != 0) {
            a(this.f246138j.getDrawable(i3));
        }
    }

    private void b() {
        View view;
        QLog.d(ToastView.TAG, 4, "show mParentView=" + this.f246130b + ",toastLayout=" + this.f246129a);
        ViewGroup viewGroup = this.f246130b;
        if (viewGroup == null || (view = this.f246129a) == null) {
            return;
        }
        viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
        int i3 = this.f246142n;
        if (i3 > -1) {
            this.f246131c.postDelayed(this.f246132d, i3);
        }
    }

    private void a(CharSequence charSequence) {
        this.f246141m = charSequence;
    }

    private void a(boolean z16) {
        View inflate = this.f246139k.inflate(R.layout.c, (ViewGroup) null);
        this.f246129a = inflate;
        inflate.setClickable(z16);
        ImageView imageView = (ImageView) this.f246129a.findViewById(R.id.n);
        if (this.f246140l != null) {
            imageView.setVisibility(0);
            imageView.setImageDrawable(this.f246140l);
        } else {
            imageView.setVisibility(8);
        }
        if (this.f246141m != null) {
            ((TextView) this.f246129a.findViewById(R.id.o)).setText(this.f246141m);
        }
    }

    public j b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (j) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        j jVar = (j) this.f246143o.get(com.tencent.mobileqq.microapp.a.c.n(str));
        return jVar == null ? this.f246135g : jVar;
    }

    public void a(String str, String str2, CharSequence charSequence, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, charSequence, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        QLog.d(ToastView.TAG, 4, "show iconType=" + str + ",localIconPath=" + str2 + ",msg=" + ((Object) charSequence) + ",duration=" + i3 + ",mask=" + z16);
        if (!TextUtils.isEmpty(str2)) {
            a(new BitmapDrawable(str2));
        } else {
            a(c(str));
        }
        a(charSequence);
        b(i3);
        a();
        a(z16);
        b();
    }

    public void a() {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f246131c.removeCallbacks(this.f246132d);
        QLog.d(ToastView.TAG, 4, "hide mParentView=" + this.f246130b + ",toastLayout=" + this.f246129a);
        ViewGroup viewGroup = this.f246130b;
        if (viewGroup == null || (view = this.f246129a) == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    public String a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (StringUtil.isEmpty(str)) {
            return "";
        }
        String n3 = com.tencent.mobileqq.microapp.a.c.n(str);
        for (String str2 : this.f246137i) {
            String substring = str2.startsWith("/") ? str2.substring(1) : str2;
            if (substring.endsWith("/")) {
                substring = substring.substring(0, substring.length() - 1);
            }
            if ((n3.startsWith("/") ? n3.substring(1) : n3).startsWith(substring)) {
                return str2;
            }
        }
        return "";
    }
}

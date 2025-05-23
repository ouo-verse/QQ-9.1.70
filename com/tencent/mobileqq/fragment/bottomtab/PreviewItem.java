package com.tencent.mobileqq.fragment.bottomtab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.BaseApplication;

/* loaded from: classes12.dex */
public class PreviewItem {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final int f211351a;

    /* renamed from: b, reason: collision with root package name */
    private final String f211352b;

    /* renamed from: c, reason: collision with root package name */
    private final String f211353c;

    /* renamed from: d, reason: collision with root package name */
    private a f211354d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f211355e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f211356f;

    /* renamed from: g, reason: collision with root package name */
    private c f211357g;

    /* renamed from: h, reason: collision with root package name */
    int f211358h;

    public PreviewItem(int i3, String str, String str2, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2, cVar);
            return;
        }
        this.f211351a = i3;
        this.f211352b = str;
        this.f211353c = str2;
        this.f211357g = cVar;
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i3) {
        if (this.f211355e.getVisibility() == 0 && i3 == 0) {
            this.f211354d.b();
        } else {
            this.f211354d.c(i3);
        }
    }

    private void f() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(BaseApplication.getContext()).inflate(R.layout.fa_, (ViewGroup) null);
        this.f211355e = linearLayout;
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.icon);
        imageView.setImageResource(this.f211351a);
        TextView textView = (TextView) this.f211355e.findViewById(R.id.title);
        textView.setText(this.f211352b);
        AccessibilityUtil.n(textView, false);
        this.f211354d = new a(this.f211355e, this.f211353c);
        this.f211355e.setContentDescription(this.f211352b);
        if (this.f211357g.c()) {
            int dip2px = DisplayUtil.dip2px(BaseApplication.getContext(), 45.0f);
            int dip2px2 = DisplayUtil.dip2px(BaseApplication.getContext(), 55.0f);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = dip2px;
            layoutParams.height = dip2px2;
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.fragment.bottomtab.PreviewItem.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreviewItem.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        PreviewItem previewItem = PreviewItem.this;
                        previewItem.c(previewItem.f211358h);
                    }
                }
            });
        }
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f211353c;
    }

    public View e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f211355e;
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f211356f;
    }

    public void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.f211358h = i3;
        }
    }

    public void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.f211356f = z16;
        }
    }
}

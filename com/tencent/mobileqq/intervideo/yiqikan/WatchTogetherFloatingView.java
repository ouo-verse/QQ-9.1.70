package com.tencent.mobileqq.intervideo.yiqikan;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes15.dex */
public class WatchTogetherFloatingView extends FrameLayout {
    static IPatchRedirector $redirector_;
    private int C;
    private a D;

    /* renamed from: d, reason: collision with root package name */
    private ViewGroup f238470d;

    /* renamed from: e, reason: collision with root package name */
    private TouchWebView f238471e;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f238472f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f238473h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f238474i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f238475m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        WeakReference<WatchTogetherFloatingView> f238476a;

        public a(WatchTogetherFloatingView watchTogetherFloatingView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) watchTogetherFloatingView);
            } else {
                this.f238476a = new WeakReference<>(watchTogetherFloatingView);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        removeMessages(2);
                        return;
                    }
                    return;
                } else {
                    try {
                        this.f238476a.get().d();
                        return;
                    } catch (NullPointerException unused) {
                        if (QLog.isColorLevel()) {
                            QLog.d("WatchTogetherFloatingView", 2, "MESSAGE_WAIT_LOADING END, but View missing");
                            return;
                        }
                        return;
                    }
                }
            }
            sendEmptyMessageDelayed(2, 20000L);
        }
    }

    public WatchTogetherFloatingView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.C = 0;
        this.D = new a(this);
        c();
    }

    private void c() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.at8, (ViewGroup) this, true);
        this.f238470d = viewGroup;
        this.f238472f = (RelativeLayout) viewGroup.findViewById(R.id.i6w);
        this.f238473h = (TextView) this.f238470d.findViewById(R.id.jdl);
        this.f238474i = (LinearLayout) this.f238470d.findViewById(R.id.f166098gi2);
        this.f238475m = (ImageView) this.f238470d.findViewById(R.id.g0i);
    }

    private void g() {
        View findViewById;
        if ((getParent() instanceof FrameLayout) && (findViewById = ((FrameLayout) getParent().getParent()).findViewById(R.id.m2t)) != null) {
            String string = getContext().getString(R.string.w5g);
            int i3 = this.C;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        string = getContext().getString(R.string.w5d);
                    }
                } else {
                    string = getContext().getString(R.string.w5g);
                }
            } else {
                string = getContext().getString(R.string.w5e);
            }
            findViewById.setContentDescription(string);
        }
    }

    public void a(TouchWebView touchWebView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) touchWebView);
            return;
        }
        if (this.f238470d != null && touchWebView != null) {
            TouchWebView touchWebView2 = this.f238471e;
            if (touchWebView2 != null) {
                ViewParent parent = touchWebView2.getParent();
                ViewGroup viewGroup = this.f238470d;
                if (parent == viewGroup) {
                    viewGroup.removeView(this.f238471e);
                }
            }
            touchWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.f238470d.addView(touchWebView, 0);
            this.f238471e = touchWebView;
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.C;
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.D.sendEmptyMessage(3);
        this.f238472f.setVisibility(0);
        this.f238473h.setVisibility(8);
        this.f238474i.setVisibility(0);
        this.C = 2;
        g();
        TouchWebView touchWebView = this.f238471e;
        if (touchWebView != null) {
            touchWebView.loadUrl("about:blank");
        }
    }

    public void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        if (z16) {
            this.D.sendEmptyMessage(1);
            this.f238472f.setVisibility(0);
            this.f238473h.setVisibility(0);
            this.f238474i.setVisibility(8);
            this.C = 0;
        } else {
            this.D.sendEmptyMessage(3);
            this.f238473h.setVisibility(8);
            this.f238472f.setVisibility(8);
            this.f238474i.setVisibility(8);
            this.C = 1;
        }
        g();
    }

    public void f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        e(true);
        TouchWebView touchWebView = this.f238471e;
        if (touchWebView != null) {
            touchWebView.loadUrl("about:blank");
            this.f238471e.loadUrl(str);
        }
    }
}

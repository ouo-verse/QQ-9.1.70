package com.tencent.mobileqq.filebrowser.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.widget.tip.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class FileBrowserViewBase {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    private static com.tencent.mobileqq.widget.tip.a f206083j;

    /* renamed from: a, reason: collision with root package name */
    protected View f206084a;

    /* renamed from: b, reason: collision with root package name */
    protected Activity f206085b;

    /* renamed from: c, reason: collision with root package name */
    protected RelativeLayout f206086c;

    /* renamed from: d, reason: collision with root package name */
    protected ProgressBar f206087d;

    /* renamed from: e, reason: collision with root package name */
    protected TextView f206088e;

    /* renamed from: f, reason: collision with root package name */
    protected View f206089f;

    /* renamed from: g, reason: collision with root package name */
    protected TextView f206090g;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f206091h;

    /* renamed from: i, reason: collision with root package name */
    protected Bundle f206092i;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f206095d;

        a(View.OnClickListener onClickListener) {
            this.f206095d = onClickListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileBrowserViewBase.this, (Object) onClickListener);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                com.tencent.mobileqq.filemanager.fileviewer.onlineprint.h.f208453a.c("btn_print");
                this.f206095d.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements a.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileBrowserViewBase.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public /* bridge */ /* synthetic */ void onClick(View view) {
            l53.d.a(this, view);
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                FileBrowserViewBase.f206083j = null;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onShow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    public FileBrowserViewBase(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
        } else {
            this.f206085b = activity;
        }
    }

    private void h(View view) {
        com.tencent.mobileqq.filemanager.fileviewer.onlineprint.h hVar = com.tencent.mobileqq.filemanager.fileviewer.onlineprint.h.f208453a;
        if (!hVar.e("btn_print")) {
            return;
        }
        hVar.b("btn_print");
        com.tencent.mobileqq.widget.tip.a m06 = QUIDefaultBubbleTip.r(this.f206085b).S(view).o0(this.f206085b.getString(R.string.f174962x_)).i0(0.0f, -8.0f).k0(0).R(0).f(new b()).m0(1);
        f206083j = m06;
        m06.s0();
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        com.tencent.mobileqq.widget.tip.a aVar = f206083j;
        if (aVar != null) {
            aVar.o();
        }
        f206083j = null;
    }

    public View c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f206084a;
    }

    public void d(String str, int i3, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), onClickListener);
        } else {
            e(str, onClickListener);
        }
    }

    public void e(String str, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) onClickListener);
            return;
        }
        if (this.f206091h == null) {
            this.f206091h = (TextView) this.f206084a.findViewById(R.id.fdn);
        }
        TextView textView = this.f206091h;
        if (textView != null) {
            textView.setText(str);
            this.f206091h.setOnClickListener(onClickListener);
            this.f206091h.setVisibility(0);
            o(true);
        }
    }

    public void f(View.OnClickListener onClickListener, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, onClickListener, Boolean.valueOf(z16));
            return;
        }
        TextView textView = (TextView) this.f206084a.findViewById(R.id.f107976bv);
        if (textView == null) {
            QLog.d("FileBrowserViewBase", 1, "initFilePrint not find tv print");
            return;
        }
        if (onClickListener != null) {
            textView.setVisibility(0);
            textView.setOnClickListener(new a(onClickListener));
            h(textView);
        } else {
            textView.setVisibility(8);
        }
        if (z16) {
            TextView textView2 = (TextView) this.f206084a.findViewById(R.id.lk7);
            textView2.setVisibility(0);
            View findViewById = this.f206084a.findViewById(R.id.bmt);
            if (textView.getVisibility() == 0 && findViewById != null) {
                findViewById.setVisibility(0);
            }
            textView.post(new Runnable(textView, textView2) { // from class: com.tencent.mobileqq.filebrowser.view.FileBrowserViewBase.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ TextView f206093d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ TextView f206094e;

                {
                    this.f206093d = textView;
                    this.f206094e = textView2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, FileBrowserViewBase.this, textView, textView2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ViewGroup.LayoutParams layoutParams = this.f206093d.getLayoutParams();
                    layoutParams.width = this.f206094e.getWidth();
                    this.f206093d.setLayoutParams(layoutParams);
                }
            });
        }
    }

    public abstract void g();

    public void i(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) onClickListener);
            return;
        }
        View view = this.f206084a;
        if (view != null && this.f206086c == null) {
            this.f206086c = (RelativeLayout) view.findViewById(R.id.jvt);
            this.f206087d = (ProgressBar) this.f206084a.findViewById(R.id.jv8);
            this.f206088e = (TextView) this.f206084a.findViewById(R.id.jvc);
            this.f206090g = (TextView) this.f206084a.findViewById(R.id.lgk);
            this.f206089f = this.f206084a.findViewById(R.id.jv7);
        }
        this.f206089f.setOnClickListener(onClickListener);
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        b();
        TextView textView = (TextView) this.f206084a.findViewById(R.id.f107976bv);
        if (textView != null) {
            textView.setVisibility(8);
        }
        View findViewById = this.f206084a.findViewById(R.id.bmt);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    public void k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            return;
        }
        TextView textView = this.f206090g;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void l(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bundle);
        } else {
            this.f206092i = bundle;
        }
    }

    public void m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        TextView textView = this.f206088e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else if (this.f206086c != null) {
            this.f206087d.setProgress(i3);
        }
    }

    public void o(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        TextView textView = this.f206091h;
        if (textView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
    }

    public void p(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        TextView textView = this.f206090g;
        if (textView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
    }

    public void q(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        RelativeLayout relativeLayout = this.f206086c;
        if (relativeLayout != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            relativeLayout.setVisibility(i3);
        }
    }
}

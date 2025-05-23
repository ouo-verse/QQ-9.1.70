package com.tencent.mobileqq.filebrowser.view;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanageraux.widget.TriangleView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

/* compiled from: P */
/* loaded from: classes12.dex */
public class i extends FileBrowserViewBase {
    static IPatchRedirector $redirector_;
    private ProgressBar A;
    private TextView B;
    private BaseAdapter C;
    private int D;

    /* renamed from: k, reason: collision with root package name */
    private XListView f206151k;

    /* renamed from: l, reason: collision with root package name */
    private TriangleView f206152l;

    /* renamed from: m, reason: collision with root package name */
    private View f206153m;

    /* renamed from: n, reason: collision with root package name */
    private View f206154n;

    /* renamed from: o, reason: collision with root package name */
    private View f206155o;

    /* renamed from: p, reason: collision with root package name */
    private View f206156p;

    /* renamed from: q, reason: collision with root package name */
    private TextView f206157q;

    /* renamed from: r, reason: collision with root package name */
    private TextView f206158r;

    /* renamed from: s, reason: collision with root package name */
    private TextView f206159s;

    /* renamed from: t, reason: collision with root package name */
    private TextView f206160t;

    /* renamed from: u, reason: collision with root package name */
    private View f206161u;

    /* renamed from: v, reason: collision with root package name */
    private TextView f206162v;

    /* renamed from: w, reason: collision with root package name */
    private TextView f206163w;

    /* renamed from: x, reason: collision with root package name */
    private TextView f206164x;

    /* renamed from: y, reason: collision with root package name */
    private TextView f206165y;

    /* renamed from: z, reason: collision with root package name */
    private RelativeLayout f206166z;

    public i(Activity activity) {
        super(activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
        }
    }

    private void G() {
        RelativeLayout relativeLayout;
        boolean z16;
        int i3;
        if (this.f206153m == null) {
            return;
        }
        View view = this.f206155o;
        if ((view != null && view.getVisibility() == 0) || ((relativeLayout = this.f206086c) != null && relativeLayout.getVisibility() == 0)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || this.f206153m.getPaddingBottom() == 0) {
            if (!z16 && this.f206153m.getPaddingBottom() == 0) {
                return;
            }
            View view2 = this.f206153m;
            int paddingTop = view2.getPaddingTop();
            if (z16) {
                i3 = ViewUtils.dip2px(60.0f);
            } else {
                i3 = 0;
            }
            view2.setPadding(0, paddingTop, 0, i3);
        }
    }

    public void A(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.f206162v.setText(str);
        }
    }

    public void B(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else if (!z16) {
            this.f206161u.setVisibility(8);
        } else {
            this.f206161u.setVisibility(0);
            this.D = 0;
        }
    }

    public void C(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        if (z16 && this.D == 2) {
            this.f206155o.setVisibility(0);
        } else {
            this.f206155o.setVisibility(8);
        }
        G();
    }

    public void D(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        TextView textView = this.f206165y;
        if (textView != null) {
            RelativeLayout relativeLayout = this.f206086c;
            int i3 = 0;
            if (relativeLayout != null) {
                if (z16 && relativeLayout.getVisibility() != 0) {
                    this.f206165y.setVisibility(0);
                    return;
                } else {
                    this.f206165y.setVisibility(8);
                    return;
                }
            }
            if (!z16) {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
    }

    public void E(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
            return;
        }
        TextView textView = this.f206164x;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
    }

    public void F(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
            return;
        }
        View view = this.f206154n;
        if (view != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
        if (z16) {
            this.D = 1;
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.view.FileBrowserViewBase
    public void e(String str, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, (Object) onClickListener);
        } else {
            super.e(str, onClickListener);
            this.f206157q.setText(str);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.view.FileBrowserViewBase
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.i("ZipFileViewer<QFile>", 4, "FileBrowserViewBase: ZipFileViewer initFileView");
        if (this.f206084a == null) {
            View inflate = ((LayoutInflater) BaseApplication.getContext().getSystemService("layout_inflater")).inflate(R.layout.g6s, (ViewGroup) null, false);
            this.f206084a = inflate;
            this.f206151k = (XListView) inflate.findViewById(R.id.ca7);
            this.f206158r = (TextView) this.f206084a.findViewById(R.id.fc6);
            this.f206159s = (TextView) this.f206084a.findViewById(R.id.kjo);
            this.f206160t = (TextView) this.f206084a.findViewById(R.id.f167080kk2);
            this.f206156p = this.f206084a.findViewById(R.id.l7k);
            this.f206153m = this.f206084a.findViewById(R.id.l7o);
            this.f206154n = this.f206084a.findViewById(R.id.fym);
            this.f206155o = this.f206084a.findViewById(R.id.f165220cc4);
            this.f206157q = (TextView) this.f206084a.findViewById(R.id.k7g);
            TextView textView = (TextView) this.f206084a.findViewById(R.id.kcl);
            this.f206164x = textView;
            textView.setVisibility(8);
            this.f206152l = (TriangleView) this.f206084a.findViewById(R.id.f167009jw1);
            View findViewById = this.f206084a.findViewById(R.id.fyk);
            this.f206161u = findViewById;
            this.f206162v = (TextView) findViewById.findViewById(R.id.l7m);
            this.f206163w = (TextView) this.f206161u.findViewById(R.id.f126047np);
            this.f206091h = (TextView) this.f206084a.findViewById(R.id.fdn);
            this.f206165y = (TextView) this.f206084a.findViewById(R.id.s8z);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.view.FileBrowserViewBase
    public void i(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) onClickListener);
            return;
        }
        super.i(onClickListener);
        this.f206166z = (RelativeLayout) this.f206084a.findViewById(R.id.f100895tq);
        this.A = (ProgressBar) this.f206084a.findViewById(R.id.f100745tb);
        this.B = (TextView) this.f206084a.findViewById(R.id.f100775te);
        this.f206084a.findViewById(R.id.f100735ta).setOnClickListener(onClickListener);
    }

    @Override // com.tencent.mobileqq.filebrowser.view.FileBrowserViewBase
    public void m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        if (this.f206166z != null) {
            this.B.setText(str);
        }
        TextView textView = this.f206088e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.view.FileBrowserViewBase
    public void n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        ProgressBar progressBar = this.A;
        if (progressBar != null) {
            progressBar.setProgress(i3);
        }
        ProgressBar progressBar2 = this.f206087d;
        if (progressBar2 != null) {
            progressBar2.setProgress(i3);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.view.FileBrowserViewBase
    public void q(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        RelativeLayout relativeLayout = this.f206166z;
        if (this.D == 2) {
            relativeLayout = this.f206086c;
        }
        if (relativeLayout != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            relativeLayout.setVisibility(i3);
            if (z16) {
                D(false);
            }
        }
        G();
    }

    public void r(boolean z16, String str, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), str, onClickListener);
            return;
        }
        this.f206157q.setText(str);
        this.f206157q.setOnClickListener(onClickListener);
        C(z16);
    }

    public void s(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str, (Object) str2);
            return;
        }
        BaseAdapter baseAdapter = this.C;
        if (baseAdapter != null) {
            baseAdapter.notifyDataSetChanged();
        }
    }

    public void t(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.f206158r.setText(str);
        }
    }

    public void u(String str, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) onClickListener);
            return;
        }
        TextView textView = this.f206165y;
        if (textView != null) {
            textView.setText(str);
            this.f206165y.setOnClickListener(onClickListener);
            D(true);
        }
    }

    public void v(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        } else {
            this.f206164x.setText(str);
            E(true);
        }
    }

    public void w(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
            return;
        }
        if (z16) {
            this.f206084a.setBackgroundResource(R.drawable.bg_texture);
            this.f206152l.setColor(BaseApplication.getContext().getResources().getColor(R.color.ajr));
            this.f206157q.setTextColor(BaseApplication.getContext().getResources().getColor(R.color.a07));
            this.f206162v.setTextColor(BaseApplication.getContext().getResources().getColor(R.color.skin_gray3));
            return;
        }
        this.f206084a.setBackgroundColor(Color.parseColor("#ffffffff"));
        this.f206152l.setColor(Color.parseColor("#ffffffff"));
        this.f206156p.setBackgroundColor(Color.parseColor("#fff7f7f8"));
        this.f206157q.setTextColor(BaseApplication.getContext().getResources().getColor(R.color.a06));
        this.f206162v.setTextColor(BaseApplication.getContext().getResources().getColor(R.color.black));
    }

    public void x(BaseAdapter baseAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) baseAdapter);
            return;
        }
        this.C = baseAdapter;
        this.f206151k.setAdapter((ListAdapter) baseAdapter);
        this.f206153m.setVisibility(0);
        this.f206154n.setVisibility(8);
        this.f206161u.setVisibility(8);
        this.D = 2;
    }

    public void y(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f206163w.setText(str);
        }
    }

    public void z(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
        } else {
            this.f206159s.setText(str);
            this.f206160t.setText(str2);
        }
    }
}

package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.widgets.TriangleView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class j extends a {
    private XListView H;
    private TriangleView I;
    private View J;
    private View K;
    private View L;
    private View M;
    private TextView N;
    private TextView P;
    private TextView Q;
    private TextView R;
    private View S;
    private TextView T;
    private TextView U;
    private TextView V;
    private TextView W;
    private RelativeLayout X;
    private ProgressBar Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private View f208629a0;

    /* renamed from: b0, reason: collision with root package name */
    private com.tencent.biz.troop.file.b f208630b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f208631c0;

    public j(Activity activity) {
        super(activity);
    }

    public void A(boolean z16) {
        if (!z16) {
            this.S.setVisibility(8);
            return;
        }
        this.S.setVisibility(0);
        this.T.setVisibility(0);
        this.U.setVisibility(0);
        this.f208631c0 = 0;
    }

    public void B(boolean z16) {
        int i3;
        View view = this.L;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    public void C(boolean z16) {
        TextView textView = this.W;
        if (textView != null) {
            RelativeLayout relativeLayout = this.f208608h;
            int i3 = 0;
            if (relativeLayout != null) {
                if (z16 && relativeLayout.getVisibility() != 0) {
                    this.W.setVisibility(0);
                    return;
                } else {
                    this.W.setVisibility(8);
                    return;
                }
            }
            if (!z16) {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
    }

    public void D(boolean z16) {
        int i3;
        TextView textView = this.V;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
    }

    public void E(boolean z16) {
        int i3;
        View view = this.K;
        if (view != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
        if (z16) {
            this.f208631c0 = 1;
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.viewer.a
    public View a() {
        return this.f208606e;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.viewer.a
    public void e(String str, View.OnClickListener onClickListener) {
        super.e(str, onClickListener);
        this.N.setText(str);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.viewer.a
    public void f() {
        QLog.i("ZipFileViewer<QFile>", 4, "FileBrowserViewBase: ZipFileViewer initFileView");
        if (this.f208606e == null) {
            View inflate = ((LayoutInflater) BaseApplication.getContext().getSystemService("layout_inflater")).inflate(R.layout.amv, this.f208605d, false);
            this.f208606e = inflate;
            this.H = (XListView) inflate.findViewById(R.id.ca7);
            this.P = (TextView) this.f208606e.findViewById(R.id.fc6);
            this.Q = (TextView) this.f208606e.findViewById(R.id.kjo);
            this.R = (TextView) this.f208606e.findViewById(R.id.f167080kk2);
            this.M = this.f208606e.findViewById(R.id.l7k);
            this.J = this.f208606e.findViewById(R.id.l7o);
            this.K = this.f208606e.findViewById(R.id.fym);
            this.L = this.f208606e.findViewById(R.id.f165220cc4);
            this.N = (TextView) this.f208606e.findViewById(R.id.k7g);
            TextView textView = (TextView) this.f208606e.findViewById(R.id.kcl);
            this.V = textView;
            textView.setVisibility(8);
            this.I = (TriangleView) this.f208606e.findViewById(R.id.f167009jw1);
            this.f208630b0 = new com.tencent.biz.troop.file.b(null, this.f208607f);
            View findViewById = this.f208606e.findViewById(R.id.fyk);
            this.S = findViewById;
            this.T = (TextView) findViewById.findViewById(R.id.l7m);
            this.U = (TextView) this.S.findViewById(R.id.f126047np);
            this.E = (TextView) this.f208606e.findViewById(R.id.fdn);
            this.W = (TextView) this.f208606e.findViewById(R.id.s8z);
            if (QQTheme.isNowThemeIsNight()) {
                QUIButton qUIButton = (QUIButton) this.W;
                int e16 = ee0.b.g().e(qUIButton.getContext(), qUIButton.i());
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(e16);
                gradientDrawable.setColor(-16777216);
                this.W.setBackground(gradientDrawable);
            }
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.viewer.a
    public void g(View.OnClickListener onClickListener) {
        super.g(onClickListener);
        this.X = (RelativeLayout) this.f208606e.findViewById(R.id.f100895tq);
        this.Y = (ProgressBar) this.f208606e.findViewById(R.id.f100745tb);
        this.Z = (TextView) this.f208606e.findViewById(R.id.f100775te);
        View findViewById = this.f208606e.findViewById(R.id.f100735ta);
        this.f208629a0 = findViewById;
        findViewById.setOnClickListener(onClickListener);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.viewer.a
    public void l(String str) {
        if (this.X != null) {
            this.Z.setText(str);
        }
        TextView textView = this.f208610m;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.viewer.a
    public void m(int i3) {
        ProgressBar progressBar = this.Y;
        if (progressBar != null) {
            progressBar.setProgress(i3);
        }
        ProgressBar progressBar2 = this.f208609i;
        if (progressBar2 != null) {
            progressBar2.setProgress(i3);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.viewer.a
    public void o(boolean z16) {
        int i3;
        RelativeLayout relativeLayout = this.X;
        if (this.f208631c0 == 2) {
            relativeLayout = this.f208608h;
        }
        if (relativeLayout != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            relativeLayout.setVisibility(i3);
            if (z16) {
                C(false);
            }
        }
    }

    public void p() {
        View view = this.J;
        view.setPadding(0, view.getPaddingTop(), 0, 0);
        this.L.setVisibility(8);
    }

    public void q(boolean z16, String str, View.OnClickListener onClickListener) {
        int i3;
        View view = this.L;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        this.N.setText(str);
        this.N.setOnClickListener(onClickListener);
        if (this.f208631c0 != 2) {
            this.L.setVisibility(8);
        }
    }

    public void r(List<ZipFilePresenter.f> list, String str, long j3, long j16, String str2, String str3, String str4, String str5, boolean z16, String str6, short s16) {
        this.f208630b0.d(list);
        com.tencent.biz.troop.file.b bVar = this.f208630b0;
        bVar.C = "/";
        bVar.E = j3;
        bVar.D = j16;
        bVar.f96849h = str2;
        bVar.f96850i = str3;
        bVar.f96851m = str4;
        bVar.f96848f = str5;
        bVar.e(z16, str6, s16);
        this.H.setAdapter((ListAdapter) this.f208630b0);
        this.J.setVisibility(0);
        this.K.setVisibility(8);
        this.S.setVisibility(8);
        this.f208631c0 = 2;
    }

    public void s(String str, String str2) {
        com.tencent.biz.troop.file.b bVar = this.f208630b0;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public void t(String str) {
        this.P.setText(str);
    }

    public void u(String str, View.OnClickListener onClickListener) {
        TextView textView = this.W;
        if (textView != null) {
            textView.setText(str);
            this.W.setOnClickListener(onClickListener);
            C(true);
        }
    }

    public void v(String str) {
        this.V.setText(str);
        D(true);
    }

    public void w(boolean z16) {
        if (z16) {
            this.f208606e.setBackgroundResource(R.drawable.bg_texture);
            this.I.setColor(this.f208607f.getResources().getColor(R.color.ajr));
            this.N.setTextColor(this.f208607f.getResources().getColor(R.color.a07));
            this.T.setTextColor(this.f208607f.getResources().getColor(R.color.skin_gray3));
            return;
        }
        this.f208606e.setBackgroundColor(Color.parseColor("#ffffffff"));
        this.I.setColor(Color.parseColor("#ffffffff"));
        this.M.setBackgroundColor(Color.parseColor("#fff7f7f8"));
        this.N.setTextColor(this.f208607f.getResources().getColor(R.color.a06));
        this.T.setTextColor(this.f208607f.getResources().getColor(R.color.black));
    }

    public void x(String str) {
        this.U.setText(str);
    }

    public void y(String str, String str2) {
        this.Q.setText(str);
        this.R.setText(str2);
    }

    public void z(String str) {
        this.T.setText(str);
    }
}

package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class a {
    protected View C;
    protected TextView D;
    protected TextView E;
    protected InterfaceC7579a F;
    protected Bundle G;

    /* renamed from: d, reason: collision with root package name */
    protected ViewGroup f208605d;

    /* renamed from: e, reason: collision with root package name */
    protected View f208606e;

    /* renamed from: f, reason: collision with root package name */
    protected Activity f208607f;

    /* renamed from: h, reason: collision with root package name */
    protected RelativeLayout f208608h;

    /* renamed from: i, reason: collision with root package name */
    protected ProgressBar f208609i;

    /* renamed from: m, reason: collision with root package name */
    protected TextView f208610m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.viewer.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public interface InterfaceC7579a {
        void q();
    }

    public a(Activity activity) {
        this.f208607f = activity;
    }

    public View a() {
        return this.f208606e;
    }

    public Rect b() {
        Bundle bundle = this.G;
        if (bundle != null) {
            return (Rect) bundle.getParcelable("file_browser_params_thumb_bound");
        }
        return null;
    }

    public void c() {
        View view = this.C;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void d(String str, int i3, View.OnClickListener onClickListener) {
        e(str, onClickListener);
    }

    public void e(String str, View.OnClickListener onClickListener) {
        if (this.E == null) {
            this.E = (TextView) this.f208606e.findViewById(R.id.fdn);
        }
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(str);
            this.E.setOnClickListener(onClickListener);
            this.E.setVisibility(0);
            n(true);
        }
    }

    public abstract void f();

    public void g(View.OnClickListener onClickListener) {
        View view = this.f208606e;
        if (view != null && this.f208608h == null) {
            this.f208608h = (RelativeLayout) view.findViewById(R.id.jvt);
            this.f208609i = (ProgressBar) this.f208606e.findViewById(R.id.jv8);
            this.f208610m = (TextView) this.f208606e.findViewById(R.id.jvc);
            this.D = (TextView) this.f208606e.findViewById(R.id.lgk);
            this.C = this.f208606e.findViewById(R.id.jv7);
        }
        this.C.setOnClickListener(onClickListener);
    }

    public void h(String str) {
        if (this.f208608h != null) {
            this.D.setText(str);
        }
    }

    public void i(int i3) {
        TextView textView = this.D;
        if (textView != null) {
            textView.setVisibility(i3);
        }
    }

    public void j(Bundle bundle) {
        this.G = bundle;
    }

    public void k(InterfaceC7579a interfaceC7579a) {
        this.F = interfaceC7579a;
    }

    public void l(String str) {
        if (this.f208608h != null) {
            this.f208610m.setText(str);
        }
    }

    public void m(int i3) {
        if (this.f208608h != null) {
            this.f208609i.setProgress(i3);
        }
    }

    public void n(boolean z16) {
        int i3;
        TextView textView = this.E;
        if (textView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
    }

    public void o(boolean z16) {
        int i3;
        RelativeLayout relativeLayout = this.f208608h;
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

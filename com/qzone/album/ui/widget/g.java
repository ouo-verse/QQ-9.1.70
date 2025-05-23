package com.qzone.album.ui.widget;

import android.view.View;
import android.webkit.URLUtil;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    protected TextView f44342a;

    /* renamed from: b, reason: collision with root package name */
    protected TextView f44343b;

    /* renamed from: c, reason: collision with root package name */
    protected Switch f44344c;

    /* renamed from: d, reason: collision with root package name */
    protected View f44345d;

    /* renamed from: e, reason: collision with root package name */
    protected int f44346e;

    /* renamed from: f, reason: collision with root package name */
    protected RelativeLayout f44347f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f44348g = true;

    /* renamed from: h, reason: collision with root package name */
    private boolean f44349h = false;

    /* renamed from: i, reason: collision with root package name */
    private a f44350i;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a {
        void a(boolean z16);
    }

    public g(RelativeLayout relativeLayout, View view, int i3) {
        if (relativeLayout != null) {
            a(relativeLayout);
            this.f44347f = relativeLayout;
        }
        this.f44345d = view;
        this.f44346e = i3;
    }

    private void b(boolean z16) {
        a aVar = this.f44350i;
        if (aVar != null) {
            aVar.a(z16);
        }
    }

    public void c(boolean z16) {
        View view = this.f44345d;
        if (view == null) {
            return;
        }
        if (z16) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public void d(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Switch r06 = this.f44344c;
        if (r06 == null || onCheckedChangeListener == null) {
            return;
        }
        r06.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public void e(a aVar) {
        this.f44350i = aVar;
    }

    public void f(boolean z16) {
        RelativeLayout relativeLayout;
        this.f44348g = z16;
        if (!z16 && (relativeLayout = this.f44347f) != null) {
            relativeLayout.setVisibility(8);
            b(false);
        }
        c(z16);
    }

    public void g(boolean z16) {
        this.f44349h = z16;
    }

    public void i(ArrayList<String> arrayList, int i3, int i16) {
        boolean z16;
        if (!this.f44348g) {
            this.f44347f.setVisibility(8);
            c(false);
            b(false);
            return;
        }
        if (arrayList == null) {
            return;
        }
        if (arrayList.size() <= 0) {
            this.f44347f.setVisibility(8);
            c(false);
            b(false);
        } else {
            Iterator<String> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z16 = true;
                    break;
                } else if (!URLUtil.isNetworkUrl(it.next())) {
                    z16 = false;
                    break;
                }
            }
            if (z16) {
                this.f44347f.setVisibility(8);
                c(false);
                b(false);
            } else {
                this.f44347f.setVisibility(0);
                c(true);
                b(true);
            }
        }
        this.f44346e = i3;
        TextView textView = this.f44342a;
        if (textView != null && this.f44343b != null) {
            if (i3 == 0) {
                this.f44342a.setText(com.qzone.reborn.configx.g.f53821a.b().v1());
            } else if (i3 == 2) {
                textView.setText(R.string.f173048gp2);
            } else if (i3 == 3) {
                if (i16 == 1) {
                    textView.setText(R.string.gp5);
                } else if (this.f44349h) {
                    textView.setText("\u65e0\u635f\u539f\u56fe");
                } else {
                    textView.setText(R.string.f173050gp4);
                }
            }
        }
        Switch r56 = this.f44344c;
        if (r56 != null) {
            if (this.f44346e != 2) {
                r56.setChecked(false);
            } else {
                r56.setChecked(true);
            }
        }
    }

    public void h(ArrayList<String> arrayList, int i3) {
        i(arrayList, i3, 0);
    }

    private void a(RelativeLayout relativeLayout) {
        this.f44342a = (TextView) relativeLayout.findViewById(R.id.fpv);
        this.f44343b = (TextView) relativeLayout.findViewById(R.id.fpz);
        this.f44344c = (Switch) relativeLayout.findViewById(R.id.fpn);
    }
}

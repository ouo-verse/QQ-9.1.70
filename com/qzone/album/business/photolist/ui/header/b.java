package com.qzone.album.business.photolist.ui.header;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    ViewGroup f43533a;

    /* renamed from: b, reason: collision with root package name */
    ViewGroup f43534b;

    /* renamed from: c, reason: collision with root package name */
    ViewGroup f43535c;

    /* renamed from: d, reason: collision with root package name */
    TextView f43536d;

    /* renamed from: e, reason: collision with root package name */
    TextView f43537e;

    /* renamed from: f, reason: collision with root package name */
    TextView f43538f;

    /* renamed from: g, reason: collision with root package name */
    private View f43539g;

    public b(View view) {
        if (view == null) {
            return;
        }
        this.f43539g = view;
        this.f43533a = (ViewGroup) view.findViewById(R.id.ekr);
        this.f43536d = (TextView) this.f43539g.findViewById(R.id.ekq);
        this.f43534b = (ViewGroup) this.f43539g.findViewById(R.id.eja);
        this.f43537e = (TextView) this.f43539g.findViewById(R.id.ej_);
        this.f43535c = (ViewGroup) this.f43539g.findViewById(R.id.ejl);
        this.f43538f = (TextView) this.f43539g.findViewById(R.id.ejk);
    }

    public void a(int i3) {
        if (this.f43537e == null) {
            return;
        }
        String str = "";
        if (i3 < 0 || i3 >= 1000) {
            if (i3 >= 1000) {
                str = "999+";
            }
        } else if (i3 != 0) {
            str = i3 + "";
        }
        this.f43537e.setText(str);
        ViewGroup viewGroup = this.f43534b;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
            this.f43537e.setVisibility(0);
        }
    }

    public void b(int i3) {
        if (this.f43538f == null) {
            return;
        }
        String str = "";
        if (i3 < 0 || i3 >= 1000) {
            if (i3 >= 1000) {
                str = "999+";
            }
        } else if (i3 != 0) {
            str = i3 + "";
        }
        this.f43538f.setText(str);
        ViewGroup viewGroup = this.f43535c;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
            this.f43538f.setVisibility(0);
        }
    }

    public void c(View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.f43533a.setOnClickListener(onClickListener);
        this.f43534b.setOnClickListener(onClickListener2);
        this.f43535c.setOnClickListener(onClickListener3);
    }

    public void d(int i3) {
        if (this.f43536d == null || this.f43533a == null) {
            return;
        }
        String str = "";
        if (i3 < 0 || i3 >= 1000) {
            if (i3 >= 1000) {
                str = "999+";
            }
        } else if (i3 != 0) {
            str = i3 + "";
        }
        this.f43536d.setText(str);
        this.f43533a.setVisibility(0);
        this.f43536d.setVisibility(0);
        AccessibilityUtil.p(this.f43533a, "\u67e5\u770b\u4eba\u6570" + str);
    }

    public void e(int i3) {
        ViewGroup viewGroup = this.f43534b;
        if (viewGroup == null || this.f43537e == null) {
            return;
        }
        if (i3 <= 999) {
            viewGroup.setVisibility(0);
            if (i3 == 0) {
                this.f43537e.setText("");
            } else {
                this.f43537e.setText(Integer.toString(i3));
            }
            AccessibilityUtil.p(this.f43534b, "\u8bc4\u8bba\u4eba\u6570" + i3);
            return;
        }
        viewGroup.setVisibility(0);
        this.f43537e.setText("999+");
        AccessibilityUtil.p(this.f43534b, "\u8bc4\u8bba\u4eba\u6570999+");
    }

    public void f(int i3) {
        ViewGroup viewGroup = this.f43535c;
        if (viewGroup == null || this.f43538f == null) {
            return;
        }
        if (i3 <= 999) {
            viewGroup.setVisibility(0);
            if (i3 == 0) {
                this.f43538f.setText("");
            } else {
                this.f43538f.setText(Integer.toString(i3));
            }
            AccessibilityUtil.p(this.f43535c, "\u70b9\u8d5e\u4eba\u6570" + i3);
            return;
        }
        viewGroup.setVisibility(0);
        this.f43538f.setText("999+");
        AccessibilityUtil.p(this.f43535c, "\u70b9\u8d5e\u4eba\u6570999+");
    }
}

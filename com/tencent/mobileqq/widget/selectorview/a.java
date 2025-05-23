package com.tencent.mobileqq.widget.selectorview;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.selectorview.QPickerView;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends h {

    /* renamed from: g, reason: collision with root package name */
    private int f317376g;

    /* renamed from: h, reason: collision with root package name */
    private int f317377h;

    /* renamed from: i, reason: collision with root package name */
    private int f317378i;

    /* renamed from: j, reason: collision with root package name */
    private int f317379j;

    /* renamed from: k, reason: collision with root package name */
    private int f317380k;

    /* renamed from: l, reason: collision with root package name */
    private int f317381l;

    /* renamed from: m, reason: collision with root package name */
    private int f317382m;

    /* renamed from: n, reason: collision with root package name */
    private int f317383n;

    /* renamed from: o, reason: collision with root package name */
    private int f317384o;

    /* renamed from: p, reason: collision with root package name */
    private int f317385p;

    /* renamed from: q, reason: collision with root package name */
    private int f317386q;

    /* renamed from: r, reason: collision with root package name */
    private final QPickerView.e f317387r;

    /* renamed from: s, reason: collision with root package name */
    private final QPickerView.f f317388s;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.widget.selectorview.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    class C8999a implements QPickerView.e {
        C8999a() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getColumnCount() {
            return 3;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getRowCount(int i3) {
            int i16;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return 0;
                    }
                    if (a.this.f317381l + a.this.f317376g == a.this.f317384o - a.this.f317377h && a.this.f317382m + 1 == a.this.f317385p) {
                        return a.this.f317386q;
                    }
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(1, a.this.f317381l + a.this.f317376g);
                    if (a.this.f317381l != 0) {
                        i16 = a.this.f317382m;
                    } else {
                        i16 = a.this.f317385p - 1;
                    }
                    calendar.set(2, i16);
                    calendar.set(5, 1);
                    if (a.this.f317381l == 0 && a.this.f317382m == 0) {
                        return calendar.getActualMaximum(5) - a.this.f317386q;
                    }
                    return calendar.getActualMaximum(5);
                }
                if (a.this.f317381l + a.this.f317376g == a.this.f317384o - a.this.f317377h) {
                    return a.this.f317385p;
                }
                if (a.this.f317381l != 0) {
                    return 12;
                }
                return (12 - a.this.f317385p) + 1;
            }
            return ((a.this.f317384o - a.this.f317376g) - a.this.f317377h) + 1;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public String getText(int i3, int i16) {
            if (i3 != 0) {
                int i17 = 1;
                if (i3 != 1) {
                    if (i3 != 2) {
                        return "";
                    }
                    StringBuilder sb5 = new StringBuilder();
                    if (a.this.f317381l == 0 && a.this.f317382m == 0) {
                        i17 = 1 + a.this.f317386q;
                    }
                    sb5.append(i17 + i16);
                    sb5.append(HardCodeUtil.qqStr(R.string.f2039651m));
                    return sb5.toString();
                }
                StringBuilder sb6 = new StringBuilder();
                if (a.this.f317381l == 0) {
                    i17 = a.this.f317385p;
                }
                sb6.append(i17 + i16);
                sb6.append(HardCodeUtil.qqStr(R.string.f2039751n));
                return sb6.toString();
            }
            return (a.this.f317376g + i16) + HardCodeUtil.qqStr(R.string.f2039951p);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements QPickerView.f {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.f
        public void onItemSelected(int i3, int i16) {
            if (i3 == 0) {
                a.this.f317381l = i16;
            } else if (i3 == 1) {
                a.this.f317382m = i16;
            } else if (i3 == 2) {
                a.this.f317383n = i16;
            }
            QPickerView qPickerView = a.this.f317413c;
            if (qPickerView != null && (i3 == 0 || i3 == 1)) {
                qPickerView.m(1);
                a.this.f317413c.m(2);
            }
            a.s(a.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface c {
    }

    public a(Context context) {
        super(context);
        this.f317376g = 1896;
        this.f317377h = 0;
        C8999a c8999a = new C8999a();
        this.f317387r = c8999a;
        b bVar = new b();
        this.f317388s = bVar;
        this.f317413c.j(c8999a);
        this.f317413c.setPickListener(bVar);
        k(HardCodeUtil.qqStr(R.string.f2039851o));
    }

    private void G() {
        Calendar calendar = Calendar.getInstance();
        this.f317384o = calendar.get(1);
        this.f317385p = calendar.get(2) + 1;
        this.f317386q = calendar.get(5);
    }

    private void H() {
        int i3;
        int i16;
        int i17 = this.f317381l;
        this.f317378i = this.f317376g + i17;
        int i18 = this.f317382m;
        if (i17 == 0) {
            i3 = i18 + this.f317385p;
        } else {
            i3 = i18 + 1;
        }
        this.f317379j = i3;
        if (i17 == 0 && this.f317382m == 0) {
            i16 = this.f317383n + this.f317386q;
        } else {
            i16 = this.f317383n;
        }
        this.f317380k = i16 + 1;
    }

    private void I() {
        int i3;
        int i16 = this.f317378i - this.f317376g;
        this.f317381l = i16;
        int i17 = 0;
        if (i16 == 0) {
            i3 = 0;
        } else {
            i3 = this.f317379j - 1;
        }
        this.f317382m = i3;
        if (i16 != 0) {
            i17 = this.f317380k - 1;
        }
        this.f317383n = i17;
    }

    private void J() {
        this.f317381l = this.f317413c.h(0);
        this.f317382m = this.f317413c.h(1);
        this.f317383n = this.f317413c.h(2);
    }

    static /* bridge */ /* synthetic */ c s(a aVar) {
        aVar.getClass();
        return null;
    }

    public int A() {
        int C;
        if (C(0) == 0 && C(1) == 0) {
            C = C(2) + this.f317386q;
        } else {
            C = C(2);
        }
        return C + 1;
    }

    public int B() {
        if (C(0) == 0) {
            return C(1) + this.f317385p;
        }
        return C(1) + 1;
    }

    public int C(int i3) {
        return this.f317413c.h(i3);
    }

    public int D() {
        return C(0) + this.f317376g;
    }

    public void E(int i3, int i16, int i17) {
        this.f317378i = i3;
        this.f317379j = i16;
        this.f317380k = i17;
        G();
        I();
        this.f317413c.setSelection(0, this.f317381l);
        this.f317413c.setSelection(1, this.f317382m);
        this.f317413c.setSelection(2, this.f317383n);
        this.f317413c.m(0);
        this.f317413c.m(1);
        this.f317413c.m(2);
    }

    public void F(int i3) {
        this.f317376g = i3;
    }

    public int z() {
        J();
        H();
        return (this.f317378i << 16) | (this.f317379j << 8) | this.f317380k;
    }
}

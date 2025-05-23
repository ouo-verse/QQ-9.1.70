package i43;

import android.content.Context;
import com.tencent.mobileqq.widget.selectorview.QPickerView;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends com.tencent.mobileqq.widget.selectorview.h {

    /* renamed from: g, reason: collision with root package name */
    private int f407185g;

    /* renamed from: h, reason: collision with root package name */
    private int f407186h;

    /* renamed from: i, reason: collision with root package name */
    private int f407187i;

    /* renamed from: j, reason: collision with root package name */
    private int f407188j;

    /* renamed from: k, reason: collision with root package name */
    private int f407189k;

    /* renamed from: l, reason: collision with root package name */
    private int f407190l;

    /* renamed from: m, reason: collision with root package name */
    private int f407191m;

    /* renamed from: n, reason: collision with root package name */
    private int f407192n;

    /* renamed from: o, reason: collision with root package name */
    private int f407193o;

    /* renamed from: p, reason: collision with root package name */
    private int f407194p;

    /* renamed from: q, reason: collision with root package name */
    private final QPickerView.e f407195q;

    /* renamed from: r, reason: collision with root package name */
    private final QPickerView.f f407196r;

    /* compiled from: P */
    /* renamed from: i43.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    class C10500a implements QPickerView.e {
        C10500a() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getColumnCount() {
            return 3;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getRowCount(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return 0;
                    }
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(1, a.this.f407189k + a.this.f407185g);
                    calendar.set(2, a.this.f407190l);
                    calendar.set(5, 1);
                    return calendar.getActualMaximum(5);
                }
                return 12;
            }
            return (a.this.f407192n - a.this.f407185g) + 1;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public String getText(int i3, int i16) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return "";
                    }
                    return (i16 + 1) + "\u65e5";
                }
                return (i16 + 1) + "\u6708";
            }
            return (a.this.f407185g + i16) + "\u5e74";
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
                a.this.f407189k = i16;
            } else if (i3 == 1) {
                a.this.f407190l = i16;
            } else if (i3 == 2) {
                a.this.f407191m = i16;
            }
            if (((com.tencent.mobileqq.widget.selectorview.h) a.this).f317413c != null) {
                if (i3 == 0 || i3 == 1) {
                    ((com.tencent.mobileqq.widget.selectorview.h) a.this).f317413c.m(1);
                    ((com.tencent.mobileqq.widget.selectorview.h) a.this).f317413c.m(2);
                }
            }
        }
    }

    public a(Context context) {
        super(context);
        this.f407185g = 2023;
        this.f407189k = 0;
        this.f407190l = 0;
        this.f407191m = 0;
        C10500a c10500a = new C10500a();
        this.f407195q = c10500a;
        b bVar = new b();
        this.f407196r = bVar;
        this.f317413c.j(c10500a);
        this.f317413c.setPickListener(bVar);
        k("\u9009\u62e9\u65e5\u671f");
        B();
    }

    private void B() {
        C();
        E();
        this.f407186h = this.f407192n;
        this.f407187i = this.f407193o;
        this.f407188j = this.f407194p;
        this.f317413c.setSelection(0, this.f407189k);
        this.f317413c.setSelection(1, this.f407190l);
        this.f317413c.setSelection(2, this.f407191m);
        this.f317413c.m(0);
        this.f317413c.m(1);
        this.f317413c.m(2);
    }

    private void C() {
        Calendar calendar = Calendar.getInstance();
        this.f407192n = calendar.get(1);
        this.f407193o = calendar.get(2) + 1;
        this.f407194p = calendar.get(5);
    }

    private void E() {
        this.f407189k = this.f407192n - this.f407185g;
        this.f407190l = this.f407193o - 1;
        this.f407191m = this.f407194p - 1;
    }

    private void F() {
        this.f407189k = this.f317413c.h(0);
        this.f407190l = this.f317413c.h(1);
        this.f407191m = this.f317413c.h(2);
    }

    public int A() {
        return this.f407186h;
    }

    public void D() {
        F();
        this.f407186h = this.f407189k + this.f407185g;
        this.f407187i = this.f407190l + 1;
        this.f407188j = this.f407191m + 1;
    }

    public int y() {
        return this.f407188j;
    }

    public int z() {
        return this.f407187i;
    }
}

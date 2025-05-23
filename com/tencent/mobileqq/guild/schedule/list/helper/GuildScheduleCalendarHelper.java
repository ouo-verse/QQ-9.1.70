package com.tencent.mobileqq.guild.schedule.list.helper;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.TypefaceProvider;
import com.tencent.mobileqq.qqguildsdk.data.cr;
import com.tencent.mobileqq.util.Utils;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import py1.b;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildScheduleCalendarHelper {
    private a B;
    public final Context C;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f233258a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f233259b;

    /* renamed from: c, reason: collision with root package name */
    public int f233260c;

    /* renamed from: d, reason: collision with root package name */
    public int f233261d;

    /* renamed from: e, reason: collision with root package name */
    public int f233262e;

    /* renamed from: f, reason: collision with root package name */
    public int f233263f;

    /* renamed from: g, reason: collision with root package name */
    public int f233264g;

    /* renamed from: h, reason: collision with root package name */
    public int f233265h;

    /* renamed from: i, reason: collision with root package name */
    public int f233266i;

    /* renamed from: j, reason: collision with root package name */
    public int f233267j;

    /* renamed from: k, reason: collision with root package name */
    public int f233268k;

    /* renamed from: l, reason: collision with root package name */
    public int f233269l;

    /* renamed from: m, reason: collision with root package name */
    public int f233270m;

    /* renamed from: n, reason: collision with root package name */
    public int f233271n;

    /* renamed from: o, reason: collision with root package name */
    public Typeface f233272o;

    /* renamed from: p, reason: collision with root package name */
    public int f233273p;

    /* renamed from: q, reason: collision with root package name */
    public int f233274q;

    /* renamed from: r, reason: collision with root package name */
    public int f233275r;

    /* renamed from: s, reason: collision with root package name */
    public int f233276s;

    /* renamed from: t, reason: collision with root package name */
    public int f233277t;

    /* renamed from: w, reason: collision with root package name */
    public int f233280w;

    /* renamed from: x, reason: collision with root package name */
    public int f233281x;

    /* renamed from: y, reason: collision with root package name */
    private long f233282y;

    /* renamed from: z, reason: collision with root package name */
    private long f233283z;

    /* renamed from: u, reason: collision with root package name */
    public final py1.a f233278u = new py1.a();

    /* renamed from: v, reason: collision with root package name */
    public final py1.a f233279v = new py1.a();
    public Map<py1.a, Integer> A = new HashMap();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        void a();

        void b();

        void c(int i3, int i16);

        void d();

        void e();

        void f(py1.a aVar, boolean z16);
    }

    public GuildScheduleCalendarHelper(Context context, AttributeSet attributeSet) {
        this.C = context;
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.I2);
        this.f233260c = obtainStyledAttributes.getResourceId(up1.a.J2, 0);
        this.f233261d = obtainStyledAttributes.getResourceId(up1.a.K2, 0);
        this.f233262e = obtainStyledAttributes.getResourceId(up1.a.T2, 0);
        this.f233263f = obtainStyledAttributes.getResourceId(up1.a.Q2, 0);
        this.f233265h = obtainStyledAttributes.getResourceId(up1.a.V2, 0);
        this.f233264g = obtainStyledAttributes.getResourceId(up1.a.R2, 0);
        this.f233273p = obtainStyledAttributes.getDimensionPixelSize(up1.a.P2, (int) (resources.getDisplayMetrics().scaledDensity * 16.0f));
        this.f233276s = obtainStyledAttributes.getDimensionPixelSize(up1.a.N2, Utils.n(41.0f, resources));
        this.f233277t = obtainStyledAttributes.getDimensionPixelSize(up1.a.O2, Utils.n(8.0f, resources));
        this.f233274q = obtainStyledAttributes.getDimensionPixelSize(up1.a.U2, Utils.n(99.0f, resources));
        this.f233275r = obtainStyledAttributes.getDimensionPixelSize(up1.a.S2, 0);
        this.f233259b = obtainStyledAttributes.getBoolean(up1.a.M2, true);
        this.f233258a = obtainStyledAttributes.getBoolean(up1.a.L2, false);
        obtainStyledAttributes.recycle();
        this.f233272o = TypefaceProvider.c(context, "fonts/DIN-NextLT-Pro-QQ.ttf");
    }

    private py1.a b(cr crVar) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(crVar.a());
        calendar.add(14, (int) (86400000 - (calendar.get(15) + calendar.get(16))));
        return new py1.a(calendar.get(1), calendar.get(2), calendar.get(5));
    }

    public int a(int i3, int i16) {
        int n3 = n(i3, i16);
        return (this.f233276s * n3) + (n3 * this.f233277t);
    }

    public int c(int i3, int i16) {
        if (i16 != 0) {
            switch (i16) {
                case 2:
                case 4:
                case 6:
                case 7:
                case 9:
                case 11:
                    return 31;
                case 3:
                case 5:
                case 8:
                case 10:
                    return 30;
                default:
                    if ((i3 % 4 == 0 && i3 % 100 != 0) || i3 % 400 == 0) {
                        return 29;
                    }
                    return 28;
            }
        }
        return 31;
    }

    public void d(py1.a[] aVarArr, int i3, int i16) {
        if (aVarArr == null) {
            return;
        }
        long i17 = i(i3, i16);
        for (int i18 = 0; i18 < aVarArr.length; i18++) {
            long j3 = (i18 * 86400000) + i17;
            py1.a aVar = aVarArr[i18];
            if (aVar == null) {
                aVarArr[i18] = py1.a.a(j3);
            } else {
                aVar.g(j3);
            }
        }
    }

    public void e(long j3, long j16, List<cr> list) {
        if (list == null) {
            return;
        }
        while (j3 <= j16) {
            this.A.remove(py1.a.a(j3));
            j3 += 86400000;
        }
        for (cr crVar : list) {
            int i3 = 1;
            if (crVar.b() != 1) {
                i3 = 0;
            }
            this.A.put(b(crVar), Integer.valueOf(i3));
        }
        a aVar = this.B;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void f(py1.a[] aVarArr, int i3) {
        if (aVarArr == null) {
            return;
        }
        long y16 = y(i3);
        for (int i16 = 0; i16 < aVarArr.length; i16++) {
            long j3 = (i16 * 86400000) + y16;
            py1.a aVar = aVarArr[i16];
            if (aVar == null) {
                aVarArr[i16] = py1.a.a(j3);
            } else {
                aVar.g(j3);
            }
        }
    }

    public int g(int i3, int i16) {
        return ((i16 + 1) - i3) * 12;
    }

    public b<Long> h(int i3, int i16) {
        int n3 = n(i3, i16);
        long i17 = i(i3, i16);
        return new b<>(Long.valueOf(i17), Long.valueOf(((n3 * 604800000) + i17) - 1000));
    }

    public long i(int i3, int i16) {
        int k3 = k(i3, i16);
        Calendar calendar = Calendar.getInstance();
        calendar.set(i3, i16, 1, 0, 0, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - (k3 * 86400000);
    }

    public py1.a j(py1.a aVar, int i3) {
        return py1.a.a(aVar.d() + (i3 * 86400000));
    }

    public int k(int i3, int i16) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(1);
        calendar.set(1, i3);
        calendar.set(2, i16);
        calendar.set(5, 1);
        return calendar.get(7) - 1;
    }

    public void l(int i3, int i16) {
        py1.a aVar = this.f233279v;
        if (aVar.f428062a == i3 && aVar.f428063b == i16) {
            return;
        }
        r(new py1.a(i3, i16, Math.min(this.f233279v.f428064c, c(i3, i16))));
    }

    public void m(int i3) {
        int i16;
        int x16 = x(this.f233279v);
        if (x16 == i3) {
            return;
        }
        if (i3 > x16) {
            i16 = 7;
        } else {
            i16 = -7;
        }
        long d16 = j(this.f233279v, i16).d();
        long j3 = this.f233282y;
        if (d16 < j3) {
            d16 = j3;
        }
        long j16 = this.f233283z;
        if (d16 > j16) {
            d16 = j16;
        }
        r(py1.a.a(d16));
    }

    public int n(int i3, int i16) {
        if (!this.f233259b) {
            return 6;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(1);
        calendar.set(1, i3);
        calendar.set(2, i16);
        calendar.set(5, 1);
        return (int) Math.ceil(((c(i3, i16) + (calendar.get(7) - 1)) * 1.0d) / 7.0d);
    }

    public int o(int i3, int i16, int i17) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(1);
        calendar.set(1, i3);
        calendar.set(2, i16);
        calendar.set(5, 1);
        return ((i17 + (calendar.get(7) - 1)) - 1) / 7;
    }

    public void p(a aVar) {
        this.B = aVar;
    }

    public void q(int i3, int i16) {
        this.f233280w = i3;
        this.f233281x = i16;
        this.f233282y = py1.a.h(i3, 0, 1);
        this.f233283z = py1.a.h(this.f233281x, 11, 31);
        a aVar = this.B;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void r(py1.a aVar) {
        boolean z16;
        if (aVar == null || aVar.equals(this.f233279v) || this.B == null) {
            return;
        }
        int i3 = aVar.f428062a;
        py1.a aVar2 = this.f233279v;
        if (i3 == aVar2.f428062a && aVar.f428063b == aVar2.f428063b) {
            z16 = false;
        } else {
            z16 = true;
        }
        aVar2.f(aVar);
        this.B.f(aVar, true);
        if (!z16) {
            return;
        }
        this.B.c(aVar.f428062a, aVar.f428063b);
    }

    public void s(py1.a aVar, boolean z16) {
        boolean z17;
        if (aVar == null || aVar.equals(this.f233279v) || this.B == null) {
            return;
        }
        int i3 = aVar.f428062a;
        py1.a aVar2 = this.f233279v;
        if (i3 == aVar2.f428062a && aVar.f428063b == aVar2.f428063b) {
            z17 = false;
        } else {
            z17 = true;
        }
        aVar2.f(aVar);
        this.B.f(aVar, z16);
        if (!z17) {
            return;
        }
        this.B.c(aVar.f428062a, aVar.f428063b);
    }

    public void t() {
        py1.a aVar = new py1.a();
        if (aVar.equals(this.f233278u)) {
            return;
        }
        this.f233278u.f(aVar);
        a aVar2 = this.B;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    public void u() {
        Resources resources = this.C.getResources();
        this.f233266i = resources.getColor(R.color.qui_common_fill_light_primary);
        this.f233267j = resources.getColorStateList(R.color.qui_common_text_primary).getDefaultColor();
        this.f233268k = resources.getColor(R.color.qui_button_bg_primary_default);
        this.f233269l = resources.getColor(R.color.qui_common_text_tertiary);
        int i3 = this.f233268k;
        this.f233270m = i3;
        this.f233271n = i3;
        a aVar = this.B;
        if (aVar != null) {
            aVar.d();
        }
    }

    public int v(int i3, int i16) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(i3, 0, 1);
        long timeInMillis = calendar.getTimeInMillis();
        calendar.set(i16, 11, 31);
        return (int) Math.ceil((((float) (calendar.getTimeInMillis() - timeInMillis)) * 1.0f) / 6.048E8f);
    }

    public int w(int i3, int i16, int i17) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(this.f233280w, 0, 1, 0, 0, 0);
        int i18 = calendar.get(7) - 1;
        long timeInMillis = calendar.getTimeInMillis();
        calendar.set(i3, i16, i17);
        return (int) ((i18 + ((calendar.getTimeInMillis() - timeInMillis) / 86400000)) / 7);
    }

    public int x(py1.a aVar) {
        return w(aVar.f428062a, aVar.f428063b, aVar.f428064c);
    }

    public long y(int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(this.f233280w, 0, 1, 0, 0, 0);
        calendar.set(14, 0);
        return (calendar.getTimeInMillis() - ((calendar.get(7) - 1) * 86400000)) + (i3 * 604800000);
    }
}

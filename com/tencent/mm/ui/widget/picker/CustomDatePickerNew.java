package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.dc.b;
import com.tencent.luggage.wxa.fc.e;
import com.tencent.luggage.wxa.fc.f;
import com.tencent.luggage.wxa.hc.c;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mobileqq.R;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes9.dex */
public class CustomDatePickerNew extends FrameLayout {
    public int C;
    public boolean D;
    public int E;
    public e F;
    public f G;

    /* renamed from: a, reason: collision with root package name */
    public View f153496a;

    /* renamed from: b, reason: collision with root package name */
    public c f153497b;

    /* renamed from: c, reason: collision with root package name */
    public Context f153498c;

    /* renamed from: d, reason: collision with root package name */
    public Date f153499d;

    /* renamed from: e, reason: collision with root package name */
    public Date f153500e;

    /* renamed from: f, reason: collision with root package name */
    public int f153501f;

    /* renamed from: g, reason: collision with root package name */
    public int f153502g;

    /* renamed from: h, reason: collision with root package name */
    public int f153503h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f153504i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f153505j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f153506k;

    /* renamed from: l, reason: collision with root package name */
    public int f153507l;

    /* renamed from: m, reason: collision with root package name */
    public int f153508m;

    public CustomDatePickerNew(Context context) {
        super(new ContextThemeWrapper(context, R.style.at_));
        this.f153496a = null;
        this.f153504i = true;
        this.f153505j = true;
        this.f153506k = true;
        this.D = false;
        this.E = -1;
        this.f153498c = context;
        this.f153497b = new c(context);
    }

    public String currentValue() {
        this.f153497b.p();
        if (this.f153504i) {
            return String.format(Locale.US, "%04d-%02d-%02d", Integer.valueOf(this.f153501f), Integer.valueOf(this.f153502g), Integer.valueOf(this.f153503h));
        }
        if (this.f153505j) {
            return String.format(Locale.US, "%04d-%02d", Integer.valueOf(this.f153501f), Integer.valueOf(this.f153502g));
        }
        return String.format(Locale.US, "%04d", Integer.valueOf(this.f153501f));
    }

    public int getDayOfMonth() {
        c cVar = this.f153497b;
        if (cVar != null) {
            cVar.p();
        }
        return this.f153503h;
    }

    public int getMonth() {
        c cVar = this.f153497b;
        if (cVar != null) {
            cVar.p();
        }
        return this.f153502g;
    }

    public View getView() {
        if (this.f153496a == null) {
            this.f153496a = this.f153497b.l();
        }
        return this.f153496a;
    }

    public int getYear() {
        c cVar = this.f153497b;
        if (cVar != null) {
            cVar.p();
        }
        return this.f153501f;
    }

    public void init(int i3, int i16, int i17) {
        this.f153507l = i3;
        this.f153508m = i16;
        this.C = i17;
        if (this.f153496a == null) {
            this.f153496a = this.f153497b.l();
        }
    }

    public void onShow() {
        if (this.D) {
            this.f153507l++;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(this.f153507l, this.f153508m - 1, this.C);
        Calendar calendar2 = Calendar.getInstance();
        if (this.f153499d == null) {
            this.f153499d = new Date(calendar.getTimeInMillis());
        }
        calendar2.setTime(this.f153499d);
        Calendar calendar3 = Calendar.getInstance();
        if (this.f153500e == null) {
            Calendar calendar4 = Calendar.getInstance();
            calendar4.set(this.f153507l + 100, this.f153508m - 1, this.C);
            this.f153500e = new Date(calendar4.getTimeInMillis());
        }
        calendar3.setTime(this.f153500e);
        this.f153497b.c(this.D);
        new b(this.f153498c, new f() { // from class: com.tencent.mm.ui.widget.picker.CustomDatePickerNew.2
            @Override // com.tencent.luggage.wxa.fc.f
            public void onTimeSelect(Date date) {
                CustomDatePickerNew.this.a(date);
                n.c("pvTime", "onTimeSelect", new Object[0]);
                if (CustomDatePickerNew.this.G != null) {
                    CustomDatePickerNew.this.G.onTimeSelect(date);
                }
            }
        }).a(new e() { // from class: com.tencent.mm.ui.widget.picker.CustomDatePickerNew.1
            @Override // com.tencent.luggage.wxa.fc.e
            public void onTimeSelectChanged(Date date) {
                n.c("pvTime", "onTimeSelectChanged", new Object[0]);
                if (CustomDatePickerNew.this.F != null) {
                    CustomDatePickerNew.this.F.onTimeSelectChanged(date);
                }
            }
        }).a(false).a(new boolean[]{this.f153506k, this.f153505j, this.f153504i, false, false, false}).a(calendar).a(calendar2, calendar3).b(this.f153498c.getResources().getDimensionPixelSize(R.dimen.bi8)).a(this.f153497b);
        this.f153497b.a(this.f153498c.getResources().getDimensionPixelSize(R.dimen.c5l));
        this.f153497b.c(this.f153498c.getResources().getDimensionPixelSize(R.dimen.bi8));
        this.f153497b.a(this.D, this.E);
        this.f153497b.b(ContextCompat.getColor(this.f153498c, R.color.f156611ai0));
        this.f153497b.a(0, this.f153498c.getResources().getDimensionPixelSize(R.dimen.bht), 0, this.f153498c.getResources().getDimensionPixelSize(R.dimen.bht));
        int i3 = 0;
        for (WheelView wheelView : this.f153497b.m()) {
            if (this.D && this.f153507l == 2 && i3 > 0) {
                wheelView.d(0).c(this.f153498c.getResources().getDimensionPixelSize(R.dimen.bht)).setBackgroundColor(ContextCompat.getColor(this.f153498c, R.color.ah_));
            } else {
                wheelView.d(ContextCompat.getColor(this.f153498c, R.color.f156614aj0)).c(this.f153498c.getResources().getDimensionPixelSize(R.dimen.bht)).setBackgroundColor(ContextCompat.getColor(this.f153498c, R.color.ah_));
            }
            i3++;
        }
        a(this.f153497b.m());
    }

    public void setLongTermYear(boolean z16) {
        this.D = z16;
    }

    public void setMaxDate(Long l3) {
        this.f153500e = new Date(l3.longValue());
    }

    public void setMinDate(Long l3) {
        this.f153499d = new Date(l3.longValue());
    }

    public void setOnTimeSelectListener(f fVar) {
        this.G = fVar;
    }

    public void setPickersEnable(boolean z16, boolean z17, boolean z18) {
        this.f153504i = z18;
        this.f153505j = z17;
        this.f153506k = z16;
    }

    public void setTimeSelectChangeListener(e eVar) {
        this.F = eVar;
    }

    public void setLongTermYear(boolean z16, int i3) {
        this.D = z16;
        this.E = i3;
    }

    public final void a(List list) {
        if (list.size() == 1) {
            ((WheelView) list.get(0)).setPadding(0, this.f153498c.getResources().getDimensionPixelSize(R.dimen.bht), 0, this.f153498c.getResources().getDimensionPixelSize(R.dimen.bht));
            return;
        }
        if (list.size() == 2) {
            ((WheelView) list.get(0)).setPadding(0, this.f153498c.getResources().getDimensionPixelSize(R.dimen.bht), this.f153498c.getResources().getDimensionPixelSize(R.dimen.bht), this.f153498c.getResources().getDimensionPixelSize(R.dimen.bht));
            ((WheelView) list.get(1)).setPadding(this.f153498c.getResources().getDimensionPixelSize(R.dimen.bht), this.f153498c.getResources().getDimensionPixelSize(R.dimen.bht), 0, this.f153498c.getResources().getDimensionPixelSize(R.dimen.bht));
        } else if (list.size() == 3) {
            ((WheelView) list.get(0)).setPadding(0, this.f153498c.getResources().getDimensionPixelSize(R.dimen.bht), this.f153498c.getResources().getDimensionPixelSize(R.dimen.bgc), this.f153498c.getResources().getDimensionPixelSize(R.dimen.bht));
            ((WheelView) list.get(1)).setPadding(this.f153498c.getResources().getDimensionPixelSize(R.dimen.bgc), this.f153498c.getResources().getDimensionPixelSize(R.dimen.bht), this.f153498c.getResources().getDimensionPixelSize(R.dimen.bgc), this.f153498c.getResources().getDimensionPixelSize(R.dimen.bht));
            ((WheelView) list.get(2)).setPadding(this.f153498c.getResources().getDimensionPixelSize(R.dimen.bgc), this.f153498c.getResources().getDimensionPixelSize(R.dimen.bht), 0, this.f153498c.getResources().getDimensionPixelSize(R.dimen.bht));
        }
    }

    public CustomDatePickerNew(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, R.style.at_), attributeSet);
        this.f153496a = null;
        this.f153504i = true;
        this.f153505j = true;
        this.f153506k = true;
        this.D = false;
        this.E = -1;
        this.f153498c = context;
        this.f153497b = new c(context);
    }

    public CustomDatePickerNew(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f153496a = null;
        this.f153504i = true;
        this.f153505j = true;
        this.f153506k = true;
        this.D = false;
        this.E = -1;
        this.f153498c = context;
        this.f153497b = new c(context);
    }

    public final void a(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        this.f153501f = calendar.get(1);
        this.f153502g = calendar.get(2) + 1;
        this.f153503h = calendar.get(5);
    }
}

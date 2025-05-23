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
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mobileqq.R;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes9.dex */
public class CustomTimePickerNew extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public View f153525a;

    /* renamed from: b, reason: collision with root package name */
    public c f153526b;

    /* renamed from: c, reason: collision with root package name */
    public Context f153527c;

    /* renamed from: d, reason: collision with root package name */
    public int f153528d;

    /* renamed from: e, reason: collision with root package name */
    public int f153529e;

    /* renamed from: f, reason: collision with root package name */
    public int f153530f;

    /* renamed from: g, reason: collision with root package name */
    public int f153531g;

    /* renamed from: h, reason: collision with root package name */
    public int f153532h;

    /* renamed from: i, reason: collision with root package name */
    public int f153533i;

    /* renamed from: j, reason: collision with root package name */
    public int f153534j;

    /* renamed from: k, reason: collision with root package name */
    public int f153535k;

    /* renamed from: l, reason: collision with root package name */
    public e f153536l;

    /* renamed from: m, reason: collision with root package name */
    public f f153537m;

    public CustomTimePickerNew(Context context) {
        super(new ContextThemeWrapper(context, R.style.at_));
        this.f153525a = null;
        this.f153528d = -1;
        this.f153529e = -1;
        this.f153530f = -1;
        this.f153531g = -1;
        this.f153532h = -1;
        this.f153533i = -1;
        this.f153527c = context;
        this.f153526b = new c(context);
    }

    public String currentValue() {
        this.f153526b.p();
        return String.format(Locale.US, "%02d:%02d", Integer.valueOf(this.f153534j), Integer.valueOf(this.f153535k));
    }

    public View getView() {
        if (this.f153525a == null) {
            this.f153525a = this.f153526b.l();
        }
        return this.f153525a;
    }

    public void init(int i3, int i16) {
        this.f153532h = i3;
        this.f153533i = i16;
    }

    public void onShow() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, this.f153532h);
        calendar.set(12, this.f153533i);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(11, this.f153528d);
        calendar2.set(12, this.f153529e);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(11, this.f153530f);
        calendar3.set(12, this.f153531g);
        new b(this.f153527c, new f() { // from class: com.tencent.mm.ui.widget.picker.CustomTimePickerNew.2
            @Override // com.tencent.luggage.wxa.fc.f
            public void onTimeSelect(Date date) {
                CustomTimePickerNew.this.a(date);
            }
        }).a(new boolean[]{false, false, false, true, true, false}).a(calendar).a(calendar2, calendar3).a(new e() { // from class: com.tencent.mm.ui.widget.picker.CustomTimePickerNew.1
            @Override // com.tencent.luggage.wxa.fc.e
            public void onTimeSelectChanged(Date date) {
                if (CustomTimePickerNew.this.f153536l != null) {
                    CustomTimePickerNew.this.f153536l.onTimeSelectChanged(date);
                }
            }
        }).a(false).a(ContextCompat.getColor(this.f153527c, R.color.f156611ai0)).a(this.f153526b);
        this.f153526b.a(this.f153527c.getResources().getDimensionPixelSize(R.dimen.c5l));
        this.f153526b.c(this.f153527c.getResources().getDimensionPixelSize(R.dimen.bi8));
        this.f153526b.a(0, this.f153527c.getResources().getDimensionPixelSize(R.dimen.bht), 0, this.f153527c.getResources().getDimensionPixelSize(R.dimen.bht));
        Iterator it = this.f153526b.m().iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).d(ContextCompat.getColor(this.f153527c, R.color.f156614aj0)).c(this.f153527c.getResources().getDimensionPixelSize(R.dimen.bht)).setBackgroundColor(ContextCompat.getColor(this.f153527c, R.color.ah_));
        }
        a(this.f153526b.m());
    }

    public void setMaxTime(int i3, int i16) {
        this.f153530f = i3;
        this.f153531g = i16;
    }

    public void setMinTime(int i3, int i16) {
        this.f153528d = i3;
        this.f153529e = i16;
    }

    public void setOnTimeSelectListener(f fVar) {
        this.f153537m = fVar;
    }

    public void setTimeSelectChangeListener(e eVar) {
        this.f153536l = eVar;
    }

    public final void a(List list) {
        if (list.size() == 1) {
            ((WheelView) list.get(0)).setPadding(0, this.f153527c.getResources().getDimensionPixelSize(R.dimen.bht), 0, this.f153527c.getResources().getDimensionPixelSize(R.dimen.bht));
            return;
        }
        if (list.size() == 2) {
            ((WheelView) list.get(0)).setPadding(0, this.f153527c.getResources().getDimensionPixelSize(R.dimen.bht), this.f153527c.getResources().getDimensionPixelSize(R.dimen.bht), this.f153527c.getResources().getDimensionPixelSize(R.dimen.bht));
            ((WheelView) list.get(1)).setPadding(this.f153527c.getResources().getDimensionPixelSize(R.dimen.bht), this.f153527c.getResources().getDimensionPixelSize(R.dimen.bht), 0, this.f153527c.getResources().getDimensionPixelSize(R.dimen.bht));
        } else if (list.size() == 3) {
            ((WheelView) list.get(0)).setPadding(0, this.f153527c.getResources().getDimensionPixelSize(R.dimen.bht), this.f153527c.getResources().getDimensionPixelSize(R.dimen.bgc), this.f153527c.getResources().getDimensionPixelSize(R.dimen.bht));
            ((WheelView) list.get(1)).setPadding(this.f153527c.getResources().getDimensionPixelSize(R.dimen.bgc), this.f153527c.getResources().getDimensionPixelSize(R.dimen.bht), this.f153527c.getResources().getDimensionPixelSize(R.dimen.bgc), this.f153527c.getResources().getDimensionPixelSize(R.dimen.bht));
            ((WheelView) list.get(2)).setPadding(this.f153527c.getResources().getDimensionPixelSize(R.dimen.bgc), this.f153527c.getResources().getDimensionPixelSize(R.dimen.bht), 0, this.f153527c.getResources().getDimensionPixelSize(R.dimen.bht));
        }
    }

    public CustomTimePickerNew(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, R.style.at_), attributeSet);
        this.f153525a = null;
        this.f153528d = -1;
        this.f153529e = -1;
        this.f153530f = -1;
        this.f153531g = -1;
        this.f153532h = -1;
        this.f153533i = -1;
        this.f153527c = context;
        this.f153526b = new c(context);
    }

    public CustomTimePickerNew(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f153525a = null;
        this.f153528d = -1;
        this.f153529e = -1;
        this.f153530f = -1;
        this.f153531g = -1;
        this.f153532h = -1;
        this.f153533i = -1;
        this.f153527c = context;
        this.f153526b = new c(context);
    }

    public final void a(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        this.f153534j = calendar.get(11);
        this.f153535k = calendar.get(12);
    }
}

package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.annotation.Keep;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.fc.e;
import com.tencent.luggage.wxa.fc.f;
import com.tencent.luggage.wxa.zf.c;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mobileqq.R;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes9.dex */
public class AppBrandDatePickerV2 implements c {

    /* renamed from: a, reason: collision with root package name */
    public View f152411a = null;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.hc.c f152412b;

    /* renamed from: c, reason: collision with root package name */
    public Context f152413c;

    /* renamed from: d, reason: collision with root package name */
    public Date f152414d;

    /* renamed from: e, reason: collision with root package name */
    public Date f152415e;

    /* renamed from: f, reason: collision with root package name */
    public int f152416f;

    /* renamed from: g, reason: collision with root package name */
    public int f152417g;

    /* renamed from: h, reason: collision with root package name */
    public int f152418h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f152419i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f152420j;

    /* loaded from: classes9.dex */
    public class a implements e {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.fc.e
        public void onTimeSelectChanged(Date date) {
            Log.i("pvTime", "onTimeSelectChanged");
        }
    }

    /* loaded from: classes9.dex */
    public class b implements f {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.fc.f
        public void onTimeSelect(Date date) {
            AppBrandDatePickerV2.this.a(date);
            Log.i("pvTime", "onTimeSelect");
        }
    }

    @Keep
    public AppBrandDatePickerV2(Context context) {
        this.f152413c = context;
        this.f152412b = new com.tencent.luggage.wxa.hc.c(context);
    }

    public void b(Long l3) {
        this.f152414d = new Date(l3.longValue());
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public View getView() {
        if (this.f152411a == null) {
            this.f152411a = this.f152412b.l();
        }
        return this.f152411a;
    }

    @Override // com.tencent.luggage.wxa.zf.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String currentValue() {
        this.f152412b.p();
        return this.f152419i ? String.format(Locale.US, "%04d-%02d-%02d", Integer.valueOf(this.f152416f), Integer.valueOf(this.f152417g), Integer.valueOf(this.f152418h)) : this.f152420j ? String.format(Locale.US, "%04d-%02d", Integer.valueOf(this.f152416f), Integer.valueOf(this.f152417g)) : String.format(Locale.US, "%04d", Integer.valueOf(this.f152416f));
    }

    public void a(int i3, int i16, int i17, boolean z16, boolean z17, boolean z18) {
        this.f152419i = z18;
        this.f152420j = z17;
        Calendar calendar = Calendar.getInstance();
        calendar.set(i3, i16 - 1, i17);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(this.f152414d);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(this.f152415e);
        new com.tencent.luggage.wxa.dc.b(this.f152413c, new b()).a(new a()).a(false).a(new boolean[]{z16, z17, z18, false, false, false}).a(calendar).a(calendar2, calendar3).b(this.f152413c.getResources().getDimensionPixelSize(R.dimen.cxz)).a(this.f152412b);
        this.f152412b.a(this.f152413c.getResources().getDimensionPixelSize(R.dimen.c5l));
        this.f152412b.c(this.f152413c.getResources().getDimensionPixelSize(R.dimen.cxz));
        this.f152412b.b(ContextCompat.getColor(this.f152413c, R.color.f156611ai0));
        this.f152412b.a(0, this.f152413c.getResources().getDimensionPixelSize(R.dimen.bht), 0, this.f152413c.getResources().getDimensionPixelSize(R.dimen.bht));
        Iterator it = this.f152412b.m().iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).d(ContextCompat.getColor(this.f152413c, R.color.f156614aj0)).c(this.f152413c.getResources().getDimensionPixelSize(R.dimen.bht)).setBackgroundColor(ContextCompat.getColor(this.f152413c, R.color.ah_));
        }
        a(this.f152412b.m());
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onAttach(com.tencent.luggage.wxa.zl.c cVar) {
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onDetach(com.tencent.luggage.wxa.zl.c cVar) {
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onHide(com.tencent.luggage.wxa.zl.c cVar) {
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onShow(com.tencent.luggage.wxa.zl.c cVar) {
    }

    public final void a(List list) {
        if (list.size() == 1) {
            ((WheelView) list.get(0)).setPadding(0, this.f152413c.getResources().getDimensionPixelSize(R.dimen.bht), 0, this.f152413c.getResources().getDimensionPixelSize(R.dimen.bht));
            return;
        }
        if (list.size() == 2) {
            ((WheelView) list.get(0)).setPadding(0, this.f152413c.getResources().getDimensionPixelSize(R.dimen.bht), this.f152413c.getResources().getDimensionPixelSize(R.dimen.bht), this.f152413c.getResources().getDimensionPixelSize(R.dimen.bht));
            ((WheelView) list.get(1)).setPadding(this.f152413c.getResources().getDimensionPixelSize(R.dimen.bht), this.f152413c.getResources().getDimensionPixelSize(R.dimen.bht), 0, this.f152413c.getResources().getDimensionPixelSize(R.dimen.bht));
        } else if (list.size() == 3) {
            ((WheelView) list.get(0)).setPadding(0, this.f152413c.getResources().getDimensionPixelSize(R.dimen.bht), this.f152413c.getResources().getDimensionPixelSize(R.dimen.bgc), this.f152413c.getResources().getDimensionPixelSize(R.dimen.bht));
            ((WheelView) list.get(1)).setPadding(this.f152413c.getResources().getDimensionPixelSize(R.dimen.bgc), this.f152413c.getResources().getDimensionPixelSize(R.dimen.bht), this.f152413c.getResources().getDimensionPixelSize(R.dimen.bgc), this.f152413c.getResources().getDimensionPixelSize(R.dimen.bht));
            ((WheelView) list.get(2)).setPadding(this.f152413c.getResources().getDimensionPixelSize(R.dimen.bgc), this.f152413c.getResources().getDimensionPixelSize(R.dimen.bht), 0, this.f152413c.getResources().getDimensionPixelSize(R.dimen.bht));
        }
    }

    public final void a(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        this.f152416f = calendar.get(1);
        this.f152417g = calendar.get(2) + 1;
        this.f152418h = calendar.get(5);
    }

    public void a(Long l3) {
        this.f152415e = new Date(l3.longValue());
    }
}

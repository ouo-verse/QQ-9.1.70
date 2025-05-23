package com.tencent.luggage.wxa.hc;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.hc.a implements View.OnClickListener {
    public e D;
    public Context E;
    public String F;
    public boolean G;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.fc.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.fc.a
        public void a() {
            try {
                c.this.f126978e.f124620c.onTimeSelectChanged(e.G.parse(c.this.D.d()));
            } catch (ParseException e16) {
                n.a(c.this.F, e16, "", new Object[0]);
            }
        }
    }

    public c(Context context) {
        super(context);
        this.F = "TimePickerView";
        this.G = false;
        this.D = new e(context);
        this.E = context;
    }

    public void c(boolean z16) {
        this.G = z16;
        e eVar = this.D;
        if (eVar != null) {
            eVar.b(z16);
        }
    }

    @Override // com.tencent.luggage.wxa.hc.a
    public boolean i() {
        return this.f126978e.S;
    }

    public View l() {
        if (this.D.e() == null) {
            View inflate = LayoutInflater.from(this.E).inflate(R.layout.fka, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.f97565kq);
            ((ViewGroup) inflate).removeView(linearLayout);
            linearLayout.setBackgroundColor(-1);
            this.D.a(linearLayout);
        }
        return this.D.e();
    }

    public List m() {
        return this.D.f();
    }

    public final void n() {
        if (this.G) {
            return;
        }
        com.tencent.luggage.wxa.ec.a aVar = this.f126978e;
        Calendar calendar = aVar.f124629l;
        if (calendar != null && aVar.f124630m != null) {
            Calendar calendar2 = aVar.f124628k;
            if (calendar2 != null && calendar2.getTimeInMillis() >= this.f126978e.f124629l.getTimeInMillis()) {
                if (this.f126978e.f124628k.getTimeInMillis() > this.f126978e.f124630m.getTimeInMillis()) {
                    com.tencent.luggage.wxa.ec.a aVar2 = this.f126978e;
                    aVar2.f124628k = aVar2.f124630m;
                    return;
                }
                return;
            }
            com.tencent.luggage.wxa.ec.a aVar3 = this.f126978e;
            aVar3.f124628k = aVar3.f124629l;
            return;
        }
        if (calendar != null) {
            aVar.f124628k = calendar;
            return;
        }
        Calendar calendar3 = aVar.f124630m;
        if (calendar3 != null) {
            aVar.f124628k = calendar3;
        }
    }

    public final void o() {
        int i3;
        e eVar = this.D;
        com.tencent.luggage.wxa.ec.a aVar = this.f126978e;
        eVar.a((View) null, aVar.f124627j, aVar.D);
        if (this.f126978e.f124620c != null) {
            this.D.a(new a());
        }
        com.tencent.luggage.wxa.ec.a aVar2 = this.f126978e;
        int i16 = aVar2.f124631n;
        if (i16 != 0 && (i3 = aVar2.f124632o) != 0 && i16 <= i3) {
            r();
        }
        com.tencent.luggage.wxa.ec.a aVar3 = this.f126978e;
        Calendar calendar = aVar3.f124629l;
        if (calendar != null && aVar3.f124630m != null) {
            if (calendar.getTimeInMillis() > this.f126978e.f124630m.getTimeInMillis()) {
                n.b(this.F, "initWheelTime: startDate can't be later than endDate, set startDate to null", new Object[0]);
                this.f126978e.f124629l = null;
            }
        } else if (calendar != null) {
            if (calendar.get(1) < 1900) {
                n.b(this.F, "initWheelTime: The startDate can not as early as 1900, set startDate to null", new Object[0]);
                this.f126978e.f124629l = null;
            }
        } else {
            Calendar calendar2 = aVar3.f124630m;
            if (calendar2 != null && calendar2.get(1) > 2100) {
                n.b(this.F, "initWheelTime: The endDate should not be later than 2100, set endDate to null", new Object[0]);
                this.f126978e.f124629l = null;
            }
        }
        q();
        s();
        if (this.E.getResources().getConfiguration().locale.getLanguage().endsWith(OcrConfig.CHINESE)) {
            e eVar2 = this.D;
            com.tencent.luggage.wxa.ec.a aVar4 = this.f126978e;
            eVar2.a(aVar4.f124633p, aVar4.f124634q, aVar4.f124635r, aVar4.f124636s, aVar4.f124637t, aVar4.f124638u);
        }
        e eVar3 = this.D;
        com.tencent.luggage.wxa.ec.a aVar5 = this.f126978e;
        eVar3.c(aVar5.f124639v, aVar5.f124640w, aVar5.f124641x, aVar5.f124642y, aVar5.f124643z, aVar5.A);
        b(this.f126978e.T);
        this.D.a(this.f126978e.P);
        this.D.a(this.f126978e.W);
        this.D.c(this.f126978e.f124625h);
        this.D.b(this.f126978e.R);
        this.D.a(this.f126978e.U);
        this.D.c(this.f126978e.X);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            p();
        }
        a();
    }

    public void p() {
        if (this.f126978e.f124619b != null) {
            try {
                this.f126978e.f124619b.onTimeSelect(e.G.parse(this.D.d()));
            } catch (ParseException e16) {
                n.a(this.F, e16, "", new Object[0]);
            }
        }
    }

    public final void q() {
        e eVar = this.D;
        com.tencent.luggage.wxa.ec.a aVar = this.f126978e;
        eVar.a(aVar.f124629l, aVar.f124630m);
        n();
    }

    public final void r() {
        this.D.d(this.f126978e.f124631n);
        this.D.b(this.f126978e.f124632o);
    }

    public final void s() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        Calendar calendar = this.f126978e.f124628k;
        if (calendar == null) {
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(System.currentTimeMillis());
            i3 = calendar2.get(1);
            i16 = calendar2.get(2);
            i17 = calendar2.get(5);
            i18 = calendar2.get(11);
            i19 = calendar2.get(12);
            i26 = calendar2.get(13);
        } else {
            i3 = calendar.get(1);
            i16 = this.f126978e.f124628k.get(2);
            i17 = this.f126978e.f124628k.get(5);
            i18 = this.f126978e.f124628k.get(11);
            i19 = this.f126978e.f124628k.get(12);
            i26 = this.f126978e.f124628k.get(13);
        }
        int i27 = i18;
        int i28 = i17;
        int i29 = i16;
        int i36 = i3;
        e eVar = this.D;
        eVar.a(i36, i29, i28, i27, i19, i26);
    }

    public void a(com.tencent.luggage.wxa.ec.a aVar) {
        this.f126978e = aVar;
        a(aVar.E);
    }

    public void b(int i3) {
        this.D.a(i3);
    }

    public final void a(Context context) {
        k();
        h();
        f();
        LayoutInflater.from(context).inflate(R.layout.fka, this.f126975b);
        TextView textView = (TextView) a(R.id.k4v);
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.f7923498);
        Button button = (Button) a(R.id.tcc);
        Button button2 = (Button) a(R.id.tbx);
        button.setTag("submit");
        button2.setTag("cancel");
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button.setText(TextUtils.isEmpty(this.f126978e.F) ? context.getResources().getString(R.string.f174712wl) : this.f126978e.F);
        button2.setText(TextUtils.isEmpty(this.f126978e.G) ? context.getResources().getString(R.string.f174652wf) : this.f126978e.G);
        textView.setText(TextUtils.isEmpty(this.f126978e.H) ? "" : this.f126978e.H);
        button.setTextColor(this.f126978e.I);
        button2.setTextColor(this.f126978e.J);
        textView.setTextColor(this.f126978e.K);
        relativeLayout.setBackgroundColor(this.f126978e.M);
        button.setTextSize(this.f126978e.N);
        button2.setTextSize(this.f126978e.N);
        textView.setTextSize(this.f126978e.O);
        o();
    }

    public void c(int i3) {
        this.D.c(i3);
    }

    public void a(boolean z16, int i3) {
        e eVar = this.D;
        if (eVar != null) {
            eVar.a(z16, i3);
        }
    }

    public void a(float f16) {
        e eVar = this.D;
        if (eVar != null) {
            eVar.a(f16);
        }
    }

    public void a(int i3, int i16, int i17, int i18) {
        this.D.a(i3, i16, i17, i18);
    }
}

package com.tencent.mobileqq.location.ui;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private k f241667a;

    /* renamed from: b, reason: collision with root package name */
    TextView f241668b;

    /* renamed from: c, reason: collision with root package name */
    TextView f241669c;

    /* renamed from: d, reason: collision with root package name */
    TextView f241670d;

    /* renamed from: e, reason: collision with root package name */
    TextView f241671e;

    /* renamed from: f, reason: collision with root package name */
    View f241672f;

    /* renamed from: g, reason: collision with root package name */
    View f241673g;

    /* renamed from: h, reason: collision with root package name */
    View f241674h;

    /* renamed from: i, reason: collision with root package name */
    View f241675i;

    /* renamed from: j, reason: collision with root package name */
    View f241676j;

    /* renamed from: k, reason: collision with root package name */
    View f241677k;

    /* renamed from: l, reason: collision with root package name */
    View f241678l;

    /* renamed from: m, reason: collision with root package name */
    View f241679m;

    /* renamed from: n, reason: collision with root package name */
    View f241680n;

    /* renamed from: o, reason: collision with root package name */
    TextView f241681o;

    /* renamed from: p, reason: collision with root package name */
    TextView f241682p;

    /* renamed from: q, reason: collision with root package name */
    TextView f241683q;

    /* renamed from: r, reason: collision with root package name */
    int f241684r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!m.this.f241667a.t()) {
                m.this.f241667a.f241654f.v(true);
                m.this.f241667a.u();
                ReportController.o(null, "CliOper", "", "", "0X800A973", "0X800A973", 0, 0, "0", "0", "0", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!m.this.f241667a.t()) {
                m.this.f241667a.f241654f.B(m.this.c());
                ReportController.o(null, "CliOper", "", "", "0X800A96F", "0X800A96F", 0, 0, "0", "0", "0", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!m.this.f241667a.t() && !view.isSelected()) {
                m.this.k(view);
                m mVar = m.this;
                mVar.f241684r = 1;
                mVar.f241667a.f(1);
                ReportController.o(null, "CliOper", "", "", "0X800A96E", "0X800A96E", 2, 0, "0", "0", "0", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!m.this.f241667a.t() && !view.isSelected()) {
                m.this.k(view);
                m mVar = m.this;
                mVar.f241684r = 2;
                mVar.f241667a.f(2);
                ReportController.o(null, "CliOper", "", "", "0X800A96E", "0X800A96E", 3, 0, "0", "0", "0", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!m.this.f241667a.t() && !view.isSelected()) {
                m.this.k(view);
                m mVar = m.this;
                mVar.f241684r = 3;
                mVar.f241667a.f(3);
                ReportController.o(null, "CliOper", "", "", "0X800A96E", "0X800A96E", 1, 0, "0", "0", "0", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) kVar, (Object) view);
            return;
        }
        this.f241684r = 0;
        this.f241667a = kVar;
        f(view);
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        int i3 = this.f241684r;
        if (i3 != 2) {
            if (i3 != 3) {
                return "drive";
            }
            return "walk";
        }
        return "bus";
    }

    private void e() {
        this.f241673g.setOnClickListener(new a());
        this.f241674h.setOnClickListener(new b());
        this.f241678l.setOnClickListener(new c());
        this.f241679m.setOnClickListener(new d());
        this.f241680n.setOnClickListener(new e());
    }

    private void f(View view) {
        this.f241672f = view.findViewById(R.id.do6);
        this.f241668b = (TextView) view.findViewById(R.id.dsz);
        this.f241669c = (TextView) view.findViewById(R.id.dsu);
        this.f241673g = view.findViewById(R.id.do5);
        this.f241670d = (TextView) view.findViewById(R.id.dsm);
        this.f241671e = (TextView) view.findViewById(R.id.dpp);
        this.f241674h = view.findViewById(R.id.dr9);
        this.f241675i = view.findViewById(R.id.dpu);
        this.f241676j = view.findViewById(R.id.f166818do4);
        this.f241677k = view.findViewById(R.id.dsh);
        View findViewById = view.findViewById(R.id.dsb);
        this.f241678l = findViewById;
        Drawable background = findViewById.getBackground();
        background.setAlpha(25);
        this.f241678l.setBackground(background);
        View findViewById2 = view.findViewById(R.id.ds_);
        this.f241679m = findViewById2;
        Drawable background2 = findViewById2.getBackground();
        background2.setAlpha(25);
        this.f241679m.setBackground(background2);
        View findViewById3 = view.findViewById(R.id.dsd);
        this.f241680n = findViewById3;
        Drawable background3 = findViewById3.getBackground();
        background3.setAlpha(25);
        this.f241680n.setBackground(background3);
        this.f241681o = (TextView) view.findViewById(R.id.icc);
        this.f241682p = (TextView) view.findViewById(R.id.ic7);
        this.f241683q = (TextView) view.findViewById(R.id.icg);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.f241672f.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MapWidget.k kVar) {
        int i3;
        Integer num;
        this.f241675i.setVisibility(8);
        this.f241677k.setVisibility(8);
        this.f241676j.setVisibility(0);
        LocationRoom.Venue l3 = this.f241667a.f241654f.l();
        this.f241668b.setText(l3.f241271f);
        this.f241669c.setText(l3.f241272h);
        if (kVar != null && (num = kVar.f241536a) != null) {
            i3 = num.intValue();
        } else {
            i3 = 1;
        }
        j(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(int i3) {
        this.f241675i.setVisibility(0);
        this.f241677k.setVisibility(8);
        this.f241676j.setVisibility(8);
        LocationRoom.Venue l3 = this.f241667a.f241654f.l();
        this.f241668b.setText(l3.f241271f);
        this.f241669c.setText(l3.f241272h);
        j(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void i(MapWidget.k kVar, LocationRoom.Venue venue) {
        String format;
        this.f241675i.setVisibility(8);
        this.f241677k.setVisibility(0);
        this.f241676j.setVisibility(8);
        this.f241668b.setText(venue.f241271f);
        this.f241669c.setText(venue.f241272h);
        this.f241670d.setText(MapUtils.g(kVar.f241537b));
        if (kVar.f241538c < 1000.0f) {
            format = String.format(BaseApplication.getContext().getResources().getString(R.string.hh7), Integer.valueOf(Math.round(kVar.f241538c)));
        } else {
            format = String.format(BaseApplication.getContext().getResources().getString(R.string.hh6), Double.valueOf(kVar.f241538c / 1000.0d));
        }
        this.f241671e.setText(format);
        j(kVar.f241536a.intValue());
    }

    void j(int i3) {
        this.f241684r = i3;
        if (i3 != 2) {
            if (i3 != 3) {
                this.f241684r = 1;
                k(this.f241678l);
                return;
            } else {
                k(this.f241680n);
                return;
            }
        }
        k(this.f241679m);
    }

    void k(View view) {
        this.f241678l.setSelected(false);
        this.f241679m.setSelected(false);
        this.f241680n.setSelected(false);
        view.setSelected(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        this.f241672f.setVisibility(0);
    }
}

package com.tencent.mobileqq.location.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.location.LocationShareViewModel;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes15.dex */
public class o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    TextView f241691a;

    /* renamed from: b, reason: collision with root package name */
    TextView f241692b;

    /* renamed from: c, reason: collision with root package name */
    TextView f241693c;

    /* renamed from: d, reason: collision with root package name */
    View f241694d;

    /* renamed from: e, reason: collision with root package name */
    View f241695e;

    /* renamed from: f, reason: collision with root package name */
    View f241696f;

    /* renamed from: g, reason: collision with root package name */
    k f241697g;

    /* renamed from: h, reason: collision with root package name */
    LocationShareViewModel f241698h;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!o.this.f241697g.t()) {
                ReportController.o(null, "CliOper", "", "", "0X800A966", "0X800A966", 0, 0, "0", "0", "0", "");
                k kVar = o.this.f241697g;
                LocationDialogUtil.j(kVar.f241657i, kVar);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!o.this.f241697g.t()) {
                o.this.f241697g.f(null);
                ReportController.o(null, "CliOper", "", "", "0X800A96B", "0X800A96B", 0, 0, "0", "0", "0", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar, LocationShareViewModel locationShareViewModel, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, kVar, locationShareViewModel, view);
            return;
        }
        this.f241697g = kVar;
        this.f241698h = locationShareViewModel;
        d(view);
    }

    private void d(View view) {
        this.f241694d = view.findViewById(R.id.ebp);
        this.f241691a = (TextView) view.findViewById(R.id.f167086ed4);
        this.f241692b = (TextView) view.findViewById(R.id.eba);
        this.f241693c = (TextView) view.findViewById(R.id.edo);
        this.f241695e = view.findViewById(R.id.ebz);
        this.f241696f = view.findViewById(R.id.edk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit e(String str) {
        MapUtils.q(str, BaseApplication.getContext().getResources().getString(R.string.hhn), this.f241693c);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f241694d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(LocationRoom.Venue venue) {
        if (venue == null) {
            venue = this.f241697g.f241654f.l();
        }
        TextView textView = this.f241691a;
        String string = BaseApplication.getContext().getResources().getString(R.string.hhm);
        Object[] objArr = new Object[1];
        String str = venue.f241271f;
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        textView.setText(String.format(string, objArr));
        this.f241692b.setText(venue.f241272h);
        MapUtils.q(this.f241698h.R1(venue.f241270e, new Function1() { // from class: com.tencent.mobileqq.location.ui.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit e16;
                e16 = o.this.e((String) obj);
                return e16;
            }
        }), BaseApplication.getContext().getResources().getString(R.string.hhn), this.f241693c);
        this.f241695e.setOnClickListener(new a());
        this.f241696f.setOnClickListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f241694d.setVisibility(0);
    }
}

package com.tencent.mobileqq.location.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.location.LocationShareViewModel;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqcommon.api.IBaseImageUtilApi;
import com.tencent.mobileqq.qqcommon.api.ILiuHaiUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.az;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private o f241649a;

    /* renamed from: b, reason: collision with root package name */
    private m f241650b;

    /* renamed from: c, reason: collision with root package name */
    private View f241651c;

    /* renamed from: d, reason: collision with root package name */
    private View f241652d;

    /* renamed from: e, reason: collision with root package name */
    private View f241653e;

    /* renamed from: f, reason: collision with root package name */
    public MapWidget f241654f;

    /* renamed from: g, reason: collision with root package name */
    private HeadSetViewModule f241655g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f241656h;

    /* renamed from: i, reason: collision with root package name */
    public QBaseActivity f241657i;

    /* renamed from: j, reason: collision with root package name */
    private LocationRoom.b f241658j;

    /* renamed from: k, reason: collision with root package name */
    private DecodeTaskCompletionListener f241659k;

    /* renamed from: l, reason: collision with root package name */
    private final LocationShareViewModel f241660l;

    /* renamed from: m, reason: collision with root package name */
    private final com.tencent.mobileqq.mvvm.d f241661m;

    /* renamed from: n, reason: collision with root package name */
    private View.OnClickListener f241662n;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!k.this.t()) {
                k.this.f241654f.p(true);
                k.this.f241660l.Z1();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements DecodeTaskCompletionListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this);
            }
        }

        @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
        public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("LocationShareController", 2, "[location] onDecodeTaskCompleted invoked. ", "remainingTasks = [" + i3 + "], uin = [" + str + "], avatar = [" + bitmap + "]");
            }
            Bitmap roundFaceBitmap = ((IBaseImageUtilApi) QRoute.api(IBaseImageUtilApi.class)).getRoundFaceBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight());
            com.tencent.mobileqq.location.model.a b16 = com.tencent.mobileqq.location.ui.b.c().b(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (b16 == null) {
                b16 = new com.tencent.mobileqq.location.model.a();
                com.tencent.mobileqq.location.ui.b.c().e(str, b16);
            }
            b16.f241298a = currentTimeMillis;
            b16.f241300c = roundFaceBitmap;
            k.this.f241654f.H(str, roundFaceBitmap);
            if (k.this.f241659k != null) {
                k.this.f241659k.onDecodeTaskCompleted(i3, i16, str, roundFaceBitmap);
            }
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements MapWidget.j {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this);
            }
        }

        @Override // com.tencent.mobileqq.location.ui.MapWidget.j
        public void a(boolean z16, Point point) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), point);
            } else if (z16) {
                k kVar = k.this;
                kVar.q(kVar.f241660l, true);
            } else {
                k kVar2 = k.this;
                kVar2.q(kVar2.f241660l, false);
            }
        }

        @Override // com.tencent.mobileqq.location.ui.MapWidget.j
        public void b(LatLng latLng, float f16, List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, latLng, Float.valueOf(f16), list);
                return;
            }
            if (list == null) {
                return;
            }
            for (String str : list) {
                Bitmap d16 = com.tencent.mobileqq.location.ui.b.c().d(str);
                if (d16 != null) {
                    k.this.f241654f.H(str, ((IBaseImageUtilApi) QRoute.api(IBaseImageUtilApi.class)).getRoundFaceBitmap(d16, d16.getWidth(), d16.getHeight()));
                }
            }
        }

        @Override // com.tencent.mobileqq.location.ui.MapWidget.j
        public void c(LatLng latLng) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) latLng);
            }
        }

        @Override // com.tencent.mobileqq.location.ui.MapWidget.j
        public void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.location.ui.MapWidget.j
        public void e(LocationRoom.Venue venue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) venue);
            } else if (venue == null) {
                k.this.i();
            } else {
                k.this.u();
            }
        }

        @Override // com.tencent.mobileqq.location.ui.MapWidget.j
        public void f(boolean z16, MapWidget.k kVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                k.this.g(z16, kVar);
            } else {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), kVar);
            }
        }
    }

    public k(LocationShareViewModel locationShareViewModel, com.tencent.mobileqq.mvvm.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) locationShareViewModel, (Object) dVar);
            return;
        }
        this.f241662n = new a();
        this.f241660l = locationShareViewModel;
        this.f241661m = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z16, MapWidget.k kVar) {
        if (QLog.isColorLevel()) {
            QLog.d("LocationShareController", 2, "[venue] finishRoute: called. success: " + z16 + " routeType: " + kVar.f241536a);
        }
        LocationRoom.Venue l3 = this.f241654f.l();
        if (l3 == null) {
            if (QLog.isColorLevel()) {
                QLog.e("LocationShareController", 2, "[venue] finishRoute: called. venue null");
            }
            i();
            return;
        }
        if (kVar.f241536a != null) {
            if (z16) {
                this.f241650b.i(kVar, l3);
            } else {
                this.f241650b.g(kVar);
            }
        } else {
            this.f241650b.g(kVar);
            QQToast.makeText(this.f241657i, 1, "\u8def\u5f84\u89c4\u5212\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 1).show();
        }
        this.f241653e.setVisibility(0);
        this.f241651c.setVisibility(8);
        this.f241649a.b();
        this.f241650b.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (QLog.isColorLevel()) {
            QLog.d("LocationShareController", 2, "[venue] hideVenueAndRoute: called.");
        }
        this.f241653e.setVisibility(4);
        this.f241651c.setVisibility(0);
        this.f241649a.b();
        this.f241650b.d();
    }

    private void k() {
        this.f241656h.setOnClickListener(this.f241662n);
        this.f241654f.setListener(new d());
    }

    private boolean l() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    private void n(com.tencent.mobileqq.location.model.c cVar) {
        this.f241654f.setVenueOprating(false);
        this.f241652d.setVisibility(8);
        if (cVar.f241305b) {
            this.f241654f.setVenue(cVar.f241304a);
            QQToast.makeText(this.f241657i, 2, "\u96c6\u5408\u70b9\u8bbe\u7f6e\u6210\u529f", 0).show();
            ReportController.o(null, "CliOper", "", "", "0X800A964", "0X800A964", 0, 0, "0", "0", "0", "");
            return;
        }
        int i3 = cVar.f241306c;
        if (i3 != 10104) {
            if (i3 != 10105) {
                QQToast.makeText(this.f241657i, 1, "\u8bbe\u7f6e\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
            } else {
                QQToast.makeText(this.f241657i, 1, "\u5df2\u6709\u4eba\u8bbe\u7f6e\u96c6\u5408\u70b9", 0).show();
            }
        } else {
            QQToast.makeText(this.f241657i, 1, "\u4f60\u5df2\u79bb\u5f00\u5171\u4eab\u4f1a\u8bdd", 0).show();
            this.f241657i.finish();
        }
        if (this.f241654f.l() != null) {
            u();
        } else {
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(LocationShareViewModel locationShareViewModel, boolean z16) {
        if (l()) {
            locationShareViewModel.E.setValue(Boolean.valueOf(z16));
        } else {
            locationShareViewModel.E.postValue(Boolean.valueOf(z16));
        }
    }

    private void v(LocationRoom.Venue venue) {
        if (QLog.isColorLevel()) {
            QLog.d("LocationShareController", 2, "[venue] showVenue: called.");
        }
        this.f241653e.setVisibility(0);
        this.f241651c.setVisibility(8);
        this.f241649a.c(venue);
        this.f241650b.d();
        this.f241649a.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Integer num) {
        int intValue;
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(this.f241657i, R.string.hh8, 0).show();
            return;
        }
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        Integer C = this.f241654f.C(intValue);
        if (num == null && C != null) {
            if (C.intValue() == 3) {
                ReportController.o(null, "CliOper", "", "", "0X800A96C", "0X800A96C", 1, 0, "", "0", "0", "");
            } else if (C.intValue() == 1) {
                ReportController.o(null, "CliOper", "", "", "0X800A96C", "0X800A96C", 2, 0, "", "0", "0", "");
            }
        }
        if (C != null) {
            this.f241653e.setVisibility(0);
            this.f241651c.setVisibility(8);
            this.f241650b.h(C.intValue());
            this.f241649a.b();
            this.f241650b.l();
            return;
        }
        MapWidget.k kVar = new MapWidget.k();
        kVar.f241536a = Integer.valueOf(intValue);
        g(false, kVar);
    }

    public void h(com.tencent.mobileqq.location.model.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar);
            return;
        }
        int i3 = cVar.f241307d;
        if (i3 == 1) {
            int i16 = cVar.f241308e;
            if (i16 == 1) {
                this.f241654f.setVenueOprating(true);
                v(cVar.f241304a);
                this.f241652d.setVisibility(0);
                return;
            } else {
                if (i16 == 2) {
                    n(cVar);
                    return;
                }
                return;
            }
        }
        if (i3 == 2) {
            int i17 = cVar.f241308e;
            if (i17 == 1) {
                this.f241654f.setVenueOprating(true);
                this.f241652d.setVisibility(0);
            } else if (i17 == 2) {
                this.f241654f.setVenueOprating(false);
                this.f241652d.setVisibility(8);
                if (cVar.f241305b) {
                    this.f241654f.setVenue(null);
                    i();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(QBaseActivity qBaseActivity, LocationRoom.b bVar, MapWidget mapWidget, HeadSetViewModule headSetViewModule, ImageView imageView, View view, View view2, View view3) {
        int c16;
        this.f241657i = qBaseActivity;
        this.f241654f = mapWidget;
        this.f241655g = headSetViewModule;
        this.f241656h = imageView;
        this.f241658j = bVar;
        this.f241651c = view2;
        this.f241652d = view;
        this.f241653e = view3;
        this.f241649a = new o(this, this.f241660l, view3);
        this.f241650b = new m(this, view3);
        this.f241652d.setVisibility(8);
        ((ILiuHaiUtilsApi) QRoute.api(ILiuHaiUtilsApi.class)).initLiuHaiProperty(qBaseActivity);
        if (((ILiuHaiUtilsApi) QRoute.api(ILiuHaiUtilsApi.class)).isHasNotch()) {
            c16 = x.c(qBaseActivity, 112.0f) + ((ILiuHaiUtilsApi) QRoute.api(ILiuHaiUtilsApi.class)).getNotchHeight();
        } else {
            c16 = x.c(qBaseActivity, 112.0f);
        }
        this.f241654f.m(qBaseActivity, LocationHandler.K2().J2(this.f241658j), null, c16, view3);
        k();
        com.tencent.mobileqq.location.ui.b.c().f(new b());
        if (az.f()) {
            this.f241656h.setBackgroundResource(R.drawable.hca);
            view3.setBackgroundResource(R.drawable.bg_texture);
        }
        com.tencent.mobileqq.location.f.c(this.f241660l, this.f241661m, this);
    }

    public void m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f241654f.r(str, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        this.f241660l.U1();
        com.tencent.mobileqq.location.ui.b.c().a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(this.f241657i, R.string.hh8, 0).show();
            return;
        }
        LocationRoom.Venue l3 = this.f241654f.l();
        if (l3 == null) {
            QQToast.makeText(this.f241657i, 1, "\u79fb\u9664\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
        } else {
            this.f241660l.e2(l3);
        }
    }

    public void r(boolean z16) {
        Resources resources;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        if (z16) {
            this.f241656h.setClickable(true);
            this.f241656h.setOnClickListener(new c());
            if (az.f()) {
                this.f241656h.setImageDrawable(this.f241657i.getResources().getDrawable(R.drawable.location_my_black_dark));
                return;
            } else {
                this.f241656h.setImageDrawable(this.f241657i.getResources().getDrawable(R.drawable.location_my_black));
                return;
            }
        }
        this.f241656h.setClickable(true);
        this.f241656h.setOnClickListener(this.f241662n);
        Drawable drawable = this.f241656h.getResources().getDrawable(R.drawable.location_my_blue);
        QBaseActivity qBaseActivity = this.f241657i;
        if (qBaseActivity == null || (resources = qBaseActivity.getResources()) == null) {
            return;
        }
        drawable.setColorFilter(resources.getColor(R.color.bdi), PorterDuff.Mode.SRC_ATOP);
        this.f241656h.setImageDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(LocationRoom.Venue venue) {
        if (QLog.isColorLevel()) {
            QLog.d("LocationShareController", 2, "[venue] setVenue: invoked. location: " + venue);
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(this.f241657i, R.string.hh8, 0).show();
        } else {
            if (venue == null) {
                return;
            }
            this.f241660l.P1(venue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t() {
        if (this.f241652d.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
        v(null);
    }

    public void w(com.tencent.mobileqq.location.model.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
            return;
        }
        if (bVar.f241301a.equals(this.f241658j) && !this.f241657i.isFinishing()) {
            for (com.tencent.mobileqq.location.data.a aVar : bVar.f241303c) {
                Bitmap d16 = com.tencent.mobileqq.location.ui.b.c().d(aVar.d());
                if (d16 != null) {
                    this.f241654f.H(aVar.d(), ((IBaseImageUtilApi) QRoute.api(IBaseImageUtilApi.class)).getRoundFaceBitmap(d16, d16.getWidth(), d16.getHeight()));
                }
            }
            this.f241655g.h(bVar.f241303c);
            this.f241654f.u(bVar.f241301a);
        }
    }
}

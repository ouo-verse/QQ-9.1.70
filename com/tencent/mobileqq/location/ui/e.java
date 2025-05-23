package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.location.LocationPickViewModel;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.location.ui.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqcommon.api.IBaseImageUtilApi;
import com.tencent.mobileqq.qqcommon.api.IImmersiveUtilsApi;
import com.tencent.mobileqq.qqcommon.api.ILiuHaiUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.az;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f241582a;

    /* renamed from: b, reason: collision with root package name */
    private PoiSlideBottomPanel f241583b;

    /* renamed from: c, reason: collision with root package name */
    private View f241584c;

    /* renamed from: d, reason: collision with root package name */
    private View f241585d;

    /* renamed from: e, reason: collision with root package name */
    private View f241586e;

    /* renamed from: f, reason: collision with root package name */
    private XListView f241587f;

    /* renamed from: g, reason: collision with root package name */
    private MapWidget f241588g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f241589h;

    /* renamed from: i, reason: collision with root package name */
    private View.OnClickListener f241590i;

    /* renamed from: j, reason: collision with root package name */
    private com.tencent.mobileqq.location.ui.c f241591j;

    /* renamed from: k, reason: collision with root package name */
    private LatLng f241592k;

    /* renamed from: l, reason: collision with root package name */
    private QBaseActivity f241593l;

    /* renamed from: m, reason: collision with root package name */
    private LocationRoom.b f241594m;

    /* renamed from: n, reason: collision with root package name */
    private DecodeTaskCompletionListener f241595n;

    /* renamed from: o, reason: collision with root package name */
    public final LocationPickViewModel f241596o;

    /* renamed from: p, reason: collision with root package name */
    private final com.tencent.mobileqq.mvvm.d f241597p;

    /* renamed from: q, reason: collision with root package name */
    private final AbsListView.OnScrollListener f241598q;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements AbsListView.OnScrollListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private int f241599d;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) absListView, i3);
                return;
            }
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.f241599d) {
                if (!e.this.f241583b.n()) {
                    e.this.f241583b.b();
                }
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("LocationShareController", 4, "onScrollStateChanged");
                    }
                    e.this.f241591j.f();
                }
            }
            this.f241599d = firstVisiblePosition;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PoiSlideBottomPanel f241601d;

        b(PoiSlideBottomPanel poiSlideBottomPanel) {
            this.f241601d = poiSlideBottomPanel;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this, (Object) poiSlideBottomPanel);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                e.this.f241582a = true;
                e.this.f241591j.e(i3);
                if (this.f241601d.n()) {
                    ReportController.o(null, "CliOper", "", "", "0X800A960", "0X800A960", 0, 0, "0", "0", "0", "");
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements DecodeTaskCompletionListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
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
            e.this.f241588g.H(str, roundFaceBitmap);
            if (e.this.f241595n != null) {
                e.this.f241595n.onDecodeTaskCompleted(i3, i16, str, roundFaceBitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f241604d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ EditText f241605e;

        d(Activity activity, EditText editText) {
            this.f241604d = activity;
            this.f241605e = editText;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, e.this, activity, editText);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("LocationShareController", 2, "myBtn onClick: invoked. set my btn black");
                }
                e.this.f241589h.setImageDrawable(this.f241604d.getResources().getDrawable(R.drawable.location_my_black));
                e.this.f241588g.p(true);
                e eVar = e.this;
                eVar.f241592k = eVar.f241588g.k();
                if (this.f241605e.getText().length() > 0) {
                    this.f241605e.setText("");
                } else {
                    e.this.s("");
                }
                ReportController.o(null, "CliOper", "", "", "0X800A771", "0X800A771", 0, 0, "", "0", "0", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.location.ui.e$e, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class C7980e implements MapWidget.j {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private long f241607a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f241608b;

        C7980e(Activity activity) {
            this.f241608b = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this, (Object) activity);
            } else {
                this.f241607a = 0L;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void h(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // com.tencent.mobileqq.location.ui.MapWidget.j
        public void a(boolean z16, Point point) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), point);
                return;
            }
            if (z16) {
                e.this.f241589h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.location.ui.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        e.C7980e.h(view);
                    }
                });
                if (az.f()) {
                    e.this.f241589h.setImageDrawable(this.f241608b.getResources().getDrawable(R.drawable.location_my_black_dark));
                    return;
                } else {
                    e.this.f241589h.setImageDrawable(this.f241608b.getResources().getDrawable(R.drawable.location_my_black));
                    return;
                }
            }
            e.this.f241589h.setOnClickListener(e.this.f241590i);
            Drawable drawable = this.f241608b.getResources().getDrawable(R.drawable.location_my_blue);
            drawable.setColorFilter(this.f241608b.getResources().getColor(R.color.qui_common_brand_standard), PorterDuff.Mode.SRC_ATOP);
            e.this.f241589h.setImageDrawable(drawable);
        }

        @Override // com.tencent.mobileqq.location.ui.MapWidget.j
        public void b(LatLng latLng, float f16, List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, latLng, Float.valueOf(f16), list);
                return;
            }
            if (list != null) {
                for (String str : list) {
                    Bitmap d16 = com.tencent.mobileqq.location.ui.b.c().d(str);
                    if (d16 != null) {
                        e.this.f241588g.H(str, ((IBaseImageUtilApi) QRoute.api(IBaseImageUtilApi.class)).getRoundFaceBitmap(d16, d16.getWidth(), d16.getHeight()));
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.location.ui.MapWidget.j
        public void c(LatLng latLng) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) latLng);
                return;
            }
            if (System.currentTimeMillis() - this.f241607a < 1000) {
                return;
            }
            this.f241607a = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("LocationShareController", 2, "onMapStable onClick: invoked. center: " + latLng);
            }
            e.this.f241592k = latLng;
            e.this.f241591j.j(e.this.f241588g.getMap(), latLng, "");
            ReportController.o(null, "CliOper", "", "", "0X800A95D", "0X800A95D", 0, 0, "", "0", "0", "");
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
            }
        }

        @Override // com.tencent.mobileqq.location.ui.MapWidget.j
        public void f(boolean z16, MapWidget.k kVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), kVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LocationPickViewModel locationPickViewModel, com.tencent.mobileqq.mvvm.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) locationPickViewModel, (Object) dVar);
            return;
        }
        this.f241582a = true;
        this.f241598q = new a();
        this.f241596o = locationPickViewModel;
        this.f241597p = dVar;
    }

    private void l(Activity activity) {
        d dVar = new d(activity, (EditText) this.f241583b.findViewById(R.id.et_search_keyword));
        this.f241590i = dVar;
        this.f241589h.setOnClickListener(dVar);
        this.f241588g.setListener(new C7980e(activity));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationRoom.Venue i() {
        return this.f241591j.g();
    }

    public void j(com.tencent.mobileqq.location.model.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
            return;
        }
        for (com.tencent.mobileqq.location.data.a aVar : bVar.f241303c) {
            Bitmap d16 = com.tencent.mobileqq.location.ui.b.c().d(aVar.d());
            if (d16 != null) {
                this.f241588g.H(aVar.d(), ((IBaseImageUtilApi) QRoute.api(IBaseImageUtilApi.class)).getRoundFaceBitmap(d16, d16.getWidth(), d16.getHeight()));
            }
        }
        this.f241588g.u(bVar.f241301a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(QBaseActivity qBaseActivity, LocationRoom.b bVar, CameraPosition cameraPosition, MapWidget mapWidget, ImageView imageView, View view, PoiSlideBottomPanel poiSlideBottomPanel, XListView xListView, View view2, View view3) {
        int c16;
        this.f241593l = qBaseActivity;
        this.f241584c = view2;
        this.f241585d = view;
        this.f241583b = poiSlideBottomPanel;
        this.f241586e = view3;
        this.f241587f = xListView;
        this.f241588g = mapWidget;
        this.f241589h = imageView;
        this.f241594m = bVar;
        com.tencent.mobileqq.location.ui.c cVar = new com.tencent.mobileqq.location.ui.c(qBaseActivity);
        this.f241591j = cVar;
        this.f241596o.P1(this.f241593l, this.f241594m, cVar);
        this.f241596o.b2();
        xListView.setDividerHeight(0);
        xListView.setAdapter((ListAdapter) this.f241591j);
        xListView.setSelectionAfterHeaderView();
        xListView.setOnScrollListener(this.f241598q);
        xListView.setOnItemClickListener(new b(poiSlideBottomPanel));
        ((ILiuHaiUtilsApi) QRoute.api(ILiuHaiUtilsApi.class)).initLiuHaiProperty(qBaseActivity);
        if (((ILiuHaiUtilsApi) QRoute.api(ILiuHaiUtilsApi.class)).isHasNotch()) {
            c16 = x.c(qBaseActivity, 54.0f) + ((ILiuHaiUtilsApi) QRoute.api(ILiuHaiUtilsApi.class)).getNotchHeight();
        } else {
            c16 = x.c(qBaseActivity, 54.0f) + ((IImmersiveUtilsApi) QRoute.api(IImmersiveUtilsApi.class)).getStatusBarHeight(qBaseActivity);
        }
        this.f241588g.m(qBaseActivity, LocationHandler.K2().J2(this.f241594m), cameraPosition, c16, poiSlideBottomPanel);
        l(qBaseActivity);
        com.tencent.mobileqq.location.ui.b.c().f(new c());
        if (az.f()) {
            this.f241589h.setBackgroundResource(R.drawable.hca);
        }
        com.tencent.mobileqq.location.f.a(this.f241596o, this.f241597p, this);
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.f241596o.Z1();
        this.f241584c.setVisibility(8);
        this.f241586e.setVisibility(0);
        this.f241587f.setVisibility(8);
        this.f241585d.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        this.f241596o.R1();
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f241596o.Z1();
        this.f241584c.setVisibility(8);
        this.f241586e.setVisibility(8);
        this.f241587f.setVisibility(0);
        this.f241585d.setEnabled(false);
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f241596o.X1();
        this.f241584c.setVisibility(0);
        this.f241586e.setVisibility(8);
        this.f241587f.setVisibility(8);
        this.f241585d.setEnabled(false);
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f241596o.X1();
            this.f241582a = false;
        }
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.f241596o.Z1();
        LocationRoom.Venue g16 = this.f241591j.g();
        if (g16 == null) {
            return;
        }
        this.f241588g.o(g16.f241273i, true);
        int h16 = this.f241591j.h();
        if (h16 >= 0) {
            this.f241587f.setSelection(h16);
        }
        if (this.f241582a && this.f241583b.n()) {
            this.f241583b.i();
        }
        this.f241584c.setVisibility(8);
        this.f241586e.setVisibility(8);
        this.f241587f.setVisibility(0);
        this.f241585d.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(String str) {
        this.f241582a = false;
        this.f241596o.a2(this.f241588g.getMap(), this.f241592k, str);
    }
}

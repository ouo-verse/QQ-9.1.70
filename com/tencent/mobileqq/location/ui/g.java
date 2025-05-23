package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.location.LocationPickViewModelV2;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.location.ui.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqcommon.api.IBaseImageUtilApi;
import com.tencent.mobileqq.qqcommon.api.IImmersiveUtilsApi;
import com.tencent.mobileqq.qqcommon.api.ILiuHaiUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.az;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.qphone.base.util.BaseApplication;
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
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f241610a;

    /* renamed from: b, reason: collision with root package name */
    private View f241611b;

    /* renamed from: c, reason: collision with root package name */
    private View f241612c;

    /* renamed from: d, reason: collision with root package name */
    private View f241613d;

    /* renamed from: e, reason: collision with root package name */
    private View f241614e;

    /* renamed from: f, reason: collision with root package name */
    private XListView f241615f;

    /* renamed from: g, reason: collision with root package name */
    private MapWidget f241616g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f241617h;

    /* renamed from: i, reason: collision with root package name */
    private View.OnClickListener f241618i;

    /* renamed from: j, reason: collision with root package name */
    private com.tencent.mobileqq.location.ui.d f241619j;

    /* renamed from: k, reason: collision with root package name */
    private QUSHalfScreenFloatingView f241620k;

    /* renamed from: l, reason: collision with root package name */
    private LatLng f241621l;

    /* renamed from: m, reason: collision with root package name */
    private QBaseActivity f241622m;

    /* renamed from: n, reason: collision with root package name */
    private LocationRoom.b f241623n;

    /* renamed from: o, reason: collision with root package name */
    private DecodeTaskCompletionListener f241624o;

    /* renamed from: p, reason: collision with root package name */
    public final LocationPickViewModelV2 f241625p;

    /* renamed from: q, reason: collision with root package name */
    private final com.tencent.mobileqq.mvvm.d f241626q;

    /* renamed from: r, reason: collision with root package name */
    protected int f241627r;

    /* renamed from: s, reason: collision with root package name */
    private final AbsListView.OnScrollListener f241628s;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements AbsListView.OnScrollListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private int f241629d;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
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
            if (firstVisiblePosition > this.f241629d && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("LocationShareController", 4, "onScrollStateChanged");
                }
                g.this.f241619j.g();
            }
            this.f241629d = firstVisiblePosition;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                g.this.f241610a = false;
                if (g.this.f241619j.i() == -1) {
                    g.this.o();
                    g.this.f241620k.O(0);
                }
                g.this.f241619j.f(i3);
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
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
            g.this.f241616g.H(str, roundFaceBitmap);
            if (g.this.f241624o != null) {
                g.this.f241624o.onDecodeTaskCompleted(i3, i16, str, roundFaceBitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f241633d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ EditText f241634e;

        d(Activity activity, EditText editText) {
            this.f241633d = activity;
            this.f241634e = editText;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, g.this, activity, editText);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            EventCollector.getInstance().onViewClicked(view);
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
                g.this.f241617h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.location.ui.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        g.d.b(view2);
                    }
                });
                g.this.f241617h.setImageDrawable(this.f241633d.getResources().getDrawable(R.drawable.location_my_black));
                g.this.f241616g.p(true);
                g gVar = g.this;
                gVar.f241621l = gVar.f241616g.k();
                if (this.f241634e.getText().length() > 0) {
                    this.f241634e.setText("");
                } else {
                    g.this.x("");
                }
                ReportController.o(null, "CliOper", "", "", "0X800A771", "0X800A771", 0, 0, "", "0", "0", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class e implements MapWidget.j {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private long f241636a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f241637b;

        e(Activity activity) {
            this.f241637b = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this, (Object) activity);
            } else {
                this.f241636a = 0L;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void h(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // com.tencent.mobileqq.location.ui.MapWidget.j
        public void a(boolean z16, Point point) {
            Resources resources;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), point);
                return;
            }
            if (z16) {
                g.this.f241617h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.location.ui.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        g.e.h(view);
                    }
                });
                if (az.f()) {
                    g.this.f241617h.setImageDrawable(this.f241637b.getResources().getDrawable(R.drawable.location_my_black_dark));
                    return;
                } else {
                    g.this.f241617h.setImageDrawable(this.f241637b.getResources().getDrawable(R.drawable.location_my_black));
                    return;
                }
            }
            g.this.f241617h.setOnClickListener(g.this.f241618i);
            Drawable drawable = this.f241637b.getResources().getDrawable(R.drawable.location_my_blue);
            if (g.this.f241622m == null || (resources = g.this.f241622m.getResources()) == null) {
                return;
            }
            drawable.setColorFilter(resources.getColor(R.color.bdi), PorterDuff.Mode.SRC_ATOP);
            g.this.f241617h.setImageDrawable(drawable);
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
                        g.this.f241616g.H(str, ((IBaseImageUtilApi) QRoute.api(IBaseImageUtilApi.class)).getRoundFaceBitmap(d16, d16.getWidth(), d16.getHeight()));
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
            if (System.currentTimeMillis() - this.f241636a >= 1000 && g.this.f241627r != 2) {
                this.f241636a = System.currentTimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.d("LocationShareController", 2, "onMapStable onClick: invoked. center: " + latLng);
                }
                g.this.f241621l = latLng;
                g.this.f241619j.m(g.this.f241616g.getMap(), latLng, LocationHandler.K2().J2(g.this.f241623n).j().b(), "");
                ReportController.o(null, "CliOper", "", "", "0X800A95D", "0X800A95D", 0, 0, "", "0", "0", "");
            }
        }

        @Override // com.tencent.mobileqq.location.ui.MapWidget.j
        public void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            } else {
                g.this.f241620k.O(0);
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
    public g(LocationPickViewModelV2 locationPickViewModelV2, com.tencent.mobileqq.mvvm.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) locationPickViewModelV2, (Object) dVar);
            return;
        }
        this.f241610a = true;
        this.f241627r = 1;
        this.f241628s = new a();
        this.f241625p = locationPickViewModelV2;
        this.f241626q = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        InputMethodManager inputMethodManager = (InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null && inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(((EditText) this.f241614e.findViewById(R.id.et_search_keyword)).getWindowToken(), 0);
        }
    }

    private void q(Activity activity) {
        d dVar = new d(activity, (EditText) this.f241614e.findViewById(R.id.et_search_keyword));
        this.f241618i = dVar;
        this.f241617h.setOnClickListener(dVar);
        this.f241616g.setListener(new e(activity));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    this.f241627r = 2;
                    return;
                }
                return;
            }
            this.f241627r = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationRoom.Venue m() {
        return this.f241619j.h();
    }

    public void n(com.tencent.mobileqq.location.model.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
            return;
        }
        for (com.tencent.mobileqq.location.data.a aVar : bVar.f241303c) {
            Bitmap d16 = com.tencent.mobileqq.location.ui.b.c().d(aVar.d());
            if (d16 != null) {
                this.f241616g.H(aVar.d(), ((IBaseImageUtilApi) QRoute.api(IBaseImageUtilApi.class)).getRoundFaceBitmap(d16, d16.getWidth(), d16.getHeight()));
            }
        }
        this.f241616g.u(bVar.f241301a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(QBaseActivity qBaseActivity, LocationRoom.b bVar, CameraPosition cameraPosition, MapWidget mapWidget, ImageView imageView, View view, View view2, QUSHalfScreenFloatingView qUSHalfScreenFloatingView, XListView xListView, View view3, View view4) {
        int statusBarHeight;
        this.f241622m = qBaseActivity;
        this.f241611b = view3;
        this.f241612c = view;
        this.f241613d = view4;
        this.f241614e = view2;
        this.f241615f = xListView;
        this.f241620k = qUSHalfScreenFloatingView;
        this.f241616g = mapWidget;
        this.f241617h = imageView;
        this.f241623n = bVar;
        com.tencent.mobileqq.location.ui.d dVar = new com.tencent.mobileqq.location.ui.d(qBaseActivity);
        this.f241619j = dVar;
        this.f241625p.P1(this.f241622m, this.f241623n, dVar);
        this.f241625p.b2();
        xListView.setDividerHeight(0);
        xListView.setAdapter((ListAdapter) this.f241619j);
        xListView.setSelectionAfterHeaderView();
        xListView.setOnScrollListener(this.f241628s);
        xListView.setOnItemClickListener(new b());
        ((ILiuHaiUtilsApi) QRoute.api(ILiuHaiUtilsApi.class)).initLiuHaiProperty(qBaseActivity);
        if (((ILiuHaiUtilsApi) QRoute.api(ILiuHaiUtilsApi.class)).isHasNotch()) {
            statusBarHeight = x.c(qBaseActivity, 54.0f) + ((ILiuHaiUtilsApi) QRoute.api(ILiuHaiUtilsApi.class)).getNotchHeight();
        } else {
            statusBarHeight = ((IImmersiveUtilsApi) QRoute.api(IImmersiveUtilsApi.class)).getStatusBarHeight(qBaseActivity) + x.c(qBaseActivity, 54.0f);
        }
        this.f241616g.m(qBaseActivity, LocationHandler.K2().J2(this.f241623n), cameraPosition, statusBarHeight, this.f241620k);
        q(qBaseActivity);
        com.tencent.mobileqq.location.ui.b.c().f(new c());
        if (az.f()) {
            this.f241617h.setBackgroundResource(R.drawable.hca);
        }
        com.tencent.mobileqq.location.f.b(this.f241625p, this.f241626q, this);
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f241625p.Z1();
        this.f241611b.setVisibility(8);
        this.f241613d.setVisibility(0);
        this.f241615f.setVisibility(8);
        this.f241612c.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        this.f241625p.R1();
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.f241625p.Z1();
        this.f241611b.setVisibility(8);
        this.f241613d.setVisibility(8);
        this.f241615f.setVisibility(0);
        this.f241612c.setEnabled(true);
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.f241625p.X1();
        this.f241611b.setVisibility(0);
        this.f241613d.setVisibility(8);
        this.f241615f.setVisibility(8);
        this.f241612c.setEnabled(false);
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f241625p.X1();
            this.f241610a = false;
        }
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.f241625p.Z1();
        LocationRoom.Venue h16 = this.f241619j.h();
        if (h16 == null) {
            return;
        }
        this.f241616g.o(h16.f241273i, true);
        int i3 = this.f241619j.i();
        if (i3 >= 0) {
            this.f241615f.setSelection(i3);
        }
        if (this.f241610a) {
            this.f241620k.O(0);
        }
        this.f241611b.setVisibility(8);
        this.f241613d.setVisibility(8);
        this.f241615f.setVisibility(0);
        this.f241612c.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(String str) {
        this.f241610a = false;
        this.f241625p.a2(this.f241616g.getMap(), this.f241621l, str);
    }

    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        int i3 = this.f241619j.i();
        if (i3 != -1 && this.f241619j.h() != null) {
            if (i3 < this.f241615f.getFirstVisiblePosition() || i3 > this.f241615f.getFirstVisiblePosition() + 2) {
                this.f241615f.setSelection(i3);
            }
        }
    }
}

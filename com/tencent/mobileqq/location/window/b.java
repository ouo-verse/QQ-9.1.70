package com.tencent.mobileqq.location.window;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.h;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.ui.LocationDialogUtil;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqcommon.api.IBaseImageUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;
import javax.security.auth.Destroyable;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b implements Destroyable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private FloatMapWidget f241724a;

    /* renamed from: b, reason: collision with root package name */
    private INetInfoHandler f241725b;

    /* renamed from: c, reason: collision with root package name */
    private LocationRoom.b f241726c;

    /* renamed from: d, reason: collision with root package name */
    private DecodeTaskCompletionListener f241727d;

    /* renamed from: e, reason: collision with root package name */
    private MapWidget.j f241728e;

    /* renamed from: f, reason: collision with root package name */
    private final h f241729f;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.location.h
        public void a(LocationRoom.b bVar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("LocationShareController", 2, "onKickOff: invoked. roomKey: " + bVar + " mRoomKey: " + b.this.f241726c + " clientType: " + i3);
            }
            if (com.tencent.mobileqq.location.util.d.a(MobileQQ.sMobileQQ.getApplicationContext())) {
                i16 = 5;
            }
            if (i16 == i3) {
                return;
            }
            QQToast.makeText(BaseApplication.getContext(), "\u5df2\u5728\u5176\u4ed6\u8bbe\u5907\u8fdb\u884c\u5171\u4eab", 0).show();
        }

        @Override // com.tencent.mobileqq.location.h
        public void b(LocationRoom.b bVar, int i3) {
            QBaseActivity qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar, i3);
            } else if (bVar.equals(b.this.f241726c) && i3 != 2 && i3 != 1 && (qBaseActivity = QBaseActivity.sTopActivity) != null) {
                LocationDialogUtil.k(qBaseActivity);
            }
        }

        @Override // com.tencent.mobileqq.location.h
        public void c(LocationRoom.b bVar, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, bVar, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("LocationShareController", 2, "onOperateRoomResponse: invoked. ", " roomKey: ", bVar, " errorCode: ", Integer.valueOf(i3), " operateType: ", Integer.valueOf(i16));
            }
            if (!bVar.equals(b.this.f241726c)) {
                return;
            }
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (i3 == 10100) {
                if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                    LocationDialogUtil.k(qBaseActivity);
                    return;
                }
                return;
            }
            if (i3 == 10101 && qBaseActivity != null && !qBaseActivity.isFinishing()) {
                LocationDialogUtil.l(qBaseActivity);
            }
        }

        @Override // com.tencent.mobileqq.location.h
        public void d(LocationRoom.b bVar, LocationRoom.Venue venue, List<com.tencent.mobileqq.location.data.a> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, bVar, venue, list);
                return;
            }
            if (!bVar.equals(b.this.f241726c)) {
                if (QLog.isColorLevel()) {
                    QLog.d("LocationShareController", 2, "onUpdateUserLocations: invoked. ", " roomKey: ", bVar, " mRoomKey: ", b.this.f241726c);
                    return;
                }
                return;
            }
            for (com.tencent.mobileqq.location.data.a aVar : list) {
                Bitmap d16 = com.tencent.mobileqq.location.ui.b.c().d(aVar.d());
                if (d16 != null) {
                    b.this.f241724a.H(aVar.d(), ((IBaseImageUtilApi) QRoute.api(IBaseImageUtilApi.class)).getRoundFaceBitmap(d16, 16, 16));
                }
            }
            b.this.f241724a.u(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.location.window.b$b, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class C7983b implements DecodeTaskCompletionListener {
        static IPatchRedirector $redirector_;

        C7983b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
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
            Bitmap roundFaceBitmap = ((IBaseImageUtilApi) QRoute.api(IBaseImageUtilApi.class)).getRoundFaceBitmap(bitmap, 16, 16);
            com.tencent.mobileqq.location.model.a b16 = com.tencent.mobileqq.location.ui.b.c().b(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (b16 == null) {
                b16 = new com.tencent.mobileqq.location.model.a();
                com.tencent.mobileqq.location.ui.b.c().e(str, b16);
            }
            b16.f241298a = currentTimeMillis;
            b16.f241300c = roundFaceBitmap;
            b.this.f241724a.H(str, roundFaceBitmap);
            if (b.this.f241727d != null) {
                b.this.f241727d.onDecodeTaskCompleted(i3, i16, str, roundFaceBitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements INetInfoHandler {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                b.this.i();
            } else {
                iPatchRedirector.redirect((short) 6, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                b.this.i();
            } else {
                iPatchRedirector.redirect((short) 7, (Object) this);
            }
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.location.ui.MapWidget.j
        public void a(boolean z16, Point point) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), point);
            }
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
                        b.this.f241724a.H(str, ((IBaseImageUtilApi) QRoute.api(IBaseImageUtilApi.class)).getRoundFaceBitmap(d16, 16, 16));
                    }
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

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f241729f = new a();
        }
    }

    private void e() {
        d dVar = new d();
        this.f241728e = dVar;
        this.f241724a.setListener(dVar);
    }

    private void f() {
        this.f241725b = new c();
        AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.f241725b);
    }

    private void h() {
        this.f241724a.setOnMapLoadedCallback();
        e();
        com.tencent.mobileqq.location.ui.b.c().f(new C7983b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (QLog.isColorLevel()) {
            QLog.d("LocationShareController", 2, "onBadNetSituation: invoked. ", " TAG: ", "LocationShareController");
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            IFloatMapService iFloatMapService = (IFloatMapService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFloatMapService.class, "");
            LocationRoom.b bVar = this.f241726c;
            if (bVar != null && bVar.equals(iFloatMapService.currentFloatWindowVisibleRoomKey())) {
                FloatMapDialogUtil.b(qBaseActivity);
                iFloatMapService.setBadNetOnFloatWindowDialogShown(true);
            }
        }
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        try {
            AppNetConnInfo.unregisterNetInfoHandler(this.f241725b);
            this.f241725b = null;
        } catch (Exception e16) {
            QLog.e("LocationShareController", 1, "onFragmentDestroy: failed. ", e16);
        }
        com.tencent.mobileqq.location.ui.b.c().a();
        this.f241728e = null;
        LocationHandler.K2().Q2(this.f241729f);
        this.f241724a = null;
    }

    public void g(LocationRoom.b bVar, CameraPosition cameraPosition, FloatMapWidget floatMapWidget) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, bVar, cameraPosition, floatMapWidget);
            return;
        }
        this.f241724a = floatMapWidget;
        this.f241726c = bVar;
        floatMapWidget.m(null, LocationHandler.K2().J2(this.f241726c), cameraPosition, x.c(BaseApplication.getContext(), 10.0f), null);
        this.f241724a.setMapLogoVisibility(8);
        h();
        f();
        LocationHandler.K2().G2(this.f241729f);
    }
}

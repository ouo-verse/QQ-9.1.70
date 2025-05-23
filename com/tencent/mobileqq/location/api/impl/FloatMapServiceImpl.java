package com.tencent.mobileqq.location.api.impl;

import android.app.Dialog;
import android.support.annotation.UiThread;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.location.callback.d;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.i;
import com.tencent.mobileqq.location.j;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.ui.LocationDialogUtil;
import com.tencent.mobileqq.location.window.FloatMapWidget;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class FloatMapServiceImpl implements IFloatMapService {
    static IPatchRedirector $redirector_ = null;
    public static final int QUIT_FROM_TYPE_BAD_NET = 3;
    public static final int QUIT_FROM_TYPE_DESTROY_MANAGER = 2;
    public static final int QUIT_FROM_TYPE_ENTER_SHARE_FRAGMENT = 1;
    public static final int QUIT_FROM_TYPE_IGNORED = -1;
    private static final String TAG = "FloatMapServiceImpl";
    AppRuntime app;
    public boolean badNetOnFloatWindowDialogShown;
    private com.tencent.mobileqq.location.window.event.a eventProvider;
    private List<d> floatMapCallbacks;
    private FloatMapWidget floatMapWidget;
    com.tencent.mobileqq.location.window.b floatWindowController;
    private j themeChangedReceiver;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LocationRoom.b f241208d;

        a(LocationRoom.b bVar) {
            this.f241208d = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FloatMapServiceImpl.this, (Object) bVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                int b16 = this.f241208d.b();
                String c16 = this.f241208d.c();
                ILocationShareService iLocationShareService = (ILocationShareService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(ILocationShareService.class, "");
                iLocationShareService.requestOperateRoom(3, b16, c16);
                iLocationShareService.stopLocationSharing(b16, c16, false);
                ReportController.o(null, "CliOper", "", "", "0X800A979", "0X800A979", 0, 0, "", "0", "0", "");
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FloatMapServiceImpl.this);
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

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.location.window.a f241211d;

        c(com.tencent.mobileqq.location.window.a aVar) {
            this.f241211d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FloatMapServiceImpl.this, (Object) aVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                this.f241211d.a();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public FloatMapServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.badNetOnFloatWindowDialogShown = false;
        }
    }

    private void createMapWidget(LocationRoom.b bVar) {
        LatLng latLng;
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).initLocationManager();
        TencentLocation lastKnownLocation = TencentLocationManager.getInstance(BaseApplication.getContext()).getLastKnownLocation();
        if (lastKnownLocation != null) {
            latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
        } else {
            latLng = null;
        }
        CameraPosition fromLatLngZoom = CameraPosition.fromLatLngZoom(latLng, 15.0f);
        FloatMapWidget floatMapWidget = (FloatMapWidget) LayoutInflater.from(BaseApplication.getContext()).inflate(R.layout.f168235qb, (ViewGroup) null).findViewById(R.id.lrc);
        this.floatMapWidget = floatMapWidget;
        this.floatWindowController.g(bVar, fromLatLngZoom, floatMapWidget);
    }

    private void initMapWidgetSettings() {
        UiSettings uiSettings = this.floatMapWidget.getMap().getUiSettings();
        uiSettings.setScaleViewEnabled(false);
        uiSettings.setLogoScale(0.2f);
        this.floatMapWidget.onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void quitFloatDirectly(int i3) {
        try {
            Iterator<d> it = getFloatMapCallbacks().iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.eventProvider.b();
            FloatMapWidget floatMapWidget = this.floatMapWidget;
            if (floatMapWidget != null) {
                floatMapWidget.onPause();
                this.floatMapWidget.onStop();
                if (this.floatMapWidget.getMap() != null && !this.floatMapWidget.getMap().isDestroyed()) {
                    this.floatMapWidget.onDestroy();
                }
                this.floatMapWidget = null;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "quitFloat: failed. ", e16);
        }
        this.floatWindowController.destroy();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "quitFloat: invoked. ", " fromType: ", Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.location.api.IFloatMapService
    public synchronized void addFloatMapCallback(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) dVar);
        } else {
            this.floatMapCallbacks.add(dVar);
        }
    }

    @Override // com.tencent.mobileqq.location.api.IFloatMapService
    public Dialog createFloatExitConfirmDialog(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Dialog) iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) str);
        }
        return LocationDialogUtil.h(i3, str);
    }

    @Override // com.tencent.mobileqq.location.api.IFloatMapService
    public LocationRoom.b currentFloatWindowVisibleRoomKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LocationRoom.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.eventProvider.a();
    }

    @Override // com.tencent.mobileqq.location.api.IFloatMapService
    public boolean enterFloat(QBaseActivity qBaseActivity, LocationRoom.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) qBaseActivity, (Object) bVar)).booleanValue();
        }
        if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(BaseApplication.getContext(), R.string.f171139ci4, 0).show();
            return false;
        }
        createMapWidget(bVar);
        initMapWidgetSettings();
        Iterator<d> it = getFloatMapCallbacks().iterator();
        while (it.hasNext()) {
            if (!it.next().b(qBaseActivity, bVar)) {
                return false;
            }
        }
        this.eventProvider.c(bVar);
        LocationHandler.K2().R2(bVar.b(), bVar.c());
        int a16 = com.tencent.mobileqq.location.util.c.a(bVar);
        if (a16 != 0) {
            ReportController.o(null, "CliOper", "", "", "0X800A974", "0X800A974", a16, 0, "0", "0", "0", "");
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.location.api.IFloatMapService
    public boolean getBadNetOnFloatWindowDialogShown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.badNetOnFloatWindowDialogShown;
    }

    @Override // com.tencent.mobileqq.location.api.IFloatMapService
    public List<d> getFloatMapCallbacks() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.floatMapCallbacks;
    }

    @Override // com.tencent.mobileqq.location.api.IFloatMapService
    public View getFloatMapView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.floatMapWidget;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.app = appRuntime;
        this.floatMapCallbacks = new ArrayList();
        this.eventProvider = new com.tencent.mobileqq.location.window.event.a();
        this.themeChangedReceiver = new j();
        this.floatWindowController = new com.tencent.mobileqq.location.window.b();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        this.themeChangedReceiver.b();
        this.floatWindowController.destroy();
        quitFloat(2);
        Iterator<d> it = this.floatMapCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        synchronized (FloatMapServiceImpl.class) {
            this.floatMapCallbacks.clear();
        }
        this.app = null;
    }

    @Override // com.tencent.mobileqq.location.api.IFloatMapService
    @UiThread
    public void quitFloat(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(i3) { // from class: com.tencent.mobileqq.location.api.impl.FloatMapServiceImpl.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f241207d;

                {
                    this.f241207d = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FloatMapServiceImpl.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        FloatMapServiceImpl.this.quitFloatDirectly(this.f241207d);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.location.api.IFloatMapService
    public synchronized void removeFloatMapCallback(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) dVar);
        } else {
            this.floatMapCallbacks.remove(dVar);
        }
    }

    @Override // com.tencent.mobileqq.location.api.IFloatMapService
    public void setBadNetOnFloatWindowDialogShown(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.badNetOnFloatWindowDialogShown = z16;
        }
    }

    @Override // com.tencent.mobileqq.location.api.IFloatMapService
    public void setThemeChangedListener(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) iVar);
        } else {
            this.themeChangedReceiver.c(iVar);
        }
    }

    @Override // com.tencent.mobileqq.location.api.IFloatMapService
    public void showFloatTypeDialog(LocationRoom.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bVar);
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        com.tencent.mobileqq.location.window.a aVar = new com.tencent.mobileqq.location.window.a();
        aVar.e(context.getString(R.string.vy6));
        aVar.g(context.getString(R.string.close));
        aVar.i(context.getString(R.string.c9l));
        aVar.f(new a(bVar));
        aVar.h(new b());
        aVar.d(new c(aVar));
        aVar.j();
    }
}

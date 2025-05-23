package com.tencent.biz.map;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.widgets.d;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqfav.QfavBuilder;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DetailMapFragment extends QPublicBaseFragment implements d.a {
    protected View E;
    protected QQMapView F;
    protected View G;
    protected ImageView H;
    protected ImageView I;
    protected TencentMap J;
    public String L;
    public String M;
    public String N;
    public String P;
    public String Q;
    private Marker V;
    private Marker W;
    protected View X;
    protected View Y;
    protected RelativeLayout Z;

    /* renamed from: a0, reason: collision with root package name */
    protected RelativeLayout f78653a0;

    /* renamed from: b0, reason: collision with root package name */
    protected TextView f78654b0;

    /* renamed from: c0, reason: collision with root package name */
    protected TextView f78655c0;

    /* renamed from: d0, reason: collision with root package name */
    protected LinearLayout f78656d0;

    /* renamed from: e0, reason: collision with root package name */
    protected View f78657e0;

    /* renamed from: f0, reason: collision with root package name */
    protected com.tencent.biz.widgets.d f78658f0;

    /* renamed from: h0, reason: collision with root package name */
    private float f78660h0;

    /* renamed from: i0, reason: collision with root package name */
    private float f78661i0;

    /* renamed from: j0, reason: collision with root package name */
    protected ActionSheet f78662j0;
    protected boolean C = false;
    protected LatLng D = null;
    protected String K = "";
    protected String R = "";
    protected LatLng S = null;
    protected boolean T = false;
    boolean U = false;

    /* renamed from: g0, reason: collision with root package name */
    private float f78659g0 = -1.0f;

    /* renamed from: k0, reason: collision with root package name */
    private LbsManagerServiceOnLocationChangeListener f78663k0 = new LbsManagerServiceOnLocationChangeListener(QQMapActivity.TAG, true) { // from class: com.tencent.biz.map.DetailMapFragment.1
        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            String str;
            SosoLocation sosoLocation;
            if (!DetailMapFragment.this.isAdded()) {
                return;
            }
            if (sosoLbsInfo == null || (sosoLocation = sosoLbsInfo.mLocation) == null || (str = sosoLocation.address) == null) {
                str = "";
            }
            if (QLog.isColorLevel()) {
                QLog.d("PoiMapFragment", 2, "onLocationFinish errCode=" + i3);
            }
            if (i3 == 0 && sosoLbsInfo != null && sosoLbsInfo.mLocation != null) {
                SosoLocation sosoLocation2 = sosoLbsInfo.mLocation;
                DetailMapFragment.this.sh(new GeoPoint((int) (sosoLocation2.mLat02 * 1000000.0d), (int) (sosoLocation2.mLon02 * 1000000.0d)), str);
                DetailMapFragment detailMapFragment = DetailMapFragment.this;
                detailMapFragment.R = str;
                detailMapFragment.S = new LatLng(r8.getLatitudeE6() / 1000000.0d, r8.getLongitudeE6() / 1000000.0d);
                DetailMapFragment.this.Jh();
                return;
            }
            new Handler().post(new Runnable() { // from class: com.tencent.biz.map.DetailMapFragment.1.1
                @Override // java.lang.Runnable
                public void run() {
                    ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).removeListener(DetailMapFragment.this.f78663k0);
                }
            });
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DetailMapFragment.this.Kh("em_location_navigation_back", "dt_clck");
            if (DetailMapFragment.this.isAdded() && DetailMapFragment.this.getQBaseActivity() != null && !DetailMapFragment.this.getQBaseActivity().isFinishing()) {
                DetailMapFragment.this.getQBaseActivity().finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a implements ActionSheet.OnButtonClickListener {
            a() {
            }

            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i3) {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ClipboardMonitor.setPrimaryClip((ClipboardManager) DetailMapFragment.this.getQBaseActivity().getSystemService("clipboard"), ClipData.newPlainText("Label", DetailMapFragment.this.L + "(" + DetailMapFragment.this.M + ")"));
                            QQToast.makeText(DetailMapFragment.this.getQBaseActivity(), 2, DetailMapFragment.this.getQBaseActivity().getString(R.string.zos), 1).show(DetailMapFragment.this.getQBaseActivity().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                        }
                    } else {
                        DetailMapFragment detailMapFragment = DetailMapFragment.this;
                        LatLng latLng = detailMapFragment.D;
                        if (QfavBuilder.b0((float) latLng.latitude, (float) latLng.longitude, detailMapFragment.L, detailMapFragment.M, null).B(Long.valueOf(DetailMapFragment.this.N).longValue(), DetailMapFragment.this.P).e(DetailMapFragment.this.getQBaseActivity(), DetailMapFragment.this.Q, 1, null)) {
                            QQToast.makeText(DetailMapFragment.this.getQBaseActivity(), 2, DetailMapFragment.this.getQBaseActivity().getString(R.string.b3n), 1).show(DetailMapFragment.this.getQBaseActivity().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                            com.tencent.biz.widgets.d.d("favorite_success");
                        }
                        cooperation.qqfav.d.e(null, 65, 7);
                        ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "rec_locate", "click_collect", 0, 0, "", "", "", "");
                    }
                } else {
                    DetailMapFragment.this.wh();
                }
                DetailMapFragment.this.f78662j0.dismiss();
            }
        }

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DetailMapFragment detailMapFragment = DetailMapFragment.this;
            if (detailMapFragment.f78662j0 == null) {
                detailMapFragment.f78662j0 = (ActionSheet) ActionSheetHelper.createDialog(detailMapFragment.getQBaseActivity(), null);
                DetailMapFragment.this.f78662j0.addButton(R.string.f16307225);
                DetailMapFragment.this.f78662j0.addButton(R.string.b3m);
                DetailMapFragment.this.f78662j0.addButton(R.string.f186543rk);
                DetailMapFragment.this.f78662j0.addCancelButton(R.string.cancel);
                DetailMapFragment.this.f78662j0.setOnButtonClickListener(new a());
            }
            if (!DetailMapFragment.this.f78662j0.isShowing()) {
                DetailMapFragment.this.f78662j0.show();
            }
            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "rec_locate", "click_menu", 0, 0, "", "", "", "");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DetailMapFragment detailMapFragment = DetailMapFragment.this;
            if (detailMapFragment.S != null) {
                detailMapFragment.Kh("em_location_navigation_icon", "dt_clck");
                LatLng latLng = DetailMapFragment.this.D;
                GeoPoint geoPoint = new GeoPoint((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
                LatLng latLng2 = DetailMapFragment.this.S;
                GeoPoint geoPoint2 = new GeoPoint((int) (latLng2.latitude * 1000000.0d), (int) (latLng2.longitude * 1000000.0d));
                if (DetailMapFragment.this.uh("android.permission.ACCESS_FINE_LOCATION") != 0) {
                    DetailMapFragment.this.requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
                } else {
                    DetailMapFragment detailMapFragment2 = DetailMapFragment.this;
                    com.tencent.biz.widgets.d dVar = detailMapFragment2.f78658f0;
                    QBaseActivity qBaseActivity = detailMapFragment2.getQBaseActivity();
                    DetailMapFragment detailMapFragment3 = DetailMapFragment.this;
                    dVar.m(qBaseActivity, geoPoint2, geoPoint, detailMapFragment3.R, detailMapFragment3.L);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DetailMapFragment detailMapFragment;
            LatLng latLng;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!TextUtils.isEmpty(DetailMapFragment.this.L) && (latLng = (detailMapFragment = DetailMapFragment.this).D) != null) {
                String e16 = MapUtils.e(detailMapFragment.L, latLng);
                if (TextUtils.isEmpty(e16)) {
                    QLog.i("PoiMapFragment", 1, "targetPoiPath is empty");
                }
                DetailMapFragment.this.Kh("em_location_car_icon", "dt_clck");
                String str = "/modules/aggretakecar/pages/tripdetail/tripdetail?from=locationnew&source=qq&target=" + e16;
                QLog.i("PoiMapFragment", 1, "targetPath: " + str);
                ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(DetailMapFragment.this.getQBaseActivity(), "wx65cc950f42e8fff1", str, 2121);
            } else {
                QLog.i("PoiMapFragment", 1, "null == userPoint || TextUtils.isEmpty(mCurPoiName) || mTargetPos == null");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class e implements TencentMap.OnMarkerClickListener {
        e() {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener
        public boolean onMarkerClick(Marker marker) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class f implements TencentMap.OnCameraChangeListener {
        f() {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
        public void onCameraChange(CameraPosition cameraPosition) {
            DetailMapFragment detailMapFragment = DetailMapFragment.this;
            if (detailMapFragment.U && MapUtils.c(detailMapFragment.S, cameraPosition.target) > 2.0d) {
                DetailMapFragment detailMapFragment2 = DetailMapFragment.this;
                detailMapFragment2.U = false;
                detailMapFragment2.I.setImageResource(R.drawable.ksf);
            }
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
        public void onCameraChangeFinished(CameraPosition cameraPosition) {
            DetailMapFragment detailMapFragment = DetailMapFragment.this;
            if (!detailMapFragment.U && MapUtils.c(detailMapFragment.S, cameraPosition.target) <= 2.0d) {
                DetailMapFragment detailMapFragment2 = DetailMapFragment.this;
                detailMapFragment2.U = true;
                detailMapFragment2.I.setImageResource(R.drawable.ksg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DetailMapFragment detailMapFragment = DetailMapFragment.this;
            LatLng latLng = detailMapFragment.S;
            if (latLng != null) {
                detailMapFragment.J.animateCamera(CameraUpdateFactory.newLatLng(latLng));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class h extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQPermission f78674a;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a implements DialogInterface.OnDismissListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                DetailMapFragment detailMapFragment = DetailMapFragment.this;
                detailMapFragment.yh(detailMapFragment.T);
            }
        }

        h(QQPermission qQPermission) {
            this.f78674a = qQPermission;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            DetailMapFragment detailMapFragment = DetailMapFragment.this;
            detailMapFragment.yh(detailMapFragment.T);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            if (this.f78674a.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                DetailMapFragment detailMapFragment = DetailMapFragment.this;
                detailMapFragment.yh(detailMapFragment.T);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(List<String> list, List<Integer> list2) {
            super.onDeniedWithoutShowDlg(list, list2);
            if (this.f78674a.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                DetailMapFragment detailMapFragment = DetailMapFragment.this;
                detailMapFragment.yh(detailMapFragment.T);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            super.onDialogShow(permissionRequestDialog, list);
            if (this.f78674a.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                permissionRequestDialog.setOnDismissListener(new a());
            }
        }
    }

    private void Ah() {
        View findViewById = this.E.findViewById(R.id.ifk);
        this.f78657e0 = findViewById;
        int i3 = 0;
        findViewById.setVisibility(0);
        this.Z = (RelativeLayout) this.f78657e0.findViewById(R.id.f7850479);
        this.f78653a0 = (RelativeLayout) this.f78657e0.findViewById(R.id.tlw);
        this.f78654b0 = (TextView) this.f78657e0.findViewById(R.id.f164041i8);
        this.f78655c0 = (TextView) this.f78657e0.findViewById(R.id.f164970bh2);
        this.f78656d0 = (LinearLayout) this.f78657e0.findViewById(R.id.jtl);
        this.Z.setOnClickListener(new c());
        RelativeLayout relativeLayout = this.f78653a0;
        if (!MapUtils.f()) {
            i3 = 8;
        }
        relativeLayout.setVisibility(i3);
        this.f78653a0.setOnClickListener(new d());
        if (Ih()) {
            AccessibilityUtil.c(this.Z, getString(R.string.zqy), Button.class.getName());
            AccessibilityUtil.c(this.f78653a0, getString(R.string.zqv), Button.class.getName());
        }
    }

    private void Ch() {
        ImageView imageView = (ImageView) this.E.findViewById(R.id.f83584jy);
        this.I = imageView;
        imageView.setOnClickListener(new g());
        if (Ih()) {
            AccessibilityUtil.c(this.I, getString(R.string.zqw), Button.class.getName());
        }
    }

    private void Dh() {
        this.F = (QQMapView) this.E.findViewById(R.id.emb);
        this.G = this.E.findViewById(R.id.f166180yx0);
        ImageView imageView = (ImageView) this.E.findViewById(R.id.cbq);
        this.H = imageView;
        this.F.removeView(imageView);
        Hh();
        Ch();
    }

    private void Hh() {
        TencentMap map = this.F.getMap();
        this.J = map;
        map.moveCamera(CameraUpdateFactory.zoomTo(15.0f));
        this.J.getUiSettings().setGestureScaleByMapCenter(true);
        this.J.getUiSettings().setRotateGesturesEnabled(false);
        this.J.setOnMarkerClickListener(new e());
        this.J.setOnCameraChangeListener(new f());
    }

    private boolean Ih() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100264", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kh(String str, String str2) {
        com.tencent.biz.map.c cVar = new com.tencent.biz.map.c(getQBaseActivity());
        cVar.b("pg_location_navigation", null);
        cVar.a(Arrays.asList("em_location_navigation_icon", "em_location_navigation_back", "em_location_navigation_more", "em_location_car_icon"));
        if ("dt_imp".equals(str2)) {
            cVar.d(str, null);
        } else if ("dt_imp_end".equals(str2)) {
            cVar.e(str, null);
        } else if ("dt_clck".equals(str2)) {
            cVar.c(str, null);
        }
    }

    private void Lh() {
        Nh("dt_pgin");
        Kh("em_location_navigation_icon", "dt_imp");
        Kh("em_location_navigation_back", "dt_imp");
        Kh("em_location_car_icon", "dt_imp");
    }

    private void Mh() {
        Nh("dt_pgout");
        Kh("em_location_navigation_icon", "dt_imp_end");
        Kh("em_location_navigation_back", "dt_imp_end");
        Kh("em_location_car_icon", "dt_imp_end");
    }

    private void Nh(String str) {
        com.tencent.biz.map.c cVar = new com.tencent.biz.map.c(getQBaseActivity());
        cVar.b("pg_location_navigation", null);
        cVar.a(Arrays.asList("em_location_navigation_icon", "em_location_navigation_back", "em_location_navigation_more", "em_location_car_icon"));
        if ("dt_pgin".equals(str)) {
            cVar.f();
        } else if ("dt_pgout".equals(str)) {
            cVar.h(null);
        }
    }

    private void rh() {
        if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
            this.J.setMapType(1008);
            com.tencent.mobileqq.qwallet.utils.d.b(getQBaseActivity(), false);
        } else {
            com.tencent.mobileqq.qwallet.utils.d.b(getQBaseActivity(), true);
        }
    }

    private void setStatusBarImmersive() {
        if (getQBaseActivity() != null && ImmersiveUtils.isSupporImmersive() == 1) {
            if (SystemBarActivityModule.getSystemBarComp(getQBaseActivity()) == null) {
                SystemBarActivityModule.setImmersiveStatus(getQBaseActivity(), 0);
                return;
            }
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarDrawable(null);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarColor(0);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusColor(0);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarDarkMode(true);
        }
    }

    private void vh() {
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(this.f78663k0);
    }

    @SuppressLint({"ResourceAsColor"})
    protected void Bh() {
        zh();
        Eh();
    }

    protected void Eh() {
        View findViewById = this.E.findViewById(R.id.f26150cr);
        findViewById.getBackground().mutate().setAlpha(102);
        findViewById.setContentDescription(getString(R.string.cat));
        if (Ih()) {
            AccessibilityUtil.c(this.E.findViewById(R.id.zee), getString(R.string.zqx), Button.class.getName());
        }
        this.E.findViewById(R.id.zee).setOnClickListener(xh());
    }

    protected void Fh() {
        com.tencent.biz.widgets.d dVar = new com.tencent.biz.widgets.d(getContext());
        this.f78658f0 = dVar;
        dVar.l(this);
    }

    protected void Gh() {
        LatLng latLng = this.D;
        if (latLng != null) {
            this.J.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        }
        String str = this.L;
        if (str != null && this.M != null) {
            this.f78654b0.setText(str);
            this.f78655c0.setText(this.M);
        }
    }

    protected void Jh() {
        LatLng latLng;
        LatLng latLng2;
        if (this.M != null && (latLng = this.S) != null && (latLng2 = this.D) != null) {
            int distanceBetween = (int) TencentLocationUtils.distanceBetween(latLng.latitude, latLng.longitude, latLng2.latitude, latLng2.longitude);
            if (distanceBetween < 100) {
                this.f78655c0.setText("100m\u5185\uff5c" + this.M);
                return;
            }
            if (distanceBetween < 1000) {
                this.f78655c0.setText(distanceBetween + "m\uff5c" + this.M);
                return;
            }
            this.f78655c0.setText(String.format("%.1f", Double.valueOf(distanceBetween / 1000.0d)) + "km\uff5c" + this.M);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        boolean z18;
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && this.f78659g0 != -1.0f) {
                    return true;
                }
            } else if (this.f78659g0 != -1.0f) {
                QBaseActivity qBaseActivity = getQBaseActivity();
                if (this.f78659g0 != -1.0f && x16 - r4 > this.E.getWidth() * 0.1d) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (isAdded() && qBaseActivity != null && !qBaseActivity.isFinishing()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z17 && z18) {
                    qBaseActivity.finish();
                    return true;
                }
                this.f78659g0 = -1.0f;
            }
        } else {
            float f16 = y16;
            if (f16 > this.f78660h0 && f16 < this.f78661i0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.E.getWidth() * 0.05d > x16 && !z16) {
                this.f78659g0 = x16;
                return true;
            }
        }
        return false;
    }

    protected void initData() {
        this.C = true;
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            this.D = new LatLng(Double.valueOf(extras.getString(QCircleSchemeAttr.Polymerize.LAT).toString()).doubleValue(), Double.valueOf(extras.getString("lon").toString()).doubleValue());
            if (extras.getString("strName") != null && extras.getString("address") != null) {
                this.L = extras.getString("strName");
                this.M = extras.getString("address");
            }
            this.N = extras.getString("sendUin");
            this.P = extras.getString("receiveUin");
            this.Q = extras.getString("receiveUinType");
            return;
        }
        this.D = new LatLng(35.69405665d, 139.74929875d);
        this.L = "";
        this.M = "";
        this.N = "";
        this.P = "";
        this.Q = "";
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean needDispatchTouchEvent() {
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStatusBarImmersive();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.hbz, (ViewGroup) null);
        this.E = inflate;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Mh();
        TencentMap tencentMap = this.J;
        if (tencentMap != null) {
            tencentMap.setOnCameraChangeListener(null);
        }
        QQMapView qQMapView = this.F;
        if (qQMapView != null) {
            qQMapView.onDestroy();
        }
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).removeListener(this.f78663k0);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        QQMapView qQMapView = this.F;
        if (qQMapView != null) {
            qQMapView.onPause();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QQMapView qQMapView = this.F;
        if (qQMapView != null) {
            qQMapView.onResume();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        QQMapView qQMapView = this.F;
        if (qQMapView != null) {
            qQMapView.onStart();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        QQMapView qQMapView = this.F;
        if (qQMapView != null) {
            qQMapView.onStop();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initData();
        Bh();
        Ah();
        Dh();
        Fh();
        yh(true);
        rh();
        Gh();
        Lh();
    }

    protected void sh(GeoPoint geoPoint, String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.f160347b93, options);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        TencentMap tencentMap = this.J;
        if (tencentMap != null && tencentMap.getProjection() != null) {
            LatLng latLng = new LatLng(geoPoint.getLatitudeE6() / 1000000.0d, geoPoint.getLongitudeE6() / 1000000.0d);
            if (this.X == null) {
                try {
                    View inflate = getLayoutInflater().inflate(R.layout.f168249q2, (ViewGroup) null);
                    this.X = inflate;
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.cbq);
                    imageView.setImageResource(R.drawable.f160347b93);
                    imageView.setBackgroundDrawable(null);
                    Marker addMarker = this.J.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(this.X)).position(latLng).snippet(""));
                    this.V = addMarker;
                    addMarker.showInfoWindow();
                } catch (Resources.NotFoundException e17) {
                    e17.printStackTrace();
                }
                LatLng latLng2 = this.D;
                if (latLng2 != null) {
                    this.J.moveCamera(CameraUpdateFactory.newLatLng(latLng2));
                    LatLng latLng3 = this.D;
                    th(new GeoPoint((int) (latLng3.latitude * 1000000.0d), (int) (latLng3.longitude * 1000000.0d)), null);
                    return;
                }
                return;
            }
            if (this.V != null) {
                if (latLng.getLatitude() != this.V.getPosition().getLatitude() || latLng.getLongitude() != this.V.getPosition().getLongitude()) {
                    this.V.setPosition(latLng);
                    this.V.setSnippet("");
                    this.V.showInfoWindow();
                }
            }
        }
    }

    protected void th(GeoPoint geoPoint, String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.nf9, options);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("PoiMapFragment", 2, "addTargetPosition errCode=" + e16);
            }
        }
        TencentMap tencentMap = this.J;
        if (tencentMap != null && tencentMap.getProjection() != null) {
            LatLng latLng = new LatLng(geoPoint.getLatitudeE6() / 1000000.0d, geoPoint.getLongitudeE6() / 1000000.0d);
            if (this.Y == null) {
                try {
                    View inflate = getLayoutInflater().inflate(R.layout.fgr, (ViewGroup) null);
                    this.Y = inflate;
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.cbq);
                    imageView.setImageResource(R.drawable.nf9);
                    imageView.setBackgroundDrawable(null);
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.width = ViewUtils.dip2px(25.0f);
                    layoutParams.height = ViewUtils.dip2px(80.0f);
                    imageView.setLayoutParams(layoutParams);
                    Marker addMarker = this.J.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(this.Y)).position(latLng).snippet(""));
                    this.W = addMarker;
                    addMarker.showInfoWindow();
                    return;
                } catch (Resources.NotFoundException e17) {
                    e17.printStackTrace();
                    return;
                }
            }
            if (this.W != null) {
                if (latLng.getLatitude() != this.W.getPosition().getLatitude() || latLng.getLongitude() != this.W.getPosition().getLongitude()) {
                    this.W.setPosition(latLng);
                    this.W.setSnippet("");
                    this.W.showInfoWindow();
                }
            }
        }
    }

    public int uh(String str) {
        return getActivity().checkSelfPermission(str);
    }

    protected void wh() {
        getQBaseActivity().startActivity(new com.tencent.biz.map.b(this.L, this.M, this.D).b(getQBaseActivity()));
    }

    protected View.OnClickListener xh() {
        return new b();
    }

    protected void yh(boolean z16) {
        this.T = z16;
        if (!NetworkUtil.isNetSupport(getContext())) {
            QQToast.makeText(getContext(), 1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8fde\u63a5\uff01", 0);
            return;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_MAP, QQPermissionConstants.Business.SCENE.MAP_SHOW_ENTRY));
        if (vx.a.a(qQPermission)) {
            qQPermission.requestPermissions(vx.a.f443628a, 2, new h(qQPermission));
        } else {
            vh();
        }
    }

    protected void zh() {
        Resources resources = getContext().getResources();
        this.f78660h0 = resources.getDimensionPixelSize(R.dimen.f158428c42);
        this.f78661i0 = resources.getDimensionPixelSize(R.dimen.f158427c41);
        this.E.findViewById(R.id.cau).getBackground().mutate().setAlpha(102);
        View findViewById = this.E.findViewById(R.id.t2l);
        if (Ih()) {
            AccessibilityUtil.c(findViewById, getString(R.string.zqu), Button.class.getName());
        }
        findViewById.setOnClickListener(new a());
    }
}

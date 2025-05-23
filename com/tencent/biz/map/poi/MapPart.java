package com.tencent.biz.map.poi;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.app.HardCodeUtil;
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
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* loaded from: classes2.dex */
public class MapPart extends com.tencent.biz.map.poi.a {
    private boolean C = false;
    private LbsManagerServiceOnLocationChangeListener D = new LbsManagerServiceOnLocationChangeListener(QQMapActivity.TAG, true) { // from class: com.tencent.biz.map.poi.MapPart.1
        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            SosoLocation sosoLocation;
            String str;
            if (QLog.isColorLevel()) {
                QLog.d(MapPart.this.getTAG(), 2, "onLocationFinish errCode=" + i3);
            }
            if (i3 == 0 && sosoLbsInfo != null && (sosoLocation = sosoLbsInfo.mLocation) != null) {
                if (sosoLocation == null || (str = sosoLocation.address) == null) {
                    str = "";
                }
                SosoLocation sosoLocation2 = sosoLbsInfo.mLocation;
                GeoPoint geoPoint = new GeoPoint((int) (sosoLocation2.mLat02 * 1000000.0d), (int) (sosoLocation2.mLon02 * 1000000.0d));
                MapPart.this.f78693e.X1().setValue(new LatLng(geoPoint.getLatitudeE6() / 1000000.0d, geoPoint.getLongitudeE6() / 1000000.0d));
                if (MapPart.this.f78693e.T1().getValue().booleanValue()) {
                    MapPart.this.f78693e.c2(false);
                    MapPart.this.f78693e.Z1(new LatLng(geoPoint.getLatitudeE6() / 1000000.0d, geoPoint.getLongitudeE6() / 1000000.0d));
                    MapPart.this.f78693e.f78748m = str;
                }
                if (!MapPart.this.f78693e.b2()) {
                    MapPart.this.G9();
                }
            } else {
                new Handler().post(new Runnable() { // from class: com.tencent.biz.map.poi.MapPart.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).removeListener(MapPart.this.D);
                    }
                });
            }
            try {
                if (MapPart.this.C) {
                    MapPart.this.getActivity().dismissDialog(0);
                    MapPart.this.C = false;
                }
            } catch (Throwable th5) {
                QLog.e(MapPart.this.getTAG(), 1, th5, new Object[0]);
            }
        }
    };

    /* renamed from: d, reason: collision with root package name */
    protected View f78692d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.biz.map.poi.b f78693e;

    /* renamed from: f, reason: collision with root package name */
    private QQMapView f78694f;

    /* renamed from: h, reason: collision with root package name */
    private View f78695h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f78696i;

    /* renamed from: m, reason: collision with root package name */
    private View f78697m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<Integer> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            MapPart.this.P9(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<Integer> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            if (num == null) {
                return;
            }
            int intValue = num.intValue();
            com.tencent.biz.map.poi.b unused = MapPart.this.f78693e;
            if (intValue == 0) {
                MapPart.this.f78696i.setImageResource(R.drawable.ksg);
                return;
            }
            int intValue2 = num.intValue();
            com.tencent.biz.map.poi.b unused2 = MapPart.this.f78693e;
            if (intValue2 == 1) {
                MapPart.this.f78696i.setImageResource(R.drawable.ksf);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQPermission f78702a;

        /* loaded from: classes2.dex */
        class a implements DialogInterface.OnDismissListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                MapPart.this.J9();
            }
        }

        /* loaded from: classes2.dex */
        class b implements DialogInterface.OnDismissListener {
            b() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.f78702a.hasPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                    MapPart.this.getActivity().finish();
                }
            }
        }

        c(QQPermission qQPermission) {
            this.f78702a = qQPermission;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            MapPart.this.J9();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            if (this.f78702a.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                MapPart.this.J9();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(List<String> list, List<Integer> list2) {
            super.onDeniedWithoutShowDlg(list, list2);
            if (this.f78702a.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                MapPart.this.J9();
            } else {
                MapPart.this.getActivity().finish();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            super.onDialogShow(permissionRequestDialog, list);
            if (this.f78702a.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                permissionRequestDialog.setOnDismissListener(new a());
            } else {
                permissionRequestDialog.setOnDismissListener(new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            MapPart.this.N9();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            MapPart.this.f78696i.performClick();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void H9() {
        getActivity().showDialog(0);
        this.C = true;
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(this.D);
    }

    private boolean I9() {
        return ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("fixMapBug8980_105938676", Boolean.TRUE).booleanValue();
    }

    private void K9() {
        View partRootView = getPartRootView();
        if (partRootView != null) {
            ImageView imageView = (ImageView) partRootView.findViewById(R.id.f83584jy);
            this.f78696i = imageView;
            imageView.setOnClickListener(new d());
            if (I9()) {
                View findViewById = partRootView.findViewById(R.id.f83594jz);
                this.f78697m = findViewById;
                findViewById.setOnClickListener(new e());
                AccessibilityUtil.p(this.f78697m, HardCodeUtil.qqStr(R.string.f174852wz));
            }
        }
    }

    private void L9() {
        View partRootView = getPartRootView();
        if (partRootView != null) {
            this.f78694f = (QQMapView) partRootView.findViewById(R.id.emb);
            O9(false);
            View findViewById = partRootView.findViewById(R.id.f166180yx0);
            this.f78695h = findViewById;
            findViewById.setVisibility(0);
            P9(270);
            K9();
            return;
        }
        Log.i(getTAG(), "rootview is null");
    }

    private void M9() {
        if (this.f78692d == null) {
            View inflate = getActivity().getLayoutInflater().inflate(R.layout.f168249q2, (ViewGroup) null);
            this.f78692d = inflate;
            ImageView imageView = (ImageView) inflate.findViewById(R.id.cbq);
            imageView.setImageResource(R.drawable.f160347b93);
            imageView.setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N9() {
        com.tencent.biz.map.poi.b bVar = this.f78693e;
        if (bVar != null) {
            bVar.N1();
        }
    }

    private void O9(boolean z16) {
        View partRootView = getPartRootView();
        if (partRootView == null) {
            Log.i(getTAG(), "rootview is null");
            return;
        }
        if (z16 && this.f78694f != null) {
            partRootView.findViewById(R.id.fua).setVisibility(0);
            partRootView.findViewById(R.id.f83584jy).setVisibility(0);
            if (I9()) {
                partRootView.findViewById(R.id.f83594jz).setVisibility(0);
            }
            this.f78694f.setVisibility(0);
            return;
        }
        partRootView.findViewById(R.id.fua).setVisibility(8);
        partRootView.findViewById(R.id.f83584jy).setVisibility(8);
        if (I9()) {
            partRootView.findViewById(R.id.f83594jz).setVisibility(8);
        }
        QQMapView qQMapView = this.f78694f;
        if (qQMapView != null) {
            qQMapView.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P9(int i3) {
        View view;
        ViewGroup.LayoutParams layoutParams = this.f78695h.getLayoutParams();
        layoutParams.height = i3;
        this.f78695h.setLayoutParams(layoutParams);
        if (I9() && (view = this.f78697m) != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.bottomMargin = i3 + ViewUtils.dpToPx(20.0f);
            this.f78697m.setLayoutParams(marginLayoutParams);
        }
    }

    private void initViewModel() {
        com.tencent.biz.map.poi.b bVar = (com.tencent.biz.map.poi.b) getViewModel(com.tencent.biz.map.poi.b.class);
        this.f78693e = bVar;
        bVar.e2(this.f78694f.getMap());
        this.f78693e.L1();
        this.f78693e.W1().observe(getHostFragment(), new a());
        this.f78693e.U1().observe(getHostFragment(), new b());
    }

    protected void G9() {
        M9();
        ((com.tencent.biz.map.poi.b) getViewModel(com.tencent.biz.map.poi.b.class)).M1(this.f78692d);
    }

    protected void J9() {
        if (!NetworkUtil.isNetSupport(getContext())) {
            QQToast.makeText(getContext(), 1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8fde\u63a5\uff01", 0);
            O9(true);
            return;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_MAP, QQPermissionConstants.Business.SCENE.MAP_SHOW_ENTRY));
        if (vx.a.a(qQPermission)) {
            qQPermission.requestPermissions(vx.a.f443628a, 2, new c(qQPermission));
        } else {
            H9();
            O9(true);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "MapPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        L9();
        M9();
        initViewModel();
        J9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QQMapView qQMapView = this.f78694f;
        if (qQMapView != null) {
            qQMapView.onDestroy();
        }
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).removeListener(this.D);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        QQMapView qQMapView = this.f78694f;
        if (qQMapView != null) {
            qQMapView.onPause();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QQMapView qQMapView = this.f78694f;
        if (qQMapView != null) {
            qQMapView.onResume();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(Activity activity) {
        super.onPartStart(activity);
        QQMapView qQMapView = this.f78694f;
        if (qQMapView != null) {
            qQMapView.onStart();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        QQMapView qQMapView = this.f78694f;
        if (qQMapView != null) {
            qQMapView.onStop();
        }
    }
}

package com.tencent.mobileqq.location.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.location.LocationShareViewModel;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.net.LocationShareLocationManager;
import com.tencent.mobileqq.location.net.ReportLocationHandler;
import com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.az;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LocationShareFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;
    private static long H;
    private MapWidget C;
    private View D;
    private k E;
    private LocationRoom.b F;
    private HeadSetView G;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f241498d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f241499e;

        a(int i3, String str) {
            this.f241498d = i3;
            this.f241499e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, LocationShareFragment.this, Integer.valueOf(i3), str);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!LocationShareFragment.this.E.t()) {
                if (!com.tencent.mobileqq.location.util.d.a(LocationShareFragment.this.getQBaseActivity())) {
                    LocationPickFragmentV2.Kh(LocationShareFragment.this.getActivity(), this.f241498d, this.f241499e, LocationShareFragment.this.C.i());
                } else {
                    LocationPickFragment.Eh(LocationShareFragment.this.getActivity(), this.f241498d, this.f241499e, LocationShareFragment.this.C.i());
                }
                ReportController.o(null, "CliOper", "", "", "0X800A95C", "0X800A95C", 0, 0, "", "0", "0", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQPermission f241501a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f241502b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f241503c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f241504d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f241505e;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a implements DialogInterface.OnDismissListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    LocationShareFragment.this.xh();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                }
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.location.ui.LocationShareFragment$b$b, reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        class DialogInterfaceOnDismissListenerC7977b implements DialogInterface.OnDismissListener {
            static IPatchRedirector $redirector_;

            DialogInterfaceOnDismissListenerC7977b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                } else {
                    b.this.f241505e.finish();
                }
            }
        }

        b(QQPermission qQPermission, int i3, String str, int i16, QBaseActivity qBaseActivity) {
            this.f241501a = qQPermission;
            this.f241502b = i3;
            this.f241503c = str;
            this.f241504d = i16;
            this.f241505e = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, LocationShareFragment.this, qQPermission, Integer.valueOf(i3), str, Integer.valueOf(i16), qBaseActivity);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                LocationShareFragment.this.xh();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
                return;
            }
            super.onDenied(list, list2);
            if (this.f241501a.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                LocationShareFragment.this.xh();
            } else {
                com.tencent.mobileqq.location.net.e.c().e(this.f241502b, this.f241503c, this.f241504d, 1);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) list2);
                return;
            }
            super.onDeniedWithoutShowDlg(list, list2);
            if (this.f241501a.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                LocationShareFragment.this.xh();
            } else {
                this.f241505e.finish();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) permissionRequestDialog, (Object) list);
                return;
            }
            super.onDialogShow(permissionRequestDialog, list);
            if (this.f241501a.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                permissionRequestDialog.setOnDismissListener(new a());
            } else {
                permissionRequestDialog.setOnDismissListener(new DialogInterfaceOnDismissListenerC7977b());
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27936);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            H = 0L;
        }
    }

    public LocationShareFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void initData() {
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        Intent intent = getActivity().getIntent();
        int intExtra = intent.getIntExtra("FROM_KEY", -1);
        LocationHandler.K2().T2(intExtra);
        String stringExtra = intent.getStringExtra("uin");
        int intExtra2 = intent.getIntExtra("uintype", -1);
        this.F = new LocationRoom.b(intExtra2, stringExtra);
        com.tencent.mobileqq.mvvm.d checkAndAddLifeCycleFragment = ((ILifeCycleFragmentInjectApi) QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment(getActivity());
        LocationShareViewModel locationShareViewModel = (LocationShareViewModel) com.tencent.mobileqq.mvvm.h.b(checkAndAddLifeCycleFragment, LocationShareViewModel.G).get(LocationShareViewModel.class);
        locationShareViewModel.S1(appInterface, getQBaseActivity(), this.F);
        k kVar = new k(locationShareViewModel, checkAndAddLifeCycleFragment);
        this.E = kVar;
        HeadSetView headSetView = this.G;
        LocationRoom.b bVar = this.F;
        boolean z16 = true;
        if (intExtra != 1) {
            z16 = false;
        }
        headSetView.setLocationController(kVar, bVar, z16);
        TextView textView = (TextView) this.D.findViewById(R.id.f166142bn0);
        textView.setOnClickListener(new a(intExtra2, stringExtra));
        if (az.f()) {
            textView.setBackgroundResource(R.drawable.f160924l5);
        } else {
            textView.setBackgroundResource(R.drawable.c29);
        }
    }

    private void initView() {
        MapWidget mapWidget = (MapWidget) this.D.findViewById(R.id.lrc);
        this.C = mapWidget;
        MapUtils.i(mapWidget, "\u5730\u56fe \u4f60\u6b63\u5728\u5171\u4eab\u4f4d\u7f6e");
        ImageView imageView = (ImageView) this.D.findViewById(R.id.lrh);
        MapUtils.i(imageView, "\u5728\u5730\u56fe\u533a\u56de\u5230\u6211\u7684\u4f4d\u7f6e");
        this.E.j(getQBaseActivity(), this.F, this.C, this.G.headSetViewModule, imageView, this.D.findViewById(R.id.bmz), this.D.findViewById(R.id.f166142bn0), this.D.findViewById(R.id.acl));
        if (az.f()) {
            TencentMap map = this.C.getMap();
            this.C.getMap();
            map.setMapType(1008);
        } else {
            TencentMap map2 = this.C.getMap();
            this.C.getMap();
            map2.setMapType(1000);
        }
        ((IFloatMapService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFloatMapService.class, "")).quitFloat(1);
        ReportController.o(null, "CliOper", "", "", "0X800A8BA", "0X800A8BA", 0, 0, "", "0", "0", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void wh(Context context, int i3, String str, int i16) {
        Intent intent = new Intent();
        intent.putExtra("uin", str);
        intent.putExtra("uintype", i3);
        intent.putExtra("FROM_KEY", i16);
        intent.putExtra("FRAGMENT_KEY", "LocationShareFragment");
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        QPublicFragmentActivity.start(context, intent, LocationShareFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xh() {
        initData();
        initView();
    }

    public static void yh(Activity activity, int i3, String str, int i16) {
        if (System.currentTimeMillis() - H < 1000) {
            if (QLog.isColorLevel()) {
                QLog.d("LocationShareFragment", 2, "launch: invoked. ", " sLastLaunchTime: ", Long.valueOf(H));
                return;
            }
            return;
        }
        H = System.currentTimeMillis();
        if (MapUtils.h(activity) <= 0) {
            QQToast.makeText(activity, 1, activity.getString(R.string.f171143iv2), 1).show();
            return;
        }
        ReportLocationHandler reportLocationHandler = LocationShareLocationManager.h().f241318a;
        boolean z16 = !reportLocationHandler.t(str, i3);
        if (QLog.isColorLevel()) {
            QLog.d("LocationShareFragment", 2, "[location_fragment]launch: invoked. ", " notSameSession: ", Boolean.valueOf(z16));
        }
        if (!reportLocationHandler.m()) {
            if (QLog.isColorLevel()) {
                QLog.d("LocationShareFragment", 2, "launch: invoked. not reporting ", " from: ", Integer.valueOf(i16));
            }
            if (i16 != 1) {
                LocationDialogUtil.n(activity, i3, str, i16);
                return;
            } else {
                wh(activity, i3, str, i16);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationShareFragment", 2, "launch: invoked. reporting ", " from: ", Integer.valueOf(i16));
        }
        if (z16) {
            LocationDialogUtil.f(activity, i3, str, i16);
        } else {
            wh(activity, i3, str, i16);
        }
    }

    public static boolean zh(Activity activity, boolean z16) {
        int i3 = 9216;
        if (!cu.f() && !cu.g()) {
            if (!z16) {
                i3 = 1280;
            }
            activity.getWindow().getDecorView().setSystemUiVisibility(i3);
            return z16;
        }
        if (ImmersiveUtils.supportStatusBarDarkMode()) {
            ImmersiveUtils.setStatusBarDarkMode(activity.getWindow(), z16);
            if (cu.g()) {
                if (!z16) {
                    i3 = 1280;
                }
                activity.getWindow().getDecorView().setSystemUiVisibility(i3);
                return z16;
            }
            return z16;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 == 0 || i3 == 0) {
            this.C.y();
            if (i16 == -1) {
                LocationRoom.Venue venue = (LocationRoom.Venue) intent.getParcelableExtra("key_picked_location");
                if (QLog.isColorLevel()) {
                    QLog.d("LocationShareFragment", 2, "[venue] share fragment onActivityResult: venue: " + venue);
                }
                if (venue != null) {
                    this.E.s(venue);
                    return;
                } else {
                    QQToast.makeText(getActivity(), 1, R.string.hgu, 1).show();
                    return;
                }
            }
            if (i16 == -1) {
                LocationRoom.Venue venue2 = (LocationRoom.Venue) intent.getParcelableExtra("key_picked_location");
                if (QLog.isColorLevel()) {
                    QLog.d("LocationShareFragment", 2, "[venue] share fragment onActivityResult: venue: " + venue2);
                }
                if (venue2 != null) {
                    this.E.s(venue2);
                    return;
                } else {
                    QQToast.makeText(getActivity(), 1, R.string.hgu, 1).show();
                    return;
                }
            }
            if (i16 == 1 || i16 == 1) {
                getActivity().finish();
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        getActivity().overridePendingTransition(0, R.anim.f154550b4);
        if (((IFloatMapService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFloatMapService.class, "")).enterFloat(getQBaseActivity(), this.F)) {
            return super.onBackEvent();
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @SuppressLint({"InflateParams"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            view = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("LocationShareFragment", 2, "[location_fragment]onCreateView: invoked. this: " + this + " activity: " + getActivity());
            }
            View inflate = layoutInflater.inflate(R.layout.f167975c81, (ViewGroup) null);
            this.D = inflate;
            HeadSetView headSetView = (HeadSetView) inflate.findViewById(R.id.lkg);
            this.G = headSetView;
            headSetView.d();
            getActivity().overridePendingTransition(R.anim.f154548b2, android.R.anim.fade_out);
            view = this.D;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationShareFragment", 2, "[location_fragment]onDestroy: invoked. this: " + this + " activity: " + getActivity());
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationShareFragment", 2, "[location_fragment]onFinish: invoked. this: " + this + " activity: " + getActivity());
        }
        super.onFinish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, R.anim.f154550b4);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationShareFragment", 2, "[location_fragment]onPause: invoked. this: " + this + " isFinishing: " + getActivity().isFinishing() + " activity: " + getActivity());
        }
        super.onPause();
        MapWidget mapWidget = this.C;
        if (mapWidget != null) {
            mapWidget.g(false);
            this.C.onPause();
        }
        if (getActivity().isFinishing()) {
            MapUtils.a();
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.location.ui.LocationShareFragment.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocationShareFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    LocationHandler.K2().S2();
                    if (LocationShareFragment.this.C != null) {
                        LocationShareFragment.this.C.onStop();
                        LocationShareFragment.this.C.onDestroy();
                        LocationShareFragment.this.C = null;
                    }
                    if (LocationShareFragment.this.G != null) {
                        LocationShareFragment.this.G = null;
                    }
                    if (LocationShareFragment.this.E != null) {
                        LocationShareFragment.this.E.o();
                        LocationShareFragment.this.E = null;
                    }
                }
            }, 200L);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationShareFragment", 2, "[location_fragment]onResume: invoked. this: " + this + " activity: " + getActivity());
        }
        super.onResume();
        MapWidget mapWidget = this.C;
        if (mapWidget != null) {
            mapWidget.g(true);
            this.C.onResume();
        }
        this.G.i();
        if (this.F != null && LocationShareLocationManager.h().f241318a.n(this.F)) {
            LocationHandler.K2().R2(this.F.b(), this.F.c());
        }
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            return;
        }
        zh(qBaseActivity, false);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationShareFragment", 2, "[location_fragment]onStart: invoked. this: " + this + " activity: " + getActivity());
        }
        super.onStart();
        MapWidget mapWidget = this.C;
        if (mapWidget != null) {
            mapWidget.onStart();
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.location.ui.LocationShareFragment.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocationShareFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    MapUtils.k();
                }
            }
        });
        ee2.d.a("aio");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationShareFragment", 2, "[location_fragment]onStop: invoked. this: " + this + " activity: " + getActivity());
        }
        super.onStop();
        MapWidget mapWidget = this.C;
        if (mapWidget != null) {
            mapWidget.onStop();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationShareFragment", 2, "[location_fragment]onViewCreated: invoked. this: " + this + " activity: " + getActivity());
        }
        super.onViewCreated(view, bundle);
        QBaseActivity qBaseActivity = getQBaseActivity();
        Intent intent = qBaseActivity.getIntent();
        int intExtra = intent.getIntExtra("FROM_KEY", -1);
        String stringExtra = intent.getStringExtra("uin");
        int intExtra2 = intent.getIntExtra("uintype", -1);
        if (!NetworkUtil.isNetworkAvailable()) {
            LocationDialogUtil.g(qBaseActivity, intExtra, intExtra2, stringExtra);
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_LOCATION, QQPermissionConstants.Business.SCENE.SHARE_LOCATION));
        if (com.tencent.mobileqq.location.util.a.a(qQPermission)) {
            qQPermission.requestPermissions(com.tencent.mobileqq.location.util.a.f241701a, 2, new b(qQPermission, intExtra2, stringExtra, intExtra, qBaseActivity));
        } else {
            xh();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean overrideFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        boolean overrideFinish = super.overrideFinish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, R.anim.f154550b4);
        }
        return overrideFinish;
    }
}

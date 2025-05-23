package com.tencent.mobileqq.location.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.location.LocationPickViewModelV2;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.net.LocationShareLocationManager;
import com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqcommon.api.IImmersiveUtilsApi;
import com.tencent.mobileqq.qqcommon.api.ILiuHaiUtilsApi;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.az;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenDefaultHeaderView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.widget.XListView;
import java.util.List;

/* loaded from: classes15.dex */
public class LocationPickFragmentV2 extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;
    private static long L;
    private MapWidget C;
    private View D;
    private View E;
    private XListView F;
    private QUSHalfScreenFloatingView G;
    private com.tencent.mobileqq.location.ui.g H;
    private LocationPickViewModelV2 I;
    private boolean J;
    private LocationRoom.b K;

    /* loaded from: classes15.dex */
    class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQPermission f241449a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f241450b;

        /* renamed from: com.tencent.mobileqq.location.ui.LocationPickFragmentV2$a$a, reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        class DialogInterfaceOnDismissListenerC7974a implements DialogInterface.OnDismissListener {
            static IPatchRedirector $redirector_;

            DialogInterfaceOnDismissListenerC7974a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    LocationPickFragmentV2.this.Gh();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                }
            }
        }

        /* loaded from: classes15.dex */
        class b implements DialogInterface.OnDismissListener {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                } else {
                    a.this.f241450b.finish();
                }
            }
        }

        a(QQPermission qQPermission, QBaseActivity qBaseActivity) {
            this.f241449a = qQPermission;
            this.f241450b = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, LocationPickFragmentV2.this, qQPermission, qBaseActivity);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                LocationPickFragmentV2.this.Gh();
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
            if (this.f241449a.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                LocationPickFragmentV2.this.Gh();
                return;
            }
            Intent intent = this.f241450b.getIntent();
            String stringExtra = intent.getStringExtra("uin");
            com.tencent.mobileqq.location.net.e.c().e(intent.getIntExtra("uintype", -1), stringExtra, LocationHandler.K2().H2(), 1);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) list2);
                return;
            }
            super.onDeniedWithoutShowDlg(list, list2);
            if (this.f241449a.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                LocationPickFragmentV2.this.Gh();
            } else {
                this.f241450b.finish();
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
            if (this.f241449a.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                permissionRequestDialog.setOnDismissListener(new DialogInterfaceOnDismissListenerC7974a());
            } else {
                permissionRequestDialog.setOnDismissListener(new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class b implements View.OnHoverListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationPickFragmentV2.this);
            }
        }

        @Override // android.view.View.OnHoverListener
        public boolean onHover(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            AccessibilityManager accessibilityManager = (AccessibilityManager) LocationPickFragmentV2.this.getActivity().getSystemService("accessibility");
            if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
                if (view.requestFocus()) {
                    ((InputMethodManager) LocationPickFragmentV2.this.getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(view, 1);
                }
                LocationPickFragmentV2.this.G.P(0);
                ReportController.o(null, "CliOper", "", "", "0X800A95E", "0X800A95E", 0, 0, "", "0", "0", "");
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class c implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f241455d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f241456e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f241457f;

        c(View view, View view2, View view3) {
            this.f241455d = view;
            this.f241456e = view2;
            this.f241457f = view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, LocationPickFragmentV2.this, view, view2, view3);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (1 == motionEvent.getAction()) {
                com.tencent.mobileqq.location.ui.g gVar = LocationPickFragmentV2.this.H;
                com.tencent.mobileqq.location.ui.g unused = LocationPickFragmentV2.this.H;
                gVar.l(2);
                this.f241455d.setVisibility(8);
                this.f241456e.setVisibility(0);
                this.f241457f.setVisibility(0);
                LocationPickFragmentV2.this.G.P(0);
                ReportController.o(null, "CliOper", "", "", "0X800A95E", "0X800A95E", 0, 0, "", "0", "0", "");
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f241459d;

        d(EditText editText) {
            this.f241459d = editText;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationPickFragmentV2.this, (Object) editText);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                this.f241459d.setText("");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class e implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f241461d;

        e(View view) {
            this.f241461d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationPickFragmentV2.this, (Object) view);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
                return;
            }
            if (editable.length() > 0) {
                this.f241461d.setVisibility(0);
            } else {
                this.f241461d.setVisibility(8);
            }
            String trim = editable.toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                LocationPickFragmentV2.this.H.x(trim);
            } else {
                LocationPickFragmentV2.this.H.x("");
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f241463d;

        f(QBaseActivity qBaseActivity) {
            this.f241463d = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationPickFragmentV2.this, (Object) qBaseActivity);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                this.f241463d.setResult(0);
                this.f241463d.finish();
                ReportController.o(null, "CliOper", "", "", "0X800A963", "0X800A963", 0, 0, "0", "0", "0", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class g implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f241465d;

        g(QBaseActivity qBaseActivity) {
            this.f241465d = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationPickFragmentV2.this, (Object) qBaseActivity);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!NetworkUtil.isNetworkAvailable()) {
                QQToast.makeText(this.f241465d, R.string.hh8, 0).show();
            } else {
                LocationRoom.Venue m3 = LocationPickFragmentV2.this.H.m();
                if (QLog.isColorLevel()) {
                    QLog.d("LocationPickFragment", 2, "[venue] pick confirm click: venue: " + m3);
                }
                if (!LocationPickFragmentV2.this.I.Q1()) {
                    i3 = 1;
                }
                ReportController.o(null, "CliOper", "", "", "0X800A962", "0X800A962", i3, 0, "", "0", "0", "");
                Intent intent = new Intent();
                intent.putExtra("key_picked_location", m3);
                this.f241465d.setResult(-1, intent);
                this.f241465d.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class h implements QUSBaseHalfScreenFloatingView.n {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationPickFragmentV2.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.n
        public void onFinishDrag() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.n
        public void onStartDrag() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class i implements QUSBaseHalfScreenFloatingView.k {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationPickFragmentV2.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.k
        public void a(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
            } else {
                LocationPickFragmentV2 locationPickFragmentV2 = LocationPickFragmentV2.this;
                locationPickFragmentV2.Lh(locationPickFragmentV2.D.getHeight() - ((int) f16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class j extends com.tencent.mobileqq.widget.qus.e {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f241469d;

        j(int i3) {
            this.f241469d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationPickFragmentV2.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
            }
            if ((LocationPickFragmentV2.this.F.getChildCount() <= 0 || LocationPickFragmentV2.this.F.getFirstVisiblePosition() != 0 || LocationPickFragmentV2.this.F.getChildAt(0).getTop() < LocationPickFragmentV2.this.F.getPaddingTop()) && LocationPickFragmentV2.this.F.getChildCount() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
            }
            LocationPickFragmentV2.this.F.getDrawingRect(new Rect());
            return true;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF57419d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return LocationPickFragmentV2.this.E;
            }
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int initState() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return (this.f241469d * 74) / 100;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int minHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return (this.f241469d * 36) / 100;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class k extends com.tencent.mobileqq.widget.qus.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f241471d;

        k(int i3) {
            this.f241471d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationPickFragmentV2.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowMin() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                LocationPickFragmentV2.this.J = true;
                LocationPickFragmentV2.this.Lh((this.f241471d * 36) / 100);
                LocationPickFragmentV2.this.hideInputMethod();
                if (LocationPickFragmentV2.this.H != null) {
                    LocationPickFragmentV2.this.H.y();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotal() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                LocationPickFragmentV2.this.J = false;
                LocationPickFragmentV2.this.Lh((this.f241471d * 74) / 100);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class l implements View.OnKeyListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f241473d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f241474e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f241475f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f241476h;

        l(EditText editText, View view, View view2, View view3) {
            this.f241473d = editText;
            this.f241474e = view;
            this.f241475f = view2;
            this.f241476h = view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, LocationPickFragmentV2.this, editText, view, view2, view3);
            }
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), keyEvent)).booleanValue();
            }
            if (i3 == 4) {
                LocationPickFragmentV2.this.Hh(this.f241473d, this.f241474e, this.f241475f, this.f241476h);
                return true;
            }
            if (i3 != 84 && i3 != 66) {
                return false;
            }
            LocationPickFragmentV2.this.H.x(this.f241473d.getText().toString().trim());
            LocationPickFragmentV2.this.hideInputMethod();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class m implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f241478d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f241479e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f241480f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f241481h;

        m(EditText editText, View view, View view2, View view3) {
            this.f241478d = editText;
            this.f241479e = view;
            this.f241480f = view2;
            this.f241481h = view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, LocationPickFragmentV2.this, editText, view, view2, view3);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                LocationPickFragmentV2.this.Fh(this.f241478d, this.f241479e, this.f241480f, this.f241481h);
                ReportController.o(null, "CliOper", "", "", "0X800A961", "0X800A961", 0, 0, "0", "0", "0", "");
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27693);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            L = 0L;
        }
    }

    public LocationPickFragmentV2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.J = true;
        }
    }

    private void Eh() {
        ((ILiuHaiUtilsApi) QRoute.api(ILiuHaiUtilsApi.class)).initLiuHaiProperty(getActivity());
        int statusBarHeight = ((IImmersiveUtilsApi) QRoute.api(IImmersiveUtilsApi.class)).getStatusBarHeight(getActivity());
        View findViewById = this.D.findViewById(R.id.c3p);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        if (((ILiuHaiUtilsApi) QRoute.api(ILiuHaiUtilsApi.class)).isHasNotch()) {
            findViewById.setPadding(x.c(getActivity(), 20.0f), ((ILiuHaiUtilsApi) QRoute.api(ILiuHaiUtilsApi.class)).getNotchHeight(), x.c(getActivity(), 20.0f), 0);
            layoutParams.height += statusBarHeight + ((ILiuHaiUtilsApi) QRoute.api(ILiuHaiUtilsApi.class)).getNotchHeight();
        } else {
            findViewById.setPadding(x.c(getActivity(), 20.0f), statusBarHeight, x.c(getActivity(), 20.0f), 0);
            layoutParams.height += statusBarHeight;
        }
        findViewById.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh(EditText editText, View view, View view2, View view3) {
        this.H.l(1);
        editText.setText("");
        hideInputMethod();
        this.G.O(0);
        view.setVisibility(0);
        view2.setVisibility(8);
        view3.setVisibility(8);
        editText.clearFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gh() {
        initData();
        initView();
        this.C.onStart();
        this.C.onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh(EditText editText, View view, View view2, View view3) {
        if (this.J) {
            Fh(editText, view, view2, view3);
        } else {
            this.G.O(0);
        }
    }

    private void Ih() {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) this.D.findViewById(R.id.x5o);
        this.G = qUSHalfScreenFloatingView;
        qUSHalfScreenFloatingView.setVisibility(0);
        this.G.setOutSideTouchEnable(false);
        this.G.r();
        this.G.getChildAt(0).setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        relativeLayout.addView(new QUSHalfScreenDefaultHeaderView(getContext(), null, 0));
        this.G.setHeaderView(relativeLayout);
        int i3 = getResources().getDisplayMetrics().heightPixels;
        this.G.i(new h());
        this.G.l(new i());
        this.G.setQUSDragFloatController(new j(i3));
        this.G.j(new k(i3));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void Jh() {
        getActivity().getWindow().setSoftInputMode(48);
        View findViewById = this.D.findViewById(R.id.cas);
        View findViewById2 = findViewById.findViewById(R.id.btn_cancel_search);
        View findViewById3 = findViewById.findViewById(R.id.kag);
        View findViewById4 = findViewById.findViewById(R.id.ib_clear_text);
        View findViewById5 = findViewById.findViewById(R.id.f110936jv);
        findViewById2.setVisibility(8);
        EditText editText = (EditText) findViewById.findViewById(R.id.et_search_keyword);
        editText.setOnKeyListener(new l(editText, findViewById3, findViewById2, findViewById5));
        findViewById2.setOnClickListener(new m(editText, findViewById3, findViewById2, findViewById5));
        editText.setImeOptions(3);
        editText.setOnHoverListener(new b());
        editText.setOnTouchListener(new c(findViewById3, findViewById2, findViewById5));
        findViewById.findViewById(R.id.ib_clear_text).setOnClickListener(new d(editText));
        editText.addTextChangedListener(new e(findViewById4));
    }

    public static void Kh(Activity activity, int i3, String str, CameraPosition cameraPosition) {
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(activity, R.string.hh8, 0).show();
            return;
        }
        if (System.currentTimeMillis() - L < 1000) {
            return;
        }
        L = System.currentTimeMillis();
        if (MapUtils.h(activity) <= 0) {
            QQToast.makeText(activity, 1, activity.getString(R.string.f171143iv2), 1).show();
            return;
        }
        boolean z16 = !LocationShareLocationManager.h().f241318a.t(str, i3);
        if (QLog.isColorLevel()) {
            QLog.d("LocationPickFragment", 2, "[location_fragment]launch: invoked. ", " notSameSession: ", Boolean.valueOf(z16));
        }
        Intent intent = new Intent();
        intent.putExtra("uin", str);
        intent.putExtra("uintype", i3);
        intent.putExtra("FRAGMENT_KEY", "LocationPickFragment");
        intent.putExtra("key_last_position", cameraPosition.target);
        intent.putExtra("key_last_zoom", cameraPosition.zoom);
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) LocationPickFragmentV2.class, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lh(int i3) {
        View findViewById = this.D.findViewById(R.id.f166180yx0);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = i3;
        findViewById.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideInputMethod() {
        InputMethodManager inputMethodManager = (InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null && inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(((EditText) this.D.findViewById(R.id.et_search_keyword)).getWindowToken(), 0);
        }
    }

    private void initData() {
        com.tencent.mobileqq.mvvm.d checkAndAddLifeCycleFragment = ((ILifeCycleFragmentInjectApi) QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment(getActivity());
        LocationPickViewModelV2 locationPickViewModelV2 = (LocationPickViewModelV2) com.tencent.mobileqq.mvvm.h.b(checkAndAddLifeCycleFragment, LocationPickViewModelV2.G).get(LocationPickViewModelV2.class);
        this.I = locationPickViewModelV2;
        this.H = new com.tencent.mobileqq.location.ui.g(locationPickViewModelV2, checkAndAddLifeCycleFragment);
        Intent intent = getActivity().getIntent();
        this.K = new LocationRoom.b(intent.getIntExtra("uintype", -1), intent.getStringExtra("uin"));
    }

    private void initView() {
        Eh();
        QBaseActivity qBaseActivity = getQBaseActivity();
        this.D.findViewById(R.id.cau).setOnClickListener(new f(qBaseActivity));
        this.D.findViewById(R.id.cax).setOnClickListener(new g(qBaseActivity));
        Jh();
        this.F = (XListView) this.E.findViewById(R.id.fw_);
        MapWidget mapWidget = (MapWidget) this.D.findViewById(R.id.lrc);
        this.C = mapWidget;
        MapUtils.i(mapWidget, "\u5730\u56fe \u4f60\u6b63\u5728\u5171\u4eab\u4f4d\u7f6e");
        ImageView imageView = (ImageView) this.D.findViewById(R.id.lrh);
        MapUtils.i(imageView, "\u5728\u5730\u56fe\u533a\u56de\u5230\u6211\u7684\u4f4d\u7f6e");
        Intent intent = qBaseActivity.getIntent();
        this.H.p(qBaseActivity, this.K, CameraPosition.fromLatLngZoom((LatLng) intent.getParcelableExtra("key_last_position"), intent.getFloatExtra("key_last_zoom", 0.0f)), this.C, imageView, this.D.findViewById(R.id.cax), this.E, this.G, this.F, this.D.findViewById(R.id.f166531c92), this.D.findViewById(R.id.c3n));
        this.D.findViewById(R.id.f164945lf2);
        View findViewById = this.D.findViewById(R.id.c3p);
        if (az.f()) {
            TencentMap map = this.C.getMap();
            this.C.getMap();
            map.setMapType(1008);
            findViewById.setBackgroundColor(Color.parseColor("#CC000000"));
            return;
        }
        TencentMap map2 = this.C.getMap();
        this.C.getMap();
        map2.setMapType(1000);
        findViewById.setBackgroundColor(Color.parseColor("#7F000000"));
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 4) {
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        getActivity().setResult(0);
        getActivity().overridePendingTransition(0, R.anim.f154550b4);
        return super.onBackEvent();
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
                QLog.d("LocationPickFragment", 2, "[location_fragment]onCreateView: invoked. this: " + this + " activity: " + getActivity());
            }
            this.D = layoutInflater.inflate(R.layout.e_c, (ViewGroup) null);
            this.E = layoutInflater.inflate(R.layout.fga, (ViewGroup) null);
            getActivity().overridePendingTransition(R.anim.f154548b2, R.anim.f154550b4);
            view = this.D;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationPickFragment", 2, "[location_fragment]onDestroy: invoked. this: " + this + " activity: " + getActivity());
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationPickFragment", 2, "[location_fragment]onFinish: invoked. this: " + this + " activity: " + getActivity());
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationPickFragment", 2, "[location_fragment]onPause: invoked. this: " + this + " isFinishing: " + getActivity().isFinishing() + " activity: " + getActivity());
        }
        super.onPause();
        MapWidget mapWidget = this.C;
        if (mapWidget != null) {
            mapWidget.onPause();
        }
        if (getActivity().isFinishing()) {
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.location.ui.LocationPickFragmentV2.14
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocationPickFragmentV2.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (LocationPickFragmentV2.this.C != null) {
                        LocationPickFragmentV2.this.C.onStop();
                        LocationPickFragmentV2.this.C.onDestroy();
                        LocationPickFragmentV2.this.C = null;
                    }
                    if (LocationPickFragmentV2.this.H != null) {
                        LocationPickFragmentV2.this.H.s();
                        LocationPickFragmentV2.this.H = null;
                    }
                }
            }, 200L);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationPickFragment", 2, "[location_fragment]onResume: invoked. this: " + this + " activity: " + getActivity());
        }
        super.onResume();
        MapWidget mapWidget = this.C;
        if (mapWidget != null) {
            mapWidget.onResume();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationPickFragment", 2, "[location_fragment]onStart: invoked. this: " + this + " activity: " + getActivity());
        }
        super.onStart();
        MapWidget mapWidget = this.C;
        if (mapWidget != null) {
            mapWidget.onStart();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationPickFragment", 2, "[location_fragment]onStop: invoked. this: " + this + " activity: " + getActivity());
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
            QLog.d("LocationPickFragment", 2, "[location_fragment]onViewCreated: invoked. this: " + this + " activity: " + getActivity());
        }
        super.onViewCreated(view, bundle);
        Ih();
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_LOCATION, QQPermissionConstants.Business.SCENE.SHARE_PICK_LOCATION));
        if (com.tencent.mobileqq.location.util.a.a(qQPermission)) {
            qQPermission.requestPermissions(com.tencent.mobileqq.location.util.a.f241701a, 2, new a(qQPermission, getQBaseActivity()));
        } else {
            Gh();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            super.onWindowFocusChanged(z16);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean overrideFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        boolean overrideFinish = super.overrideFinish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, R.anim.f154550b4);
        }
        return overrideFinish;
    }
}

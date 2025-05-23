package com.tencent.mobileqq.location.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
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
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.location.LocationPickViewModel;
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
import com.tencent.mobileqq.widget.r;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.widget.XListView;
import java.util.List;

/* loaded from: classes15.dex */
public class LocationPickFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;
    private static long I;
    private PoiSlideBottomPanel C;
    private MapWidget D;
    private View E;
    private com.tencent.mobileqq.location.ui.e F;
    private LocationPickViewModel G;
    private LocationRoom.b H;

    /* loaded from: classes15.dex */
    class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQPermission f241421a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f241422b;

        /* renamed from: com.tencent.mobileqq.location.ui.LocationPickFragment$a$a, reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        class DialogInterfaceOnDismissListenerC7973a implements DialogInterface.OnDismissListener {
            static IPatchRedirector $redirector_;

            DialogInterfaceOnDismissListenerC7973a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    LocationPickFragment.this.Ah();
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
                    a.this.f241422b.finish();
                }
            }
        }

        a(QQPermission qQPermission, QBaseActivity qBaseActivity) {
            this.f241421a = qQPermission;
            this.f241422b = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, LocationPickFragment.this, qQPermission, qBaseActivity);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                LocationPickFragment.this.Ah();
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
            if (this.f241421a.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                LocationPickFragment.this.Ah();
                return;
            }
            Intent intent = this.f241422b.getIntent();
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
            if (this.f241421a.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                LocationPickFragment.this.Ah();
            } else {
                this.f241422b.finish();
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
            if (this.f241421a.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                permissionRequestDialog.setOnDismissListener(new DialogInterfaceOnDismissListenerC7973a());
            } else {
                permissionRequestDialog.setOnDismissListener(new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationPickFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (LocationPickFragment.this.C.n()) {
                LocationPickFragment.this.C.j();
            } else {
                LocationPickFragment.this.C.b();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class c implements r {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f241427d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f241428e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f241429f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ImageView f241430h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ View f241431i;

        c(View view, View view2, View view3, ImageView imageView, View view4) {
            this.f241427d = view;
            this.f241428e = view2;
            this.f241429f = view3;
            this.f241430h = imageView;
            this.f241431i = view4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, LocationPickFragment.this, view, view2, view3, imageView, view4);
            }
        }

        @Override // com.tencent.mobileqq.widget.r
        public void cancelAnimator() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.widget.r
        public void displayPanel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.widget.r
        public void displayPanelFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            if (LocationPickFragment.this.D != null) {
                LocationPickFragment.this.D.setEnabled(false);
            }
            ReportController.o(null, "CliOper", "", "", "0X800A95F", "0X800A95F", LocationPickFragment.this.C.S(), 0, "", "0", "0", "");
            this.f241428e.setVisibility(8);
            this.f241429f.setContentDescription(LocationPickFragment.this.getString(R.string.w1i));
            if (this.f241430h != null && LocationPickFragment.this.C.n()) {
                this.f241430h.setImageResource(R.drawable.hzl);
            }
        }

        @Override // com.tencent.mobileqq.widget.r
        public void fadeBackground(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
                return;
            }
            if (f16 < 0.0f) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("LocationPickFragment", 2, "[panel] fadeBackground: invoked. alpha: " + f16);
            }
            this.f241427d.setBackgroundColor(Color.argb(Math.round(f16 * 0.7f * 255.0f), 0, 0, 0));
        }

        @Override // com.tencent.mobileqq.widget.r
        public void hidePanel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                LocationPickFragment.this.hideInputMethod();
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.widget.r
        public void hidePanelFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            if (LocationPickFragment.this.D != null) {
                LocationPickFragment.this.D.setEnabled(true);
            }
            LocationPickFragment.this.C.setDisplayFromType(2);
            this.f241431i.requestFocus();
            this.f241428e.setVisibility(0);
            this.f241429f.setContentDescription(LocationPickFragment.this.getString(R.string.w1h));
            if (this.f241430h != null && !LocationPickFragment.this.C.n()) {
                this.f241430h.setImageResource(R.drawable.hzk);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f241433d;

        d(QBaseActivity qBaseActivity) {
            this.f241433d = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationPickFragment.this, (Object) qBaseActivity);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                this.f241433d.setResult(0);
                this.f241433d.finish();
                ReportController.o(null, "CliOper", "", "", "0X800A963", "0X800A963", 0, 0, "0", "0", "0", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f241435d;

        e(QBaseActivity qBaseActivity) {
            this.f241435d = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationPickFragment.this, (Object) qBaseActivity);
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
                QQToast.makeText(this.f241435d, R.string.hh8, 0).show();
            } else {
                LocationRoom.Venue i16 = LocationPickFragment.this.F.i();
                if (QLog.isColorLevel()) {
                    QLog.d("LocationPickFragment", 2, "[venue] pick confirm click: venue: " + i16);
                }
                if (!LocationPickFragment.this.G.Q1()) {
                    i3 = 1;
                }
                ReportController.o(null, "CliOper", "", "", "0X800A962", "0X800A962", i3, 0, "", "0", "0", "");
                Intent intent = new Intent();
                intent.putExtra("key_picked_location", i16);
                this.f241435d.setResult(-1, intent);
                this.f241435d.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class f implements View.OnKeyListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f241437d;

        f(EditText editText) {
            this.f241437d = editText;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationPickFragment.this, (Object) editText);
            }
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), keyEvent)).booleanValue();
            }
            if (i3 == 4 && LocationPickFragment.this.C.n()) {
                LocationPickFragment.this.C.i();
                return true;
            }
            if (i3 != 84 && i3 != 66) {
                return false;
            }
            LocationPickFragment.this.F.s(this.f241437d.getText().toString().trim());
            LocationPickFragment.this.hideInputMethod();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class g implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f241439d;

        g(EditText editText) {
            this.f241439d = editText;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationPickFragment.this, (Object) editText);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                this.f241439d.setText("");
                LocationPickFragment.this.C.i();
                ReportController.o(null, "CliOper", "", "", "0X800A961", "0X800A961", 0, 0, "0", "0", "0", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class h implements View.OnHoverListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationPickFragment.this);
            }
        }

        @Override // android.view.View.OnHoverListener
        public boolean onHover(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            AccessibilityManager accessibilityManager = (AccessibilityManager) LocationPickFragment.this.getActivity().getSystemService("accessibility");
            if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
                if (view.requestFocus()) {
                    ((InputMethodManager) LocationPickFragment.this.getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(view, 1);
                }
                if (!LocationPickFragment.this.C.n()) {
                    LocationPickFragment.this.C.setDisplayFromType(3);
                    LocationPickFragment.this.C.b();
                }
                ReportController.o(null, "CliOper", "", "", "0X800A95E", "0X800A95E", 0, 0, "", "0", "0", "");
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class i implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationPickFragment.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (1 == motionEvent.getAction()) {
                if (!LocationPickFragment.this.C.n()) {
                    LocationPickFragment.this.C.setDisplayFromType(3);
                    LocationPickFragment.this.C.b();
                }
                ReportController.o(null, "CliOper", "", "", "0X800A95E", "0X800A95E", 0, 0, "", "0", "0", "");
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class j implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f241443d;

        j(EditText editText) {
            this.f241443d = editText;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationPickFragment.this, (Object) editText);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                this.f241443d.setText("");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class k implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f241445d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f241446e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f241447f;

        k(View view, View view2, View view3) {
            this.f241445d = view;
            this.f241446e = view2;
            this.f241447f = view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, LocationPickFragment.this, view, view2, view3);
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
                this.f241445d.setVisibility(8);
                this.f241446e.setVisibility(0);
                this.f241447f.setVisibility(0);
            } else {
                this.f241445d.setVisibility(0);
                this.f241446e.setVisibility(8);
                this.f241447f.setVisibility(8);
            }
            String trim = editable.toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                LocationPickFragment.this.F.s(trim);
            } else {
                LocationPickFragment.this.F.s("");
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27187);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            I = 0L;
        }
    }

    public LocationPickFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ah() {
        initData();
        initView();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void Bh() {
        getActivity().getWindow().setSoftInputMode(48);
        View findViewById = this.E.findViewById(R.id.cas);
        View findViewById2 = findViewById.findViewById(R.id.btn_cancel_search);
        findViewById2.setVisibility(8);
        ((TextView) findViewById.findViewById(R.id.kag)).setText("\u67e5\u627e\u96c6\u5408\u5730\u70b9");
        EditText editText = (EditText) findViewById.findViewById(R.id.et_search_keyword);
        editText.setOnKeyListener(new f(editText));
        findViewById2.setOnClickListener(new g(editText));
        editText.setImeOptions(3);
        editText.setOnHoverListener(new h());
        editText.setOnTouchListener(new i());
        findViewById.findViewById(R.id.ib_clear_text).setOnClickListener(new j(editText));
        View findViewById3 = findViewById.findViewById(R.id.kag);
        editText.addTextChangedListener(new k(findViewById3, findViewById.findViewById(R.id.ib_clear_text), findViewById2));
        if (az.f()) {
            editText.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.skin_aio_input_bg));
            ((TextView) findViewById3).setTextColor(Color.parseColor("#8E8E93"));
        } else {
            editText.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.searchbar_input_location_share));
        }
    }

    private void Ch() {
        ((ILiuHaiUtilsApi) QRoute.api(ILiuHaiUtilsApi.class)).initLiuHaiProperty(getActivity());
        int c16 = x.c(getActivity(), 275.0f) - ((ILiuHaiUtilsApi) QRoute.api(ILiuHaiUtilsApi.class)).getNotchHeight();
        PoiSlideBottomPanel poiSlideBottomPanel = (PoiSlideBottomPanel) this.E.findViewById(R.id.m8z);
        this.C = poiSlideBottomPanel;
        poiSlideBottomPanel.setBottomHeight(c16);
        this.C.setTitleHeightNoDisplay(c16);
        View findViewById = this.E.findViewById(R.id.c3o);
        findViewById.setOnClickListener(new b());
        this.C.setDragView(findViewById);
        ImageView imageView = (ImageView) this.C.findViewById(R.id.f166529fw3);
        View findViewById2 = this.E.findViewById(R.id.c3p);
        this.C.setSlidePanelListener(new c(this.E.findViewById(R.id.bn7), findViewById2, findViewById, imageView, this.E.findViewById(R.id.cas)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Dh() {
        this.C.U();
    }

    public static void Eh(Activity activity, int i3, String str, CameraPosition cameraPosition) {
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(activity, R.string.hh8, 0).show();
            return;
        }
        if (System.currentTimeMillis() - I < 1000) {
            return;
        }
        I = System.currentTimeMillis();
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
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) LocationPickFragment.class, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideInputMethod() {
        InputMethodManager inputMethodManager = (InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null && inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(((EditText) this.E.findViewById(R.id.et_search_keyword)).getWindowToken(), 0);
        }
    }

    private void initData() {
        com.tencent.mobileqq.mvvm.d checkAndAddLifeCycleFragment = ((ILifeCycleFragmentInjectApi) QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment(getActivity());
        LocationPickViewModel locationPickViewModel = (LocationPickViewModel) com.tencent.mobileqq.mvvm.h.b(checkAndAddLifeCycleFragment, LocationPickViewModel.G).get(LocationPickViewModel.class);
        this.G = locationPickViewModel;
        this.F = new com.tencent.mobileqq.location.ui.e(locationPickViewModel, checkAndAddLifeCycleFragment);
        Intent intent = getActivity().getIntent();
        this.H = new LocationRoom.b(intent.getIntExtra("uintype", -1), intent.getStringExtra("uin"));
    }

    private void initView() {
        zh();
        QBaseActivity qBaseActivity = getQBaseActivity();
        this.E.findViewById(R.id.cau).setOnClickListener(new d(qBaseActivity));
        this.E.findViewById(R.id.cax).setOnClickListener(new e(qBaseActivity));
        Bh();
        Ch();
        XListView xListView = (XListView) this.E.findViewById(R.id.fw_);
        MapWidget mapWidget = (MapWidget) this.E.findViewById(R.id.lrc);
        this.D = mapWidget;
        MapUtils.i(mapWidget, "\u5730\u56fe \u4f60\u6b63\u5728\u5171\u4eab\u4f4d\u7f6e");
        ImageView imageView = (ImageView) this.E.findViewById(R.id.lrh);
        MapUtils.i(imageView, "\u5728\u5730\u56fe\u533a\u56de\u5230\u6211\u7684\u4f4d\u7f6e");
        Intent intent = qBaseActivity.getIntent();
        this.F.k(qBaseActivity, this.H, CameraPosition.fromLatLngZoom((LatLng) intent.getParcelableExtra("key_last_position"), intent.getFloatExtra("key_last_zoom", 0.0f)), this.D, imageView, this.E.findViewById(R.id.cax), this.C, xListView, this.E.findViewById(R.id.f166531c92), this.E.findViewById(R.id.c3n));
        View findViewById = this.E.findViewById(R.id.f164945lf2);
        View findViewById2 = this.E.findViewById(R.id.c3p);
        if (az.f()) {
            findViewById.setVisibility(0);
            findViewById2.setBackgroundColor(Color.parseColor("#CC000000"));
        } else {
            findViewById.setVisibility(8);
            findViewById2.setBackgroundColor(Color.parseColor("#7F000000"));
        }
    }

    private void yh() {
        if (az.f()) {
            this.E.findViewById(R.id.fwb).setBackgroundResource(R.drawable.bg_texture);
        }
    }

    private void zh() {
        ((ILiuHaiUtilsApi) QRoute.api(ILiuHaiUtilsApi.class)).initLiuHaiProperty(getActivity());
        int statusBarHeight = ((IImmersiveUtilsApi) QRoute.api(IImmersiveUtilsApi.class)).getStatusBarHeight(getActivity());
        View findViewById = this.E.findViewById(R.id.c3p);
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

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 4 && this.C.n()) {
            this.C.i();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        getActivity().setResult(0);
        getActivity().overridePendingTransition(0, R.anim.f154550b4);
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        PoiSlideBottomPanel poiSlideBottomPanel = this.C;
        if (poiSlideBottomPanel != null) {
            poiSlideBottomPanel.r(configuration);
            this.C.post(new Runnable() { // from class: com.tencent.mobileqq.location.ui.j
                @Override // java.lang.Runnable
                public final void run() {
                    LocationPickFragment.this.Dh();
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @SuppressLint({"InflateParams"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            view = (View) iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("LocationPickFragment", 2, "[location_fragment]onCreateView: invoked. this: " + this + " activity: " + getActivity());
            }
            this.E = layoutInflater.inflate(R.layout.f167974lv, (ViewGroup) null);
            getActivity().overridePendingTransition(R.anim.f154548b2, R.anim.f154550b4);
            view = this.E;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationPickFragment", 2, "[location_fragment]onPause: invoked. this: " + this + " isFinishing: " + getActivity().isFinishing() + " activity: " + getActivity());
        }
        super.onPause();
        MapWidget mapWidget = this.D;
        if (mapWidget != null) {
            mapWidget.onPause();
        }
        if (getActivity().isFinishing()) {
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.location.ui.LocationPickFragment.12
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocationPickFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (LocationPickFragment.this.D != null) {
                        LocationPickFragment.this.D.onStop();
                        LocationPickFragment.this.D.onDestroy();
                        LocationPickFragment.this.D = null;
                    }
                    if (LocationPickFragment.this.F != null) {
                        LocationPickFragment.this.F.n();
                        LocationPickFragment.this.F = null;
                    }
                }
            }, 200L);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationPickFragment", 2, "[location_fragment]onResume: invoked. this: " + this + " activity: " + getActivity());
        }
        super.onResume();
        MapWidget mapWidget = this.D;
        if (mapWidget != null) {
            mapWidget.onResume();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationPickFragment", 2, "[location_fragment]onStart: invoked. this: " + this + " activity: " + getActivity());
        }
        super.onStart();
        MapWidget mapWidget = this.D;
        if (mapWidget != null) {
            mapWidget.onStart();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationPickFragment", 2, "[location_fragment]onStop: invoked. this: " + this + " activity: " + getActivity());
        }
        super.onStop();
        MapWidget mapWidget = this.D;
        if (mapWidget != null) {
            mapWidget.onStop();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationPickFragment", 2, "[location_fragment]onViewCreated: invoked. this: " + this + " activity: " + getActivity());
        }
        super.onViewCreated(view, bundle);
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_LOCATION, QQPermissionConstants.Business.SCENE.SHARE_PICK_LOCATION));
        if (com.tencent.mobileqq.location.util.a.a(qQPermission)) {
            qQPermission.requestPermissions(com.tencent.mobileqq.location.util.a.f241701a, 2, new a(qQPermission, getQBaseActivity()));
        } else {
            Ah();
        }
        yh();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        super.onWindowFocusChanged(z16);
        PoiSlideBottomPanel poiSlideBottomPanel = this.C;
        if (poiSlideBottomPanel != null) {
            poiSlideBottomPanel.i();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean overrideFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        boolean overrideFinish = super.overrideFinish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, R.anim.f154550b4);
        }
        return overrideFinish;
    }
}

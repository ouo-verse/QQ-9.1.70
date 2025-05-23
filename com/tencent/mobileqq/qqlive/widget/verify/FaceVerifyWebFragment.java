package com.tencent.mobileqq.qqlive.widget.verify;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.verified.IQQLiveDataStore;
import com.tencent.mobileqq.qqlive.api.verified.IQQLiveVerifyFloatService;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.mobileqq.webview.swift.u;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppActivity;

/* compiled from: P */
/* loaded from: classes17.dex */
public class FaceVerifyWebFragment extends WebViewFragment implements com.tencent.mobileqq.webview.swift.h {
    static IPatchRedirector $redirector_;
    private static final String[] G;
    private QQCustomDialog C;
    private String D;
    private QQPermission E;
    private BusinessConfig F;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppActivity f274066a;

        a(AppActivity appActivity) {
            this.f274066a = appActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FaceVerifyWebFragment.this, (Object) appActivity);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (this.f274066a != null && ((IQQLiveVerifyFloatService) QRoute.api(IQQLiveVerifyFloatService.class)).checkFloatingBallPermission(this.f274066a)) {
                ((IQQLiveVerifyFloatService) QRoute.api(IQQLiveVerifyFloatService.class)).showFloatingBall(this.f274066a);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                FaceVerifyWebFragment.this.th();
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FaceVerifyWebFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).openPermissionActivity(FaceVerifyWebFragment.this.getActivity());
            dialogInterface.dismiss();
            FaceVerifyWebFragment.this.C = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FaceVerifyWebFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            dialogInterface.dismiss();
            FaceVerifyWebFragment.this.C = null;
            FaceVerifyWebFragment.this.getActivity().finish();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41080);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            G = new String[]{QQPermissionConstants.Permission.CAMERA, "android.permission.ACCESS_WIFI_STATE", "android.permission.ACCESS_NETWORK_STATE", QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.RECORD_AUDIO};
        }
    }

    public FaceVerifyWebFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.F = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_LIVE, QQPermissionConstants.Business.SCENE.QQ_LIVE_GAME);
        }
    }

    public static FaceVerifyWebFragment rh(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("intent", intent);
        FaceVerifyWebFragment faceVerifyWebFragment = new FaceVerifyWebFragment();
        faceVerifyWebFragment.setArguments(bundle);
        return faceVerifyWebFragment;
    }

    @TargetApi(24)
    private void sh() {
        if (this.E == null) {
            return;
        }
        this.E.requestPermissions(G, 2, new a((AppActivity) getActivity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th() {
        if (this.C == null) {
            this.C = DialogUtil.createCustomDialog(getActivity(), 230, (String) null, "\u8bf7\u5230\u5e94\u7528\u6743\u9650\u4e2d\u6253\u5f00: \u76f8\u673a\uff0c\u5b58\u50a8\uff0c\u5f55\u97f3\u6743\u9650, \u60ac\u6d6e\u7403", "\u53d6\u6d88", "\u53bb\u8bbe\u7f6e", new b(), new c());
        }
        if (!this.C.isShowing()) {
            this.C.show();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public WebViewWrapper createWebViewWrapper(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (WebViewWrapper) iPatchRedirector.redirect((short) 7, (Object) this, z16);
        }
        return new e(getActivity(), getWebViewKernelCallBack(), this.intent, z16);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            super.doOnActivityResult(i3, i16, intent);
            m.c().h(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.h
    public WebViewFragment newInstance(int i3, u uVar, WebViewTabBarData webViewTabBarData, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (WebViewFragment) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), uVar, webViewTabBarData, intent);
        }
        return rh(intent);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        this.D = this.intent.getStringExtra("extra_web_verify_app_id");
        ((IQQLiveDataStore) QRoute.api(IQQLiveDataStore.class)).setAppId(this.D);
        com.tencent.mobileqq.qqlive.widget.a.b().g(BaseApplication.getContext(), this.D, getUrl());
        this.E = QQPermissionFactory.getQQPermission(this, this.F);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        ((IQQLiveVerifyFloatService) QRoute.api(IQQLiveVerifyFloatService.class)).hideFloatingBall(getContext());
        try {
            l.f274086a.g(-1, "fragment destroy");
        } catch (Throwable th5) {
            QLog.e("FaceVerifyWebFragment", 1, th5, new Object[0]);
        }
        ((IQQLiveDataStore) QRoute.api(IQQLiveDataStore.class)).clear();
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onStart();
            sh();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) bundle);
        } else {
            super.onViewCreated(view, bundle);
        }
    }
}

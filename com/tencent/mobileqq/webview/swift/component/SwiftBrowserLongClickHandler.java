package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;
import androidx.core.util.Consumer;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IMiniCodeApi;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.ActionSheet;
import cooperation.qqfav.QfavBuilder;
import java.io.File;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SwiftBrowserLongClickHandler extends b.C8976b {
    static IPatchRedirector $redirector_;
    int C;
    String D;
    int E;
    String F;
    ScannerResult G;
    Object H;
    private QQPermission I;

    /* renamed from: e, reason: collision with root package name */
    public ActionSheet f314239e;

    /* renamed from: f, reason: collision with root package name */
    String f314240f;

    /* renamed from: h, reason: collision with root package name */
    QQProgressDialog f314241h;

    /* renamed from: i, reason: collision with root package name */
    CookieManager f314242i;

    /* renamed from: m, reason: collision with root package name */
    Activity f314243m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements ActionSheet.OnButtonClickListenerV2 {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftBrowserLongClickHandler.this);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListenerV2
        public void OnClick(View view, int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), str);
                return;
            }
            if (str != null) {
                SwiftBrowserLongClickHandler swiftBrowserLongClickHandler = SwiftBrowserLongClickHandler.this;
                if (swiftBrowserLongClickHandler.f314241h == null) {
                    SwiftBrowserLongClickHandler swiftBrowserLongClickHandler2 = SwiftBrowserLongClickHandler.this;
                    swiftBrowserLongClickHandler.f314241h = new QQProgressDialog(swiftBrowserLongClickHandler2.f314243m, swiftBrowserLongClickHandler2.C);
                    SwiftBrowserLongClickHandler.this.f314241h.setMessage(R.string.c7z);
                }
                SwiftBrowserLongClickHandler.this.f314241h.show();
                if (str.equals(SwiftBrowserLongClickHandler.this.f314243m.getString(R.string.f170643x5))) {
                    if (TextUtils.isEmpty(SwiftBrowserLongClickHandler.this.D)) {
                        SwiftBrowserLongClickHandler.this.E = 0;
                    } else {
                        QQProgressDialog qQProgressDialog = SwiftBrowserLongClickHandler.this.f314241h;
                        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                            SwiftBrowserLongClickHandler.this.f314241h.dismiss();
                        }
                        SwiftBrowserLongClickHandler swiftBrowserLongClickHandler3 = SwiftBrowserLongClickHandler.this;
                        swiftBrowserLongClickHandler3.h(swiftBrowserLongClickHandler3.D);
                    }
                } else if (str.equals(SwiftBrowserLongClickHandler.this.f314243m.getString(R.string.f170642x4))) {
                    if (TextUtils.isEmpty(SwiftBrowserLongClickHandler.this.D)) {
                        SwiftBrowserLongClickHandler.this.E = 1;
                    } else {
                        SwiftBrowserLongClickHandler swiftBrowserLongClickHandler4 = SwiftBrowserLongClickHandler.this;
                        swiftBrowserLongClickHandler4.n(swiftBrowserLongClickHandler4.D);
                    }
                } else if (str.equals(SwiftBrowserLongClickHandler.this.f314243m.getString(R.string.bsr))) {
                    QQProgressDialog qQProgressDialog2 = SwiftBrowserLongClickHandler.this.f314241h;
                    if (qQProgressDialog2 != null && qQProgressDialog2.isShowing()) {
                        SwiftBrowserLongClickHandler.this.f314241h.dismiss();
                    }
                    SwiftBrowserLongClickHandler swiftBrowserLongClickHandler5 = SwiftBrowserLongClickHandler.this;
                    swiftBrowserLongClickHandler5.j(swiftBrowserLongClickHandler5.D, 1);
                } else if (str.equals(SwiftBrowserLongClickHandler.this.f314243m.getString(R.string.bsq))) {
                    QQProgressDialog qQProgressDialog3 = SwiftBrowserLongClickHandler.this.f314241h;
                    if (qQProgressDialog3 != null && qQProgressDialog3.isShowing()) {
                        SwiftBrowserLongClickHandler.this.f314241h.dismiss();
                    }
                    SwiftBrowserLongClickHandler swiftBrowserLongClickHandler6 = SwiftBrowserLongClickHandler.this;
                    swiftBrowserLongClickHandler6.j(swiftBrowserLongClickHandler6.D, 2);
                } else if (str.equals(SwiftBrowserLongClickHandler.this.f314243m.getString(R.string.f170644x7))) {
                    if (TextUtils.isEmpty(SwiftBrowserLongClickHandler.this.D)) {
                        SwiftBrowserLongClickHandler.this.E = 2;
                    } else {
                        QQProgressDialog qQProgressDialog4 = SwiftBrowserLongClickHandler.this.f314241h;
                        if (qQProgressDialog4 != null && qQProgressDialog4.isShowing()) {
                            SwiftBrowserLongClickHandler.this.f314241h.dismiss();
                        }
                        SwiftBrowserLongClickHandler swiftBrowserLongClickHandler7 = SwiftBrowserLongClickHandler.this;
                        swiftBrowserLongClickHandler7.o(swiftBrowserLongClickHandler7.D);
                    }
                } else if (str.equals(SwiftBrowserLongClickHandler.this.f314243m.getString(R.string.bsh))) {
                    QQProgressDialog qQProgressDialog5 = SwiftBrowserLongClickHandler.this.f314241h;
                    if (qQProgressDialog5 != null && qQProgressDialog5.isShowing()) {
                        SwiftBrowserLongClickHandler.this.f314241h.dismiss();
                    }
                    if (!TextUtils.isEmpty(SwiftBrowserLongClickHandler.this.D)) {
                        QfavBuilder.e0(new File(SwiftBrowserLongClickHandler.this.D).getAbsolutePath()).h(SwiftBrowserLongClickHandler.this.f314243m, ((TeamWorkDocEditBrowserActivity) SwiftBrowserLongClickHandler.this.f314243m).f177177a0.getCurrentAccountUin());
                    }
                }
                SwiftBrowserLongClickHandler.this.f314239e.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftBrowserLongClickHandler.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f314253a;

        c(String str) {
            this.f314253a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftBrowserLongClickHandler.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                SwiftBrowserLongClickHandler.this.i(this.f314253a);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
                return;
            }
            QQProgressDialog qQProgressDialog = SwiftBrowserLongClickHandler.this.f314241h;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                SwiftBrowserLongClickHandler.this.f314241h.dismiss();
            }
            QLog.d("SwiftBrowserLongClickHandler", 1, "User requestPermissions " + list + list2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements Consumer<RFWSaveMediaResultBean> {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftBrowserLongClickHandler.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(RFWSaveMediaResultBean rFWSaveMediaResultBean) {
            if (rFWSaveMediaResultBean != null && rFWSaveMediaResultBean.isSuccess) {
                String str = rFWSaveMediaResultBean.savePath;
                QLog.d("SwiftBrowserLongClickHandler", 1, "moveImageToRealPath suc path=" + str);
                QQProgressDialog qQProgressDialog = SwiftBrowserLongClickHandler.this.f314241h;
                if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                    SwiftBrowserLongClickHandler.this.f314241h.dismiss();
                }
                QQToast.makeText(SwiftBrowserLongClickHandler.this.f314243m.getApplicationContext(), 2, SwiftBrowserLongClickHandler.this.f314243m.getString(R.string.g2r, str), 1).show(SwiftBrowserLongClickHandler.this.C);
                return;
            }
            QLog.d("SwiftBrowserLongClickHandler", 1, "moveImageToRealPath fail");
            QQToast.makeText(SwiftBrowserLongClickHandler.this.f314243m.getApplicationContext(), 1, SwiftBrowserLongClickHandler.this.f314243m.getString(R.string.g2q), 1).show(SwiftBrowserLongClickHandler.this.C);
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void accept(final RFWSaveMediaResultBean rFWSaveMediaResultBean) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rFWSaveMediaResultBean);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.component.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        SwiftBrowserLongClickHandler.d.this.c(rFWSaveMediaResultBean);
                    }
                });
            }
        }
    }

    public SwiftBrowserLongClickHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.C = 0;
        this.E = -1;
        this.H = new Object();
    }

    private void l(String str) {
        if (this.f314243m.isFinishing()) {
            return;
        }
        ThreadManagerV2.excute(new Runnable(str) { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f314244d;

            {
                this.f314244d = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftBrowserLongClickHandler.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                SwiftBrowserLongClickHandler swiftBrowserLongClickHandler;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Bundle bundle = new Bundle();
                SwiftBrowserLongClickHandler swiftBrowserLongClickHandler2 = SwiftBrowserLongClickHandler.this;
                if (swiftBrowserLongClickHandler2.f314242i == null) {
                    swiftBrowserLongClickHandler2.f314242i = CookieManager.getInstance();
                    SwiftBrowserLongClickHandler.this.f314242i.setAcceptCookie(true);
                }
                String cookie = SwiftBrowserLongClickHandler.this.f314242i.getCookie(this.f314244d);
                if (cookie != null) {
                    bundle.putString("Cookie", cookie);
                    if (QLog.isColorLevel()) {
                        QLog.d("SwiftBrowserLongClickHandler", 2, "Get cookie: " + com.tencent.biz.common.util.k.e(cookie, new String[0]) + " from " + com.tencent.biz.common.util.k.f(this.f314244d, new String[0]));
                    }
                }
                String e16 = com.tencent.biz.common.util.e.e(BaseApplication.getContext(), this.f314244d, bundle);
                SwiftBrowserLongClickHandler.this.D = e16;
                if (QLog.isColorLevel()) {
                    QLog.d("SwiftBrowserLongClickHandler", 2, "saveImage filepath = " + SwiftBrowserLongClickHandler.this.D);
                }
                if (e16 == null) {
                    SwiftBrowserLongClickHandler.this.f314243m.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.4.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            QQProgressDialog qQProgressDialog = SwiftBrowserLongClickHandler.this.f314241h;
                            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                                SwiftBrowserLongClickHandler.this.f314241h.dismiss();
                            }
                            QQToast.makeText(SwiftBrowserLongClickHandler.this.f314243m.getApplicationContext(), 1, R.string.g2q, 1).show(SwiftBrowserLongClickHandler.this.C);
                        }
                    });
                    return;
                }
                SwiftBrowserLongClickHandler swiftBrowserLongClickHandler3 = SwiftBrowserLongClickHandler.this;
                int i3 = swiftBrowserLongClickHandler3.E;
                if (i3 == 0) {
                    swiftBrowserLongClickHandler3.h(e16);
                    SwiftBrowserLongClickHandler.this.f314243m.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.4.2
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            QQProgressDialog qQProgressDialog = SwiftBrowserLongClickHandler.this.f314241h;
                            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                                SwiftBrowserLongClickHandler.this.f314241h.dismiss();
                            }
                        }
                    });
                    return;
                }
                if (i3 == 1) {
                    swiftBrowserLongClickHandler3.n(e16);
                    return;
                }
                if (i3 == 2) {
                    swiftBrowserLongClickHandler3.o(e16);
                    return;
                }
                ScannerResult decodeQQCodeFromFile = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile(Uri.parse("file://" + new File(e16).getAbsolutePath()), (Context) SwiftBrowserLongClickHandler.this.f314243m, 3, false);
                if (decodeQQCodeFromFile != null) {
                    synchronized (SwiftBrowserLongClickHandler.this.H) {
                        swiftBrowserLongClickHandler = SwiftBrowserLongClickHandler.this;
                        swiftBrowserLongClickHandler.F = swiftBrowserLongClickHandler.D;
                        swiftBrowserLongClickHandler.G = decodeQQCodeFromFile;
                    }
                    if (swiftBrowserLongClickHandler.f314239e.isShowing()) {
                        SwiftBrowserLongClickHandler.this.f314243m.runOnUiThread(new Runnable(decodeQQCodeFromFile) { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.4.3
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ ScannerResult f314247d;

                            {
                                this.f314247d = decodeQQCodeFromFile;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this, (Object) decodeQQCodeFromFile);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("SwiftBrowserLongClickHandler", 2, "showQR Button");
                                }
                                if (this.f314247d.l()) {
                                    SwiftBrowserLongClickHandler.this.f314239e.addButton(R.string.bsr);
                                }
                                if (this.f314247d.j()) {
                                    SwiftBrowserLongClickHandler.this.f314239e.addButton(R.string.bsq);
                                }
                                SwiftBrowserLongClickHandler.this.f314239e.updateAllButton();
                            }
                        });
                    }
                }
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        if (this.I == null) {
            this.I = QQPermissionFactory.getQQPermission(this.f314243m, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_WEBVIEW, QQPermissionConstants.Business.SCENE.WEBVIEW_MEDIA));
        }
        if (this.I.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            this.I.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new c(str));
        } else {
            i(str);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.C8976b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.e();
        Activity activity = this.f314441d.getActivity();
        this.f314243m = activity;
        if (activity instanceof QQBrowserActivity) {
            this.C = ((QQBrowserActivity) activity).getTitleBarHeight();
        }
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SwiftBrowserLongClickHandler.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).init(SwiftBrowserLongClickHandler.this.f314441d.getActivity(), SwiftBrowserLongClickHandler.this.hashCode(), "SwiftBrowserLongClickHandler");
                }
            }
        }, null, true);
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.C8976b
    public void f(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) bundle);
            return;
        }
        if (i3 == 3) {
            ActionSheet actionSheet = this.f314239e;
            if (actionSheet != null && actionSheet.isShowing()) {
                this.f314239e.dismiss();
            }
            ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).unInit(hashCode(), "SwiftBrowserLongClickHandler");
        }
    }

    void h(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, str);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, str);
        bundle.putBoolean("not_forward", true);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, str);
        bundle.putBoolean("isFromShare", true);
        bundle.putBoolean("isJumpAIO", true);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        ForwardBaseOption.startForwardActivityForResult(this.f314243m, intent, 21);
    }

    void i(String str) {
        RFWSaveUtil.insertMedia(BaseApplication.getContext(), str, new d());
    }

    void j(String str, int i3) {
        Intent intent = new Intent();
        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
        intent.putExtra("detectType", i3);
        intent.putExtra("fromPicQRDecode", true);
        intent.putExtra("preScanResult", this.G);
        String str2 = this.f314240f;
        if (!TextUtils.isEmpty(str2) && str2.startsWith("data:")) {
            str2 = "";
        }
        intent.putExtra("report_params", ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(null, str2, null, null, null, 5));
        RouteUtils.startActivity(this.f314243m, intent, "/qrscan/scanner");
    }

    public boolean k() {
        boolean z16;
        boolean z17;
        ScannerResult scannerResult;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        QQProgressDialog qQProgressDialog = this.f314241h;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f314241h.dismiss();
        }
        synchronized (this.H) {
            if (!TextUtils.isEmpty(this.F) && this.F.equals(this.D) && (scannerResult = this.G) != null) {
                z16 = scannerResult.l();
                z17 = this.G.j();
            } else {
                z16 = false;
                z17 = false;
            }
        }
        if (z16) {
            j(this.D, 1);
            return true;
        }
        if (z17) {
            j(this.D, 2);
            return true;
        }
        QQToast.makeText(this.f314243m.getApplicationContext(), 1, R.string.f170426qi, 1).show(this.C);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m(View view) {
        boolean z16;
        int i3;
        String extra;
        IX5WebViewExtension x5WebViewExtension;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view)).booleanValue();
        }
        Activity activity = this.f314243m;
        if (activity != null && !activity.isFinishing()) {
            b.c cVar = this.f314441d;
            String str = "";
            if (cVar != null && cVar.getWebView() != null) {
                WebView webView = this.f314441d.getWebView();
                IX5WebViewBase.HitTestResult x5HitTestResult = webView.getX5HitTestResult();
                if (x5HitTestResult != null) {
                    i3 = x5HitTestResult.getType();
                    if (i3 == 8) {
                        if (x5HitTestResult.getData() instanceof IX5WebViewBase.HitTestResult.ImageAnchorData) {
                            extra = ((IX5WebViewBase.HitTestResult.ImageAnchorData) x5HitTestResult.getData()).mPicUrl;
                        }
                        x5WebViewExtension = webView.getX5WebViewExtension();
                        if (x5WebViewExtension == null) {
                            Boolean bool = (Boolean) x5WebViewExtension.invokeMiscMethod("supportImageQuery", new Bundle());
                            if (bool != null) {
                                z16 = bool.booleanValue();
                            } else {
                                QLog.e("SwiftBrowserLongClickHandler", 1, "X5WebView supportImageQuery invoke result is null.");
                                z16 = false;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("SwiftBrowserLongClickHandler", 2, "isSupportImageQuery:" + z16);
                            }
                        } else {
                            QLog.e("SwiftBrowserLongClickHandler", 1, "X5WebView extension is null. can't get ability of supportImageQuery");
                            z16 = false;
                        }
                    } else {
                        extra = x5HitTestResult.getExtra();
                    }
                } else {
                    WebView.HitTestResult hitTestResult = webView.getHitTestResult();
                    if (hitTestResult == null) {
                        return false;
                    }
                    i3 = hitTestResult.getType();
                    extra = hitTestResult.getExtra();
                }
                str = extra;
                x5WebViewExtension = webView.getX5WebViewExtension();
                if (x5WebViewExtension == null) {
                }
            } else if (view instanceof android.webkit.WebView) {
                WebView.HitTestResult hitTestResult2 = ((android.webkit.WebView) view).getHitTestResult();
                if (hitTestResult2 == null) {
                    return false;
                }
                i3 = hitTestResult2.getType();
                str = hitTestResult2.getExtra();
                z16 = false;
            } else {
                z16 = false;
                i3 = 0;
            }
            if (i3 != 8 && i3 != 5) {
                QLog.e("SwiftBrowserLongClickHandler", 1, "the type of HitTestResult is not image type.");
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                QLog.e("SwiftBrowserLongClickHandler", 1, "the image url of HitTestResult is empty.");
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserLongClickHandler", 2, "showActionSheet");
            }
            this.f314240f = str;
            Activity activity2 = this.f314243m;
            boolean z17 = activity2 instanceof TeamWorkDocEditBrowserActivity;
            ActionSheet createMenuSheet = ActionSheet.createMenuSheet(activity2);
            this.f314239e = createMenuSheet;
            if (z16) {
                createMenuSheet.addButton(R.string.f170644x7);
            }
            this.f314239e.addButton(R.string.f170643x5);
            this.f314239e.addButton(R.string.f170642x4);
            if (z17) {
                this.f314239e.addButton(R.string.bsh);
            }
            this.f314239e.addCancelButton(R.string.cancel);
            l(this.f314240f);
            this.f314239e.setOnButtonClickListenerV2(new a());
            this.f314239e.setOnDismissListener(new b());
            this.f314239e.setCanceledOnTouchOutside(true);
            try {
                this.f314239e.show();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return true;
    }

    void o(String str) {
        b.c cVar = this.f314441d;
        if (cVar == null) {
            QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. mComponentContext is null");
            return;
        }
        com.tencent.smtt.sdk.WebView webView = cVar.getWebView();
        if (webView == null) {
            QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. x5WebView is null");
            return;
        }
        IX5WebViewExtension x5WebViewExtension = webView.getX5WebViewExtension();
        if (x5WebViewExtension == null) {
            QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. extension is null");
        } else if (TextUtils.isEmpty(str)) {
            QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. filePath is null");
        } else {
            ThreadManagerV2.excute(new Runnable(str, x5WebViewExtension) { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f314249d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ IX5WebViewExtension f314250e;

                {
                    this.f314249d = str;
                    this.f314250e = x5WebViewExtension;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, SwiftBrowserLongClickHandler.this, str, x5WebViewExtension);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    boolean z16 = false;
                    String str2 = null;
                    try {
                        byte[] readFile = FileUtils.readFile(this.f314249d);
                        if (readFile != null) {
                            str2 = Base64.encodeToString(readFile, 0);
                        } else {
                            QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. FileUtils.readFile returns null, filepath:" + this.f314249d);
                        }
                    } catch (Exception e16) {
                        QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. read from filePath error", e16);
                    }
                    if (str2 != null) {
                        Bundle bundle = new Bundle();
                        bundle.putCharSequence("imageBase64", str2);
                        Boolean bool = (Boolean) this.f314250e.invokeMiscMethod("imageQuery", bundle);
                        if (bool != null) {
                            z16 = bool.booleanValue();
                        }
                        QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. query result:" + z16);
                    }
                }
            }, 64, null, true);
        }
    }
}

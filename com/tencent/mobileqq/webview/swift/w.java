package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.comic.api.IQQComicWebViewApi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class w implements com.tencent.mobileqq.colornote.f {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private IColorNoteController f314829d;

    /* renamed from: e, reason: collision with root package name */
    private ColorNote f314830e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f314831f;

    /* renamed from: h, reason: collision with root package name */
    protected QQBrowserActivity f314832h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements ha1.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) w.this);
            }
        }

        @Override // ha1.a
        public void onColorNoteAnimFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                w.this.f314832h.doFinish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements com.tencent.mobileqq.colornote.swipe.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) w.this);
            }
        }

        @Override // com.tencent.mobileqq.colornote.swipe.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QLog.d("WebColorNoteController", 1, "onPageSwipeNotClose");
            }
        }

        @Override // com.tencent.mobileqq.colornote.swipe.a
        public void onPageSwipeClose() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QLog.d("WebColorNoteController", 1, "onPageSwipeClose");
            }
        }
    }

    public w(@NonNull QQBrowserActivity qQBrowserActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQBrowserActivity);
        } else {
            this.f314831f = true;
            this.f314832h = qQBrowserActivity;
        }
    }

    private void f(IColorNoteSwipeLayout iColorNoteSwipeLayout) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("WebColorNoteController", 2, "QQBrowserActivity initColorNote.");
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        boolean z17 = false;
        if (runtime != null && runtime.isLogin()) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean isDisableSwipeByUrl = true ^ ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).isDisableSwipeByUrl(this.f314832h.getOriginalUrl());
        if (((IQQComicWebViewApi) QRoute.api(IQQComicWebViewApi.class)).isBoodoUrl(this.f314832h.getOriginalUrl())) {
            if (QLog.isColorLevel()) {
                QLog.d("WebColorNoteController", 2, "This is boodo url ,disable swipe.");
            }
            isDisableSwipeByUrl = false;
        }
        if (!((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).isUrlBlocked(this.f314832h.getOriginalUrl()) && !TextUtils.isEmpty(this.f314832h.getOriginalUrl())) {
            z17 = isDisableSwipeByUrl;
        }
        if (z16) {
            IColorNoteController iColorNoteController = (IColorNoteController) QRoute.api(IColorNoteController.class);
            this.f314829d = iColorNoteController;
            if (z17) {
                iColorNoteController.init(this.f314832h, true, false, iColorNoteSwipeLayout, true, true, false, R.color.f156954am1);
            } else {
                iColorNoteController.init(this.f314832h, false, true, iColorNoteSwipeLayout, true, true, false, R.color.f156954am1);
            }
            this.f314829d.attachToActivity(this.f314832h);
            this.f314829d.setServiceInfo(this);
            this.f314830e = getColorNote();
            this.f314829d.setOnColorNoteAnimFinishListener(new a());
            this.f314829d.setOnPageSwipeListener(new b());
            this.f314829d.doSetPropertiesFromWebView(this.f314832h.getOriginalUrl());
        }
    }

    private void o(int i3) {
        if (QLog.isDevelopLevel()) {
            if (i3 == 16908288) {
                QLog.d("WebColorNoteController", 4, "QQBrowserActivity getColorNote,serviceType is ColorNoteConstants.ServiceType.WEB.");
            }
            if (i3 == 16908292) {
                QLog.d("WebColorNoteController", 4, "QQBrowserActivity getColorNote,serviceType is ColorNoteConstants.ServiceType.BODONG.");
            }
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        IColorNoteController iColorNoteController = this.f314829d;
        if (iColorNoteController != null) {
            if (!iColorNoteController.isColorNoteExist()) {
                if (this.f314829d.canAddColorNote()) {
                    this.f314829d.insertColorNote();
                    this.f314832h.finish();
                    return;
                } else {
                    this.f314829d.onCannotAdd();
                    return;
                }
            }
            this.f314829d.deleteColorNote();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.f314831f = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.f314831f = true;
        }
    }

    public IColorNoteController d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (IColorNoteController) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f314829d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            f(null);
        }
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        IColorNoteController iColorNoteController = this.f314829d;
        if (iColorNoteController != null && iColorNoteController.isColorNoteExist()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    @Override // com.tencent.mobileqq.colornote.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ColorNote getColorNote() {
        String str;
        String str2;
        String str3;
        int i3;
        String str4;
        String e16;
        String A;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ColorNote) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Intent intent = this.f314832h.getIntent();
        WebViewFragment currentWebViewFragment = this.f314832h.getCurrentWebViewFragment();
        String str5 = "";
        if (currentWebViewFragment != null && currentWebViewFragment.getAppRuntime() != null) {
            Share share = (Share) currentWebViewFragment.getShare();
            if (!TextUtils.isEmpty(share.B())) {
                e16 = share.B();
            } else {
                if (currentWebViewFragment.getSwiftTitleUI() != null) {
                    try {
                        e16 = currentWebViewFragment.getSwiftTitleUI().e();
                    } catch (Exception e17) {
                        QLog.e("WebColorNoteController", 2, "fragment.mSwiftTitleUI.getTitle()", e17);
                    }
                }
                str = share.x();
                A = share.A();
                if (TextUtils.isEmpty(A)) {
                    A = ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).getWebViewIconUrl(this.f314832h.getOriginalUrl());
                }
                str3 = str5;
                str2 = A;
            }
            str5 = e16;
            str = share.x();
            A = share.A();
            if (TextUtils.isEmpty(A)) {
            }
            str3 = str5;
            str2 = A;
        } else {
            str = null;
            str2 = null;
            str3 = "";
        }
        ColorNote colorNote = this.f314830e;
        if (colorNote != null && colorNote.isTitleAndPicValid()) {
            if (!TextUtils.isEmpty(str3)) {
                this.f314830e.mMainTitle = str3;
            }
            if (!TextUtils.isEmpty(str)) {
                this.f314830e.mSubTitle = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                this.f314830e.mPicUrl = str2;
            }
            return this.f314830e;
        }
        WebView hostWebView = this.f314832h.getHostWebView();
        JSONObject jSONObject = new JSONObject();
        if (hostWebView != null) {
            try {
                jSONObject.put("key_scroll_y", hostWebView.getWebScrollY());
            } catch (JSONException e18) {
                QLog.e("WebColorNoteController", 1, e18, new Object[0]);
            }
        }
        String originalUrl = this.f314832h.getOriginalUrl();
        if (TextUtils.isEmpty(originalUrl)) {
            originalUrl = intent.getStringExtra(QCircleLpReportDc010001.KEY_SUBTYPE);
        }
        if (originalUrl == null || TextUtils.isEmpty(originalUrl)) {
            originalUrl = "unregistered service sub type";
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f314832h.getOriginalUrl();
            try {
                URL url = new URL(str);
                if (!TextUtils.isEmpty(url.getHost())) {
                    str = url.getHost();
                }
            } catch (RuntimeException e19) {
                QLog.e("WebColorNoteController", 1, e19, new Object[0]);
            } catch (MalformedURLException e26) {
                QLog.e("WebColorNoteController", 1, e26, new Object[0]);
            } catch (Exception e27) {
                QLog.e("WebColorNoteController", 1, e27, new Object[0]);
            }
        }
        String str6 = str;
        String originalUrl2 = this.f314832h.getOriginalUrl();
        IQQComicWebViewApi iQQComicWebViewApi = (IQQComicWebViewApi) QRoute.api(IQQComicWebViewApi.class);
        if (iQQComicWebViewApi.isBoodoUrl(originalUrl2)) {
            String addUrlField = iQQComicWebViewApi.addUrlField(iQQComicWebViewApi.replaceUrlFieldValueReg(iQQComicWebViewApi.addUrlField(originalUrl2, "from", "1041001"), "from", "1041001"), "openFromColorTab", "1");
            if (QLog.isColorLevel()) {
                QLog.d("WebColorNoteController", 2, "isBoodoUlr,serviceType is ColorNoteConstants.ServiceType.BODONG, original url is " + originalUrl2 + ", new url is " + addUrlField);
            }
            i3 = android.R.id.empty;
            str4 = addUrlField;
        } else {
            i3 = android.R.id.background;
            str4 = originalUrl;
        }
        o(i3);
        IColorNoteController iColorNoteController = this.f314829d;
        if (iColorNoteController != null) {
            ColorNote onGetColorNote = iColorNoteController.onGetColorNote(i3, str4, str3, str6, str2, jSONObject.toString().getBytes());
            this.f314830e = onGetColorNote;
            return onGetColorNote;
        }
        ColorNote a16 = new ColorNote.a().g(i3).i(str4).d(str3).h(str6).e(str2).f(jSONObject.toString().getBytes()).a();
        this.f314830e = a16;
        return a16;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        IColorNoteController iColorNoteController = this.f314829d;
        if (iColorNoteController != null && (iColorNoteController.isColorNoteExist() || this.f314829d.isSwipeBackExit())) {
            return true;
        }
        return false;
    }

    public void i(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
        } else if (this.f314831f) {
            e();
        }
    }

    public void j() {
        IColorNoteController iColorNoteController;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (this.f314831f && (iColorNoteController = this.f314829d) != null) {
            iColorNoteController.onDestroy();
        }
    }

    public void k() {
        IColorNoteController iColorNoteController;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.f314831f && (iColorNoteController = this.f314829d) != null) {
            iColorNoteController.onPause();
            if (this.f314832h.getIntent().getBooleanExtra("isFromFavourite", false)) {
                this.f314829d.addHistoryNote();
            }
        }
        if (((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).isUrlSmallScreenBlocked(this.f314832h.getOriginalUrl())) {
            ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(this.f314832h, 2, true);
            if (QLog.isColorLevel()) {
                QLog.d("WebColorNoteController", 2, "color note small screen visible by doOnPause");
            }
        }
    }

    public void l() {
        IColorNoteController iColorNoteController;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.f314831f && (iColorNoteController = this.f314829d) != null) {
            iColorNoteController.onResume();
        }
        if (((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).isUrlSmallScreenBlocked(this.f314832h.getOriginalUrl())) {
            ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(this.f314832h, 2, false);
            if (QLog.isColorLevel()) {
                QLog.d("WebColorNoteController", 2, "color note small screen invisible by doOnResume");
            }
        }
    }

    public void m(com.tencent.mobileqq.colornote.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) fVar);
            return;
        }
        IColorNoteController iColorNoteController = this.f314829d;
        if (iColorNoteController != null) {
            iColorNoteController.setServiceInfo(fVar);
        }
    }

    public boolean n() {
        IColorNoteController iColorNoteController;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (this.f314831f && (iColorNoteController = this.f314829d) != null) {
            iColorNoteController.exitAnimation();
            return true;
        }
        return false;
    }

    public boolean p(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str)).booleanValue();
        }
        IColorNoteController iColorNoteController = this.f314829d;
        if (iColorNoteController != null && iColorNoteController.shouldDisplayColorNote() && this.f314829d.hasShareEntr() && !((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).isUrlShareEntranceBlocked(str)) {
            return true;
        }
        return false;
    }
}

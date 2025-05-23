package com.tencent.mobileqq.intervideo.yiqikan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mediafocus.b;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.WebViewModule;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingWatchTogetherWrapper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nonnull;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    private static volatile g f238485j;

    /* renamed from: a, reason: collision with root package name */
    private volatile WatchTogetherFloatingData f238486a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f238487b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<c> f238488c;

    /* renamed from: d, reason: collision with root package name */
    private WebViewModule f238489d;

    /* renamed from: e, reason: collision with root package name */
    private WatchTogetherFloatingView f238490e;

    /* renamed from: f, reason: collision with root package name */
    private d f238491f;

    /* renamed from: g, reason: collision with root package name */
    private WeakReference<IVideoOuterStatusListener> f238492g;

    /* renamed from: h, reason: collision with root package name */
    private WatchTogetherFloatingData f238493h;

    /* renamed from: i, reason: collision with root package name */
    private long f238494i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements IVideoInnerStatusListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
            }
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoClose(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoSeek(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (g.this.f238491f != null) {
                com.tencent.mobileqq.mediafocus.b.i().l(1, g.this.f238491f);
            } else {
                g.this.n(false);
            }
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoStop() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements gh2.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private long f238496a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f238497b;

        b(Context context) {
            this.f238497b = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this, (Object) context);
            } else {
                this.f238496a = 0L;
            }
        }

        @Override // gh2.d
        public boolean onCloseClick() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (QLog.isColorLevel()) {
                QLog.d("WatchFloatingWindowController", 2, "onCloseClick");
            }
            if (g.this.f238486a == null) {
                return true;
            }
            if (g.this.f238486a.isIsAdm()) {
                f.m(this.f238497b, 5, g.this.f238486a.getCurUin());
            } else {
                ReportController.o(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_quit_member", 0, 0, g.this.f238486a.getCurUin(), "", "", "");
                g.this.g();
            }
            return true;
        }

        @Override // gh2.d
        public boolean onEnterClick(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
            }
            if (QLog.isColorLevel()) {
                QLog.d("WatchFloatingWindowController", 2, "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(i3), " centerY: ", Integer.valueOf(i16));
            }
            if (g.this.f238486a == null || g.this.f238490e == null) {
                return false;
            }
            if (System.currentTimeMillis() - this.f238496a < 1000) {
                if (QLog.isColorLevel()) {
                    QLog.d("WatchFloatingWindowController", 2, "click button too frequently pastTime=" + (System.currentTimeMillis() - this.f238496a));
                }
                return true;
            }
            this.f238496a = System.currentTimeMillis();
            int b16 = g.this.f238490e.b();
            if (b16 == 1) {
                tr2.g.i(this.f238497b, 1, g.this.f238486a.getBigUrl(), null, new Bundle(), g.this.f238486a.getCurType());
                g gVar = g.this;
                gVar.f(gVar.f238486a.getCurUin(), g.this.f238486a.getCurType(), false);
            } else if (b16 == 2) {
                g.this.f238490e.f(g.this.f238486a.getSmallUrl());
                ReportController.o(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_refresh", 0, 0, g.this.f238486a.getCurUin(), "", "", "");
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface c {
        void e(int i3);

        void m(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class d implements b.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<IVideoOuterStatusListener> f238499a;

        public d(WeakReference<IVideoOuterStatusListener> weakReference) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference);
            } else {
                this.f238499a = weakReference;
            }
        }

        private void c(boolean z16) {
            WeakReference<IVideoOuterStatusListener> weakReference = this.f238499a;
            if (weakReference != null && weakReference.get() != null) {
                IVideoOuterStatusListener iVideoOuterStatusListener = this.f238499a.get();
                if (z16) {
                    iVideoOuterStatusListener.onVideoStop();
                } else {
                    iVideoOuterStatusListener.onVideoStart(-1);
                }
            }
        }

        @Override // com.tencent.mobileqq.mediafocus.b.c
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            if (i3 != -2 && i3 != -1) {
                if (i3 == 1) {
                    QLog.i("WatchFloatingWindowController", 1, "onFocusChange: MEDIAFOCUS_GAIN");
                    g.k().n(false);
                    c(false);
                    return;
                }
                return;
            }
            QLog.i("WatchFloatingWindowController", 1, "onFocusChange: MEDIAFOCUS_LOSS");
            g.k().n(true);
            c(true);
        }

        public void b(WeakReference<IVideoOuterStatusListener> weakReference) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) weakReference);
            } else {
                this.f238499a = weakReference;
            }
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f238487b = false;
            this.f238494i = 0L;
        }
    }

    private boolean d(String str, int i3) {
        if (!TextUtils.isEmpty(str) && this.f238486a != null) {
            if (str.equals(this.f238486a.getCurUin()) && i3 == this.f238486a.getCurType()) {
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("WatchFloatingWindowController", 2, "closeFloatingWindow uin or type not match:mCurType=" + this.f238486a.getCurType() + " sessionType=" + i3 + " mCurUin=" + this.f238486a.getCurUin() + " uin=" + str);
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WatchFloatingWindowController", 2, "closeFloatingWindow uin is empty or data==null");
        }
        return false;
    }

    private int j(Context context, float f16) {
        int i3;
        FloatingScreenParams.FloatingBuilder floatingBuilder = new FloatingScreenParams.FloatingBuilder();
        if (f16 < 1.0f) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        FloatingScreenParams build = floatingBuilder.setShapeType(i3).setCanMove(true).setCanZoom(false).setRatio(f16).setFloatingCenter(300, -680).build();
        IQQFloatingWindow iQQFloatingWindow = (IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class);
        BaseApplication baseApplication = BaseApplication.context;
        WatchTogetherFloatingView watchTogetherFloatingView = this.f238490e;
        String str = FloatingWatchTogetherWrapper.CLASS_NAME;
        int enterWatchTogetherFloatingScreen = iQQFloatingWindow.enterWatchTogetherFloatingScreen(baseApplication, watchTogetherFloatingView, build, str);
        if (QLog.isColorLevel()) {
            QLog.d("WatchFloatingWindowController", 2, "createFloatWindow: invoked. ", " result: ", Integer.valueOf(enterWatchTogetherFloatingScreen));
        }
        if (enterWatchTogetherFloatingScreen == 1) {
            f.m(context, 4, this.f238486a.getCurUin());
            return enterWatchTogetherFloatingScreen;
        }
        this.f238492g = new WeakReference<>(((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).setFloatingVideoListener(new a(), str));
        ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).setWindowClickListener(str, new b(context));
        return 0;
    }

    public static g k() {
        if (f238485j == null) {
            synchronized (g.class) {
                if (f238485j == null) {
                    f238485j = new g();
                }
            }
        }
        return f238485j;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            if (this.f238486a == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("WatchFloatingWindowController", 2, "closeFloatingWindow, oooo");
                    return;
                }
                return;
            }
            f(this.f238486a.getCurUin(), this.f238486a.getCurType(), true);
        }
    }

    public void f(String str, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (!d(str, i3)) {
            return;
        }
        if (!this.f238487b) {
            if (QLog.isColorLevel()) {
                QLog.d("WatchFloatingWindowController", 2, "closeFloatingWindow, but isSuccessCreateFloatingView is false");
                return;
            }
            return;
        }
        this.f238486a = null;
        this.f238493h = null;
        WebViewModule webViewModule = this.f238489d;
        if (webViewModule != null) {
            webViewModule.onPause();
            this.f238489d.onDestroy();
            this.f238489d = null;
        }
        this.f238494i = 0L;
        this.f238490e = null;
        IQQFloatingWindow iQQFloatingWindow = (IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class);
        String str2 = FloatingWatchTogetherWrapper.CLASS_NAME;
        iQQFloatingWindow.quitFloatingScreen(str2);
        f.k(false, str, i3, z16);
        if (this.f238491f != null) {
            com.tencent.mobileqq.mediafocus.b.i().d(this.f238491f);
            this.f238491f = null;
        }
        this.f238492g = null;
        ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).setFloatingVideoListener(null, str2);
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f238486a == null) {
            return;
        }
        int i3 = 2;
        if (!this.f238487b) {
            if (QLog.isColorLevel()) {
                QLog.d("WatchFloatingWindowController", 2, "closeOrQuitBusiness, but isSuccessCreateFloatingView is false");
            }
        } else {
            String curUin = this.f238486a.getCurUin();
            int curType = this.f238486a.getCurType();
            if (this.f238486a.isIsAdm()) {
                i3 = 1;
            }
            i(curUin, curType, i3);
        }
    }

    public void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (this.f238486a == null) {
            return;
        }
        if (!this.f238487b) {
            if (QLog.isColorLevel()) {
                QLog.d("WatchFloatingWindowController", 2, "closeOrQuitBusiness, but isSuccessCreateFloatingView is false");
                return;
            }
            return;
        }
        i(this.f238486a.getCurUin(), this.f238486a.getCurType(), i3);
    }

    public void i(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.f238486a != null && this.f238490e != null) {
            WeakReference<c> weakReference = this.f238488c;
            if (weakReference != null && weakReference.get() != null) {
                this.f238488c.get().e(i16);
            }
            if (this.f238490e.b() != 1) {
                f(str, i3, true);
            }
        }
    }

    public void l() {
        WebViewModule webViewModule;
        TouchWebView touchWebView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        WatchTogetherFloatingView watchTogetherFloatingView = this.f238490e;
        if (watchTogetherFloatingView == null || (webViewModule = this.f238489d) == null || (touchWebView = webViewModule.webView) == null) {
            return;
        }
        watchTogetherFloatingView.a(touchWebView);
        this.f238489d.onResume();
    }

    public boolean m() {
        WebViewModule webViewModule;
        TouchWebView touchWebView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        if (this.f238490e == null || (webViewModule = this.f238489d) == null || (touchWebView = webViewModule.webView) == null) {
            return false;
        }
        return touchWebView.isShown();
    }

    public void n(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        WeakReference<c> weakReference = this.f238488c;
        if (weakReference != null && weakReference.get() != null) {
            c cVar = this.f238488c.get();
            if (z16) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            cVar.m(i3);
        }
    }

    public void o(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) cVar);
            return;
        }
        WeakReference<c> weakReference = this.f238488c;
        if (weakReference != null && weakReference.get() != null && this.f238488c.get() == cVar) {
            this.f238488c = null;
        }
    }

    public void p(WatchTogetherFloatingData watchTogetherFloatingData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) watchTogetherFloatingData);
        } else {
            this.f238493h = watchTogetherFloatingData;
        }
    }

    public void q(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) cVar);
        } else {
            this.f238488c = new WeakReference<>(cVar);
        }
    }

    public int r(Context context, @Nonnull WatchTogetherFloatingData watchTogetherFloatingData) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) watchTogetherFloatingData)).intValue();
        }
        if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(BaseApplication.getContext(), R.string.f171139ci4, 0).show();
            this.f238493h = null;
            return 4;
        }
        if (this.f238486a != null && this.f238486a.getCurUin().equals(watchTogetherFloatingData.getCurUin()) && this.f238486a.getCurType() == this.f238486a.getCurType() && this.f238486a.getLoadingStatus() == 1) {
            if (QLog.isColorLevel()) {
                QLog.d("WatchFloatingWindowController", 2, "showFloatingWindow:  duplicate show");
            }
            this.f238493h = null;
            return 5;
        }
        WatchTogetherFloatingView watchTogetherFloatingView = this.f238490e;
        if (watchTogetherFloatingView == null) {
            WatchTogetherFloatingView watchTogetherFloatingView2 = new WatchTogetherFloatingView(BaseApplication.getContext());
            this.f238490e = watchTogetherFloatingView2;
            watchTogetherFloatingView2.e(true);
        } else {
            watchTogetherFloatingView.f(watchTogetherFloatingData.getSmallUrl());
        }
        this.f238486a = watchTogetherFloatingData;
        if (this.f238486a.getVideoHeight() > 0.0d && this.f238486a.getVideoWidth() > 0.0d) {
            f16 = (float) (this.f238486a.getVideoHeight() / this.f238486a.getVideoWidth());
        } else {
            f16 = 0.5625f;
        }
        int j3 = j(context, f16);
        if (j3 != 0) {
            this.f238486a = null;
            this.f238493h = null;
            return j3;
        }
        this.f238487b = true;
        Intent intent = new Intent();
        intent.putExtra("web_view_module_from", 1);
        intent.putExtra("url", watchTogetherFloatingData.getSmallUrl());
        WebViewModule webViewModule = new WebViewModule(intent, context);
        this.f238489d = webViewModule;
        webViewModule.onCreate();
        f.k(true, watchTogetherFloatingData.getCurUin(), watchTogetherFloatingData.getCurType(), true);
        ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplication.getContext(), 50, 0);
        this.f238493h = null;
        return 0;
    }

    public void s(Context context) {
        WatchTogetherFloatingData watchTogetherFloatingData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) context);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WatchFloatingWindowController", 2, "showFloatingWindowByPendingData");
        }
        if (context == null || (watchTogetherFloatingData = this.f238493h) == null) {
            return;
        }
        r(context, watchTogetherFloatingData);
    }

    public void t(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        if (this.f238490e == null || this.f238486a == null) {
            return;
        }
        if (this.f238486a.getLoadingStatus() == i3) {
            if (i3 == 2) {
                ReportController.o(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_refresh_error", 0, 0, this.f238486a.getCurUin(), "", "", "");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WatchFloatingWindowController", 2, "updateLoadingStatus mLoadingStatus=" + this.f238486a.getLoadingStatus() + " status=" + i3);
        }
        this.f238486a.setLoadingStatus(i3);
        if (i3 == 1) {
            this.f238490e.e(false);
            d dVar = this.f238491f;
            if (dVar == null) {
                this.f238491f = new d(this.f238492g);
                com.tencent.mobileqq.mediafocus.b.i().l(1, this.f238491f);
                return;
            } else {
                dVar.b(this.f238492g);
                return;
            }
        }
        if (i3 == 2) {
            ReportController.o(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_refresh_error", 0, 0, this.f238486a.getCurUin(), "", "", "");
            this.f238490e.d();
        }
    }

    public void u(double d16, double d17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Double.valueOf(d16), Double.valueOf(d17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WatchFloatingWindowController", 2, "updateWindowSize videoWidth =" + d16 + " videoHeight=" + d17);
        }
        if (d16 > 0.0d && d17 > 0.0d) {
            if (this.f238486a == null) {
                return;
            }
            if (d16 == this.f238486a.getVideoWidth() && d17 == this.f238486a.getVideoHeight()) {
                if (QLog.isColorLevel()) {
                    QLog.d("WatchFloatingWindowController", 2, "updateWindowSize params is equal");
                    return;
                }
                return;
            }
            this.f238486a.setVideoWidth(d16);
            this.f238486a.setVideoHeight(d17);
            float f16 = (float) (d17 / d16);
            IQQFloatingWindow iQQFloatingWindow = (IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class);
            String str = FloatingWatchTogetherWrapper.CLASS_NAME;
            iQQFloatingWindow.updateFloatingWindowRatio(f16, str);
            IQQFloatingWindow iQQFloatingWindow2 = (IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class);
            if (f16 >= 1.0f) {
                i3 = 2;
            }
            iQQFloatingWindow2.updateFloatingWindowShape(i3, str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WatchFloatingWindowController", 2, "updateWindowSize params is invalid");
        }
    }
}

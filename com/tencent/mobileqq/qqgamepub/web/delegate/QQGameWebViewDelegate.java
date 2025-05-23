package com.tencent.mobileqq.qqgamepub.web.delegate;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameWebPresenter;
import com.tencent.mobileqq.qqgamepub.utils.b;
import com.tencent.mobileqq.qqgamepub.web.c;
import com.tencent.mobileqq.qqgamepub.web.view.QQGameHeadLayout;
import com.tencent.mobileqq.qqgamepub.web.view.QQGamePubWebView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.m;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGameWebViewDelegate extends com.tencent.mobileqq.qqgamepub.web.delegate.a<QQGameWebPresenter> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private QQGamePubWebView f264829f;

    /* renamed from: h, reason: collision with root package name */
    private c f264830h;

    /* renamed from: i, reason: collision with root package name */
    private QQGameHeadLayout f264831i;

    /* renamed from: m, reason: collision with root package name */
    private a f264832m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void onPageFinished(WebView webView, String str);

        void onPageStarted(WebView webView, String str, Bitmap bitmap);
    }

    public QQGameWebViewDelegate(QQGameWebPresenter qQGameWebPresenter, View view) {
        super(qQGameWebPresenter, view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQGameWebPresenter, (Object) view);
            return;
        }
        this.f264831i = (QQGameHeadLayout) view.findViewById(R.id.cw5);
        this.f264829f = (QQGamePubWebView) view.findViewById(R.id.cwr);
        this.f264831i.attachToRootView();
        this.f264829f.attachHeaderView(this.f264831i);
    }

    public QQGameHeadLayout c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QQGameHeadLayout) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f264831i;
    }

    public void d(Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) map);
            return;
        }
        try {
            QQGamePubWebView qQGamePubWebView = this.f264829f;
            if (qQGamePubWebView != null && map != null) {
                qQGamePubWebView.getPluginEngine().s(this.f264829f.getUrl(), 8589934621L, map);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void e(QBaseActivity qBaseActivity, com.tencent.mobileqq.qqgamepub.web.a aVar, QQGamePubWebView.a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, qBaseActivity, aVar, aVar2);
            return;
        }
        aVar.g();
        if (this.f264829f == null) {
            this.f264829f = new QQGamePubWebView(qBaseActivity);
        }
        b.c().h(this.f264829f);
        c cVar = new c(qBaseActivity, qBaseActivity, ((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface(), this.f264829f, aVar) { // from class: com.tencent.mobileqq.qqgamepub.web.delegate.QQGameWebViewDelegate.1
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.qqgamepub.web.a f264833a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(qBaseActivity, qBaseActivity, r8, r9);
                this.f264833a = aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, QQGameWebViewDelegate.this, qBaseActivity, qBaseActivity, r8, r9, aVar);
                }
            }

            @Override // com.tencent.mobileqq.qqgamepub.web.c, com.tencent.mobileqq.webview.AbsWebView
            public void onPageFinished(WebView webView, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) webView, (Object) str);
                    return;
                }
                super.onPageFinished(webView, str);
                this.f264833a.j();
                QLog.d("QQGameWebViewDelegate", 4, "-->web onPageFinished");
                this.f264833a.c();
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(webView, str) { // from class: com.tencent.mobileqq.qqgamepub.web.delegate.QQGameWebViewDelegate.1.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ WebView f264835d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f264836e;

                    {
                        this.f264835d = webView;
                        this.f264836e = str;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, AnonymousClass1.this, webView, str);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        } else if (QQGameWebViewDelegate.this.f264832m != null && QQGameWebViewDelegate.this.f264829f != null) {
                            QQGameWebViewDelegate.this.f264829f.setVisibility(0);
                            QQGameWebViewDelegate.this.f264832m.onPageFinished(this.f264835d, this.f264836e);
                        }
                    }
                });
            }

            @Override // com.tencent.mobileqq.qqgamepub.web.c, com.tencent.mobileqq.webview.AbsWebView
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, webView, str, bitmap);
                    return;
                }
                super.onPageStarted(webView, str, bitmap);
                this.f264833a.h();
                if (QQGameWebViewDelegate.this.f264832m != null) {
                    QQGameWebViewDelegate.this.f264832m.onPageStarted(webView, str, bitmap);
                }
            }

            @Override // com.tencent.mobileqq.webview.AbsWebView
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 4, (Object) this, (Object) webView, (Object) str)).booleanValue();
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
        };
        this.f264830h = cVar;
        new m(cVar).a(null, ((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface(), null);
        QQGamePubWebView qQGamePubWebView = (QQGamePubWebView) this.f264830h.getWebView();
        this.f264829f = qQGamePubWebView;
        qQGamePubWebView.setViewVisibleListener(aVar2);
        this.f264829f.setWillNotCacheDrawing(false);
        this.f264829f.setDrawingCacheEnabled(true);
        aVar.f();
    }

    public void f(String str, com.tencent.mobileqq.qqgamepub.web.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) aVar);
            return;
        }
        if (this.f264829f == null) {
            QLog.e("QQGameWebViewDelegate", 1, "doGetAllMsgLogic webView is null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQGameWebViewDelegate", 1, "paramUrl = " + str);
        }
        aVar.i();
        this.f264830h.setTimeBeforeLoadUrl(System.currentTimeMillis());
        this.f264829f.loadUrl(str);
    }

    public void g(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.f264832m = aVar;
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QQGamePubWebView qQGamePubWebView = this.f264829f;
        if (qQGamePubWebView != null) {
            qQGamePubWebView.q();
        }
        c cVar = this.f264830h;
        if (cVar != null) {
            cVar.onDestroy();
        }
        this.f264832m = null;
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        c cVar = this.f264830h;
        if (cVar != null) {
            cVar.onPause();
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        c cVar = this.f264830h;
        if (cVar != null) {
            cVar.onResume();
        }
    }
}

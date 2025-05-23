package com.tencent.mobileqq.microapp.appbrand.page;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.apkg.g;
import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.b.h;
import com.tencent.mobileqq.microapp.widget.TabBarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.core.EventListener;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes15.dex */
public final class AppBrandPageContainer extends FrameLayout implements TabBarView.b {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "AppBrandPageContainer";
    public a appBrandRuntime;
    public FrameLayout fullScreenLayout;
    public LinkedList pageLinkedList;
    public int refreshStyleColor;

    public AppBrandPageContainer(Context context, a aVar) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) aVar);
            return;
        }
        this.pageLinkedList = new LinkedList();
        this.refreshStyleColor = -1;
        this.appBrandRuntime = aVar;
        setBackgroundColor(-1);
    }

    private void bringToFront(AbsAppBrandPage absAppBrandPage, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "bringToFront page=" + absAppBrandPage + ",viewAnim=" + z16);
        }
        if (absAppBrandPage == null) {
            return;
        }
        this.pageLinkedList.remove(absAppBrandPage);
        this.pageLinkedList.push(absAppBrandPage);
        requestLayout();
        invalidate();
        absAppBrandPage.onPageForeground();
    }

    private void executeDownSubPack(String str, String str2) {
        WeakReference weakReference = new WeakReference(this);
        QQProgressDialog qQProgressDialog = new QQProgressDialog(getContext());
        qQProgressDialog.setMessage("\u6b63\u5728\u52a0\u8f7d\u6a21\u5757...");
        qQProgressDialog.setCancelable(false);
        qQProgressDialog.show();
        this.appBrandRuntime.f245898c.a(str, new g.a(weakReference, str2, str, qQProgressDialog) { // from class: com.tencent.mobileqq.microapp.appbrand.page.AppBrandPageContainer.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ QQProgressDialog val$dialog;
            final /* synthetic */ String val$fromFunc;
            final /* synthetic */ WeakReference val$pageWeakRef;
            final /* synthetic */ String val$url;

            {
                this.val$pageWeakRef = weakReference;
                this.val$fromFunc = str2;
                this.val$url = str;
                this.val$dialog = qQProgressDialog;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, AppBrandPageContainer.this, weakReference, str2, str, qQProgressDialog);
                }
            }

            @Override // com.tencent.mobileqq.microapp.apkg.g.a
            public void onInitApkgInfo$76ec3a73(int i3, c cVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) cVar);
                } else {
                    ThreadManager.getUIHandler().post(new Runnable(i3) { // from class: com.tencent.mobileqq.microapp.appbrand.page.AppBrandPageContainer.1.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ int val$resCode;

                        {
                            this.val$resCode = i3;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, i3);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (this.val$resCode == 0) {
                                AppBrandPageContainer appBrandPageContainer = (AppBrandPageContainer) AnonymousClass1.this.val$pageWeakRef.get();
                                if (appBrandPageContainer != null) {
                                    if ("navigateTo".equals(AnonymousClass1.this.val$fromFunc)) {
                                        appBrandPageContainer.navigateTo(AnonymousClass1.this.val$url);
                                    } else if ("redirectTo".equals(AnonymousClass1.this.val$fromFunc)) {
                                        appBrandPageContainer.redirectTo(AnonymousClass1.this.val$url);
                                    } else if (EventListener.APPLAUNCH.equals(AnonymousClass1.this.val$fromFunc)) {
                                        appBrandPageContainer.launch(AnonymousClass1.this.val$url, EventListener.APPLAUNCH);
                                    } else if ("reLaunch".equals(AnonymousClass1.this.val$fromFunc)) {
                                        appBrandPageContainer.launch(AnonymousClass1.this.val$url, "reLaunch");
                                    }
                                }
                            } else {
                                QQToast.makeText(AnonymousClass1.this.val$dialog.getContext(), "\u9875\u9762\u4e0d\u5b58\u5728\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 1).show();
                            }
                            AnonymousClass1.this.val$dialog.dismiss();
                        }
                    });
                }
            }
        });
    }

    private boolean isUrlResReady(String str) {
        return this.appBrandRuntime.f245898c.c(str);
    }

    public final void cleanup(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        Iterator it = this.pageLinkedList.iterator();
        while (it.hasNext()) {
            AbsAppBrandPage absAppBrandPage = (AbsAppBrandPage) it.next();
            if (!z16 || !absAppBrandPage.isTabPage()) {
                h.a().a(absAppBrandPage.getCurrentPageWebview(), BaseApplicationImpl.sApplication);
                absAppBrandPage.cleanup();
                it.remove();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "cleanup keepTabPage=" + z16 + ",pageLinkedList size=" + this.pageLinkedList.size());
        }
    }

    public PageWebview findPageWebView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (PageWebview) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        Iterator it = this.pageLinkedList.iterator();
        while (it.hasNext()) {
            PageWebview webView = ((AbsAppBrandPage) it.next()).getWebView(i3);
            if (webView != null) {
                return webView;
            }
        }
        return null;
    }

    public AbsAppBrandPage getCurrentPage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (AbsAppBrandPage) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        AbsAppBrandPage absAppBrandPage = (AbsAppBrandPage) this.pageLinkedList.peek();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "getCurrentPage page=" + absAppBrandPage + ",this=" + this);
        }
        return absAppBrandPage;
    }

    public PageWebview getCurrentPageWebview() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (PageWebview) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        AbsAppBrandPage absAppBrandPage = (AbsAppBrandPage) this.pageLinkedList.peek();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "getCurrentPageWebview page=" + absAppBrandPage);
        }
        if (absAppBrandPage != null) {
            return absAppBrandPage.getCurrentPageWebview();
        }
        return null;
    }

    public WebviewContainer getCurrentWebviewContainer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (WebviewContainer) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        AbsAppBrandPage absAppBrandPage = (AbsAppBrandPage) this.pageLinkedList.peek();
        if (absAppBrandPage != null) {
            return absAppBrandPage.getCurrentWebviewContainer();
        }
        return null;
    }

    public AbsAppBrandPage getPageByWebViewId(int i3) {
        AbsAppBrandPage absAppBrandPage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (AbsAppBrandPage) iPatchRedirector.redirect((short) 15, (Object) this, i3);
        }
        Iterator it = this.pageLinkedList.iterator();
        while (true) {
            if (it.hasNext()) {
                absAppBrandPage = (AbsAppBrandPage) it.next();
                if (absAppBrandPage.getWebView(i3) != null) {
                    break;
                }
            } else {
                absAppBrandPage = null;
                break;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "getPageByWebViewId webviewId=" + i3 + ",page=" + absAppBrandPage);
        }
        return absAppBrandPage;
    }

    public final int getPageCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.pageLinkedList.size();
    }

    public boolean handleBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        WebviewContainer currentWebviewContainer = getCurrentWebviewContainer();
        if (currentWebviewContainer != null && currentWebviewContainer.handleBackPressed()) {
            return true;
        }
        return false;
    }

    public void launch(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "launch type=" + str2 + JefsClass.INDEX_URL + str + ",currPageCount=" + getPageCount());
        }
        if (!isUrlResReady(str)) {
            executeDownSubPack(str, str2);
            return;
        }
        AppBrandPage appBrandPage = new AppBrandPage(getContext(), this);
        this.pageLinkedList.push(appBrandPage);
        appBrandPage.onCreate();
        appBrandPage.loadUrl(str, str2);
    }

    public void navigateBack(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "navigateBack delta=" + i3 + ",viewAnim=" + z16);
        }
        int pageCount = getPageCount();
        if (pageCount >= 2 && i3 >= 1) {
            if (i3 >= pageCount) {
                i3 = pageCount - 1;
            }
            Iterator it = this.pageLinkedList.iterator();
            for (int i16 = 0; i16 < i3 && this.pageLinkedList.size() >= 1; i16++) {
                if (it.hasNext()) {
                    AbsAppBrandPage absAppBrandPage = (AbsAppBrandPage) it.next();
                    QLog.d(TAG, 4, "navigateBack clearPage=" + absAppBrandPage);
                    h.a().a(absAppBrandPage.getCurrentPageWebview(), BaseApplicationImpl.sApplication);
                    absAppBrandPage.cleanup();
                    it.remove();
                }
            }
            AbsAppBrandPage absAppBrandPage2 = (AbsAppBrandPage) this.pageLinkedList.peek();
            QLog.d(TAG, 4, "navigateBack backPage=" + absAppBrandPage2);
            if (absAppBrandPage2 != null) {
                absAppBrandPage2.onPageForeground();
                absAppBrandPage2.onAppRoute("navigateBack", absAppBrandPage2.getUrl());
            }
        }
    }

    public void navigateTo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "navigateTo url=" + str);
        }
        if (!isUrlResReady(str)) {
            executeDownSubPack(str, "navigateTo");
            return;
        }
        AppBrandPage appBrandPage = new AppBrandPage(getContext(), this);
        this.pageLinkedList.push(appBrandPage);
        appBrandPage.onCreate();
        appBrandPage.loadUrl(str, "navigateTo");
    }

    @Override // com.tencent.mobileqq.microapp.widget.TabBarView.b
    public void onTabItemClick(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "onTabItemClick pagePath=" + str);
        }
        swichTab(str);
    }

    public void redirectTo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "redirectTo url=" + str);
        }
        if (!isUrlResReady(str)) {
            executeDownSubPack(str, "redirectTo");
            return;
        }
        AbsAppBrandPage absAppBrandPage = (AbsAppBrandPage) this.pageLinkedList.peek();
        if (absAppBrandPage != null) {
            absAppBrandPage.cleanup();
            bringToFront(absAppBrandPage, false);
        } else {
            absAppBrandPage = new AppBrandPage(getContext(), this);
            this.pageLinkedList.push(absAppBrandPage);
        }
        absAppBrandPage.onCreate();
        absAppBrandPage.loadUrl(str, "redirectTo");
    }

    public void swichTab(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "swichTab url=" + str);
        }
        cleanup(true);
        AbsAppBrandPage absAppBrandPage = (AbsAppBrandPage) this.pageLinkedList.peek();
        if (absAppBrandPage == null) {
            absAppBrandPage = new AppBrandPage(getContext(), this);
            absAppBrandPage.onCreate();
            this.pageLinkedList.push(absAppBrandPage);
        }
        absAppBrandPage.loadUrl(str, "switchTab");
    }
}

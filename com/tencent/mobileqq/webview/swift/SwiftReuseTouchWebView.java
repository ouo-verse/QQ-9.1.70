package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SwiftReuseTouchWebView extends TouchWebView {
    static IPatchRedirector $redirector_;
    private static final Object G;
    private static SwiftReuseTouchWebView H;
    public static int I;
    private SwiftReuseTouchWebView C;
    public int D;
    private int E;
    private a F;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f314087a;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftReuseTouchWebView.this);
            } else {
                this.f314087a = SwiftReuseTouchWebView.this.getSettings().getUserAgentString();
            }
        }

        void a() {
            SwiftReuseTouchWebView.this.getSettings().setUserAgentString(this.f314087a);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48549);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            G = new Object();
            I = 0;
        }
    }

    SwiftReuseTouchWebView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.D = 0;
        this.E = 0;
        this.F = new a();
    }

    public static SwiftReuseTouchWebView q(Context context) {
        SwiftReuseTouchWebView swiftReuseTouchWebView;
        Context context2;
        synchronized (G) {
            QLog.i("SwiftReuseTouchWebView", 1, "sPool acquire:" + H);
            swiftReuseTouchWebView = H;
            if (swiftReuseTouchWebView != null) {
                H = swiftReuseTouchWebView.C;
                swiftReuseTouchWebView.C = null;
                I--;
            } else {
                swiftReuseTouchWebView = null;
            }
        }
        if (swiftReuseTouchWebView == null) {
            boolean z16 = context instanceof Activity;
            if (z16) {
                context2 = context.getApplicationContext();
            } else {
                context2 = context;
            }
            MutableContextWrapper mutableContextWrapper = new MutableContextWrapper(context2);
            swiftReuseTouchWebView = new SwiftReuseTouchWebView(mutableContextWrapper);
            if (z16) {
                mutableContextWrapper.setBaseContext(context);
            }
        } else {
            swiftReuseTouchWebView.E++;
            swiftReuseTouchWebView.onResume();
            ((MutableContextWrapper) swiftReuseTouchWebView.getContext()).setBaseContext(context);
        }
        return swiftReuseTouchWebView;
    }

    public static void r() {
        synchronized (G) {
            QLog.i("SwiftReuseTouchWebView", 1, "clearAllCache: " + H);
            while (true) {
                SwiftReuseTouchWebView swiftReuseTouchWebView = H;
                if (swiftReuseTouchWebView != null) {
                    H = swiftReuseTouchWebView.C;
                    swiftReuseTouchWebView.C = null;
                    I--;
                    u(swiftReuseTouchWebView);
                }
            }
        }
    }

    private static void u(SwiftReuseTouchWebView swiftReuseTouchWebView) {
        try {
            ViewParent parent = swiftReuseTouchWebView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(swiftReuseTouchWebView);
            }
            swiftReuseTouchWebView.destroy();
        } catch (Throwable th5) {
            QLog.e("SwiftReuseTouchWebView", 1, "tryFixOldVersionMemoryLeak error " + th5, th5);
        }
    }

    @Override // com.tencent.smtt.sdk.WebView
    public boolean canGoBack() {
        WebHistoryItem itemAtIndex;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (s(1)) {
            WebBackForwardList copyBackForwardList = copyBackForwardList();
            if (copyBackForwardList != null && copyBackForwardList.getSize() > 0 && (itemAtIndex = copyBackForwardList.getItemAtIndex(0)) != null && "about:blank".equals(itemAtIndex.getUrl())) {
                return super.canGoBackOrForward(-2);
            }
            return super.canGoBack();
        }
        return super.canGoBack();
    }

    @Override // com.tencent.biz.pubaccount.CustomWebView, com.tencent.biz.pubaccount.SuperWebView, com.tencent.smtt.sdk.WebView
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.destroy();
        QLog.i("SwiftReuseTouchWebView", 1, "destroy sPoolSize=" + I);
    }

    @Override // com.tencent.biz.ui.TouchWebView, com.tencent.biz.pubaccount.CustomWebView, com.tencent.biz.pubaccount.SuperWebView
    public void resetForReuse() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.resetForReuse();
            this.F.a();
        }
    }

    public boolean s(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3)).booleanValue();
        }
        if ((i3 & this.D) != 0) {
            return true;
        }
        return false;
    }

    public void t(boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        synchronized (G) {
            int i3 = I;
            if (i3 < 4) {
                this.C = H;
                H = this;
                I = i3 + 1;
                z17 = true;
            } else {
                z17 = false;
            }
        }
        if (z17) {
            ((MutableContextWrapper) getContext()).setBaseContext(MobileQQ.sMobileQQ);
            this.D |= 1;
            if (!z16) {
                resetForReuse();
                onPause();
            }
            QLog.i("SwiftReuseTouchWebView", 1, String.format("[webViewReuse] recycle size=%d isNew=%b flag=%d this=%s", Integer.valueOf(I), Boolean.valueOf(z16), Integer.valueOf(this.D), Integer.valueOf(hashCode())));
            return;
        }
        super.destroy();
    }
}

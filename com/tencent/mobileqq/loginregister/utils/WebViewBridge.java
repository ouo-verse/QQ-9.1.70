package com.tencent.mobileqq.loginregister.utils;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.loginregister.utils.ActivityResultHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.Navigator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ProcessUtil;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class WebViewBridge {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f243039a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, c> f243040b;

    /* renamed from: c, reason: collision with root package name */
    private BroadcastReceiver f243041c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f243042d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f243045a;

        a(int i3) {
            this.f243045a = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebViewBridge.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.utils.WebViewBridge.d
        public void a(FragmentActivity fragmentActivity, String str, Bundle bundle, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                WebViewBridge.this.i(fragmentActivity, this.f243045a, str, bundle, i3);
            } else {
                iPatchRedirector.redirect((short) 3, this, fragmentActivity, str, bundle, Integer.valueOf(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebViewBridge.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (intent != null && context != null) {
                int intExtra = intent.getIntExtra("web_bridge_seq", 0);
                String stringExtra = intent.getStringExtra("web_bridge_process");
                String currentProcessName = ProcessUtil.getCurrentProcessName(context);
                if (QLog.isColorLevel()) {
                    QLog.i("WebViewBridge", 2, "onReceive process=" + stringExtra + " currProcess=" + currentProcessName + " bridgeSeq=" + intExtra);
                }
                if (TextUtils.equals(stringExtra, currentProcessName)) {
                    String stringExtra2 = intent.getStringExtra("web_bridge_event");
                    QLog.i("WebViewBridge", 1, "on bridge event receive, process=" + stringExtra + " bridgeSeq=" + intExtra + " event=" + stringExtra2);
                    c cVar = (c) WebViewBridge.this.f243040b.get(Integer.valueOf(intExtra));
                    if (cVar != null) {
                        cVar.a(intExtra, stringExtra2, intent.getExtras());
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface c {
        void a(int i3, String str, Bundle bundle);

        void b(int i3, int i16, int i17, Bundle bundle);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface d {
        void a(FragmentActivity fragmentActivity, String str, Bundle bundle, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final WebViewBridge f243048a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32988);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f243048a = new WebViewBridge();
            }
        }
    }

    WebViewBridge() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f243039a = new AtomicInteger(0);
        this.f243040b = new ConcurrentHashMap<>();
        this.f243041c = null;
        this.f243042d = new Object();
    }

    private int e() {
        return this.f243039a.incrementAndGet();
    }

    public static WebViewBridge f() {
        return e.f243048a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(int i3, int i16, int i17, Intent intent) {
        Bundle bundle;
        QLog.i("WebViewBridge", 1, "onActivityResult bridgeSeq=" + i3 + " requestCode=" + i16 + " resultCode=" + i17);
        c cVar = this.f243040b.get(Integer.valueOf(i3));
        if (cVar != null) {
            if (intent != null) {
                bundle = intent.getExtras();
            } else {
                bundle = null;
            }
            cVar.b(i3, i16, i17, bundle);
            return;
        }
        QLog.i("WebViewBridge", 1, "onActivityResult callback is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(int i3, final int i16, Navigator navigator, ActivityResultHelper.ForResultFragment forResultFragment) {
        forResultFragment.qh(i3, new ActivityResultHelper.b() { // from class: com.tencent.mobileqq.loginregister.utils.b
            @Override // com.tencent.mobileqq.loginregister.utils.ActivityResultHelper.b
            public final void onActivityResult(int i17, int i18, Intent intent) {
                WebViewBridge.this.g(i16, i17, i18, intent);
            }
        });
        navigator.withRequestCode(forResultFragment, i3).request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(FragmentActivity fragmentActivity, final int i3, String str, Bundle bundle, final int i16) {
        Context context;
        if (fragmentActivity != null) {
            context = fragmentActivity;
        } else {
            context = QBaseActivity.sTopActivity;
        }
        if (context == null) {
            context = MobileQQ.sMobileQQ.getApplicationContext();
        }
        String qQProcessName = MobileQQ.sMobileQQ.getQQProcessName();
        QLog.i("WebViewBridge", 1, "launchWebViewActivity bridgeSeq:" + i3 + " process:" + qQProcessName);
        final Navigator withString = QRoute.createNavigator(context, RouterConstants.UI_ROUTE_BROWSER).withInt("web_bridge_seq", i3).withString("web_bridge_process", qQProcessName).withString("url", str);
        if (bundle != null) {
            withString.withAll(bundle);
        }
        if (fragmentActivity != null && !fragmentActivity.isFinishing()) {
            new ActivityResultHelper(fragmentActivity).b(new ActivityResultHelper.c() { // from class: com.tencent.mobileqq.loginregister.utils.a
                @Override // com.tencent.mobileqq.loginregister.utils.ActivityResultHelper.c
                public final void a(ActivityResultHelper.ForResultFragment forResultFragment) {
                    WebViewBridge.this.h(i16, i3, withString, forResultFragment);
                }
            });
        } else {
            QLog.i("WebViewBridge", 1, "activity is null or finishing, start without result, bridgeSeq:" + i3);
            withString.withFlags(268435456).request();
        }
        m();
    }

    private void m() {
        if (this.f243041c != null) {
            return;
        }
        synchronized (this.f243042d) {
            if (this.f243041c != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mobileqq.loginregister.webview.bridge.event");
            b bVar = new b();
            this.f243041c = bVar;
            MobileQQ.sMobileQQ.registerReceiver(bVar, intentFilter);
        }
    }

    public void j(Activity activity, String str, Bundle bundle) {
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, activity, str, bundle);
            return;
        }
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            QLog.w("WebViewBridge", 1, "postEvent intent is null");
            return;
        }
        int intExtra = intent.getIntExtra("web_bridge_seq", 0);
        String stringExtra = intent.getStringExtra("web_bridge_process");
        QLog.i("WebViewBridge", 1, "postEvent bridgeSeq=" + intExtra + " process=" + stringExtra);
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        Intent intent2 = new Intent("com.tencent.mobileqq.loginregister.webview.bridge.event");
        intent2.setPackage(applicationContext.getPackageName());
        intent2.putExtra("web_bridge_seq", intExtra);
        intent2.putExtra("web_bridge_process", stringExtra);
        intent2.putExtra("web_bridge_event", str);
        if (bundle != null) {
            intent2.putExtras(bundle);
        }
        applicationContext.sendBroadcast(intent2);
    }

    public d k(LifecycleOwner lifecycleOwner, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this, (Object) lifecycleOwner, (Object) cVar);
        }
        int e16 = e();
        if (cVar != null) {
            this.f243040b.put(Integer.valueOf(e16), cVar);
        }
        if (lifecycleOwner != null) {
            lifecycleOwner.getLifecycle().addObserver(new LifecycleObserver(e16) { // from class: com.tencent.mobileqq.loginregister.utils.WebViewBridge.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f243043d;

                {
                    this.f243043d = e16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebViewBridge.this, e16);
                    }
                }

                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                void onDestroy() {
                    QLog.i("WebViewBridge", 1, "onDestroy bridgeSeq=" + this.f243043d);
                    WebViewBridge.this.n(this.f243043d);
                }
            });
        }
        return new a(e16);
    }

    public d l(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
        }
        return k(null, cVar);
    }

    public void n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f243040b.remove(Integer.valueOf(i3));
        }
    }
}

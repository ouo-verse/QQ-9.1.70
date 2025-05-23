package jx2;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.tvideo.authpay.TVideoAuthPayWebView;
import com.tencent.mobileqq.tvideo.event.QFSTVideoAuthPayReloadEvent;
import com.tencent.paysdk.api.IUserInfoProvider;
import com.tencent.paysdk.api.h;
import com.tencent.paysdk.api.k;
import com.tencent.paysdk.api.n;
import com.tencent.paysdk.api.o;
import com.tencent.paysdk.api.p;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jy2.g;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private List<TVideoAuthPayWebView> f411057a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    p f411058b = new b();

    /* renamed from: c, reason: collision with root package name */
    au2.a f411059c = new C10619c();

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f411060a;

        a(Context context) {
            this.f411060a = context;
        }

        @Override // com.tencent.paysdk.api.n
        public void a() {
            zt2.e.f453199a.v();
        }

        @Override // com.tencent.paysdk.api.n
        public void b(@NonNull Context context, @NonNull String str) {
            QLog.d("TVideoAuthPayInitManager", 4, "openWebView url = " + str);
            c.this.h();
            jy2.f.f411169a.i(context, str);
        }

        @Override // com.tencent.paysdk.api.n
        @Nullable
        public p c() {
            return c.this.f411058b;
        }

        @Override // com.tencent.paysdk.api.n
        @NonNull
        public IUserInfoProvider d() {
            return new e();
        }

        @Override // com.tencent.paysdk.api.n
        public void e(@NonNull String str) {
            c.this.g();
        }

        @Override // com.tencent.paysdk.api.n
        @Nullable
        public com.tencent.paysdk.log.b f() {
            return new jx2.d();
        }

        @Override // com.tencent.paysdk.api.n
        @Nullable
        public k g() {
            return null;
        }

        @Override // com.tencent.paysdk.api.n
        @NonNull
        public com.tencent.paysdk.api.a getAppInfo() {
            return new jx2.a();
        }

        @Override // com.tencent.paysdk.api.n
        @NonNull
        public Context getContext() {
            return this.f411060a;
        }

        @Override // com.tencent.paysdk.api.n
        @NonNull
        public com.tencent.paysdk.api.d getDeviceInfo() {
            return new jx2.b();
        }

        @Override // com.tencent.paysdk.api.n
        public boolean isRelease() {
            return !g.K();
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements p {
        b() {
        }

        @Override // com.tencent.paysdk.api.p
        @Nullable
        public o a(@NonNull Context context) {
            c.this.f();
            TVideoAuthPayWebView tVideoAuthPayWebView = new TVideoAuthPayWebView(context);
            QLog.d("TVideoAuthPayInitManager", 4, "createWebView " + tVideoAuthPayWebView.hashCode());
            c.this.f411057a.add(tVideoAuthPayWebView);
            return tVideoAuthPayWebView;
        }

        @Override // com.tencent.paysdk.api.p
        public void b(@NonNull h hVar) {
            QLog.d("TVideoAuthPayInitManager", 4, "synCookies");
            c.m();
            if (hVar != null) {
                hVar.onCompleted();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public static final c f411064a = new c();
    }

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            if (this.f411057a.size() > 5) {
                QLog.d("TVideoAuthPayInitManager", 4, "checkDestroyWebView");
                TVideoAuthPayWebView tVideoAuthPayWebView = this.f411057a.get(0);
                jy2.f.f411169a.b(tVideoAuthPayWebView);
                this.f411057a.remove(tVideoAuthPayWebView);
            }
        } catch (Exception e16) {
            QLog.d("TVideoAuthPayInitManager", 4, "checkDestroyWebView Exception " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        zt2.e eVar = zt2.e.f453199a;
        if (eVar.k()) {
            CookieManager.getInstance().setAcceptCookie(true);
            com.tencent.paysdk.a.t();
        } else {
            h();
            eVar.l(Foreground.getTopActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (Foreground.getTopActivity() != null && Foreground.getTopActivity().getResources().getConfiguration().orientation == 2) {
            g.Q(Foreground.getTopActivity(), 1);
        }
    }

    private void j() {
        Iterator<TVideoAuthPayWebView> it = this.f411057a.iterator();
        while (it.hasNext()) {
            jy2.f.f411169a.b(it.next());
        }
        QLog.d("TVideoAuthPayInitManager", 4, "destroyAllWebView");
        this.f411057a.clear();
    }

    public static c k() {
        return d.f411064a;
    }

    public static void m() {
        boolean k3 = zt2.e.f453199a.k();
        CookieSyncManager createInstance = CookieSyncManager.createInstance(g.e().getApplicationContext());
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setCookie("qq.com/", "vqqplugin_auth_state=" + (k3 ? 1 : 0) + "; path=/; domain=.qq.com;");
        createInstance.sync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (zt2.k.c()) {
            QFSTVideoAuthPayReloadEvent qFSTVideoAuthPayReloadEvent = new QFSTVideoAuthPayReloadEvent();
            qFSTVideoAuthPayReloadEvent.setIgnorePos(true);
            SimpleEventBus.getInstance().dispatchEvent(qFSTVideoAuthPayReloadEvent);
        }
    }

    public void i() {
        zt2.e.f453199a.x(this.f411059c);
        j();
        CookieManager.getInstance().setAcceptCookie(true);
    }

    public void l(Context context) {
        m();
        zt2.e.f453199a.w(this.f411059c);
        com.tencent.paysdk.a.r(new a(context));
    }

    /* compiled from: P */
    /* renamed from: jx2.c$c, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C10619c implements au2.a {
        C10619c() {
        }

        @Override // au2.a
        public void a(@NonNull bu2.a aVar) {
            QLog.d("TVideoAuthPayInitManager", 4, "onAccountLogin");
            CookieManager.getInstance().setAcceptCookie(true);
            com.tencent.paysdk.a.t();
            c.this.n();
        }

        @Override // au2.a
        public void e(@NonNull bu2.a aVar) {
            com.tencent.paysdk.a.t();
        }

        @Override // au2.a
        public void d() {
        }

        @Override // au2.a
        public void b(@NonNull bu2.c cVar) {
        }

        @Override // au2.a
        public void c(@Nullable bu2.a aVar) {
        }
    }
}

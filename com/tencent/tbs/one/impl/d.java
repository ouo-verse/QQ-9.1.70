package com.tencent.tbs.one.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneDebugger;
import com.tencent.tbs.one.TBSOneDelegate;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.TBSOneOnlineService;
import com.tencent.tbs.one.impl.a.g;
import com.tencent.tbs.one.impl.a.o;
import com.tencent.tbs.one.impl.e.h;
import java.io.File;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class d extends TBSOneManager {

    /* renamed from: e, reason: collision with root package name */
    private final Object f374860e = new Object();

    /* renamed from: f, reason: collision with root package name */
    private String f374861f;

    /* renamed from: g, reason: collision with root package name */
    private h f374862g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f374863h;

    public d(Context context, String str) {
        com.tencent.tbs.one.b.c(str).c("initializing");
        a.a(context);
        g.a("[%s] [TBSOneManagerImpl] Initializing v:%s (time:%s)", str, "0.0.5", "20240801165048");
        this.f374861f = str;
        this.f374862g = a.a(context, str);
        com.tencent.tbs.one.b.c(str).b("initializing");
    }

    private void b() {
        synchronized (this.f374860e) {
            this.f374863h = true;
        }
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final void cancelComponent(final String str) {
        g.a("[%s] [TBSOneManagerImpl] Canceling component %s", this.f374861f, str);
        b();
        o.b(new Runnable() { // from class: com.tencent.tbs.one.impl.d.5
            @Override // java.lang.Runnable
            public final void run() {
                d.this.f374862g.d(str);
            }
        });
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final void configure(String str, Object obj) {
        g.a("[%s] [TBSOneManagerImpl] Configuring %s = %s", this.f374861f, str, obj);
        this.f374862g.a(str, obj);
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final String getBuildNumber() {
        return "20240801165048";
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final TBSOneDebugger getDebugger() {
        return this.f374862g.d();
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final String getDexUtilsExtraMsg() {
        return com.tencent.tbs.one.impl.c.a.d.a();
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final File getInstalledComponentPath(String str) {
        if (isComponentInstalled(str)) {
            try {
                File installComponentSync = installComponentSync(str, null, 1000L);
                if (installComponentSync != null) {
                    return installComponentSync;
                }
            } catch (Exception e16) {
                g.a("[TBSOneManagerImpl].getInstalledComponentPath handle Loading component %s exception:%s", str, e16.toString());
            }
        }
        return null;
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final int[] getInstalledVersionCodesOfComponent(String str) {
        return this.f374862g.c(str);
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final TBSOneComponent getLoadedComponent(String str) {
        return this.f374862g.f(str);
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final TBSOneOnlineService getOnlineService() {
        b();
        return this.f374862g.c();
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final int getVersionCode() {
        return 5;
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final String getVersionName() {
        return "0.0.5";
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final void installComponent(String str, TBSOneCallback<File> tBSOneCallback) {
        installComponent(str, null, tBSOneCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.tbs.one.TBSOneManager
    public final File installComponentSync(final String str, final Bundle bundle, long j3) throws TBSOneException {
        if (!o.e()) {
            b();
            final c cVar = new c();
            o.b(new Runnable() { // from class: com.tencent.tbs.one.impl.d.6
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.f374862g.b(str, bundle, cVar);
                }
            });
            cVar.a(j3);
            if (cVar.f374629b == 0) {
                return (File) cVar.f374628a;
            }
            throw new TBSOneException(cVar.f374629b, cVar.f374630c);
        }
        throw new RuntimeException("TBSOneManager.installComponentSync must not be called on TBSOne thread.");
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final boolean isComponentInstalled(String str) {
        return this.f374862g.b(str);
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final void loadComponentAsync(String str, TBSOneCallback<TBSOneComponent> tBSOneCallback) {
        loadComponentAsync(str, null, tBSOneCallback);
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final TBSOneComponent loadComponentSync(String str, long j3) throws TBSOneException {
        return loadComponentSync(str, null, j3);
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final void setAutoUpdateEnabled(boolean z16) {
        String str;
        Object[] objArr = new Object[2];
        objArr[0] = this.f374861f;
        if (z16) {
            str = "Enabling";
        } else {
            str = "Disabling";
        }
        objArr[1] = str;
        g.a("[%s] [TBSOneManagerImpl] %s auto update", objArr);
        this.f374862g.a(z16);
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final void setDelegate(final TBSOneDelegate tBSOneDelegate) {
        g.a("[%s] [TBSOneManagerImpl] Setting delegate %s", this.f374861f, tBSOneDelegate);
        o.b(new Runnable() { // from class: com.tencent.tbs.one.impl.d.1
            @Override // java.lang.Runnable
            public final void run() {
                d.this.f374862g.f375061n = tBSOneDelegate;
            }
        });
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final void setOatOptEnable(boolean z16) {
        com.tencent.tbs.one.impl.c.a.d.a(z16);
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final void setPolicy(TBSOneManager.Policy policy) {
        g.a("[%s] [TBSOneManagerImpl] Setting policy %s", this.f374861f, policy);
        synchronized (this.f374860e) {
            if (this.f374863h) {
                return;
            }
            this.f374862g.f375055h = policy;
        }
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final void setTBSOneLoggingHandler(com.tencent.tbs.one.a aVar) {
        g.a(aVar);
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final void installComponent(final String str, final Bundle bundle, final TBSOneCallback<File> tBSOneCallback) {
        g.a("[%s] [TBSOneManagerImpl].installComponent(name = %s, options = %s,)", this.f374861f, str, bundle);
        b();
        o.b(new Runnable() { // from class: com.tencent.tbs.one.impl.d.2
            @Override // java.lang.Runnable
            public final void run() {
                d.this.f374862g.b(str, bundle, tBSOneCallback);
            }
        });
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final void loadComponentAsync(final String str, final Bundle bundle, final TBSOneCallback<TBSOneComponent> tBSOneCallback) {
        g.a("[%s] [TBSOneManagerImpl] Loading component %s asynchronously", this.f374861f, str);
        b();
        o.b(new Runnable() { // from class: com.tencent.tbs.one.impl.d.3

            /* compiled from: P */
            /* renamed from: com.tencent.tbs.one.impl.d$3$a */
            /* loaded from: classes26.dex */
            final class a extends TBSOneCallback<TBSOneComponent> {
                a() {
                }

                @Override // com.tencent.tbs.one.TBSOneCallback
                public final /* synthetic */ void onCompleted(TBSOneComponent tBSOneComponent) {
                    TBSOneComponent tBSOneComponent2 = tBSOneComponent;
                    com.tencent.tbs.one.b.c(d.this.f374861f).d(str).b("loadAsync");
                    TBSOneCallback tBSOneCallback = tBSOneCallback;
                    if (tBSOneCallback != null) {
                        tBSOneCallback.onCompleted(tBSOneComponent2);
                    }
                }

                @Override // com.tencent.tbs.one.TBSOneCallback
                public final void onError(int i3, String str) {
                    TBSOneCallback tBSOneCallback = tBSOneCallback;
                    if (tBSOneCallback != null) {
                        tBSOneCallback.onError(i3, str);
                    }
                }

                @Override // com.tencent.tbs.one.TBSOneCallback
                public final void onProgressChanged(int i3, int i16) {
                    TBSOneCallback tBSOneCallback = tBSOneCallback;
                    if (tBSOneCallback != null) {
                        tBSOneCallback.onProgressChanged(i3, i16);
                    }
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.tbs.one.b.c(d.this.f374861f).d(str).c("loadAsync");
                d.this.f374862g.a(str, bundle, new a());
            }
        });
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final TBSOneComponent loadComponentSync(final String str, final Bundle bundle, long j3) throws TBSOneException {
        g.a("[%s] [TBSOneManagerImpl] Loading component %s synchronously", this.f374861f, str);
        if (!o.e()) {
            b();
            com.tencent.tbs.one.b.c(this.f374861f).d(str).c("loadSync");
            final c cVar = new c();
            o.b(new Runnable() { // from class: com.tencent.tbs.one.impl.d.4
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.f374862g.a(str, bundle, cVar);
                }
            });
            cVar.a(j3);
            if (cVar.f374629b == 0) {
                com.tencent.tbs.one.b.c(this.f374861f).d(str).b("loadSync");
                return (TBSOneComponent) cVar.f374628a;
            }
            throw new TBSOneException(cVar.f374629b, cVar.f374630c);
        }
        throw new RuntimeException("TBSOneManager.loadComponentSync must not be called on TBSOne thread.");
    }
}

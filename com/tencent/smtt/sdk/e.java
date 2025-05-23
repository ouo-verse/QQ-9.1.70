package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.ProxyConfig;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes23.dex */
public class e extends ProxyController {

    /* renamed from: a, reason: collision with root package name */
    CopyOnWriteArrayList<a> f369348a;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a {

        /* renamed from: a, reason: collision with root package name */
        ProxyConfig f369349a;

        /* renamed from: b, reason: collision with root package name */
        Executor f369350b;

        /* renamed from: c, reason: collision with root package name */
        Runnable f369351c;

        a() {
        }
    }

    public void a(String[][] strArr, String[] strArr2, Runnable runnable, Executor executor, boolean z16) {
        try {
            DexLoader b16 = p.a().c().b();
            b16.invokeMethod(b16.newInstance("android.webview.chromium.tencent.TencentSupportProxyController", new Class[0], new Object[0]), "android.webview.chromium.tencent.TencentSupportProxyController", "setProxyOverride", new Class[]{String[][].class, String[].class, Runnable.class, Executor.class, Boolean.TYPE}, strArr, strArr2, runnable, executor, Boolean.valueOf(z16));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void b(String[][] strArr, String[] strArr2, Runnable runnable, Executor executor, boolean z16) {
        try {
            Class<?> cls = Class.forName("androidx.webkit.internal.ProxyControllerImpl");
            Method declaredMethod = cls.getDeclaredMethod("getBoundaryInterface", new Class[0]);
            declaredMethod.setAccessible(true);
            Class.forName("org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface").getMethod("setProxyOverride", String[][].class, String[].class, Runnable.class, Executor.class, Boolean.TYPE).invoke(declaredMethod.invoke(cls.newInstance(), new Object[0]), strArr, strArr2, runnable, executor, Boolean.valueOf(z16));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.smtt.sdk.ProxyController
    public void clearProxyOverride(Executor executor, Runnable runnable) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            b(executor, runnable);
        } else {
            a(executor, runnable);
        }
    }

    @Override // com.tencent.smtt.sdk.ProxyController
    public void setProxyOverride(ProxyConfig proxyConfig, Executor executor, Runnable runnable) {
        String[][] a16 = a(proxyConfig.getProxyRules());
        String[] strArr = (String[]) proxyConfig.getBypassRules().toArray(new String[0]);
        p a17 = p.a();
        if (a17 != null && a17.b()) {
            a(a16, strArr, runnable, executor, proxyConfig.isReverseBypassEnabled());
            return;
        }
        a aVar = new a();
        aVar.f369349a = proxyConfig;
        aVar.f369350b = executor;
        aVar.f369351c = runnable;
        if (this.f369348a == null) {
            this.f369348a = new CopyOnWriteArrayList<>();
        }
        this.f369348a.add(aVar);
        b(a16, strArr, runnable, executor, proxyConfig.isReverseBypassEnabled());
    }

    @Override // com.tencent.smtt.sdk.ProxyController
    public void syncSetProxy() {
        p a16;
        CopyOnWriteArrayList<a> copyOnWriteArrayList = this.f369348a;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0 && (a16 = p.a()) != null && a16.b()) {
            Iterator<a> it = this.f369348a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a(a(next.f369349a.getProxyRules()), (String[]) next.f369349a.getBypassRules().toArray(new String[0]), next.f369351c, next.f369350b, next.f369349a.isReverseBypassEnabled());
            }
            this.f369348a.clear();
        }
    }

    private void a(Executor executor, Runnable runnable) {
        try {
            Class<?> cls = Class.forName("androidx.webkit.internal.ProxyControllerImpl");
            Method declaredMethod = cls.getDeclaredMethod("getBoundaryInterface", new Class[0]);
            declaredMethod.setAccessible(true);
            Class.forName("org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface").getMethod("clearProxyOverride", Runnable.class, Executor.class).invoke(declaredMethod.invoke(cls.newInstance(), new Object[0]), runnable, executor);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void b(Executor executor, Runnable runnable) {
        try {
            DexLoader b16 = p.a().c().b();
            b16.invokeMethod(b16.newInstance("android.webview.chromium.tencent.TencentSupportProxyController", new Class[0], new Object[0]), "android.webview.chromium.tencent.TencentSupportProxyController", "clearProxyOverride", new Class[]{Runnable.class, Executor.class}, runnable, executor);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static String[][] a(List<ProxyConfig.ProxyRule> list) {
        String[][] strArr = (String[][]) Array.newInstance((Class<?>) String.class, list.size(), 2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            strArr[i3][0] = list.get(i3).getSchemeFilter();
            strArr[i3][1] = list.get(i3).getUrl();
        }
        return strArr;
    }
}

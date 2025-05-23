package com.tencent.mobileqq.webprocess;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.injector.m;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<Integer, a> f313731a;

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<Integer, a> f313732b;

    /* renamed from: c, reason: collision with root package name */
    public static long f313733c;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f313734a;

        /* renamed from: b, reason: collision with root package name */
        public int f313735b;

        /* renamed from: c, reason: collision with root package name */
        public int f313736c;

        /* renamed from: d, reason: collision with root package name */
        public int f313737d;

        a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
                return;
            }
            this.f313734a = i3;
            this.f313735b = 0;
            this.f313736c = 0;
            this.f313737d = 0;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48403);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f313731a = new HashMap<>();
        f313732b = new HashMap<>();
        f313733c = 0L;
    }

    public static void a(int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("_accelerator_mode_", 3);
        bundle.putInt("from", i3);
        SwiftWebAccelerator.h().k(bundle);
    }

    @Deprecated
    public static void b(int i3) {
        boolean isProcessRunning = QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool");
        if (!isProcessRunning) {
            ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).preloadWebProcess(5, null);
        }
        a aVar = new a(i3);
        if (f313731a.containsKey(Integer.valueOf(i3))) {
            aVar = f313731a.get(Integer.valueOf(i3));
        }
        aVar.f313735b++;
        aVar.f313736c += isProcessRunning ? 1 : 0;
        aVar.f313737d += !isProcessRunning ? 1 : 0;
        f313731a.put(Integer.valueOf(i3), aVar);
        if (aVar.f313735b > 3) {
            c();
        }
    }

    public static void c() {
        if (System.currentTimeMillis() - f313733c > 3600000) {
            for (a aVar : f313731a.values()) {
                HashMap<String, String> hashMap = new HashMap<>(4);
                hashMap.put("type", String.valueOf(aVar.f313734a));
                hashMap.put("totalNum", String.valueOf(aVar.f313735b));
                hashMap.put("hasProc", String.valueOf(aVar.f313736c));
                hashMap.put("noProc", String.valueOf(aVar.f313737d));
                ((m) aa.k(m.class)).collectPerformance(null, "actPreloadWebview", true, 0L, 0L, hashMap, null);
            }
            for (a aVar2 : f313732b.values()) {
                HashMap<String, String> hashMap2 = new HashMap<>(4);
                hashMap2.put("type", String.valueOf(aVar2.f313734a));
                hashMap2.put("totalNum", String.valueOf(aVar2.f313735b));
                hashMap2.put("hasProc", String.valueOf(aVar2.f313736c));
                hashMap2.put("noProc", String.valueOf(aVar2.f313737d));
                ((m) aa.k(m.class)).collectPerformance(null, "actJumpWebview", true, 0L, 0L, hashMap2, null);
            }
            f313731a.clear();
            f313732b.clear();
            f313733c = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d(IPreloadService.TAG, 2, "reportInterval...");
            }
        }
    }
}

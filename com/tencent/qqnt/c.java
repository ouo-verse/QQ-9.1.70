package com.tencent.qqnt;

import android.app.Application;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.fragment.app.Argus;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.cache.core.manager.api.ClearMode;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.qui.immersive.color.l;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.richframework.argus.QQArgusManager;
import com.tencent.richframework.preload.activity.ArgusPreloadManager;
import java.util.ArrayList;
import java.util.Set;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes23.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a implements com.tencent.mobileqq.perf.memory.cache.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.perf.memory.cache.a
        public void onClear(@NonNull ClearMode clearMode, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, clearMode, Float.valueOf(f16));
            } else if (clearMode == ClearMode.LowMemory && f16 == 0.0f && c.a()) {
                ArgusPreloadManager.INSTANCE.getLayoutPreLoader().clearAll(false);
            }
        }

        @Override // com.tencent.mobileqq.perf.memory.cache.a
        public void onTrimMemory(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
        }
    }

    static /* bridge */ /* synthetic */ boolean a() {
        return f();
    }

    public static void b(Application application) {
        int i3 = MobileQQ.sProcessId;
        if (i3 != 7 && i3 != 4) {
            d(application);
            c(application);
        }
    }

    private static void c(Application application) {
        Argus argus = Argus.INSTANCE;
        argus.startMonitor(application);
        if (g()) {
            RFWLayoutPreLoader.globalBlackLayoutIds.add(Integer.valueOf(R.layout.f167792hn));
        }
        Set<Integer> set = RFWLayoutPreLoader.globalBlackLayoutIds;
        set.add(Integer.valueOf(R.layout.buu));
        set.add(Integer.valueOf(R.layout.bv8));
        ArgusPreloadManager argusPreloadManager = ArgusPreloadManager.INSTANCE;
        argusPreloadManager.getLayoutPreLoader().setPreloadPending(!InitSkin.sInited);
        if (e()) {
            argus.registerComponentCallback(argusPreloadManager);
        }
        argus.registerComponentCallback(QQArgusManager.INSTANCE);
        com.tencent.mobileqq.perf.memory.cache.b.f257663a.c(new a());
    }

    private static void d(Application application) {
        QUIImmersiveHelper.m(application);
        ArrayList arrayList = new ArrayList();
        com.tencent.mobileqq.qui.immersive.color.f.a(new l());
        if (com.tencent.mobileqq.immersive.a.d()) {
            com.tencent.mobileqq.qui.immersive.color.f.a(new com.tencent.mobileqq.immersive.colorfetcher.a());
        }
        QUIImmersiveHelper.f(arrayList);
    }

    private static boolean e() {
        return RFWConfig.getConfigValue("ENABLE_ARGUS_AUTO_PRELOAD", true);
    }

    private static boolean f() {
        return RFWConfig.getConfigValue("ARGUS_PRELOAD_CLEAR_ON_LOW_MEMORY", true);
    }

    public static boolean g() {
        if ("VIVO".equalsIgnoreCase(Build.MANUFACTURER) && Build.VERSION.SDK_INT == 34) {
            return true;
        }
        return false;
    }
}

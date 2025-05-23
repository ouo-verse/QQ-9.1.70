package com.tencent.cache.core.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f98836a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14830);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f98836a = new e();
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Debug.MemoryInfo a(e eVar, int i3, int i16) {
        Context appContext;
        Debug.MemoryInfo[] memoryInfoArr;
        boolean z16;
        Debug.MemoryInfo memoryInfo;
        boolean z17;
        if ((i16 & 1) != 0) {
            i3 = Process.myPid();
        }
        if (Build.VERSION.SDK_INT > 28 && i3 == Process.myPid()) {
            Debug.MemoryInfo memoryInfo2 = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo2);
            return memoryInfo2;
        }
        com.tencent.cache.core.manager.api.b b16 = com.tencent.cache.core.manager.api.c.f98725d.b();
        if (b16 != null && (appContext = b16.getAppContext()) != null) {
            Object systemService = appContext.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (systemService != null) {
                try {
                    memoryInfoArr = SystemMethodProxy.getProcessMemoryInfo((ActivityManager) systemService, new int[]{i3});
                } catch (Exception e16) {
                    b.f98833f.c("MemoryUtil", 1, e16, new Object[0]);
                    memoryInfoArr = null;
                }
                if (memoryInfoArr != null) {
                    if (memoryInfoArr.length == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        z16 = false;
                        if (z16 && (memoryInfo = memoryInfoArr[0]) != null) {
                            Intrinsics.checkNotNull(memoryInfo);
                            return memoryInfo;
                        }
                        b.f98833f.j("MemoryUtil", 1, "getThrottledMemoryInfo, get memInfo failed");
                        return new Debug.MemoryInfo();
                    }
                }
                z16 = true;
                if (z16) {
                }
                b.f98833f.j("MemoryUtil", 1, "getThrottledMemoryInfo, get memInfo failed");
                return new Debug.MemoryInfo();
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
        }
        return new Debug.MemoryInfo();
    }
}

package com.tencent.mobileqq.qmethodmonitor.monitor;

import android.os.Build;
import android.os.Process;
import com.tencent.mobileqq.perf.tool.CpuUtil;
import com.tencent.mobileqq.perf.tool.MemoryUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ds;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cr3.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static List<String> f261912a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qmethodmonitor.monitor.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    class C8284a implements c {
        C8284a() {
        }

        @Override // cr3.c
        public boolean a(String str, String str2, ClassLoader classLoader) {
            de2.a aVar = (de2.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100038");
            if (aVar == null) {
                return false;
            }
            a.h(str, str2, classLoader, aVar.f393657e);
            if (aVar.f393658f) {
                List<String> list = aVar.f393659h;
                if (list != null && list.size() > 0) {
                    a.f261912a = aVar.f393659h;
                }
                Iterator it = a.f261912a.iterator();
                while (it.hasNext()) {
                    if (str.contains((String) it.next())) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // cr3.c
        public void b(String str, Exception exc) {
            QLog.e("DexMonitor", 1, "onTransformError: ", exc);
        }

        @Override // cr3.c
        public void c(String str, File file) {
            QLog.d("DexMonitor", 1, "onTransformEnd. sourceName: " + str + " newSourceFile: " + file);
            try {
                TreeMap treeMap = new TreeMap();
                Runtime runtime = Runtime.getRuntime();
                long freeMemory = runtime.freeMemory() / 1048576;
                long j3 = (runtime.totalMemory() / 1048576) - freeMemory;
                treeMap.put("source_name", str);
                treeMap.put("cpu", String.valueOf(CpuUtil.f258160a.g(Process.myPid()) * 100.0f));
                treeMap.put("pss_memory", String.valueOf(MemoryUtil.l(Process.myPid()).getTotalPss() / 1024.0f));
                treeMap.put("free_memory", String.valueOf(freeMemory));
                treeMap.put("free_used_memory", String.valueOf(j3));
                com.tencent.mobileqq.qmethodmonitor.a.b("dex_monitor_performance", treeMap);
            } catch (Exception e16) {
                QLog.e("DexMonitor", 1, "perf report error ", e16);
            }
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        f261912a = arrayList;
        arrayList.add("/zip_download/kingcard");
    }

    public static long c(String str) {
        if (str == null) {
            return 0L;
        }
        try {
            File file = new File(str);
            if (!file.exists() || file.length() <= 0) {
                return 0L;
            }
            return file.length();
        } catch (Exception e16) {
            QLog.e("DexMonitor", 1, "getFileSize error ", e16);
            return 0L;
        }
    }

    public static boolean d() {
        return "com.tencent.mobileqq".equals(MobileQQ.sMobileQQ.getQQProcessName());
    }

    private static boolean e() {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        de2.a aVar = (de2.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100038");
        QLog.d("DexMonitor", 1, "config: " + aVar);
        if (aVar == null) {
            return false;
        }
        return aVar.f393656d;
    }

    private static boolean f() {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        de2.a aVar = (de2.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100038");
        QLog.d("DexMonitor", 1, "config: " + aVar);
        if (aVar == null || !aVar.f393656d || !aVar.f393658f) {
            return false;
        }
        return true;
    }

    public static void g() {
        if (e()) {
            er3.a.a(BaseApplication.getContext(), new C8284a());
            er3.a.d(1);
        }
    }

    public static void h(String str, String str2, ClassLoader classLoader, int i3) {
        try {
            long c16 = c(str);
            String str3 = "null";
            if (classLoader != null) {
                str3 = classLoader.getClass().getName();
            }
            QLog.d("DexMonitor", 1, "DexMonitor Open Dex File source: " + str + " | sourceSize: " + c16 + " output: " + str2 + " | classLoader: " + str3);
            if (ds.d(0, i3) == 1) {
                TreeMap treeMap = new TreeMap();
                treeMap.put("source_name", str);
                treeMap.put("output_name", str2);
                treeMap.put("source_size", String.valueOf(c16));
                treeMap.put("class_loader_name", str3);
                com.tencent.mobileqq.qmethodmonitor.a.b("dex_monitor", treeMap);
            }
        } catch (Exception e16) {
            QLog.e("DexMonitor", 1, "onOpenFile error:", e16);
        }
    }

    public static void i() {
        if (f() && d() && com.tencent.mobileqq.qmethodmonitor.a.a(BaseApplication.getContext())) {
            List<String> b16 = er3.a.b(BaseApplication.getContext());
            QLog.d("DexMonitor", 1, "start Transform. TransformList:" + b16);
            if (b16.size() == 0) {
                return;
            }
            try {
                er3.a.e(BaseApplication.getContext());
            } catch (Throwable th5) {
                QLog.e("DexMonitor", 1, "DexMonitor startTransform", th5);
            }
        }
    }
}

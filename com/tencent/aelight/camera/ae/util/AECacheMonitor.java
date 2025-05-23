package com.tencent.aelight.camera.ae.util;

import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.ae.j;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AECacheMonitor {

    /* renamed from: a, reason: collision with root package name */
    private List<a> f65735a = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface c {
        void a(long j3, HashMap<String, String> hashMap, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        protected static final AECacheMonitor f65745a = new AECacheMonitor();
    }

    private long f(File file, boolean z16, String str, ArrayList<b> arrayList) {
        if (file.isDirectory()) {
            long j3 = 0;
            for (File file2 : file.listFiles()) {
                long f16 = f(file2, false, null, null);
                if (z16) {
                    e(file2, str, arrayList, f16);
                }
                j3 += f16;
            }
            return j3;
        }
        return FileUtils.getFileSizes(file.getAbsolutePath());
    }

    public static AECacheMonitor g() {
        return d.f65745a;
    }

    private long i(String str, ArrayList<b> arrayList) {
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (str.equals(next.f65741a)) {
                return next.f65743c;
            }
        }
        return 0L;
    }

    private boolean j() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        return !from.isAccessible() || System.currentTimeMillis() - from.decodeLong(AECameraConstants.SP_KEY_AE_MONITOR_TIME, 0L) > 86400000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f65735a.size() > 0) {
            ms.a.f("AECacheMonitor", "already register cache.");
            return;
        }
        this.f65735a.add(new a(this, "sandboxCaptureMaterial", j.a.f65591b, true));
        this.f65735a.add(new a(this, "sandboxCaptureCache", j.a.f65592c, true));
        this.f65735a.add(new a(this, "internalFile", j.a.f65590a, true));
        this.f65735a.add(new a(this, "bundleSoFile", g.a.c.f65267b, true));
        this.f65735a.add(new a(this, "sandboxWinkEditorFile", u53.b.f438370a, true));
        this.f65735a.add(new a(this, "sandboxWinkEditorCache", u53.a.f438360a, true));
        this.f65735a.add(new a(this, "sandboxWinkPag", u53.c.f438380a, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<b> m() {
        ArrayList<b> arrayList = new ArrayList<>();
        try {
            long j3 = 0;
            for (a aVar : this.f65735a) {
                long f16 = f(new File(aVar.f65738b), aVar.f65739c, aVar.f65737a, arrayList);
                if (f16 > 0) {
                    arrayList.add(new b(aVar, f16));
                    j3 += f16;
                }
            }
            arrayList.add(new b("total_cache_size", "", j3));
        } catch (Throwable th5) {
            ms.a.c("AECacheMonitor", "startCollectData|" + th5.getMessage());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        if (from.isAccessible()) {
            from.encodeLong(AECameraConstants.SP_KEY_AE_MONITOR_TIME, System.currentTimeMillis());
        }
    }

    public void o(final c cVar) {
        if (cVar == null && !j()) {
            ms.a.c("AECacheMonitor", "It is too closely to monitor.The job will be terminal.");
        } else {
            ms.a.f("AECacheMonitor", "Will Start monitor.");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.util.AECacheMonitor.1
                @Override // java.lang.Runnable
                public void run() {
                    ms.a.f("AECacheMonitor", "Start monitor...");
                    AECacheMonitor.this.k();
                    ms.a.f("AECacheMonitor", "registerCache end...");
                    ArrayList m3 = AECacheMonitor.this.m();
                    ms.a.f("AECacheMonitor", "startCollectData end..." + m3.size());
                    AECacheMonitor.this.l(m3, cVar);
                    if (cVar == null) {
                        AECacheMonitor.this.p();
                    }
                    ms.a.f("AECacheMonitor", "End monitor.");
                }
            }, 64, null, false);
        }
    }

    public void n() {
        o(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        String f65737a;

        /* renamed from: b, reason: collision with root package name */
        String f65738b;

        /* renamed from: c, reason: collision with root package name */
        boolean f65739c;

        a(String str, String str2) {
            this.f65739c = false;
            this.f65737a = str;
            this.f65738b = str2;
        }

        a(AECacheMonitor aECacheMonitor, String str, String str2, boolean z16) {
            this(str, str2);
            this.f65739c = z16;
        }
    }

    private long h(long j3) {
        return j3 / 1048576;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        String f65741a;

        /* renamed from: b, reason: collision with root package name */
        String f65742b;

        /* renamed from: c, reason: collision with root package name */
        long f65743c;

        b(a aVar, long j3) {
            this.f65743c = 0L;
            this.f65741a = aVar.f65737a;
            this.f65742b = aVar.f65738b;
            this.f65743c = j3;
        }

        b(String str, String str2, long j3) {
            this.f65741a = str;
            this.f65742b = str2;
            this.f65743c = j3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(ArrayList<b> arrayList, c cVar) {
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb5 = new StringBuilder();
            HashMap<String, String> hashMap = new HashMap<>();
            Iterator<b> it = arrayList.iterator();
            long j3 = 0;
            long j16 = 0;
            while (it.hasNext()) {
                b next = it.next();
                long h16 = h(next.f65743c);
                if (h16 > j3) {
                    if (j16 > j3) {
                        sb5.append(",\n");
                    }
                    j16 += next.f65743c;
                    hashMap.put(next.f65741a, "" + h16);
                    sb5.append("{ id:" + next.f65741a + ",path:" + next.f65742b + ",size:" + h(next.f65743c) + "}");
                    j3 = 0;
                }
            }
            long h17 = h(i("sandboxWinkEditorFile", arrayList) + i("sandboxWinkEditorCache", arrayList) + i("sandboxWinkPag", arrayList));
            long h18 = h(i("bundleSoFile", arrayList));
            long h19 = h(i("total_cache_size", arrayList));
            hashMap.put("total_wink_size", "" + h17);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("");
            long j17 = (h19 - h17) - h18;
            sb6.append(j17);
            hashMap.put("total_cap_size", sb6.toString());
            com.tencent.aelight.camera.ae.report.b.b().q(hashMap);
            String str = "total:" + hashMap.get("total_cache_size") + " MB,soBundle:" + h18 + "MB,cap:" + j17 + "MB,wink:" + h17 + "MB";
            if (cVar != null) {
                cVar.a(h19, hashMap, str);
            }
            ms.a.f("AECacheMonitor", str + "-->" + ("{ cacheSize:" + hashMap.get("total_cache_size") + ",info:[" + sb5.toString() + "]}"));
            return;
        }
        ms.a.c("AECacheMonitor", "reportCacheSize|info is null.");
        if (cVar != null) {
            cVar.a(-1L, null, "error.");
        }
    }

    private void e(File file, String str, ArrayList<b> arrayList, long j3) {
        if (j3 <= 0 || arrayList == null) {
            return;
        }
        try {
            arrayList.add(new b(str + "_" + file.getName(), file.getPath(), j3));
        } catch (Throwable th5) {
            ms.a.c("AECacheMonitor", "checkNeedPrintFile|exception:" + th5.getMessage());
        }
    }
}

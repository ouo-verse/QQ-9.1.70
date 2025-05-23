package com.tencent.mobileqq.statistics.storage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mm.vfs.QuotaFileSystem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.message.cleanup.tool.ChatFileCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.cleanup.tool.ZPlanCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.filescan.api.IStorageFileHelperApi;
import com.tencent.mobileqq.app.message.messageclean.q;
import com.tencent.mobileqq.nativefilescan.DirSizeData;
import com.tencent.mobileqq.nativefilescan.FileScanCore;
import com.tencent.mobileqq.nativefilescan.ILogger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class StorageReport {
    static IPatchRedirector $redirector_;

    /* renamed from: p, reason: collision with root package name */
    private static volatile StorageReport f290106p;

    /* renamed from: q, reason: collision with root package name */
    private static final RecyclablePool f290107q;

    /* renamed from: r, reason: collision with root package name */
    private static volatile Handler f290108r;

    /* renamed from: s, reason: collision with root package name */
    private static HandlerThread f290109s;

    /* renamed from: t, reason: collision with root package name */
    public static final List<String> f290110t;

    /* renamed from: u, reason: collision with root package name */
    private static final List<String> f290111u;

    /* renamed from: v, reason: collision with root package name */
    private static boolean f290112v;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<com.tencent.mobileqq.statistics.storage.a> f290113a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<com.tencent.mobileqq.statistics.storage.a> f290114b;

    /* renamed from: c, reason: collision with root package name */
    private c f290115c;

    /* renamed from: d, reason: collision with root package name */
    private d f290116d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f290117e;

    /* renamed from: f, reason: collision with root package name */
    private long f290118f;

    /* renamed from: g, reason: collision with root package name */
    private Field f290119g;

    /* renamed from: h, reason: collision with root package name */
    private String f290120h;

    /* renamed from: i, reason: collision with root package name */
    private String f290121i;

    /* renamed from: j, reason: collision with root package name */
    private final String f290122j;

    /* renamed from: k, reason: collision with root package name */
    private Field f290123k;

    /* renamed from: l, reason: collision with root package name */
    private Method f290124l;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<com.tencent.mobileqq.statistics.storage.a> f290125m;

    /* renamed from: n, reason: collision with root package name */
    private ArrayList<com.tencent.mobileqq.statistics.storage.a> f290126n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f290127o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends com.tencent.mobileqq.nativefilescan.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StorageReport.this);
            }
        }

        @Override // com.tencent.mobileqq.nativefilescan.a, com.tencent.mobileqq.nativefilescan.Callback
        public void onDirInfoAvailable(@NonNull String[] strArr, @NonNull String[] strArr2, @NonNull long[] jArr, @NonNull long[] jArr2, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, strArr, strArr2, jArr, jArr2, Integer.valueOf(i3));
                return;
            }
            for (int i16 = 0; i16 <= i3; i16++) {
                StorageReport.this.C(StorageReport.this.r(strArr[i16], strArr2[i16], jArr[i16], jArr2[i16]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements ILogger {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StorageReport.this);
            }
        }

        @Override // com.tencent.mobileqq.nativefilescan.ILogger
        public void d(@NonNull String str, @NonNull String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            } else if (QLog.isColorLevel()) {
                QLog.d("StorageReport_" + str, 2, str2);
            }
        }

        @Override // com.tencent.mobileqq.nativefilescan.ILogger
        public void e(@NonNull String str, @NonNull String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
                return;
            }
            QLog.e("StorageReport_" + str, 1, str2);
        }

        @Override // com.tencent.mobileqq.nativefilescan.ILogger
        public void i(@NonNull String str, @NonNull String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            } else if (QLog.isColorLevel()) {
                QLog.i("StorageReport_" + str, 2, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class c implements Comparator {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, obj, obj2)).intValue();
            }
            long j3 = ((com.tencent.mobileqq.statistics.storage.a) obj).f290134k;
            long j16 = ((com.tencent.mobileqq.statistics.storage.a) obj2).f290134k;
            if (j3 > j16) {
                return -1;
            }
            if (j3 < j16) {
                return 1;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class d implements Comparator {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, obj, obj2)).intValue();
            }
            long j3 = ((com.tencent.mobileqq.statistics.storage.a) obj).f290133j;
            long j16 = ((com.tencent.mobileqq.statistics.storage.a) obj2).f290133j;
            if (j3 > j16) {
                return -1;
            }
            if (j3 < j16) {
                return 1;
            }
            return 0;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75459);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
            return;
        }
        f290107q = new RecyclablePool(com.tencent.mobileqq.statistics.storage.a.class, 50);
        ArrayList arrayList = new ArrayList();
        f290110t = arrayList;
        ArrayList arrayList2 = new ArrayList();
        f290111u = arrayList2;
        f290112v = false;
        String e16 = com.tencent.mobileqq.vfs.b.i().e();
        if (e16 != null) {
            arrayList.add(e16);
            String str = e16 + "/Tencent";
            arrayList.add(str);
            arrayList2.add(str);
            String str2 = e16 + "/Tencent/MobileQQ";
            arrayList.add(str2);
            arrayList2.add(str2);
        }
        File externalCacheDir = BaseApplication.getContext().getExternalCacheDir();
        if (externalCacheDir != null && externalCacheDir.exists()) {
            arrayList.add(externalCacheDir.getPath());
            arrayList2.add(externalCacheDir.getPath());
        }
        File externalFilesDir = BaseApplication.getContext().getExternalFilesDir(null);
        if (externalFilesDir != null && externalFilesDir.exists()) {
            arrayList.add(externalFilesDir.getPath());
            arrayList2.add(externalFilesDir.getPath());
            String str3 = externalFilesDir.getPath() + "/tencent";
            arrayList.add(str3);
            arrayList2.add(str3);
            String str4 = externalFilesDir.getPath() + "/tencent/MobileQQ";
            arrayList.add(str4);
            arrayList2.add(str4);
        }
    }

    StorageReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f290113a = new ArrayList<>(20);
        this.f290114b = new ArrayList<>(40);
        this.f290115c = new c();
        this.f290116d = new d();
        this.f290117e = true;
        this.f290118f = 0L;
        this.f290119g = null;
        this.f290120h = "";
        this.f290121i = "";
        this.f290123k = null;
        this.f290124l = null;
        this.f290125m = new ArrayList<>(7);
        this.f290126n = new ArrayList<>(7);
        this.f290127o = false;
        this.f290122j = "qqStorageReport";
        boolean z16 = 0.0010000000474974513d >= Math.random();
        this.f290117e = z16;
        if (!z16) {
            QLog.d("StorageReport", 1, "--scan qq-- mNeedReport:false");
            return;
        }
        this.f290117e = ((IFeatureRuntimeService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("storage_report", true);
        QLog.d("StorageReport", 1, "--scan qq-- after feature mNeedReport:" + this.f290117e);
    }

    private void B(com.tencent.mobileqq.statistics.storage.a aVar, long j3) {
        com.tencent.mobileqq.statistics.storage.a aVar2;
        if (aVar != null && !TextUtils.isEmpty(aVar.f290132i)) {
            int i3 = 0;
            if (j3 >= 10240) {
                if (j3 >= 10240 && j3 < FaceConstant.HeadDownload.QQHEAD_SYSTEM_MIN_STORAGE_SIZE) {
                    i3 = 1;
                } else if (j3 >= FaceConstant.HeadDownload.QQHEAD_SYSTEM_MIN_STORAGE_SIZE && j3 < 1048576) {
                    i3 = 2;
                } else if (j3 >= 1048576 && j3 < 2097152) {
                    i3 = 3;
                } else if (j3 >= 2097152 && j3 < 10485760) {
                    i3 = 4;
                } else if (j3 >= 10485760 && j3 < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                    i3 = 5;
                } else if (j3 >= GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                    i3 = 6;
                }
            }
            if (aVar.f290132i.contains(com.tencent.mobileqq.app.message.filescan.d.f195978a.a())) {
                aVar2 = this.f290126n.get(i3);
            } else {
                aVar2 = this.f290125m.get(i3);
            }
            aVar2.f290133j += j3;
            aVar2.f290136m++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long C(com.tencent.mobileqq.statistics.storage.a aVar) {
        if (aVar == null) {
            return 0L;
        }
        if (aVar.f290133j >= 5242880) {
            QLog.d("StorageReport", 1, "--scan qq-- file info: " + aVar.toString());
        }
        if (aVar.f290133j >= QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT) {
            x(aVar);
        } else if (((IStorageFileHelperApi) QRoute.api(IStorageFileHelperApi.class)).isFileUnderPublicDir(aVar.f290132i)) {
            x(aVar);
        }
        B(aVar, aVar.f290133j);
        if (this.f290113a.size() < 20) {
            this.f290113a.add(aVar);
            if (this.f290113a.size() == 20) {
                Collections.sort(this.f290113a, this.f290115c);
            }
            return aVar.f290133j;
        }
        ArrayList<com.tencent.mobileqq.statistics.storage.a> arrayList = this.f290113a;
        com.tencent.mobileqq.statistics.storage.a aVar2 = arrayList.get(arrayList.size() - 1);
        if (this.f290113a.size() >= 20 && aVar.f290134k > aVar2.f290134k) {
            ArrayList<com.tencent.mobileqq.statistics.storage.a> arrayList2 = this.f290113a;
            arrayList2.remove(arrayList2.size() - 1);
            f290107q.recycle(aVar2);
            this.f290113a.add(aVar);
            Collections.sort(this.f290113a, this.f290115c);
            return aVar.f290133j;
        }
        f290107q.recycle(aVar);
        return aVar.f290133j;
    }

    private boolean D() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean z16 = false;
        if (peekAppRuntime != null) {
            z16 = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("native_file_scan", false);
        }
        QLog.d("StorageReport", 1, "useNativeScan : " + z16);
        return z16;
    }

    private void c(long j3) {
        ThreadManagerV2.excute(new Runnable(j3) { // from class: com.tencent.mobileqq.statistics.storage.StorageReport.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f290128d;

            {
                this.f290128d = j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, StorageReport.this, Long.valueOf(j3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                long totalSize = StorageReport.this.h(com.tencent.mobileqq.vfs.b.i().d()).getTotalSize();
                long totalSize2 = StorageReport.this.h(com.tencent.mobileqq.vfs.b.i().e()).getTotalSize();
                long j16 = totalSize + totalSize2;
                long totalSize3 = StorageReport.this.h(BaseApplication.getContext().getCacheDir().getAbsolutePath()).getTotalSize();
                long totalSize4 = StorageReport.this.h(BaseApplication.getContext().getExternalCacheDir().getAbsolutePath()).getTotalSize();
                long totalSize5 = StorageReport.this.h(BaseApplication.getContext().getCodeCacheDir().getAbsolutePath()).getTotalSize();
                long j17 = totalSize3 + totalSize4 + totalSize5;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("calculateStorageSize dataSize: ");
                long j18 = j16 - j17;
                sb5.append(q.c(j18));
                sb5.append(", cacheSize: ");
                sb5.append(q.c(j17));
                sb5.append(", appSize: ");
                sb5.append(q.c(this.f290128d));
                sb5.append(", totalSize: ");
                sb5.append(q.c(this.f290128d + j16));
                sb5.append(", origin dataSize: ");
                sb5.append(j18);
                sb5.append(", origin cacheSize: ");
                sb5.append(j17);
                sb5.append(", origin appSize: ");
                sb5.append(this.f290128d);
                sb5.append(", origin totalSize: ");
                sb5.append(this.f290128d + j16);
                sb5.append(", innerDataSize: ");
                sb5.append(totalSize);
                sb5.append(", sdcardPrivateSize: ");
                sb5.append(totalSize2);
                sb5.append(", innerCacheSize: ");
                sb5.append(totalSize3);
                sb5.append(", sdcardCacheSize: ");
                sb5.append(totalSize4);
                sb5.append(", innerCodeCacheSize: ");
                sb5.append(totalSize5);
                sb5.append(", cost: ");
                sb5.append(SystemClock.uptimeMillis() - uptimeMillis);
                QLog.d("StorageReport", 1, sb5.toString());
            }
        }, 64, null, true);
    }

    private ILogger d() {
        return new b();
    }

    private String j(ArrayList<com.tencent.mobileqq.statistics.storage.a> arrayList) {
        StringBuilder sb5 = new StringBuilder(64);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            com.tencent.mobileqq.statistics.storage.a aVar = arrayList.get(i3);
            sb5.append(aVar.f290136m);
            sb5.append("-");
            sb5.append(aVar.f290133j);
            if (i3 < arrayList.size() - 1) {
                sb5.append("|");
            }
        }
        return sb5.toString();
    }

    public static StorageReport k() {
        if (f290106p == null) {
            synchronized (StorageReport.class) {
                if (f290106p == null) {
                    f290106p = new StorageReport();
                }
            }
        }
        return f290106p;
    }

    private int l() {
        List<SimpleAccount> allAccounts = MobileQQ.sMobileQQ.getAllAccounts();
        if (allAccounts == null) {
            return 1;
        }
        return allAccounts.size();
    }

    private String m(String str) {
        String[] split = str.split(File.separator);
        if (split != null && split.length > 0) {
            return split[split.length - 1];
        }
        return str;
    }

    public static synchronized Handler p() {
        Handler handler;
        synchronized (StorageReport.class) {
            if (f290108r == null) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("SETTING_STORAGE_CLEAN_SCAN", 0);
                f290109s = baseHandlerThread;
                baseHandlerThread.start();
                f290108r = new Handler(f290109s.getLooper());
            }
            handler = f290108r;
        }
        return handler;
    }

    @Nullable
    private com.tencent.mobileqq.statistics.storage.a q(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str + "/" + str2);
        if (file.isDirectory()) {
            return null;
        }
        com.tencent.mobileqq.statistics.storage.a aVar = (com.tencent.mobileqq.statistics.storage.a) f290107q.obtain(com.tencent.mobileqq.statistics.storage.a.class);
        aVar.f290131h = str2;
        aVar.f290135l = true;
        aVar.f290133j = file.length();
        aVar.f290132i = str + "/" + str2;
        aVar.f290134k = i(file);
        aVar.f290136m = 1L;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public com.tencent.mobileqq.statistics.storage.a r(String str, String str2, long j3, long j16) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            long j17 = 0;
            if (j3 != 0) {
                j17 = Math.max(this.f290118f - j3, 0L);
            }
            com.tencent.mobileqq.statistics.storage.a aVar = (com.tencent.mobileqq.statistics.storage.a) f290107q.obtain(com.tencent.mobileqq.statistics.storage.a.class);
            aVar.f290131h = str2;
            aVar.f290135l = true;
            aVar.f290133j = j16;
            aVar.f290132i = str + File.separator + str2;
            aVar.f290134k = j17;
            aVar.f290136m = 1L;
            return aVar;
        }
        return null;
    }

    public static synchronized void s() {
        synchronized (StorageReport.class) {
            if (f290108r != null) {
                f290108r.removeCallbacks(null);
                f290108r = null;
            }
            HandlerThread handlerThread = f290109s;
            if (handlerThread != null) {
                handlerThread.quit();
                f290109s = null;
            }
        }
    }

    public void A(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.f290127o = z16;
        }
    }

    public long e(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList)).longValue();
        }
        long j3 = 0;
        if (arrayList != null && arrayList.size() != 0) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                String str = arrayList.get(i3);
                String[] list = new File(str).list();
                if (list != null && list.length > 0) {
                    for (String str2 : list) {
                        File file = new File(str, str2);
                        if (file.isFile()) {
                            j3 += file.length();
                        }
                    }
                }
            }
        }
        return j3;
    }

    public Bundle f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bundle) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        Bundle bundle = new Bundle();
        Stack stack = new Stack();
        stack.push(str);
        long j3 = 0;
        long j16 = 0;
        long j17 = 0;
        while (!stack.isEmpty()) {
            File file = new File((String) stack.pop());
            if (file.isDirectory()) {
                String[] list = file.list();
                if (list != null) {
                    for (String str2 : list) {
                        File file2 = new File(file, str2);
                        if (file2.isDirectory()) {
                            stack.push(file2.getAbsolutePath());
                        } else {
                            C(q(file.getAbsolutePath(), str2));
                            j3 += file2.length();
                            j16++;
                        }
                    }
                }
                j17++;
            } else {
                C(q(file.getParent(), file.getName()));
                j16++;
            }
            j3 += file.length();
        }
        bundle.putLong("key_size", j3);
        bundle.putLong("key_file_count", j16);
        bundle.putLong("key_dir_count", j17);
        return bundle;
    }

    public DirSizeData g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (DirSizeData) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        DirSizeData dirSizeData = new DirSizeData();
        FileScanCore.INSTANCE.a(d()).d(str, false, true, dirSizeData, new a());
        return dirSizeData;
    }

    public DirSizeData h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (DirSizeData) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        DirSizeData dirSizeData = new DirSizeData();
        FileScanCore.INSTANCE.a(d()).d(str, false, true, dirSizeData, null);
        return dirSizeData;
    }

    public long i(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Long) iPatchRedirector.redirect((short) 19, (Object) this, (Object) file)).longValue();
        }
        try {
            try {
                try {
                    if (this.f290119g == null) {
                        Field declaredField = Class.forName("libcore.io.Libcore").getDeclaredField("os");
                        this.f290119g = declaredField;
                        if (!declaredField.isAccessible()) {
                            this.f290119g.setAccessible(true);
                        }
                    }
                    Object obj = this.f290119g.get(null);
                    if (this.f290124l == null) {
                        this.f290124l = obj.getClass().getMethod("lstat", String.class);
                    }
                    Object invoke = this.f290124l.invoke(obj, file.getAbsolutePath());
                    if (this.f290123k == null) {
                        Field declaredField2 = invoke.getClass().getDeclaredField("st_atime");
                        this.f290123k = declaredField2;
                        if (!declaredField2.isAccessible()) {
                            this.f290123k.setAccessible(true);
                        }
                    }
                    long j3 = this.f290123k.getLong(invoke);
                    if (j3 == 0) {
                        return 0L;
                    }
                    long j16 = this.f290118f - j3;
                    if (j16 < 0) {
                        return 0L;
                    }
                    return j16;
                } catch (NoSuchFieldException e16) {
                    e16.printStackTrace();
                    return 0L;
                } catch (InvocationTargetException e17) {
                    e17.printStackTrace();
                    return 0L;
                }
            } catch (IllegalAccessException e18) {
                e18.printStackTrace();
                return 0L;
            } catch (NoSuchMethodException e19) {
                e19.printStackTrace();
                return 0L;
            }
        } catch (ClassNotFoundException e26) {
            e26.printStackTrace();
            return 0L;
        }
    }

    public boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f290127o;
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x0575 A[Catch: all -> 0x07cc, TryCatch #6 {, blocks: (B:4:0x0007, B:6:0x000e, B:8:0x0015, B:12:0x0035, B:14:0x0047, B:15:0x004a, B:17:0x005d, B:18:0x0065, B:22:0x00a0, B:24:0x00af, B:25:0x00bc, B:28:0x00d4, B:30:0x00fb, B:31:0x010e, B:33:0x0116, B:35:0x0127, B:37:0x012a, B:39:0x0152, B:43:0x01f4, B:44:0x0178, B:46:0x0183, B:48:0x01bb, B:50:0x01d7, B:52:0x01ed, B:55:0x01f0, B:62:0x0207, B:64:0x020b, B:66:0x0215, B:68:0x0222, B:70:0x0243, B:73:0x0246, B:74:0x0258, B:76:0x025e, B:78:0x0271, B:80:0x0276, B:82:0x027a, B:84:0x02aa, B:86:0x030b, B:87:0x02c4, B:89:0x02cb, B:91:0x02e9, B:93:0x0309, B:103:0x0336, B:104:0x036c, B:106:0x0374, B:191:0x038c, B:195:0x0399, B:197:0x039c, B:202:0x03a4, B:205:0x03b6, B:208:0x03db, B:139:0x0551, B:131:0x0575, B:133:0x0589, B:111:0x045d, B:172:0x0469, B:175:0x0473, B:177:0x0485, B:125:0x04fd, B:128:0x0501, B:115:0x049e, B:152:0x04a8, B:155:0x04ae, B:157:0x04c7, B:119:0x04e5, B:122:0x04ed, B:110:0x043a, B:231:0x0591, B:232:0x05b5, B:234:0x05bd, B:236:0x05cb, B:237:0x0763, B:239:0x076b, B:241:0x078f, B:243:0x0793, B:246:0x07a6, B:250:0x07c5), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0587  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized long o(com.tencent.mobileqq.app.message.filescan.c cVar, int i3, int i16) {
        long j3;
        boolean z16;
        int i17;
        long j16;
        long j17;
        String str;
        long currentTimeMillis;
        String[] strArr;
        StringBuilder sb5;
        Exception exc;
        long j18;
        SharedPreferences sharedPreferences;
        long j19;
        String[] strArr2;
        Iterator<String> it;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i19 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, this, cVar, Integer.valueOf(i3), Integer.valueOf(i16))).longValue();
        }
        QLog.d("StorageReport", 1, "--scan qq-- getQQStorageSize()");
        long h16 = q.h(true);
        c(h16);
        if (cVar != null) {
            cVar.a(i3);
        }
        this.f290118f = System.currentTimeMillis() / 1000;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null) {
            String currentAccountUin = runtime.getCurrentAccountUin();
            this.f290121i = currentAccountUin;
            this.f290120h = currentAccountUin;
        }
        this.f290120h += "_" + String.valueOf(this.f290118f);
        SharedPreferences sharedPreferences2 = BaseApplicationImpl.getApplication().getSharedPreferences("sp_storage_report", 0);
        long j26 = sharedPreferences2.getLong("sp_key_storage_report_time", 0L);
        if (this.f290117e && j26 > 0) {
            j3 = h16;
            if (Math.abs(this.f290118f - j26) < 86400) {
                this.f290117e = false;
                QLog.d("StorageReport", 2, "--scan qq-- report in one day set mNeedReport = false");
            }
        } else {
            j3 = h16;
        }
        this.f290114b.clear();
        this.f290113a.clear();
        this.f290125m.clear();
        this.f290126n.clear();
        for (int i26 = 0; i26 < 7; i26++) {
            RecyclablePool recyclablePool = f290107q;
            com.tencent.mobileqq.statistics.storage.a aVar = (com.tencent.mobileqq.statistics.storage.a) recyclablePool.obtain(com.tencent.mobileqq.statistics.storage.a.class);
            aVar.f290133j = 0L;
            aVar.f290136m = 0L;
            this.f290125m.add(aVar);
            com.tencent.mobileqq.statistics.storage.a aVar2 = (com.tencent.mobileqq.statistics.storage.a) recyclablePool.obtain(com.tencent.mobileqq.statistics.storage.a.class);
            aVar2.f290133j = 0L;
            aVar2.f290136m = 0L;
            this.f290126n.add(aVar2);
        }
        Iterator<String> it5 = f290110t.iterator();
        long j27 = 0;
        long j28 = 0;
        long j29 = 0;
        long j36 = 0;
        long j37 = 0;
        long j38 = 0;
        long j39 = 0;
        while (it5.hasNext()) {
            String next = it5.next();
            String[] list = new File(next).list();
            if (list != null && list.length > 0) {
                QLog.d("StorageReport", 1, "--scan qq-- file path:" + next + ", list count:" + list.length);
                String[] strArr3 = list;
                int length = strArr3.length;
                int i27 = i19;
                while (i27 < length) {
                    String str2 = strArr3[i27];
                    String str3 = next + "/" + str2;
                    if (f290111u.contains(str3)) {
                        strArr2 = strArr3;
                        it = it5;
                        i18 = length;
                    } else {
                        File file = new File(str3);
                        if (file.isDirectory()) {
                            com.tencent.mobileqq.statistics.storage.a aVar3 = new com.tencent.mobileqq.statistics.storage.a();
                            strArr2 = strArr3;
                            aVar3.f290135l = false;
                            it = it5;
                            i18 = length;
                            aVar3.f290134k = i(file);
                            aVar3.f290131h = str2;
                            aVar3.f290132i = next + "/" + str2;
                            aVar3.f290136m = 0L;
                            aVar3.f290137n = 0L;
                            this.f290114b.add(aVar3);
                        } else {
                            strArr2 = strArr3;
                            it = it5;
                            i18 = length;
                            long C = C(q(next, str2));
                            j27 += C;
                            j28 += C;
                            if (next.contains(com.tencent.mobileqq.app.message.filescan.d.f195978a.d())) {
                                j37 += C;
                                j38++;
                                if (next.contains(BaseApplication.getContext().getExternalCacheDir().getPath())) {
                                    j39 += C;
                                }
                            } else {
                                j29 += C;
                                j36++;
                            }
                        }
                    }
                    i27++;
                    it5 = it;
                    strArr3 = strArr2;
                    length = i18;
                }
            }
            it5 = it5;
            i19 = 0;
        }
        if (f290112v) {
            for (String str4 : com.tencent.mobileqq.app.message.filescan.d.f195978a.i()) {
                File file2 = new File(str4);
                if (file2.isDirectory()) {
                    com.tencent.mobileqq.statistics.storage.a aVar4 = new com.tencent.mobileqq.statistics.storage.a();
                    aVar4.f290135l = false;
                    aVar4.f290134k = i(file2);
                    aVar4.f290131h = m(str4);
                    aVar4.f290132i = str4;
                    aVar4.f290136m = 0L;
                    aVar4.f290137n = 0L;
                    this.f290114b.add(aVar4);
                }
            }
        }
        Iterator<String> it6 = com.tencent.mobileqq.app.message.filescan.d.f195978a.e().iterator();
        long j46 = j28;
        long j47 = 0;
        long j48 = 0;
        long j49 = 0;
        while (it6.hasNext()) {
            String next2 = it6.next();
            Iterator<String> it7 = it6;
            String[] list2 = new File(next2).list();
            if (list2 != null) {
                j19 = j47;
                if (list2.length > 0) {
                    int length2 = list2.length;
                    int i28 = 0;
                    while (i28 < length2) {
                        int i29 = length2;
                        String str5 = list2[i28];
                        String[] strArr4 = list2;
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(next2);
                        SharedPreferences sharedPreferences3 = sharedPreferences2;
                        sb6.append("/");
                        sb6.append(str5);
                        String sb7 = sb6.toString();
                        File file3 = new File(sb7);
                        long j56 = j3;
                        if (com.tencent.mobileqq.app.message.filescan.d.f195978a.c().contains(sb7)) {
                            QLog.d("StorageReport", 2, "--scan qq-- dir pass " + str5);
                        } else if (file3.isDirectory()) {
                            com.tencent.mobileqq.statistics.storage.a aVar5 = new com.tencent.mobileqq.statistics.storage.a();
                            aVar5.f290135l = false;
                            aVar5.f290134k = i(file3);
                            aVar5.f290131h = str5;
                            aVar5.f290132i = sb7;
                            aVar5.f290136m = 0L;
                            aVar5.f290137n = 0L;
                            this.f290114b.add(aVar5);
                        } else {
                            long C2 = C(q(next2, str5));
                            j27 += C2;
                            j46 += C2;
                            j19 += C2;
                            j48++;
                            if (next2.contains(BaseApplication.getContext().getCacheDir().getPath())) {
                                j49 += C2;
                            }
                        }
                        i28++;
                        length2 = i29;
                        list2 = strArr4;
                        sharedPreferences2 = sharedPreferences3;
                        j3 = j56;
                    }
                    sharedPreferences = sharedPreferences2;
                } else {
                    sharedPreferences = sharedPreferences2;
                }
            } else {
                sharedPreferences = sharedPreferences2;
                j19 = j47;
            }
            j47 = j19;
            it6 = it7;
            sharedPreferences2 = sharedPreferences;
            j3 = j3;
        }
        SharedPreferences sharedPreferences4 = sharedPreferences2;
        long j57 = j3;
        QLog.d("StorageReport", 1, "--scan qq-- begin scan,mCurrentScanTime = " + this.f290118f);
        boolean D = D();
        long j58 = j49;
        long j59 = j29;
        long j65 = j37;
        long j66 = j39;
        long j67 = j47;
        long j68 = 0;
        int i36 = 0;
        long j69 = 0;
        long j75 = 0;
        while (i36 < this.f290114b.size()) {
            com.tencent.mobileqq.statistics.storage.a aVar6 = this.f290114b.get(i36);
            long j76 = j46;
            aVar6.f290133j = 0L;
            aVar6.f290136m = 0L;
            aVar6.f290137n = 0L;
            aVar6.f290138o = 0L;
            String str6 = aVar6.f290132i;
            if (!D) {
                try {
                    String[] list3 = new File(str6).list();
                    if (list3 != null) {
                        z16 = D;
                        try {
                            if (list3.length > 0) {
                                int length3 = list3.length;
                                i17 = i36;
                                int i37 = 0;
                                while (i37 < length3) {
                                    int i38 = length3;
                                    try {
                                        str = list3[i37];
                                        currentTimeMillis = System.currentTimeMillis();
                                        strArr = list3;
                                        sb5 = new StringBuilder();
                                        sb5.append(str6);
                                        j17 = j27;
                                    } catch (Exception e16) {
                                        e = e16;
                                        exc = e;
                                        exc.printStackTrace();
                                        QLog.d("StorageReport", 1, "--scan qq-- except: " + exc.getStackTrace());
                                        if (cVar == null) {
                                        }
                                        i36 = i17 + 1;
                                        j46 = j76;
                                        D = z16;
                                    }
                                    try {
                                        sb5.append(File.separator);
                                        sb5.append(str);
                                        Bundle f16 = f(sb5.toString());
                                        aVar6.f290138o += System.currentTimeMillis() - currentTimeMillis;
                                        j16 = j68;
                                        try {
                                            aVar6.f290133j += f16.getLong("key_size", 0L);
                                            aVar6.f290136m += f16.getLong("key_file_count", 0L);
                                            aVar6.f290137n += f16.getLong("key_dir_count", 0L);
                                            i37++;
                                            length3 = i38;
                                            j68 = j16;
                                            list3 = strArr;
                                            j27 = j17;
                                        } catch (Exception e17) {
                                            e = e17;
                                            exc = e;
                                            j68 = j16;
                                            j27 = j17;
                                            exc.printStackTrace();
                                            QLog.d("StorageReport", 1, "--scan qq-- except: " + exc.getStackTrace());
                                            if (cVar == null) {
                                            }
                                            i36 = i17 + 1;
                                            j46 = j76;
                                            D = z16;
                                        }
                                    } catch (Exception e18) {
                                        e = e18;
                                        exc = e;
                                        j27 = j17;
                                        exc.printStackTrace();
                                        QLog.d("StorageReport", 1, "--scan qq-- except: " + exc.getStackTrace());
                                        if (cVar == null) {
                                        }
                                        i36 = i17 + 1;
                                        j46 = j76;
                                        D = z16;
                                    }
                                }
                                j16 = j68;
                                j17 = j27;
                            }
                        } catch (Exception e19) {
                            e = e19;
                            i17 = i36;
                            exc = e;
                            exc.printStackTrace();
                            QLog.d("StorageReport", 1, "--scan qq-- except: " + exc.getStackTrace());
                            if (cVar == null) {
                            }
                            i36 = i17 + 1;
                            j46 = j76;
                            D = z16;
                        }
                    } else {
                        z16 = D;
                    }
                    j16 = j68;
                    i17 = i36;
                    j17 = j27;
                } catch (Exception e26) {
                    e = e26;
                    z16 = D;
                }
            } else {
                z16 = D;
                j16 = j68;
                i17 = i36;
                j17 = j27;
                try {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    aVar6.f290133j = g(str6).getTotalSize();
                    aVar6.f290136m = r4.getFileCount();
                    aVar6.f290137n = r4.getDirCount();
                    aVar6.f290138o = SystemClock.uptimeMillis() - uptimeMillis;
                } catch (Exception e27) {
                    e = e27;
                    exc = e;
                    j68 = j16;
                    j27 = j17;
                    exc.printStackTrace();
                    QLog.d("StorageReport", 1, "--scan qq-- except: " + exc.getStackTrace());
                    if (cVar == null) {
                    }
                    i36 = i17 + 1;
                    j46 = j76;
                    D = z16;
                }
            }
            com.tencent.mobileqq.app.message.filescan.d dVar = com.tencent.mobileqq.app.message.filescan.d.f195978a;
            if (str6.contains(dVar.a())) {
                try {
                    j67 += aVar6.f290133j;
                    j48 += aVar6.f290136m;
                    j68 = j16 + aVar6.f290137n;
                    try {
                        if (str6.contains(BaseApplication.getContext().getCacheDir().getPath())) {
                            j58 += aVar6.f290133j;
                        }
                    } catch (Exception e28) {
                        e = e28;
                        exc = e;
                        j27 = j17;
                        exc.printStackTrace();
                        QLog.d("StorageReport", 1, "--scan qq-- except: " + exc.getStackTrace());
                        if (cVar == null) {
                        }
                        i36 = i17 + 1;
                        j46 = j76;
                        D = z16;
                    }
                } catch (Exception e29) {
                    e = e29;
                    exc = e;
                    j68 = j16;
                    j27 = j17;
                    exc.printStackTrace();
                    QLog.d("StorageReport", 1, "--scan qq-- except: " + exc.getStackTrace());
                    if (cVar == null) {
                    }
                    i36 = i17 + 1;
                    j46 = j76;
                    D = z16;
                }
            } else {
                long j77 = j58;
                try {
                    if (str6.contains(dVar.d())) {
                        try {
                            j65 += aVar6.f290133j;
                            try {
                                j38 += aVar6.f290136m;
                                j69 += aVar6.f290137n;
                                if (str6.contains(BaseApplication.getContext().getExternalCacheDir().getPath())) {
                                    j66 += aVar6.f290133j;
                                }
                                j58 = j77;
                                j68 = j16;
                            } catch (Exception e36) {
                                e = e36;
                                exc = e;
                                j58 = j77;
                                j68 = j16;
                                j27 = j17;
                                exc.printStackTrace();
                                QLog.d("StorageReport", 1, "--scan qq-- except: " + exc.getStackTrace());
                                if (cVar == null) {
                                }
                                i36 = i17 + 1;
                                j46 = j76;
                                D = z16;
                            }
                        } catch (Exception e37) {
                            e = e37;
                        }
                    } else {
                        long j78 = j65;
                        long j79 = j66;
                        try {
                            j18 = j77;
                            j59 += aVar6.f290133j;
                            try {
                                j36 += aVar6.f290136m;
                                j75 += aVar6.f290137n;
                                j65 = j78;
                                j66 = j79;
                                j68 = j16;
                                j58 = j18;
                            } catch (Exception e38) {
                                e = e38;
                                exc = e;
                                j65 = j78;
                                j66 = j79;
                                j68 = j16;
                                j27 = j17;
                                j58 = j18;
                                exc.printStackTrace();
                                QLog.d("StorageReport", 1, "--scan qq-- except: " + exc.getStackTrace());
                                if (cVar == null) {
                                }
                                i36 = i17 + 1;
                                j46 = j76;
                                D = z16;
                            }
                        } catch (Exception e39) {
                            e = e39;
                            j18 = j77;
                        }
                    }
                } catch (Exception e46) {
                    j18 = j77;
                    exc = e46;
                }
            }
            try {
                j27 = j17 + aVar6.f290133j;
            } catch (Exception e47) {
                e = e47;
                exc = e;
                j27 = j17;
                exc.printStackTrace();
                QLog.d("StorageReport", 1, "--scan qq-- except: " + exc.getStackTrace());
                if (cVar == null) {
                }
                i36 = i17 + 1;
                j46 = j76;
                D = z16;
            }
            try {
                QLog.d("StorageReport", 1, "--scan qq-- dir info: " + aVar6.toString());
            } catch (Exception e48) {
                e = e48;
                exc = e;
                exc.printStackTrace();
                QLog.d("StorageReport", 1, "--scan qq-- except: " + exc.getStackTrace());
                if (cVar == null) {
                }
                i36 = i17 + 1;
                j46 = j76;
                D = z16;
            }
            if (cVar == null) {
                cVar.a(((i17 + 1) * (i16 - 2)) / this.f290114b.size());
            }
            i36 = i17 + 1;
            j46 = j76;
            D = z16;
        }
        long j85 = j68;
        long j86 = j46;
        long j87 = j27;
        long j88 = j58;
        long j89 = j59;
        long j95 = j65;
        long j96 = j66;
        Collections.sort(this.f290114b, this.f290116d);
        QLog.d("StorageReport", 1, "--scan qq-- dir begin to report dir info");
        for (int i39 = 0; i39 < this.f290114b.size(); i39++) {
            x(this.f290114b.get(i39));
        }
        QLog.d("StorageReport", 1, "--scan qq-- dir totalsize: " + j87);
        com.tencent.mobileqq.statistics.storage.a aVar7 = new com.tencent.mobileqq.statistics.storage.a();
        aVar7.f290135l = false;
        aVar7.f290132i = "qq";
        aVar7.f290136m = j38 + j48 + j36;
        aVar7.f290137n = j69 + j85 + j75;
        aVar7.f290134k = 0L;
        aVar7.f290133j = j87;
        x(aVar7);
        QLog.d("StorageReport", 1, "--scan qq-- total wholeItem info: " + aVar7.toString());
        com.tencent.mobileqq.statistics.storage.a aVar8 = new com.tencent.mobileqq.statistics.storage.a();
        aVar8.f290135l = false;
        aVar8.f290132i = "sdcard";
        aVar8.f290131h = j(this.f290125m);
        aVar8.f290136m = j38 + j36;
        aVar8.f290137n = j69 + j75;
        aVar8.f290134k = 0L;
        aVar8.f290133j = j95 + j89;
        x(aVar8);
        QLog.d("StorageReport", 1, "--scan qq-- total sdcardItem info: " + aVar8.toString());
        com.tencent.mobileqq.statistics.storage.a aVar9 = new com.tencent.mobileqq.statistics.storage.a();
        aVar9.f290135l = false;
        aVar9.f290132i = "inner";
        aVar9.f290131h = j(this.f290126n);
        aVar9.f290136m = j48;
        aVar9.f290137n = j85;
        aVar9.f290134k = 0L;
        aVar9.f290133j = j67;
        x(aVar9);
        QLog.d("StorageReport", 1, "--scan qq-- total innerItem info: " + aVar9.toString());
        QLog.d("StorageReport", 1, "--scan qq-- data size: " + (((j95 + j67) - j96) - j88) + ", cache size: " + (j96 + j88) + ", total size: " + (j57 + j95 + j67) + ", sdcardPublicSize:" + j89 + ", sdcardPrivateCacheSize:" + j96 + ", innerCacheSize:" + j88 + ", appSize:" + j57 + ", sdcardPrivateSize:" + j95 + ", innerSize:" + j67 + ", lossSize:" + j86);
        com.tencent.mobileqq.statistics.storage.a aVar10 = new com.tencent.mobileqq.statistics.storage.a();
        aVar10.f290135l = false;
        aVar10.f290132i = "qqbundle";
        aVar10.f290133j = j57;
        x(aVar10);
        StringBuilder sb8 = new StringBuilder();
        sb8.append("--scan qq-- total qqbundleItem info: ");
        sb8.append(aVar10);
        QLog.d("StorageReport", 1, sb8.toString());
        QLog.d("StorageReport", 1, "--scan qq-- dir begin to report old list");
        for (int i46 = 0; i46 < this.f290113a.size(); i46++) {
            com.tencent.mobileqq.statistics.storage.a aVar11 = this.f290113a.get(i46);
            aVar11.f290131h = "old_" + aVar11.f290131h;
            x(aVar11);
        }
        if (this.f290117e) {
            sharedPreferences4.edit().putLong("sp_key_storage_report_time", this.f290118f).commit();
        }
        for (int i47 = 0; i47 < 7; i47++) {
            RecyclablePool recyclablePool2 = f290107q;
            recyclablePool2.recycle(this.f290125m.get(i47));
            recyclablePool2.recycle(this.f290126n.get(i47));
        }
        if (cVar != null) {
            cVar.a(i16);
        }
        return j87;
    }

    public void t(long j3, long j16, long j17, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Boolean.valueOf(z16));
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("appSize", String.valueOf(j3));
        hashMap.put("otherSize", String.valueOf(j16));
        long j18 = j16 - j3;
        hashMap.put("otherSizeExcludeApp", String.valueOf(j18));
        hashMap.put("cacheSize", String.valueOf(j17));
        hashMap.put("is_cleanup", String.valueOf(z16 ? 1 : 0));
        hashMap.put("account", this.f290121i);
        hashMap.put("report_key", this.f290120h);
        hashMap.put("path", "otherSizeInfo");
        try {
            StringBuilder sb5 = new StringBuilder();
            com.tencent.mobileqq.app.message.filescan.d dVar = com.tencent.mobileqq.app.message.filescan.d.f195978a;
            sb5.append(dVar.b());
            sb5.append(File.separator);
            sb5.append("nt_db");
            long totalSize = h(sb5.toString()).getTotalSize();
            long totalSize2 = h(dVar.b()).getTotalSize();
            hashMap.put("ntDBSize", String.valueOf(totalSize));
            hashMap.put("dbSize", String.valueOf(totalSize2));
            hashMap.put("otherSizeExcludeAppDB", String.valueOf(j18 - totalSize2));
        } catch (Throwable th5) {
            QLog.d("StorageReport", 1, th5, new Object[0]);
        }
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, this.f290122j, true, 0L, 0L, hashMap, null);
        QLog.d("StorageReport", 1, "reportAppSizeInfo params: " + hashMap);
    }

    public void u(long j3, long j16, long j17, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), list);
            return;
        }
        ArrayList<String> whiteList = new ChatFileCleanUpThoroughCacheTool().getWhiteList();
        whiteList.addAll(list);
        Iterator<String> it = whiteList.iterator();
        long j18 = 0;
        while (it.hasNext()) {
            j18 += h(it.next()).getTotalSize();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("path", "chatStorageSize");
        hashMap.put("is_cleanup", "1");
        hashMap.put("chatRecordSize", String.valueOf(j3));
        hashMap.put("chatFileNTSize", String.valueOf(j16));
        hashMap.put("chatTextSize", String.valueOf(j17));
        hashMap.put("fileActualSize", String.valueOf(j18));
        hashMap.put("loginAccountNumber", String.valueOf(l()));
        hashMap.put("account", this.f290121i);
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, this.f290122j, true, 0L, 0L, hashMap, null);
        QLog.d("StorageReport", 1, "reportChatStorageDiff params: " + hashMap);
    }

    public void v(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("path", HippyReporter.RemoveEngineReason.CLEAR_CACHE);
        hashMap.put("is_cleanup_clear_cache", String.valueOf(z16 ? 1 : 0));
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, this.f290122j, true, 0L, 0L, hashMap, null);
        QLog.d("StorageReport", 1, "reportClearCache params: " + hashMap);
    }

    public void w(int i3, long j3, long j16, String str, boolean z16, long j17, long j18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), str, Boolean.valueOf(z16), Long.valueOf(j17), Long.valueOf(j18));
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("path", "msgCleanCost");
        String str2 = "1";
        hashMap.put("is_cleanup", "1");
        hashMap.put("recordCount", String.valueOf(i3));
        hashMap.put("releaseSpace", String.valueOf(j3));
        hashMap.put("costTime", String.valueOf(j16));
        hashMap.put("msgCleanType", str);
        if (!z16) {
            str2 = "0";
        }
        hashMap.put("isSlowTable", str2);
        hashMap.put("dbOriginSize", String.valueOf(j17));
        hashMap.put("dbFinalSize", String.valueOf(j18));
        hashMap.put("account", this.f290121i);
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, this.f290122j, true, 0L, 0L, hashMap, null);
        QLog.d("StorageReport", 1, "reportDBMsgCleanCost params: " + hashMap);
    }

    public void x(com.tencent.mobileqq.statistics.storage.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
            return;
        }
        if (!this.f290117e) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>(20);
        hashMap.put("account", this.f290121i);
        hashMap.put("report_key", this.f290120h);
        hashMap.put("path", aVar.f290132i);
        hashMap.put("name", aVar.f290131h);
        hashMap.put("size", String.valueOf(aVar.f290133j));
        hashMap.put("accessTime", String.valueOf(aVar.f290134k));
        hashMap.put("isFile", String.valueOf(aVar.f290135l));
        hashMap.put(QuotaFileSystem.STAT_FILE_COUNT, String.valueOf(aVar.f290136m));
        hashMap.put(QuotaFileSystem.STAT_DIR_COUNT, String.valueOf(aVar.f290137n));
        hashMap.put("dirScanCost", String.valueOf(aVar.f290138o));
        if (QLog.isColorLevel()) {
            QLog.d("StorageReport", 2, "--scan qq-- file report to tdw : report key = " + this.f290120h + ",item info=" + aVar.toString());
        }
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, this.f290122j, true, 0L, 0L, hashMap, null);
    }

    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (!this.f290117e) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("path", "jumpHistory");
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, this.f290122j, true, 0L, 0L, hashMap, null);
        QLog.d("StorageReport", 1, "reportJumpHistoryClick params: " + hashMap);
    }

    public void z(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, j3);
            return;
        }
        Iterator<String> it = new ZPlanCleanUpThoroughCacheTool().getWhiteList().iterator();
        long j16 = 0;
        while (it.hasNext()) {
            j16 += h(it.next()).getTotalSize();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("path", "zplanStorageSize");
        hashMap.put("is_cleanup", "1");
        hashMap.put("fileActualSize", String.valueOf(j16));
        hashMap.put("size", String.valueOf(j3));
        hashMap.put("loginAccountNumber", String.valueOf(l()));
        hashMap.put("account", this.f290121i);
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, this.f290122j, true, 0L, 0L, hashMap, null);
        QLog.d("StorageReport", 1, "reportZPlanStorageDiff params: " + hashMap);
    }
}

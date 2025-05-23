package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.biz.common.util.h;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.task.TaskOfflineUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class KandianReportSoLoader {

    /* renamed from: a, reason: collision with root package name */
    private static String f239874a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f239875b = null;

    /* renamed from: c, reason: collision with root package name */
    private static String f239876c = null;

    /* renamed from: d, reason: collision with root package name */
    private static String f239877d = null;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f239878e = false;

    /* renamed from: f, reason: collision with root package name */
    private static int f239879f = -1;

    static {
        try {
            f239874a = com.tencent.biz.common.offline.c.c("3454") + "3454";
            f239875b = BaseApplicationImpl.getApplication().getFilesDir().getParent() + "/txlib/kandianreport";
            f239876c = f239874a + "/so_config.json";
            f239877d = f239875b + "/so_config.json";
        } catch (Throwable th5) {
            QLog.e("kandianreport.KandianReportSoLoader", 2, th5.getLocalizedMessage());
        }
    }

    static /* bridge */ /* synthetic */ boolean f() {
        return j();
    }

    public static boolean g() throws Throwable {
        Boolean bool = Boolean.FALSE;
        boolean booleanValue = ((Boolean) com.tencent.mobileqq.kandian.base.utils.c.c("kd_fc_so_copy", bool)).booleanValue();
        boolean exists = new File(f239877d).exists();
        boolean booleanValue2 = ((Boolean) com.tencent.mobileqq.kandian.base.utils.c.c("kd_fc_so_download", bool)).booleanValue();
        boolean exists2 = new File(f239876c).exists();
        QLog.d("kandianreport.KandianReportSoLoader", 1, "copy flag: " + booleanValue);
        QLog.d("kandianreport.KandianReportSoLoader", 1, "actual copy state: " + exists);
        QLog.d("kandianreport.KandianReportSoLoader", 1, "download flag: " + booleanValue2);
        QLog.d("kandianreport.KandianReportSoLoader", 1, "actual download state: " + exists2);
        if (booleanValue != exists) {
            c.a("copy state is wrong " + booleanValue);
        }
        if (booleanValue2 != exists2) {
            c.a("download state is wrong " + booleanValue2);
        }
        if (exists2) {
            try {
                if (!h.k(f239874a, "3454")) {
                    r("checkSoFileIsReady: verification failed");
                    return false;
                }
            } catch (Throwable th5) {
                QLog.e("kandianreport.KandianReportSoLoader", 1, th5, new Object[0]);
                return false;
            }
        }
        if (!exists && exists2) {
            QLog.d("kandianreport.KandianReportSoLoader", 1, "download success but not copy");
            exists = j();
            QLog.d("kandianreport.KandianReportSoLoader", 1, "copy result: " + exists);
            if (!h.k(f239874a, "3454")) {
                r("checkSoFileIsReady: verification failed");
                return false;
            }
        }
        return exists ? s() : exists;
    }

    private static boolean h(String str, String str2) {
        boolean copyFile = FileUtils.copyFile(str, str2);
        boolean z16 = false;
        if (!copyFile) {
            r("copy file result false " + str);
        } else if (!new File(str2).exists()) {
            r("copy file result true but still not found " + str);
            copyFile = false;
        } else {
            r("copy file result success and found " + str);
        }
        if (!copyFile) {
            copyFile = i(str, str2);
            if (!copyFile) {
                r("double copy file result false fail " + str);
            } else if (!new File(str2).exists()) {
                r("double copy file result true but still not found " + str);
                QLog.d("kandianreport.KandianReportSoLoader", 1, "copy file final result" + z16);
                return z16;
            }
        }
        z16 = copyFile;
        QLog.d("kandianreport.KandianReportSoLoader", 1, "copy file final result" + z16);
        return z16;
    }

    private static synchronized boolean j() throws Exception {
        synchronized (KandianReportSoLoader.class) {
            com.tencent.mobileqq.kandian.base.utils.c.e("kd_fc_so_copy", Boolean.FALSE);
            JSONArray jSONArray = (JSONArray) new JSONObject(TaskOfflineUtils.d(new FileInputStream(f239876c))).get(NativeMonitorConfigHelper.SUB_KEY_SYMBOL);
            if (jSONArray == null || jSONArray.length() <= 0) {
                return false;
            }
            QLog.d("kandianreport.KandianReportSoLoader", 1, "so config copy " + jSONArray.toString());
            if (!h(f239876c, f239877d)) {
                QLog.d("kandianreport.KandianReportSoLoader", 1, "so config copy fail");
                return false;
            }
            String b16 = h.b(f239876c);
            String b17 = h.b(f239877d);
            r("so config copy success: " + b16 + " " + b17);
            if (b16 != null && b16.equals(b17)) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    String string = jSONArray.getString(i3);
                    String str = f239874a + "/" + string;
                    String str2 = f239875b + "/" + string;
                    if (!h(str, str2)) {
                        QLog.d("kandianreport.KandianReportSoLoader", 1, "jscjni copy fail " + string);
                        return false;
                    }
                    String b18 = h.b(str);
                    String b19 = h.b(str2);
                    r("so copy success: " + b18 + " " + b19);
                    if (b18 == null || !b18.equals(b19)) {
                        return false;
                    }
                }
                com.tencent.mobileqq.kandian.base.utils.c.e("kd_fc_so_copy", Boolean.TRUE);
                return true;
            }
            return false;
        }
    }

    public static void l(final Runnable runnable) {
        Boolean bool = Boolean.TRUE;
        if (((Boolean) com.tencent.mobileqq.kandian.base.utils.c.c("qq_is_reinstall", bool)).booleanValue()) {
            com.tencent.mobileqq.kandian.base.utils.c.e("qq_is_reinstall", Boolean.FALSE);
            try {
                if (new File(f239876c).exists()) {
                    com.tencent.mobileqq.kandian.base.utils.c.e("kd_fc_so_download", bool);
                }
            } catch (Exception e16) {
                QLog.d("kandianreport.KandianReportSoLoader", 1, "check local offline file fail!");
                e16.printStackTrace();
            }
        }
        QLog.d("kandianreport.KandianReportSoLoader", 1, "download so files now");
        TaskOfflineUtils.c("3454", 1, new TaskOfflineUtils.b() { // from class: com.tencent.mobileqq.kandian.glue.report.task.KandianReportSoLoader.1
            @Override // com.tencent.mobileqq.kandian.glue.report.task.TaskOfflineUtils.b
            public void onStateChange(int i3, int i16) {
                if (i3 == 0) {
                    KandianReportSoLoader.f239879f = i16;
                    com.tencent.mobileqq.kandian.base.utils.c.e("kd_fc_so_download", Boolean.TRUE);
                    QLog.d("kandianreport.KandianReportSoLoader", 1, "download so success: a new version: " + KandianReportSoLoader.f239879f);
                    ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.report.task.KandianReportSoLoader.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                FileUtils.deleteDirectory(KandianReportSoLoader.f239875b);
                                boolean f16 = KandianReportSoLoader.f();
                                PublicAccountReportUtils.l(null, "", "0X8009A1C", "0X8009A1C", 0, f16 ? 1 : 0, "", "", "", "copy file step", false);
                                if (!f16) {
                                    QLog.d("kandianreport.KandianReportSoLoader", 1, "copy fail, delete so");
                                    FileUtils.deleteDirectory(KandianReportSoLoader.f239874a);
                                }
                            } catch (Throwable th5) {
                                PublicAccountReportUtils.l(null, "", "0X8009A1C", "0X8009A1C", 0, 0, "", "", "", "copy file exception : " + th5.toString(), false);
                                QLog.d("kandianreport.KandianReportSoLoader", 1, "jscjni downloadSoFiles read so config fail");
                            }
                            Runnable runnable2 = runnable;
                            if (runnable2 != null) {
                                runnable2.run();
                            }
                        }
                    });
                } else {
                    if (i3 != 7 && i3 != 8 && i3 != 5 && !((Boolean) com.tencent.mobileqq.kandian.base.utils.c.c("kd_fc_so_download", Boolean.FALSE)).booleanValue()) {
                        PublicAccountReportUtils.l(null, "", "0X8009A1C", "0X8009A1C", 0, 0, "", "", "" + i3, "download fail", false);
                    }
                    QLog.d("kandianreport.KandianReportSoLoader", 1, "download so fail or not update:" + i3);
                }
                KandianReportSoLoader.r("local so file exists: " + new File(KandianReportSoLoader.f239876c).exists());
            }
        });
    }

    public static String m() {
        return f239875b;
    }

    public static int n() {
        return f239879f;
    }

    public static boolean o() {
        return new File(f239876c).exists();
    }

    public static boolean p() {
        return f239878e;
    }

    public static synchronized void q(Runnable runnable) {
        synchronized (KandianReportSoLoader.class) {
            try {
            } catch (Throwable th5) {
                QLog.d("kandianreport.KandianReportSoLoader", 1, "load so files fail " + th5.getMessage());
                c.c("load so files fail " + th5.getMessage());
                FileUtils.deleteDirectory(f239874a);
            }
            if (p()) {
                if (runnable != null) {
                    runnable.run();
                }
                return;
            }
            if (!g()) {
                QLog.d("kandianreport.KandianReportSoLoader", 1, "so not ready");
                FileUtils.deleteDirectory(f239874a);
                return;
            }
            QLog.d("kandianreport.KandianReportSoLoader", 1, "so ready, now load so");
            boolean exists = new File(f239876c).exists();
            r("config find result " + exists);
            if (!exists) {
                QLog.d("kandianreport.KandianReportSoLoader", 1, "configDownloadPath not exists");
                FileUtils.deleteDirectory(f239874a);
                return;
            }
            JSONArray jSONArray = (JSONArray) new JSONObject(TaskOfflineUtils.d(new FileInputStream(f239876c))).get(NativeMonitorConfigHelper.SUB_KEY_SYMBOL);
            if (jSONArray != null && jSONArray.length() > 0) {
                try {
                    System.loadLibrary("c++_shared");
                } catch (Throwable th6) {
                    QLog.d("kandianreport.KandianReportSoLoader", 1, "load c++_shared fail " + th6.getMessage());
                    c.c("load c++_shared fail " + th6.getMessage());
                }
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    String string = jSONArray.getString(i3);
                    String str = f239875b + "/arm64-v8a/" + string;
                    if (!FileUtils.fileExists(str)) {
                        if (!h(f239874a + "/" + string, str)) {
                            QLog.d("kandianreport.KandianReportSoLoader", 1, "load so copy fail " + string);
                            FileUtils.deleteDirectory(f239874a);
                        } else {
                            QLog.d("kandianreport.KandianReportSoLoader", 1, "load so copy success " + string);
                        }
                    }
                    System.load(str);
                    QLog.d("kandianreport.KandianReportSoLoader", 1, "load so success " + str);
                }
                f239878e = true;
                PublicAccountReportUtils.l(null, "", "0X80099E1", "0X80099E1", 0, 0, "", "", "", "load so success", false);
            }
            f239879f = TaskOfflineUtils.b("3454", 1).f239952b;
            r("so load success");
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public static void r(String str) {
        if (TaskManager.f239892l) {
            QLog.d("kandianreport.KandianReportSoLoader", 1, str);
            HashMap<String, String> hashMap = new HashMap<>();
            AppRuntime c16 = com.tencent.mobileqq.kandian.base.utils.b.c();
            if (c16 != null) {
                hashMap.put("uin", c16.getAccount());
            }
            hashMap.put("log", str);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "kandianreportdataframe", true, 1L, 0L, hashMap, null);
            c.a(str);
        }
    }

    private static boolean s() {
        if (!new File(f239876c).exists()) {
            return false;
        }
        try {
            JSONArray jSONArray = (JSONArray) new JSONObject(TaskOfflineUtils.d(new FileInputStream(f239876c))).get(NativeMonitorConfigHelper.SUB_KEY_SYMBOL);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                String string = jSONArray.getString(i3);
                if (!new File(f239875b + "/" + string).exists()) {
                    QLog.d("kandianreport.KandianReportSoLoader", 1, string + " not found");
                    return false;
                }
            }
            QLog.d("kandianreport.KandianReportSoLoader", 1, "so verify pass");
            return true;
        } catch (Throwable th5) {
            QLog.e("kandianreport.KandianReportSoLoader", 1, th5.getMessage());
            return false;
        }
    }

    private static boolean i(String str, String str2) {
        try {
            File file = new File(str);
            File file2 = new File(str2);
            if (!file.exists()) {
                QLog.d("kandianreport.KandianReportSoLoader", 1, "copy file result false not found " + str);
                return false;
            }
            if (!file2.exists()) {
                file2 = FileUtils.createFile(str2);
            }
            if (file.getAbsolutePath().toString().equals(file2.getAbsolutePath().toString())) {
                return true;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (IOException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static void k() {
        l(null);
    }
}

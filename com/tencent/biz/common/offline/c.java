package com.tencent.biz.common.offline;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static String f78439a;

    /* renamed from: b, reason: collision with root package name */
    private static String f78440b;

    /* renamed from: c, reason: collision with root package name */
    private static String f78441c;

    /* renamed from: d, reason: collision with root package name */
    private static String f78442d;

    /* renamed from: e, reason: collision with root package name */
    private static final ReentrantLock f78443e = new ReentrantLock();

    /* renamed from: f, reason: collision with root package name */
    private static final ReentrantLock f78444f = new ReentrantLock();

    public static String a() {
        if (TextUtils.isEmpty(f78441c)) {
            if (QLog.isColorLevel()) {
                QLog.w("OfflineEnvHelper", 2, "getInnerOfflineDir, initEnv");
            }
            h();
        }
        return f78441c;
    }

    public static String b() {
        if (TextUtils.isEmpty(f78442d)) {
            h();
        }
        return f78442d;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i(str)) {
            return e();
        }
        return a();
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i(str)) {
            return f();
        }
        return b();
    }

    public static String e() {
        if (TextUtils.isEmpty(f78439a)) {
            if (QLog.isColorLevel()) {
                QLog.w("OfflineEnvHelper", 2, "getSDOfflineDir, initEnv");
            }
            h();
        }
        return f78439a;
    }

    public static String f() {
        if (TextUtils.isEmpty(f78440b)) {
            h();
        }
        return f78440b;
    }

    private static void g(String str) {
        if (HtmlOffline.f78403f.isColorLevel()) {
            HtmlOffline.f78403f.i("HtmlCheckUpdate", 2, str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x022d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void h() {
        boolean z16;
        boolean z17;
        File file;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        String d16 = ((com.tencent.mobileqq.webview.swift.injector.c) aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).d("offline", true);
        if (!TextUtils.isEmpty(d16)) {
            String str = d16 + "/html5/";
            String str2 = d16 + "/tmp/";
            File file2 = new File(str);
            try {
                if (!file2.exists()) {
                    ReentrantLock reentrantLock = f78443e;
                    if (reentrantLock.tryLock()) {
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            File file3 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/qbiz/html5/");
                            if (file3.exists()) {
                                file2.mkdirs();
                                if (file3.renameTo(file2)) {
                                    z28 = true;
                                    HtmlOffline.f78403f.i("HtmlCheckUpdate", 1, "sd move old data, cost=" + (System.currentTimeMillis() - currentTimeMillis) + ", move=" + z28);
                                    reentrantLock.unlock();
                                } else {
                                    g("sd move error");
                                }
                            } else {
                                g("sd no old data");
                            }
                            z28 = false;
                            HtmlOffline.f78403f.i("HtmlCheckUpdate", 1, "sd move old data, cost=" + (System.currentTimeMillis() - currentTimeMillis) + ", move=" + z28);
                            reentrantLock.unlock();
                        } catch (Throwable th5) {
                            f78443e.unlock();
                            throw th5;
                        }
                    } else {
                        HtmlOffline.f78403f.i("HtmlCheckUpdate", 1, "sd move lock failed");
                    }
                }
            } catch (Exception e16) {
                g("sd move error: " + e16.toString());
            }
            if (!file2.exists() && !file2.mkdirs()) {
                z26 = true;
            } else {
                z26 = false;
            }
            File file4 = new File(str2);
            if (!file4.exists() && !file4.mkdirs()) {
                z27 = true;
            } else {
                z27 = false;
            }
            if (z26 | z27) {
                g("no sd");
            } else {
                f78439a = VFSAssistantUtils.getSDKPrivatePath(str);
                f78440b = VFSAssistantUtils.getSDKPrivatePath(str2);
            }
        }
        String d17 = ((com.tencent.mobileqq.webview.swift.injector.c) aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).d("offline", false);
        if (!TextUtils.isEmpty(d17)) {
            String str3 = d17 + "/html5/";
            String str4 = d17 + "/tmp/";
            File file5 = new File(str3);
            try {
            } catch (Exception e17) {
                e = e17;
                z16 = true;
                g("data move error: " + e.toString());
                if (file5.exists()) {
                }
                z17 = false;
                file = new File(str4);
                if (file.exists()) {
                }
                z18 = false;
                if (!(z17 | z18)) {
                }
            }
            if (!file5.exists()) {
                ReentrantLock reentrantLock2 = f78444f;
                if (reentrantLock2.tryLock()) {
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        File file6 = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/qbiz/html5/");
                        if (file6.exists()) {
                            file5.mkdirs();
                            if (file6.renameTo(file5)) {
                                z19 = true;
                                HtmlOffline.f78403f.i("HtmlCheckUpdate", 1, "data move old data, cost=" + (System.currentTimeMillis() - currentTimeMillis2) + ", move=" + z19);
                                reentrantLock2.unlock();
                            } else {
                                g("data move error");
                            }
                        } else {
                            g("data no old data");
                        }
                        z19 = false;
                        HtmlOffline.f78403f.i("HtmlCheckUpdate", 1, "data move old data, cost=" + (System.currentTimeMillis() - currentTimeMillis2) + ", move=" + z19);
                        reentrantLock2.unlock();
                    } catch (Throwable th6) {
                        f78444f.unlock();
                        throw th6;
                    }
                } else {
                    z16 = true;
                    try {
                        HtmlOffline.f78403f.i("HtmlCheckUpdate", 1, "data move lock failed");
                    } catch (Exception e18) {
                        e = e18;
                        g("data move error: " + e.toString());
                        if (file5.exists()) {
                        }
                        z17 = false;
                        file = new File(str4);
                        if (file.exists()) {
                        }
                        z18 = false;
                        if (!(z17 | z18)) {
                        }
                    }
                    if (file5.exists() && !file5.mkdirs()) {
                        z17 = z16;
                    } else {
                        z17 = false;
                    }
                    file = new File(str4);
                    if (file.exists() && !file.mkdirs()) {
                        z18 = z16;
                    } else {
                        z18 = false;
                    }
                    if (!(z17 | z18)) {
                        g("no data dir");
                        return;
                    } else {
                        f78441c = str3;
                        f78442d = str4;
                        return;
                    }
                }
            }
            z16 = true;
            if (file5.exists()) {
            }
            z17 = false;
            file = new File(str4);
            if (file.exists()) {
            }
            z18 = false;
            if (!(z17 | z18)) {
            }
        }
    }

    public static boolean i(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            int intValue = Integer.valueOf(str).intValue();
            if (intValue < 1000 || intValue >= 2000) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            if (HtmlOffline.f78403f.isColorLevel()) {
                HtmlOffline.f78403f.i("HtmlCheckUpdate", 2, "initEnv NumberFormatException");
            }
            return true;
        }
    }
}

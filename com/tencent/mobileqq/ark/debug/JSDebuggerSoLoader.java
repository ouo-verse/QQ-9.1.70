package com.tencent.mobileqq.ark.debug;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ark.ArkDebugger;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.api.INativeLibLoader;
import com.tencent.mobileqq.ark.util.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class JSDebuggerSoLoader {

    /* renamed from: a, reason: collision with root package name */
    private static String f199369a = "";

    /* renamed from: c, reason: collision with root package name */
    private static boolean f199371c = false;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f199372d = false;

    /* renamed from: e, reason: collision with root package name */
    private static int f199373e = 1;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f199370b = new Object();

    /* renamed from: f, reason: collision with root package name */
    private static Map<String, Pair<String, String>> f199374f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private static final Runnable f199375g = new Runnable() { // from class: com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader.3
        @Override // java.lang.Runnable
        public void run() {
            if (JSDebuggerSoLoader.f199373e == 0) {
                JSDebuggerSoLoader.j(JSDebuggerSoLoader.m());
                JSDebuggerSoLoader.k();
                JSDebuggerSoLoader.i();
            } else {
                if (JSDebuggerSoLoader.f199373e == 1) {
                    JSDebuggerSoLoader.i();
                    return;
                }
                if (JSDebuggerSoLoader.f199373e == 2) {
                    JSDebuggerSoLoader.i();
                    String m3 = JSDebuggerSoLoader.m();
                    if (!TextUtils.isEmpty(m3)) {
                        JSDebuggerSoLoader.p(m3, "libarkDebuggerJSImpl.so");
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements g91.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f199378a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f199379b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f199380c;

        a(String str, String str2, String str3) {
            this.f199378a = str;
            this.f199379b = str2;
            this.f199380c = str3;
        }

        @Override // g91.a
        public void a(int i3, byte[] bArr) {
            if (i3 != 0 || bArr == null) {
                JSDebuggerSoLoader.o(6);
                QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.onDownloadArkJSDebugger failed!");
            } else {
                String str = this.f199378a;
                String str2 = this.f199379b;
                if (JSDebuggerSoLoader.q(str, str2, str2, this.f199380c)) {
                    JSDebuggerSoLoader.o(4);
                    QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.testZipAndUnzip 2 succeed");
                    JSDebuggerSoLoader.p(this.f199380c, "libarkDebuggerJSImpl.so");
                } else {
                    JSDebuggerSoLoader.o(5);
                    QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.testZipAndUnzip 2 failed");
                }
            }
            synchronized (JSDebuggerSoLoader.f199370b) {
                JSDebuggerSoLoader.f199371c = false;
            }
        }
    }

    static /* bridge */ /* synthetic */ boolean i() {
        return r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                File file = new File(str);
                if (file.exists() && file.isDirectory()) {
                    for (String str2 : file.list()) {
                        File file2 = new File(str, str2);
                        if (file2.exists() && file2.isFile()) {
                            file2.delete();
                        }
                    }
                }
            } catch (Exception e16) {
                QLog.e("JSDebuggerSoLoader", 1, e16, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k() {
        f199372d = false;
    }

    private static void l(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e16) {
                QLog.e("JSDebuggerSoLoader", 1, e16, new Object[0]);
            }
        }
    }

    public static String m() {
        if (TextUtils.isEmpty(f199369a)) {
            BaseApplication context = BaseApplication.getContext();
            if (context != null) {
                File filesDir = context.getFilesDir();
                if (filesDir != null) {
                    f199369a = filesDir.getParent() + SoLoadCore.PATH_TX_LIB + "arkdebugger/";
                }
            } else {
                QLog.w("JSDebuggerSoLoader", 2, "getLibDirPath but context is null");
            }
        }
        return f199369a;
    }

    private static String n() {
        String m3 = m();
        if (!TextUtils.isEmpty(m3)) {
            return m3 + "temp/";
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(final String str, final String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToLogicThread(new Runnable() { // from class: com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader.2
                @Override // java.lang.Runnable
                public void run() {
                    QLog.i("JSDebuggerSoLoader", 2, "setJSDebuggerLibPathForArk: " + str + "," + str2);
                    INativeLibLoader iNativeLibLoader = (INativeLibLoader) QRoute.api(INativeLibLoader.class);
                    if (!iNativeLibLoader.isArkLibraryLoaded()) {
                        iNativeLibLoader.loadArkLibrary();
                    }
                    ArkDebugger.SetJSLibraryPath(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00de A[Catch: Exception -> 0x012b, TryCatch #0 {Exception -> 0x012b, blocks: (B:11:0x001d, B:13:0x003a, B:15:0x0044, B:17:0x004a, B:20:0x0075, B:22:0x0099, B:23:0x00ac, B:24:0x00c1, B:26:0x00de, B:28:0x0102, B:32:0x0115), top: B:10:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean q(String str, String str2, String str3, String str4) {
        boolean z16;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            try {
                j(str4);
                File file = new File(str + str2);
                if (file.exists()) {
                    String d16 = com.tencent.qqprotect.singleupdate.a.d(file);
                    if (!TextUtils.isEmpty(d16) && d16.equals(str3)) {
                        FileUtils.uncompressZip(file.getAbsolutePath(), str, false);
                        if (new File(str + "libarkDebuggerJSImpl.so").exists()) {
                            if (FileUtils.copyFile(str + "libarkDebuggerJSImpl.so", str4 + "libarkDebuggerJSImpl.so")) {
                                QLog.i("JSDebuggerSoLoader", 2, "testZipAndUnzip.copyFile succeed:libarkDebuggerJSImpl.so");
                            } else {
                                QLog.i("JSDebuggerSoLoader", 2, "testZipAndUnzip.copyFile failed:libarkDebuggerJSImpl.so");
                                z16 = true;
                                if (new File(str + "libjsc_ark.so").exists()) {
                                    if (FileUtils.copyFile(str + "libjsc_ark.so", str4 + "libjsc_ark.so")) {
                                        QLog.i("JSDebuggerSoLoader", 2, "testZipAndUnzip.copyFile succeed:libjsc_ark.so");
                                    } else {
                                        QLog.i("JSDebuggerSoLoader", 2, "testZipAndUnzip.copyFile failed:libjsc_ark.so");
                                        z16 = true;
                                    }
                                    if (!z16) {
                                        return true;
                                    }
                                }
                            }
                        }
                        z16 = false;
                        if (new File(str + "libjsc_ark.so").exists()) {
                        }
                    }
                }
            } catch (Exception e16) {
                QLog.e("JSDebuggerSoLoader", 1, e16, new Object[0]);
            }
        }
        return false;
    }

    private static synchronized boolean r() {
        synchronized (JSDebuggerSoLoader.class) {
            Object obj = f199370b;
            synchronized (obj) {
                if (f199371c) {
                    QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.sync failed");
                    return false;
                }
                if (f199372d) {
                    o(2);
                    QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.has succeed");
                    return true;
                }
                o(0);
                String m3 = m();
                String n3 = n();
                if (!TextUtils.isEmpty(m3) && !TextUtils.isEmpty(n3)) {
                    l(m3);
                    File file = new File(m3 + "libarkDebuggerJSImpl.so");
                    if (file.exists()) {
                        QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.js debugger so exists:" + file);
                        p(m3, "libarkDebuggerJSImpl.so");
                        o(2);
                        f199372d = true;
                        return true;
                    }
                    Pair<String, String> pair = f199374f.get("");
                    if (pair != null && !TextUtils.isEmpty((CharSequence) pair.second)) {
                        l(n3);
                        String str = n3 + ((String) pair.second);
                        if (new File(str).exists()) {
                            Object obj2 = pair.second;
                            if (q(n3, (String) obj2, (String) obj2, m3)) {
                                QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.testZipAndUnzip 1 succeed");
                                o(3);
                                p(m3, "libarkDebuggerJSImpl.so");
                                f199372d = true;
                                return true;
                            }
                        }
                        if (TextUtils.isEmpty((CharSequence) pair.first)) {
                            o(7);
                            QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.manage URL is null");
                            return false;
                        }
                        String str2 = (String) pair.second;
                        j(n3);
                        synchronized (obj) {
                            if (f199371c) {
                                return false;
                            }
                            o(1);
                            h.b(MobileQQ.sMobileQQ.waitAppRuntime(null), (String) pair.first, null, str, new a(n3, str2, m3));
                            f199371c = true;
                            QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.downloadArkJSDebugger");
                            return true;
                        }
                    }
                    o(7);
                    QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.manage MD5 is null");
                    return false;
                }
                o(9);
                QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.necessary dir path is null");
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o(int i3) {
    }
}

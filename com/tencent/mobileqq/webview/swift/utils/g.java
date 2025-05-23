package com.tencent.mobileqq.webview.swift.utils;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.webviewplugin.OfflineWebResManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.OfflineWebRes;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.pts.utils.PTSFileUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.util.LRULinkedHashMap;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final LRULinkedHashMap<String, a> f314750a;

    /* renamed from: b, reason: collision with root package name */
    private static WeakReference<OfflineWebResManager> f314751b;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final String f314752a;

        /* renamed from: b, reason: collision with root package name */
        public final String f314753b;

        /* renamed from: c, reason: collision with root package name */
        public final String f314754c;

        /* renamed from: d, reason: collision with root package name */
        final long f314755d;

        a(String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, str3);
                return;
            }
            this.f314752a = str;
            this.f314753b = str2;
            this.f314754c = str3;
            this.f314755d = SystemClock.elapsedRealtime();
        }

        boolean a() {
            if (SystemClock.elapsedRealtime() - this.f314755d > MiniBoxNoticeInfo.MIN_5) {
                return true;
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49436);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f314750a = new LRULinkedHashMap<>(4);
            f314751b = null;
        }
    }

    private static String a(String str) {
        if (str.endsWith(".css")) {
            return "text/css";
        }
        if (str.endsWith(PTSFileUtil.JS_FORMAT)) {
            return "application/x-javascript";
        }
        if (!str.endsWith(".jpg") && !str.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END) && !str.endsWith(".png") && !str.endsWith(".jpeg")) {
            return "text/html";
        }
        return "image/*";
    }

    public static a b(String str) {
        a aVar;
        if (((com.tencent.mobileqq.webview.swift.injector.c) aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).j()) {
            return null;
        }
        String v3 = HtmlOffline.v(str);
        if (TextUtils.isEmpty(v3)) {
            aVar = null;
        } else {
            aVar = f314750a.get(v3);
        }
        if (aVar == null || aVar.a()) {
            return null;
        }
        return aVar;
    }

    private static OfflineWebResManager c(OfflineWebResManager offlineWebResManager) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (MobileQQ.sProcessId == 7) {
            AppRuntime appRuntime = waitAppRuntime.getAppRuntime("modular_web");
            if (appRuntime instanceof AppInterface) {
                return new OfflineWebResManager((AppInterface) appRuntime);
            }
            return offlineWebResManager;
        }
        if (waitAppRuntime instanceof AppInterface) {
            return new OfflineWebResManager((AppInterface) waitAppRuntime);
        }
        return offlineWebResManager;
    }

    private static String d(String str) throws IOException {
        BufferedInputStream bufferedInputStream;
        ConcurrentHashMap<String, String> concurrentHashMap = HtmlOffline.f78404g;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(str)) {
            return HtmlOffline.f78404g.get(str);
        }
        String str2 = com.tencent.biz.common.offline.c.c(str) + str + "/verify.json";
        BufferedInputStream bufferedInputStream2 = null;
        if (!new File(str2).exists()) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str2));
        } catch (Exception unused) {
            bufferedInputStream = null;
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            String d16 = com.tencent.biz.common.util.h.d(bufferedInputStream);
            HtmlOffline.f78404g.put(str, d16);
            bufferedInputStream.close();
            return d16;
        } catch (Exception unused2) {
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x0108, code lost:
    
        if (r14 == null) goto L73;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0093 A[Catch: Exception -> 0x016a, TryCatch #3 {Exception -> 0x016a, blocks: (B:12:0x002b, B:14:0x0031, B:15:0x0037, B:18:0x0049, B:21:0x005c, B:24:0x0068, B:26:0x0075, B:29:0x007c, B:32:0x0093, B:35:0x009e, B:38:0x00b5, B:41:0x00c3, B:47:0x00d2, B:53:0x00f0, B:54:0x011a, B:56:0x0120, B:73:0x0111, B:74:0x0114, B:63:0x010a, B:83:0x0085), top: B:11:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0120 A[Catch: Exception -> 0x016a, TRY_LEAVE, TryCatch #3 {Exception -> 0x016a, blocks: (B:12:0x002b, B:14:0x0031, B:15:0x0037, B:18:0x0049, B:21:0x005c, B:24:0x0068, B:26:0x0075, B:29:0x007c, B:32:0x0093, B:35:0x009e, B:38:0x00b5, B:41:0x00c3, B:47:0x00d2, B:53:0x00f0, B:54:0x011a, B:56:0x0120, B:73:0x0111, B:74:0x0114, B:63:0x010a, B:83:0x0085), top: B:11:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0111 A[Catch: Exception -> 0x016a, TryCatch #3 {Exception -> 0x016a, blocks: (B:12:0x002b, B:14:0x0031, B:15:0x0037, B:18:0x0049, B:21:0x005c, B:24:0x0068, B:26:0x0075, B:29:0x007c, B:32:0x0093, B:35:0x009e, B:38:0x00b5, B:41:0x00c3, B:47:0x00d2, B:53:0x00f0, B:54:0x011a, B:56:0x0120, B:73:0x0111, B:74:0x0114, B:63:0x010a, B:83:0x0085), top: B:11:0x002b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean e(String str) {
        OfflineWebResManager c16;
        FileInputStream fileInputStream;
        boolean z16;
        FileInputStream fileInputStream2;
        int available;
        if (((com.tencent.mobileqq.webview.swift.injector.c) aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).j()) {
            return false;
        }
        if (b(str) != null) {
            if (QLog.isColorLevel()) {
                QLog.d("SwiftOfflinePackageUtils", 2, "offline data is already cached.");
            }
            return true;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d("SwiftOfflinePackageUtils", 2, "read offline data start");
            }
            String queryParameter = Uri.parse(str).getQueryParameter("_bid");
            if (TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            String d16 = d(queryParameter);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (TextUtils.isEmpty(d16)) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(d16);
            String v3 = HtmlOffline.v(str);
            if (v3 == null) {
                return false;
            }
            String optString = jSONObject.optString(v3);
            long currentTimeMillis3 = System.currentTimeMillis();
            WeakReference<OfflineWebResManager> weakReference = f314751b;
            if (weakReference != null && weakReference.get() != null) {
                c16 = f314751b.get();
                if (c16 != null) {
                    return false;
                }
                OfflineWebRes k3 = c16.k(optString);
                long currentTimeMillis4 = System.currentTimeMillis();
                if (k3 == null) {
                    return false;
                }
                File file = new File(BaseApplication.getContext().getFilesDir(), "WebOfflineRes");
                if (!file.exists()) {
                    return false;
                }
                File file2 = new File(file, k3.hashName);
                if (!file2.exists()) {
                    return false;
                }
                String a16 = a(v3);
                try {
                    fileInputStream2 = new FileInputStream(file2);
                } catch (Exception unused) {
                    fileInputStream = null;
                } catch (OutOfMemoryError e16) {
                    e = e16;
                    fileInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = null;
                }
                try {
                    available = fileInputStream2.available();
                } catch (Exception unused2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    z16 = false;
                    if (QLog.isColorLevel()) {
                    }
                    return z16;
                } catch (OutOfMemoryError e17) {
                    e = e17;
                    fileInputStream = fileInputStream2;
                    try {
                        QLog.e("SwiftOfflinePackageUtils", 1, e.getMessage());
                    } catch (Throwable th6) {
                        th = th6;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
                if (available == 0) {
                    fileInputStream2.close();
                    return false;
                }
                byte[] bArr = new byte[available];
                if (available == fileInputStream2.read(bArr)) {
                    f314750a.put(v3, new a(a16, new String(bArr, "utf-8"), "utf-8"));
                    z16 = true;
                } else {
                    z16 = false;
                }
                fileInputStream2.close();
                if (QLog.isColorLevel()) {
                    QLog.d("SwiftOfflinePackageUtils", 2, "read offline package data finish, readMd5File: " + (currentTimeMillis2 - currentTimeMillis) + ", getMd5: " + (currentTimeMillis3 - currentTimeMillis2) + ", query: " + (currentTimeMillis4 - currentTimeMillis3) + ", totalCost: " + (System.currentTimeMillis() - currentTimeMillis) + ", filePath: " + HtmlOffline.v(str));
                }
                return z16;
            }
            c16 = c(null);
            f314751b = new WeakReference<>(c16);
            if (c16 != null) {
            }
        } catch (Exception e18) {
            QLog.e("SwiftOfflinePackageUtils", 1, "loadOfflinePackage got exception!", e18);
            return false;
        }
    }
}

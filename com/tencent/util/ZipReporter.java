package com.tencent.util;

import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ZipReporter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f383967a;

    public static void b(File file, int i3) {
        if (file == null) {
            QLog.e("ZipReporter", 1, "checkZipRegular, zip file is null");
        } else if (!file.exists()) {
            QLog.e("ZipReporter", 1, "checkZipRegular, zip file is not exists");
        } else {
            if (file.length() == 0) {
                return;
            }
            ThreadManagerV2.excute(new Runnable(file, i3) { // from class: com.tencent.util.ZipReporter.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ File f383968d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f383969e;

                {
                    this.f383968d = file;
                    this.f383969e = i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) file, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ZipReporter.d(this.f383968d, this.f383969e);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }, 192, null, false);
        }
    }

    public static int c() {
        if (f383967a == 0) {
            f383967a = 20;
        }
        return f383967a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(File file, int i3) {
        String account;
        try {
            long length = file.length();
            long uncompressedFileSize = ZipUtils.getUncompressedFileSize(file.getAbsolutePath());
            long j3 = uncompressedFileSize / length;
            if (j3 < i3) {
                return;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (waitAppRuntime == null) {
                account = "";
            } else {
                account = waitAppRuntime.getAccount();
            }
            String str = account;
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("UnusualUin", str);
            }
            hashMap.put("ZipSize", String.valueOf(length));
            hashMap.put("UnzipSize", String.valueOf(uncompressedFileSize));
            hashMap.put("ZipName", file.getName());
            hashMap.put("ZipCurrentTimes", String.valueOf(j3));
            hashMap.put("ZipTargetTimes", String.valueOf(i3));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "UnUsualZipEvent", false, 0L, 0L, hashMap, "");
        } catch (Exception e16) {
            QLog.d("ZipReporter", 1, "reportUnusualSizeZip error : ", e16);
        } catch (OutOfMemoryError e17) {
            QLog.d("ZipReporter", 1, "reportUnusualSizeZip OutOfMemoryError : ", e17);
        }
    }

    public static void e(int i3) {
        f383967a = i3;
    }
}

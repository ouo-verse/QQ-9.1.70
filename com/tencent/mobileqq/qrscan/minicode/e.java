package com.tencent.mobileqq.qrscan.minicode;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.SystemProperties;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QMMKVMigrateHelper;
import com.tencent.mobileqq.minicode.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f276758a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f276759b;

    /* renamed from: c, reason: collision with root package name */
    public static String f276760c;

    /* renamed from: d, reason: collision with root package name */
    public static String f276761d;

    /* renamed from: e, reason: collision with root package name */
    private static Boolean f276762e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f276763f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29053);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f276758a = false;
        f276759b = false;
        f276760c = "sp_file_minirecog";
        f276761d = "sp_key_detect_init_error_";
        f276762e = null;
        if (f276758a) {
            String h16 = h();
            String g16 = g();
            File file = new File(h16);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(g16);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            c("libQMCF_qr.so", "so_debug/", h16);
            c("libyuvutil.so", "so_debug/", h16);
            c("libminicode.so", "so_debug/", h16);
            c("qr_detection_model.bin", "model_debug/", g16);
            c("qr_detection_model.txt", "model_debug/", g16);
            c("qr_anchor.bin", "model_debug/", g16);
        }
        f276763f = false;
    }

    public static void a(boolean z16) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(f276761d);
        if (z16) {
            str = "qq.android.minidecode.so_v8.8.5";
        } else {
            str = "qq.android.minidetect.so_v8.9.85";
        }
        sb5.append(str);
        QMMKVMigrateHelper.getMMKVMigratedSharePreferencesSync(MobileQQ.sMobileQQ, f276760c, 4).edit().remove(sb5.toString()).apply();
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog", 2, String.format("clearMiniScanError bDecodeElseDetect=%b", Boolean.valueOf(z16)));
        }
    }

    private static boolean b(String str, String str2) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(str);
            File file2 = new File(str2);
            if (file.exists()) {
                file.delete();
            }
            fileInputStream = new FileInputStream(file2);
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        }
                        fileOutputStream2.flush();
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                        try {
                            fileInputStream.close();
                            return true;
                        } catch (Exception e17) {
                            e17.printStackTrace();
                            return true;
                        }
                    } catch (Exception e18) {
                        fileOutputStream = fileOutputStream2;
                        e = e18;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e19) {
                                e19.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e26) {
                                e26.printStackTrace();
                            }
                        }
                        return false;
                    } catch (Throwable th5) {
                        fileOutputStream = fileOutputStream2;
                        th = th5;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e27) {
                                e27.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                throw th;
                            } catch (Exception e28) {
                                e28.printStackTrace();
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e29) {
                e = e29;
            }
        } catch (Exception e36) {
            e = e36;
            fileInputStream = null;
        } catch (Throwable th7) {
            th = th7;
            fileInputStream = null;
        }
    }

    public static void c(String str, String str2, String str3) {
        boolean z16;
        String str4 = AppConstants.SDCARD_PATH_MINICODERECOG + str2 + str;
        String str5 = str3 + str;
        if (new File(str4).exists()) {
            z16 = b(str5, str4);
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog", 2, String.format("copy %s %b", str5, Boolean.valueOf(z16)));
        }
    }

    public static final String d() {
        return e() + "kernal_path/";
    }

    public static String e() {
        BaseApplication context = BaseApplication.getContext();
        if (context.getFilesDir() == null) {
            QLog.i("MiniRecog", 2, "getAppDir is null.");
            return "";
        }
        return context.getFilesDir() + "/minirecog/";
    }

    public static int f(boolean z16) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(f276761d);
        if (z16) {
            str = "qq.android.minidecode.so_v8.8.5";
        } else {
            str = "qq.android.minidetect.so_v8.9.85";
        }
        sb5.append(str);
        int i3 = QMMKVMigrateHelper.getMMKVMigratedSharePreferencesSync(MobileQQ.sMobileQQ, f276760c, 4).getInt(sb5.toString(), 0);
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog", 2, String.format("getMiniScanErrorCnt errorCnt=%d bDecodeElseDetect=%b", Integer.valueOf(i3), Boolean.valueOf(z16)));
        }
        return i3;
    }

    public static final String g() {
        return e() + "model_debug/";
    }

    public static final String h() {
        return e() + "so_debug/";
    }

    public static int i() {
        if (f(false) >= 3) {
            return -1;
        }
        int qmcfGpuSupportType = ((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).getQmcfGpuSupportType();
        int qmcfGpuSupportTypeWithoutGPURule = ((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).getQmcfGpuSupportTypeWithoutGPURule();
        if (!f276763f) {
            MiniScanReport.n(qmcfGpuSupportType, qmcfGpuSupportTypeWithoutGPURule);
            f276763f = true;
        }
        boolean isQmcfSupport = ((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).isQmcfSupport(qmcfGpuSupportTypeWithoutGPURule);
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog", 2, String.format("getSupportDetectType supportType[loose,strict]=[%d,%d]", Integer.valueOf(qmcfGpuSupportTypeWithoutGPURule), Integer.valueOf(qmcfGpuSupportType)));
        }
        if (!isQmcfSupport) {
            return 0;
        }
        if (!((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).isQmcfSupportGLElseCL(qmcfGpuSupportTypeWithoutGPURule)) {
            return 1;
        }
        return 2;
    }

    public static final String j() {
        return AppConstants.SDCARD_PATH_MINICODERECOG + "tmp/";
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0054, code lost:
    
        if ("unknown".equals(r6) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean k() {
        boolean z16;
        if (f276762e == null) {
            boolean s06 = ah.s0();
            if (s06) {
                try {
                } catch (Throwable th5) {
                    QLog.e("MiniRecog", 2, "RecogUtil.isX86()", th5);
                }
                if (((Integer) SystemProperties.class.getMethod("getInt", String.class, Integer.TYPE).invoke(SystemProperties.class, new String("ro.kernel.qemu"), new Integer(0))).intValue() == 1) {
                    String str = Build.MANUFACTURER;
                    if (!"tencent".equals(str)) {
                    }
                    z16 = true;
                    QLog.i("MiniRecog", 1, String.format("RecogUtil isX86 [%b,%b,%s]", Boolean.valueOf(s06), Boolean.valueOf(z16), Build.MANUFACTURER));
                    f276762e = Boolean.valueOf(z16);
                }
            }
            z16 = false;
            QLog.i("MiniRecog", 1, String.format("RecogUtil isX86 [%b,%b,%s]", Boolean.valueOf(s06), Boolean.valueOf(z16), Build.MANUFACTURER));
            f276762e = Boolean.valueOf(z16);
        }
        return f276762e.booleanValue();
    }

    public static void l(boolean z16) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(f276761d);
        if (z16) {
            str = "qq.android.minidecode.so_v8.8.5";
        } else {
            str = "qq.android.minidetect.so_v8.9.85";
        }
        sb5.append(str);
        String sb6 = sb5.toString();
        SharedPreferences mMKVMigratedSharePreferencesSync = QMMKVMigrateHelper.getMMKVMigratedSharePreferencesSync(MobileQQ.sMobileQQ, f276760c, 4);
        int i3 = mMKVMigratedSharePreferencesSync.getInt(sb6, 0);
        int i16 = i3 + 1;
        mMKVMigratedSharePreferencesSync.edit().putInt(sb6, i16).apply();
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog", 2, String.format("markMiniScanError bDecodeElseDetect=%b old_errorCnt=%d new_errorCnt=%d", Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16)));
        }
    }

    public static void m(boolean z16) {
        f276759b = z16;
    }

    public static void n(Bitmap bitmap, String str) {
        Utils.saveBitmapToFile(bitmap, j() + str + ".png", Bitmap.CompressFormat.PNG, 100, false);
    }
}

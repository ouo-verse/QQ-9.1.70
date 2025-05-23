package com.tencent.mobileqq.springhb.preload;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f289514a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75358);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f289514a = new byte[0];
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void b(AppRuntime appRuntime, int i3) {
        String str;
        try {
            synchronized (f289514a) {
                if (i3 == 1) {
                    str = "spring_2024_hb_preload_config_easter" + appRuntime.getCurrentAccountUin();
                } else if (i3 == 0) {
                    str = "spring_2024_hb_preload_config_sys_" + appRuntime.getCurrentAccountUin();
                } else {
                    str = "spring_2025_hb_preload_config" + appRuntime.getCurrentAccountUin();
                }
                QLog.i("SpringHb_Preload_SpringHbPreloadFileHelper", 1, String.format("deleteLocalEntryConfig fileName=%s", str));
                File fileStreamPath = BaseApplication.getContext().getFileStreamPath(str);
                if (fileStreamPath.exists()) {
                    fileStreamPath.delete();
                }
            }
            g(appRuntime, 0, "", i3);
        } catch (Exception e16) {
            QLog.e("SpringHb_Preload_SpringHbPreloadFileHelper", 1, "deleteLocalEntryConfig fail.", e16);
        }
    }

    private static String c(AppRuntime appRuntime, int i3) {
        String str;
        try {
            if (i3 == 0) {
                str = "spring_2024_hb_preload_config_config_md5_sys_" + appRuntime.getCurrentAccountUin();
            } else if (i3 == 1) {
                str = "spring_2024_hb_preload_config_config_md5_esster_" + appRuntime.getCurrentAccountUin();
            } else {
                str = "spring_2025_hb_preload_config_config_md5_2025" + appRuntime.getCurrentAccountUin();
            }
            return QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeString(str, "");
        } catch (Exception e16) {
            QLog.e("SpringHb_Preload_SpringHbPreloadFileHelper", 1, "getLocalConfigMD5FromMMKV fail.", e16);
            return null;
        }
    }

    public static int d(AppRuntime appRuntime, int i3) {
        String str;
        int i16 = 0;
        try {
            if (i3 == 0) {
                str = "spring_2024_hb_preload_config_config_version_sys_" + appRuntime.getCurrentAccountUin();
            } else if (i3 == 1) {
                str = "spring_2024_hb_preload_config_config_version_easter_" + appRuntime.getCurrentAccountUin();
            } else {
                str = "spring_2025_hb_preload_config_config_version_2025" + appRuntime.getCurrentAccountUin();
            }
            i16 = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeInt(str, 0);
            QLog.i("SpringHb_Preload_SpringHbPreloadFileHelper", 1, "getLocalConfigVersionFromMMKV version: " + i16);
            return i16;
        } catch (Exception e16) {
            QLog.e("SpringHb_Preload_SpringHbPreloadFileHelper", 1, "getLocalConfigVersionFromMMKV fail.", e16);
            return i16;
        }
    }

    public static long e(@NonNull AppRuntime appRuntime, @NonNull String str, long j3) {
        return QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeLong(str + "_" + appRuntime.getCurrentAccountUin(), j3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e6 A[Catch: all -> 0x0114, TRY_LEAVE, TryCatch #4 {all -> 0x0114, blocks: (B:33:0x00d2, B:35:0x00e6), top: B:32:0x00d2 }] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v11, types: [com.tencent.mobileqq.springhb.preload.h] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.tencent.mobileqq.springhb.preload.h] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static h f(AppRuntime appRuntime, int i3) {
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        ?? r75;
        BufferedInputStream bufferedInputStream2;
        Exception exc;
        String str;
        AppRuntime peekAppRuntime;
        ?? r85;
        Object obj;
        BufferedInputStream bufferedInputStream3;
        File fileStreamPath;
        Object obj2;
        synchronized (f289514a) {
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    if (i3 == 1) {
                        str = "spring_2024_hb_preload_config_easter" + appRuntime.getCurrentAccountUin();
                    } else if (i3 == 0) {
                        str = "spring_2024_hb_preload_config_sys_" + appRuntime.getCurrentAccountUin();
                    } else {
                        str = "spring_2025_hb_preload_config" + appRuntime.getCurrentAccountUin();
                    }
                    try {
                        fileStreamPath = BaseApplication.getContext().getFileStreamPath(str);
                    } catch (Exception e16) {
                        e = e16;
                        obj = null;
                        bufferedInputStream3 = null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = null;
                    fileInputStream = null;
                }
            } catch (Exception e17) {
                bufferedInputStream = null;
                r75 = 0;
                bufferedInputStream2 = null;
                exc = e17;
                str = null;
            }
            if (fileStreamPath.exists()) {
                if (TextUtils.equals(c(appRuntime, i3), MD5Utils.encodeFileHexStr(fileStreamPath.getAbsolutePath()))) {
                    fileInputStream = new FileInputStream(fileStreamPath);
                    try {
                        bufferedInputStream = new BufferedInputStream(fileInputStream);
                        try {
                            r75 = new ObjectInputStream(bufferedInputStream);
                            try {
                                try {
                                    ?? hVar = new h();
                                    try {
                                        hVar.d(r75);
                                        fileInputStream2 = r75;
                                        obj2 = hVar;
                                        a(fileInputStream2);
                                        a(bufferedInputStream);
                                        a(fileInputStream);
                                        r85 = obj2;
                                    } catch (Exception e18) {
                                        exc = e18;
                                        fileInputStream2 = fileInputStream;
                                        r75 = r75;
                                        bufferedInputStream2 = hVar;
                                        try {
                                            QLog.e("SpringHb_Preload_SpringHbPreloadFileHelper", 1, "loadLocalPreloadConfig fail.", exc);
                                            b(appRuntime, i3);
                                            peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                                            if (peekAppRuntime != null) {
                                                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(316, exc, new String[0]);
                                            }
                                            a(r75);
                                            a(bufferedInputStream);
                                            a(fileInputStream2);
                                            r85 = bufferedInputStream2;
                                            QLog.i("SpringHb_Preload_SpringHbPreloadFileHelper", 1, String.format("loadLocalPreloadConfig fileName=%s", str));
                                            return r85;
                                        } catch (Throwable th6) {
                                            th = th6;
                                            fileInputStream = fileInputStream2;
                                            fileInputStream2 = r75;
                                            a(fileInputStream2);
                                            a(bufferedInputStream);
                                            a(fileInputStream);
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    fileInputStream2 = r75;
                                    a(fileInputStream2);
                                    a(bufferedInputStream);
                                    a(fileInputStream);
                                    throw th;
                                }
                            } catch (Exception e19) {
                                bufferedInputStream2 = null;
                                fileInputStream2 = fileInputStream;
                                exc = e19;
                                r75 = r75;
                            }
                        } catch (Exception e26) {
                            bufferedInputStream2 = null;
                            fileInputStream2 = fileInputStream;
                            exc = e26;
                            r75 = 0;
                        } catch (Throwable th8) {
                            th = th8;
                            a(fileInputStream2);
                            a(bufferedInputStream);
                            a(fileInputStream);
                            throw th;
                        }
                    } catch (Exception e27) {
                        e = e27;
                        obj = null;
                        bufferedInputStream3 = null;
                        fileInputStream2 = fileInputStream;
                        exc = e;
                        bufferedInputStream = bufferedInputStream3;
                        r75 = obj;
                        bufferedInputStream2 = bufferedInputStream3;
                        QLog.e("SpringHb_Preload_SpringHbPreloadFileHelper", 1, "loadLocalPreloadConfig fail.", exc);
                        b(appRuntime, i3);
                        peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        if (peekAppRuntime != null) {
                        }
                        a(r75);
                        a(bufferedInputStream);
                        a(fileInputStream2);
                        r85 = bufferedInputStream2;
                        QLog.i("SpringHb_Preload_SpringHbPreloadFileHelper", 1, String.format("loadLocalPreloadConfig fileName=%s", str));
                        return r85;
                    } catch (Throwable th9) {
                        th = th9;
                        bufferedInputStream = null;
                    }
                    QLog.i("SpringHb_Preload_SpringHbPreloadFileHelper", 1, String.format("loadLocalPreloadConfig fileName=%s", str));
                } else {
                    QLog.e("SpringHb_Preload_SpringHbPreloadFileHelper", 1, "loadLocalPreloadConfig local config md5 not match.");
                    b(appRuntime, i3);
                }
            }
            bufferedInputStream = null;
            fileInputStream = null;
            obj2 = null;
            a(fileInputStream2);
            a(bufferedInputStream);
            a(fileInputStream);
            r85 = obj2;
            QLog.i("SpringHb_Preload_SpringHbPreloadFileHelper", 1, String.format("loadLocalPreloadConfig fileName=%s", str));
        }
        return r85;
    }

    private static void g(AppRuntime appRuntime, int i3, String str, int i16) {
        String str2;
        String str3;
        QLog.i("SpringHb_Preload_SpringHbPreloadFileHelper", 1, String.format("saveLocalConfigInfoToMMKV version=%s md5=%s", Integer.valueOf(i3), str));
        try {
            String currentAccountUin = appRuntime.getCurrentAccountUin();
            if (i16 == 0) {
                str2 = "spring_2024_hb_preload_config_config_version_sys_" + currentAccountUin;
            } else if (i16 == 1) {
                str2 = "spring_2024_hb_preload_config_config_version_easter_" + currentAccountUin;
            } else {
                str2 = "spring_2025_hb_preload_config_config_version_2025" + currentAccountUin;
            }
            if (i16 == 0) {
                str3 = "spring_2024_hb_preload_config_config_md5_sys_" + currentAccountUin;
            } else if (i16 == 1) {
                str3 = "spring_2024_hb_preload_config_config_md5_esster_" + currentAccountUin;
            } else {
                str3 = "spring_2025_hb_preload_config_config_md5_2025" + currentAccountUin;
            }
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
            from.encodeLong(str2, i3);
            from.encodeString(str3, str);
        } catch (Exception e16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(315, e16, new String[0]);
            }
            QLog.e("SpringHb_Preload_SpringHbPreloadFileHelper", 1, "saveLocalConfigInfoToMMKV fail.", e16);
        }
    }

    public static void h(AppRuntime appRuntime, h hVar, int i3) {
        ObjectOutputStream objectOutputStream;
        BufferedOutputStream bufferedOutputStream;
        OutputStream outputStream;
        String str;
        synchronized (f289514a) {
            OutputStream outputStream2 = null;
            try {
                try {
                    String currentUin = appRuntime.getCurrentUin();
                    if (i3 == 1) {
                        str = "spring_2024_hb_preload_config_easter" + currentUin;
                    } else if (i3 == 0) {
                        str = "spring_2024_hb_preload_config_sys_" + currentUin;
                    } else {
                        str = "spring_2025_hb_preload_config" + currentUin;
                    }
                    File fileStreamPath = BaseApplication.getContext().getFileStreamPath(str);
                    File fileStreamPath2 = BaseApplication.getContext().getFileStreamPath(str + ".tmp");
                    QLog.i("SpringHb_Preload_SpringHbPreloadFileHelper", 1, String.format("saveLocalPreloadConfig fileName=%s", str));
                    if (fileStreamPath2.exists()) {
                        fileStreamPath2.delete();
                    }
                    fileStreamPath2.createNewFile();
                    outputStream = new FileOutputStream(fileStreamPath2);
                    try {
                        bufferedOutputStream = new BufferedOutputStream(outputStream);
                        try {
                            objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
                            try {
                                hVar.e(objectOutputStream);
                                objectOutputStream.flush();
                                outputStream.flush();
                                if (fileStreamPath.exists()) {
                                    fileStreamPath.delete();
                                }
                                fileStreamPath2.renameTo(fileStreamPath);
                                g(appRuntime, hVar.f289507a, MD5Utils.encodeFileHexStr(fileStreamPath.getAbsolutePath()), i3);
                                a(outputStream);
                                a(bufferedOutputStream);
                                a(objectOutputStream);
                            } catch (Exception e16) {
                                e = e16;
                                outputStream2 = objectOutputStream;
                                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                                if (peekAppRuntime != null) {
                                    ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(315, e, new String[0]);
                                }
                                QLog.e("SpringHb_Preload_SpringHbPreloadFileHelper", 1, "saveLocalEntryConfig fail.", e);
                                b(appRuntime, i3);
                                a(outputStream);
                                a(bufferedOutputStream);
                                a(outputStream2);
                            } catch (Throwable th5) {
                                th = th5;
                                outputStream2 = outputStream;
                                a(outputStream2);
                                a(bufferedOutputStream);
                                a(objectOutputStream);
                                throw th;
                            }
                        } catch (Exception e17) {
                            e = e17;
                        }
                    } catch (Exception e18) {
                        e = e18;
                        bufferedOutputStream = null;
                    } catch (Throwable th6) {
                        th = th6;
                        bufferedOutputStream = null;
                        objectOutputStream = null;
                    }
                } catch (Exception e19) {
                    e = e19;
                    outputStream = null;
                    bufferedOutputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    bufferedOutputStream = null;
                    objectOutputStream = null;
                    a(outputStream2);
                    a(bufferedOutputStream);
                    a(objectOutputStream);
                    throw th;
                }
            } catch (Throwable th8) {
                th = th8;
                objectOutputStream = null;
            }
        }
    }

    public static void i(@NonNull AppRuntime appRuntime, @NonNull String str, long j3) {
        QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeLong(str + "_" + appRuntime.getCurrentAccountUin(), j3);
    }
}

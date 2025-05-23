package com.tencent.mobileqq.ar;

import android.annotation.TargetApi;
import android.os.Environment;
import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipEntry;

/* compiled from: P */
/* loaded from: classes11.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    static SimpleDateFormat f198369a;

    @TargetApi(18)
    public static boolean a() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception unused) {
            return false;
        }
    }

    public static long b(String str) {
        if (f198369a == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            f198369a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
        }
        try {
            return f198369a.parse(str).getTime();
        } catch (ParseException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_Utils", 2, "", e16);
            }
            return -1L;
        }
    }

    public static byte[] c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr));
                try {
                    byte[] bArr2 = new byte[256];
                    while (true) {
                        int read = inflaterInputStream.read(bArr2);
                        if (-1 != read) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                        } else {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            inflaterInputStream.close();
                            byteArrayOutputStream.close();
                            return byteArray;
                        }
                    }
                } finally {
                }
            } finally {
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (new File(str).getAbsolutePath().startsWith(AppConstants.SDCARD_PATH)) {
            return e();
        }
        return str;
    }

    public static String e() {
        if (a()) {
            return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH);
        }
        if (QLog.isColorLevel()) {
            QLog.i("ArConfig_Utils", 2, "no_sdcard");
        }
        float availableInnernalMemorySize = FileUtils.getAvailableInnernalMemorySize();
        if (availableInnernalMemorySize < 1.572864E7f && QLog.isColorLevel()) {
            QLog.i("ArConfig_Utils", 2, "inner memory avail may not enough : " + availableInnernalMemorySize);
        }
        return BaseApplication.getContext().getFilesDir().getAbsolutePath() + File.separator;
    }

    public static void f(String str, boolean z16, int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", String.valueOf(i3));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "olympic_ar_config", z16, 0L, 0L, hashMap, null);
    }

    public static void g(String str, boolean z16, int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", String.valueOf(i3));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "ar_client_download_report", z16, 0L, 0L, hashMap, null);
    }

    public static void h(String str, boolean z16, boolean z17) {
        boolean z18;
        String str2;
        String str3;
        String str4;
        if (z16 && z17) {
            z18 = true;
        } else {
            z18 = false;
        }
        boolean z19 = z18;
        HashMap<String, String> hashMap = new HashMap<>();
        String str5 = "1";
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put("ar_feature", str2);
        if (z17) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        hashMap.put("ar_model", str3);
        if (z19) {
            str4 = "1";
        } else {
            str4 = "0";
        }
        hashMap.put("ar_all_resource", str4);
        if (!z19) {
            str5 = "0";
        }
        hashMap.put("param_FailCode", str5);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "olympic_ar_pre_download", z19, 0L, 0L, hashMap, null);
    }

    public static void i(String str, String str2) throws IOException {
        QZipFile qZipFile;
        InputStream inputStream;
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_Utils", 2, "uncompressZip: path=" + str);
        }
        FileOutputStream fileOutputStream = null;
        try {
            qZipFile = new QZipFile(str);
            try {
                Enumeration<? extends ZipEntry> entries = qZipFile.entries();
                byte[] bArr = new byte[8192];
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    String name = nextElement.getName();
                    if (name != null && !name.contains("../")) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str2);
                        String str3 = File.separator;
                        sb5.append(str3);
                        sb5.append(name);
                        String sb6 = sb5.toString();
                        if (nextElement.isDirectory()) {
                            File file = new File(sb6);
                            if (!file.exists()) {
                                file.mkdir();
                            }
                        } else {
                            int lastIndexOf = sb6.lastIndexOf(str3);
                            String substring = sb6.substring(0, lastIndexOf);
                            if (!sb6.substring(lastIndexOf + 1).startsWith(".")) {
                                File file2 = new File(substring);
                                if (!file2.exists()) {
                                    file2.mkdir();
                                }
                                File file3 = new File(sb6 + ".tmp");
                                File file4 = new File(sb6);
                                if (file3.exists()) {
                                    file3.delete();
                                }
                                FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                                try {
                                    inputStream = qZipFile.getInputStream(nextElement);
                                    while (true) {
                                        try {
                                            int read = inputStream.read(bArr, 0, 8192);
                                            if (read == -1) {
                                                break;
                                            } else {
                                                fileOutputStream2.write(bArr, 0, read);
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            fileOutputStream = fileOutputStream2;
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException e16) {
                                                    e16.printStackTrace();
                                                }
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e17) {
                                                    e17.printStackTrace();
                                                }
                                            }
                                            if (qZipFile != null) {
                                                try {
                                                    qZipFile.close();
                                                    throw th;
                                                } catch (IOException e18) {
                                                    e18.printStackTrace();
                                                    throw th;
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                    fileOutputStream2.flush();
                                    fileOutputStream2.close();
                                    inputStream.close();
                                    if (!FileUtils.renameFile(file3, file4)) {
                                        FileUtils.copyFile(file3, file4);
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    inputStream = null;
                                }
                            }
                        }
                    }
                }
                try {
                    qZipFile.close();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
            } catch (Throwable th7) {
                th = th7;
                inputStream = null;
            }
        } catch (Throwable th8) {
            th = th8;
            qZipFile = null;
            inputStream = null;
        }
    }
}

package com.tencent.open.appcommon;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.base.f;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes22.dex */
public class Common {

    /* renamed from: a, reason: collision with root package name */
    public static final String f340639a = "file:///android_asset" + File.separator + "Page/system";

    public static void A(String str) {
        SharedPreferences.Editor edit = com.tencent.open.adapter.a.f().e().getSharedPreferences("qzoneappcenter", 4).edit();
        edit.putString("appstoreagentversion", str);
        edit.commit();
    }

    public static void B(int i3) {
        SharedPreferences.Editor edit = com.tencent.open.adapter.a.f().e().getSharedPreferences("qzoneappcenter", 4).edit();
        edit.putInt("appTabVersionCode", i3);
        edit.commit();
    }

    public static void C(boolean z16) {
        SharedPreferences.Editor edit = com.tencent.open.adapter.a.f().e().getSharedPreferences("qzoneappcenter", 4).edit();
        edit.putBoolean("appstoreclearcache", z16);
        edit.commit();
    }

    public static void D(String str) {
        f.a("Common", "setLastResourceZipMd5=" + str);
        SharedPreferences.Editor edit = com.tencent.open.adapter.a.f().e().getSharedPreferences("qzoneappcenter", 4).edit();
        edit.putString("lastresourcezipmd5", str);
        edit.commit();
    }

    public static void E(String str) {
        f.a("Common", "setResourceMD5=" + str);
        SharedPreferences.Editor edit = com.tencent.open.adapter.a.f().e().getSharedPreferences("qzoneappcenter", 4).edit();
        edit.putString("relastmd5", str);
        edit.commit();
    }

    public static void F(long j3, long j16) {
        SharedPreferences.Editor edit = com.tencent.open.adapter.a.f().e().getSharedPreferences("qzoneappcenter", 4).edit();
        edit.putLong("remaxage", j3);
        edit.putLong("relasttime", j16);
        edit.commit();
    }

    public static synchronized void G(String str) {
        synchronized (Common.class) {
            SharedPreferences.Editor edit = com.tencent.open.adapter.a.f().e().getSharedPreferences("qzoneappcenter", 4).edit();
            edit.putString("sdhtmldir", str);
            edit.commit();
        }
    }

    public static long H(InputStream inputStream, String str, String str2) throws Exception {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, str2);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (-1 == read) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    }
                    fileOutputStream2.flush();
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused) {
                    }
                    return file2.length();
                } catch (Exception e16) {
                    throw e16;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            throw e17;
        }
    }

    public static synchronized void a(boolean z16) {
        long j3;
        synchronized (Common.class) {
            ScheduledExecutorService newSingleThreadScheduledExecutor = ProxyExecutors.newSingleThreadScheduledExecutor();
            Runnable runnable = new Runnable() { // from class: com.tencent.open.appcommon.Common.1
                @Override // java.lang.Runnable
                public void run() {
                    File file = new File(Common.i());
                    if (file.exists()) {
                        for (File file2 : file.listFiles()) {
                            if (file2.getName().startsWith("system_old_") || (file2.isDirectory() && !file2.getName().equals("tmp") && !TextUtils.isEmpty(Common.r()) && !file2.getName().equals(Common.r()))) {
                                if (com.tencent.open.base.c.b(new File(file + File.separator + file2.getName()))) {
                                    f.e("Common", "<initSystemFolder> delete temp file<" + file2.getName() + "> successful");
                                } else {
                                    f.a("Common", "<initSystemFolder> delete temp file<" + file2.getName() + "> failed");
                                }
                            }
                        }
                    }
                }
            };
            if (z16) {
                j3 = 10;
            } else {
                j3 = 0;
            }
            newSingleThreadScheduledExecutor.schedule(runnable, j3, TimeUnit.SECONDS);
        }
    }

    public static String b() {
        return com.tencent.open.adapter.a.f().e().getSharedPreferences("qzoneappcenter", 4).getString("appstoreagentversion", "");
    }

    public static String c() {
        return s() + File.separator + "qapp_center_index.htm";
    }

    public static int d() {
        return com.tencent.open.adapter.a.f().e().getSharedPreferences("qzoneappcenter", 4).getInt("appTabVersionCode", -1);
    }

    public static String e() {
        return "file:///android_asset" + File.separator + "Page/system";
    }

    public static boolean f() {
        return com.tencent.open.adapter.a.f().e().getSharedPreferences("qzoneappcenter", 4).getBoolean("appstoreclearcache", false);
    }

    public static String g() {
        return i() + File.separator + "resource.diff";
    }

    public static String[] h(String str) {
        String str2 = "";
        if (str.toLowerCase().startsWith("sd://")) {
            String substring = str.substring(5);
            int indexOf = substring.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            if (indexOf != -1) {
                String substring2 = substring.substring(0, indexOf);
                str2 = substring.substring(indexOf + 1);
                substring = substring2;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(s());
            String str3 = File.separator;
            sb5.append(str3);
            sb5.append(substring);
            if (new File(sb5.toString()).exists()) {
                str = "file:///" + s() + str3 + substring;
            } else {
                str = "file:///android_asset/Page/system/" + substring;
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            str2 = ContainerUtils.FIELD_DELIMITER + str2;
        }
        f.a("Common", "url params= " + str + " " + str2);
        return new String[]{str, str2};
    }

    public static String i() {
        return l() + File.separator + ".AppCenterWebBuffer_QQ";
    }

    public static String j() {
        return com.tencent.open.adapter.a.f().e().getSharedPreferences("qzoneappcenter", 4).getString("lastresourcezipmd5", "");
    }

    public static String k() {
        return i() + File.separator + "resource_merged.zip";
    }

    public static String l() {
        String e16 = com.tencent.mobileqq.vfs.b.i().e();
        if (TextUtils.isEmpty(e16)) {
            return ".";
        }
        return e16;
    }

    public static String m() {
        int myPid = Process.myPid();
        try {
            Context e16 = com.tencent.open.adapter.a.f().e();
            if (e16 == null) {
                return "";
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) e16.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return "";
        } catch (Exception unused) {
            f.a("Common", "exception happened!");
            return "";
        }
    }

    public static String n() {
        return com.tencent.open.adapter.a.f().e().getSharedPreferences("qzoneappcenter", 4).getString("relastmd5", "");
    }

    public static long[] o() {
        SharedPreferences sharedPreferences = com.tencent.open.adapter.a.f().e().getSharedPreferences("qzoneappcenter", 4);
        return new long[]{sharedPreferences.getLong("remaxage", 0L), sharedPreferences.getLong("relasttime", 0L)};
    }

    public static long p() {
        StatFs statFs = new StatFs(q());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public static String q() {
        String str = "/mnt/sdcard-ext";
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                str = Environment.getExternalStorageDirectory().getAbsolutePath();
            } else if (!new File("/mnt/sdcard-ext").isDirectory()) {
                str = ".";
            }
            return str;
        } catch (Exception unused) {
            return ".";
        }
    }

    public static String r() {
        return com.tencent.open.adapter.a.f().e().getSharedPreferences("qzoneappcenter", 4).getString("sdhtmldir", "");
    }

    public static String s() {
        String r16 = r();
        f.e("Common", "<getSDResDir> getSDResDir=" + r16);
        if (TextUtils.isEmpty(r16)) {
            return "";
        }
        return i() + File.separator + r16;
    }

    public static String t() {
        return i() + File.separator + "tmp";
    }

    public static String u() {
        return i() + File.separator + "system_old_";
    }

    public static String v() {
        return i() + File.separator + "resource.zip";
    }

    public static boolean w() {
        if (Environment.getExternalStorageState().equals("mounted") || new File("/mnt/sdcard-ext").isDirectory()) {
            return true;
        }
        return false;
    }

    public static synchronized void x() {
        synchronized (Common.class) {
            f.e("Common", "<initSystemFolder> begin to init system file... ");
            File file = new File(i());
            if (!file.exists()) {
                file.mkdirs();
            }
            a(true);
        }
    }

    public static String y(Map<String, String> map) throws UnsupportedEncodingException {
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = true;
        for (String str : map.keySet()) {
            String str2 = map.get(str);
            if (z16) {
                sb5.append(str + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(str2, "utf-8"));
                z16 = false;
            } else if (str2 != null) {
                sb5.append(ContainerUtils.FIELD_DELIMITER + str + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(str2, "utf-8"));
            } else {
                sb5.append(ContainerUtils.FIELD_DELIMITER + str + ContainerUtils.KEY_VALUE_DELIMITER);
            }
        }
        return sb5.toString();
    }

    public static HashMap<String, String> z(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (str != null) {
            if (str.startsWith(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) || str.startsWith(ContainerUtils.FIELD_DELIMITER)) {
                str = str.substring(1);
            }
            for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split.length > 1) {
                    hashMap.put(split[0], URLDecoder.decode(split[1]));
                }
            }
        }
        return hashMap;
    }
}

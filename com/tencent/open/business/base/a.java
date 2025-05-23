package com.tencent.open.business.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.AssetManager;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.base.f;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected static Map<String, String> f341048a = new HashMap();

    public static boolean a(String str) {
        return PackageUtil.isAppInstalled(com.tencent.open.adapter.a.f().e(), str);
    }

    public static void b(String str) throws IOException {
        QZipFile qZipFile = null;
        try {
            long length = new File(str).length();
            QZipFile qZipFile2 = new QZipFile(str);
            try {
                Enumeration<? extends ZipEntry> entries = qZipFile2.entries();
                boolean z16 = false;
                boolean z17 = false;
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    if (!nextElement.isDirectory()) {
                        long compressedSize = nextElement.getCompressedSize();
                        long size = nextElement.getSize();
                        if (compressedSize >= -1 && compressedSize <= length && size >= -1 && size <= 1500 * compressedSize) {
                            if (nextElement.getName() != null && nextElement.getName().contains("AndroidManifest.xml")) {
                                if (compressedSize != 0 && size != 0) {
                                    n(qZipFile2, nextElement, false);
                                    z16 = true;
                                } else {
                                    throw new RuntimeException("Invalid AndroidManifest!");
                                }
                            } else if (nextElement.getName() != null && nextElement.getName().contains("classes.dex")) {
                                n(qZipFile2, nextElement, false);
                                z17 = true;
                            }
                            if (z17 && z16) {
                                qZipFile2.close();
                                return;
                            }
                        } else {
                            throw new RuntimeException("Invalid entry size!");
                        }
                    }
                }
                qZipFile2.close();
            } catch (Throwable th5) {
                th = th5;
                qZipFile = qZipFile2;
                if (qZipFile != null) {
                    qZipFile.close();
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x003e, code lost:
    
        if (r1 != null) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(String[] strArr) {
        String str = "";
        Process process = null;
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(strArr);
            processBuilder.redirectErrorStream(false);
            process = processBuilder.start();
            DataOutputStream dataOutputStream = new DataOutputStream(process.getOutputStream());
            str = new DataInputStream(process.getInputStream()).readLine();
            dataOutputStream.writeBytes("exit\n");
            dataOutputStream.flush();
            process.waitFor();
        } catch (Exception unused) {
        } catch (Throwable th5) {
            if (process != null) {
                process.destroy();
            }
            throw th5;
        }
        process.destroy();
        return str;
    }

    public static Bitmap d(String str) {
        ApplicationInfo applicationInfo;
        Drawable loadIcon;
        try {
            PackageManager packageManager = com.tencent.open.adapter.a.f().e().getPackageManager();
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, str, 1);
            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null && (loadIcon = applicationInfo.loadIcon(packageManager)) != null) {
                return com.tencent.open.base.d.e(loadIcon);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            PackageInfo packageArchiveInfo = com.tencent.open.adapter.a.f().e().getPackageManager().getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo == null) {
                return null;
            }
            return packageArchiveInfo.applicationInfo.packageName;
        } catch (Exception e16) {
            f.d("AppUtil", "getApkName>>>", e16);
            return null;
        }
    }

    public static String f(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static int g(String str) {
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(com.tencent.open.adapter.a.f().e().getPackageManager(), str, 1);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (Exception e16) {
            f.j("AppUtil", "getApkVersonCode>>>", e16);
            return 0;
        }
    }

    public static int h(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            PackageInfo packageArchiveInfo = com.tencent.open.adapter.a.f().e().getPackageManager().getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.versionCode;
            }
        } catch (Exception e16) {
            f.d("AppUtil", "getApkVersonCodeFromApkFile>>>", e16);
        }
        return 0;
    }

    public static int i(String str) {
        XmlResourceParser xmlResourceParser;
        f.e("AppUtil", "getAppVersionCode: " + str);
        try {
            b(str);
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            Method declaredMethod = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(assetManager, str);
            xmlResourceParser = assetManager.openXmlResourceParser("AndroidManifest.xml");
        } catch (Exception e16) {
            f.c("AppUtil", "openManifest failed: " + e16.getMessage());
            xmlResourceParser = null;
        }
        if (xmlResourceParser == null) {
            return 0;
        }
        try {
            for (int eventType = xmlResourceParser.getEventType(); eventType != 1; eventType = xmlResourceParser.nextToken()) {
                if (eventType == 2) {
                    String name = xmlResourceParser.getName();
                    if (!TextUtils.isEmpty(name) && name.equals("manifest")) {
                        for (int i3 = 0; i3 < xmlResourceParser.getAttributeCount(); i3++) {
                            if (xmlResourceParser.getAttributeName(i3).equals("versionCode")) {
                                String attributeValue = xmlResourceParser.getAttributeValue(i3);
                                xmlResourceParser.close();
                                f.e("AppUtil", "apkPath:" + str + ",versionCode:" + attributeValue);
                                return Integer.parseInt(attributeValue);
                            }
                        }
                    }
                }
            }
        } catch (IOException e17) {
            f.c("AppUtil", "error: " + e17.getMessage());
        } catch (XmlPullParserException e18) {
            f.c("AppUtil", "error: " + e18.getMessage());
        } catch (Exception e19) {
            f.c("AppUtil", "error: " + e19.getMessage());
        }
        xmlResourceParser.close();
        return 0;
    }

    public static String j(Context context) {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (Exception e16) {
            f.j("AppUtil", "getCurProcessName err", e16);
            return null;
        }
    }

    public static Process k() {
        ProcessBuilder processBuilder = new ProcessBuilder("su");
        processBuilder.redirectErrorStream(false);
        try {
            return processBuilder.start();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static int l() {
        String[] strArr = {"/system/xbin/", "/system/bin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i3 = 0; i3 < 5; i3++) {
            try {
                String str = strArr[i3] + "su";
                if (new File(str).exists()) {
                    String c16 = c(new String[]{"ls", "-l", str});
                    if (!TextUtils.isEmpty(c16)) {
                        if (c16.indexOf("root") != c16.lastIndexOf("root")) {
                            return 1;
                        }
                    }
                    return 0;
                }
            } catch (Exception unused) {
            }
        }
        return 2;
    }

    public static Intent m(Context context, String str) {
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.addFlags(1073741824);
        if (!f341048a.containsKey(str)) {
            for (ResolveInfo resolveInfo : InstalledAppListMonitor.queryIntentActivities(context.getPackageManager(), intent, 0)) {
                if (!f341048a.containsKey(resolveInfo.activityInfo.applicationInfo.packageName)) {
                    Map<String, String> map = f341048a;
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    map.put(activityInfo.applicationInfo.packageName, activityInfo.name);
                }
            }
        }
        String str2 = f341048a.get(str);
        if (str2 == null) {
            return null;
        }
        intent.setComponent(new ComponentName(str, str2));
        return intent;
    }

    public static void n(QZipFile qZipFile, ZipEntry zipEntry, boolean z16) throws IOException {
        InputStream inputStream;
        byte[] bArr = new byte[4096];
        try {
            inputStream = qZipFile.getInputStream(zipEntry);
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
        }
        try {
            if (z16) {
                do {
                } while (-1 != inputStream.read(bArr));
            } else {
                inputStream.read(bArr);
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th6) {
            th = th6;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public static boolean o(Context context, String str) {
        return p(context, str, "");
    }

    public static boolean p(Context context, String str, String str2) {
        return q(context, str, str2, "");
    }

    public static boolean q(Context context, String str, String str2, String str3) {
        return r(context, str, str2, str3, "0");
    }

    public static boolean r(Context context, String str, String str2, String str3, String str4) {
        try {
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                return false;
            }
            TMAssistantDownloadManager.getInstance(context.getApplicationContext()).hookAM4Install();
            Intent openApkIntent = FileProvider7Helper.openApkIntent(context, str);
            if (GlobalUtil.isVivo()) {
                openApkIntent.putExtra("installDir", true);
            }
            if (!TextUtils.isEmpty(str2)) {
                f.e("AppUtil", "installApp>>> put source " + str2);
                openApkIntent.putExtra("big_brother_source_key", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                f.e("AppUtil", "installApp>>> put ref id " + str3);
                openApkIntent.putExtra(LaunchParam.KEY_REF_ID, str3);
            }
            if (!TextUtils.isEmpty(str4) && "1".equals(str4)) {
                openApkIntent.putExtra("android.intent.extra.RETURN_RESULT", true);
            }
            context.startActivity(openApkIntent);
            return true;
        } catch (Exception e16) {
            f.d("AppUtil", "installApp>>>", e16);
            return false;
        }
    }

    public static boolean s(Context context) {
        if (context == null) {
            f.c("AppUtil", "isPackageScanAllowed context is null");
            return true;
        }
        try {
            return com.tencent.open.adapter.a.f().e().getSharedPreferences("package_scan", 0).getBoolean(AppConstants.Preferences.QQSETTING_PACKAGE_SCAN_FLAG, true);
        } catch (Exception e16) {
            e16.printStackTrace();
            return true;
        }
    }

    public static boolean t(Context context, String str, Bundle bundle, int i3) {
        Intent launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(context.getPackageManager(), str);
        if (launchIntentForPackage == null) {
            launchIntentForPackage = new Intent(str);
            launchIntentForPackage.addCategory("android.intent.category.DEFAULT");
        }
        try {
            launchIntentForPackage.addFlags(i3);
            launchIntentForPackage.putExtras(bundle);
            try {
                try {
                    ((StartAppCheckHandler) ((BaseActivity) context).app.getBusinessHandler(BusinessHandlerFactory.STARTAPPCHECK_HANDLER)).J2(str.trim(), context, launchIntentForPackage);
                    return true;
                } catch (Exception unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AppStartedHandler", 2, "<-- StartAppCheckHandler Failed!");
                    }
                    context.startActivity(launchIntentForPackage);
                    return true;
                }
            } catch (Exception unused2) {
                new StartAppCheckHandler(null).K2(str.trim(), context, launchIntentForPackage);
                return true;
            }
        } catch (Exception unused3) {
            Toast.makeText(context, HardCodeUtil.qqStr(R.string.joa), 0).show();
            return false;
        }
    }

    public static boolean u() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("su");
            processBuilder.redirectErrorStream(false);
            Process start = processBuilder.start();
            DataOutputStream dataOutputStream = new DataOutputStream(start.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(start.getInputStream());
            dataOutputStream.flush();
            dataOutputStream.writeBytes("id\n");
            dataOutputStream.flush();
            dataOutputStream.writeBytes("exit\n");
            dataOutputStream.flush();
            start.waitFor();
            String readLine = dataInputStream.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return false;
            }
            if (!readLine.contains("uid=0")) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static boolean v(String str) {
        String str2;
        Process k3 = k();
        boolean z16 = false;
        if (k3 == null) {
            return false;
        }
        try {
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(k3.getOutputStream());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(k3.getInputStream(), "UTF-8"));
                File file = new File(str);
                String parent = file.getParent();
                String parent2 = new File(parent).getParent();
                String parent3 = new File(parent2).getParent();
                dataOutputStream.write(("chmod 777 " + file.getAbsolutePath() + "\n").getBytes());
                dataOutputStream.flush();
                dataOutputStream.writeBytes("chmod 777 " + parent + "\n");
                dataOutputStream.flush();
                dataOutputStream.writeBytes("chmod 777 " + parent2 + "\n");
                dataOutputStream.flush();
                dataOutputStream.writeBytes("chmod 777 " + parent3 + "\n");
                dataOutputStream.flush();
                dataOutputStream.write(("LD_LIBRARY_PATH=/vendor/lib:/system/lib pm install -r " + str + "\n").getBytes());
                dataOutputStream.flush();
                dataOutputStream.close();
                char[] cArr = new char[1024];
                int read = bufferedReader.read(cArr);
                StringBuilder sb5 = new StringBuilder();
                if (read != -1) {
                    sb5.append(cArr, 0, read);
                    str2 = sb5.toString();
                } else {
                    byte[] bArr = new byte[1024];
                    str2 = new String(bArr, 0, k3.getErrorStream().read(bArr));
                }
                if (!TextUtils.isEmpty(str2)) {
                    if (str2.toLowerCase().contains("success")) {
                        z16 = true;
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            return z16;
        } finally {
            k3.destroy();
        }
    }

    public static void w(Context context, String str) {
        x(context, str, "");
    }

    public static void x(Context context, String str, String str2) {
        try {
            Intent launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(context.getPackageManager(), str);
            launchIntentForPackage.putExtra(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "qzone_m");
            f.a("add", ">>has add platformid=qzone_m");
            context.startActivity(launchIntentForPackage);
        } catch (Exception unused) {
            new Intent();
            Intent m3 = m(context, str);
            if (m3 != null) {
                m3.setAction("android.intent.action.MAIN");
                m3.putExtra(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "qzone_m");
                m3.putExtra("big_brother_source_key", str2);
                f.a("add", ">>has add platformid=qzone_m");
                try {
                    context.startActivity(m3);
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    Toast.makeText(context, HardCodeUtil.qqStr(R.string.jo8), 0).show();
                    return;
                }
            }
            Toast.makeText(context, HardCodeUtil.qqStr(R.string.jo9), 0).show();
        }
    }

    public static void y(Context context, String str, String str2, String str3) {
        Intent launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(context.getPackageManager(), str2);
        if (launchIntentForPackage == null) {
            launchIntentForPackage = new Intent(str2);
            launchIntentForPackage.addCategory("android.intent.category.DEFAULT");
        }
        if (!TextUtils.isEmpty(str3)) {
            launchIntentForPackage.putExtra("appCustom", str3);
            f.a("add", ">>has add appCustom=" + str3);
        }
        launchIntentForPackage.putExtra(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "qzone_m");
        f.a("add", ">>has add platformid=qzone_m");
        try {
            if (!(context instanceof Activity)) {
                launchIntentForPackage.addFlags(268435456);
            }
            context.startActivity(launchIntentForPackage);
        } catch (Exception unused) {
            Toast.makeText(context, HardCodeUtil.qqStr(R.string.jo_), 0).show();
        }
    }

    public static boolean z(Context context, String str) {
        try {
            context.startActivity(new Intent("android.intent.action.DELETE", Uri.parse("package:" + str)));
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }
}

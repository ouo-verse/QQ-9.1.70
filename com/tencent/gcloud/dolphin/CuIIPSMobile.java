package com.tencent.gcloud.dolphin;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportKey;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes6.dex */
public class CuIIPSMobile {
    static IPatchRedirector $redirector_ = null;
    private static final String PROVIDER_NAME = ".ApolloFileprovider";
    private static final String RES_SUFFIX = ".res";
    private static final String TAG = "CuIIPSMobile";
    WifiManager.WifiLock wifiLock;

    public CuIIPSMobile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.wifiLock = null;
        }
    }

    public static String GetApkAbsPath(Object obj) {
        Context context = (Context) obj;
        try {
            String str = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir;
            Log.v("GetApkAbsPath", "getapkpath success, path:" + str);
            return str;
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            Log.e(TAG, "GetApkAbsPath getapkpath failed");
            return "error";
        }
    }

    public static String GetObbAbsPath(Object obj) {
        String absolutePath = ((Context) obj).getObbDir().getAbsolutePath();
        Log.v("GetObbAbsPath", "getapkpath success, path:" + absolutePath);
        return absolutePath;
    }

    public static String GetSDCardPath() {
        try {
            return Environment.getExternalStorageDirectory().getPath();
        } catch (Exception unused) {
            Log.v(" GetSDCardPath", "get sdcard path failed");
            return "error";
        }
    }

    public static boolean copyResFileFromApp(Object obj, String str, String str2) {
        Context context = (Context) obj;
        if (context == null) {
            Log.e(TAG, "Dolphin copyResFileFromApp the activity is null");
            return false;
        }
        if (str != null && str.length() != 0) {
            if (str2 != null && str2.length() != 0) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.length());
                String str3 = str2 + substring;
                Log.i(TAG, "copyResFileFromApp srcFileName:" + substring + ",dstAbsPath" + str3);
                try {
                    InputStream open = context.getAssets().open(substring);
                    File file = new File(str2);
                    if (!file.exists() && !file.mkdirs()) {
                        Log.e(TAG, "Dolphin copyResFileFromApp dstFileDir:" + file + "makedir failed");
                        return false;
                    }
                    File file2 = new File(str3);
                    if (file2.exists() && !file2.delete()) {
                        Log.e(TAG, "Dolphin copyResFileFromApp dstFile:" + file2 + "delete failed");
                        return false;
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = open.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileOutputStream.flush();
                            open.close();
                            fileOutputStream.close();
                            return true;
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return false;
                }
            } else {
                Log.e(TAG, "Dolphin copyResFileFromApp the dstPath is null");
                return false;
            }
        } else {
            Log.e(TAG, "Dolphin copyResFileFromApp the srcPath is null");
            return false;
        }
    }

    public static String getBundleId(Object obj) {
        try {
            return ((Context) obj).getPackageName();
        } catch (Exception e16) {
            Log.e(TAG, "GetBundleId Exception:" + e16);
            return null;
        }
    }

    public static String getVersionCode(Object obj) {
        Context context = (Context) obj;
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode + "";
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static int installAPK(String str, Object obj) {
        Context context = (Context) obj;
        if (context == null) {
            Log.e(TAG, "installAPK the context is null");
            return -1;
        }
        if (str == null || str.length() == 0 || !isFileExist(str)) {
            return -1;
        }
        File file = new File(str);
        if (!str.startsWith(Environment.getExternalStorageDirectory().getPath())) {
            Log.d(TAG, "we don't support install path=" + str);
            return -2;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        int i3 = context.getApplicationInfo().targetSdkVersion;
        Log.d(TAG, "targetVersion=" + i3);
        if (i3 >= 24 && Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
            intent.setDataAndType(FileProvider.getUriForFile(context, context.getPackageName() + PROVIDER_NAME, file), "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        }
        try {
            context.startActivity(intent);
            return 0;
        } catch (ActivityNotFoundException e16) {
            e16.printStackTrace();
            return -3;
        }
    }

    public static boolean isFileExist(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return true;
        }
        return false;
    }

    public boolean createWifiLock(Object obj, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, obj, i3)).booleanValue();
        }
        WifiManager.WifiLock createWifiLock = ((WifiManager) ((Context) obj).getSystemService("wifi")).createWifiLock(i3, "cu_iipsmobile_wifilock");
        this.wifiLock = createWifiLock;
        if (createWifiLock != null) {
            return true;
        }
        return false;
    }

    public String install(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        ProcessBuilder processBuilder = new ProcessBuilder("pm", VRReportDefine$ReportKey.INSTALL, "-r", str);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Process start = processBuilder.start();
            InputStream errorStream = start.getErrorStream();
            while (true) {
                int read = errorStream.read();
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(read);
            }
            InputStream inputStream = start.getInputStream();
            while (true) {
                int read2 = inputStream.read();
                if (read2 != -1) {
                    byteArrayOutputStream.write(read2);
                } else {
                    return new String(byteArrayOutputStream.toByteArray());
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public boolean isOpenNetwork(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, obj)).booleanValue();
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) ((Context) obj).getSystemService("connectivity");
        if (connectivityManager.getActiveNetworkInfo() != null) {
            return connectivityManager.getActiveNetworkInfo().isAvailable();
        }
        return false;
    }

    public boolean isWifiLocked() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        WifiManager.WifiLock wifiLock = this.wifiLock;
        if (wifiLock != null) {
            return wifiLock.isHeld();
        }
        return false;
    }

    public boolean lockWifi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (isWifiLocked()) {
            return true;
        }
        WifiManager.WifiLock wifiLock = this.wifiLock;
        if (wifiLock != null) {
            wifiLock.acquire();
            return true;
        }
        return false;
    }

    public boolean releaseLock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        WifiManager.WifiLock wifiLock = this.wifiLock;
        if (wifiLock != null && wifiLock.isHeld()) {
            this.wifiLock.release();
            return true;
        }
        if (this.wifiLock == null) {
            return true;
        }
        return false;
    }

    public boolean slientInstall(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        try {
            Process exec = RuntimeMonitor.exec(Runtime.getRuntime(), "su");
            OutputStream outputStream = exec.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeBytes("chmod 777 " + str + "\n");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("LD_LIBRARY_PATH=/vendor/lib:/system/lib pm install -r ");
            sb5.append(str);
            dataOutputStream.writeBytes(sb5.toString());
            dataOutputStream.flush();
            dataOutputStream.close();
            outputStream.close();
            if (exec.waitFor() != 0) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public boolean testnet(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).booleanValue();
        }
        try {
            int responseCode = ((HttpURLConnection) new URL(str).openConnection()).getResponseCode();
            Log.v("CuIIPSMobile::testnet", "connect code" + responseCode);
            if (responseCode == 200) {
                Log.v("CuIIPSMobile::testnet", "testnet net is ok");
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public int toggleWiFi(Object obj, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, obj, Boolean.valueOf(z16))).intValue();
        }
        Log.v(TAG, "toggleWiFi begin");
        ((WifiManager) ((Context) obj).getSystemService("wifi")).setWifiEnabled(z16);
        return 1;
    }
}

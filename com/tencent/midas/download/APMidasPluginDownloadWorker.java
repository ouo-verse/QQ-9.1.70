package com.tencent.midas.download;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginConfig;
import com.tencent.midas.plugin.APPluginUtils;
import com.tenpay.sdk.download.HttpOp;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes9.dex */
class APMidasPluginDownloadWorker implements Runnable {
    private static final String TAG = "PluginDownloadWorker";
    private final Context context;
    private final ArrayList<APMidasPluginDownInfo> downInfos;
    private final IAPMidasPluginDownListener downListener;
    private final File saveDir;

    /* JADX INFO: Access modifiers changed from: package-private */
    public APMidasPluginDownloadWorker(Context context, ArrayList<APMidasPluginDownInfo> arrayList, File file, IAPMidasPluginDownListener iAPMidasPluginDownListener) {
        this.downInfos = arrayList;
        this.saveDir = file;
        this.downListener = iAPMidasPluginDownListener;
        this.context = context;
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.Closeable] */
    private boolean downloadSingleDownInfo(APMidasPluginDownInfo aPMidasPluginDownInfo) {
        String str;
        ?? r65;
        FileOutputStream fileOutputStream;
        if (aPMidasPluginDownInfo == null) {
            APLog.e(TAG, "Cannot download down info, info is null!");
            return false;
        }
        if (TextUtils.isEmpty(aPMidasPluginDownInfo.full_url)) {
            APLog.e(TAG, "Cannot download down info, info's url is empty!");
            return false;
        }
        if (TextUtils.isEmpty(aPMidasPluginDownInfo.name)) {
            APLog.e(TAG, "Cannot download down info, info's name is empty!");
            return false;
        }
        if (!aPMidasPluginDownInfo.name.endsWith(".apk") && !aPMidasPluginDownInfo.name.endsWith(".Apk") && !aPMidasPluginDownInfo.name.endsWith(".APK")) {
            str = aPMidasPluginDownInfo.name + ".apk";
        } else {
            str = aPMidasPluginDownInfo.name;
        }
        if (isPluginAlreadyExist(this.context, str, aPMidasPluginDownInfo.new_md5_decode, this.saveDir.getAbsolutePath())) {
            APLog.d(TAG, "plugin already test, no need to download! name = " + str);
            return true;
        }
        String str2 = aPMidasPluginDownInfo.full_url;
        APLog.d(TAG, "download single down info! Start to down url = " + str2);
        APLog.d(TAG, "download single down info! Start to down file name = " + str);
        File file = new File(this.saveDir, str);
        if (file.exists()) {
            if (!file.delete()) {
                APLog.e(TAG, "File already exist test, cannot delete old file, file = " + file.getAbsolutePath());
                return false;
            }
            ?? sb5 = new StringBuilder();
            sb5.append("download single down info! file name already exist, delete it successfully = ");
            r65 = file.getAbsolutePath();
            sb5.append(r65);
            APLog.w(TAG, sb5.toString());
        }
        InputStream inputStream = null;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                httpURLConnection.setConnectTimeout(HttpOp.HTTP_READTIMEOUT);
                httpURLConnection.setReadTimeout(HttpOp.HTTP_READTIMEOUT);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    APLog.e(TAG, "Cannot download file, http code not 200! Code = " + responseCode);
                    closeQuietly(null);
                    closeQuietly(null);
                    return false;
                }
                if (!file.createNewFile()) {
                    APLog.e(TAG, "Cannot download file, fail to create file! File = " + file.getAbsolutePath());
                    closeQuietly(null);
                    closeQuietly(null);
                    return false;
                }
                fileOutputStream = new FileOutputStream(file);
                try {
                    inputStream = httpURLConnection.getInputStream();
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileOutputStream.flush();
                            closeQuietly(inputStream);
                            closeQuietly(fileOutputStream);
                            APLog.d(TAG, "download single down info success! File name = " + str + " About to copy to sdcard!");
                            return true;
                        }
                    }
                } catch (Exception e16) {
                    e = e16;
                    e.printStackTrace();
                    APLog.e(TAG, "download single down info fail! File name = " + str);
                    closeQuietly(inputStream);
                    closeQuietly(fileOutputStream);
                    return false;
                }
            } catch (Exception e17) {
                e = e17;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                r65 = 0;
                closeQuietly(null);
                closeQuietly(r65);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            closeQuietly(null);
            closeQuietly(r65);
            throw th;
        }
    }

    private static boolean isPluginAlreadyExist(Context context, String str, String str2, String str3) {
        APLog.d(TAG, "plugin already exist in midasplugins test, file name = " + str);
        APLog.d(TAG, "plugin already exist in midasplugins test, md5 = " + str2);
        if (TextUtils.isEmpty(str)) {
            APLog.e(TAG, "plugin already exist in midasplugins test error, empty file name!");
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            APLog.e(TAG, "plugin already exist in midasplugins test error, empty md5!");
            return false;
        }
        if (context == null) {
            APLog.e(TAG, "plugin already exist in midasplugins test error, null context!");
            return false;
        }
        if (TextUtils.isEmpty(str3)) {
            APLog.e(TAG, "plugin already exist in midasplugins test error, empty saveDir!");
            return false;
        }
        File pluginPath = APPluginConfig.getPluginPath(context);
        if (pluginPath == null) {
            APLog.e(TAG, "plugin already exist in midasplugins error, cannot get plugin path!");
            return false;
        }
        File file = new File(pluginPath, str);
        if (!file.exists()) {
            APLog.d(TAG, "plugin already exist in midasplugins test, plugin not exist! Name = " + str);
            return false;
        }
        try {
            if (APPluginUtils.checkFileMD5(file.getCanonicalPath(), str2)) {
                APLog.d(TAG, "plugin already exist in midasplugins test, plugin exist & md5 correct!");
                if (APPluginUtils.copyFile(file.getCanonicalPath(), str3, str)) {
                    APLog.d(TAG, "plugin already exist in midasplugins test, plugin exist & md5 correct & copy success!");
                    return true;
                }
                APLog.e(TAG, "plugin already exist in midasplugins test, plugin exist & md5 correct & copy fail!");
            } else {
                APLog.d(TAG, "plugin already exist in midasplugins test, plugin exist & md5 not correct!");
            }
        } catch (IOException e16) {
            e16.printStackTrace();
            APLog.d(TAG, "plugin already exist in midasplugins test error, exception = " + e16);
        }
        APLog.e(TAG, "plugin already exist in midasplugins test, final false!");
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        APLog.d(TAG, "About to enter critical region\uff01");
        synchronized (APMidasPluginDownloadWorker.class) {
            APLog.d(TAG, "Enter critical region\uff01");
            if (this.downListener == null) {
                APLog.e(TAG, "Cannot start plugin down worker, null downListener!");
                return;
            }
            ArrayList<APMidasPluginDownInfo> arrayList = this.downInfos;
            if (arrayList != null && !arrayList.isEmpty()) {
                if (this.context == null) {
                    APLog.e(TAG, "Cannot start plugin down worker, null context!");
                    this.downListener.onDownloadFail(-8);
                    return;
                }
                File file = this.saveDir;
                if (file == null) {
                    APLog.e(TAG, "Cannot start plugin down worker, null save dir!");
                    this.downListener.onDownloadFail(-6);
                    return;
                }
                if (!file.isDirectory()) {
                    APLog.e(TAG, "Cannot start plugin down worker, save dir not directory!");
                    this.downListener.onDownloadFail(-7);
                    return;
                }
                if (APMidasPluginDownloadUtils.checkIniFileExist(this.saveDir)) {
                    APLog.d(TAG, "MidasSign.ini already exists, no need to download again!");
                    this.downListener.onDownloadFail(-2);
                    return;
                }
                APLog.d(TAG, "MidasSign.ini not exists, start to download again!");
                APPluginUtils.clearDirContent(this.saveDir);
                if (!this.saveDir.exists() && !this.saveDir.mkdirs()) {
                    APLog.e(TAG, "Cannot start plugin down worker, save dir not exist and cannot create it!");
                    this.downListener.onDownloadFail(-3);
                    return;
                }
                Iterator<APMidasPluginDownInfo> it = this.downInfos.iterator();
                while (it.hasNext()) {
                    APMidasPluginDownInfo next = it.next();
                    if (!downloadSingleDownInfo(next)) {
                        this.downListener.onDownloadFail(-4);
                        APLog.d(TAG, "File name = " + next.name + " download fail, about to clear download dir!");
                        APPluginUtils.clearDirContent(this.saveDir);
                        return;
                    }
                }
                this.downListener.onDownloadSuccess();
                APLog.d(TAG, "About to leave critical region");
                APLog.d(TAG, "Leave critical region");
                return;
            }
            APLog.e(TAG, "Cannot start plugin down worker, empty down list!");
            this.downListener.onDownloadFail(-5);
        }
    }
}

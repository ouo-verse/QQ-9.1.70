package com.tencent.qqlive.tvkplayer.dex.sdkupdate;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.api.TVKSDKMgr;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKSDKUpdateHelper {
    private static final String CONFIG_NAME = "TVKMediaPlayerConfig.ser";
    private static final String DIRNAME = "TencentVideoKit";
    private static final String STORE_PATH = "/tencent/TencentVideoSdk/com.tencent.videokit";
    private static final String TAG = "TVKPlayer[TVKSDKUpdateHelper]";
    private static final String UPDATE_DIRNAME = "TencentVideoKitUpdate";
    private static final boolean isCheckRemoteFiles = false;
    private static final boolean isStoreRemoteFiles = false;
    private Context mContext;
    private TVKSDKLocalConfig mLocalSDKConfig;
    private String mStorePath;
    private int mErrorCode = 0;
    private File mSDKDir = null;
    private File mSDKUpdateDir = null;
    private File mSDKConfigFile = null;
    private File mSDKUpdateConfigFile = null;
    private File mRemoteSDKZIP = null;
    private File mSDKRemoteConfigFile = null;
    private boolean mIsFileExisted = false;
    private TVKSDKMgr.PluginInstallListener mSdkUpdateListener = null;

    public TVKSDKUpdateHelper(Context context) {
        this.mContext = context.getApplicationContext();
        this.mStorePath = this.mContext.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + STORE_PATH;
        TVKUpdateUtils.i(TAG, "new TVKSDKUpdateHelper, StorePath=" + this.mStorePath);
    }

    private int checkAndUnzipWithDownloadedFile(File file, TVKSDKLocalConfig tVKSDKLocalConfig, String str) {
        if (file == null || !file.exists()) {
            return 104;
        }
        if (!checkFileMD5(file, tVKSDKLocalConfig.md5)) {
            TVKUpdateUtils.e(TAG, "Unzip, file md5 error, : " + tVKSDKLocalConfig.md5);
            return 104;
        }
        if (!unzipFile(file.getAbsolutePath(), str)) {
            TVKUpdateUtils.e(TAG, "Unzip, file unzip error");
            return 104;
        }
        this.mIsFileExisted = true;
        File updateJarFile = getUpdateJarFile(str);
        if (updateJarFile == null) {
            TVKUpdateUtils.e(TAG, "getupdatejar error");
            return 104;
        }
        tVKSDKLocalConfig.jarMd5 = TVKUpdateUtils.checkMD5(updateJarFile);
        int unzipWithDownloadFile = unzipWithDownloadFile(file, tVKSDKLocalConfig, str);
        if (unzipWithDownloadFile != 0) {
            return unzipWithDownloadFile;
        }
        if (!file.delete()) {
            TVKUpdateUtils.w(TAG, "localSDKZIP.delete() err.");
            return 0;
        }
        return 0;
    }

    private boolean checkBuildVerMatch(TVKSDKLocalConfig tVKSDKLocalConfig) {
        if (!TVKSDKMgr.checkSdkPluginMode()) {
            return true;
        }
        String[] split = TVKSDKMgr.getSdkVersion().split("\\.");
        String[] split2 = tVKSDKLocalConfig.version.split("\\.");
        if (split != null && split2 != null && split.length > 3 && split2.length > 3) {
            if (Integer.valueOf(split2[3]).intValue() >= Integer.valueOf(split[3]).intValue()) {
                return true;
            }
            TVKUpdateUtils.e(TAG, "build version not match, sdk:" + TVKSDKMgr.getSdkVersion() + ", configver: " + tVKSDKLocalConfig.version);
            return false;
        }
        TVKUpdateUtils.e(TAG, "build version is invalid, sdk:" + TVKSDKMgr.getSdkVersion() + ", configver: " + tVKSDKLocalConfig.version);
        return false;
    }

    private boolean checkConfigInfo(File file) {
        TVKSDKLocalConfig tVKSDKLocalConfig = this.mLocalSDKConfig;
        if (tVKSDKLocalConfig != null && tVKSDKLocalConfig.md5 != null && tVKSDKLocalConfig.filename != null && tVKSDKLocalConfig.version != null && tVKSDKLocalConfig.jarMd5 != null) {
            return true;
        }
        TVKUpdateUtils.e(TAG, "checkFileAndConfig info error, : " + file);
        return false;
    }

    private boolean checkFileAndConfig(File file, File file2) {
        if (file == null || !file.exists() || file2 == null || !file2.exists()) {
            return false;
        }
        if (!readConfig(file2)) {
            TVKUpdateUtils.recursionDeleteFile(file);
            return false;
        }
        if (!checkConfigInfo(file)) {
            TVKUpdateUtils.recursionDeleteFile(file);
            return false;
        }
        if (!checkjarMd5(this.mLocalSDKConfig.jarMd5, file.getAbsolutePath())) {
            TVKUpdateUtils.recursionDeleteFile(file);
            return false;
        }
        if (!checkVerMatch(this.mLocalSDKConfig)) {
            TVKUpdateUtils.recursionDeleteFile(file);
            return false;
        }
        if (!checkBuildVerMatch(this.mLocalSDKConfig)) {
            TVKUpdateUtils.recursionDeleteFile(file);
            return false;
        }
        return true;
    }

    private boolean checkFileMD5(File file, String str) {
        return str.equalsIgnoreCase(TVKUpdateUtils.checkMD5(file));
    }

    private boolean checkLocalConfig(TVKSDKLocalConfig tVKSDKLocalConfig) {
        if (tVKSDKLocalConfig != null && tVKSDKLocalConfig.md5 != null && tVKSDKLocalConfig.filename != null && tVKSDKLocalConfig.version != null && tVKSDKLocalConfig.jarMd5 != null) {
            return true;
        }
        TVKUpdateUtils.e(TAG, "remotecofig info error");
        return false;
    }

    private boolean checkLocalFiles() {
        return checkFileAndConfig(this.mSDKDir, this.mSDKConfigFile);
    }

    private boolean checkRemoteFiles() {
        if (!copyRemoteFiles(this.mSDKDir.getAbsolutePath())) {
            deleteRemoteFiles();
            return false;
        }
        return checkFileAndConfig(this.mSDKDir, this.mSDKConfigFile);
    }

    private boolean checkSameVer(TVKSDKLocalConfig tVKSDKLocalConfig, TVKSDKLocalConfig tVKSDKLocalConfig2) {
        if (TextUtils.isEmpty(tVKSDKLocalConfig.version) || !tVKSDKLocalConfig.version.equalsIgnoreCase(tVKSDKLocalConfig2.version) || TextUtils.isEmpty(tVKSDKLocalConfig.md5) || !tVKSDKLocalConfig.md5.equalsIgnoreCase(tVKSDKLocalConfig2.md5)) {
            return false;
        }
        if (!copyRemoteFiles(this.mSDKUpdateDir.getAbsolutePath())) {
            TVKUpdateUtils.e(TAG, "copy failed");
            deleteRemoteFiles();
            return false;
        }
        return true;
    }

    private boolean checkUpdateLocalFiles() {
        if (!checkFileAndConfig(this.mSDKUpdateDir, this.mSDKUpdateConfigFile)) {
            return false;
        }
        TVKUpdateUtils.recursionDeleteFile(this.mSDKDir);
        if (!this.mSDKUpdateDir.renameTo(this.mSDKDir)) {
            TVKUpdateUtils.e(TAG, "renameTo failed");
            return false;
        }
        return true;
    }

    private boolean checkVerMatch(TVKSDKLocalConfig tVKSDKLocalConfig) {
        if (!TVKSDKMgr.checkSdkPluginMode()) {
            return true;
        }
        String[] split = TVKSDKMgr.getSdkVersion().split("\\.");
        String[] split2 = tVKSDKLocalConfig.version.split("\\.");
        if (split != null && split2 != null && split.length > 1 && split2.length > 1 && split[0].equalsIgnoreCase(split2[0]) && split[1].equalsIgnoreCase(split2[1])) {
            return true;
        }
        TVKUpdateUtils.e(TAG, "version not match, sdk:" + TVKSDKMgr.getSdkVersion() + ", configver: " + tVKSDKLocalConfig.version);
        return false;
    }

    private boolean checkjarMd5(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String checkMD5 = TVKUpdateUtils.checkMD5(getUpdateJarFile(str2));
            if (!TextUtils.isEmpty(checkMD5) && str.equalsIgnoreCase(checkMD5)) {
                return true;
            }
            TVKUpdateUtils.e(TAG, "checkjarMd5 failed, localMD5 = " + str + ", fileMd5: " + checkMD5);
            return false;
        }
        TVKUpdateUtils.e(TAG, "checkjarMd5 failed, empty,  md5: " + str + ", dirPath: " + str2);
        return false;
    }

    private void closeStreamAfterDownload(FileOutputStream fileOutputStream, InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e16) {
                TVKUpdateUtils.e(TAG, "InputStream close error" + e16.toString());
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e17) {
                TVKUpdateUtils.e(TAG, "outputStream close error" + e17.toString());
            }
        }
    }

    private boolean copyRemoteFiles(String str) {
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return false;
            }
            File file = new File(this.mStorePath, CONFIG_NAME);
            if (!file.exists()) {
                return false;
            }
            File file2 = new File(str, CONFIG_NAME);
            this.mSDKRemoteConfigFile = file2;
            if (!file2.getParentFile().mkdirs()) {
                TVKUpdateUtils.w(TAG, "mSDKRemoteConfigFile.getParentFile().mkdirs() err.");
            }
            if (!TVKUpdateUtils.copyFile(file, this.mSDKRemoteConfigFile)) {
                TVKUpdateUtils.e(TAG, "copyRemoteFiles, copy SDKConfig fail");
                return false;
            }
            File file3 = new File(this.mStorePath, "TvkPlugin.zip");
            if (!file3.exists()) {
                return false;
            }
            File file4 = new File(str, "TvkPlugin.zip");
            this.mRemoteSDKZIP = file4;
            if (!file4.getParentFile().mkdirs()) {
                TVKUpdateUtils.w(TAG, "copyRemoteFiles, mRemoteSDKZIP.getParentFile().mkdirs().");
            }
            if (!TVKUpdateUtils.copyFile(file3, this.mRemoteSDKZIP)) {
                TVKUpdateUtils.e(TAG, "copyRemoteFiles, copy SDKZip fail");
                return false;
            }
            if (!unzipFile(this.mRemoteSDKZIP.getAbsolutePath(), this.mRemoteSDKZIP.getParentFile().getAbsolutePath())) {
                TVKUpdateUtils.e(TAG, "copyRemoteFiles, file unzip error");
                return false;
            }
            return true;
        } catch (Exception e16) {
            TVKUpdateUtils.e(TAG, "copyRemoteFiles, exception: " + e16.toString());
            return false;
        }
    }

    private void deleteRemoteFiles() {
        try {
            File file = this.mSDKRemoteConfigFile;
            if (file != null && file.exists()) {
                if (!this.mSDKRemoteConfigFile.delete()) {
                    TVKUpdateUtils.w(TAG, "mSDKRemoteConfigFile.delete() err.");
                }
                this.mSDKRemoteConfigFile = null;
            }
        } catch (Throwable th5) {
            TVKUpdateUtils.i(TAG, "deleteRemoteFiles:" + th5.toString());
        }
        try {
            File file2 = this.mRemoteSDKZIP;
            if (file2 != null && file2.exists()) {
                if (!this.mRemoteSDKZIP.delete()) {
                    TVKUpdateUtils.w(TAG, "mRemoteSDKZIP.delete() err.");
                }
                this.mRemoteSDKZIP = null;
            }
        } catch (Throwable th6) {
            TVKUpdateUtils.i(TAG, "deleteRemoteFiles\uff1a" + th6.toString());
        }
    }

    private int downloadWithUrlAndPath(TVKSDKLocalConfig tVKSDKLocalConfig, String str) {
        int realDownload;
        int i3 = 3;
        int i16 = 0;
        while (true) {
            int i17 = i3 - 1;
            if (i3 >= 0) {
                if (i17 < 0) {
                    return i16;
                }
                if (!TVKUpdateUtils.isWifiConnected(this.mContext) && i17 < 2) {
                    TVKUpdateUtils.e(TAG, "download, not in wifi condition, no retry");
                    return 102;
                }
                TVKUpdateUtils.i(TAG, "download, retry time : " + (2 - i17));
                try {
                    try {
                        realDownload = realDownload(tVKSDKLocalConfig, str, null, null, 0);
                    } catch (Exception unused) {
                        this.mErrorCode = 102;
                        TVKUpdateUtils.e(TAG, "download error, retry");
                        closeStreamAfterDownload(null, null);
                        i3 = i17;
                        i16 = 102;
                    } catch (OutOfMemoryError unused2) {
                        this.mErrorCode = 102;
                        TVKUpdateUtils.e(TAG, "download error, retry");
                        closeStreamAfterDownload(null, null);
                        i3 = i17;
                        i16 = 102;
                    }
                    if (104 == this.mErrorCode) {
                        return 104;
                    }
                    if (realDownload == 0) {
                        return 0;
                    }
                    closeStreamAfterDownload(null, null);
                    i3 = i17;
                    i16 = realDownload;
                } finally {
                    closeStreamAfterDownload(null, null);
                }
            } else {
                return 101;
            }
        }
    }

    private String fetchResultWithURL(String str) {
        System.setProperty("http.keepAlive", "false");
        System.setProperty("http.maxConnections", "100");
        TVKUpdateUtils.i(TAG, "request url: " + str);
        int i3 = 3;
        while (true) {
            int i16 = i3 - 1;
            if (i3 > 0) {
                try {
                    String uRLResponse = getURLResponse(str, false);
                    if (TextUtils.isEmpty(uRLResponse)) {
                        getURLResponse(str, true);
                    }
                    TVKUpdateUtils.i(TAG, "fetchResultWithURL, result : " + uRLResponse);
                    if (!TextUtils.isEmpty(uRLResponse) && !TextUtils.isEmpty(uRLResponse.trim())) {
                        return uRLResponse;
                    }
                    i3 = i16;
                } catch (Exception unused) {
                    this.mErrorCode = 103;
                    return null;
                } catch (OutOfMemoryError unused2) {
                    this.mErrorCode = 103;
                    return null;
                }
            } else {
                this.mErrorCode = 103;
                return null;
            }
        }
    }

    private void fileInit() {
        this.mIsFileExisted = false;
        if (checkUpdateLocalFiles()) {
            this.mIsFileExisted = true;
        } else if (checkLocalFiles()) {
            this.mIsFileExisted = true;
        }
    }

    private String getFilePathByPrefix(File file, String str) {
        File[] listFiles;
        if (file != null && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.getName().length() >= str.length() && file2.getName().substring(0, str.length()).equalsIgnoreCase(str)) {
                    return file2.getAbsolutePath();
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x00ab, code lost:
    
        if (r6 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0083, code lost:
    
        if (r6 == null) goto L43;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getURLResponse(String str, boolean z16) {
        HttpURLConnection httpURLConnection;
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                if (!z16) {
                    try {
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setDoOutput(true);
                    } catch (MalformedURLException e16) {
                        e = e16;
                        TVKUpdateUtils.e(TAG, "getURLResponse, exception: " + e.toString());
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e17) {
                                TVKUpdateUtils.e(TAG, e17);
                            }
                        }
                    } catch (IOException e18) {
                        e = e18;
                        TVKUpdateUtils.e(TAG, "getURLResponse, ioexception: " + e.toString());
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e19) {
                                TVKUpdateUtils.e(TAG, e19);
                            }
                        }
                    }
                }
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("GET");
                inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                    stringBuffer.append("\n");
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e26) {
                        TVKUpdateUtils.e(TAG, e26);
                    }
                }
            } catch (MalformedURLException e27) {
                e = e27;
                httpURLConnection = null;
            } catch (IOException e28) {
                e = e28;
                httpURLConnection = null;
            } catch (Throwable th5) {
                th = th5;
                str = 0;
                if (0 != 0) {
                }
                if (str == 0) {
                }
            }
            httpURLConnection.disconnect();
            return stringBuffer.toString();
        } catch (Throwable th6) {
            th = th6;
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e29) {
                    TVKUpdateUtils.e(TAG, e29);
                }
            }
            if (str == 0) {
                str.disconnect();
                throw th;
            }
            throw th;
        }
    }

    private File getUpdateJarFile(String str) {
        File file;
        if (str.contains(UPDATE_DIRNAME)) {
            file = this.mSDKUpdateDir;
        } else {
            file = this.mSDKDir;
        }
        String filePathByPrefix = getFilePathByPrefix(file, "TVK_MediaPlayer");
        if (!TextUtils.isEmpty(filePathByPrefix)) {
            return new File(filePathByPrefix);
        }
        return null;
    }

    private String getUpdateURL(boolean z16) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("https://commdata.v.qq.com/commdatav2?cmd=51&so_name=TvkPlugin&so_ver=");
        if (z16) {
            str = this.mLocalSDKConfig.version;
        } else {
            str = TVKUpdateInfo.SDK_CORE_DEAFAULT_VERSION;
        }
        sb5.append(str);
        sb5.append("&app_id=");
        sb5.append(TVKUpdateInfo.APP_ID);
        sb5.append("&sdk_version=");
        sb5.append(TVKUpdateInfo.SDK_WRAPPER_VERSION);
        return sb5.toString();
    }

    private void onProgress(float f16) {
        TVKSDKMgr.PluginInstallListener pluginInstallListener = this.mSdkUpdateListener;
        if (pluginInstallListener != null) {
            pluginInstallListener.onInstallProgress(f16);
        }
    }

    private TVKSDKLocalConfig parseJsonData(String str) {
        try {
            if (str.startsWith("QZOutputJson=")) {
                str = str.replace("QZOutputJson=", "");
            }
            JSONObject jSONObject = new JSONObject(str);
            if ("no record".equals(jSONObject.optString("error_msg"))) {
                this.mErrorCode = 103;
                return null;
            }
            String optString = jSONObject.optString("c_so_url");
            String optString2 = jSONObject.optString("c_so_name");
            String optString3 = jSONObject.optString("c_so_update_ver");
            String optString4 = jSONObject.optString("c_so_md5");
            String optString5 = jSONObject.optString("ret");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                TVKSDKLocalConfig tVKSDKLocalConfig = new TVKSDKLocalConfig();
                tVKSDKLocalConfig.filename = optString2;
                tVKSDKLocalConfig.version = optString3;
                tVKSDKLocalConfig.md5 = optString4;
                tVKSDKLocalConfig.url = optString;
                return tVKSDKLocalConfig;
            }
            this.mErrorCode = 103;
            return null;
        } catch (Exception unused) {
            this.mErrorCode = 103;
            return null;
        }
    }

    private boolean readConfig(File file) {
        ObjectInputStream objectInputStream = null;
        try {
            try {
                ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream(file));
                try {
                    this.mLocalSDKConfig = (TVKSDKLocalConfig) objectInputStream2.readObject();
                    try {
                        objectInputStream2.close();
                        return true;
                    } catch (Exception e16) {
                        TVKUpdateUtils.w(TAG, "checkFileAndConfig err." + e16.toString());
                        return true;
                    }
                } catch (Exception e17) {
                    e = e17;
                    objectInputStream = objectInputStream2;
                    TVKUpdateUtils.e(TAG, "read config failed: " + e.toString());
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                            return false;
                        } catch (Exception e18) {
                            TVKUpdateUtils.w(TAG, "checkFileAndConfig err." + e18.toString());
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    objectInputStream = objectInputStream2;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Exception e19) {
                            TVKUpdateUtils.w(TAG, "checkFileAndConfig err." + e19.toString());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e26) {
            e = e26;
        }
    }

    private int realDownload(TVKSDKLocalConfig tVKSDKLocalConfig, String str, FileOutputStream fileOutputStream, InputStream inputStream, int i3) throws Exception, OutOfMemoryError {
        TVKUpdateUtils.recursionDeleteFile(new File(str));
        File file = new File(str, "TvkPlugin.zip");
        if (!file.getParentFile().mkdirs()) {
            TVKUpdateUtils.w(TAG, "downloadWithUrlAndPath, localSDKZIP.getParentFile().mkdirs()");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(tVKSDKLocalConfig.url).openConnection();
        if (httpURLConnection == null) {
            TVKUpdateUtils.e(TAG, "download, connection null");
            return 102;
        }
        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode > 300) {
            TVKUpdateUtils.e(TAG, "download, response code error: " + responseCode);
            return 103;
        }
        long parseInt = Integer.parseInt(httpURLConnection.getHeaderField("Content-Length"));
        long j3 = 0;
        if (parseInt == 0) {
            TVKUpdateUtils.e(TAG, "download, length error");
            return 104;
        }
        InputStream inputStream2 = httpURLConnection.getInputStream();
        if (inputStream2 == null) {
            TVKUpdateUtils.e(TAG, "download, input stream null");
            return 104;
        }
        int i16 = 8192;
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream2.read(bArr, 0, i16);
            if (read <= -1) {
                break;
            }
            fileOutputStream2.write(bArr, 0, read);
            long j16 = j3 + read;
            onProgress((float) (j16 / parseInt));
            j3 = j16;
            i16 = 8192;
        }
        fileOutputStream2.flush();
        fileOutputStream2.close();
        httpURLConnection.disconnect();
        TVKUpdateUtils.i(TAG, "download done, size : " + parseInt);
        int checkAndUnzipWithDownloadedFile = checkAndUnzipWithDownloadedFile(file, tVKSDKLocalConfig, str);
        this.mErrorCode = checkAndUnzipWithDownloadedFile;
        if (checkAndUnzipWithDownloadedFile == 0) {
            return 0;
        }
        TVKUpdateUtils.e(TAG, "download error");
        if (104 == this.mErrorCode) {
            return 104;
        }
        return 102;
    }

    private void storeSDKFilesRemote(File file, File file2) {
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return;
            }
            File file3 = new File(this.mStorePath, CONFIG_NAME);
            if (!file3.getParentFile().mkdirs()) {
                TVKUpdateUtils.w(TAG, "storeSDKFilesRemote, destConfigFile.getParentFile().mkdirs() err.");
            }
            if (file3.exists() && !file3.delete()) {
                TVKUpdateUtils.w(TAG, "storeSDKFilesRemote, destConfigFile.delete() err.");
            }
            if (!TVKUpdateUtils.copyFile(file, file3)) {
                TVKUpdateUtils.e(TAG, "shareSDKFiles, Config copy error");
                if (!file3.delete()) {
                    TVKUpdateUtils.w(TAG, "storeSDKFilesRemote, destConfigFile.delete() err.");
                    return;
                }
                return;
            }
            TVKUpdateUtils.i(TAG, "shareSDKFiles, Config copy done");
            storeSDKZipFileRemote(file3, file2);
        } catch (Exception e16) {
            TVKUpdateUtils.e(TAG, "shareSDKFiles, Exception " + e16.toString());
        }
    }

    private void storeSDKZipFileRemote(File file, File file2) {
        File file3 = new File(this.mStorePath, "TvkPlugin.zip");
        if (!file3.getParentFile().mkdirs()) {
            TVKUpdateUtils.w(TAG, "storeSDKFilesRemote, destZipFile.getParentFile().mkdirs() err.");
        }
        if (file3.exists() && !file3.delete()) {
            TVKUpdateUtils.w(TAG, "storeSDKFilesRemote, destZipFile.delete() err.");
        }
        if (!TVKUpdateUtils.copyFile(file2, file3)) {
            TVKUpdateUtils.e(TAG, "shareSDKFiles, ZIP copy error");
            if (!file.delete()) {
                TVKUpdateUtils.w(TAG, "storeSDKFilesRemote, destConfigFile.delete() err.");
            }
            if (!file3.delete()) {
                TVKUpdateUtils.w(TAG, "storeSDKFilesRemote, destZipFile.delete() err.");
                return;
            }
            return;
        }
        TVKUpdateUtils.i(TAG, "shareSDKFiles, ZIP copy done");
    }

    private boolean unzipFile(String str, String str2) {
        try {
            TVKUpdateUtils.unZipFolder(str, str2);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int unzipWithDownloadFile(File file, TVKSDKLocalConfig tVKSDKLocalConfig, String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        FileOutputStream fileOutputStream;
        String str2;
        FileOutputStream fileOutputStream2 = null;
        r1 = null;
        r1 = null;
        fileOutputStream2 = null;
        r1 = null;
        fileOutputStream2 = null;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(4096);
                try {
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                } catch (IOException e16) {
                    e = e16;
                    fileOutputStream = 0;
                } catch (Throwable th5) {
                    th = th5;
                    objectOutputStream = null;
                }
            } catch (IOException e17) {
                e = e17;
                fileOutputStream = 0;
                byteArrayOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                byteArrayOutputStream = null;
                objectOutputStream = null;
            }
            try {
                objectOutputStream.writeObject(tVKSDKLocalConfig);
                objectOutputStream.flush();
                objectOutputStream.close();
                fileOutputStream = new FileOutputStream(new File(str, CONFIG_NAME));
                try {
                    byteArrayOutputStream.writeTo(fileOutputStream);
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    try {
                        fileOutputStream.close();
                        TVKUpdateUtils.i(TAG, "Unzip, save version: " + tVKSDKLocalConfig.version + ", jarmd5: " + tVKSDKLocalConfig.jarMd5);
                        return 0;
                    } catch (IOException e18) {
                        e = e18;
                        byteArrayOutputStream = null;
                        TVKUpdateUtils.e(TAG, "unzip, config write error:" + e.toString());
                        if (!file.delete()) {
                            TVKUpdateUtils.w(TAG, "localSDKZIP.delete() err.");
                        }
                        if (fileOutputStream != 0) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e19) {
                                TVKUpdateUtils.e(TAG, e19);
                            }
                        }
                        if (objectOutputStream2 != null) {
                            try {
                                objectOutputStream2.close();
                            } catch (IOException e26) {
                                TVKUpdateUtils.e(TAG, e26);
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                                return 105;
                            } catch (IOException e27) {
                                TVKUpdateUtils.e(TAG, e27);
                                return 105;
                            }
                        }
                        return 105;
                    } catch (Throwable th7) {
                        th = th7;
                        byteArrayOutputStream = null;
                        objectOutputStream = null;
                        str2 = fileOutputStream;
                        fileOutputStream2 = str2;
                        if (fileOutputStream2 != null) {
                        }
                        if (objectOutputStream != null) {
                        }
                        if (byteArrayOutputStream == null) {
                        }
                    }
                } catch (IOException e28) {
                    e = e28;
                }
            } catch (IOException e29) {
                e = e29;
                fileOutputStream = 0;
                objectOutputStream2 = objectOutputStream;
            } catch (Throwable th8) {
                th = th8;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e36) {
                        TVKUpdateUtils.e(TAG, e36);
                    }
                }
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e37) {
                        TVKUpdateUtils.e(TAG, e37);
                    }
                }
                if (byteArrayOutputStream == null) {
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (IOException e38) {
                        TVKUpdateUtils.e(TAG, e38);
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Throwable th9) {
            th = th9;
            objectOutputStream = null;
            str2 = str;
        }
    }

    public void downloadWithIsUpdate(TVKSDKLocalConfig tVKSDKLocalConfig, boolean z16) {
        File file;
        if (z16) {
            file = this.mSDKUpdateDir;
        } else {
            file = this.mSDKDir;
        }
        int downloadWithUrlAndPath = downloadWithUrlAndPath(tVKSDKLocalConfig, file.getAbsolutePath());
        this.mErrorCode = downloadWithUrlAndPath;
        if (downloadWithUrlAndPath == 0 && !z16) {
            this.mLocalSDKConfig = tVKSDKLocalConfig;
        }
    }

    public String getJar() {
        if (this.mIsFileExisted) {
            return getFilePathByPrefix(this.mSDKDir, "TVK_MediaPlayer");
        }
        return null;
    }

    public String getLibs() {
        if (this.mIsFileExisted) {
            return getFilePathByPrefix(this.mSDKDir, "armeabi");
        }
        return null;
    }

    public TVKSDKLocalConfig getUpdateInfoWithIsUpdate(boolean z16) {
        String fetchResultWithURL = fetchResultWithURL(getUpdateURL(z16));
        if (fetchResultWithURL == null) {
            this.mErrorCode = 103;
            return null;
        }
        TVKSDKLocalConfig parseJsonData = parseJsonData(fetchResultWithURL);
        if (parseJsonData != null && !checkVerMatch(parseJsonData) && !checkBuildVerMatch(parseJsonData)) {
            this.mErrorCode = 103;
            return null;
        }
        return parseJsonData;
    }

    public boolean helperInit() {
        String str;
        try {
            if (this.mContext.getFilesDir().exists() && this.mContext.getFilesDir().canRead() && this.mContext.getFilesDir().canWrite()) {
                str = this.mContext.getFilesDir().getAbsolutePath();
            } else if (Environment.getExternalStorageState().equals("mounted") && this.mContext.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) != null) {
                str = this.mContext.getFilesDir().getAbsolutePath();
            } else {
                str = null;
            }
            if (str != null) {
                this.mSDKDir = new File(str, DIRNAME);
                this.mSDKUpdateDir = new File(str, UPDATE_DIRNAME);
                this.mSDKConfigFile = new File(this.mSDKDir.getAbsolutePath(), CONFIG_NAME);
                this.mSDKUpdateConfigFile = new File(this.mSDKUpdateDir.getAbsolutePath(), CONFIG_NAME);
                fileInit();
                return true;
            }
            this.mErrorCode = 105;
            TVKUpdateUtils.e(TAG, "helperInit failed, dir error");
            return false;
        } catch (Exception e16) {
            this.mErrorCode = 105;
            TVKUpdateUtils.e(TAG, "helperInit failed, " + e16.toString());
            return false;
        }
    }

    public boolean isFileExisted() {
        return this.mIsFileExisted;
    }

    public boolean isSameVersion(TVKSDKLocalConfig tVKSDKLocalConfig) {
        TVKSDKLocalConfig tVKSDKLocalConfig2;
        if (tVKSDKLocalConfig != null && !TextUtils.isEmpty(tVKSDKLocalConfig.version) && (tVKSDKLocalConfig2 = this.mLocalSDKConfig) != null && tVKSDKLocalConfig.version.equals(tVKSDKLocalConfig2.version)) {
            return true;
        }
        return false;
    }

    public boolean isSameVersionForRemoteAndCopy(TVKSDKLocalConfig tVKSDKLocalConfig) {
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return false;
            }
            File file = new File(this.mStorePath, CONFIG_NAME);
            if (!file.exists()) {
                TVKUpdateUtils.w(TAG, "isSameVersionForRemoteAndCopy, no SDKConfig in SD card: " + file.getAbsolutePath());
                return false;
            }
            File file2 = new File(this.mStorePath, "TvkPlugin.zip");
            if (!file2.exists()) {
                TVKUpdateUtils.w(TAG, "isSameVersionForRemoteAndCopy, no SDKZip in SD card: " + file2.getAbsolutePath());
                return false;
            }
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            try {
                TVKSDKLocalConfig tVKSDKLocalConfig2 = (TVKSDKLocalConfig) objectInputStream.readObject();
                objectInputStream.close();
                if (!checkLocalConfig(tVKSDKLocalConfig2)) {
                    return false;
                }
                String checkMD5 = TVKUpdateUtils.checkMD5(file2);
                if (!TextUtils.isEmpty(checkMD5) && checkMD5.equalsIgnoreCase(tVKSDKLocalConfig2.md5)) {
                    TVKUpdateUtils.i(TAG, "compare, ver: " + tVKSDKLocalConfig2.version + ", md5: " + tVKSDKLocalConfig2.md5);
                    return checkSameVer(tVKSDKLocalConfig2, tVKSDKLocalConfig);
                }
                TVKUpdateUtils.e(TAG, "md5 not match, localMD5 = " + tVKSDKLocalConfig2.md5 + ", fileMd5: " + checkMD5);
                TVKUpdateUtils.recursionDeleteFile(file);
                TVKUpdateUtils.recursionDeleteFile(file2);
                return false;
            } catch (Exception unused) {
                objectInputStream.close();
                return false;
            }
        } catch (Exception e16) {
            TVKUpdateUtils.e(TAG, "read config failed: " + e16.toString());
            return false;
        }
    }

    public void onFinished() {
        TVKSDKMgr.PluginInstallListener pluginInstallListener = this.mSdkUpdateListener;
        if (pluginInstallListener == null) {
            return;
        }
        int i3 = this.mErrorCode;
        if (i3 == 0) {
            pluginInstallListener.onInstallSuccess();
        } else {
            pluginInstallListener.onInstallFailure(i3);
        }
    }

    public void setOnSDKUpdateListener(TVKSDKMgr.PluginInstallListener pluginInstallListener) {
        this.mSdkUpdateListener = pluginInstallListener;
    }
}

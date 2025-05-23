package com.tencent.ttpic.openapi.offlineset.utils;

import com.tencent.aekit.api.standard.AEModule;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FileOfflineUtil {
    private static final String DIR_NAME = "offlinepkg";
    private static final String OFFELINE_DIR;
    private static final String TAG = "FileOfflineUtil";
    private static String sCachePath;

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("tencent");
        String str = File.separator;
        sb5.append(str);
        sb5.append("com.tencent.ttpic");
        sb5.append(str);
        sb5.append(DIR_NAME);
        OFFELINE_DIR = sb5.toString();
    }

    private static void checkFileExit(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static String getCacheFilePath() {
        if (sCachePath != null) {
            File file = new File(sCachePath);
            if (file.exists()) {
                return file.getAbsolutePath() + File.separator + DIR_NAME;
            }
            return null;
        }
        return null;
    }

    public static String getOfflineDirPath() {
        String cacheFilePath = getCacheFilePath();
        if (cacheFilePath == null) {
            cacheFilePath = getSDCardPath();
        }
        checkFileExit(cacheFilePath);
        LogUtils.i("Offline", "getOffPath:" + cacheFilePath);
        return cacheFilePath;
    }

    public static String getSDCardPath() {
        try {
            return AEModule.getContext().getExternalFilesDir(null).getAbsolutePath() + File.separator + OFFELINE_DIR;
        } catch (Exception e16) {
            e16.printStackTrace();
            return PreDownloadConstants.SDCRAD_DEFAULT + File.separator + OFFELINE_DIR;
        }
    }

    public static String getStringFromStream(InputStream inputStream) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb5 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb5.append(readLine);
                } else {
                    bufferedReader.close();
                    inputStreamReader.close();
                    return sb5.toString();
                }
            }
        } catch (FileNotFoundException unused) {
            LogUtils.e(TAG, "FileNotFoundException");
            return null;
        } catch (UnsupportedEncodingException unused2) {
            LogUtils.e(TAG, "UnsupportedEncodingException");
            return null;
        } catch (IOException unused3) {
            LogUtils.e(TAG, "IOException");
            return null;
        }
    }

    public static String readJsonStringFromFile(String str) {
        File file = new File(str);
        if (!file.exists()) {
            LogUtils.e(TAG, "file not exit:" + str);
            return null;
        }
        try {
            return getStringFromStream(new FileInputStream(file));
        } catch (FileNotFoundException unused) {
            LogUtils.e(TAG, "FileNotFoundException");
            return null;
        }
    }

    public static String readStringFromAssets(String str) {
        try {
            return getStringFromStream(AEModule.getContext().getAssets().open(str));
        } catch (FileNotFoundException unused) {
            LogUtils.e(TAG, "getStringFromAssets|FileNotFoundException");
            return null;
        } catch (IOException unused2) {
            LogUtils.e(TAG, "getStringFromAssets|IOException");
            return null;
        } catch (Exception e16) {
            LogUtils.e(TAG, "getStringFromAssets|Exception:" + e16.getMessage());
            return null;
        }
    }

    public static void setCachePath(String str) {
        LogUtils.i("Offline", "cachePath:" + str);
        sCachePath = str;
    }
}

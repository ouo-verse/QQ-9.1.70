package org.light.device;

import android.content.Context;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
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

    public static String getOfflineDirPath(Context context) {
        String cacheFilePath = getCacheFilePath();
        if (cacheFilePath == null) {
            cacheFilePath = getSDCardPath(context);
        }
        checkFileExit(cacheFilePath);
        LightLogUtil.i("Offline", "getOffPath:" + cacheFilePath);
        return cacheFilePath;
    }

    public static String getSDCardPath(Context context) {
        try {
            return context.getExternalFilesDir(null).getAbsolutePath() + File.separator + OFFELINE_DIR;
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
            LightLogUtil.e(TAG, "FileNotFoundException");
            return null;
        } catch (UnsupportedEncodingException unused2) {
            LightLogUtil.e(TAG, "UnsupportedEncodingException");
            return null;
        } catch (IOException unused3) {
            LightLogUtil.e(TAG, "IOException");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readJsonStringFromFile(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        ?? r26 = 0;
        try {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    return "";
                }
                fileInputStream2 = new FileInputStream(file);
                try {
                    String stringFromStream = getStringFromStream(fileInputStream2);
                    try {
                        fileInputStream2.close();
                    } catch (IOException e16) {
                        LightLogUtil.e(TAG, "readStringFromAssetsPath|IO close Exception:" + e16.getMessage());
                    }
                    return stringFromStream;
                } catch (FileNotFoundException unused) {
                    LightLogUtil.e(TAG, "readStringFromAssetsPath|FileNotFoundException");
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e17) {
                            LightLogUtil.e(TAG, "readStringFromAssetsPath|IO close Exception:" + e17.getMessage());
                        }
                    }
                    return null;
                } catch (Exception e18) {
                    fileInputStream = fileInputStream2;
                    e = e18;
                    try {
                        LightLogUtil.e(TAG, "readStringFromAssetsPath|Exception:" + e.getMessage());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e19) {
                                LightLogUtil.e(TAG, "readStringFromAssetsPath|IO close Exception:" + e19.getMessage());
                            }
                        }
                        return null;
                    } catch (Throwable th5) {
                        th = th5;
                        r26 = fileInputStream;
                        if (r26 != 0) {
                        }
                        throw th;
                    }
                }
            } catch (FileNotFoundException unused2) {
                fileInputStream2 = null;
            } catch (Exception e26) {
                e = e26;
                fileInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                if (r26 != 0) {
                }
                throw th;
            }
        } catch (Throwable th7) {
            r26 = str;
            th = th7;
            if (r26 != 0) {
                try {
                    r26.close();
                } catch (IOException e27) {
                    LightLogUtil.e(TAG, "readStringFromAssetsPath|IO close Exception:" + e27.getMessage());
                }
            }
            throw th;
        }
    }

    public static String readStringFromAssets(Context context, String str) {
        try {
            return getStringFromStream(context.getAssets().open(str));
        } catch (FileNotFoundException unused) {
            LightLogUtil.e(TAG, "getStringFromAssets|FileNotFoundException");
            return null;
        } catch (IOException unused2) {
            LightLogUtil.e(TAG, "getStringFromAssets|IOException");
            return null;
        } catch (Exception e16) {
            LightLogUtil.e(TAG, "getStringFromAssets|Exception:" + e16.getMessage());
            return null;
        }
    }

    public static void setCachePath(String str) {
        LightLogUtil.i("Offline", "cachePath:" + str);
        sCachePath = str;
    }
}

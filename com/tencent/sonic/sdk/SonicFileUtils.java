package com.tencent.sonic.sdk;

import android.text.TextUtils;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.sonic.sdk.SonicDataHelper;
import com.tencent.sonic.sdk.SonicResourceDataHelper;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SonicFileUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String DATA_EXT = ".data";
    private static final String HEADER_EXT = ".header";
    private static final String HTML_EXT = ".html";
    private static final String TAG = "SonicSdk_SonicFileUtils";
    private static final String TEMPLATE_EXT = ".tpl";
    private static final double THRESHOLD_OF_CACHE_MAX_PERCENT = 0.8d;
    private static final double THRESHOLD_OF_CACHE_MIN_PERCENT = 0.25d;

    public SonicFileUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static long calcCacheSize(String str, Map<String, List<String>> map) {
        File[] listFiles;
        File file = new File(str);
        long j3 = 0;
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                j3 += file2.length();
                String name = file2.getName();
                List<String> list = map.get(name);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(file2.getAbsolutePath());
                map.put(name, list);
            }
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkAndTrimCache() {
        HashMap hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis();
        long calcCacheSize = calcCacheSize(getSonicCacheDirPath(), hashMap);
        double d16 = calcCacheSize;
        double d17 = SonicEngine.getInstance().getConfig().SONIC_CACHE_MAX_SIZE;
        if (d16 > THRESHOLD_OF_CACHE_MAX_PERCENT * d17) {
            SonicUtils.log(TAG, 4, "now try clear cache, current cache size: " + ((calcCacheSize / 1024) / 1024) + QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO);
            List<SonicDataHelper.SessionData> allSessionByHitCount = SonicDataHelper.getAllSessionByHitCount();
            for (int i3 = 0; i3 < allSessionByHitCount.size(); i3++) {
                List list = (List) hashMap.get(allSessionByHitCount.get(i3).sessionId);
                if (list != null && list.size() > 0) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        File file = new File((String) it.next());
                        if (file.isFile() && file.exists()) {
                            String name = file.getName();
                            long length = file.length();
                            if (file.delete()) {
                                calcCacheSize -= length;
                                SonicDataHelper.removeSessionData(name);
                                SonicChunkDataHelper.removeChunkData(name);
                                SonicUtils.log(TAG, 4, "delete " + file.getAbsolutePath());
                            }
                        }
                    }
                }
                if (calcCacheSize <= THRESHOLD_OF_CACHE_MIN_PERCENT * d17) {
                    break;
                }
            }
            SonicUtils.log(TAG, 4, "checkAndTrimCache: finish , cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkAndTrimResourceCache() {
        HashMap hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis();
        long calcCacheSize = calcCacheSize(getSonicResourceCachePath(), hashMap);
        double d16 = calcCacheSize;
        double d17 = SonicEngine.getInstance().getConfig().SONIC_RESOURCE_CACHE_MAX_SIZE;
        if (d16 > THRESHOLD_OF_CACHE_MAX_PERCENT * d17) {
            SonicUtils.log(TAG, 4, "now try clear cache, current cache size: " + ((calcCacheSize / 1024) / 1024) + QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO);
            List<SonicResourceDataHelper.ResourceData> allResourceData = SonicResourceDataHelper.getAllResourceData();
            for (int i3 = 0; i3 < allResourceData.size(); i3++) {
                List list = (List) hashMap.get(allResourceData.get(i3).resourceId);
                if (list != null && list.size() > 0) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        File file = new File((String) it.next());
                        if (file.isFile() && file.exists()) {
                            String name = file.getName();
                            long length = file.length();
                            if (file.delete()) {
                                calcCacheSize -= length;
                                SonicResourceDataHelper.removeResourceData(name);
                                SonicUtils.log(TAG, 4, "delete " + file.getAbsolutePath());
                            }
                        }
                    }
                }
                if (calcCacheSize <= THRESHOLD_OF_CACHE_MIN_PERCENT * d17) {
                    break;
                }
            }
            SonicUtils.log(TAG, 4, "checkAndTrimCache: finish , cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String convertHeadersToString(Map<String, List<String>> map) {
        if (map != null && map.size() > 0) {
            StringBuilder sb5 = new StringBuilder();
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    for (String str : entry.getValue()) {
                        if (!TextUtils.isEmpty(str)) {
                            sb5.append(key);
                            sb5.append(ProgressTracer.SEPARATOR);
                            sb5.append(str);
                            sb5.append("\r\n");
                        }
                    }
                }
            }
            return sb5.toString();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean deleteAllChildFiles(File file) {
        File[] listFiles;
        boolean z16 = true;
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return true;
        }
        for (File file2 : listFiles) {
            z16 &= deleteAllChildFiles(file2);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean deleteResourceFiles(String str) {
        boolean z16;
        File file = new File(getSonicResourcePath(str));
        if (file.exists()) {
            z16 = file.delete();
        } else {
            z16 = true;
        }
        File file2 = new File(getSonicHeaderPath(str));
        if (file2.exists()) {
            return z16 & file2.delete();
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean deleteSonicFiles(String str) {
        boolean z16;
        File file = new File(getSonicHtmlPath(str));
        if (file.exists()) {
            z16 = file.delete();
        } else {
            z16 = true;
        }
        File file2 = new File(getSonicTemplatePath(str));
        if (file2.exists()) {
            z16 &= file2.delete();
        }
        File file3 = new File(getSonicDataPath(str));
        if (file3.exists()) {
            z16 &= file3.delete();
        }
        File file4 = new File(getSonicHeaderPath(str));
        if (file4.exists()) {
            return z16 & file4.delete();
        }
        return z16;
    }

    public static Map<String, List<String>> getHeaderFromLocalCache(String str) {
        HashMap hashMap = new HashMap();
        File file = new File(str);
        if (file.exists()) {
            String readFile = readFile(file);
            if (!TextUtils.isEmpty(readFile)) {
                String[] split = readFile.split("\r\n");
                if (split.length > 0) {
                    for (String str2 : split) {
                        String[] split2 = str2.split(ProgressTracer.SEPARATOR);
                        if (split2.length == 2) {
                            String trim = split2[0].trim();
                            List list = (List) hashMap.get(trim.toLowerCase());
                            if (list == null) {
                                list = new ArrayList(1);
                                hashMap.put(trim.toLowerCase(), list);
                            }
                            list.add(split2[1].trim());
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getSonicCacheDirPath() {
        String absolutePath = SonicEngine.getInstance().getRuntime().getSonicCacheDir().getAbsolutePath();
        String str = File.separator;
        if (!absolutePath.endsWith(str)) {
            return absolutePath + str;
        }
        return absolutePath;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getSonicDataPath(String str) {
        return getSonicCacheDirPath() + str + DATA_EXT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getSonicHeaderPath(String str) {
        return getSonicCacheDirPath() + str + HEADER_EXT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getSonicHtmlPath(String str) {
        return getSonicCacheDirPath() + str + HTML_EXT;
    }

    static String getSonicResourceCachePath() {
        String absolutePath = SonicEngine.getInstance().getRuntime().getSonicResourceCacheDir().getAbsolutePath();
        String str = File.separator;
        if (!absolutePath.endsWith(str)) {
            return absolutePath + str;
        }
        return absolutePath;
    }

    public static String getSonicResourceHeaderPath(String str) {
        return getSonicResourceCachePath() + str + HEADER_EXT;
    }

    public static String getSonicResourcePath(String str) {
        return getSonicResourceCachePath() + str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getSonicTemplatePath(String str) {
        return getSonicCacheDirPath() + str + TEMPLATE_EXT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String readFile(File file) {
        BufferedInputStream bufferedInputStream;
        InputStreamReader inputStreamReader;
        StringBuilder sb5;
        String str = null;
        if (file == null || !file.exists() || !file.canRead()) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
            } catch (Throwable th5) {
                th = th5;
                inputStreamReader = null;
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream = null;
            inputStreamReader = null;
        }
        try {
            int length = (int) file.length();
            if (length > 12288) {
                char[] cArr = new char[4096];
                StringBuilder sb6 = new StringBuilder(12288);
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (-1 == read) {
                        break;
                    }
                    sb6.append(cArr, 0, read);
                }
                str = sb6.toString();
            } else {
                char[] cArr2 = new char[length];
                str = new String(cArr2, 0, inputStreamReader.read(cArr2));
            }
            try {
                bufferedInputStream.close();
            } catch (Exception e16) {
                SonicUtils.log(TAG, 6, "readFile close error:(" + file.getName() + ") " + e16.getMessage());
            }
            try {
                inputStreamReader.close();
            } catch (Exception e17) {
                e = e17;
                sb5 = new StringBuilder();
                sb5.append("readFile close error:(");
                sb5.append(file.getName());
                sb5.append(") ");
                sb5.append(e.getMessage());
                SonicUtils.log(TAG, 6, sb5.toString());
                return str;
            }
        } catch (Throwable th7) {
            th = th7;
            try {
                SonicUtils.log(TAG, 6, "readFile error:(" + file.getName() + ") " + th.getMessage());
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e18) {
                        SonicUtils.log(TAG, 6, "readFile close error:(" + file.getName() + ") " + e18.getMessage());
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (Exception e19) {
                        e = e19;
                        sb5 = new StringBuilder();
                        sb5.append("readFile close error:(");
                        sb5.append(file.getName());
                        sb5.append(") ");
                        sb5.append(e.getMessage());
                        SonicUtils.log(TAG, 6, sb5.toString());
                        return str;
                    }
                }
                return str;
            } finally {
            }
        }
        return str;
    }

    public static byte[] readFileToBytes(File file) {
        byte[] bArr;
        BufferedInputStream bufferedInputStream;
        byte[] bArr2;
        BufferedInputStream bufferedInputStream2 = null;
        if (file == null || !file.exists() || !file.canRead()) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        } catch (Throwable th5) {
            th = th5;
            bArr = null;
        }
        try {
            int length = (int) file.length();
            if (length > 12288) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr3 = new byte[4096];
                while (true) {
                    int read = bufferedInputStream.read(bArr3);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr3, 0, read);
                }
                bArr2 = byteArrayOutputStream.toByteArray();
            } else {
                bArr2 = new byte[length];
                bufferedInputStream.read(bArr2);
            }
            try {
                bufferedInputStream.close();
                return bArr2;
            } catch (Exception e16) {
                SonicUtils.log(TAG, 6, "readFile close error:(" + file.getName() + ") " + e16.getMessage());
                return bArr2;
            }
        } catch (Throwable th6) {
            th = th6;
            bArr = null;
            bufferedInputStream2 = bufferedInputStream;
            try {
                SonicUtils.log(TAG, 6, "readFile error:(" + file.getName() + ") " + th.getMessage());
                return bArr;
            } finally {
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e17) {
                        SonicUtils.log(TAG, 6, "readFile close error:(" + file.getName() + ") " + e17.getMessage());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean verifyData(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str2.equals(SonicUtils.getSHA1(str))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean writeFile(String str, String str2) {
        return writeFile(str.getBytes(), str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean writeFile(byte[] bArr, String str) {
        File file = new File(str);
        FileOutputStream fileOutputStream = null;
        try {
            if (!file.exists() && !file.createNewFile()) {
                return false;
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                try {
                    fileOutputStream2.close();
                    return true;
                } catch (Throwable th5) {
                    SonicUtils.log(TAG, 6, "writeFile close error:(" + str + ") " + th5.getMessage());
                    return true;
                }
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = fileOutputStream2;
                try {
                    SonicUtils.log(TAG, 6, "writeFile error:(" + str + ") " + th.getMessage());
                    return false;
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th7) {
                            SonicUtils.log(TAG, 6, "writeFile close error:(" + str + ") " + th7.getMessage());
                        }
                    }
                }
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public static boolean verifyData(byte[] bArr, String str) {
        return (bArr == null || TextUtils.isEmpty(str) || !str.equals(SonicUtils.getSHA1(bArr))) ? false : true;
    }
}

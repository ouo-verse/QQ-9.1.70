package com.tencent.pts.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/* loaded from: classes22.dex */
public final class PTSFileUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String FRAME_TREE_FORMAT = ".frametree";
    public static final String JS_FORMAT = ".js";
    public static final String TAG = "PTSFileUtil";
    private static HashMap<String, String> sFileContentMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41920);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sFileContentMap = new HashMap<>();
        }
    }

    PTSFileUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void clearCache() {
        PTSLog.i(TAG, "[clearCache]");
        sFileContentMap.clear();
    }

    public static String getFileContent(String str, Context context, boolean z16) {
        if (PTSLog.isColorLevel() || PTSLog.isDebug()) {
            PTSLog.i(TAG, "[getFileContent], filePath = " + str + ", useAssets = " + z16);
        }
        if (TextUtils.isEmpty(str)) {
            PTSLog.i(TAG, "[getFileContent] filePath is empty.");
            return "";
        }
        String str2 = sFileContentMap.get(str);
        if (TextUtils.isEmpty(str2)) {
            str2 = loadFile(str, context, z16);
        } else if (PTSLog.isColorLevel() || PTSLog.isDebug()) {
            PTSLog.i(TAG, "[getFileContent] hit cache, key = " + str);
        }
        if (TextUtils.isEmpty(str2)) {
            PTSLog.e(TAG, "[getFileContent] res is empty.");
        }
        return str2;
    }

    public static String getFilePath(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        String str4 = File.separator;
        sb5.append(str4);
        sb5.append(str);
        sb5.append(str3);
        String sb6 = sb5.toString();
        if (TextUtils.isEmpty(str2)) {
            return sb6;
        }
        if (str2.endsWith(str4)) {
            return str2 + sb6;
        }
        return str2 + str4 + sb6;
    }

    public static boolean isFileInMap(String str) {
        boolean z16;
        if (!TextUtils.isEmpty(str)) {
            z16 = !TextUtils.isEmpty(sFileContentMap.get(str));
        } else {
            z16 = false;
        }
        if (PTSLog.isColorLevel() || PTSLog.isDebug()) {
            PTSLog.i(TAG, "[isFileInMap], filePath= " + str + ", isExist = " + z16);
        }
        return z16;
    }

    public static String loadFile(String str, Context context, boolean z16) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            PTSLog.i(TAG, "[loadFile] filePath is empty.");
            return "";
        }
        if (z16) {
            if (context != null) {
                try {
                    InputStream open = context.getAssets().open(str);
                    byte[] bArr = new byte[open.available()];
                    open.read(bArr);
                    open.close();
                    str2 = new String(bArr);
                } catch (IOException e16) {
                    PTSLog.e(TAG, "loadFile exception, e = " + e16);
                }
            }
        } else {
            PTSLog.i(TAG, "[loadFile], filePath = " + str);
            File file = new File(str);
            try {
                if (file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte[] bArr2 = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr2);
                    fileInputStream.close();
                    str2 = new String(bArr2);
                }
            } catch (IOException e17) {
                PTSLog.e(TAG, "[loadFile], e = " + e17);
            } catch (Throwable th5) {
                PTSLog.e(TAG, "[loadFile], t = " + th5);
            }
        }
        if (TextUtils.isEmpty(str2)) {
            PTSLog.e(TAG, "[loadFile] res is empty, filePath = " + str);
        } else {
            PTSLog.i(TAG, "[loadFile] succeed, filePath = " + str);
            sFileContentMap.put(str, str2);
        }
        return str2;
    }

    public static void updateFileContentCache(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            sFileContentMap.put(str, str2);
        }
    }
}

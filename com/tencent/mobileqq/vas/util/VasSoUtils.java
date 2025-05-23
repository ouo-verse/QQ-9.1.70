package com.tencent.mobileqq.vas.util;

import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.updatesystem.business.FontSoBusiness;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasSoUtils {
    public static final int LOAD_SO_FAIL = 2;
    public static final int LOAD_SO_NOT_EXIST = 1;
    public static final int LOAD_SO_SUCCESS = 0;
    private static final String SO_UNZIP_TEMP_DIR = "unzip_temp/";
    public static final String TAG = "VasSoUtils";

    public static String getSoDir(int i3) {
        FontSoBusiness fontSoBusiness = FontSoBusiness.instance;
        if (i3 == 1) {
            return fontSoBusiness.getFontSoSavePath(FontSoBusiness.SCID_HYFONT_SO);
        }
        return fontSoBusiness.getFontSoSavePath(FontSoBusiness.SCID_COLORFONT_SO);
    }

    private static boolean loadFzFontBySoManager() {
        if (!VasToggle.isEnable(VasToggle.FZ_FONT_SO, false)) {
            return false;
        }
        QLog.d(TAG, 1, "tryInitFZEngine: loadFzFontBySoManager");
        boolean isSucc = SoLoadManager.getInstance().loadSync(FontManagerConstants.FZ_COLOR_FONT_SO_TAG).isSucc();
        QLog.d(TAG, 1, "SoManager fz_font.so load isSucc:" + isSucc);
        return isSucc;
    }

    public static synchronized int loadLibrary(String str, String str2) {
        synchronized (VasSoUtils.class) {
            if (str2 != null) {
                if (str2.equals(FontSoBusiness.FZ_COLOR_FONT_SO_NAME) && loadFzFontBySoManager()) {
                    return 0;
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            String str3 = File.separator;
            sb5.append(str3);
            sb5.append(str2);
            File file = new File(sb5.toString());
            if (!file.exists()) {
                return 1;
            }
            try {
                QLog.i(TAG, 1, str + "/" + str2 + " crc=" + IOUtil.getCRC32Value(file));
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str);
                sb6.append(str3);
                sb6.append(str2);
                System.load(sb6.toString());
                return 0;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "loadLibrary error: " + th5.getMessage());
                file.delete();
                return 2;
            }
        }
    }

    public static boolean unCompressSo(String str, String str2, String str3) {
        boolean z16;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!new File(str).exists()) {
                QLog.e(TAG, 1, "unCompressSo fail src file not exists");
                return false;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str2);
            String str4 = File.separator;
            sb5.append(str4);
            sb5.append(SO_UNZIP_TEMP_DIR);
            String sb6 = sb5.toString();
            try {
                FileUtils.uncompressZip(str, sb6, false);
                File file = new File(sb6 + str3);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "unCompressSo tempfile = " + file.getAbsolutePath());
                }
                if (!file.exists()) {
                    QLog.e(TAG, 1, "unCompressSo fail so file not exists");
                    return false;
                }
                String str5 = str2 + str4 + str3;
                File file2 = new File(str5);
                if (file2.exists()) {
                    z16 = file2.delete();
                    QLog.d(TAG, 1, "unCompressSo so already exists, delete old so result = " + z16);
                } else {
                    z16 = true;
                }
                if (!z16) {
                    return false;
                }
                boolean renameTo = file.renameTo(file2);
                QLog.d(TAG, 1, "unCompressSo rename temp so to real path result = " + renameTo + "realpath = " + str5);
                return renameTo;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "unCompressSo IOException: ", e16);
                return false;
            }
        }
        QLog.e(TAG, 1, "unCompressSo fail zipPath = " + str + " dstPath = " + str2);
        return false;
    }
}

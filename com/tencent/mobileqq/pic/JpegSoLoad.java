package com.tencent.mobileqq.pic;

import android.content.Context;
import android.os.Environment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class JpegSoLoad {
    static IPatchRedirector $redirector_ = null;
    public static final int FILE_NOT_FIND = -2;
    public static final int INVALID_PARAM = -1;
    private static final String JPEG_SO_LIB = "/jpeglib/";
    public static final int LOAD_ERROR = -3;
    public static final int LOAD_SUCCESS = 0;
    private static final String PKG_NAME = "com.tencent.mobileqq";
    public static final String SO_NAME = "jpegc_above820";

    public JpegSoLoad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int LoadJpegExtractedSo(String str, Context context) {
        int i3;
        if (str == null) {
            return -1;
        }
        String str2 = getJpegSolibPath(context) + getLibActualName(str);
        int i16 = 0;
        if (!new File(str2).exists()) {
            i3 = -2;
        } else {
            try {
                System.load(str2);
                i3 = 0;
            } catch (UnsatisfiedLinkError unused) {
                i3 = -3;
            }
        }
        if (i3 != 0) {
            try {
                System.loadLibrary(str);
            } catch (UnsatisfiedLinkError unused2) {
            }
            QLog.d("JpegSoLoad", 2, "LoadJpegExtractedSo:" + i16 + " path:" + str2 + " length:" + new File(str2).length());
            return i16;
        }
        i16 = i3;
        QLog.d("JpegSoLoad", 2, "LoadJpegExtractedSo:" + i16 + " path:" + str2 + " length:" + new File(str2).length());
        return i16;
    }

    public static String getJpegSolibPath(Context context) {
        if (context == null) {
            return Environment.getDataDirectory() + "/data/com.tencent.mobileqq" + JPEG_SO_LIB;
        }
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            return filesDir.getParent() + JPEG_SO_LIB;
        }
        return Environment.getDataDirectory() + "/data/" + context.getPackageName() + JPEG_SO_LIB;
    }

    public static String getLibActualName(String str) {
        return RFixConstants.SO_PATH + str + ".so";
    }
}

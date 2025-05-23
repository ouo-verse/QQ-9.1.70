package com.tencent.video.decode;

import android.content.Context;
import android.os.Environment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ShortVideoSoLoad {
    static IPatchRedirector $redirector_ = null;
    private static String DEFAULT_SHORT_VIDEO_PATH = null;
    private static String PKG_NAME = null;
    private static final String SHORT_VIDEO_SO_LIB = "/app_lib/QzoneVideoPlugin/";
    public static final int VIDEO_FILE_NOT_FIND = -2;
    public static final int VIDEO_INVALID_PARAM = -1;
    public static final int VIDEO_LOAD_ERROR = -3;
    public static final int VIDEO_LOAD_SUCCESS = 0;
    public static final int VIDEO_LOAD_UNINIT = -4;
    private static int VIDEO_SO_LOAD_STATUS = 0;
    public static final int VIDEO_SO_VERSION_ERR = -5;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10140);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        PKG_NAME = "com.tencent.mobileqq";
        DEFAULT_SHORT_VIDEO_PATH = Environment.getDataDirectory() + "/data/" + PKG_NAME + SHORT_VIDEO_SO_LIB;
        VIDEO_SO_LOAD_STATUS = -4;
    }

    public ShortVideoSoLoad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public static synchronized int LoadExtractedShortVideo(String str) {
        int i3;
        synchronized (ShortVideoSoLoad.class) {
            int i16 = VIDEO_SO_LOAD_STATUS;
            if (i16 == 0) {
                return i16;
            }
            if (str == null) {
                VIDEO_SO_LOAD_STATUS = -1;
                return -1;
            }
            if (!new File(str).exists()) {
                i3 = -2;
            } else {
                try {
                    System.load(str);
                    i3 = 0;
                } catch (UnsatisfiedLinkError unused) {
                    i3 = -3;
                }
            }
            VIDEO_SO_LOAD_STATUS = i3;
            return i3;
        }
    }

    public static synchronized int getShortVideoSoLoadStatus() {
        int i3;
        synchronized (ShortVideoSoLoad.class) {
            i3 = VIDEO_SO_LOAD_STATUS;
        }
        return i3;
    }

    public static String getShortVideoSoPath(Context context) {
        if (context == null) {
            return DEFAULT_SHORT_VIDEO_PATH;
        }
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            return String.valueOf(filesDir.getParent()) + SHORT_VIDEO_SO_LIB;
        }
        return DEFAULT_SHORT_VIDEO_PATH;
    }

    public static synchronized void setDefaultPackageName(String str) {
        synchronized (ShortVideoSoLoad.class) {
            PKG_NAME = str;
            DEFAULT_SHORT_VIDEO_PATH = Environment.getDataDirectory() + "/data/" + PKG_NAME + SHORT_VIDEO_SO_LIB;
        }
    }

    public static synchronized void setShortVideoSoLoadStatus(int i3) {
        synchronized (ShortVideoSoLoad.class) {
            VIDEO_SO_LOAD_STATUS = i3;
        }
    }
}

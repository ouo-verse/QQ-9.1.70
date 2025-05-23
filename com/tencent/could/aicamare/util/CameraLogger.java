package com.tencent.could.aicamare.util;

import android.util.Log;
import com.tencent.could.aicamare.callback.CameraLoggerCallBack;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CameraLogger {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static LOG_LEVEL f99931a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class LOG_LEVEL {
        private static final /* synthetic */ LOG_LEVEL[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final LOG_LEVEL LEVEL_DEBUG;
        public static final LOG_LEVEL LEVEL_ERROR;
        public static final LOG_LEVEL LEVEL_INFO;
        public static final LOG_LEVEL LEVEL_NONE;
        public static final LOG_LEVEL LEVEL_VERBOSE;
        public static final LOG_LEVEL LEVEL_WARN;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13818);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            LOG_LEVEL log_level = new LOG_LEVEL("LEVEL_VERBOSE", 0);
            LEVEL_VERBOSE = log_level;
            LOG_LEVEL log_level2 = new LOG_LEVEL("LEVEL_DEBUG", 1);
            LEVEL_DEBUG = log_level2;
            LOG_LEVEL log_level3 = new LOG_LEVEL("LEVEL_INFO", 2);
            LEVEL_INFO = log_level3;
            LOG_LEVEL log_level4 = new LOG_LEVEL("LEVEL_WARN", 3);
            LEVEL_WARN = log_level4;
            LOG_LEVEL log_level5 = new LOG_LEVEL("LEVEL_ERROR", 4);
            LEVEL_ERROR = log_level5;
            LOG_LEVEL log_level6 = new LOG_LEVEL("LEVEL_NONE", 5);
            LEVEL_NONE = log_level6;
            $VALUES = new LOG_LEVEL[]{log_level, log_level2, log_level3, log_level4, log_level5, log_level6};
        }

        LOG_LEVEL(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static LOG_LEVEL valueOf(String str) {
            return (LOG_LEVEL) Enum.valueOf(LOG_LEVEL.class, str);
        }

        public static LOG_LEVEL[] values() {
            return (LOG_LEVEL[]) $VALUES.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13797);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f99931a = LOG_LEVEL.LEVEL_VERBOSE;
        }
    }

    public static void a(String str, String str2, CameraLoggerCallBack cameraLoggerCallBack) {
        if (LOG_LEVEL.LEVEL_ERROR.compareTo(f99931a) >= 0) {
            a(false, str, str2, cameraLoggerCallBack);
        }
    }

    public static void a(boolean z16, String str, String str2, CameraLoggerCallBack cameraLoggerCallBack) {
        StringBuilder sb5 = new StringBuilder();
        if (z16) {
            sb5.append("[ai-camera-debug]");
        } else {
            sb5.append("[ai-camera-error]");
        }
        sb5.append(str2);
        if (cameraLoggerCallBack != null) {
            cameraLoggerCallBack.logger(str, sb5.toString());
        } else {
            Log.d(str, sb5.toString());
        }
    }
}

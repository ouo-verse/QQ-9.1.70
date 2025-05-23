package com.tencent.qqlive.tvkplayer.tools.utils;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqlive.tvkplayer.api.ITVKLogListener;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import java.util.MissingFormatArgumentException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLogUtil {
    public static final int DEBUG = 50;
    public static final int ERROR = 10;
    public static final int INFO = 40;
    public static final String TAG = "TVKPlayer";
    public static final int VERBOSE = 60;
    public static final int WARNING = 20;
    private static boolean isDebug = false;
    private static ITVKLogListener onLogListener;

    public static void d(String str, String str2) {
        printTag(50, str, str2, new Object[0]);
    }

    public static void e(String str, String str2) {
        printTag(10, str, str2, new Object[0]);
    }

    public static void i(String str, String str2) {
        printTag(40, str, str2, new Object[0]);
    }

    private static void logToLogListener(int i3, String str, String str2) {
        if (i3 != 10) {
            if (i3 != 20) {
                if (i3 != 40) {
                    if (i3 != 50) {
                        if (i3 == 60) {
                            onLogListener.v(str, str2);
                            return;
                        }
                        return;
                    }
                    onLogListener.d(str, str2);
                    return;
                }
                onLogListener.i(str, str2);
                return;
            }
            onLogListener.w(str, str2);
            return;
        }
        onLogListener.e(str, str2);
    }

    private static void printTag(int i3, String str, String str2, Object... objArr) {
        if (i3 != 60 && i3 != 50) {
            if (i3 == 20) {
                i3 = 10;
            }
            if (objArr != null) {
                try {
                    if (objArr.length != 0) {
                        str2 = String.format(str2, objArr);
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                } catch (OutOfMemoryError unused) {
                    return;
                } catch (MissingFormatArgumentException e17) {
                    e17.printStackTrace();
                    return;
                }
            }
            if (onLogListener != null) {
                if (i3 <= TVKMediaPlayerConfig.PlayerConfig.log_print_level) {
                    logToLogListener(i3, str, str2);
                }
            } else if (isDebug && i3 <= TVKMediaPlayerConfig.PlayerConfig.log_print_level) {
                Log.println(toSysLevel(i3), str, str2);
            }
        }
    }

    public static void setDebugEnable(boolean z16) {
        isDebug = z16;
    }

    public static void setOnLogListener(ITVKLogListener iTVKLogListener) {
        onLogListener = iTVKLogListener;
    }

    private static int toSysLevel(int i3) {
        if (i3 != 10) {
            if (i3 != 20) {
                if (i3 != 40) {
                    if (i3 != 50) {
                        if (i3 != 60) {
                            return 0;
                        }
                        return 2;
                    }
                    return 3;
                }
                return 4;
            }
            return 5;
        }
        return 6;
    }

    public static void v(String str, String str2) {
        printTag(60, str, str2, new Object[0]);
    }

    public static void w(String str, String str2) {
        printTag(20, str, str2, new Object[0]);
    }

    public static void e(String str, Throwable th5) {
        e(str, th5, "");
    }

    public static void e(String str, Throwable th5, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        } else {
            str3 = str2 + "\n";
        }
        if (th5 != null) {
            str3 = str3 + Log.getStackTraceString(th5);
        }
        printTag(10, str, str3, new Object[0]);
    }
}

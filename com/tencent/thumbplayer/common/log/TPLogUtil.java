package com.tencent.thumbplayer.common.log;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.thumbplayer.api.common.ITPLogListener;
import com.tencent.thumbplayer.core.utils.TPNativeLog;
import com.tencent.thumbplayer.libloader.TPLibraryLoader;
import java.util.MissingFormatArgumentException;

/* loaded from: classes26.dex */
public class TPLogUtil {
    private static final ITPLogListener DUMMY_LOG_LISTENER;
    private static boolean sIsDebug;
    private static ITPLogListener sLogListener;
    private static int sMinPrintLevel;

    static {
        ITPLogListener iTPLogListener = new ITPLogListener() { // from class: com.tencent.thumbplayer.common.log.TPLogUtil.1
            @Override // com.tencent.thumbplayer.api.common.ITPLogListener
            public void d(String str, String str2) {
            }

            @Override // com.tencent.thumbplayer.api.common.ITPLogListener
            public void e(String str, String str2) {
            }

            @Override // com.tencent.thumbplayer.api.common.ITPLogListener
            public void i(String str, String str2) {
            }

            @Override // com.tencent.thumbplayer.api.common.ITPLogListener
            public void v(String str, String str2) {
            }

            @Override // com.tencent.thumbplayer.api.common.ITPLogListener
            public void w(String str, String str2) {
            }
        };
        DUMMY_LOG_LISTENER = iTPLogListener;
        sIsDebug = true;
        sLogListener = iTPLogListener;
        sMinPrintLevel = 2;
    }

    private static void callLogListener(int i3, String str, String str2) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            sLogListener.e(str, str2);
                            return;
                        }
                        return;
                    }
                    sLogListener.w(str, str2);
                    return;
                }
                sLogListener.i(str, str2);
                return;
            }
            sLogListener.d(str, str2);
            return;
        }
        sLogListener.v(str, str2);
    }

    private static void callSystemLogger(int i3, String str, String str2) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            Log.println(6, str, str2);
                            return;
                        }
                        return;
                    }
                    Log.println(5, str, str2);
                    return;
                }
                Log.println(4, str, str2);
                return;
            }
            Log.println(3, str, str2);
            return;
        }
        Log.println(2, str, str2);
    }

    public static void d(String str, String str2) {
        print(1, str, str2);
    }

    public static void e(String str, String str2) {
        print(4, str, str2);
    }

    public static void enableDebug(boolean z16) {
        sIsDebug = z16;
    }

    public static void i(String str, String str2) {
        print(2, str, str2);
    }

    public static void print(int i3, String str, String str2) {
        if (i3 < sMinPrintLevel) {
            return;
        }
        try {
            if (DUMMY_LOG_LISTENER != sLogListener) {
                callLogListener(i3, str, str2);
            } else if (sIsDebug) {
                callSystemLogger(i3, str, str2);
            }
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
        } catch (MissingFormatArgumentException e17) {
            e17.printStackTrace();
        } catch (Exception e18) {
            e18.printStackTrace();
        }
    }

    public static void setLogListener(ITPLogListener iTPLogListener) {
        if (iTPLogListener == null) {
            iTPLogListener = DUMMY_LOG_LISTENER;
        }
        sLogListener = iTPLogListener;
    }

    public static void setMinPrintLevel(int i3) {
        sMinPrintLevel = i3;
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            TPNativeLog.setMinPrintLevel(TPPlayerCoreLogImpl.tpLogLevelToPlayerCoreLogLevel(i3));
        }
    }

    public static void v(String str, String str2) {
        print(0, str, str2);
    }

    public static void w(String str, String str2) {
        print(3, str, str2);
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
        print(4, str, str3);
    }
}

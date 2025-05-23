package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.smtt.sdk.TbsHandlerThread;
import java.io.File;

/* compiled from: P */
/* loaded from: classes25.dex */
public class TbsLog {
    public static final int MSG_PV_REPORT = 501;
    public static final String X5LOGTAG = "x5logtag";

    /* renamed from: a, reason: collision with root package name */
    private static boolean f369646a = false;

    /* renamed from: b, reason: collision with root package name */
    private static Handler f369647b;

    /* renamed from: c, reason: collision with root package name */
    private static TbsLogClient f369648c;

    public static void d(String str, String str2, String str3) {
    }

    public static void e(String str, String str2) {
        e(str, "", str2);
    }

    public static String getTbsLogFilePath() {
        File file = TbsLogClient.f369650c;
        if (file != null) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static Handler getTbsLogHandler() {
        return f369647b;
    }

    public static void i(Throwable th5) {
        i("handle_throwable", Log.getStackTraceString(th5));
    }

    public static synchronized void initIfNeed(Context context) {
        synchronized (TbsLog.class) {
            if (f369648c == null) {
                setTbsLogClient(new TbsLogClient(context));
            }
            if (f369647b == null) {
                f369647b = new Handler(TbsHandlerThread.getInstance().getLooper()) { // from class: com.tencent.smtt.utils.TbsLog.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        int i3 = message.what;
                        if (i3 == 500) {
                            if (TbsLog.f369648c != null) {
                                TbsLog.f369648c.writeLogToDisk();
                            }
                        } else if (i3 == 501) {
                            Object obj = message.obj;
                            if (obj instanceof Runnable) {
                                ((Runnable) obj).run();
                            }
                        }
                    }
                };
            }
        }
    }

    public static void setLogView(TextView textView) {
        TbsLogClient tbsLogClient;
        if (textView != null && (tbsLogClient = f369648c) != null) {
            tbsLogClient.setLogView(textView);
        }
    }

    public static boolean setTbsLogClient(TbsLogClient tbsLogClient) {
        if (tbsLogClient == null) {
            return false;
        }
        f369648c = tbsLogClient;
        return true;
    }

    @Deprecated
    public static void setWriteLogJIT(boolean z16) {
        TbsLogClient tbsLogClient = f369648c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.setWriteLogJIT(z16);
    }

    public static void v(String str, String str2, String str3) {
    }

    public static void w(String str, String str2) {
        w(str, "", str2);
    }

    public static synchronized void writeLogToDisk() {
        Handler handler;
        synchronized (TbsLog.class) {
            if (f369648c != null && (handler = f369647b) != null) {
                handler.obtainMessage(500).sendToTarget();
            }
        }
    }

    public static void d(String str, String str2) {
        d(str, "", str2);
    }

    public static void e(String str, String str2, boolean z16) {
        e(str, str2);
        TbsLogClient tbsLogClient = f369648c;
        if (tbsLogClient != null && f369646a && z16) {
            tbsLogClient.showLog(str + MsgSummary.STR_COLON + str2);
        }
    }

    public static void i(String str, String str2) {
        i(str, "", str2);
    }

    public static void v(String str, String str2) {
        v(str, "", str2);
    }

    public static void w(String str, String str2, boolean z16) {
        w(str, str2);
        TbsLogClient tbsLogClient = f369648c;
        if (tbsLogClient != null && f369646a && z16) {
            tbsLogClient.showLog(str + MsgSummary.STR_COLON + str2);
        }
    }

    public static void d(String str, String str2, boolean z16) {
        d(str, str2);
        TbsLogClient tbsLogClient = f369648c;
        if (tbsLogClient != null && f369646a && z16) {
            tbsLogClient.showLog(str + MsgSummary.STR_COLON + str2);
        }
    }

    public static void i(String str, String str2, boolean z16) {
        i(str, str2);
        TbsLogClient tbsLogClient = f369648c;
        if (tbsLogClient != null && f369646a && z16) {
            tbsLogClient.showLog(str + MsgSummary.STR_COLON + str2);
        }
    }

    public static void v(String str, String str2, boolean z16) {
        v(str, str2);
        TbsLogClient tbsLogClient = f369648c;
        if (tbsLogClient != null && f369646a && z16) {
            tbsLogClient.showLog(str + MsgSummary.STR_COLON + str2);
        }
    }

    public static void e(String str, String str2, String str3) {
        TbsLogClient tbsLogClient = f369648c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.e(str, "TBS:" + str2 + " " + str3);
        f369648c.writeLog("(E)-" + str + "-TBS:" + str2 + " " + str3);
    }

    public static void w(String str, String str2, String str3) {
        TbsLogClient tbsLogClient = f369648c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.w(str, "TBS:" + str2 + " " + str3);
        f369648c.writeLog("(W)-" + str + "-TBS:" + str2 + " " + str3);
    }

    public static void i(String str, String str2, String str3) {
        TbsLogClient tbsLogClient = f369648c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.i(str, "TBS:" + str2 + " " + str3);
        f369648c.writeLog("(I)-" + str + "-TBS:" + str2 + " " + str3);
    }
}

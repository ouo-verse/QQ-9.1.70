package com.tencent.mqq.shared_file_accessor;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.tencent.mqq.shared_file_accessor.CommonConstants;

/* compiled from: P */
/* loaded from: classes21.dex */
public class LogUtil {
    private static final String CP_URI_BASE = "content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl/log";
    private static final Uri LOG_URI = Uri.parse(CP_URI_BASE);
    static final boolean mTimeLogEnabled = false;
    static final boolean mTimeLogIntoLogcat = true;
    static final boolean sLogcatLogEnabled = false;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class LogTicket {
        public double mBeginTime = System.nanoTime() * 1.0E-6d;
    }

    public static void d(String str, String str2) {
        Log.d(str, str2);
    }

    public static void e(String str, String str2) {
        Log.e(str, str2);
    }

    public static LogTicket timeLogBegin() {
        return new LogTicket();
    }

    public static void timeLogEnd(Context context, String str, String str2, String str3, String str4, String str5, CommonConstants.ValueType valueType, boolean z16, LogTicket logTicket) {
    }

    public static void timeLogEnd(String str, LogTicket logTicket) {
    }
}

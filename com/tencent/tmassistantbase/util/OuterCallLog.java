package com.tencent.tmassistantbase.util;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes26.dex */
public class OuterCallLog {
    public static final String OuterCall_DownloadApi_DoDownloadAction = "OuterCall_DownloadApi_DoDownloadAction";
    public static final String OuterCall_DownloadApi_DoDownloadActionByMyApp = "OuterCall_DownloadApi_DoDownloadActionByMyApp";
    public static final String OuterCall_JS_DoDownloadAction = "OuterCall_JS_DoDownloadAction";
    public static final String OuterCall_MyAppApi_HandleDownloadAction = "OuterCall_MyAppApi_HandleDownloadAction";
    public static final String OuterCall_MyAppApi_StartToAppDetail = "OuterCall_MyAppApi_StartToAppDetail";
    public static final String OuterCall_MyAppApi_StartToDownloadList = "OuterCall_MyAppApi_StartToDownloadList";
    public static final String OuterCall_QQ_Report = "OuterCall_QQ_Report";
    public static final String OuterCall_TMAssistantCallYYB_V2_StartToAppDetail = "OuterCall_TMAssistantCallYYB_V2_StartToAppDetail";
    public static final String OuterCall_TMAssistantCallYYB_V2_StartToDownloadList = "OuterCall_TMAssistantCallYYB_V2_StartToDownloadList";
    public static final String OuterCall_TMQQDownloaderDataProcessor_HandleDownloadTask_End = "OuterCall_TMQQDownloaderDataProcessor_HandleDownloadTask_End";
    public static final String OuterCall_TMQQDownloaderDataProcessor_HandleDownloadTask_Start = "OuterCall_TMQQDownloaderDataProcessor_HandleDownloadTask_Start";
    public static OuterCallLog sInstance;
    public volatile long lastTime = 0;

    public static synchronized OuterCallLog getsInstance() {
        OuterCallLog outerCallLog;
        synchronized (OuterCallLog.class) {
            if (sInstance == null) {
                sInstance = new OuterCallLog();
            }
            outerCallLog = sInstance;
        }
        return outerCallLog;
    }

    public void printCostTime(String str) {
        if (this.lastTime == 0) {
            reset();
        }
        Log.i("OuterCallFromQQ", str + " costTime = " + (System.currentTimeMillis() - this.lastTime));
        this.lastTime = System.currentTimeMillis();
    }

    public void reset() {
        this.lastTime = System.currentTimeMillis();
        Log.i("OuterCallFromQQ", "reset_sdk");
    }
}

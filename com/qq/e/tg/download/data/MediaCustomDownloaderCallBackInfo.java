package com.qq.e.tg.download.data;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MediaCustomDownloaderCallBackInfo {
    public static final int ERR_DBEXCPTION = 4;
    public static final int ERR_UNKNOWN_EXCEPTION = 1;
    public static final int ERR_UNKNOWN_IOEXCEPTION = 2;
    public static final int STATUS_DOWNLOADING = 4;
    public static final int STATUS_DOWNLOAD_DELETE = 64;
    public static final int STATUS_DOWNLOAD_FAILED = 16;
    public static final int STATUS_DOWNLOAD_FINISHED = 8;
    public static final int STATUS_DOWNLOAD_PAUSED = 32;
    public static final int STATUS_DOWNLOAD_RESUME = 128;
    public static final int STATUS_INSTALLED = 1;
    public static final int STATUS_UNKNOWN = 0;
    public String appName;
    public int eCode;
    public String eMsg;
    public JSONObject extInfo;
    public String iconUrl;
    public String pkgName;
    public int progress;
    public int status;
    public String taskId;
    public long totalSize;
}

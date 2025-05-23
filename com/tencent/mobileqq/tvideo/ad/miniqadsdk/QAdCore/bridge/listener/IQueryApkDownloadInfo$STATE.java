package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.listener;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes19.dex */
public @interface IQueryApkDownloadInfo$STATE {
    public static final int STATE_APP_INSTALLED = 6;
    public static final int STATE_TASK_DELETED = 7;
    public static final int STATE_TASK_DOWNLOADING = 2;
    public static final int STATE_TASK_EXIST_SUCCEED = 12;
    public static final int STATE_TASK_FAILED = 3;
    public static final int STATE_TASK_NO_NETWORK = 10;
    public static final int STATE_TASK_PAUSED = 5;
    public static final int STATE_TASK_SUCCEED = 4;
    public static final int STATE_TASK_UNKNOWN = 0;
    public static final int STATE_TASK_WAITING = 1;
    public static final int STATE_TASK_WAITING_WIFI = 11;
    public static final int STATE_TASK_YYB_DOWNLOADING = 8;
    public static final int STATE_TASK_YYB_SUCCEED = 9;
}

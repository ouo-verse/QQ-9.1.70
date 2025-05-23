package com.tencent.commonsdk.util.notification;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface NotificationReportController {
    public static final int MSG_REPORT_NOTIFY_CLICK = 2;
    public static final int MSG_REPORT_NOTIFY_PUSH = 1;
    public static final int MSG_REPORT_NOTIFY_PUSH_FLUSH = 5;
    public static final int MSG_REPORT_QQLS_CLICK = 4;
    public static final int MSG_REPORT_QQLS_PUSH = 3;

    void report(int i3, int i16, String str, int i17);

    void reportAll();
}

package com.tencent.image.api;

import com.tencent.image.ReportBean;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IReport {
    public static final int TYPE_CALLBACK_AIO_THUMB_DISPATCH_WAIT_TIME = 4;
    public static final int TYPE_CALLBACK_AIO_THUMB_DOWNLOAD_WAIT_TIME = 3;
    public static final int TYPE_CALLBACK_HTTP_ERROR = 2;
    public static final int TYPE_CALLBACK_OVERSIZE = 1;

    void debug(int i3, Object obj);

    void report(ReportBean reportBean);

    void reportEvent(ReportEventBean reportEventBean);

    void reportException(String str, String str2);
}

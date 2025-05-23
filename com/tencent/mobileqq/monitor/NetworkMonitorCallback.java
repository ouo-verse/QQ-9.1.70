package com.tencent.mobileqq.monitor;

import com.tencent.mobileqq.msf.sdk.utils.MonitorHttpInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface NetworkMonitorCallback {
    void addDownloadURL(String str);

    void addHttpInfo(MonitorHttpInfo monitorHttpInfo);
}

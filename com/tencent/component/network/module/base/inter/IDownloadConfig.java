package com.tencent.component.network.module.base.inter;

import java.util.HashMap;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface IDownloadConfig {
    boolean canRetCodeRetry(int i3);

    boolean disableBssid();

    boolean enableDns114();

    Object getConfig(String str, String str2, Object obj);

    long getCurrentUin();

    long getDefaultHttp2LiveTime();

    int getDefaultHttp2ThreadPoolSize();

    long getDefaultHttpLiveTime();

    int getDefaultThreadPoolSize();

    int getNetworkStackType();

    int getOperator();

    String getQUA();

    String getRefer();

    int getReportPercent();

    String getTerminal();

    String getUserAgent();

    String getVersion();

    boolean isFromQzoneAlbum(String str);

    int photoDownloadKeepAliveConfig();

    int photoDownloadKeepAliveProxyConfig();

    void reportToBeacon(String str, boolean z16, HashMap<String, String> hashMap, long j3);

    void reportToLp(int i3, boolean z16, String str, int i16, String str2);

    void reportToMta(String str, Properties properties);

    boolean shouldUseHttp2(String str);
}

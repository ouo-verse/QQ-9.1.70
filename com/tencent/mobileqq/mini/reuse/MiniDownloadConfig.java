package com.tencent.mobileqq.mini.reuse;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.module.base.inter.IDownloadConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import common.config.service.QzoneConfig;
import cooperation.qzone.UploadEnv;
import java.util.HashMap;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes33.dex */
class MiniDownloadConfig implements IDownloadConfig {
    private static final int DEFAULT_HTTP_LIVE_TIME = 60;
    private static final int DEFAULT_HTTP_THREAD_POOL_SIZE = 16;
    private static final String TAG = "MiniDownloadConfig";

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public boolean canRetCodeRetry(int i3) {
        return false;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public boolean disableBssid() {
        return ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).disableBssid();
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public boolean enableDns114() {
        return true;
    }

    public long getConfig(String str, String str2, long j3) {
        return 0L;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public long getCurrentUin() {
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        if (!TextUtils.isEmpty(account)) {
            try {
                return Long.parseLong(account);
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public long getDefaultHttp2LiveTime() {
        return getDefaultHttpLiveTime();
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public int getDefaultHttp2ThreadPoolSize() {
        return getDefaultThreadPoolSize();
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public long getDefaultHttpLiveTime() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_download_http_connect_live_time", 60);
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public int getDefaultThreadPoolSize() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_download_http_tp_size", 16);
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public int getOperator() {
        return 0;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public String getQUA() {
        return null;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public String getRefer() {
        return "miniApp";
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public int getReportPercent() {
        return 0;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public String getTerminal() {
        return "Android-miniApp";
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public String getUserAgent() {
        return "miniApp";
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public String getVersion() {
        return ah.P();
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public boolean isFromQzoneAlbum(String str) {
        return false;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public int photoDownloadKeepAliveConfig() {
        return 0;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public int photoDownloadKeepAliveProxyConfig() {
        return 0;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public void reportToBeacon(String str, boolean z16, HashMap<String, String> hashMap, long j3) {
        ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).reportDownloadResult(str, z16, hashMap, j3, "mini");
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public boolean shouldUseHttp2(String str) {
        return false;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public Object getConfig(String str, String str2, Object obj) {
        return QzoneConfig.getInstance().getConfigByObject(str, str2, obj);
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public int getNetworkStackType() {
        return UploadEnv.getIpStack(1);
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public void reportToMta(String str, Properties properties) {
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public void reportToLp(int i3, boolean z16, String str, int i16, String str2) {
    }
}

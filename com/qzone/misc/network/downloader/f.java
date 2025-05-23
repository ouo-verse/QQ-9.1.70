package com.qzone.misc.network.downloader;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.config.service.QZoneConfigService;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.module.base.inter.IDownloadConfig;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.UploadEnv;
import cooperation.qzone.report.lp.LpReportInfo_dc02349;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes39.dex */
public class f implements IDownloadConfig, QzoneConfig.QzoneConfigChangeListener {
    private boolean F;

    /* renamed from: d, reason: collision with root package name */
    private String f48404d;

    /* renamed from: e, reason: collision with root package name */
    private String f48405e;

    /* renamed from: f, reason: collision with root package name */
    private List<String> f48406f = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private List<String> f48407h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private Map<String, Pattern> f48408i = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    private ReadWriteLock f48409m = new ReentrantReadWriteLock();
    private int C = 100;
    private int D = 0;
    private int E = 0;
    private long G = 0;

    public f() {
        this.F = true;
        c();
        QzoneConfig.getInstance().addListener(this);
        this.F = Math.abs(System.currentTimeMillis() - NetConnInfoCenter.getServerTimeMillis()) <= 86400000;
    }

    private boolean a() {
        if (this.G == 0) {
            this.G = System.currentTimeMillis();
            return true;
        }
        if (System.currentTimeMillis() - this.G <= 60000) {
            return false;
        }
        this.G = System.currentTimeMillis();
        return true;
    }

    private boolean b() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_DOWNLOAD, QzoneConfig.SECONDARY_ENABLE_COLOR, -1) == 1;
    }

    private void c() {
        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_DOWNLOAD_SETTING, QzoneConfig.SECONDARY_REGULAR_HTTP2_GRAY_CONFIG, QzoneConfig.DefaultValue.DEFAULT_DOWNLOAD_HTTP2_GRAY_CONFIG);
        if (config != null && !config.equals(this.f48405e)) {
            QZLog.i("QzoneDownloadConfig", "http2 gray:" + config);
            try {
                String[] split = config.split(",");
                if (split.length >= 3) {
                    this.D = Integer.parseInt(split[0]);
                    this.E = Integer.parseInt(split[1]);
                    this.C = Integer.parseInt(split[2]);
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        String config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_DOWNLOAD_SETTING, QzoneConfig.SECONDARY_HTTP2_DOMAIN_LIST, QzoneConfig.DefaultValue.DEFAULT_DOWNLOAD_HTTP2_DOMAIN_LIST);
        if (config2 == null || config2.equals(this.f48404d)) {
            return;
        }
        QZLog.i("QzoneDownloadConfig", "http2 domain:" + config2);
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        try {
            String[] split2 = config2.split(",");
            if (split2 != null) {
                for (String str : split2) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                        hashMap.put(str, Pattern.compile(str, 2));
                    }
                }
            }
        } catch (Throwable th6) {
            th6.printStackTrace();
        }
        try {
            this.f48409m.writeLock().lock();
            this.f48405e = config;
            this.f48404d = config2;
            this.f48406f.clear();
            this.f48406f.addAll(arrayList);
            this.f48407h.clear();
            this.f48408i.clear();
            this.f48408i.putAll(hashMap);
        } finally {
            this.f48409m.writeLock().unlock();
        }
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public boolean canRetCodeRetry(int i3) {
        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_DOWNLOAD, QzoneConfig.SECONDARY_RETRY_RETCODE, "-2005");
        if (TextUtils.isEmpty(config)) {
            return false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("");
        sb5.append(i3);
        return config.contains(sb5.toString());
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public boolean disableBssid() {
        return com.qzone.reborn.configx.g.f53821a.b().m();
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public boolean enableDns114() {
        return true;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public Object getConfig(String str, String str2, Object obj) {
        return QzoneConfig.getInstance().getConfigByObject(str, str2, obj);
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public long getCurrentUin() {
        com.qzone.common.config.service.a e16 = QZoneConfigService.f().e();
        if (e16 != null) {
            return e16.a();
        }
        return 0L;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public long getDefaultHttp2LiveTime() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_DOWNLOAD_SETTING, QzoneConfig.SECONDARY_HTTP2_CONNECT_LIVE_TIME, 120);
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public int getDefaultHttp2ThreadPoolSize() {
        if (NetworkState.g().getNetworkType() == 1) {
            return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_DOWNLOAD_SETTING, QzoneConfig.SECONDARY_HTTP2_WIFI_THREAD_POOL_SIZE, 2);
        }
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_DOWNLOAD_SETTING, QzoneConfig.SECONDARY_HTTP2_THREAD_POOL_SIZE, 2);
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public long getDefaultHttpLiveTime() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_DOWNLOAD_SETTING, QzoneConfig.SECONDARY_HTTP_CONNECT_LIVE_TIME, 120);
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public int getDefaultThreadPoolSize() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_DOWNLOAD_SETTING, QzoneConfig.SECONDARY_HTTP_THREAD_POOL_SIZE, 2);
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public int getOperator() {
        int e16 = com.tencent.common.config.provider.a.e();
        if (e16 <= 0 && a()) {
            QZoneConfigService.f().k();
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("QzoneDownloadConfig", 4, "QzoneDownloadConfig ():WiFiCrarryType=" + e16);
        }
        return e16;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public String getQUA() {
        com.qzone.common.config.service.a e16 = QZoneConfigService.f().e();
        if (e16 == null) {
            return QUA.getQUA3();
        }
        String qua = e16.getQUA();
        return TextUtils.isEmpty(qua) ? QUA.getQUA3() : qua;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public String getRefer() {
        com.qzone.common.config.service.a e16 = QZoneConfigService.f().e();
        if (e16 == null) {
            return "mqq";
        }
        String refer = e16.getRefer();
        return TextUtils.isEmpty(refer) ? "mqq" : refer;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public int getReportPercent() {
        return b() ? 100 : 5;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public String getTerminal() {
        com.qzone.common.config.service.a e16 = QZoneConfigService.f().e();
        if (e16 == null) {
            return "Android-QZoneInQQ";
        }
        String c16 = e16.c();
        return TextUtils.isEmpty(c16) ? "Android-QZoneInQQ" : c16;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public String getUserAgent() {
        return "qzone";
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public String getVersion() {
        com.qzone.common.config.service.a e16 = QZoneConfigService.f().e();
        if (e16 == null) {
            return QUA.getVersionForPic();
        }
        String version = e16.getVersion();
        return TextUtils.isEmpty(version) ? QUA.getVersionForPic() : version;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public boolean isFromQzoneAlbum(String str) {
        try {
            this.f48409m.readLock().lock();
            boolean z16 = true;
            if (this.f48407h.contains(str)) {
                return true;
            }
            Iterator<Map.Entry<String, Pattern>> it = this.f48408i.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z16 = false;
                    break;
                }
                if (Utils.match(this.f48408i.get(it.next().getKey()), str)) {
                    break;
                }
            }
            if (z16) {
                try {
                    this.f48409m.writeLock().lock();
                    this.f48407h.add(str);
                } finally {
                    this.f48409m.writeLock().unlock();
                }
            }
            return z16;
        } finally {
            this.f48409m.readLock().unlock();
        }
    }

    @Override // common.config.service.QzoneConfig.QzoneConfigChangeListener
    public void onConfigChange() {
        if (QLog.isColorLevel()) {
            QLog.d("QzoneDownloadConfig", 2, "QzoneDownloadConfig change");
        }
        c();
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public int photoDownloadKeepAliveConfig() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_DOWNLOAD, QzoneConfig.SECONDARY_PHOTO_DOWNLOAD_KEEP_ALIVE, 0);
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public int photoDownloadKeepAliveProxyConfig() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_DOWNLOAD, QzoneConfig.SECONDARY_PHOTO_DOWNLOAD_KEEP_ALIVE_PROXY, 1);
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public void reportToLp(int i3, boolean z16, String str, int i16, String str2) {
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_DOWNLOAD_SETTING, QzoneConfig.SECONDARY_EXCEPTION_REPORT_USESAMPLE, 0);
        LpReportInfo_dc02349 lpReportInfo_dc02349 = new LpReportInfo_dc02349();
        lpReportInfo_dc02349.downloadType = i3;
        lpReportInfo_dc02349.isHttp2 = !z16 ? 1 : 0;
        lpReportInfo_dc02349.downloadUrl = str;
        lpReportInfo_dc02349.retCode = i16;
        lpReportInfo_dc02349.errMsg = str2;
        LpReportManager.getInstance().reportToDC02349(lpReportInfo_dc02349, config == 1, true);
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public void reportToMta(String str, Properties properties) {
        QZLog.d("QzoneDownloadConfig", 2, "[reportToMta] s=" + str + ", prop=" + properties);
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public boolean shouldUseHttp2(String str) {
        return false;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public int getNetworkStackType() {
        return UploadEnv.getIpStack(1);
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public void reportToBeacon(String str, boolean z16, HashMap<String, String> hashMap, long j3) {
        if (hashMap == null) {
            return;
        }
        if (QZLog.isDevelopLevel()) {
            String str2 = "";
            for (String str3 : hashMap.keySet()) {
                str2 = str2 + str3 + ":" + hashMap.get(str3) + ",";
            }
            QZLog.i("QzoneDownloadConfig", "tagName:" + str + ",params:" + str2);
        }
        try {
            ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).reportDownloadResult(str, z16, hashMap, j3, "qzone");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(LoginData.getInstance().getUinString(), str, z16, j3, 0L, hashMap, null);
        } catch (Throwable th5) {
            QZLog.e("QzoneDownloadConfig", "", th5);
        }
    }
}

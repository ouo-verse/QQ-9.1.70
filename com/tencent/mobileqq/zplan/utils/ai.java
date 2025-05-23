package com.tencent.mobileqq.zplan.utils;

import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.module.base.inter.IDownloadConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import common.config.service.QzoneConfig;
import cooperation.qzone.UploadEnv;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.HashMap;
import java.util.Properties;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 42\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u0012\u0010\u0017\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0018\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J(\u0010\u001f\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010 \u001a\u00020\u0002H\u0016J8\u0010'\u001a\u00020&2\b\u0010!\u001a\u0004\u0018\u00010\b2\u0006\u0010\"\u001a\u00020\u00102\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010#2\u0006\u0010%\u001a\u00020\u0005H\u0016J4\u0010,\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00102\b\u0010*\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u00100\u001a\u00020&2\b\u0010-\u001a\u0004\u0018\u00010\b2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\b\u00101\u001a\u00020\u0010H\u0016\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/ai;", "Lcom/tencent/component/network/module/base/inter/IDownloadConfig;", "", "getDefaultThreadPoolSize", "getDefaultHttp2ThreadPoolSize", "", "getDefaultHttpLiveTime", "getDefaultHttp2LiveTime", "", "getTerminal", "getVersion", "getRefer", DKWebViewController.DKHippyWebviewFunction.GET_USER_AGENT, "", "a", "getCurrentUin", "", "enableDns114", "photoDownloadKeepAliveConfig", "photoDownloadKeepAliveProxyConfig", "getOperator", "getReportPercent", "domain", "shouldUseHttp2", "isFromQzoneAlbum", "retCode", "canRetCodeRetry", "mainKey", "secondaryKey", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getConfig", "getNetworkStackType", "tag", "success", "Ljava/util/HashMap;", "params", "duration", "", "reportToBeacon", "type", "isHttp2", "url", "errMsg", "reportToLp", ReportConstant.COSTREPORT_PREFIX, "Ljava/util/Properties;", Constants.Service.PROPERTIES, "reportToMta", "disableBssid", "<init>", "()V", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ai implements IDownloadConfig {

    /* renamed from: d, reason: collision with root package name */
    private static final a f335764d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @Deprecated
    private static final int f335765e;

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    private static final long f335766f;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/ai$a;", "", "", "TERMINAL", "Ljava/lang/String;", QQWinkConstants.ENTRY_BUSINESS_QCIRCLE_OLD, "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    static {
        ZPlanFeatureSwitch zPlanFeatureSwitch = ZPlanFeatureSwitch.f369852a;
        f335765e = zPlanFeatureSwitch.m2();
        f335766f = zPlanFeatureSwitch.k2();
    }

    public Void a() {
        return null;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public boolean canRetCodeRetry(int retCode) {
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

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public Object getConfig(String mainKey, String secondaryKey, Object defaultValue) {
        return QzoneConfig.getInstance().getConfigByObject(mainKey, secondaryKey, defaultValue);
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public long getCurrentUin() {
        return BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
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
        return f335766f;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public int getDefaultThreadPoolSize() {
        return f335765e;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public int getOperator() {
        return 0;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public /* bridge */ /* synthetic */ String getQUA() {
        return (String) a();
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public String getRefer() {
        return "zplan";
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public int getReportPercent() {
        return 0;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public String getTerminal() {
        return "android-zplan";
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public String getUserAgent() {
        return "zplan";
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public String getVersion() {
        return com.tencent.mobileqq.utils.ah.P();
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public boolean isFromQzoneAlbum(String domain) {
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
    public void reportToBeacon(String tag, boolean success, HashMap<String, String> params, long duration) {
        ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).reportDownloadResult(tag, success, params, duration, "zplan");
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public boolean shouldUseHttp2(String domain) {
        return false;
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public int getNetworkStackType() {
        return UploadEnv.getIpStack(1);
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public void reportToMta(String s16, Properties properties) {
    }

    @Override // com.tencent.component.network.module.base.inter.IDownloadConfig
    public void reportToLp(int type, boolean isHttp2, String url, int retCode, String errMsg) {
    }
}

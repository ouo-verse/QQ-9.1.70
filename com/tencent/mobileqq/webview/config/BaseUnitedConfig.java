package com.tencent.mobileqq.webview.config;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.freesia.NetworkResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 \u0017*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0005\u001a\u00020\u0004H&J\u0017\u0010\u0006\u001a\u00028\u0001\"\b\b\u0001\u0010\u0002*\u00020\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0019\u0010\u0012\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00018\u0000H\u0014\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\fH\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/webview/config/BaseUnitedConfig;", "Lcom/tencent/freesia/IConfigData;", "T", "Lcom/tencent/freesia/BaseConfigParser;", "", "getGroup", "loadConfig", "()Lcom/tencent/freesia/IConfigData;", "", AdMetricTag.FALLBACK, "isSwitchOn", "version", "", "onSend", "Lcom/tencent/freesia/NetworkResult;", "result", "onReceiveNotUpdate", DownloadInfo.spKey_Config, "doOnConfigUpdate", "(Lcom/tencent/freesia/IConfigData;)V", "onRemoved", "<init>", "()V", "d", "a", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class BaseUnitedConfig<T extends IConfigData> extends BaseConfigParser<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    public void doOnConfigUpdate(T config) {
        super.doOnConfigUpdate(config);
        com.tencent.xaction.log.b.a("BaseUnitedConfig", 4, "doOnConfigUpdate:" + config);
    }

    public abstract String getGroup();

    public final boolean isSwitchOn(boolean fallback) {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(getGroup(), fallback);
    }

    public final <T extends IConfigData> T loadConfig() {
        T t16 = (T) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(getGroup());
        if (t16 == null) {
            t16 = defaultConfig();
        }
        Intrinsics.checkNotNull(t16, "null cannot be cast to non-null type T of com.tencent.mobileqq.webview.config.BaseUnitedConfig.loadConfig");
        return t16;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onReceiveNotUpdate(NetworkResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        super.onReceiveNotUpdate(result);
        com.tencent.xaction.log.b.a("BaseUnitedConfig", 4, "onReceiveNotUpdate:" + result);
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onRemoved() {
        super.onRemoved();
        com.tencent.xaction.log.b.a("BaseUnitedConfig", 4, "onRemoved");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onSend(String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        super.onSend(version);
        com.tencent.xaction.log.b.a("BaseUnitedConfig", 4, "onSend:" + version);
    }
}

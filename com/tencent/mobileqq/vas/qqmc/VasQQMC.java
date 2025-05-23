package com.tencent.mobileqq.vas.qqmc;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.freesia.NetworkResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u0019*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0014\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH&J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0017\u0010\u000f\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0001\u0010\u0001*\u00020\u0002\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000bH\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/vas/qqmc/VasQQMC;", "T", "Lcom/tencent/freesia/IConfigData;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/vas/qqmc/IVasUnitedConfigManager;", "()V", "doOnConfigUpdate", "", DownloadInfo.spKey_Config, "(Lcom/tencent/freesia/IConfigData;)V", "getGroup", "", "isSwitchOn", "", AdMetricTag.FALLBACK, "loadConfig", "()Lcom/tencent/freesia/IConfigData;", "loadRawConfig", "", "onReceiveNotUpdate", "result", "Lcom/tencent/freesia/NetworkResult;", "onRemoved", "onSend", "version", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public abstract class VasQQMC<T extends IConfigData> extends BaseConfigParser<T> implements IVasUnitedConfigManager {

    @NotNull
    private static final String TAG = "VasQQMC";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    public void doOnConfigUpdate(@Nullable T config) {
        super.doOnConfigUpdate(config);
        com.tencent.xaction.log.b.a(TAG, 4, "doOnConfigUpdate:" + config);
    }

    @NotNull
    public abstract String getGroup();

    @Override // com.tencent.mobileqq.vas.qqmc.IVasUnitedConfigManager
    public final boolean isSwitchOn(boolean fallback) {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(getGroup(), fallback);
    }

    @Override // com.tencent.mobileqq.vas.qqmc.IVasUnitedConfigManager
    @Nullable
    public final <T extends IConfigData> T loadConfig() {
        return (T) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(getGroup());
    }

    @Override // com.tencent.mobileqq.vas.qqmc.IVasUnitedConfigManager
    @Nullable
    public final byte[] loadRawConfig(@NotNull byte[] fallback) {
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(getGroup(), fallback);
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onReceiveNotUpdate(@NotNull NetworkResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        super.onReceiveNotUpdate(result);
        com.tencent.xaction.log.b.a(TAG, 4, "onReceiveNotUpdate:" + result);
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onRemoved() {
        super.onRemoved();
        com.tencent.xaction.log.b.a(TAG, 4, "onRemoved");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onSend(@NotNull String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        super.onSend(version);
        com.tencent.xaction.log.b.a(TAG, 4, "onSend:" + version);
    }
}

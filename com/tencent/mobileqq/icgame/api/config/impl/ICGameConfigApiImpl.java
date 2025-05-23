package com.tencent.mobileqq.icgame.api.config.impl;

import com.google.gson.Gson;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.config.IICGameConfigApi;
import com.tencent.mobileqq.icgame.api.config.SinglePrimaryData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$SecurityData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J5\u0010\u0003\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\t2\u0006\u0010\n\u001a\u0002H\u0004H\u0016\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/config/impl/ICGameConfigApiImpl;", "Lcom/tencent/mobileqq/icgame/api/config/IICGameConfigApi;", "()V", "getConfigBean", "T", "", "key", "", "clazz", "Ljava/lang/Class;", "defVal", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;", "getRawConfig", "getSinglePrimaryData", "Lcom/tencent/mobileqq/icgame/api/config/SinglePrimaryData;", QAdRewardDefine$SecurityData.DATA_KEY, "isSwitchOn", "", AdMetricTag.FALLBACK, "Companion", "ic-game-common-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class ICGameConfigApiImpl implements IICGameConfigApi {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Deprecated
    @NotNull
    private static final String TAG = "ICGameIICGameConfigApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/config/impl/ICGameConfigApiImpl$Companion;", "", "()V", "TAG", "", "ic-game-common-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.config.IICGameConfigApi
    @NotNull
    public <T> T getConfigBean(@NotNull String key, @NotNull Class<T> clazz, @NotNull T defVal) {
        Object obj;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(defVal, "defVal");
        boolean z16 = false;
        byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(key, new byte[0]);
        if (loadRawConfig.length == 0) {
            z16 = true;
        }
        if (z16) {
            return defVal;
        }
        try {
            obj = new Gson().fromJson(new String(loadRawConfig, Charsets.UTF_8), (Class<Object>) clazz);
        } catch (Exception e16) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e(TAG, "getBean toggleName=" + key + ",clazz=" + clazz + ",e=" + e16);
            obj = null;
        }
        if (obj != null) {
            return (T) obj;
        }
        return defVal;
    }

    @Override // com.tencent.mobileqq.icgame.api.config.IICGameConfigApi
    @NotNull
    public String getRawConfig(@NotNull String key, @NotNull String defVal) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defVal, "defVal");
        boolean z16 = false;
        byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(key, new byte[0]);
        if (loadRawConfig.length == 0) {
            z16 = true;
        }
        if (z16) {
            return defVal;
        }
        return new String(loadRawConfig, Charsets.UTF_8);
    }

    @Override // com.tencent.mobileqq.icgame.api.config.IICGameConfigApi
    @NotNull
    public SinglePrimaryData getSinglePrimaryData(@NotNull String key, @NotNull String dataKey) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(dataKey, "dataKey");
        return new SinglePrimaryData(key, dataKey, getRawConfig(key, ""));
    }

    @Override // com.tencent.mobileqq.icgame.api.config.IICGameConfigApi
    public boolean isSwitchOn(@NotNull String key, boolean fallback) {
        Intrinsics.checkNotNullParameter(key, "key");
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(key, fallback);
    }
}

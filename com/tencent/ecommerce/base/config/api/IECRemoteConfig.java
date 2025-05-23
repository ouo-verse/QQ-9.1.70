package com.tencent.ecommerce.base.config.api;

import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vf0.ECTabExpEntityInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J-\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H'\u00a2\u0006\u0004\b\b\u0010\tJ%\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u000b\u0010\fJ-\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u000e\u0010\tJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u0005H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/base/config/api/IECRemoteConfig;", "", "T", "", "configId", "", "key", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getConfig", "(ILjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "toggleName", "getFeatureToggleConfig", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "unitedConfigId", "getUnitedConfig", ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME, "Lvf0/a;", "getTabConfig", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECRemoteConfig {
    @Deprecated(message = "\u795e\u706f\u914d\u7f6e\u5373\u5c06\u4e0b\u67b6,\u540e\u7eed\u65b0\u7684\u914d\u7f6e\u5efa\u8bae\u4f7f\u7528getTabConfig")
    <T> T getConfig(int configId, @NotNull String key, T defaultValue);

    <T> T getFeatureToggleConfig(@NotNull String toggleName, T defaultValue);

    @Nullable
    ECTabExpEntityInfo getTabConfig(@NotNull String expName);

    <T> T getUnitedConfig(int unitedConfigId, @NotNull String key, T defaultValue);
}

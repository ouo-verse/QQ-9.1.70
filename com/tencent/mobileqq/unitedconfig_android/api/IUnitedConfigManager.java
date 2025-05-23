package com.tencent.mobileqq.unitedconfig_android.api;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import py2.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J(\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH&J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH&J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000fH&J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H&J&\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH&J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\u0006\u0010\u0013\u001a\u00020\u0004H&J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001e\u0010\u001c\u001a\u00020\f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\u0006\u0010\u001b\u001a\u00020\fH&J\u001e\u0010\u001d\u001a\u00020\n2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\u0006\u0010\u001b\u001a\u00020\fH'\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/unitedconfig_android/api/IUnitedConfigManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/freesia/IConfigData;", "T", "", VipFunCallConstants.KEY_GROUP, "loadConfig", "(Ljava/lang/String;)Lcom/tencent/freesia/IConfigData;", "Lpy2/a;", "callback", "", "loadLargeConfigAsync", "", AdMetricTag.FALLBACK, "isSwitchOn", "", "loadRawConfig", "loadAsString", "loadLargeConfigAsStringAsync", "businessId", "Ljava/util/ArrayList;", "getGroups", "getResourcePath", "", "getConfigVersion", "removeLocal", "groups", "callBackIfNotUpdate", "fetch", "fetchSwitch", "unitedconfig_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IUnitedConfigManager extends QRouteApi {
    boolean fetch(@NotNull ArrayList<String> groups, boolean callBackIfNotUpdate);

    @Deprecated(message = "\u5f00\u5173\u7c7b\u578b\u914d\u7f6e\u5df2\u4e0d\u518d\u4f7f\u7528")
    void fetchSwitch(@NotNull ArrayList<String> groups, boolean callBackIfNotUpdate);

    int getConfigVersion(@NotNull String group);

    @NotNull
    ArrayList<String> getGroups(@NotNull String businessId);

    @Nullable
    String getResourcePath(@NotNull String group);

    boolean isSwitchOn(@NotNull String group, boolean fallback);

    @NotNull
    String loadAsString(@NotNull String group, @NotNull String fallback);

    @Nullable
    <T extends IConfigData> T loadConfig(@NotNull String group);

    void loadLargeConfigAsStringAsync(@NotNull String group, @NotNull String fallback, @NotNull a<String> callback);

    <T extends IConfigData> void loadLargeConfigAsync(@NotNull String group, @NotNull a<T> callback);

    @NotNull
    byte[] loadRawConfig(@NotNull String group, @NotNull byte[] fallback);

    void removeLocal(@NotNull String group);
}

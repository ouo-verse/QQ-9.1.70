package com.tencent.qqnt.aio.api;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&J#\u0010\n\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/api/IAIOUniteConfigApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/freesia/IConfigData;", "T", "", VipFunCallConstants.KEY_GROUP, "Lcom/tencent/qqnt/aio/api/a;", "callback", "", "loadLargeConfigAsync", "loadConfig", "(Ljava/lang/String;)Lcom/tencent/freesia/IConfigData;", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOUniteConfigApi extends QRouteApi {
    @Nullable
    <T extends IConfigData> T loadConfig(@NotNull String group);

    <T extends IConfigData> void loadLargeConfigAsync(@NotNull String group, @NotNull a<T> callback);
}

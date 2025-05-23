package com.tencent.guild.api.aio.panel;

import com.tencent.aio.part.root.panel.mvx.config.b;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import zq0.AioPanelParam;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/guild/api/aio/panel/IPanelProviderFactoryApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lzq0/b;", "params", "Lcom/tencent/aio/part/root/panel/mvx/config/b;", "getEmotionPanelProvider", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IPanelProviderFactoryApi extends QRouteApi {
    @NotNull
    b getEmotionPanelProvider(@NotNull AioPanelParam params);
}

package com.tencent.timi.game.jump.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/timi/game/jump/api/IQQLiveDefinitionApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getDefinitionLevel", "", "roomId", "timi-game-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes26.dex */
public interface IQQLiveDefinitionApi extends QRouteApi {
    @Nullable
    String getDefinitionLevel(@NotNull String roomId);
}

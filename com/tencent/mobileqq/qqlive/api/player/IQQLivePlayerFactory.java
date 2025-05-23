package com.tencent.mobileqq.qqlive.api.player;

import com.tencent.mobileqq.qqlive.player.IQQLivePlayer;
import com.tencent.mobileqq.qqlive.sail.model.player.PlayerConfig;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/player/IQQLivePlayerFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getQQLivePlayer", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQLivePlayerFactory extends QRouteApi {
    @NotNull
    IQQLivePlayer getQQLivePlayer(@NotNull PlayerConfig config);
}

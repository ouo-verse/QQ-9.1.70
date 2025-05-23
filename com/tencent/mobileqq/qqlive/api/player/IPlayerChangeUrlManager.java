package com.tencent.mobileqq.qqlive.api.player;

import com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QRouteFactory(singleton = false)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0012J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/player/IPlayerChangeUrlManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getChangedUrl", "", "callback", "Lcom/tencent/mobileqq/qqlive/api/player/IPlayerChangeUrlManager$Callback;", "getUrlByDefinition", "", "targetDefinition", "Lcom/tencent/mobileqq/qqlive/data/room/EnterRoomInfo$VideoDefinition;", "hasChangeUrl", "", "init", "roomId", "", "needChangeUrl", "playerErrorCode", "", "Callback", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IPlayerChangeUrlManager extends QRouteApi {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/player/IPlayerChangeUrlManager$Callback;", "", "onError", "", "errCode", "", "errMsg", "", "onResult", "url", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public interface Callback {
        void onError(long errCode, @NotNull String errMsg);

        void onResult(@NotNull String url);
    }

    void getChangedUrl(@NotNull Callback callback);

    @NotNull
    String getUrlByDefinition(@Nullable EnterRoomInfo.VideoDefinition targetDefinition);

    boolean hasChangeUrl();

    void init(long roomId);

    boolean needChangeUrl(int playerErrorCode);
}

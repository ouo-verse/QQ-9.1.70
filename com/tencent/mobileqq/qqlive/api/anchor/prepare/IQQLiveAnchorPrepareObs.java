package com.tencent.mobileqq.qqlive.api.anchor.prepare;

import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J&\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\fH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/anchor/prepare/IQQLiveAnchorPrepareObs;", "Lcom/tencent/mobileqq/qqlive/api/anchor/prepare/IQQLiveAnchorPrepareSubModule;", "exitObsRoom", "", "programId", "", "getPushInfo", "roomInfo", "Lcom/tencent/mobileqq/qqlive/data/anchor/room/QQLiveAnchorRoomInfo;", "params", "Lcom/tencent/mobileqq/qqlive/data/anchor/params/QQLiveAnchorAutoCheckPullPlayParams;", "callback", "Lcom/tencent/mobileqq/qqlive/callback/anchor/IQQLiveAnchorRoomThirdPushCallback;", "startCheck", "stopCheck", "updateLiveStatCallback", "anchorRoomThirdPushCallback", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public interface IQQLiveAnchorPrepareObs extends IQQLiveAnchorPrepareSubModule {
    void exitObsRoom(@NotNull String programId);

    void getPushInfo(@Nullable QQLiveAnchorRoomInfo roomInfo, @Nullable QQLiveAnchorAutoCheckPullPlayParams params, @Nullable IQQLiveAnchorRoomThirdPushCallback callback);

    void startCheck();

    void stopCheck();

    void updateLiveStatCallback(@Nullable IQQLiveAnchorRoomThirdPushCallback anchorRoomThirdPushCallback);
}

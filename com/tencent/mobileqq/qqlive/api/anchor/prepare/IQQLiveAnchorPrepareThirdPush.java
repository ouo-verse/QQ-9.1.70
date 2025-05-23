package com.tencent.mobileqq.qqlive.api.anchor.prepare;

import android.view.ViewGroup;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;

/* loaded from: classes17.dex */
public interface IQQLiveAnchorPrepareThirdPush extends IQQLiveAnchorPrepareSubModule {
    void getPullInfo(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo, QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams, IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback);

    void getPushInfo(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo, QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams, IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback);

    void setNeedCallbackPlayerError(boolean z16);

    void setPreViewContainer(ViewGroup viewGroup);

    void startCheck(String str, QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams, IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback);

    void stopCheck();
}

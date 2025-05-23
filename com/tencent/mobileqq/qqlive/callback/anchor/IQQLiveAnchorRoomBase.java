package com.tencent.mobileqq.qqlive.callback.anchor;

import com.tencent.mobileqq.qqlive.api.anchor.QQLiveAnchorRoomState;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.data.common.QQLiveEventMsg;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveAnchorRoomBase {
    void onError(QQLiveErrorMsg qQLiveErrorMsg);

    void onEvent(QQLiveEventMsg qQLiveEventMsg);

    void onStateChange(QQLiveAnchorRoomState qQLiveAnchorRoomState, QQLiveAnchorRoomState qQLiveAnchorRoomState2);
}

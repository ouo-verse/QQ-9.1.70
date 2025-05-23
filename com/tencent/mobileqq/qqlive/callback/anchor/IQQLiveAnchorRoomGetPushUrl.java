package com.tencent.mobileqq.qqlive.callback.anchor;

import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;

/* loaded from: classes17.dex */
public interface IQQLiveAnchorRoomGetPushUrl extends IQQLiveAnchorRoomBase {
    void onGetPushInfo(QQLiveAnchorDataPushInfo qQLiveAnchorDataPushInfo);

    void onStartGetPushInfo();
}

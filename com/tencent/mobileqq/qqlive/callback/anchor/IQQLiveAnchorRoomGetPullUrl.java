package com.tencent.mobileqq.qqlive.callback.anchor;

import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;

/* loaded from: classes17.dex */
public interface IQQLiveAnchorRoomGetPullUrl extends IQQLiveAnchorRoomBase {
    void onGetPullInfo(QQLiveAnchorDataPullInfo qQLiveAnchorDataPullInfo);

    void onStartGetPullInfo();

    void onThirdPushChecked(QQLiveAnchorDataThirdPushCheck qQLiveAnchorDataThirdPushCheck);
}

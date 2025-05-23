package com.tencent.mobileqq.qqlive.callback.anchor;

import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataAuth;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;

/* loaded from: classes17.dex */
public interface IQQLiveAnchorRoomPrepare extends IQQLiveAnchorRoomBase {
    void onFaceAuth(QQLiveAnchorDataAuth qQLiveAnchorDataAuth);

    void onPrepare(QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare);

    void onStartFaceAuth();

    void onStartPrepare();
}

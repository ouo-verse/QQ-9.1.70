package com.tencent.mobileqq.qqlive.callback.anchor;

import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveAnchorRoomEnter extends IQQLiveAnchorRoomBase {
    void onEnter(QQLiveAnchorDataEnter qQLiveAnchorDataEnter);

    void onEnterRoom();

    void onStartEnter();
}

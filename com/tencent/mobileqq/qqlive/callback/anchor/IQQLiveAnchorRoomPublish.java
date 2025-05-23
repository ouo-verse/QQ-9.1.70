package com.tencent.mobileqq.qqlive.callback.anchor;

import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPublishStream;

/* loaded from: classes17.dex */
public interface IQQLiveAnchorRoomPublish extends IQQLiveAnchorRoomBase {
    void onPublishStream(QQLiveAnchorDataPublishStream qQLiveAnchorDataPublishStream);

    void onStartPublishStream();
}

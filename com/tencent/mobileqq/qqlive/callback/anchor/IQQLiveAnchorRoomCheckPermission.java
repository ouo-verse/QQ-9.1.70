package com.tencent.mobileqq.qqlive.callback.anchor;

import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataCheckPermission;

/* loaded from: classes17.dex */
public interface IQQLiveAnchorRoomCheckPermission extends IQQLiveAnchorRoomBase {
    void onCheckPermission(QQLiveAnchorDataCheckPermission qQLiveAnchorDataCheckPermission);

    void onStartCheckPermission();
}

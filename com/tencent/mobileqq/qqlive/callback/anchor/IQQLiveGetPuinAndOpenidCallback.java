package com.tencent.mobileqq.qqlive.callback.anchor;

import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorPuinAndOpenid;

/* loaded from: classes17.dex */
public interface IQQLiveGetPuinAndOpenidCallback {
    void onFail(int i3, String str);

    void onSuccess(QQLiveAnchorPuinAndOpenid qQLiveAnchorPuinAndOpenid);
}

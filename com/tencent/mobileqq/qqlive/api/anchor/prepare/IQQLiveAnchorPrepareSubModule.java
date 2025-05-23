package com.tencent.mobileqq.qqlive.api.anchor.prepare;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;

/* loaded from: classes17.dex */
public interface IQQLiveAnchorPrepareSubModule {
    void destroy();

    void init(IQQLiveSDK iQQLiveSDK);

    void onSelected(boolean z16);
}

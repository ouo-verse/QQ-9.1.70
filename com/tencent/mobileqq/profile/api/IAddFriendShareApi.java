package com.tencent.mobileqq.profile.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IAddFriendShareApi extends QRouteApi {
    void openMyQRCode();

    void shareSelfToWeiXin();
}

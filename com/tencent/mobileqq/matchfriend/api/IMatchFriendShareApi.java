package com.tencent.mobileqq.matchfriend.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMatchFriendShareApi extends QRouteApi {
    void reportShareSendEvent(Context context, AppInterface appInterface, int i3, String str);
}

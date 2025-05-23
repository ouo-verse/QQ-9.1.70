package com.tencent.mobileqq.matchfriend.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMatchFriendLocalCache extends QRouteApi {
    void cleanCache(Context context);
}

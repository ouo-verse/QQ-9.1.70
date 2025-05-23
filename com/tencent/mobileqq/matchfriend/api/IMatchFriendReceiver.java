package com.tencent.mobileqq.matchfriend.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMatchFriendReceiver extends QRouteApi {
    public static final String KEY_IS_FROM_MATCH_FRIEND = "key_is_from_match_friend";

    void onReceive(AppRuntime appRuntime, Context context, Intent intent);
}

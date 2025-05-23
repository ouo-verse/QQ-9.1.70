package com.tencent.mobileqq.utils.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IContactUtils extends QRouteApi {
    String getAccountNickName(AppInterface appInterface, String str);

    String getBuddyNickName(AppRuntime appRuntime, String str, boolean z16);

    String getFriendNickName(AppInterface appInterface, String str);
}

package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildInnerKeyboardApi extends QRouteApi {
    void clickCallbackButton(String str, long j3, long j16, long j17, long j18, String str2, vw1.a aVar);

    void permissionRole(String str, String str2, String str3, String[] strArr, vw1.b bVar);
}

package com.tencent.mobileqq.avatar.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRemote;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IQQAvatarBroadcastApi extends QRouteApi {
    @QRemote
    boolean checkIsBroadcastRegister(boolean z16);

    @QRemote
    List<String> queryAvatarByUin(List<String> list);

    @QRemote
    void resetBroadcastRegisterState();
}

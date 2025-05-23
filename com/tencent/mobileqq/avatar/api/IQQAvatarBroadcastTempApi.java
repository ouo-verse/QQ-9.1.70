package com.tencent.mobileqq.avatar.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes11.dex */
public interface IQQAvatarBroadcastTempApi extends QRouteApi {
    boolean isBroadcastRegister();

    List<String> queryAvatarByUin(List<String> list);

    void registerBroadcast();

    void resetBroadcastRegisterState();
}

package com.tencent.mobileqq.profilecard.api;

import com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IRelationBlacklistApi extends QRouteApi {
    boolean isEnableBlackList();

    void sendAddBlacklistRequest(String str, RelationBlacklistListener relationBlacklistListener);

    void sendBlacklistCheckRequest(String str, RelationBlacklistListener relationBlacklistListener);

    void sendDeleteBlacklistRequest(String str, RelationBlacklistListener relationBlacklistListener);

    void sendGetShieldListNumberRequest(RelationBlacklistListener relationBlacklistListener);

    void sendShieldListTransferRequest(RelationBlacklistListener relationBlacklistListener);
}

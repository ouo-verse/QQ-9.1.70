package com.tencent.mobileqq.addfriend.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes10.dex */
public interface IAddFriendServiceApi extends IRuntimeService {
    boolean hasSendAddFriendReq(String str);

    boolean hasSendAddFriendReq(String str, boolean z16);

    boolean hasSendAddFriendReq(String str, boolean z16, boolean z17);

    void setAddFriendReqStatus(String str, boolean z16);
}

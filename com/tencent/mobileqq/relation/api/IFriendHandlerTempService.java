package com.tencent.mobileqq.relation.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes17.dex */
public interface IFriendHandlerTempService extends IRuntimeService {
    void getFriendInfo(String str);

    void getFriendInfo(String str, boolean z16);

    void getOnlineInfo(String str, boolean z16);
}

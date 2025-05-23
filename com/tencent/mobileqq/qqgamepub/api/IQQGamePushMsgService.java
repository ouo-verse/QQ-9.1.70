package com.tencent.mobileqq.qqgamepub.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(needUin = false, process = {"all"})
/* loaded from: classes16.dex */
public interface IQQGamePushMsgService extends IRuntimeService {
    boolean isFollowPubAccount(String str);

    void onReceivePushMsg(String str, int i3);

    void reportPushMsgClicked(String str);
}

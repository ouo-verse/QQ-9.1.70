package com.tencent.mobileqq.gamecenter.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IGameMsgStrangerRulesApi extends QRouteApi {
    public static final String GAME_MSG_SP_KEY_ADD_FRIEND_INFO = "game_msg_sp_key_add_friend_info_";
    public static final String GAME_MSG_SP_KEY_SAY_HELLO = "game_msg_sp_key_say_hello_";
    public static final String GAME_MSG_SP_KEY_SEND_MSG_WITHOUT_REPLY = "game_msg_sp_key_send_msg_without_reply_";

    void doInit(AppInterface appInterface, String str, int i3);

    boolean isAbleToAction();

    void recordAction();
}

package com.tencent.mobileqq.icgame.api.room;

import a32.a;
import b32.e;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface ILiveRoomMessage {
    void registerAnnounceMessageListener(IQQLiveAnnouncePushListener iQQLiveAnnouncePushListener);

    void registerAudienceInfoListener(a aVar);

    void registerFollowMessageListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener);

    void registerHighPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback);

    void registerLivePushChannel(int i3, IQQCmdPushCallback iQQCmdPushCallback);

    void registerLowPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback);

    void registerOnReceiveFloatHeartListener(ji2.a aVar);

    void registerReceiveGiftMessageListener(v22.a aVar);

    void registerReceiveLuckyBagMessageListener(x22.a aVar);

    void registerRoomChatMsgListener(y22.a aVar);

    void registerRoomFollowListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener);

    void registerRoomStatusListener(e eVar);

    void registerSystemMsgListener(y22.a aVar);

    void unRegisterAnnounceMessageListener(IQQLiveAnnouncePushListener iQQLiveAnnouncePushListener);

    void unRegisterAudienceInfoListener(a aVar);

    void unRegisterFollowMessageListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener);

    void unRegisterHighPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback);

    void unRegisterLivePushChannel(IQQCmdPushCallback iQQCmdPushCallback);

    void unRegisterLowPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback);

    void unRegisterOnReceiveFloatHeartListener(ji2.a aVar);

    void unRegisterReceiveGiftMessageListener(v22.a aVar);

    void unRegisterReceiveLuckyBagMessageListener(x22.a aVar);

    void unRegisterRoomChatMsgListener(y22.a aVar);

    void unRegisterRoomFollowListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener);

    void unRegisterRoomStatusListener(e eVar);

    void unRegisterSystemMsgListener(y22.a aVar);
}

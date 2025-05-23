package com.tencent.mobileqq.qqlive.api.room;

import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.callback.luckybag.ReceiveLuckyBagMessageListener;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveReceiveMessageListener;
import com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener;
import com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener;
import com.tencent.mobileqq.qqlive.callback.userlevel.IQQLiveUserLevelChangeListener;
import ji2.a;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface ILiveRoomMessage {
    void registerAnnounceMessageListener(IQQLiveAnnouncePushListener iQQLiveAnnouncePushListener);

    void registerAudienceInfoListener(RoomAudienceInfoListener roomAudienceInfoListener);

    void registerFollowMessageListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener);

    void registerHighPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback);

    void registerLivePushChannel(int i3, IQQCmdPushCallback iQQCmdPushCallback);

    void registerLowPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback);

    void registerOnReceiveFloatHeartListener(a aVar);

    void registerReceiveGiftMessageListener(ReceiveGiftMessageListener receiveGiftMessageListener);

    void registerReceiveLuckyBagMessageListener(ReceiveLuckyBagMessageListener receiveLuckyBagMessageListener);

    void registerRoomChatMsgListener(IQQLiveReceiveMessageListener iQQLiveReceiveMessageListener);

    void registerRoomFollowListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener);

    void registerRoomStatusListener(LiveRoomStatusListener liveRoomStatusListener);

    void registerSystemMsgListener(IQQLiveReceiveMessageListener iQQLiveReceiveMessageListener);

    void registerUserLevelChangedListener(IQQLiveUserLevelChangeListener iQQLiveUserLevelChangeListener);

    void unRegisterAnnounceMessageListener(IQQLiveAnnouncePushListener iQQLiveAnnouncePushListener);

    void unRegisterAudienceInfoListener(RoomAudienceInfoListener roomAudienceInfoListener);

    void unRegisterFollowMessageListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener);

    void unRegisterHighPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback);

    void unRegisterLivePushChannel(IQQCmdPushCallback iQQCmdPushCallback);

    void unRegisterLowPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback);

    void unRegisterOnReceiveFloatHeartListener(a aVar);

    void unRegisterReceiveGiftMessageListener(ReceiveGiftMessageListener receiveGiftMessageListener);

    void unRegisterReceiveLuckyBagMessageListener(ReceiveLuckyBagMessageListener receiveLuckyBagMessageListener);

    void unRegisterRoomChatMsgListener(IQQLiveReceiveMessageListener iQQLiveReceiveMessageListener);

    void unRegisterRoomFollowListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener);

    void unRegisterRoomStatusListener(LiveRoomStatusListener liveRoomStatusListener);

    void unRegisterSystemMsgListener(IQQLiveReceiveMessageListener iQQLiveReceiveMessageListener);

    void unRegisterUserLevelChangedListener(IQQLiveUserLevelChangeListener iQQLiveUserLevelChangeListener);
}

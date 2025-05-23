package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes24.dex */
public interface IKernelGProGuildMsgListener {
    void onBeaconReportCount(GProBeaconEventModel gProBeaconEventModel, GProBeaconStageModel gProBeaconStageModel);

    void onBeaconReportStage(GProBeaconEventModel gProBeaconEventModel, ArrayList<GProBeaconStageModel> arrayList);

    void onFeedEventUpdate(FirstViewDirectMsgNotifyInfo firstViewDirectMsgNotifyInfo);

    void onGuildAvChannelOpenUpdate(GProAvChannelStateMsg gProAvChannelStateMsg);

    void onGuildCheckInNotify(GProCheckInNotifyInfo gProCheckInNotifyInfo);

    void onGuildHelperNotifySwitchUpdate(HashMap<Integer, Integer> hashMap);

    void onGuildInteractiveUpdate(GuildInteractiveNotificationItem guildInteractiveNotificationItem);

    void onGuildManagerEventUpdate(GProManagerNotice gProManagerNotice);

    void onGuildNewPostEvent(GProNewPostAndSystemPromptNotifyFeedEventData gProNewPostAndSystemPromptNotifyFeedEventData);

    void onGuildScheduleNotify(GProScheduleNotifyInfo gProScheduleNotifyInfo);

    void onGuildTopFeedUpdate(GProGuildTopFeedMsg gProGuildTopFeedMsg);

    void onMsgAbstractUpdate(ArrayList<MsgAbstract> arrayList);

    void onUnreadCntAfterFirstView(HashMap<Integer, ArrayList<GProUnreadCntInfo>> hashMap);

    void onUnreadCntUpdate(HashMap<Integer, ArrayList<GProUnreadCntInfo>> hashMap);
}

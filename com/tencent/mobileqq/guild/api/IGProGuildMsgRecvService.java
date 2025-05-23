package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernelgpro.nativeinterface.FirstViewDirectMsgNotifyInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAvChannelStateMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCheckInNotifyInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildTopFeedMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProManagerNotice;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNewPostAndSystemPromptNotifyFeedEventData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleNotifyInfo;
import java.util.HashMap;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Service(process = {""})
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u001c\u0010\u000f\u001a\u00020\u00032\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH&\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGProGuildMsgRecvService;", "Lmqq/app/api/IRuntimeService;", "onAVChannel2Msg", "", "avChannelStateMsg", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProAvChannelStateMsg;", "onFeed2Msg", "msg", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/FirstViewDirectMsgNotifyInfo;", "onFeedTop2Msg", "topFeedMsg", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildTopFeedMsg;", "onGuildCheckInNotify", "checkInNotifyInfo", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProCheckInNotifyInfo;", "onGuildHelperNotifySwitchUpdate", "switchValue", "Ljava/util/HashMap;", "", "onGuildNewPostEvent", "data", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProNewPostAndSystemPromptNotifyFeedEventData;", "onGuildScheduleNotify", "scheduleNotifyInfo", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProScheduleNotifyInfo;", "onManageNotice2Msg", "manageNotice", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProManagerNotice;", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public interface IGProGuildMsgRecvService extends IRuntimeService {
    void onAVChannel2Msg(@NotNull GProAvChannelStateMsg avChannelStateMsg);

    void onFeed2Msg(@NotNull FirstViewDirectMsgNotifyInfo msg2);

    void onFeedTop2Msg(@NotNull GProGuildTopFeedMsg topFeedMsg);

    void onGuildCheckInNotify(@NotNull GProCheckInNotifyInfo checkInNotifyInfo);

    void onGuildHelperNotifySwitchUpdate(@NotNull HashMap<Integer, Integer> switchValue);

    void onGuildNewPostEvent(@NotNull GProNewPostAndSystemPromptNotifyFeedEventData data);

    void onGuildScheduleNotify(@NotNull GProScheduleNotifyInfo scheduleNotifyInfo);

    void onManageNotice2Msg(@NotNull GProManagerNotice manageNotice);
}

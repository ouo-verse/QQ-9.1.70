package com.tencent.mobileqq.guild.message.eventflow.api;

import androidx.annotation.Nullable;
import bu1.b;
import com.tencent.imcore.message.f;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.IRuntimeService;
import tencent.im.group_pro_proto.common.common$Event;
import tencent.im.group_pro_proto.common.common$Msg;
import tencent.im.group_pro_proto.synclogic.synclogic$ChannelMsgRsp;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes14.dex */
public interface IGuildEventFlowService extends IRuntimeService {
    boolean isGuildRoamMessageEventFlowProcessorNull();

    boolean needUpdateMsgContent(MessageRecord messageRecord, MessageRecord messageRecord2);

    void onChatMessageExposure(String str, String str2, ArrayList<b> arrayList);

    void onPullRoamMsgEventFlowRsp(boolean z16, ToServiceMsg toServiceMsg, synclogic$ChannelMsgRsp synclogic_channelmsgrsp, ArrayList<common$Msg> arrayList);

    boolean processEvent(@Nullable MessageRecord messageRecord, common$Event common_event, String str, String str2, long j3);

    void processEvents(@Nullable MessageRecord messageRecord, List<common$Event> list, String str, String str2, long j3);

    boolean processUpdateEvent(f fVar, MessageRecord messageRecord, MessageRecord messageRecord2);

    void updateEventFlowContent(MessageRecord messageRecord, MessageRecord messageRecord2);

    boolean updateReplyMsgCommentForSourceMsg(MessageRecord messageRecord, MessageRecord messageRecord2, boolean z16, boolean z17);
}

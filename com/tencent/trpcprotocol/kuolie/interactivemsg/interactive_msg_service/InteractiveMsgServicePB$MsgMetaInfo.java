package com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.trpcprotocol.kuolie.feed_plaza_svr.feed_plaza_svr.FeedPlazaSvrPB$FeedMeta;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$InteractiveOption;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;

/* loaded from: classes38.dex */
public final class InteractiveMsgServicePB$MsgMetaInfo extends MessageMicro<InteractiveMsgServicePB$MsgMetaInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 48, 58, 64, 74, 80, 88, 98}, new String[]{"msg_id", ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME, "inter_emoj_id", "peer_mini_profile", "feed_meta", "flag_msg_status", "summary", "is_read", "msg_info", "scene_id", "is_comment_delete", "quick_reply"}, new Object[]{"", 0L, 0, null, null, 0, "", Boolean.FALSE, null, 0, 0, null}, InteractiveMsgServicePB$MsgMetaInfo.class);
    public final PBStringField msg_id = PBField.initString("");
    public final PBUInt64Field msg_time = PBField.initUInt64(0);
    public final PBUInt32Field inter_emoj_id = PBField.initUInt32(0);
    public userInfo$MiniInfo peer_mini_profile = new userInfo$MiniInfo();
    public FeedPlazaSvrPB$FeedMeta feed_meta = new FeedPlazaSvrPB$FeedMeta();
    public final PBEnumField flag_msg_status = PBField.initEnum(0);
    public final PBStringField summary = PBField.initString("");
    public final PBBoolField is_read = PBField.initBool(false);
    public InteractiveMsgServicePB$MsgInfo msg_info = new InteractiveMsgServicePB$MsgInfo();
    public final PBEnumField scene_id = PBField.initEnum(0);
    public final PBUInt32Field is_comment_delete = PBField.initUInt32(0);
    public Prompt$InteractiveOption quick_reply = new Prompt$InteractiveOption();
}

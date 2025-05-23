package com.tencent.mobileqq.comment.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class oidb_0xdea$RspBody extends MessageMicro<oidb_0xdea$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"add_barrage_rsp", "get_barrage_list_rsp", "rpt_recall_barrage_rsp_list", "rpt_delete_barrage_rsp_list", "get_topic_rsp", "get_comment_rsp"}, new Object[]{null, null, null, null, null, null}, oidb_0xdea$RspBody.class);
    public oidb_0xdea$AddBarrageRspBody add_barrage_rsp = new MessageMicro<oidb_0xdea$AddBarrageRspBody>() { // from class: com.tencent.mobileqq.comment.oidb.oidb_0xdea$AddBarrageRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"int32_ret_code", "str_err_msg", "str_wording"}, new Object[]{0, "", ""}, oidb_0xdea$AddBarrageRspBody.class);
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_err_msg = PBField.initString("");
        public final PBStringField str_wording = PBField.initString("");
    };
    public oidb_0xdea$GetBarrageListRspBody get_barrage_list_rsp = new oidb_0xdea$GetBarrageListRspBody();
    public final PBRepeatMessageField<oidb_0xdea$RecallBarrageRspBody> rpt_recall_barrage_rsp_list = PBField.initRepeatMessage(oidb_0xdea$RecallBarrageRspBody.class);
    public final PBRepeatMessageField<oidb_0xdea$DeleteBarrageRspBody> rpt_delete_barrage_rsp_list = PBField.initRepeatMessage(oidb_0xdea$DeleteBarrageRspBody.class);
    public oidb_0xdea$GetTopicRspBody get_topic_rsp = new MessageMicro<oidb_0xdea$GetTopicRspBody>() { // from class: com.tencent.mobileqq.comment.oidb.oidb_0xdea$GetTopicRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xdea$GetTopicRspBody.class);
    };
    public oidb_0xdea$GetCommentRspBody get_comment_rsp = new MessageMicro<oidb_0xdea$GetCommentRspBody>() { // from class: com.tencent.mobileqq.comment.oidb.oidb_0xdea$GetCommentRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xdea$GetCommentRspBody.class);
    };
}

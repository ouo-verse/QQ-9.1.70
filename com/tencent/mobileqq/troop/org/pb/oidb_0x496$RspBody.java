package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class oidb_0x496$RspBody extends MessageMicro<oidb_0x496$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50}, new String[]{"rpt_msg_seq_info", "uint64_max_aio_msg", "uint64_max_position_msg", "msg_group_msg_config", "robot_config", "aio_keyword_config"}, new Object[]{null, 0L, 0L, null, null, null}, oidb_0x496$RspBody.class);
    public final PBRepeatMessageField<oidb_0x496$MsgSeqInfo> rpt_msg_seq_info = PBField.initRepeatMessage(oidb_0x496$MsgSeqInfo.class);
    public final PBUInt64Field uint64_max_aio_msg = PBField.initUInt64(0);
    public final PBUInt64Field uint64_max_position_msg = PBField.initUInt64(0);
    public oidb_0x496$GroupMsgConfig msg_group_msg_config = new oidb_0x496$GroupMsgConfig();
    public oidb_0x496$Robot robot_config = new oidb_0x496$Robot();
    public oidb_0x496$AioKeyword aio_keyword_config = new oidb_0x496$AioKeyword();
}

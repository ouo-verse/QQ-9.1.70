package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class oidb_0x496$MsgSeqInfo extends MessageMicro<oidb_0x496$MsgSeqInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uint64_group_code", "rpt_manager_uin_list", "uint64_update_time", "uint64_first_unread_manager_msg_seq", "rpt_uint64_manager_msg_seq"}, new Object[]{0L, 0L, 0L, 0L, 0L}, oidb_0x496$MsgSeqInfo.class);
    public final PBRepeatField<Long> rpt_manager_uin_list;
    public final PBRepeatField<Long> rpt_uint64_manager_msg_seq;
    public final PBUInt64Field uint64_first_unread_manager_msg_seq;
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_update_time;

    public oidb_0x496$MsgSeqInfo() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.rpt_manager_uin_list = PBField.initRepeat(pBUInt64Field);
        this.uint64_update_time = PBField.initUInt64(0L);
        this.uint64_first_unread_manager_msg_seq = PBField.initUInt64(0L);
        this.rpt_uint64_manager_msg_seq = PBField.initRepeat(pBUInt64Field);
    }
}

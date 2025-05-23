package com.tencent.mobileqq.vas.bubble.diy;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class BubbleDiyComu$Bubble_Req extends MessageMicro<BubbleDiyComu$Bubble_Req> {
    public static final int CMD_FIELD_NUMBER = 1;
    public static final int COMM_FIELD_NUMBER = 3;
    public static final int PACKET_SEQ_FIELD_NUMBER = 2;
    public static final int REQCMD_0X01_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"cmd", "packet_seq", "comm", "reqcmd_0x01"}, new Object[]{0, 0L, null, null}, BubbleDiyComu$Bubble_Req.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt64Field packet_seq = PBField.initUInt64(0);
    public BubbleDiyComu$Bubble_Req_Comm comm = new BubbleDiyComu$Bubble_Req_Comm();
    public BubbleDiyComu$Bubble_GetDiyText_Req reqcmd_0x01 = new BubbleDiyComu$Bubble_GetDiyText_Req();
}

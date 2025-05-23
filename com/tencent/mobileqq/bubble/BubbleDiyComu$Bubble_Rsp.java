package com.tencent.mobileqq.bubble;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class BubbleDiyComu$Bubble_Rsp extends MessageMicro<BubbleDiyComu$Bubble_Rsp> {
    public static final int CMD_FIELD_NUMBER = 3;
    public static final int COMM_FIELD_NUMBER = 5;
    public static final int ERRMSG_FIELD_NUMBER = 2;
    public static final int PACKET_SEQ_FIELD_NUMBER = 4;
    public static final int RET_FIELD_NUMBER = 1;
    public static final int RSPCMD_0X01_FIELD_NUMBER = 6;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50}, new String[]{"ret", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "cmd", "packet_seq", "comm", "rspcmd_0x01"}, new Object[]{0L, "", 0, 0L, null, null}, BubbleDiyComu$Bubble_Rsp.class);
    public final PBInt64Field ret = PBField.initInt64(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt64Field packet_seq = PBField.initUInt64(0);
    public BubbleDiyComu$Bubble_Rsp_Comm comm = new MessageMicro<BubbleDiyComu$Bubble_Rsp_Comm>() { // from class: com.tencent.mobileqq.bubble.BubbleDiyComu$Bubble_Rsp_Comm
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], BubbleDiyComu$Bubble_Rsp_Comm.class);
    };
    public BubbleDiyComu$Bubble_GetDiyText_Rsp rspcmd_0x01 = new BubbleDiyComu$Bubble_GetDiyText_Rsp();
}

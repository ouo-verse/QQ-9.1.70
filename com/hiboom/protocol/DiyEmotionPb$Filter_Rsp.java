package com.hiboom.protocol;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes2.dex */
public final class DiyEmotionPb$Filter_Rsp extends MessageMicro<DiyEmotionPb$Filter_Rsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50}, new String[]{"ret", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "cmd", "packet_seq", "comm", "rspcmd_0x01"}, new Object[]{0L, "", 0, 0L, null, null}, DiyEmotionPb$Filter_Rsp.class);
    public final PBInt64Field ret = PBField.initInt64(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt64Field packet_seq = PBField.initUInt64(0);
    public DiyEmotionPb$Filter_Rsp_Comm comm = new MessageMicro<DiyEmotionPb$Filter_Rsp_Comm>() { // from class: com.hiboom.protocol.DiyEmotionPb$Filter_Rsp_Comm
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], DiyEmotionPb$Filter_Rsp_Comm.class);
    };
    public DiyEmotionPb$Filter_Text_Rsp rspcmd_0x01 = new MessageMicro<DiyEmotionPb$Filter_Text_Rsp>() { // from class: com.hiboom.protocol.DiyEmotionPb$Filter_Text_Rsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_valid"}, new Object[]{Boolean.FALSE}, DiyEmotionPb$Filter_Text_Rsp.class);
        public final PBRepeatField<Boolean> is_valid = PBField.initRepeat(PBBoolField.__repeatHelper__);
    };
}

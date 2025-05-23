package com.hiboom.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* loaded from: classes2.dex */
public final class DiyEmotionPb$Filter_Req extends MessageMicro<DiyEmotionPb$Filter_Req> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"cmd", "packet_seq", "comm", "reqcmd_0x01"}, new Object[]{0, 0L, null, null}, DiyEmotionPb$Filter_Req.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt64Field packet_seq = PBField.initUInt64(0);
    public DiyEmotionPb$Filter_Req_Comm comm = new MessageMicro<DiyEmotionPb$Filter_Req_Comm>() { // from class: com.hiboom.protocol.DiyEmotionPb$Filter_Req_Comm
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"platform", TPReportKeys.Common.COMMON_OS_VERSION, "mqqver"}, new Object[]{0L, "", ""}, DiyEmotionPb$Filter_Req_Comm.class);
        public final PBInt64Field platform = PBField.initInt64(0);
        public final PBStringField osver = PBField.initString("");
        public final PBStringField mqqver = PBField.initString("");
    };
    public DiyEmotionPb$Filter_Text_Req reqcmd_0x01 = new MessageMicro<DiyEmotionPb$Filter_Text_Req>() { // from class: com.hiboom.protocol.DiyEmotionPb$Filter_Text_Req
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"text"}, new Object[]{""}, DiyEmotionPb$Filter_Text_Req.class);
        public final PBRepeatField<String> text = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
}

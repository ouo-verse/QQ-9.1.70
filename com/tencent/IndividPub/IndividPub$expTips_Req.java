package com.tencent.IndividPub;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* loaded from: classes3.dex */
public final class IndividPub$expTips_Req extends MessageMicro<IndividPub$expTips_Req> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"cmd", "packet_seq", "comm", "reqcmd_0x01"}, new Object[]{0, 0L, null, null}, IndividPub$expTips_Req.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt64Field packet_seq = PBField.initUInt64(0);
    public IndividPub$Platform_Comm_Req comm = new MessageMicro<IndividPub$Platform_Comm_Req>() { // from class: com.tencent.IndividPub.IndividPub$Platform_Comm_Req
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"platForm", TPReportKeys.Common.COMMON_OS_VERSION, "mqqver"}, new Object[]{0L, "", ""}, IndividPub$Platform_Comm_Req.class);
        public final PBInt64Field platForm = PBField.initInt64(0);
        public final PBStringField osver = PBField.initString("");
        public final PBStringField mqqver = PBField.initString("");
    };
    public IndividPub$expTips_Pull_Req reqcmd_0x01 = new MessageMicro<IndividPub$expTips_Pull_Req>() { // from class: com.tencent.IndividPub.IndividPub$expTips_Pull_Req
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"from"}, new Object[]{0}, IndividPub$expTips_Pull_Req.class);
        public final PBUInt32Field from = PBField.initUInt32(0);
    };
}

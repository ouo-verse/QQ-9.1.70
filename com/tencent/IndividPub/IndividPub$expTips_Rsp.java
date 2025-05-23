package com.tencent.IndividPub;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes3.dex */
public final class IndividPub$expTips_Rsp extends MessageMicro<IndividPub$expTips_Rsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50}, new String[]{"ret", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "cmd", "packet_seq", "comm", "rspcmd_0x01"}, new Object[]{0L, "", 0, 0L, null, null}, IndividPub$expTips_Rsp.class);
    public final PBInt64Field ret = PBField.initInt64(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt64Field packet_seq = PBField.initUInt64(0);
    public IndividPub$Platform_Comm_Rsp comm = new MessageMicro<IndividPub$Platform_Comm_Rsp>() { // from class: com.tencent.IndividPub.IndividPub$Platform_Comm_Rsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], IndividPub$Platform_Comm_Rsp.class);
    };
    public IndividPub$expTips_Pull_Rsp rspcmd_0x01 = new MessageMicro<IndividPub$expTips_Pull_Rsp>() { // from class: com.tencent.IndividPub.IndividPub$expTips_Pull_Rsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 48}, new String[]{"expFlag", "content", "clickText", "action", "url", "itemId"}, new Object[]{0, "", "", 0, "", 0}, IndividPub$expTips_Pull_Rsp.class);
        public final PBUInt32Field expFlag = PBField.initUInt32(0);
        public final PBStringField content = PBField.initString("");
        public final PBStringField clickText = PBField.initString("");
        public final PBEnumField action = PBField.initEnum(0);
        public final PBStringField url = PBField.initString("");
        public final PBUInt32Field itemId = PBField.initUInt32(0);
    };
}

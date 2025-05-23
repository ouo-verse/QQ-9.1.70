package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import mqq.app.MainService;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SummaryCardBusiEntry$CommonReq extends MessageMicro<SummaryCardBusiEntry$CommonReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{MainService.SERVICE_CMD, "vcReq", "hrReq"}, new Object[]{"", null, null}, SummaryCardBusiEntry$CommonReq.class);
    public final PBStringField serviceCmd = PBField.initString("");
    public SummaryCardBusiEntry$VisitorCountReq vcReq = new MessageMicro<SummaryCardBusiEntry$VisitorCountReq>() { // from class: com.tencent.pb.profilecard.SummaryCardBusiEntry$VisitorCountReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"requireuin", "operuin", "mod", "reportFlag"}, new Object[]{0, 0, 0, 0}, SummaryCardBusiEntry$VisitorCountReq.class);
        public final PBUInt32Field requireuin = PBField.initUInt32(0);
        public final PBUInt32Field operuin = PBField.initUInt32(0);
        public final PBInt32Field mod = PBField.initInt32(0);
        public final PBInt32Field reportFlag = PBField.initInt32(0);
    };
    public SummaryCardBusiEntry$HideRecordsReq hrReq = new MessageMicro<SummaryCardBusiEntry$HideRecordsReq>() { // from class: com.tencent.pb.profilecard.SummaryCardBusiEntry$HideRecordsReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"huin", "fuin", "records"}, new Object[]{0, 0, null}, SummaryCardBusiEntry$HideRecordsReq.class);
        public final PBUInt32Field huin = PBField.initUInt32(0);
        public final PBUInt32Field fuin = PBField.initUInt32(0);
        public final PBRepeatMessageField<SummaryCardBusiEntry$DetailRecord> records = PBField.initRepeatMessage(SummaryCardBusiEntry$DetailRecord.class);
    };
}

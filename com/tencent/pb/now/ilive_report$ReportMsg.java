package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_report$ReportMsg extends MessageMicro<ilive_report$ReportMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 56, 64, 74, 82}, new String[]{"informer", "type", "source_key", VRReportDefine$ReportParam.REPORT_REASON, "platform", "version", "reportee", "from", "sub_source_key", "comment_info"}, new Object[]{0L, 0, "", "", 0, "", 0L, 0, "", null}, ilive_report$ReportMsg.class);
    public final PBUInt64Field informer = PBField.initUInt64(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField source_key = PBField.initString("");
    public final PBStringField report_reason = PBField.initString("");
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField version = PBField.initString("");
    public final PBUInt64Field reportee = PBField.initUInt64(0);
    public final PBUInt32Field from = PBField.initUInt32(0);
    public final PBStringField sub_source_key = PBField.initString("");
    public ilive_report$CommentInfo comment_info = new MessageMicro<ilive_report$CommentInfo>() { // from class: com.tencent.pb.now.ilive_report$CommentInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"time", "content"}, new Object[]{0L, ""}, ilive_report$CommentInfo.class);
        public final PBUInt64Field time = PBField.initUInt64(0);
        public final PBStringField content = PBField.initString("");
    };
}

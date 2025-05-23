package com.tencent.ecommerce.repo.proto.ecom.realtime_reportsvr;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.repo.proto.ecom.common_comm.ECComm$ReqExt;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECRealtimeReportsvr$ReportReq extends MessageMicro<ECRealtimeReportsvr$ReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 402}, new String[]{WadlProxyConsts.CHANNEL, "req_ext", "operation_type", "media_id", "product", "terminal_real_report"}, new Object[]{0, null, 0, "", null, null}, ECRealtimeReportsvr$ReportReq.class);
    public final PBUInt32Field channel = PBField.initUInt32(0);
    public ECComm$ReqExt req_ext = new ECComm$ReqExt();
    public final PBUInt32Field operation_type = PBField.initUInt32(0);
    public final PBStringField media_id = PBField.initString("");
    public ECRealtimeReportsvr$Product product = new MessageMicro<ECRealtimeReportsvr$Product>() { // from class: com.tencent.ecommerce.repo.proto.ecom.realtime_reportsvr.ECRealtimeReportsvr$Product
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "saas_type", "price", "commission"}, new Object[]{"", "", 0L, 0L}, ECRealtimeReportsvr$Product.class);
        public final PBStringField product_id = PBField.initString("");
        public final PBStringField saas_type = PBField.initString("");
        public final PBInt64Field price = PBField.initInt64(0);
        public final PBInt64Field commission = PBField.initInt64(0);
    };
    public ECRealtimeReportsvr$TerminalReal terminal_real_report = new MessageMicro<ECRealtimeReportsvr$TerminalReal>() { // from class: com.tencent.ecommerce.repo.proto.ecom.realtime_reportsvr.ECRealtimeReportsvr$TerminalReal
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"event_code", "report_kv"}, new Object[]{"", null}, ECRealtimeReportsvr$TerminalReal.class);
        public final PBStringField event_code = PBField.initString("");
        public final PBRepeatMessageField<ECRealtimeReportsvr$ReportKV> report_kv = PBField.initRepeatMessage(ECRealtimeReportsvr$ReportKV.class);
    };
}

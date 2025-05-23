package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import NS_MINI_PUBLIC.Head$QAPPHead;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qzone.QZoneHelper;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StDegXtionItem extends MessageMicro<MiniAppMidasPay$StDegXtionItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"header", "body"}, new Object[]{null, null}, MiniAppMidasPay$StDegXtionItem.class);
    public Head$QAPPHead header = new MessageMicro<Head$QAPPHead>() { // from class: NS_MINI_PUBLIC.Head$QAPPHead
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 48, 58, 66, 72, 82, 90, 96, 104, 114, 122, 130, 138}, new String[]{"str_userip", "str_module", "str_cmdname", "uint64_seq", "str_qua", "uint64_loglevel", "str_logdepth", "auth_info", "retcode", "retmsg", QZoneHelper.INTENT_EXTINFO, "reqFrm", "logSeq", "colorLink", "deviceInfo", "trace", "all_trace"}, new Object[]{"", "", "", 0L, "", 0L, "", null, 0L, "", null, 1, 0L, null, "", null, null}, Head$QAPPHead.class);
        public final PBStringField str_userip = PBField.initString("");
        public final PBStringField str_module = PBField.initString("");
        public final PBStringField str_cmdname = PBField.initString("");
        public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
        public final PBStringField str_qua = PBField.initString("");
        public final PBUInt64Field uint64_loglevel = PBField.initUInt64(0);
        public final PBStringField str_logdepth = PBField.initString("");
        public Head$AuthInfo auth_info = new MessageMicro<Head$AuthInfo>() { // from class: NS_MINI_PUBLIC.Head$AuthInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"uint32_type", "str_uid", "bytes_sig", "str_appid", QZoneHelper.INTENT_EXTINFO}, new Object[]{0, "", ByteStringMicro.EMPTY, "", null}, Head$AuthInfo.class);
            public final PBUInt32Field uint32_type = PBField.initUInt32(0);
            public final PBStringField str_uid = PBField.initString("");
            public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBStringField str_appid = PBField.initString("");
            public final PBRepeatMessageField<COMM.Entry> extinfo = PBField.initRepeatMessage(COMM.Entry.class);
        };
        public final PBInt64Field retcode = PBField.initInt64(0);
        public final PBStringField retmsg = PBField.initString("");
        public final PBRepeatMessageField<COMM.Entry> extinfo = PBField.initRepeatMessage(COMM.Entry.class);
        public final PBEnumField reqFrm = PBField.initEnum(1);
        public final PBUInt64Field logSeq = PBField.initUInt64(0);
        public Head$StColorLink colorLink = new MessageMicro<Head$StColorLink>() { // from class: NS_MINI_PUBLIC.Head$StColorLink
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"links", "soft_level"}, new Object[]{null, 0}, Head$StColorLink.class);
            public final PBRepeatMessageField<Head$StColorItem> links = PBField.initRepeatMessage(Head$StColorItem.class);
            public final PBInt32Field soft_level = PBField.initInt32(0);
        };
        public final PBStringField deviceInfo = PBField.initString("");
        public Head$StLinkTrace trace = new MessageMicro<Head$StLinkTrace>() { // from class: NS_MINI_PUBLIC.Head$StLinkTrace
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"traceId", TPReportKeys.LiveExKeys.LIVE_FX_SPANID, "parentSpanId", "sampled"}, new Object[]{0L, 0L, 0L, 0}, Head$StLinkTrace.class);
            public final PBUInt64Field traceId = PBField.initUInt64(0);
            public final PBUInt64Field spanId = PBField.initUInt64(0);
            public final PBUInt64Field parentSpanId = PBField.initUInt64(0);
            public final PBInt32Field sampled = PBField.initInt32(0);
        };
        public Head$StAllLinkTrace all_trace = new MessageMicro<Head$StAllLinkTrace>() { // from class: NS_MINI_PUBLIC.Head$StAllLinkTrace
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"traceId", TPReportKeys.LiveExKeys.LIVE_FX_SPANID, "parentSpanId", "sampled"}, new Object[]{"", "", "", 0}, Head$StAllLinkTrace.class);
            public final PBStringField traceId = PBField.initString("");
            public final PBStringField spanId = PBField.initString("");
            public final PBStringField parentSpanId = PBField.initString("");
            public final PBInt32Field sampled = PBField.initInt32(0);
        };
    };
    public MiniAppMidasPay$StGamePayReq body = new MiniAppMidasPay$StGamePayReq();
}

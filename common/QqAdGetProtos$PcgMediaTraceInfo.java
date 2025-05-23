package common;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class QqAdGetProtos$PcgMediaTraceInfo extends MessageMicro<QqAdGetProtos$PcgMediaTraceInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 66, 74, 82}, new String[]{"timestamp", "media_type", ReportDataBuilder.KEY_PRODUCT_ID, "scene", "content_id", "trace_id", "buyer_id", "seller_id", "ext_info", "seller_grade"}, new Object[]{0L, 0, 0L, 0, "", "", "", "", "", ""}, QqAdGetProtos$PcgMediaTraceInfo.class);
    public final PBUInt64Field timestamp = PBField.initUInt64(0);
    public final PBInt32Field media_type = PBField.initInt32(0);
    public final PBUInt64Field product_id = PBField.initUInt64(0);
    public final PBInt32Field scene = PBField.initInt32(0);
    public final PBStringField content_id = PBField.initString("");
    public final PBStringField trace_id = PBField.initString("");
    public final PBStringField buyer_id = PBField.initString("");
    public final PBStringField seller_id = PBField.initString("");
    public final PBStringField ext_info = PBField.initString("");
    public final PBStringField seller_grade = PBField.initString("");
}

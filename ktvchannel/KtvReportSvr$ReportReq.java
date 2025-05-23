package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvReportSvr$ReportReq extends MessageMicro<KtvReportSvr$ReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 58, 66, 74, 82, 90}, new String[]{"uid", "account_source", "device_info", "imei", "app_version", "platform", "qua", "key", "act_id", "opertime", "vec_info"}, new Object[]{0L, 0L, "", "", "", 0, "", "", "", "", null}, KtvReportSvr$ReportReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt64Field account_source = PBField.initUInt64(0);
    public final PBStringField device_info = PBField.initString("");
    public final PBStringField imei = PBField.initString("");
    public final PBStringField app_version = PBField.initString("");
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField qua = PBField.initString("");
    public final PBStringField key = PBField.initString("");
    public final PBStringField act_id = PBField.initString("");
    public final PBStringField opertime = PBField.initString("");
    public final PBRepeatMessageField<KtvCommon$KVItem> vec_info = PBField.initRepeatMessage(KtvCommon$KVItem.class);
}

package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class FudaiActiveReport$PkgReq extends MessageMicro<FudaiActiveReport$PkgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"user_comm_report", "fd_config", "resource_download", "exception_handle", "active_report"}, new Object[]{null, null, null, null, null}, FudaiActiveReport$PkgReq.class);
    public FudaiActiveReport$UserCommReport user_comm_report = new MessageMicro<FudaiActiveReport$UserCommReport>() { // from class: fudai.FudaiActiveReport$UserCommReport
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBStringField imei = PBField.initString("");
        public final PBDoubleField longitude = PBField.initDouble(0.0d);
        public final PBDoubleField latitude = PBField.initDouble(0.0d);
        public final PBStringField city_code = PBField.initString("");
        public final PBEnumField net_type = PBField.initEnum(1);
        public final PBUInt32Field from_id = PBField.initUInt32(0);
        public final PBStringField mobile_type = PBField.initString("");
        public final PBStringField qua = PBField.initString("");

        static {
            Double valueOf = Double.valueOf(0.0d);
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 17, 25, 34, 40, 48, 58, 66}, new String[]{"imei", "longitude", "latitude", "city_code", "net_type", "from_id", "mobile_type", "qua"}, new Object[]{"", valueOf, valueOf, "", 1, 0, "", ""}, FudaiActiveReport$UserCommReport.class);
        }
    };
    public final PBRepeatMessageField<FudaiActiveReport$FdConfig> fd_config = PBField.initRepeatMessage(FudaiActiveReport$FdConfig.class);
    public final PBRepeatMessageField<FudaiActiveReport$ResourceDownload> resource_download = PBField.initRepeatMessage(FudaiActiveReport$ResourceDownload.class);
    public final PBRepeatMessageField<FudaiActiveReport$ExceptionHandle> exception_handle = PBField.initRepeatMessage(FudaiActiveReport$ExceptionHandle.class);
    public final PBRepeatMessageField<FudaiActiveReport$ActiveReportReq> active_report = PBField.initRepeatMessage(FudaiActiveReport$ActiveReportReq.class);
}

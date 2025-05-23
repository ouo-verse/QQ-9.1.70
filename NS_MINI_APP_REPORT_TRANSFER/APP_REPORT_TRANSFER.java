package NS_MINI_APP_REPORT_TRANSFER;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qzone.QZoneHelper;

/* loaded from: classes.dex */
public final class APP_REPORT_TRANSFER {
    public static final int Atta0db00017361 = 16;
    public static final int DC04239 = 2;
    public static final int DC04266 = 3;
    public static final int DC04682 = 7;
    public static final int DC05325 = 10;
    public static final int DC05332 = 14;
    public static final int DC05337 = 11;
    public static final int DC05373 = 12;
    public static final int DC05374 = 13;

    /* loaded from: classes.dex */
    public static final class SingleDcData extends MessageMicro<SingleDcData> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"dcid", "report_data", QZoneHelper.INTENT_EXTINFO}, new Object[]{0, null, null}, SingleDcData.class);
        public final PBUInt32Field dcid = PBField.initUInt32(0);
        public final PBRepeatMessageField<COMM.Entry> report_data = PBField.initRepeatMessage(COMM.Entry.class);
        public final PBRepeatMessageField<COMM.Entry> extinfo = PBField.initRepeatMessage(COMM.Entry.class);
    }

    /* loaded from: classes.dex */
    public static final class StDataReportReq extends MessageMicro<StDataReportReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"dcdata"}, new Object[]{null}, StDataReportReq.class);
        public final PBRepeatMessageField<SingleDcData> dcdata = PBField.initRepeatMessage(SingleDcData.class);
    }

    /* loaded from: classes.dex */
    public static final class StDataReportRsp extends MessageMicro<StDataReportRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"ret"}, new Object[]{0}, StDataReportRsp.class);
        public final PBInt32Field ret = PBField.initInt32(0);
    }

    APP_REPORT_TRANSFER() {
    }
}

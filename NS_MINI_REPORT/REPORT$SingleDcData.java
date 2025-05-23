package NS_MINI_REPORT;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qzone.QZoneHelper;

/* loaded from: classes.dex */
public final class REPORT$SingleDcData extends MessageMicro<REPORT$SingleDcData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"type", "dcid", "report_data", QZoneHelper.INTENT_EXTINFO}, new Object[]{"", 0, null, null}, REPORT$SingleDcData.class);
    public final PBStringField type = PBField.initString("");
    public final PBUInt32Field dcid = PBField.initUInt32(0);
    public final PBRepeatMessageField<COMM.Entry> report_data = PBField.initRepeatMessage(COMM.Entry.class);
    public final PBRepeatMessageField<COMM.Entry> extinfo = PBField.initRepeatMessage(COMM.Entry.class);
}

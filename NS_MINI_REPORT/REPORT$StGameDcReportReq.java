package NS_MINI_REPORT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes.dex */
public final class REPORT$StGameDcReportReq extends MessageMicro<REPORT$StGameDcReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"dcdata"}, new Object[]{null}, REPORT$StGameDcReportReq.class);
    public final PBRepeatMessageField<REPORT$SingleDcData> dcdata = PBField.initRepeatMessage(REPORT$SingleDcData.class);
}

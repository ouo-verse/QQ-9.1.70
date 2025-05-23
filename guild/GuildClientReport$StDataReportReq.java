package guild;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GuildClientReport$StDataReportReq extends MessageMicro<GuildClientReport$StDataReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{null}, GuildClientReport$StDataReportReq.class);
    public final PBRepeatMessageField<GuildClientReport$SingleTableData> data = PBField.initRepeatMessage(GuildClientReport$SingleTableData.class);
}

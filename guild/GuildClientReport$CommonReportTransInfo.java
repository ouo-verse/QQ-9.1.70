package guild;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GuildClientReport$CommonReportTransInfo extends MessageMicro<GuildClientReport$CommonReportTransInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"report_data"}, new Object[]{null}, GuildClientReport$CommonReportTransInfo.class);
    public final PBRepeatMessageField<GuildCommon$Entry> report_data = PBField.initRepeatMessage(GuildCommon$Entry.class);
}

package guild;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GuildClientReport$SingleTableData extends MessageMicro<GuildClientReport$SingleTableData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"tableID", "reportData", "extInfo", "byteExtInfo"}, new Object[]{0, null, null, null}, GuildClientReport$SingleTableData.class);
    public final PBUInt32Field tableID = PBField.initUInt32(0);
    public final PBRepeatMessageField<GuildCommon$Entry> reportData = PBField.initRepeatMessage(GuildCommon$Entry.class);
    public final PBRepeatMessageField<GuildCommon$Entry> extInfo = PBField.initRepeatMessage(GuildCommon$Entry.class);
    public final PBRepeatMessageField<GuildCommon$BytesEntry> byteExtInfo = PBField.initRepeatMessage(GuildCommon$BytesEntry.class);
}

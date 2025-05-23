package guild;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GuildVideoUrlExchange$GetVideoAdaptReq extends MessageMicro<GuildVideoUrlExchange$GetVideoAdaptReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"userID", "videos", "from", "bizType"}, new Object[]{"", null, 0, 0}, GuildVideoUrlExchange$GetVideoAdaptReq.class);
    public final PBStringField userID = PBField.initString("");
    public final PBRepeatMessageField<GuildVideoUrlExchange$Video> videos = PBField.initRepeatMessage(GuildVideoUrlExchange$Video.class);
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBInt32Field bizType = PBField.initInt32(0);
}

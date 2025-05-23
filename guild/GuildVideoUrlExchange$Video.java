package guild;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GuildVideoUrlExchange$Video extends MessageMicro<GuildVideoUrlExchange$Video> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50, 56, 64, 72, 82}, new String[]{"fileID", "fileSize", "duration", "width", "height", "playURL", "transStatus", "videoPrior", "videoRate", "AlterVideoURL"}, new Object[]{"", 0, 0, 0, 0, "", 0, 0, 0, null}, GuildVideoUrlExchange$Video.class);
    public final PBStringField fileID = PBField.initString("");
    public final PBUInt32Field fileSize = PBField.initUInt32(0);
    public final PBUInt32Field duration = PBField.initUInt32(0);
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBStringField playURL = PBField.initString("");
    public final PBUInt32Field transStatus = PBField.initUInt32(0);
    public final PBUInt32Field videoPrior = PBField.initUInt32(0);
    public final PBUInt32Field videoRate = PBField.initUInt32(0);
    public final PBRepeatMessageField<GuildVideoUrlExchange$VideoLevel> AlterVideoURL = PBField.initRepeatMessage(GuildVideoUrlExchange$VideoLevel.class);
}

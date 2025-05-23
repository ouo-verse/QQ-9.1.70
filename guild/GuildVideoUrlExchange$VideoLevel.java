package guild;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GuildVideoUrlExchange$VideoLevel extends MessageMicro<GuildVideoUrlExchange$VideoLevel> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48}, new String[]{"levelType", "playURL", "videoPrior", "videoRate", "transStatus", "hasWatermark"}, new Object[]{0, "", 0, 0, 0, Boolean.FALSE}, GuildVideoUrlExchange$VideoLevel.class);
    public final PBUInt32Field levelType = PBField.initUInt32(0);
    public final PBStringField playURL = PBField.initString("");
    public final PBUInt32Field videoPrior = PBField.initUInt32(0);
    public final PBUInt32Field videoRate = PBField.initUInt32(0);
    public final PBUInt32Field transStatus = PBField.initUInt32(0);
    public final PBBoolField hasWatermark = PBField.initBool(false);
}

package guild;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GuildVideoUrlExchange$GetVideoAdaptRsp extends MessageMicro<GuildVideoUrlExchange$GetVideoAdaptRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"videos"}, new Object[]{null}, GuildVideoUrlExchange$GetVideoAdaptRsp.class);
    public final PBRepeatMessageField<GuildVideoUrlExchange$Video> videos = PBField.initRepeatMessage(GuildVideoUrlExchange$Video.class);
}

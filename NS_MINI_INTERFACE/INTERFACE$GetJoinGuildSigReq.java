package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$GetJoinGuildSigReq extends MessageMicro<INTERFACE$GetJoinGuildSigReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"guild_id"}, new Object[]{""}, INTERFACE$GetJoinGuildSigReq.class);
    public final PBStringField guild_id = PBField.initString("");
}

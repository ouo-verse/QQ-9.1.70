package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$GetGuildInviteCodeRsp extends MessageMicro<INTERFACE$GetGuildInviteCodeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"invite_url"}, new Object[]{""}, INTERFACE$GetGuildInviteCodeRsp.class);
    public final PBStringField invite_url = PBField.initString("");
}

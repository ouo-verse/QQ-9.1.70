package guild;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GuildChannelBase$IdentityV3 extends MessageMicro<GuildChannelBase$IdentityV3> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{CommonConstant.ReqAccessTokenParam.CLIENT_ID, "identitys"}, new Object[]{0, null}, GuildChannelBase$IdentityV3.class);
    public final PBUInt32Field client_id = PBField.initUInt32(0);
    public final PBRepeatMessageField<GuildChannelBase$IdentityV2> identitys = PBField.initRepeatMessage(GuildChannelBase$IdentityV2.class);
}

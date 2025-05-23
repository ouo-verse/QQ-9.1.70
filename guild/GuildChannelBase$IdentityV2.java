package guild;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GuildChannelBase$IdentityV2 extends MessageMicro<GuildChannelBase$IdentityV2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"type", "value", "identity_type", "third_party_data"}, new Object[]{0, "", 0, ByteStringMicro.EMPTY}, GuildChannelBase$IdentityV2.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField value = PBField.initString("");
    public final PBEnumField identity_type = PBField.initEnum(0);
    public final PBBytesField third_party_data = PBField.initBytes(ByteStringMicro.EMPTY);
}

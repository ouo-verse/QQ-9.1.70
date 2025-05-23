package msf.msgsvc;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class msg_svc$AddressListTmp extends MessageMicro<msg_svc$AddressListTmp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40}, new String[]{"from_phone", "to_phone", "to_uin", PreloadTRTCPlayerParams.KEY_SIG, "from_contact_size"}, new Object[]{"", "", 0L, ByteStringMicro.EMPTY, 0}, msg_svc$AddressListTmp.class);
    public final PBStringField from_phone = PBField.initString("");
    public final PBStringField to_phone = PBField.initString("");
    public final PBUInt64Field to_uin = PBField.initUInt64(0);
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field from_contact_size = PBField.initUInt32(0);
}

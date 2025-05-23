package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$GetJoinGuildSigRsp extends MessageMicro<INTERFACE$GetJoinGuildSigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{50}, new String[]{"bytes_join_guild_sig"}, new Object[]{ByteStringMicro.EMPTY}, INTERFACE$GetJoinGuildSigRsp.class);
    public final PBRepeatField<ByteStringMicro> bytes_join_guild_sig = PBField.initRepeat(PBBytesField.__repeatHelper__);
}

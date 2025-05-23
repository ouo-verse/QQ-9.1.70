package msf.msgsvc;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class msg_svc$PubGroupTmp extends MessageMicro<msg_svc$PubGroupTmp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"to_uin", PreloadTRTCPlayerParams.KEY_SIG, "group_uin"}, new Object[]{0L, ByteStringMicro.EMPTY, 0L}, msg_svc$PubGroupTmp.class);
    public final PBUInt64Field to_uin = PBField.initUInt64(0);
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field group_uin = PBField.initUInt64(0);
}

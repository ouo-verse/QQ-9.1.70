package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class msg_svc$PbBindUinMsgReadedConfirmReq extends MessageMicro<msg_svc$PbBindUinMsgReadedConfirmReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"sync_cookie", "bind_uin"}, new Object[]{ByteStringMicro.EMPTY, 0L}, msg_svc$PbBindUinMsgReadedConfirmReq.class);
    public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field bind_uin = PBField.initUInt64(0);
}

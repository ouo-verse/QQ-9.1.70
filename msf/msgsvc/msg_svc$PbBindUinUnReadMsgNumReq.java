package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class msg_svc$PbBindUinUnReadMsgNumReq extends MessageMicro<msg_svc$PbBindUinUnReadMsgNumReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"bind_uin", "sync_cookie"}, new Object[]{0L, ByteStringMicro.EMPTY}, msg_svc$PbBindUinUnReadMsgNumReq.class);
    public final PBUInt64Field bind_uin = PBField.initUInt64(0);
    public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
}

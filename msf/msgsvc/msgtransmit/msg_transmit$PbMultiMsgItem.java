package msf.msgsvc.msgtransmit;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class msg_transmit$PbMultiMsgItem extends MessageMicro<msg_transmit$PbMultiMsgItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{WadlProxyConsts.PARAM_FILENAME, "buffer"}, new Object[]{"", ByteStringMicro.EMPTY}, msg_transmit$PbMultiMsgItem.class);
    public final PBStringField fileName = PBField.initString("");
    public final PBBytesField buffer = PBField.initBytes(ByteStringMicro.EMPTY);
}

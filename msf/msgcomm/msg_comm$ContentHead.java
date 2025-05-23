package msf.msgcomm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class msg_comm$ContentHead extends MessageMicro<msg_comm$ContentHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"pkg_num", "pkg_index", "div_seq", "auto_reply"}, new Object[]{0, 0, 0, 0}, msg_comm$ContentHead.class);
    public final PBUInt32Field pkg_num = PBField.initUInt32(0);
    public final PBUInt32Field pkg_index = PBField.initUInt32(0);
    public final PBUInt32Field div_seq = PBField.initUInt32(0);
    public final PBUInt32Field auto_reply = PBField.initUInt32(0);
}

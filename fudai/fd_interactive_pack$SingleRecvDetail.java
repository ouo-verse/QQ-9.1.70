package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class fd_interactive_pack$SingleRecvDetail extends MessageMicro<fd_interactive_pack$SingleRecvDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"uin", "nick", "ctime", "re_info"}, new Object[]{0L, "", 0, null}, fd_interactive_pack$SingleRecvDetail.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField nick = PBField.initString("");
    public final PBUInt32Field ctime = PBField.initUInt32(0);
    public fd_comm$GrabPack re_info = new fd_comm$GrabPack();
}

package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvCommon$ErrMsg extends MessageMicro<KtvCommon$ErrMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"code", "err_msg"}, new Object[]{0, ""}, KtvCommon$ErrMsg.class);
    public final PBInt32Field code = PBField.initInt32(0);
    public final PBStringField err_msg = PBField.initString("");
}

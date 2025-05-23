package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes.dex */
public final class INTERFACE$StTinyidOpenidPair extends MessageMicro<INTERFACE$StTinyidOpenidPair> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"tinyid", "openid"}, new Object[]{0L, ""}, INTERFACE$StTinyidOpenidPair.class);
    public final PBUInt64Field tinyid = PBField.initUInt64(0);
    public final PBStringField openid = PBField.initString("");
}

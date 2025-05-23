package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class INTERFACE$StAppPath extends MessageMicro<INTERFACE$StAppPath> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"appid", "path"}, new Object[]{"", ""}, INTERFACE$StAppPath.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField path = PBField.initString("");
}

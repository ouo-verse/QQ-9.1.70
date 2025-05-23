package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StExtConfigInfo extends MessageMicro<INTERFACE$StExtConfigInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"configKey", "configVersion", "dataBuf"}, new Object[]{"", "", ByteStringMicro.EMPTY}, INTERFACE$StExtConfigInfo.class);
    public final PBStringField configKey = PBField.initString("");
    public final PBStringField configVersion = PBField.initString("");
    public final PBBytesField dataBuf = PBField.initBytes(ByteStringMicro.EMPTY);
}

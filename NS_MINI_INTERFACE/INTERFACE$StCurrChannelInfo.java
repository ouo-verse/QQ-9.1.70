package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StCurrChannelInfo extends MessageMicro<INTERFACE$StCurrChannelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"refer", "via"}, new Object[]{"", ""}, INTERFACE$StCurrChannelInfo.class);
    public final PBStringField refer = PBField.initString("");
    public final PBStringField via = PBField.initString("");
}

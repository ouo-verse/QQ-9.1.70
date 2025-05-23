package NS_MINI_INTERFACE;

import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$GetWXAppURLReply extends MessageMicro<INTERFACE$GetWXAppURLReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"retCode", Global.TRACKING_URL}, new Object[]{0, ""}, INTERFACE$GetWXAppURLReply.class);
    public final PBInt32Field retCode = PBField.initInt32(0);
    public final PBStringField URL = PBField.initString("");
}

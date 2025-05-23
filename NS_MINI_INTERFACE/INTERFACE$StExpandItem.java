package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StExpandItem extends MessageMicro<INTERFACE$StExpandItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"appInfo", "icon", "name", "adId"}, new Object[]{null, "", "", 0}, INTERFACE$StExpandItem.class);
    public INTERFACE$StApiAppInfo appInfo = new INTERFACE$StApiAppInfo();
    public final PBStringField icon = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field adId = PBField.initUInt32(0);
}

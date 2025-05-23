package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StApiRightItem extends MessageMicro<INTERFACE$StApiRightItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"apiName", "secondName", "right"}, new Object[]{"", "", 0}, INTERFACE$StApiRightItem.class);
    public final PBStringField apiName = PBField.initString("");
    public final PBStringField secondName = PBField.initString("");
    public final PBInt32Field right = PBField.initInt32(0);
}

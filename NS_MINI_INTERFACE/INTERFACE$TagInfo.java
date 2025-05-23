package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$TagInfo extends MessageMicro<INTERFACE$TagInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"tagText", "tagColor", "tagType"}, new Object[]{"", "", 0}, INTERFACE$TagInfo.class);
    public final PBStringField tagText = PBField.initString("");
    public final PBStringField tagColor = PBField.initString("");
    public final PBInt32Field tagType = PBField.initInt32(0);
}

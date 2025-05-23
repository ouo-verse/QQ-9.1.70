package WEISHI_USER_GROWTH;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class WEISHI$stGetPersonalPageReq extends MessageMicro<WEISHI$stGetPersonalPageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"person_id", "type", "attach_info"}, new Object[]{"", 0, ""}, WEISHI$stGetPersonalPageReq.class);
    public final PBStringField person_id = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField attach_info = PBField.initString("");
}

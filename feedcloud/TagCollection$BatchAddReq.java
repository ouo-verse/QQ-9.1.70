package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class TagCollection$BatchAddReq extends MessageMicro<TagCollection$BatchAddReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"unified_type", "unified_id"}, new Object[]{"", ""}, TagCollection$BatchAddReq.class);
    public final PBStringField unified_type = PBField.initString("");
    public final PBRepeatField<String> unified_id = PBField.initRepeat(PBStringField.__repeatHelper__);
}

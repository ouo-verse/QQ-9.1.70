package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class TagCollection$DeleteReq extends MessageMicro<TagCollection$DeleteReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"unified_type", "unified_id"}, new Object[]{"", ""}, TagCollection$DeleteReq.class);
    public final PBStringField unified_type = PBField.initString("");
    public final PBStringField unified_id = PBField.initString("");
}

package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class TagCollection$ReadListReq extends MessageMicro<TagCollection$ReadListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"unified_type"}, new Object[]{""}, TagCollection$ReadListReq.class);
    public final PBStringField unified_type = PBField.initString("");
}

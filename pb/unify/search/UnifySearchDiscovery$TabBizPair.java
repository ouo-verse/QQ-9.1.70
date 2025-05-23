package pb.unify.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class UnifySearchDiscovery$TabBizPair extends MessageMicro<UnifySearchDiscovery$TabBizPair> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"key", "value"}, new Object[]{0, ""}, UnifySearchDiscovery$TabBizPair.class);
    public final PBInt32Field key = PBField.initInt32(0);
    public final PBStringField value = PBField.initString("");
}

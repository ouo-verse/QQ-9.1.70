package pb.unify.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchDiscovery$JumpLink extends MessageMicro<UnifySearchDiscovery$JumpLink> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"jump_type", "jump_url"}, new Object[]{0, ""}, UnifySearchDiscovery$JumpLink.class);
    public final PBInt32Field jump_type = PBField.initInt32(0);
    public final PBStringField jump_url = PBField.initString("");
}

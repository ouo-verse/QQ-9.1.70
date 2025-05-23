package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Follow$StCheckResult extends MessageMicro<Follow$StCheckResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"stars", "result"}, new Object[]{"", 0}, Follow$StCheckResult.class);
    public final PBStringField stars = PBField.initString("");
    public final PBInt32Field result = PBField.initInt32(0);
}

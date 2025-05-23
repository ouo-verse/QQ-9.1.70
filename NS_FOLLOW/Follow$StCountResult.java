package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Follow$StCountResult extends MessageMicro<Follow$StCountResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"follower", "retCode", "count"}, new Object[]{"", 0, 0}, Follow$StCountResult.class);
    public final PBStringField follower = PBField.initString("");
    public final PBInt32Field retCode = PBField.initInt32(0);
    public final PBUInt32Field count = PBField.initUInt32(0);
}

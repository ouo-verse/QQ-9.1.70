package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Follow$StBatchGetFollowerCountReq extends MessageMicro<Follow$StBatchGetFollowerCountReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"business", "stars"}, new Object[]{"", ""}, Follow$StBatchGetFollowerCountReq.class);
    public final PBStringField business = PBField.initString("");
    public final PBRepeatField<String> stars = PBField.initRepeat(PBStringField.__repeatHelper__);
}

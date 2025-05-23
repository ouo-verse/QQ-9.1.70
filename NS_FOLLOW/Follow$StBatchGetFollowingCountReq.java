package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Follow$StBatchGetFollowingCountReq extends MessageMicro<Follow$StBatchGetFollowingCountReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"business", "followers"}, new Object[]{"", ""}, Follow$StBatchGetFollowingCountReq.class);
    public final PBStringField business = PBField.initString("");
    public final PBRepeatField<String> followers = PBField.initRepeat(PBStringField.__repeatHelper__);
}

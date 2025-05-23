package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Follow$StBatchCheckFollowingNewReq extends MessageMicro<Follow$StBatchCheckFollowingNewReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"business", "followers", "stars"}, new Object[]{"", "", ""}, Follow$StBatchCheckFollowingNewReq.class);
    public final PBStringField business = PBField.initString("");
    public final PBStringField followers = PBField.initString("");
    public final PBRepeatField<String> stars = PBField.initRepeat(PBStringField.__repeatHelper__);
}

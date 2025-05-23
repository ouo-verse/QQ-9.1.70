package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Follow$StBatchCheckFollowReq extends MessageMicro<Follow$StBatchCheckFollowReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"business", "followers", "star"}, new Object[]{"", "", ""}, Follow$StBatchCheckFollowReq.class);
    public final PBStringField business = PBField.initString("");
    public final PBRepeatField<String> followers = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField star = PBField.initString("");
}

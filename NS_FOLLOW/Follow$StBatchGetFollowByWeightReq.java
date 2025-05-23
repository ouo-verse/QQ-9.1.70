package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Follow$StBatchGetFollowByWeightReq extends MessageMicro<Follow$StBatchGetFollowByWeightReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField business = PBField.initString("");
    public final PBRepeatField<String> followers = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBDoubleField startWeight = PBField.initDouble(0.0d);
    public final PBDoubleField endWeight = PBField.initDouble(0.0d);

    static {
        Double valueOf = Double.valueOf(0.0d);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 25, 33}, new String[]{"business", "followers", "startWeight", "endWeight"}, new Object[]{"", "", valueOf, valueOf}, Follow$StBatchGetFollowByWeightReq.class);
    }
}

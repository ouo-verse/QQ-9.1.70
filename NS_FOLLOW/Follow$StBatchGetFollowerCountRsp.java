package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Follow$StBatchGetFollowerCountRsp extends MessageMicro<Follow$StBatchGetFollowerCountRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"followersCount"}, new Object[]{0}, Follow$StBatchGetFollowerCountRsp.class);
    public final PBRepeatField<Integer> followersCount = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}

package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Follow$StBatchGetFollowingCountRsp extends MessageMicro<Follow$StBatchGetFollowingCountRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"followingCounts"}, new Object[]{null}, Follow$StBatchGetFollowingCountRsp.class);
    public final PBRepeatMessageField<Follow$StCountResult> followingCounts = PBField.initRepeatMessage(Follow$StCountResult.class);
}

package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Follow$StBatchGetFollowByWeightRsp extends MessageMicro<Follow$StBatchGetFollowByWeightRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"startList"}, new Object[]{null}, Follow$StBatchGetFollowByWeightRsp.class);
    public final PBRepeatMessageField<Follow$StStarList> startList = PBField.initRepeatMessage(Follow$StStarList.class);
}

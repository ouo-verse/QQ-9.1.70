package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Follow$StBatchCheckFollowingRsp extends MessageMicro<Follow$StBatchCheckFollowingRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"stars"}, new Object[]{null}, Follow$StBatchCheckFollowingRsp.class);
    public final PBRepeatMessageField<Follow$StStar> stars = PBField.initRepeatMessage(Follow$StStar.class);
}

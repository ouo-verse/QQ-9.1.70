package NS_FOLLOW;

import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Follow$StBatchCheckFollowingNewRsp extends MessageMicro<Follow$StBatchCheckFollowingNewRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{ForwardMiniChooseFriendOption.RESULT_LIST}, new Object[]{null}, Follow$StBatchCheckFollowingNewRsp.class);
    public final PBRepeatMessageField<Follow$StCheckResult> results = PBField.initRepeatMessage(Follow$StCheckResult.class);
}

package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StBatchCallFollowReq extends MessageMicro<FeedCloudWrite$StBatchCallFollowReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"uids"}, new Object[]{""}, FeedCloudWrite$StBatchCallFollowReq.class);
    public final PBRepeatField<String> uids = PBField.initRepeat(PBStringField.__repeatHelper__);
}

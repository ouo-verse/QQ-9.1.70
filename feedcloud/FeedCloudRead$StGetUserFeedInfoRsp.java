package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetUserFeedInfoRsp extends MessageMicro<FeedCloudRead$StGetUserFeedInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"lastPublishTime"}, new Object[]{0L}, FeedCloudRead$StGetUserFeedInfoRsp.class);
    public final PBRepeatField<Long> lastPublishTime = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}

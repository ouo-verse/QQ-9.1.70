package feedcloud;

import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class FeedCloudActivityLandingPage$GetActivityTopicListRsp extends MessageMicro<FeedCloudActivityLandingPage$GetActivityTopicListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{MessageForRichState.SIGN_MSG_TOPICS, "total", "is_finish"}, new Object[]{null, 0, Boolean.FALSE}, FeedCloudActivityLandingPage$GetActivityTopicListRsp.class);
    public final PBRepeatMessageField<FeedCloudActivityLandingPage$Topic> topics = PBField.initRepeatMessage(FeedCloudActivityLandingPage$Topic.class);
    public final PBInt32Field total = PBField.initInt32(0);
    public final PBBoolField is_finish = PBField.initBool(false);
}

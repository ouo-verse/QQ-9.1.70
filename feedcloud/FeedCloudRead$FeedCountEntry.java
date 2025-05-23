package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$FeedCountEntry extends MessageMicro<FeedCloudRead$FeedCountEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"vecFeed", "failFields", "invalidFeed"}, new Object[]{null, 0, Boolean.FALSE}, FeedCloudRead$FeedCountEntry.class);
    public FeedCloudMeta$StFeed vecFeed = new FeedCloudMeta$StFeed();
    public final PBRepeatField<Integer> failFields = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBBoolField invalidFeed = PBField.initBool(false);
}

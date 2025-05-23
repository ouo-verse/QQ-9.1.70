package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$Filter extends MessageMicro<FeedCloudRead$Filter> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"groups"}, new Object[]{null}, FeedCloudRead$Filter.class);
    public final PBRepeatMessageField<FeedCloudRead$FilterGroup> groups = PBField.initRepeatMessage(FeedCloudRead$FilterGroup.class);
}

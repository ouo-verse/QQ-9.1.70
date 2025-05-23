package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StExifInfo extends MessageMicro<FeedCloudMeta$StExifInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"kvs"}, new Object[]{null}, FeedCloudMeta$StExifInfo.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> kvs = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
}

package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StShareQzoneInfo extends MessageMicro<FeedCloudMeta$StShareQzoneInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"entrys"}, new Object[]{null}, FeedCloudMeta$StShareQzoneInfo.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> entrys = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
}

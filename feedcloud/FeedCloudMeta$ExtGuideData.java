package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$ExtGuideData extends MessageMicro<FeedCloudMeta$ExtGuideData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"qqGroupInfo"}, new Object[]{null}, FeedCloudMeta$ExtGuideData.class);
    public final PBRepeatMessageField<FeedCloudMeta$QQGroupInfo> qqGroupInfo = PBField.initRepeatMessage(FeedCloudMeta$QQGroupInfo.class);
}

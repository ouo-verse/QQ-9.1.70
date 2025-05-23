package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class FeedCloudPubGuideSvr$ResourceInfo extends MessageMicro<FeedCloudPubGuideSvr$ResourceInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"resource_type", "guide_resources"}, new Object[]{0, null}, FeedCloudPubGuideSvr$ResourceInfo.class);
    public final PBEnumField resource_type = PBField.initEnum(0);
    public final PBRepeatMessageField<FeedCloudPubGuideSvr$GuideResource> guide_resources = PBField.initRepeatMessage(FeedCloudPubGuideSvr$GuideResource.class);
}

package feedcloud;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class FeedCloudPubGuideSvr$PlusEntryGuideRsp extends MessageMicro<FeedCloudPubGuideSvr$PlusEntryGuideRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{DKConfiguration.Directory.RESOURCES, "show_first_pub_animation"}, new Object[]{null, Boolean.FALSE}, FeedCloudPubGuideSvr$PlusEntryGuideRsp.class);
    public final PBRepeatMessageField<FeedCloudPubGuideSvr$ResourceInfo> resources = PBField.initRepeatMessage(FeedCloudPubGuideSvr$ResourceInfo.class);
    public final PBBoolField show_first_pub_animation = PBField.initBool(false);
}

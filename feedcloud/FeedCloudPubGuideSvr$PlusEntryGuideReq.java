package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudPubGuideSvr$PlusEntryGuideReq extends MessageMicro<FeedCloudPubGuideSvr$PlusEntryGuideReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"exp", "page", "light_sdk_version"}, new Object[]{null, 0, ""}, FeedCloudPubGuideSvr$PlusEntryGuideReq.class);
    public FeedCloudPubGuideSvr$ExpInfo exp = new FeedCloudPubGuideSvr$ExpInfo();
    public final PBInt32Field page = PBField.initInt32(0);
    public final PBStringField light_sdk_version = PBField.initString("");
}

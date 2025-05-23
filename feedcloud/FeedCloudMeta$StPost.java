package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.tvkplayer.report.capability.postprocess.TVKDevicePostProcessCapabilityReportConstant;

/* loaded from: classes28.dex */
public final class FeedCloudMeta$StPost extends MessageMicro<FeedCloudMeta$StPost> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{TVKDevicePostProcessCapabilityReportConstant.POST_PROCESS_TYPE, "feed", "comment_id", "reply_id", "sec_reply_id"}, new Object[]{0, null, "", "", ""}, FeedCloudMeta$StPost.class);
    public final PBEnumField post_type = PBField.initEnum(0);
    public FeedCloudMeta$StFeedAbstract feed = new FeedCloudMeta$StFeedAbstract();
    public final PBStringField comment_id = PBField.initString("");
    public final PBStringField reply_id = PBField.initString("");
    public final PBStringField sec_reply_id = PBField.initString("");
}

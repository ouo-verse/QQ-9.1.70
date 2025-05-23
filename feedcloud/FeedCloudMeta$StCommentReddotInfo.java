package feedcloud;

import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StCommentReddotInfo extends MessageMicro<FeedCloudMeta$StCommentReddotInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{QCircleAlphaUserReporter.KEY_USER, WSAutoShowCommentParams.KEY_COMMENT_ID, WSAutoShowCommentParams.KEY_REPLY_ID}, new Object[]{null, "", ""}, FeedCloudMeta$StCommentReddotInfo.class);
    public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
    public final PBStringField commentId = PBField.initString("");
    public final PBStringField replyId = PBField.initString("");
}

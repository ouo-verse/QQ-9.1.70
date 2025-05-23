package feedcloud;

import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$FeedRedTouchTransInfo extends MessageMicro<FeedCloudMeta$FeedRedTouchTransInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 66, 74, 80, 90, 96, 104, 114, 120}, new String[]{"feedId", "author", "createTs", QQBrowserActivity.KEY_MSG_TYPE, "pageType", "redType", "insertPageType", "guideInfo", "sealTransfer", "contentID", "recomInfo", "recomReasonTypeForClient", "recomReasonType", "psvInfo", "recomRedType"}, new Object[]{"", "", 0L, 0, 0, 0, 0, null, "", 0L, null, 0, 0, null, 0}, FeedCloudMeta$FeedRedTouchTransInfo.class);
    public final PBStringField feedId = PBField.initString("");
    public final PBStringField author = PBField.initString("");
    public final PBInt64Field createTs = PBField.initInt64(0);
    public final PBInt32Field msgType = PBField.initInt32(0);
    public final PBInt32Field pageType = PBField.initInt32(0);
    public final PBInt32Field redType = PBField.initInt32(0);
    public final PBInt32Field insertPageType = PBField.initInt32(0);
    public FeedCloudMeta$GuideAttachInfo guideInfo = new MessageMicro<FeedCloudMeta$GuideAttachInfo>() { // from class: feedcloud.FeedCloudMeta$GuideAttachInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"woridng", "uids", "headWording", QZoneDTLoginReporter.SCHEMA}, new Object[]{"", "", "", ""}, FeedCloudMeta$GuideAttachInfo.class);
        public final PBStringField woridng = PBField.initString("");
        public final PBRepeatField<String> uids = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBStringField headWording = PBField.initString("");
        public final PBStringField schema = PBField.initString("");
    };
    public final PBStringField sealTransfer = PBField.initString("");
    public final PBInt64Field contentID = PBField.initInt64(0);
    public final PBRepeatMessageField<FeedCloudCommon$BytesEntry> recomInfo = PBField.initRepeatMessage(FeedCloudCommon$BytesEntry.class);
    public final PBInt32Field recomReasonTypeForClient = PBField.initInt32(0);
    public final PBInt32Field recomReasonType = PBField.initInt32(0);
    public FeedCloudMeta$PsvAttatchInfo psvInfo = new MessageMicro<FeedCloudMeta$PsvAttatchInfo>() { // from class: feedcloud.FeedCloudMeta$PsvAttatchInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"uid", "feedType", WSAutoShowCommentParams.KEY_COMMENT_ID, WSAutoShowCommentParams.KEY_REPLY_ID}, new Object[]{"", 0, "", ""}, FeedCloudMeta$PsvAttatchInfo.class);
        public final PBStringField uid = PBField.initString("");
        public final PBInt32Field feedType = PBField.initInt32(0);
        public final PBStringField commentId = PBField.initString("");
        public final PBStringField replyId = PBField.initString("");
    };
    public final PBInt32Field recomRedType = PBField.initInt32(0);
}

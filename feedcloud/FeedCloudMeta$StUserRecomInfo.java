package feedcloud;

import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StUserRecomInfo extends MessageMicro<FeedCloudMeta$StUserRecomInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiData;
    public final PBRepeatMessageField<FeedCloudCommon$Entry> busiInfo;
    public final PBBytesField busiReport;
    public final PBStringField datongJsonData;
    public final PBBoolField isNew;
    public final PBStringField recomReason;
    public final PBRepeatMessageField<FeedCloudMeta$StUser> relationUserList;
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> stFeedList;
    public final PBRepeatMessageField<FeedCloudCommon$Entry> userTagList;
    public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
    public final PBRepeatMessageField<FeedCloudMeta$StFeedAbstract> feedList = PBField.initRepeatMessage(FeedCloudMeta$StFeedAbstract.class);

    static {
        String[] strArr = {QCircleAlphaUserReporter.KEY_USER, "feedList", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "recomReason", "isNew", "busiInfo", "datongJsonData", "busiReport", "stFeedList", "relationUserList", "userTagList"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 58, 66, 74, 82, 90}, strArr, new Object[]{null, null, byteStringMicro, "", Boolean.FALSE, null, "", byteStringMicro, null, null, null}, FeedCloudMeta$StUserRecomInfo.class);
    }

    public FeedCloudMeta$StUserRecomInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.busiData = PBField.initBytes(byteStringMicro);
        this.recomReason = PBField.initString("");
        this.isNew = PBField.initBool(false);
        this.busiInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
        this.datongJsonData = PBField.initString("");
        this.busiReport = PBField.initBytes(byteStringMicro);
        this.stFeedList = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
        this.relationUserList = PBField.initRepeatMessage(FeedCloudMeta$StUser.class);
        this.userTagList = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    }
}

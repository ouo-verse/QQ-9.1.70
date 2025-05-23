package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetFeedSharePanelReq extends MessageMicro<FeedCloudRead$StGetFeedSharePanelReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42, 50, 58, 64, 74, 80, 98, 106, 114}, new String[]{"feed_id", "source", "extInfo", "shareStyleType", "feed", "tag_name", "gps_info", QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID, "dst_uid", "favorites_id", "comment", "reply", "unifiedTagInfo"}, new Object[]{"", 0, null, 0, null, "", null, 0L, "", 0L, null, null, null}, FeedCloudRead$StGetFeedSharePanelReq.class);
    public final PBStringField feed_id = PBField.initString("");
    public final PBInt32Field source = PBField.initInt32(0);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBInt32Field shareStyleType = PBField.initInt32(0);
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
    public final PBStringField tag_name = PBField.initString("");
    public FeedCloudMeta$StGPSV2 gps_info = new FeedCloudMeta$StGPSV2();
    public final PBUInt64Field album_id = PBField.initUInt64(0);
    public final PBStringField dst_uid = PBField.initString("");
    public final PBUInt64Field favorites_id = PBField.initUInt64(0);
    public FeedCloudMeta$StComment comment = new FeedCloudMeta$StComment();
    public FeedCloudMeta$StReply reply = new FeedCloudMeta$StReply();
    public FeedCloudMeta$StUnifiedTag unifiedTagInfo = new FeedCloudMeta$StUnifiedTag();
}

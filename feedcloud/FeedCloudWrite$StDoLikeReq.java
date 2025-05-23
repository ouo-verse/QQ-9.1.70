package feedcloud;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoLikeReq extends MessageMicro<FeedCloudWrite$StDoLikeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 58, 64, 72, 82}, new String[]{"extInfo", "likeType", "like", "feed", "busiReqData", "comment", "reply", "from", "src", QCircleSchemeAttr.MainPage.EUID}, new Object[]{null, 0, null, null, ByteStringMicro.EMPTY, null, null, 0, 0, ""}, FeedCloudWrite$StDoLikeReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field likeType = PBField.initUInt32(0);
    public FeedCloudMeta$StLike like = new FeedCloudMeta$StLike();
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudMeta$StComment comment = new FeedCloudMeta$StComment();
    public FeedCloudMeta$StReply reply = new FeedCloudMeta$StReply();
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBInt32Field src = PBField.initInt32(0);
    public final PBStringField euid = PBField.initString("");
}

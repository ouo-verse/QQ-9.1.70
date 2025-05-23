package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetCommentListReq extends MessageMicro<FeedCloudRead$StGetCommentListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50, 58, 66, 74, 80, 88, 96, 106, 128, 138}, new String[]{"extInfo", "userId", "feedId", "listNum", "from", "feedAttchInfo", "busiReqData", "likeKey", "busiTranparent", "source", "replyType", "commentCount", "ad_get_req", "rank_type", "hot_comment_id"}, new Object[]{null, "", "", 0, 0, "", ByteStringMicro.EMPTY, "", null, 0, 0, 0L, null, 0, ""}, FeedCloudRead$StGetCommentListReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField userId = PBField.initString("");
    public final PBStringField feedId = PBField.initString("");
    public final PBUInt32Field listNum = PBField.initUInt32(0);
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBStringField feedAttchInfo = PBField.initString("");
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField likeKey = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudCommon$BytesEntry> busiTranparent = PBField.initRepeatMessage(FeedCloudCommon$BytesEntry.class);
    public final PBInt32Field source = PBField.initInt32(0);
    public final PBInt32Field replyType = PBField.initInt32(0);
    public final PBInt64Field commentCount = PBField.initInt64(0);
    public FeedCloudRead$StGetCommtListAdInfo ad_get_req = new FeedCloudRead$StGetCommtListAdInfo();
    public final PBInt32Field rank_type = PBField.initInt32(0);
    public final PBStringField hot_comment_id = PBField.initString("");
}

package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetReplyListReq extends MessageMicro<FeedCloudRead$StGetReplyListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48}, new String[]{"extInfo", "feedUserId", "feedId", "attchInfo", "commentID", "cnt"}, new Object[]{null, "", "", "", "", 0}, FeedCloudRead$StGetReplyListReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField feedUserId = PBField.initString("");
    public final PBStringField feedId = PBField.initString("");
    public final PBStringField attchInfo = PBField.initString("");
    public final PBStringField commentID = PBField.initString("");
    public final PBInt32Field cnt = PBField.initInt32(0);
}

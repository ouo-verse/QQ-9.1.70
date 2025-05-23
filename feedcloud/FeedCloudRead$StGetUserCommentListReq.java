package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetUserCommentListReq extends MessageMicro<FeedCloudRead$StGetUserCommentListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"extInfo", "listNum", "attchInfo"}, new Object[]{null, 0, ""}, FeedCloudRead$StGetUserCommentListReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field listNum = PBField.initUInt32(0);
    public final PBStringField attchInfo = PBField.initString("");
}

package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetUserCommentListRsp extends MessageMicro<FeedCloudRead$StGetUserCommentListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"extInfo", "vecCommentInfo", "isFinish", "attchInfo"}, new Object[]{null, null, 0, ""}, FeedCloudRead$StGetUserCommentListRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudMeta$StUserCommentInfo> vecCommentInfo = PBField.initRepeatMessage(FeedCloudMeta$StUserCommentInfo.class);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBStringField attchInfo = PBField.initString("");
}

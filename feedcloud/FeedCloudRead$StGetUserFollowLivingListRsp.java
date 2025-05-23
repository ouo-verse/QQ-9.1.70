package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetUserFollowLivingListRsp extends MessageMicro<FeedCloudRead$StGetUserFollowLivingListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "userlist", "attchInfo"}, new Object[]{null, null, ""}, FeedCloudRead$StGetUserFollowLivingListRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudMeta$StUser> userlist = PBField.initRepeatMessage(FeedCloudMeta$StUser.class);
    public final PBStringField attchInfo = PBField.initString("");
}

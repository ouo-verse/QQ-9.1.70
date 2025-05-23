package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class FeedCloudRead$GetFollowedUserLatestPublishReq extends MessageMicro<FeedCloudRead$GetFollowedUserLatestPublishReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"uin", "timestamp", "userFeedLimit"}, new Object[]{"", 0L, 0L}, FeedCloudRead$GetFollowedUserLatestPublishReq.class);
    public final PBStringField uin = PBField.initString("");
    public final PBUInt64Field timestamp = PBField.initUInt64(0);
    public final PBUInt64Field userFeedLimit = PBField.initUInt64(0);
}

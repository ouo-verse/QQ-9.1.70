package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$CheckFeedOwnerReq extends MessageMicro<FeedCloudRead$CheckFeedOwnerReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"feedId", "userId"}, new Object[]{"", ""}, FeedCloudRead$CheckFeedOwnerReq.class);
    public final PBStringField feedId = PBField.initString("");
    public final PBStringField userId = PBField.initString("");
}

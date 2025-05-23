package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$DelFeedLightInteractDataReq extends MessageMicro<FeedCloudWrite$DelFeedLightInteractDataReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"feedID", "feedPosterID"}, new Object[]{"", ""}, FeedCloudWrite$DelFeedLightInteractDataReq.class);
    public final PBStringField feedID = PBField.initString("");
    public final PBStringField feedPosterID = PBField.initString("");
}

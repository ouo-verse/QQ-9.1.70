package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudDatacard$GetQQProfilePictureFeedReq extends MessageMicro<FeedCloudDatacard$GetQQProfilePictureFeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"user_id"}, new Object[]{""}, FeedCloudDatacard$GetQQProfilePictureFeedReq.class);
    public final PBStringField user_id = PBField.initString("");
}

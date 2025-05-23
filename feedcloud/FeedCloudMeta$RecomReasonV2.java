package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$RecomReasonV2 extends MessageMicro<FeedCloudMeta$RecomReasonV2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"recomUserInfo", "recomReason", "recomGroupInfo", "recomSchema"}, new Object[]{null, "", "", ""}, FeedCloudMeta$RecomReasonV2.class);
    public final PBRepeatMessageField<FeedCloudMeta$StUser> recomUserInfo = PBField.initRepeatMessage(FeedCloudMeta$StUser.class);
    public final PBStringField recomReason = PBField.initString("");
    public final PBStringField recomGroupInfo = PBField.initString("");
    public final PBStringField recomSchema = PBField.initString("");
}

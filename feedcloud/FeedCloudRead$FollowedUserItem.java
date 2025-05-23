package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$FollowedUserItem extends MessageMicro<FeedCloudRead$FollowedUserItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"uid", "keys"}, new Object[]{"", ""}, FeedCloudRead$FollowedUserItem.class);
    public final PBStringField uid = PBField.initString("");
    public final PBRepeatField<String> keys = PBField.initRepeat(PBStringField.__repeatHelper__);
}

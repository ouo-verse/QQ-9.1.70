package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$DecorateJumpInfo extends MessageMicro<FeedCloudMeta$DecorateJumpInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 40}, new String[]{"name", "description", "activityUrl", "jumpType"}, new Object[]{"", "", "", 0}, FeedCloudMeta$DecorateJumpInfo.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField description = PBField.initString("");
    public final PBStringField activityUrl = PBField.initString("");
    public final PBUInt32Field jumpType = PBField.initUInt32(0);
}

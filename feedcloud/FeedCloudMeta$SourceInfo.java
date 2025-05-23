package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$SourceInfo extends MessageMicro<FeedCloudMeta$SourceInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"feed_id", "ec_uid", "nick"}, new Object[]{"", "", ""}, FeedCloudMeta$SourceInfo.class);
    public final PBStringField feed_id = PBField.initString("");
    public final PBStringField ec_uid = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
}

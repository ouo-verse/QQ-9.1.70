package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StFeedShowReason extends MessageMicro<FeedCloudMeta$StFeedShowReason> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"showReason", "type"}, new Object[]{"", 0}, FeedCloudMeta$StFeedShowReason.class);
    public final PBStringField showReason = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
}

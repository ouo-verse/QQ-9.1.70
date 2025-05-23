package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StUnifiedTag extends MessageMicro<FeedCloudMeta$StUnifiedTag> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"unifiedType", "unifiedId"}, new Object[]{"", ""}, FeedCloudMeta$StUnifiedTag.class);
    public final PBStringField unifiedType = PBField.initString("");
    public final PBStringField unifiedId = PBField.initString("");
}

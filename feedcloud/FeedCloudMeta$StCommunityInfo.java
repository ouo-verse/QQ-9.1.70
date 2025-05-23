package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StCommunityInfo extends MessageMicro<FeedCloudMeta$StCommunityInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"subSource", "name", "schemaURL"}, new Object[]{0, "", ""}, FeedCloudMeta$StCommunityInfo.class);
    public final PBInt32Field subSource = PBField.initInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField schemaURL = PBField.initString("");
}

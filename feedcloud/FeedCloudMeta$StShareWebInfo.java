package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StShareWebInfo extends MessageMicro<FeedCloudMeta$StShareWebInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"url", "shortURL"}, new Object[]{"", ""}, FeedCloudMeta$StShareWebInfo.class);
    public final PBStringField url = PBField.initString("");
    public final PBStringField shortURL = PBField.initString("");
}

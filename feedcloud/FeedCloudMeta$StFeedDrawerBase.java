package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StFeedDrawerBase extends MessageMicro<FeedCloudMeta$StFeedDrawerBase> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"desc", "drawerDesc"}, new Object[]{"", ""}, FeedCloudMeta$StFeedDrawerBase.class);
    public final PBStringField desc = PBField.initString("");
    public final PBStringField drawerDesc = PBField.initString("");
}

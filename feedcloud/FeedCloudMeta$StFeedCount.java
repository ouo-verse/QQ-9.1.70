package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.vip.IGameCardManager;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StFeedCount extends MessageMicro<FeedCloudMeta$StFeedCount> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"liked", "push", "comment", IGameCardManager.VISITOR, "shareCount"}, new Object[]{0L, 0L, 0L, 0L, 0L}, FeedCloudMeta$StFeedCount.class);
    public final PBInt64Field liked = PBField.initInt64(0);
    public final PBInt64Field push = PBField.initInt64(0);
    public final PBInt64Field comment = PBField.initInt64(0);
    public final PBInt64Field visitor = PBField.initInt64(0);
    public final PBInt64Field shareCount = PBField.initInt64(0);
}

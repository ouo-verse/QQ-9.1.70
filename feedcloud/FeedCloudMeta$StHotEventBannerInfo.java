package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StHotEventBannerInfo extends MessageMicro<FeedCloudMeta$StHotEventBannerInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"showIcon", "rank"}, new Object[]{"", 0}, FeedCloudMeta$StHotEventBannerInfo.class);
    public final PBStringField showIcon = PBField.initString("");
    public final PBUInt32Field rank = PBField.initUInt32(0);
}

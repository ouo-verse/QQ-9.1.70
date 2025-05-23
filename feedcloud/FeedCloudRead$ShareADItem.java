package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$ShareADItem extends MessageMicro<FeedCloudRead$ShareADItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"position", "ad_feed"}, new Object[]{0, null}, FeedCloudRead$ShareADItem.class);
    public final PBUInt32Field position = PBField.initUInt32(0);
    public FeedCloudMeta$StFeed ad_feed = new FeedCloudMeta$StFeed();
}

package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import tianshu.QQCircleTianShu$AdItem;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StSearchMixTagBanner extends MessageMicro<FeedCloudRead$StSearchMixTagBanner> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 26, 42}, new String[]{"image", "actionUrl", "tianshuAdItem"}, new Object[]{null, "", null}, FeedCloudRead$StSearchMixTagBanner.class);
    public FeedCloudMeta$StImage image = new FeedCloudMeta$StImage();
    public final PBStringField actionUrl = PBField.initString("");
    public QQCircleTianShu$AdItem tianshuAdItem = new QQCircleTianShu$AdItem();
}

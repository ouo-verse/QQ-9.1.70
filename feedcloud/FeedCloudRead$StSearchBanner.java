package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import tianshu.QQCircleTianShu$RspEntry;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StSearchBanner extends MessageMicro<FeedCloudRead$StSearchBanner> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"image", "imageJumpUrl", "tianshuEntry"}, new Object[]{null, "", null}, FeedCloudRead$StSearchBanner.class);
    public FeedCloudMeta$StImage image = new FeedCloudMeta$StImage();
    public final PBStringField imageJumpUrl = PBField.initString("");
    public QQCircleTianShu$RspEntry tianshuEntry = new QQCircleTianShu$RspEntry();
}

package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StSearchBannerInfo extends MessageMicro<FeedCloudRead$StSearchBannerInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"banners"}, new Object[]{null}, FeedCloudRead$StSearchBannerInfo.class);
    public final PBRepeatMessageField<FeedCloudRead$StSearchBanner> banners = PBField.initRepeatMessage(FeedCloudRead$StSearchBanner.class);
}

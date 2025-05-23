package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class FeedCloudActivityLandingPage$GetBannerDataRsp extends MessageMicro<FeedCloudActivityLandingPage$GetBannerDataRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"banner"}, new Object[]{null}, FeedCloudActivityLandingPage$GetBannerDataRsp.class);
    public final PBRepeatMessageField<FeedCloudActivityLandingPage$BannerData> banner = PBField.initRepeatMessage(FeedCloudActivityLandingPage$BannerData.class);
}

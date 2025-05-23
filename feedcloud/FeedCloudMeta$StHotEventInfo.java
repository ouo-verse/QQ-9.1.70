package feedcloud;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StHotEventInfo extends MessageMicro<FeedCloudMeta$StHotEventInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"eventID", AdMetricTag.EVENT_NAME, "heat", "bannerInfo"}, new Object[]{0L, "", 0L, null}, FeedCloudMeta$StHotEventInfo.class);
    public final PBUInt64Field eventID = PBField.initUInt64(0);
    public final PBStringField eventName = PBField.initString("");
    public final PBUInt64Field heat = PBField.initUInt64(0);
    public FeedCloudMeta$StHotEventBannerInfo bannerInfo = new FeedCloudMeta$StHotEventBannerInfo();
}

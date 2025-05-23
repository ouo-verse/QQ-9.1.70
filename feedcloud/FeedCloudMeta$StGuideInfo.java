package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StGuideInfo extends MessageMicro<FeedCloudMeta$StGuideInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"guide_type", "btmSubInfo", "displayTimeSecond", "extData"}, new Object[]{0, null, 0, null}, FeedCloudMeta$StGuideInfo.class);
    public final PBEnumField guide_type = PBField.initEnum(0);
    public FeedCloudMeta$ButtonInfo btmSubInfo = new FeedCloudMeta$ButtonInfo();
    public final PBInt32Field displayTimeSecond = PBField.initInt32(0);
    public FeedCloudMeta$ExtGuideData extData = new FeedCloudMeta$ExtGuideData();
}

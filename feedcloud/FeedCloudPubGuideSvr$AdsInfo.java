package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class FeedCloudPubGuideSvr$AdsInfo extends MessageMicro<FeedCloudPubGuideSvr$AdsInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"type", "style", "ads_items"}, new Object[]{0, 0, null}, FeedCloudPubGuideSvr$AdsInfo.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBEnumField style = PBField.initEnum(0);
    public final PBRepeatMessageField<FeedCloudPubGuideSvr$AdsItem> ads_items = PBField.initRepeatMessage(FeedCloudPubGuideSvr$AdsItem.class);
}

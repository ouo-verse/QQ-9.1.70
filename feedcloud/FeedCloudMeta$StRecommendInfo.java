package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StRecommendInfo extends MessageMicro<FeedCloudMeta$StRecommendInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 82, 88}, new String[]{WinkDaTongReportConstant.ElementParamKey.RECOMMEND_TYPE, "items", "trans_info", "recommend_status"}, new Object[]{0, null, "", 0}, FeedCloudMeta$StRecommendInfo.class);
    public final PBUInt32Field recommend_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta$RecommendItem> items = PBField.initRepeatMessage(FeedCloudMeta$RecommendItem.class);
    public final PBStringField trans_info = PBField.initString("");
    public final PBInt32Field recommend_status = PBField.initInt32(0);
}

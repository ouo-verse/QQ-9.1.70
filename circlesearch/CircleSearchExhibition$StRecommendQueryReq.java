package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StRecommendQueryReq extends MessageMicro<CircleSearchExhibition$StRecommendQueryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 82}, new String[]{"ext_info", "feed_searches", "query_text", WinkDaTongReportConstant.ElementParamKey.RECOMMEND_TYPE, "trans_info"}, new Object[]{null, null, "", 0, ""}, CircleSearchExhibition$StRecommendQueryReq.class);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<CircleSearchExhibition$StFeedSearch> feed_searches = PBField.initRepeatMessage(CircleSearchExhibition$StFeedSearch.class);
    public final PBStringField query_text = PBField.initString("");
    public final PBUInt32Field recommend_type = PBField.initUInt32(0);
    public final PBStringField trans_info = PBField.initString("");
}

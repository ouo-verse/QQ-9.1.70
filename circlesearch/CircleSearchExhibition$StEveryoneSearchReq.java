package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StEveryoneSearchReq extends MessageMicro<CircleSearchExhibition$StEveryoneSearchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 82}, new String[]{"ext_info", "feed_searches", "query_text", "trans_info"}, new Object[]{null, null, "", ""}, CircleSearchExhibition$StEveryoneSearchReq.class);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<CircleSearchExhibition$StFeedSearch> feed_searches = PBField.initRepeatMessage(CircleSearchExhibition$StFeedSearch.class);
    public final PBStringField query_text = PBField.initString("");
    public final PBStringField trans_info = PBField.initString("");
}

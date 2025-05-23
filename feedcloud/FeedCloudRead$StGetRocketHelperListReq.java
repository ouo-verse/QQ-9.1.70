package feedcloud;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetRocketHelperListReq extends MessageMicro<FeedCloudRead$StGetRocketHelperListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 48, 58}, new String[]{"extInfo", "feedId", "source", "shareUser", "shareTime", WidgetCacheConstellationData.NUM, "attachInfo"}, new Object[]{null, "", 0, null, 0L, 0, ""}, FeedCloudRead$StGetRocketHelperListReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField feedId = PBField.initString("");
    public final PBInt32Field source = PBField.initInt32(0);
    public FeedCloudMeta$StUser shareUser = new FeedCloudMeta$StUser();
    public final PBInt64Field shareTime = PBField.initInt64(0);
    public final PBInt32Field num = PBField.initInt32(0);
    public final PBStringField attachInfo = PBField.initString("");
}

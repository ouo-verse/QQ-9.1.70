package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetRocketHelperListRsp extends MessageMicro<FeedCloudRead$StGetRocketHelperListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 50, 58}, new String[]{"extInfo", "helperInfos", "hasNext", "attachInfo", "count", "viewInfo", "enable_rocket_permission_url"}, new Object[]{null, null, Boolean.FALSE, "", 0, null, ""}, FeedCloudRead$StGetRocketHelperListRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudRead$StHelperInfo> helperInfos = PBField.initRepeatMessage(FeedCloudRead$StHelperInfo.class);
    public final PBBoolField hasNext = PBField.initBool(false);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBInt32Field count = PBField.initInt32(0);
    public FeedCloudMeta$PushBoxViewInfo viewInfo = new FeedCloudMeta$PushBoxViewInfo();
    public final PBStringField enable_rocket_permission_url = PBField.initString("");
}

package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StClearRedPointReq extends MessageMicro<FeedCloudRead$StClearRedPointReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 48}, new String[]{"extInfo", "pageType", "userID", "groupID", "toUID", "lastPageTime"}, new Object[]{null, 0, "", "", "", 0L}, FeedCloudRead$StClearRedPointReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBInt32Field pageType = PBField.initInt32(0);
    public final PBStringField userID = PBField.initString("");
    public final PBStringField groupID = PBField.initString("");
    public final PBStringField toUID = PBField.initString("");
    public final PBInt64Field lastPageTime = PBField.initInt64(0);
}

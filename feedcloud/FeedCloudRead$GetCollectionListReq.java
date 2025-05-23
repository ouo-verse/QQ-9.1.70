package feedcloud;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GetCollectionListReq extends MessageMicro<FeedCloudRead$GetCollectionListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40}, new String[]{"extInfo", "user_id", AppConstants.Key.SHARE_REQ_TYPE, "attach_info", "from"}, new Object[]{null, "", 0, "", 0}, FeedCloudRead$GetCollectionListReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField user_id = PBField.initString("");
    public final PBUInt32Field req_type = PBField.initUInt32(0);
    public final PBStringField attach_info = PBField.initString("");
    public final PBEnumField from = PBField.initEnum(0);
}

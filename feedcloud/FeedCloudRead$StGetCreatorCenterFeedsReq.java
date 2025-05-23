package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetCreatorCenterFeedsReq extends MessageMicro<FeedCloudRead$StGetCreatorCenterFeedsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42}, new String[]{"dstUserID", "count", "pageUp", "targetPageNum", "roundParam"}, new Object[]{"", 0, Boolean.FALSE, 0, ""}, FeedCloudRead$StGetCreatorCenterFeedsReq.class);
    public final PBStringField dstUserID = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBBoolField pageUp = PBField.initBool(false);
    public final PBUInt32Field targetPageNum = PBField.initUInt32(0);
    public final PBStringField roundParam = PBField.initString("");
}

package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetUIDRsp extends MessageMicro<FeedCloudRead$StGetUIDRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"extInfo", "uidValid", "uid", "errMsg"}, new Object[]{null, Boolean.FALSE, "", ""}, FeedCloudRead$StGetUIDRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBBoolField uidValid = PBField.initBool(false);
    public final PBStringField uid = PBField.initString("");
    public final PBStringField errMsg = PBField.initString("");
}

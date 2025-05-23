package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetC2CFeedReq extends MessageMicro<FeedCloudRead$StGetC2CFeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"extInfo", "userId", "busiReqData", "attchInfo"}, new Object[]{null, "", ByteStringMicro.EMPTY, ""}, FeedCloudRead$StGetC2CFeedReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField userId = PBField.initString("");
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField attchInfo = PBField.initString("");
}

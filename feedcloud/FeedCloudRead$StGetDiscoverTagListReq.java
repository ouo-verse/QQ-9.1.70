package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetDiscoverTagListReq extends MessageMicro<FeedCloudRead$StGetDiscoverTagListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "attachInfo", "busiReqData"}, new Object[]{null, "", ByteStringMicro.EMPTY}, FeedCloudRead$StGetDiscoverTagListReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField attachInfo = PBField.initString("");
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
}

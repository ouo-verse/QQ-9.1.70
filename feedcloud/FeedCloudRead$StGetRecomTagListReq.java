package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetRecomTagListReq extends MessageMicro<FeedCloudRead$StGetRecomTagListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "gpsInfo", "busiReqData"}, new Object[]{null, null, ByteStringMicro.EMPTY}, FeedCloudRead$StGetRecomTagListReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StGPSV2 gpsInfo = new FeedCloudMeta$StGPSV2();
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
}

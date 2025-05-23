package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetBusiInfoRsp extends MessageMicro<FeedCloudRead$StGetBusiInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "busiRspData"}, new Object[]{null, ByteStringMicro.EMPTY}, FeedCloudRead$StGetBusiInfoRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
}

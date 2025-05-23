package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetNoticeListReq extends MessageMicro<FeedCloudRead$StGetNoticeListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42}, new String[]{"extInfo", "listNum", "feedAttchInfo", "pageType", "busiReqData"}, new Object[]{null, 0, "", 0, ByteStringMicro.EMPTY}, FeedCloudRead$StGetNoticeListReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field listNum = PBField.initUInt32(0);
    public final PBStringField feedAttchInfo = PBField.initString("");
    public final PBUInt32Field pageType = PBField.initUInt32(0);
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
}

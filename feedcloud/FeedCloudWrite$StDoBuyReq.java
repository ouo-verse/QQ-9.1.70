package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoBuyReq extends MessageMicro<FeedCloudWrite$StDoBuyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48}, new String[]{"extInfo", "giftID", "amount", "giftType", "busiReqData", "src"}, new Object[]{null, "", 0, 0, ByteStringMicro.EMPTY, 0}, FeedCloudWrite$StDoBuyReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField giftID = PBField.initString("");
    public final PBInt32Field amount = PBField.initInt32(0);
    public final PBInt32Field giftType = PBField.initInt32(0);
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field src = PBField.initInt32(0);
}

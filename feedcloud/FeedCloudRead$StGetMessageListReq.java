package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetMessageListReq extends MessageMicro<FeedCloudRead$StGetMessageListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48}, new String[]{"extInfo", QCircleDaTongConstant.ElementParamValue.OPERATION, "listNum", "feedAttchInfo", "busiReqData", "message_category_id"}, new Object[]{null, null, 0, "", ByteStringMicro.EMPTY, 0}, FeedCloudRead$StGetMessageListReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StOperation operation = new FeedCloudMeta$StOperation();
    public final PBUInt32Field listNum = PBField.initUInt32(0);
    public final PBStringField feedAttchInfo = PBField.initString("");
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field message_category_id = PBField.initInt32(0);
}

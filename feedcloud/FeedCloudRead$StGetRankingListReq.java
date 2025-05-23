package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetRankingListReq extends MessageMicro<FeedCloudRead$StGetRankingListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 64, 72, 80, 90}, new String[]{"extInfo", "listType", "count", "listTime", "busiReqData", "enable_page", "items_per_page", "cursor", "tag_name"}, new Object[]{null, 0, 0, 0, ByteStringMicro.EMPTY, Boolean.FALSE, 0, 0, ""}, FeedCloudRead$StGetRankingListReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field listType = PBField.initUInt32(0);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt32Field listTime = PBField.initUInt32(0);
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField enable_page = PBField.initBool(false);
    public final PBInt32Field items_per_page = PBField.initInt32(0);
    public final PBInt32Field cursor = PBField.initInt32(0);
    public final PBStringField tag_name = PBField.initString("");
}

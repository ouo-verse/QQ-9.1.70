package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qzonehub.api.contentbox.IQzoneMsgApi;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetPushListByOpUIDsFeedIDReq extends MessageMicro<FeedCloudRead$StGetPushListByOpUIDsFeedIDReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58}, new String[]{"ext_info", "feed_id", IQzoneMsgApi.LIKE_KEY, "count", "backent_trans_data", "anchor_uid", "author_uid"}, new Object[]{null, "", "", 0, ByteStringMicro.EMPTY, "", ""}, FeedCloudRead$StGetPushListByOpUIDsFeedIDReq.class);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    public final PBStringField feed_id = PBField.initString("");
    public final PBStringField like_key = PBField.initString("");
    public final PBInt32Field count = PBField.initInt32(0);
    public final PBBytesField backent_trans_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField anchor_uid = PBField.initString("");
    public final PBStringField author_uid = PBField.initString("");
}

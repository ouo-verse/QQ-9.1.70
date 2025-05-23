package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qzonehub.api.contentbox.IQzoneMsgApi;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetLikeListByOpUIDsFeedIDReq extends MessageMicro<FeedCloudRead$StGetLikeListByOpUIDsFeedIDReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58}, new String[]{"ext_info", "feed_id", IQzoneMsgApi.LIKE_KEY, "count", "backent_trans_data", "anchor_uid", "anchor_uids"}, new Object[]{null, "", "", 0, ByteStringMicro.EMPTY, "", ""}, FeedCloudRead$StGetLikeListByOpUIDsFeedIDReq.class);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    public final PBStringField feed_id = PBField.initString("");
    public final PBStringField like_key = PBField.initString("");
    public final PBInt32Field count = PBField.initInt32(0);
    public final PBBytesField backent_trans_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField anchor_uid = PBField.initString("");
    public final PBRepeatField<String> anchor_uids = PBField.initRepeat(PBStringField.__repeatHelper__);
}

package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetPushListByOpUIDsFeedIDRsp extends MessageMicro<FeedCloudRead$StGetPushListByOpUIDsFeedIDRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"ext_info", "pushes", "is_finish", "backent_trans_data", "tail_text"}, new Object[]{null, null, 0, ByteStringMicro.EMPTY, ""}, FeedCloudRead$StGetPushListByOpUIDsFeedIDRsp.class);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudRead$UserAndPushCnt> pushes = PBField.initRepeatMessage(FeedCloudRead$UserAndPushCnt.class);
    public final PBUInt32Field is_finish = PBField.initUInt32(0);
    public final PBBytesField backent_trans_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField tail_text = PBField.initString("");
}

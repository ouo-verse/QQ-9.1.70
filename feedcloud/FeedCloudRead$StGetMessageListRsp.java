package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetMessageListRsp extends MessageMicro<FeedCloudRead$StGetMessageListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50}, new String[]{"extInfo", "vecNotice", "totalNum", "isFinish", "feedAttchInfo", "busiRspData"}, new Object[]{null, null, 0, 0, "", ByteStringMicro.EMPTY}, FeedCloudRead$StGetMessageListRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudMeta$StNotice> vecNotice = PBField.initRepeatMessage(FeedCloudMeta$StNotice.class);
    public final PBUInt32Field totalNum = PBField.initUInt32(0);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBStringField feedAttchInfo = PBField.initString("");
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
}

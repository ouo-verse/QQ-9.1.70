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
public final class FeedCloudRead$StGetFollowListRsp extends MessageMicro<FeedCloudRead$StGetFollowListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48}, new String[]{"extInfo", "attachInfo", "hasNext", "relationInfo", "busiRspData", "isFiltered"}, new Object[]{null, "", 0, null, ByteStringMicro.EMPTY, 0}, FeedCloudRead$StGetFollowListRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField attachInfo = PBField.initString("");
    public final PBUInt32Field hasNext = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta$StRelationInfo> relationInfo = PBField.initRepeatMessage(FeedCloudMeta$StRelationInfo.class);
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field isFiltered = PBField.initUInt32(0);
}

package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetRelationGroupListReq extends MessageMicro<FeedCloudRead$StGetRelationGroupListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"extInfo", "reqItems", "count", "scene"}, new Object[]{null, null, 0L, 0}, FeedCloudRead$StGetRelationGroupListReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudRead$GroupReqItem> reqItems = PBField.initRepeatMessage(FeedCloudRead$GroupReqItem.class);
    public final PBInt64Field count = PBField.initInt64(0);
    public final PBInt32Field scene = PBField.initInt32(0);
}

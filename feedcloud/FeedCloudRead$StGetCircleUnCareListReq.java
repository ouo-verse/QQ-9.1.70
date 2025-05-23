package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetCircleUnCareListReq extends MessageMicro<FeedCloudRead$StGetCircleUnCareListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"extInfo", "rightType", "type", "flag"}, new Object[]{null, 0, 0, 0}, FeedCloudRead$StGetCircleUnCareListReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBInt32Field rightType = PBField.initInt32(0);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBInt32Field flag = PBField.initInt32(0);
}

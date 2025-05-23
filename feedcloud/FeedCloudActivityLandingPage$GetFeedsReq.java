package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* loaded from: classes28.dex */
public final class FeedCloudActivityLandingPage$GetFeedsReq extends MessageMicro<FeedCloudActivityLandingPage$GetFeedsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 24, 32, 40, 50}, new String[]{QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID, "pub_start_time", "pub_end_time", "count", "attach_info"}, new Object[]{0, 0L, 0L, 0, null}, FeedCloudActivityLandingPage$GetFeedsReq.class);
    public final PBInt32Field biz_id = PBField.initInt32(0);
    public final PBInt64Field pub_start_time = PBField.initInt64(0);
    public final PBInt64Field pub_end_time = PBField.initInt64(0);
    public final PBInt32Field count = PBField.initInt32(0);
    public FeedCloudActivityLandingPage$AttachInfo attach_info = new FeedCloudActivityLandingPage$AttachInfo();
}

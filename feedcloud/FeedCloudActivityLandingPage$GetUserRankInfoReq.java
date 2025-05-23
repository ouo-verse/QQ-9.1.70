package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* loaded from: classes28.dex */
public final class FeedCloudActivityLandingPage$GetUserRankInfoReq extends MessageMicro<FeedCloudActivityLandingPage$GetUserRankInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 24, 32}, new String[]{QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID, "start_date", "end_date"}, new Object[]{0, 0L, 0L}, FeedCloudActivityLandingPage$GetUserRankInfoReq.class);
    public final PBInt32Field biz_id = PBField.initInt32(0);
    public final PBInt64Field start_date = PBField.initInt64(0);
    public final PBInt64Field end_date = PBField.initInt64(0);
}

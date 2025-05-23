package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* loaded from: classes28.dex */
public final class FeedCloudActivityLandingPage$GetActivityTabListReq extends MessageMicro<FeedCloudActivityLandingPage$GetActivityTabListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID}, new Object[]{0}, FeedCloudActivityLandingPage$GetActivityTabListReq.class);
    public final PBInt32Field biz_id = PBField.initInt32(0);
}

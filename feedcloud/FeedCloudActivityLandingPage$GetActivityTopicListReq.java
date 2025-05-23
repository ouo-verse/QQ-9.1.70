package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* loaded from: classes28.dex */
public final class FeedCloudActivityLandingPage$GetActivityTopicListReq extends MessageMicro<FeedCloudActivityLandingPage$GetActivityTopicListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID, "id", "offset", "limit"}, new Object[]{0, "", 0, 0}, FeedCloudActivityLandingPage$GetActivityTopicListReq.class);
    public final PBInt32Field biz_id = PBField.initInt32(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398424id = PBField.initString("");
    public final PBInt32Field offset = PBField.initInt32(0);
    public final PBInt32Field limit = PBField.initInt32(0);
}

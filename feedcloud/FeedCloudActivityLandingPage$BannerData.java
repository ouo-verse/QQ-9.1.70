package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudActivityLandingPage$BannerData extends MessageMicro<FeedCloudActivityLandingPage$BannerData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"img", "jump_url", "task_id", "jump_type"}, new Object[]{"", "", 0, 0}, FeedCloudActivityLandingPage$BannerData.class);
    public final PBStringField img = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBInt32Field task_id = PBField.initInt32(0);
    public final PBInt32Field jump_type = PBField.initInt32(0);
}

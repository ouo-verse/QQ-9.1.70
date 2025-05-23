package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$ShootLBS extends MessageMicro<FeedCloudMeta$ShootLBS> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"shoot_time", "country", "province", "city"}, new Object[]{0L, "", "", ""}, FeedCloudMeta$ShootLBS.class);
    public final PBInt64Field shoot_time = PBField.initInt64(0);
    public final PBStringField country = PBField.initString("");
    public final PBStringField province = PBField.initString("");
    public final PBStringField city = PBField.initString("");
}

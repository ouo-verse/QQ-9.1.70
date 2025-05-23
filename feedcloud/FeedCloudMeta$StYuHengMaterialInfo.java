package feedcloud;

import com.heytap.mcssdk.a.a;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StYuHengMaterialInfo extends MessageMicro<FeedCloudMeta$StYuHengMaterialInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"id", a.f36094d, "ext", "detailBytes", "channelType"}, new Object[]{"", "", "", ByteStringMicro.EMPTY, 0}, FeedCloudMeta$StYuHengMaterialInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398465id = PBField.initString("");
    public final PBStringField taskID = PBField.initString("");
    public final PBStringField ext = PBField.initString("");
    public final PBBytesField detailBytes = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field channelType = PBField.initInt32(0);
}

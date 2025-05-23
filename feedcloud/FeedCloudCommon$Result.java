package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudCommon$Result extends MessageMicro<FeedCloudCommon$Result> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"retCode", "msg"}, new Object[]{0, ""}, FeedCloudCommon$Result.class);
    public final PBInt32Field retCode = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f398427msg = PBField.initString("");
}

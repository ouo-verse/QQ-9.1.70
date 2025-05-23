package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StCallFollowRsp extends MessageMicro<FeedCloudWrite$StCallFollowRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"uid", "code", "msg"}, new Object[]{"", 0, ""}, FeedCloudWrite$StCallFollowRsp.class);
    public final PBStringField uid = PBField.initString("");
    public final PBUInt32Field code = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f398482msg = PBField.initString("");
}

package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$QQGroupInfo extends MessageMicro<FeedCloudMeta$QQGroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"name", "id", "jumpURL", "jumpAuth"}, new Object[]{"", 0L, "", ByteStringMicro.EMPTY}, FeedCloudMeta$QQGroupInfo.class);
    public final PBStringField name = PBField.initString("");

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f398444id = PBField.initUInt64(0);
    public final PBStringField jumpURL = PBField.initString("");
    public final PBBytesField jumpAuth = PBField.initBytes(ByteStringMicro.EMPTY);
}

package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$GYContentInfo extends MessageMicro<FeedCloudWrite$GYContentInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"content", "type", "url", "data"}, new Object[]{0, 0, "", ByteStringMicro.EMPTY}, FeedCloudWrite$GYContentInfo.class);
    public final PBUInt32Field content = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
}

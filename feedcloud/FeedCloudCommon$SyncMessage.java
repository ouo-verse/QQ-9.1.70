package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudCommon$SyncMessage extends MessageMicro<FeedCloudCommon$SyncMessage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"data", "timestampMS"}, new Object[]{ByteStringMicro.EMPTY, 0L}, FeedCloudCommon$SyncMessage.class);
    public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field timestampMS = PBField.initInt64(0);
}

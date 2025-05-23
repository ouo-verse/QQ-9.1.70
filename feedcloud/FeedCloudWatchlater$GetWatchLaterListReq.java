package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWatchlater$GetWatchLaterListReq extends MessageMicro<FeedCloudWatchlater$GetWatchLaterListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"size", "attach_info"}, new Object[]{0, ByteStringMicro.EMPTY}, FeedCloudWatchlater$GetWatchLaterListReq.class);
    public final PBUInt32Field size = PBField.initUInt32(0);
    public final PBBytesField attach_info = PBField.initBytes(ByteStringMicro.EMPTY);
}

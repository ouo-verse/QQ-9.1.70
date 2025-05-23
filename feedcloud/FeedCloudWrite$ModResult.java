package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$ModResult extends MessageMicro<FeedCloudWrite$ModResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"cmtID", "modResult"}, new Object[]{"", 0}, FeedCloudWrite$ModResult.class);
    public final PBStringField cmtID = PBField.initString("");
    public final PBUInt32Field modResult = PBField.initUInt32(0);
}

package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$SecurityControlResult extends MessageMicro<FeedCloudRead$SecurityControlResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"queryID", "commentState", "barrageState"}, new Object[]{"", 0, 0}, FeedCloudRead$SecurityControlResult.class);
    public final PBStringField queryID = PBField.initString("");
    public final PBUInt32Field commentState = PBField.initUInt32(0);
    public final PBUInt32Field barrageState = PBField.initUInt32(0);
}

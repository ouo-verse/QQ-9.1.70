package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$QuickShareUser extends MessageMicro<FeedCloudRead$QuickShareUser> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"uin", "name", "type"}, new Object[]{"", "", 0}, FeedCloudRead$QuickShareUser.class);
    public final PBStringField uin = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
}

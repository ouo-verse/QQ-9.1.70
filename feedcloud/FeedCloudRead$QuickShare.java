package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$QuickShare extends MessageMicro<FeedCloudRead$QuickShare> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"type", "users", "use_recom"}, new Object[]{0, null, Boolean.FALSE}, FeedCloudRead$QuickShare.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudRead$QuickShareUser> users = PBField.initRepeatMessage(FeedCloudRead$QuickShareUser.class);
    public final PBBoolField use_recom = PBField.initBool(false);
}

package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudEeveeBase$StEeveeDialogData extends MessageMicro<FeedCloudEeveeBase$StEeveeDialogData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"type", "dialog", "entries"}, new Object[]{0, null, null}, FeedCloudEeveeBase$StEeveeDialogData.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public FeedCloudRead$CommDialog dialog = new FeedCloudRead$CommDialog();
    public final PBRepeatMessageField<FeedCloudCommon$Entry> entries = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
}

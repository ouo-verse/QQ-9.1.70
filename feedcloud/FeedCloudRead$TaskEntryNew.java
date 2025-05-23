package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$TaskEntryNew extends MessageMicro<FeedCloudRead$TaskEntryNew> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"task_conf", "vertical_separator_bar", "gradient_mask_bar"}, new Object[]{null, "", ""}, FeedCloudRead$TaskEntryNew.class);
    public final PBRepeatMessageField<FeedCloudRead$TaskEntryConf> task_conf = PBField.initRepeatMessage(FeedCloudRead$TaskEntryConf.class);
    public final PBStringField vertical_separator_bar = PBField.initString("");
    public final PBStringField gradient_mask_bar = PBField.initString("");
}

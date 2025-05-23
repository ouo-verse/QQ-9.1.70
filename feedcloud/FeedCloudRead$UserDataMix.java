package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$UserDataMix extends MessageMicro<FeedCloudRead$UserDataMix> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"uid", "is_self", "kvs"}, new Object[]{"", Boolean.FALSE, null}, FeedCloudRead$UserDataMix.class);
    public final PBStringField uid = PBField.initString("");
    public final PBBoolField is_self = PBField.initBool(false);
    public final PBRepeatMessageField<FeedCloudRead$DataMixKV> kvs = PBField.initRepeatMessage(FeedCloudRead$DataMixKV.class);
}

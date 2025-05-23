package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GetDataMixRsp extends MessageMicro<FeedCloudRead$GetDataMixRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"datas"}, new Object[]{null}, FeedCloudRead$GetDataMixRsp.class);
    public final PBRepeatMessageField<FeedCloudRead$UserDataMix> datas = PBField.initRepeatMessage(FeedCloudRead$UserDataMix.class);
}

package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GetSecurityControlStateRsp extends MessageMicro<FeedCloudRead$GetSecurityControlStateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"result"}, new Object[]{null}, FeedCloudRead$GetSecurityControlStateRsp.class);
    public final PBRepeatMessageField<FeedCloudRead$SecurityControlResult> result = PBField.initRepeatMessage(FeedCloudRead$SecurityControlResult.class);
}

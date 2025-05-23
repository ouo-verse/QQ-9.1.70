package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetQQRecallCardReq extends MessageMicro<FeedCloudRead$StGetQQRecallCardReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"targetUins"}, new Object[]{""}, FeedCloudRead$StGetQQRecallCardReq.class);
    public final PBRepeatField<String> targetUins = PBField.initRepeat(PBStringField.__repeatHelper__);
}

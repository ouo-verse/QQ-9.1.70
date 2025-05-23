package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagbasesvr$StFilterTagBaseInfoReq extends MessageMicro<FeedCloudTagbasesvr$StFilterTagBaseInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"tagNames"}, new Object[]{""}, FeedCloudTagbasesvr$StFilterTagBaseInfoReq.class);
    public final PBRepeatField<String> tagNames = PBField.initRepeat(PBStringField.__repeatHelper__);
}

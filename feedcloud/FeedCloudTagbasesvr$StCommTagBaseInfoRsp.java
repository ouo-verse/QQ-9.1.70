package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagbasesvr$StCommTagBaseInfoRsp extends MessageMicro<FeedCloudTagbasesvr$StCommTagBaseInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"allCategorys"}, new Object[]{""}, FeedCloudTagbasesvr$StCommTagBaseInfoRsp.class);
    public final PBRepeatField<String> allCategorys = PBField.initRepeat(PBStringField.__repeatHelper__);
}

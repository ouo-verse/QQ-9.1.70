package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvAudienceSvr$FindAudienceReq extends MessageMicro<KtvAudienceSvr$FindAudienceReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"users"}, new Object[]{0L}, KtvAudienceSvr$FindAudienceReq.class);
    public final PBRepeatField<Long> users = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}

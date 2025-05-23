package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StBatchGetContactReq extends MessageMicro<INTERFACE$StBatchGetContactReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"appids"}, new Object[]{""}, INTERFACE$StBatchGetContactReq.class);
    public final PBRepeatField<String> appids = PBField.initRepeat(PBStringField.__repeatHelper__);
}

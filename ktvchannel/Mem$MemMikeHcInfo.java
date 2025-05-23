package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class Mem$MemMikeHcInfo extends MessageMicro<Mem$MemMikeHcInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"vct_wait_uid"}, new Object[]{0L}, Mem$MemMikeHcInfo.class);
    public final PBRepeatField<Long> vct_wait_uid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}

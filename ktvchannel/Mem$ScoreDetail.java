package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class Mem$ScoreDetail extends MessageMicro<Mem$ScoreDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"vct_score"}, new Object[]{0}, Mem$ScoreDetail.class);
    public final PBRepeatField<Integer> vct_score = PBField.initRepeat(PBInt32Field.__repeatHelper__);
}

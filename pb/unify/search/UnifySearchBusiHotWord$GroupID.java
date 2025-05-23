package pb.unify.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchBusiHotWord$GroupID extends MessageMicro<UnifySearchBusiHotWord$GroupID> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"rpt_group_mask"}, new Object[]{0L}, UnifySearchBusiHotWord$GroupID.class);
    public final PBRepeatField<Long> rpt_group_mask = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}

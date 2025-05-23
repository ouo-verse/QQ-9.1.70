package pb.unite.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UniteSearch$TabItemGroup extends MessageMicro<UniteSearch$TabItemGroup> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 24}, new String[]{"tab_name", "rpt_group_mask"}, new Object[]{ByteStringMicro.EMPTY, 0L}, UniteSearch$TabItemGroup.class);
    public final PBBytesField tab_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Long> rpt_group_mask = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}

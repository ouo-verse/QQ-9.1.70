package nearby_interact_state;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class interact_value$InteractValue extends MessageMicro<interact_value$InteractValue> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_one_interact"}, new Object[]{null}, interact_value$InteractValue.class);
    public final PBRepeatMessageField<interact_value$OneInteract> rpt_one_interact = PBField.initRepeatMessage(interact_value$OneInteract.class);
}

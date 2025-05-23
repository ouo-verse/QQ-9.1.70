package localpb.richMsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class MixedMsg$Msg extends MessageMicro<MixedMsg$Msg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"elems"}, new Object[]{null}, MixedMsg$Msg.class);
    public final PBRepeatMessageField<MixedMsg$Elem> elems = PBField.initRepeatMessage(MixedMsg$Elem.class);
}

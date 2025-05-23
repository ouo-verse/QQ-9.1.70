package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$RichText extends MessageMicro<appoint_define$RichText> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_elems"}, new Object[]{null}, appoint_define$RichText.class);
    public final PBRepeatMessageField<appoint_define$Elem> rpt_msg_elems = PBField.initRepeatMessage(appoint_define$Elem.class);
}

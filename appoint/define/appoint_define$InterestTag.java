package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$InterestTag extends MessageMicro<appoint_define$InterestTag> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_tag_type", "rpt_msg_tag_list"}, new Object[]{0, null}, appoint_define$InterestTag.class);
    public final PBUInt32Field uint32_tag_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<appoint_define$InterestItem> rpt_msg_tag_list = PBField.initRepeatMessage(appoint_define$InterestItem.class);
}

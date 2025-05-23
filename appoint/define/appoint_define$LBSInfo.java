package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$LBSInfo extends MessageMicro<appoint_define$LBSInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_gps", "rpt_msg_wifis", "rpt_msg_cells"}, new Object[]{null, null, null}, appoint_define$LBSInfo.class);
    public appoint_define$GPS msg_gps = new appoint_define$GPS();
    public final PBRepeatMessageField<appoint_define$Wifi> rpt_msg_wifis = PBField.initRepeatMessage(appoint_define$Wifi.class);
    public final PBRepeatMessageField<appoint_define$Cell> rpt_msg_cells = PBField.initRepeatMessage(appoint_define$Cell.class);
}

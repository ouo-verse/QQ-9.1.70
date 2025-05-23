package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class msg_ctrl$MsgCtrl extends MessageMicro<msg_ctrl$MsgCtrl> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"msg_flag", "resv_resv_info"}, new Object[]{0, null}, msg_ctrl$MsgCtrl.class);
    public final PBUInt32Field msg_flag = PBField.initUInt32(0);
    public msg_ctrl$ResvResvInfo resv_resv_info = new msg_ctrl$ResvResvInfo();
}

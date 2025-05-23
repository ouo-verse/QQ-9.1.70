package msf.msgsvc;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.msg.im_msg_head$InstCtrl;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class msg_svc$Trans0x211 extends MessageMicro<msg_svc$Trans0x211> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48, 56}, new String[]{"to_uin", "cc_cmd", "inst_ctrl", PreloadTRTCPlayerParams.KEY_SIG, "c2c_type", "service_type", "dataline_flag"}, new Object[]{0L, 0, null, ByteStringMicro.EMPTY, 0, 0, 0}, msg_svc$Trans0x211.class);
    public final PBUInt64Field to_uin = PBField.initUInt64(0);
    public final PBUInt32Field cc_cmd = PBField.initUInt32(0);
    public im_msg_head$InstCtrl inst_ctrl = new im_msg_head$InstCtrl();
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field c2c_type = PBField.initUInt32(0);
    public final PBUInt32Field service_type = PBField.initUInt32(0);
    public final PBUInt32Field dataline_flag = PBField.initUInt32(0);
}

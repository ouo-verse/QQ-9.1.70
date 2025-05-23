package msf.msgcomm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class msg_comm$AppShareInfo extends MessageMicro<msg_comm$AppShareInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"appshare_id", "appshare_cookie", "appshare_resource"}, new Object[]{0, ByteStringMicro.EMPTY, null}, msg_comm$AppShareInfo.class);
    public final PBUInt32Field appshare_id = PBField.initUInt32(0);
    public final PBBytesField appshare_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public msg_comm$PluginInfo appshare_resource = new msg_comm$PluginInfo();
}

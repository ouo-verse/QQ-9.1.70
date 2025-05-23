package pttcenterservice;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class PttCenter$ServerListInfo extends MessageMicro<PttCenter$ServerListInfo> {
    public static final int UINT32_UP_IP_FIELD_NUMBER = 1;
    public static final int UINT32_UP_PORT_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_up_ip", "uint32_up_port"}, new Object[]{0, 0}, PttCenter$ServerListInfo.class);
    public final PBUInt32Field uint32_up_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_up_port = PBField.initUInt32(0);
}

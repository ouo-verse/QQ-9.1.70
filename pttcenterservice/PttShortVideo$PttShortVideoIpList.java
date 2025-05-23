package pttcenterservice;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class PttShortVideo$PttShortVideoIpList extends MessageMicro<PttShortVideo$PttShortVideoIpList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_ip", "uint32_port"}, new Object[]{0, 0}, PttShortVideo$PttShortVideoIpList.class);
    public final PBUInt32Field uint32_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_port = PBField.initUInt32(0);
}

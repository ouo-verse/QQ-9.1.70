package im.oidb.wifi_poi_group.cmd0x8e9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class cmd0x8e9$VisitorInfo extends MessageMicro<cmd0x8e9$VisitorInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_visitor_uin", "uint32_visitor_status"}, new Object[]{0L, 0}, cmd0x8e9$VisitorInfo.class);
    public final PBUInt64Field uint64_visitor_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_visitor_status = PBField.initUInt32(0);
}

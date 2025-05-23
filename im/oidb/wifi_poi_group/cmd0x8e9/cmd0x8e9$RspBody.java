package im.oidb.wifi_poi_group.cmd0x8e9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.im.oidb.hotchat.Common$WifiPOIInfo;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class cmd0x8e9$RspBody extends MessageMicro<cmd0x8e9$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"poi_info", "rpt_rsp_visitor_info"}, new Object[]{null, null}, cmd0x8e9$RspBody.class);
    public Common$WifiPOIInfo poi_info = new Common$WifiPOIInfo();
    public final PBRepeatMessageField<cmd0x8e9$VisitorInfo> rpt_rsp_visitor_info = PBField.initRepeatMessage(cmd0x8e9$VisitorInfo.class);
}

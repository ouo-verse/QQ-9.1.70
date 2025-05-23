package com.tencent.ecommerce.repo.proto.ecom.window_info_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECWindowInfoSvr$SendWindowInfoToXWorldRsp extends MessageMicro<ECWindowInfoSvr$SendWindowInfoToXWorldRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 58, 66, 74, 80, 162}, new String[]{"right_status", "open_right_url", "window_master_url", "window_guest_url", "window_total_num_master", "window_total_num_guest", "order_url", "goods_url", "honor_king_url", "window_king_total_num_guest", "show_window_infos"}, new Object[]{0, "", "", "", 0, 0, "", "", "", 0, null}, ECWindowInfoSvr$SendWindowInfoToXWorldRsp.class);
    public final PBInt32Field right_status = PBField.initInt32(0);
    public final PBStringField open_right_url = PBField.initString("");
    public final PBStringField window_master_url = PBField.initString("");
    public final PBStringField window_guest_url = PBField.initString("");
    public final PBInt32Field window_total_num_master = PBField.initInt32(0);
    public final PBInt32Field window_total_num_guest = PBField.initInt32(0);
    public final PBStringField order_url = PBField.initString("");
    public final PBStringField goods_url = PBField.initString("");
    public final PBStringField honor_king_url = PBField.initString("");
    public final PBInt32Field window_king_total_num_guest = PBField.initInt32(0);
    public final PBRepeatMessageField<ECWindowInfoSvr$ShowWindowInfo> show_window_infos = PBField.initRepeatMessage(ECWindowInfoSvr$ShowWindowInfo.class);
}

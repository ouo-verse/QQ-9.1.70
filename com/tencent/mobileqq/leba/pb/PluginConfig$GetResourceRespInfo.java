package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;

/* loaded from: classes15.dex */
public final class PluginConfig$GetResourceRespInfo extends MessageMicro<PluginConfig$GetResourceRespInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 66, 80, 90, 96, 106}, new String[]{IPreloadServiceProxy.KEY_RESID, "state", "res_seq", "sub_type", "res_name", "icon_url", "jump_url", "res_conf", "can_change_state", "pkg_name", "simple_mode", "grid_icon_url"}, new Object[]{0, 0, 0, 0, "", "", "", "", 0, "", 0, ""}, PluginConfig$GetResourceRespInfo.class);
    public final PBUInt32Field res_id = PBField.initUInt32(0);
    public final PBUInt32Field state = PBField.initUInt32(0);
    public final PBUInt32Field res_seq = PBField.initUInt32(0);
    public final PBUInt32Field sub_type = PBField.initUInt32(0);
    public final PBStringField res_name = PBField.initString("");
    public final PBStringField icon_url = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField res_conf = PBField.initString("");
    public final PBUInt32Field can_change_state = PBField.initUInt32(0);
    public final PBStringField pkg_name = PBField.initString("");
    public final PBUInt32Field simple_mode = PBField.initUInt32(0);
    public final PBStringField grid_icon_url = PBField.initString("");
}

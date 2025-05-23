package msf.msgcomm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;

/* loaded from: classes28.dex */
public final class msg_comm$PluginInfo extends MessageMicro<msg_comm$PluginInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 58, 66, 74, 82, 90}, new String[]{IPreloadServiceProxy.KEY_RESID, "pkg_name", "new_ver", "res_type", "lan_type", "priority", "res_name", "res_desc", "res_url_big", "res_url_small", "res_conf"}, new Object[]{0, "", 0, 0, 0, 0, "", "", "", "", ""}, msg_comm$PluginInfo.class);
    public final PBUInt32Field res_id = PBField.initUInt32(0);
    public final PBStringField pkg_name = PBField.initString("");
    public final PBUInt32Field new_ver = PBField.initUInt32(0);
    public final PBUInt32Field res_type = PBField.initUInt32(0);
    public final PBUInt32Field lan_type = PBField.initUInt32(0);
    public final PBUInt32Field priority = PBField.initUInt32(0);
    public final PBStringField res_name = PBField.initString("");
    public final PBStringField res_desc = PBField.initString("");
    public final PBStringField res_url_big = PBField.initString("");
    public final PBStringField res_url_small = PBField.initString("");
    public final PBStringField res_conf = PBField.initString("");
}

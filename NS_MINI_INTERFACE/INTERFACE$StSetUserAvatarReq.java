package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StSetUserAvatarReq extends MessageMicro<INTERFACE$StSetUserAvatarReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50}, new String[]{"extInfo", "appid", "uin", "set_type", "item_id", "busi_info"}, new Object[]{null, "", "", 0, "", ""}, INTERFACE$StSetUserAvatarReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField appid = PBField.initString("");
    public final PBStringField uin = PBField.initString("");
    public final PBInt32Field set_type = PBField.initInt32(0);
    public final PBStringField item_id = PBField.initString("");
    public final PBStringField busi_info = PBField.initString("");
}

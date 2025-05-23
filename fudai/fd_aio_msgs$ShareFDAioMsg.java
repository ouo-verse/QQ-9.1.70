package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class fd_aio_msgs$ShareFDAioMsg extends MessageMicro<fd_aio_msgs$ShareFDAioMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 90, 96, 104, 170, 178}, new String[]{"host_uin", "fdid", "share_meta", VasQQSettingMeImpl.EXPIRE_TIME, "fd_txt", "busi_id", "theme_id", "aio_tails", "high_light_msg"}, new Object[]{0L, "", null, 0, "", 0, 0, "", ""}, fd_aio_msgs$ShareFDAioMsg.class);
    public final PBUInt64Field host_uin = PBField.initUInt64(0);
    public final PBStringField fdid = PBField.initString("");
    public fd_comm$FDShareMeta share_meta = new fd_comm$FDShareMeta();
    public final PBUInt32Field expire_time = PBField.initUInt32(0);
    public final PBStringField fd_txt = PBField.initString("");
    public final PBUInt32Field busi_id = PBField.initUInt32(0);
    public final PBUInt32Field theme_id = PBField.initUInt32(0);
    public final PBStringField aio_tails = PBField.initString("");
    public final PBStringField high_light_msg = PBField.initString("");
}

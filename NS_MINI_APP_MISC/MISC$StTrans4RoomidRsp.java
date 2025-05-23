package NS_MINI_APP_MISC;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MISC$StTrans4RoomidRsp extends MessageMicro<MISC$StTrans4RoomidRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"roomid", "openid", "tinyid"}, new Object[]{0L, "", 0L}, MISC$StTrans4RoomidRsp.class);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
    public final PBStringField openid = PBField.initString("");
    public final PBUInt64Field tinyid = PBField.initUInt64(0);
}

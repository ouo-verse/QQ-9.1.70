package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StUpdatableMsgShareInfo extends MessageMicro<INTERFACE$StUpdatableMsgShareInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"scene", "groupId", "chatUin", "subScene"}, new Object[]{0, "", "", 0}, INTERFACE$StUpdatableMsgShareInfo.class);
    public final PBUInt32Field scene = PBField.initUInt32(0);
    public final PBStringField groupId = PBField.initString("");
    public final PBStringField chatUin = PBField.initString("");
    public final PBUInt32Field subScene = PBField.initUInt32(0);
}

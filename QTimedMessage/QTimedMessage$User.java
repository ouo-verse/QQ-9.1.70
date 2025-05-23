package QTimedMessage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QTimedMessage$User extends MessageMicro<QTimedMessage$User> {
    public static final int GROUP_CODE = 1;
    public static final int GTALK_CODE = 2;
    public static final int QQ_UIN = 3;
    public static final int SYSTEM_UIN = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"enum_uin_type", "uint64_uin"}, new Object[]{1, 0L}, QTimedMessage$User.class);
    public final PBEnumField enum_uin_type = PBField.initEnum(1);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
}

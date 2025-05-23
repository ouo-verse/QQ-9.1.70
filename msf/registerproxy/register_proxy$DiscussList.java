package msf.registerproxy;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class register_proxy$DiscussList extends MessageMicro<register_proxy$DiscussList> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field discuss_code = PBField.initUInt64(0);
    public final PBUInt64Field discuss_seq = PBField.initUInt64(0);
    public final PBUInt64Field member_seq = PBField.initUInt64(0);
    public final PBUInt64Field info_seq = PBField.initUInt64(0);
    public final PBBoolField bHotGroup = PBField.initBool(false);
    public final PBUInt64Field redpack_time = PBField.initUInt64(0);
    public final PBBoolField has_msg = PBField.initBool(false);
    public final PBInt64Field dicuss_flag = PBField.initInt64(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64}, new String[]{"discuss_code", "discuss_seq", "member_seq", "info_seq", "bHotGroup", "redpack_time", "has_msg", "dicuss_flag"}, new Object[]{0L, 0L, 0L, 0L, bool, 0L, bool, 0L}, register_proxy$DiscussList.class);
    }
}

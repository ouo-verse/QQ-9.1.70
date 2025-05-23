package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StUserInfoExtra extends MessageMicro<INTERFACE$StUserInfoExtra> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField uin = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBBoolField is_qq_vip = PBField.initBool(false);
    public final PBBoolField is_qq_svip = PBField.initBool(false);
    public final PBBoolField is_year_vip = PBField.initBool(false);
    public final PBBoolField is_yellow_vip = PBField.initBool(false);
    public final PBBoolField is_yellow_svip = PBField.initBool(false);
    public final PBBoolField is_yellow_year_vip = PBField.initBool(false);
    public final PBInt32Field level_of_qq_vip = PBField.initInt32(0);
    public final PBInt32Field level_of_yellow_vip = PBField.initInt32(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 64, 72, 80}, new String[]{"uin", "openid", "is_qq_vip", "is_qq_svip", "is_year_vip", "is_yellow_vip", "is_yellow_svip", "is_yellow_year_vip", "level_of_qq_vip", "level_of_yellow_vip"}, new Object[]{"", "", bool, bool, bool, bool, bool, bool, 0, 0}, INTERFACE$StUserInfoExtra.class);
    }
}

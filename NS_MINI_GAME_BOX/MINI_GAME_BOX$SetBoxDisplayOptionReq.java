package NS_MINI_GAME_BOX;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MINI_GAME_BOX$SetBoxDisplayOptionReq extends MessageMicro<MINI_GAME_BOX$SetBoxDisplayOptionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"appid", "allow_display", "duration"}, new Object[]{"", Boolean.FALSE, 0L}, MINI_GAME_BOX$SetBoxDisplayOptionReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBBoolField allow_display = PBField.initBool(false);
    public final PBInt64Field duration = PBField.initInt64(0);
}

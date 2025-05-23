package com.tencent.jungle.weather.proto;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class Oidb_0xca6$ReqBody extends MessageMicro<Oidb_0xca6$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 48, 56}, new String[]{"city", GdtGetUserInfoHandler.KEY_AREA, "type", "date", "adcode", "area_id", "use_history"}, new Object[]{"", "", 0, "", 0, 0, 0}, Oidb_0xca6$ReqBody.class);
    public final PBStringField city = PBField.initString("");
    public final PBStringField area = PBField.initString("");
    public final PBRepeatField<Integer> type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBStringField date = PBField.initString("");
    public final PBUInt32Field adcode = PBField.initUInt32(0);
    public final PBUInt32Field area_id = PBField.initUInt32(0);
    public final PBUInt32Field use_history = PBField.initUInt32(0);
}

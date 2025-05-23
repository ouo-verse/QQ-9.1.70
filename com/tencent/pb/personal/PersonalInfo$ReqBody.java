package com.tencent.pb.personal;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes22.dex */
public final class PersonalInfo$ReqBody extends MessageMicro<PersonalInfo$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"itemid", "fontid", "fonttype"}, new Object[]{0, 0, 0}, PersonalInfo$ReqBody.class);
    public final PBInt32Field itemid = PBField.initInt32(0);
    public final PBInt32Field fontid = PBField.initInt32(0);
    public final PBInt32Field fonttype = PBField.initInt32(0);
}

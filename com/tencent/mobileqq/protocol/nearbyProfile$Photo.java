package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes35.dex */
public final class nearbyProfile$Photo extends MessageMicro<nearbyProfile$Photo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"pic_id", "pic_url"}, new Object[]{0, ""}, nearbyProfile$Photo.class);
    public final PBUInt32Field pic_id = PBField.initUInt32(0);
    public final PBStringField pic_url = PBField.initString("");
}

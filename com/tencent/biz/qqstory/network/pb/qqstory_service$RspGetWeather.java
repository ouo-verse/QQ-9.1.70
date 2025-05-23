package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class qqstory_service$RspGetWeather extends MessageMicro<qqstory_service$RspGetWeather> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"result", "temperature", "wea_desc"}, new Object[]{null, 0, ""}, qqstory_service$RspGetWeather.class);
    public qqstory_struct$ErrorInfo result = new qqstory_struct$ErrorInfo();
    public final PBInt32Field temperature = PBField.initInt32(0);
    public final PBStringField wea_desc = PBField.initString("");
}

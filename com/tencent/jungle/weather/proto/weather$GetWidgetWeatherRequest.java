package com.tencent.jungle.weather.proto;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class weather$GetWidgetWeatherRequest extends MessageMicro<weather$GetWidgetWeatherRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"adcode", "city", GdtGetUserInfoHandler.KEY_AREA}, new Object[]{0, "", ""}, weather$GetWidgetWeatherRequest.class);
    public final PBUInt32Field adcode = PBField.initUInt32(0);
    public final PBStringField city = PBField.initString("");
    public final PBStringField area = PBField.initString("");
}

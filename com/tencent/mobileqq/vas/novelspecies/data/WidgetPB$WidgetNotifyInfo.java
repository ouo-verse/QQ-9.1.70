package com.tencent.mobileqq.vas.novelspecies.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes20.dex */
public final class WidgetPB$WidgetNotifyInfo extends MessageMicro<WidgetPB$WidgetNotifyInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48}, new String[]{"big_background_pic", "small_background_pic", "element_pic", "msg", "expire_timestamp", "type"}, new Object[]{"", "", "", "", 0L, 0}, WidgetPB$WidgetNotifyInfo.class);
    public final PBStringField big_background_pic = PBField.initString("");
    public final PBStringField small_background_pic = PBField.initString("");
    public final PBStringField element_pic = PBField.initString("");

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f310081msg = PBField.initString("");
    public final PBInt64Field expire_timestamp = PBField.initInt64(0);
    public final PBEnumField type = PBField.initEnum(0);
}

package com.tencent.qzone.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes25.dex */
public final class QZoneOfficialAccountBase$PicInfo extends MessageMicro<QZoneOfficialAccountBase$PicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"pic_type", "pic_url"}, new Object[]{0, ""}, QZoneOfficialAccountBase$PicInfo.class);
    public final PBInt32Field pic_type = PBField.initInt32(0);
    public final PBStringField pic_url = PBField.initString("");
}

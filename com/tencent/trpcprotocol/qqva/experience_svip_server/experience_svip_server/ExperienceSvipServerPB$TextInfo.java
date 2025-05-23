package com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class ExperienceSvipServerPB$TextInfo extends MessageMicro<ExperienceSvipServerPB$TextInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48}, new String[]{"text_type", "title", "sub_title", "pay_btn_title", "pay_btn_corner", "pay_index"}, new Object[]{0, "", "", "", "", 0}, ExperienceSvipServerPB$TextInfo.class);
    public final PBEnumField text_type = PBField.initEnum(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField sub_title = PBField.initString("");
    public final PBStringField pay_btn_title = PBField.initString("");
    public final PBStringField pay_btn_corner = PBField.initString("");
    public final PBInt32Field pay_index = PBField.initInt32(0);
}

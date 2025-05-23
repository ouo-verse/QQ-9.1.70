package com.tencent.pb.troop.intelligentmanage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class IntelligentManageSvrPB$Entrance extends MessageMicro<IntelligentManageSvrPB$Entrance> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"title", "url", "privilege", "need_guanjia_admin"}, new Object[]{"", "", 0, Boolean.FALSE}, IntelligentManageSvrPB$Entrance.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field privilege = PBField.initUInt32(0);
    public final PBBoolField need_guanjia_admin = PBField.initBool(false);
}

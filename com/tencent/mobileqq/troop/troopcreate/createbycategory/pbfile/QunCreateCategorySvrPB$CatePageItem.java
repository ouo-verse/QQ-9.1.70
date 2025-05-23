package com.tencent.mobileqq.troop.troopcreate.createbycategory.pbfile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes19.dex */
public final class QunCreateCategorySvrPB$CatePageItem extends MessageMicro<QunCreateCategorySvrPB$CatePageItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"name", "desc", "icon", "cate_type", "jump_url"}, new Object[]{"", "", "", 0, ""}, QunCreateCategorySvrPB$CatePageItem.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBUInt32Field cate_type = PBField.initUInt32(0);
    public final PBStringField jump_url = PBField.initString("");
}

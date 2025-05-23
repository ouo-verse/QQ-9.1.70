package com.tencent.mobileqq.troop.troopcreate.createbycategory.pbfile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import s4.c;

/* loaded from: classes19.dex */
public final class QunCreateCategorySvrPB$CateDescItem extends MessageMicro<QunCreateCategorySvrPB$CateDescItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"name", "desc", "icon", c.PICS}, new Object[]{"", "", "", null}, QunCreateCategorySvrPB$CateDescItem.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBRepeatMessageField<QunCreateCategorySvrPB$PicInfo> pics = PBField.initRepeatMessage(QunCreateCategorySvrPB$PicInfo.class);
}

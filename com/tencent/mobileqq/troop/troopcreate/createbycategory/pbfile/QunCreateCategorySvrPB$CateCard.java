package com.tencent.mobileqq.troop.troopcreate.createbycategory.pbfile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes19.dex */
public final class QunCreateCategorySvrPB$CateCard extends MessageMicro<QunCreateCategorySvrPB$CateCard> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82}, new String[]{"title", "list"}, new Object[]{"", null}, QunCreateCategorySvrPB$CateCard.class);
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<QunCreateCategorySvrPB$CatePageItem> list = PBField.initRepeatMessage(QunCreateCategorySvrPB$CatePageItem.class);
}

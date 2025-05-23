package com.tencent.mobileqq.troop.troopcreate.createbycategory.pbfile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes19.dex */
public final class QunCreateCategorySvrPB$QueryRsp extends MessageMicro<QunCreateCategorySvrPB$QueryRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"page", "desc"}, new Object[]{null, null}, QunCreateCategorySvrPB$QueryRsp.class);
    public QunCreateCategorySvrPB$CatePage page = new MessageMicro<QunCreateCategorySvrPB$CatePage>() { // from class: com.tencent.mobileqq.troop.troopcreate.createbycategory.pbfile.QunCreateCategorySvrPB$CatePage
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 82}, new String[]{"title", "desc", "cards"}, new Object[]{"", "", null}, QunCreateCategorySvrPB$CatePage.class);
        public final PBStringField title = PBField.initString("");
        public final PBStringField desc = PBField.initString("");
        public final PBRepeatMessageField<QunCreateCategorySvrPB$CateCard> cards = PBField.initRepeatMessage(QunCreateCategorySvrPB$CateCard.class);
    };
    public QunCreateCategorySvrPB$CateDesc desc = new MessageMicro<QunCreateCategorySvrPB$CateDesc>() { // from class: com.tencent.mobileqq.troop.troopcreate.createbycategory.pbfile.QunCreateCategorySvrPB$CateDesc
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"list"}, new Object[]{null}, QunCreateCategorySvrPB$CateDesc.class);
        public final PBRepeatMessageField<QunCreateCategorySvrPB$CateDescItem> list = PBField.initRepeatMessage(QunCreateCategorySvrPB$CateDescItem.class);
    };
}

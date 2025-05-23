package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class MedicalArticle$MedicalArticleDate extends MessageMicro<MedicalArticle$MedicalArticleDate> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"title", "author", "author_title", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "docid"}, new Object[]{"", "", "", "", ""}, MedicalArticle$MedicalArticleDate.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField author = PBField.initString("");
    public final PBStringField author_title = PBField.initString("");
    public final PBStringField link = PBField.initString("");
    public final PBStringField docid = PBField.initString("");
}

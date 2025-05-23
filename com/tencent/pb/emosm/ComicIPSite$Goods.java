package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ComicIPSite$Goods extends MessageMicro<ComicIPSite$Goods> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82}, new String[]{"cover", "goodsTags", "id", "name", "price", "saleTags", "svipPrice", "url", "moreUrl", "saleNum"}, new Object[]{"", "", "", "", "", "", "", "", "", ""}, ComicIPSite$Goods.class);
    public final PBStringField cover = PBField.initString("");
    public final PBStringField goodsTags = PBField.initString("");

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f342122id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField price = PBField.initString("");
    public final PBStringField saleTags = PBField.initString("");
    public final PBStringField svipPrice = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField moreUrl = PBField.initString("");
    public final PBStringField saleNum = PBField.initString("");
}

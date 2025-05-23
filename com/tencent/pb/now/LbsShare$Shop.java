package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class LbsShare$Shop extends MessageMicro<LbsShare$Shop> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 72, 80}, new String[]{"id", "name", "logo", "url", "detail", "discount", "price", "soldnum", "has_tuan", "has_quan"}, new Object[]{"", "", "", "", "", "", "", "", 0, 0}, LbsShare$Shop.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f342138id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField detail = PBField.initString("");
    public final PBStringField discount = PBField.initString("");
    public final PBStringField price = PBField.initString("");
    public final PBStringField soldnum = PBField.initString("");
    public final PBUInt32Field has_tuan = PBField.initUInt32(0);
    public final PBUInt32Field has_quan = PBField.initUInt32(0);
}

package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class publicaccount_recommend$BusinessRecommend extends MessageMicro<publicaccount_recommend$BusinessRecommend> {
    public static final int ACCOUNT_FIELD_NUMBER = 5;
    public static final int ACCOUNT_FLAG_FIELD_NUMBER = 15;
    public static final int CATEGORY_FIELD_NUMBER = 11;
    public static final int CS_FIELD_NUMBER = 10;
    public static final int DESC_FIELD_NUMBER = 6;
    public static final int FILTER_FIELD_NUMBER = 14;
    public static final int IC_FIELD_NUMBER = 12;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int ISVERIFIED_FIELD_NUMBER = 13;
    public static final int KFUIN_FIELD_NUMBER = 8;
    public static final int NAMEACCOUNT_FIELD_NUMBER = 7;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int SI_FIELD_NUMBER = 9;
    public static final int SOURCE_FIELD_NUMBER = 2;
    public static final int UIN_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 64, 74, 82, 90, 98, 106, 112, 120}, new String[]{"id", "source", "uin", "name", "account", "desc", "nameAccount", "kfuin", "si", "cs", "category", "ic", "isverified", "filter", "account_flag"}, new Object[]{0, 0, 0L, "", "", "", "", 0L, "", "", "", "", "", 0, 0}, publicaccount_recommend$BusinessRecommend.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f247290id = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField account = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBStringField nameAccount = PBField.initString("");
    public final PBUInt64Field kfuin = PBField.initUInt64(0);

    /* renamed from: si, reason: collision with root package name */
    public final PBStringField f247291si = PBField.initString("");

    /* renamed from: cs, reason: collision with root package name */
    public final PBStringField f247288cs = PBField.initString("");
    public final PBStringField category = PBField.initString("");

    /* renamed from: ic, reason: collision with root package name */
    public final PBStringField f247289ic = PBField.initString("");
    public final PBStringField isverified = PBField.initString("");
    public final PBUInt32Field filter = PBField.initUInt32(0);
    public final PBUInt32Field account_flag = PBField.initUInt32(0);
}

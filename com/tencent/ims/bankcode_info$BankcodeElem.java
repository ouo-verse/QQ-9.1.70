package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class bankcode_info$BankcodeElem extends MessageMicro<bankcode_info$BankcodeElem> {
    public static final int BANKCODE_ATTR_FIELD_NUMBER = 3;
    public static final int BANKCODE_HIDDEN_POS_FIELD_NUMBER = 5;
    public static final int BANKCODE_POS_FIELD_NUMBER = 4;
    public static final int CLEAN_BANKCODE_FIELD_NUMBER = 2;
    public static final int RAW_BANKCODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"raw_bankcode", "clean_bankcode", "bankcode_attr", "bankcode_pos", "bankcode_hidden_pos"}, new Object[]{"", "", 0, null, null}, bankcode_info$BankcodeElem.class);
    public final PBStringField raw_bankcode = PBField.initString("");
    public final PBStringField clean_bankcode = PBField.initString("");
    public final PBEnumField bankcode_attr = PBField.initEnum(0);
    public bankcode_info$ElemPos bankcode_pos = new bankcode_info$ElemPos();
    public bankcode_info$ElemPos bankcode_hidden_pos = new bankcode_info$ElemPos();
}

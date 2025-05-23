package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$CorpInfo extends MessageMicro<mobileqq_qidian$CorpInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 74}, new String[]{"str_corp_short_name", "str_corp_intro", "str_homepage", "str_address", "str_corp_call", "str_postcode", "str_logo", "uint64_master_uin", "str_corp_full_name"}, new Object[]{"", "", "", "", "", "", "", 0L, ""}, mobileqq_qidian$CorpInfo.class);
    public final PBStringField str_corp_short_name = PBField.initString("");
    public final PBStringField str_corp_intro = PBField.initString("");
    public final PBStringField str_homepage = PBField.initString("");
    public final PBStringField str_address = PBField.initString("");
    public final PBStringField str_corp_call = PBField.initString("");
    public final PBStringField str_postcode = PBField.initString("");
    public final PBStringField str_logo = PBField.initString("");
    public final PBUInt64Field uint64_master_uin = PBField.initUInt64(0);
    public final PBStringField str_corp_full_name = PBField.initString("");
}

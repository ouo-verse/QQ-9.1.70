package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class NowSummaryCard$MiniCard extends MessageMicro<NowSummaryCard$MiniCard> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field target_id = PBField.initUInt64(0);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
    public final PBStringField sign = PBField.initString("");
    public final PBBoolField is_online = PBField.initBool(false);
    public final PBBoolField is_match = PBField.initBool(false);
    public final PBBoolField is_greet = PBField.initBool(false);
    public final PBStringField origin_tag_text = PBField.initString("");

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 56, 66}, new String[]{"target_id", "nick", "logo", "sign", "is_online", "is_match", "is_greet", "origin_tag_text"}, new Object[]{0L, "", "", "", bool, bool, bool, ""}, NowSummaryCard$MiniCard.class);
    }
}

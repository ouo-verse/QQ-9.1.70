package com.tencent.trpcprotocol.kuolie.surprise_match.surprise_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class SurpriseMatchPB$RecommendRsp extends MessageMicro<SurpriseMatchPB$RecommendRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"ret_code", "err_msg", "cookies", "items", "greet_text", "sub_title"}, new Object[]{0, "", "", null, "", ""}, SurpriseMatchPB$RecommendRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBStringField cookies = PBField.initString("");
    public final PBRepeatMessageField<SurpriseMatchPB$RecommendItem> items = PBField.initRepeatMessage(SurpriseMatchPB$RecommendItem.class);
    public final PBRepeatField<String> greet_text = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField sub_title = PBField.initString("");
}

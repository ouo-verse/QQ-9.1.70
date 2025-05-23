package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class Hongbao$GetRedPacketConfigRsp extends MessageMicro<Hongbao$GetRedPacketConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"quota", "token", "hb_entrys", "hb_tabs"}, new Object[]{null, null, null, null}, Hongbao$GetRedPacketConfigRsp.class);
    public Hongbao$Quota quota = new Hongbao$Quota();
    public Hongbao$Token token = new MessageMicro<Hongbao$Token>() { // from class: com.tencent.mobileqq.qwallet.pb.Hongbao$Token
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"tokens", "allow_custom_token", "allow_custom_token_flag"}, new Object[]{"", Boolean.FALSE, 0}, Hongbao$Token.class);
        public final PBRepeatField<String> tokens = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBBoolField allow_custom_token = PBField.initBool(false);
        public final PBInt32Field allow_custom_token_flag = PBField.initInt32(0);
    };
    public final PBRepeatMessageField<Hongbao$HbEntry> hb_entrys = PBField.initRepeatMessage(Hongbao$HbEntry.class);
    public final PBRepeatMessageField<Hongbao$HbTab> hb_tabs = PBField.initRepeatMessage(Hongbao$HbTab.class);
}

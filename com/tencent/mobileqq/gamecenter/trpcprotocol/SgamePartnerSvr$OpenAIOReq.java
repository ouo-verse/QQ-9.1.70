package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes12.dex */
public final class SgamePartnerSvr$OpenAIOReq extends MessageMicro<SgamePartnerSvr$OpenAIOReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"from_openaio_id", "to_openaio_id"}, new Object[]{"", ""}, SgamePartnerSvr$OpenAIOReq.class);
    public final PBStringField from_openaio_id = PBField.initString("");
    public final PBStringField to_openaio_id = PBField.initString("");
}

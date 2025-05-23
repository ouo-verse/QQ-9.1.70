package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes12.dex */
public final class SgamePartnerSvr$GetGameMsgPartnersRsp extends MessageMicro<SgamePartnerSvr$GetGameMsgPartnersRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"partners", "openaio_id", "partner_page_url", "title"}, new Object[]{null, "", "", ""}, SgamePartnerSvr$GetGameMsgPartnersRsp.class);
    public final PBRepeatMessageField<SgamePartnerSvr$GameMsgPartner> partners = PBField.initRepeatMessage(SgamePartnerSvr$GameMsgPartner.class);
    public final PBStringField openaio_id = PBField.initString("");
    public final PBStringField partner_page_url = PBField.initString("");
    public final PBStringField title = PBField.initString("");
}

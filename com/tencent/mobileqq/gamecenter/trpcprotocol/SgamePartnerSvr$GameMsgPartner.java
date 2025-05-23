package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes12.dex */
public final class SgamePartnerSvr$GameMsgPartner extends MessageMicro<SgamePartnerSvr$GameMsgPartner> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56, 66, 74}, new String[]{"uid", "openaio_id", "profile_url", "nick", "avatar", "gender", "rank", "rank_pic", "rec_tags_text"}, new Object[]{"", "", "", "", "", 0, 0, "", ""}, SgamePartnerSvr$GameMsgPartner.class);
    public final PBStringField uid = PBField.initString("");
    public final PBStringField openaio_id = PBField.initString("");
    public final PBStringField profile_url = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBStringField avatar = PBField.initString("");
    public final PBInt32Field gender = PBField.initInt32(0);
    public final PBInt32Field rank = PBField.initInt32(0);
    public final PBStringField rank_pic = PBField.initString("");
    public final PBStringField rec_tags_text = PBField.initString("");
}

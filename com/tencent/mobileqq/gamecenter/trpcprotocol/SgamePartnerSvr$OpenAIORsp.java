package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes12.dex */
public final class SgamePartnerSvr$OpenAIORsp extends MessageMicro<SgamePartnerSvr$OpenAIORsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 74}, new String[]{"appid", "from_role_id", "from_openid", "from_tinyid", "to_role_id", "to_openid", "to_tinyid", PreloadTRTCPlayerParams.KEY_SIG}, new Object[]{"", "", "", "", "", "", "", ""}, SgamePartnerSvr$OpenAIORsp.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField from_role_id = PBField.initString("");
    public final PBStringField from_openid = PBField.initString("");
    public final PBStringField from_tinyid = PBField.initString("");
    public final PBStringField to_role_id = PBField.initString("");
    public final PBStringField to_openid = PBField.initString("");
    public final PBStringField to_tinyid = PBField.initString("");
    public final PBStringField sig = PBField.initString("");
}

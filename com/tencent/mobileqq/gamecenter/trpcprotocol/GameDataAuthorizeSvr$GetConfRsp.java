package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameDataAuthorizeSvr$GetConfRsp extends MessageMicro<GameDataAuthorizeSvr$GetConfRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"url", VasQQSettingMeImpl.EXPIRE_TIME}, new Object[]{"", 0L}, GameDataAuthorizeSvr$GetConfRsp.class);
    public final PBStringField url = PBField.initString("");
    public final PBInt64Field expire_time = PBField.initInt64(0);
}

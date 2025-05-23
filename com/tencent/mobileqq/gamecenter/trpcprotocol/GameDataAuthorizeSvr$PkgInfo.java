package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes12.dex */
public final class GameDataAuthorizeSvr$PkgInfo extends MessageMicro<GameDataAuthorizeSvr$PkgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{WadlProxyConsts.CHANNEL, "model", "version", "platform"}, new Object[]{"", "", "", 0}, GameDataAuthorizeSvr$PkgInfo.class);
    public final PBStringField channel = PBField.initString("");
    public final PBStringField model = PBField.initString("");
    public final PBStringField version = PBField.initString("");
    public final PBEnumField platform = PBField.initEnum(0);
}

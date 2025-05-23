package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes12.dex */
public final class GameDataAuthorizeSvr$GetPublicAccountAuthInfoRsp extends MessageMicro<GameDataAuthorizeSvr$GetPublicAccountAuthInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"infos"}, new Object[]{null}, GameDataAuthorizeSvr$GetPublicAccountAuthInfoRsp.class);
    public final PBRepeatMessageField<GameDataAuthorizeSvr$PublicAcountInfo> infos = PBField.initRepeatMessage(GameDataAuthorizeSvr$PublicAcountInfo.class);
}

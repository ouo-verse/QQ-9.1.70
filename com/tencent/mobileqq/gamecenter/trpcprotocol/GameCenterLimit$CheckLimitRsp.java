package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameCenterLimit$CheckLimitRsp extends MessageMicro<GameCenterLimit$CheckLimitRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_limit"}, new Object[]{Boolean.FALSE}, GameCenterLimit$CheckLimitRsp.class);
    public final PBBoolField is_limit = PBField.initBool(false);
}

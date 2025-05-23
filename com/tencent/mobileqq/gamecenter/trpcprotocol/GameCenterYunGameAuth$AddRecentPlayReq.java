package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes12.dex */
public final class GameCenterYunGameAuth$AddRecentPlayReq extends MessageMicro<GameCenterYunGameAuth$AddRecentPlayReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"appid", "version_type", "timestamp"}, new Object[]{"", 0, 0L}, GameCenterYunGameAuth$AddRecentPlayReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBInt32Field version_type = PBField.initInt32(0);
    public final PBInt64Field timestamp = PBField.initInt64(0);
}

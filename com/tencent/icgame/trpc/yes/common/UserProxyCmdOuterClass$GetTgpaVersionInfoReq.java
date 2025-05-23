package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$GetTgpaVersionInfoReq extends MessageMicro<UserProxyCmdOuterClass$GetTgpaVersionInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 802}, new String[]{"game_id", "xid", "has_update", "app_name"}, new Object[]{0, "", Boolean.FALSE, ""}, UserProxyCmdOuterClass$GetTgpaVersionInfoReq.class);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBStringField xid = PBField.initString("");
    public final PBBoolField has_update = PBField.initBool(false);
    public final PBStringField app_name = PBField.initString("");
}

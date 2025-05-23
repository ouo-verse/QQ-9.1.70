package com.tencent.icgame.trpc.yes.common;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YesGameInfoOuterClass$SetUserGameDefaultRoleReq extends MessageMicro<YesGameInfoOuterClass$SetUserGameDefaultRoleReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{GdtGetUserInfoHandler.KEY_AREA, "partition", "uid", "game_id"}, new Object[]{0, 0, 0L, 0}, YesGameInfoOuterClass$SetUserGameDefaultRoleReq.class);
    public final PBUInt32Field area = PBField.initUInt32(0);
    public final PBUInt32Field partition = PBField.initUInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBInt32Field game_id = PBField.initInt32(0);
}

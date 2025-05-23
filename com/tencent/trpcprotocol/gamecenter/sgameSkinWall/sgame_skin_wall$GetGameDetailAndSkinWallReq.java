package com.tencent.trpcprotocol.gamecenter.sgameSkinWall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class sgame_skin_wall$GetGameDetailAndSkinWallReq extends MessageMicro<sgame_skin_wall$GetGameDetailAndSkinWallReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"group_id", "show_uin", "needs"}, new Object[]{0L, 0L, 0}, sgame_skin_wall$GetGameDetailAndSkinWallReq.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt64Field show_uin = PBField.initUInt64(0);
    public final PBRepeatField<Integer> needs = PBField.initRepeat(PBEnumField.__repeatHelper__);
}

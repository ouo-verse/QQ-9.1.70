package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameAuthOuterClass$CancelGameAuthReq extends MessageMicro<GameAuthOuterClass$CancelGameAuthReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uid", "sense", "game_id"}, new Object[]{0L, 0, 0}, GameAuthOuterClass$CancelGameAuthReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBInt32Field sense = PBField.initInt32(0);
    public final PBInt32Field game_id = PBField.initInt32(0);
}

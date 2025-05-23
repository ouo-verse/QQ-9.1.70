package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloBattleObOuterClass$YoloBattleGetOBStatusReq extends MessageMicro<YoloBattleObOuterClass$YoloBattleGetOBStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"ob_id", "game_matrix_ret"}, new Object[]{0L, 0L}, YoloBattleObOuterClass$YoloBattleGetOBStatusReq.class);
    public final PBInt64Field ob_id = PBField.initInt64(0);
    public final PBInt64Field game_matrix_ret = PBField.initInt64(0);
}

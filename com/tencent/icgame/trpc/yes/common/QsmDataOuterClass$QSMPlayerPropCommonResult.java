package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes7.dex */
public final class QsmDataOuterClass$QSMPlayerPropCommonResult extends MessageMicro<QsmDataOuterClass$QSMPlayerPropCommonResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"attack_score", "defend_score", "assist_score", "rank_ratio", "final_score"}, new Object[]{0, 0, 0, 0, 0}, QsmDataOuterClass$QSMPlayerPropCommonResult.class);
    public final PBInt32Field attack_score = PBField.initInt32(0);
    public final PBInt32Field defend_score = PBField.initInt32(0);
    public final PBInt32Field assist_score = PBField.initInt32(0);
    public final PBInt32Field rank_ratio = PBField.initInt32(0);
    public final PBInt32Field final_score = PBField.initInt32(0);
}

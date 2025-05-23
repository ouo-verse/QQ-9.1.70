package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes7.dex */
public final class QsmDataOuterClass$QSMPlayerSpeedCommonResult extends MessageMicro<QsmDataOuterClass$QSMPlayerSpeedCommonResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"collision_num", "drift_score", "use_nitro_score"}, new Object[]{0, 0, 0}, QsmDataOuterClass$QSMPlayerSpeedCommonResult.class);
    public final PBInt32Field collision_num = PBField.initInt32(0);
    public final PBInt32Field drift_score = PBField.initInt32(0);
    public final PBInt32Field use_nitro_score = PBField.initInt32(0);
}

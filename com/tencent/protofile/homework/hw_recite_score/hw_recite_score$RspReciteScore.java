package com.tencent.protofile.homework.hw_recite_score;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class hw_recite_score$RspReciteScore extends MessageMicro<hw_recite_score$RspReciteScore> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"score_grade"}, new Object[]{0}, hw_recite_score$RspReciteScore.class);
    public final PBUInt32Field score_grade = PBField.initUInt32(0);
}

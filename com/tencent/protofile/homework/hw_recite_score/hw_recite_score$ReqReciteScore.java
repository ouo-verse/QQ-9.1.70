package com.tencent.protofile.homework.hw_recite_score;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class hw_recite_score$ReqReciteScore extends MessageMicro<hw_recite_score$ReqReciteScore> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"error_times", "remind_times", "total_time", "total_word"}, new Object[]{0, 0, 0, 0}, hw_recite_score$ReqReciteScore.class);
    public final PBUInt32Field error_times = PBField.initUInt32(0);
    public final PBUInt32Field remind_times = PBField.initUInt32(0);
    public final PBUInt32Field total_time = PBField.initUInt32(0);
    public final PBUInt32Field total_word = PBField.initUInt32(0);
}

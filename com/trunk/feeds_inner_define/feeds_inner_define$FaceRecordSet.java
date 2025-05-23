package com.trunk.feeds_inner_define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class feeds_inner_define$FaceRecordSet extends MessageMicro<feeds_inner_define$FaceRecordSet> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_face_records"}, new Object[]{null}, feeds_inner_define$FaceRecordSet.class);
    public final PBRepeatMessageField<FaceRecord> rpt_face_records = PBField.initRepeatMessage(FaceRecord.class);

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class FaceRecord extends MessageMicro<FaceRecord> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_author_uin", "int32_face_type"}, new Object[]{0L, 0}, FaceRecord.class);
        public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0);
        public final PBInt32Field int32_face_type = PBField.initInt32(0);
    }
}

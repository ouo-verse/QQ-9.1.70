package com.tencent.protofile.group_homework;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class value$HwExamAnswer extends MessageMicro<value$HwExamAnswer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"questionid", "answer", "result", LocalPhotoFaceInfo.SCORE}, new Object[]{"", "", 0, 0}, value$HwExamAnswer.class);
    public final PBStringField questionid = PBField.initString("");
    public final PBStringField answer = PBField.initString("");
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBUInt32Field score = PBField.initUInt32(0);
}

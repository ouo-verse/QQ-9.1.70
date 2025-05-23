package com.tencent.protofile.homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.requests.QCircleRelationGroupRequest;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class hw_submit_homework$ReqSubmitHomework extends MessageMicro<hw_submit_homework$ReqSubmitHomework> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50}, new String[]{"hw_id", QCircleRelationGroupRequest.GROUP_ID, "status", "comment_info", "examination", "openId"}, new Object[]{0L, 0L, 0, null, null, ""}, hw_submit_homework$ReqSubmitHomework.class);
    public final PBUInt64Field hw_id = PBField.initUInt64(0);
    public final PBUInt64Field gid = PBField.initUInt64(0);
    public final PBInt32Field status = PBField.initInt32(0);
    public hw_submit_homework$HwCommentInfo comment_info = new hw_submit_homework$HwCommentInfo();
    public hw_submit_homework$HwExamination examination = new MessageMicro<hw_submit_homework$HwExamination>() { // from class: com.tencent.protofile.homework.hw_submit_homework$HwExamination
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 82, 90, 402}, new String[]{"total_count", "correct_count", "error_count", "undone_count", "total_score", "elapsed_time", "avg_elapsed_time", "difficult", "answer_status", "answer_analyse", "difficult_desc", "answer"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, "", "", null}, hw_submit_homework$HwExamination.class);
        public final PBUInt32Field total_count = PBField.initUInt32(0);
        public final PBUInt32Field correct_count = PBField.initUInt32(0);
        public final PBUInt32Field error_count = PBField.initUInt32(0);
        public final PBUInt32Field undone_count = PBField.initUInt32(0);
        public final PBUInt32Field total_score = PBField.initUInt32(0);
        public final PBUInt32Field elapsed_time = PBField.initUInt32(0);
        public final PBUInt32Field avg_elapsed_time = PBField.initUInt32(0);
        public final PBUInt32Field difficult = PBField.initUInt32(0);
        public final PBUInt32Field answer_status = PBField.initUInt32(0);
        public final PBStringField answer_analyse = PBField.initString("");
        public final PBStringField difficult_desc = PBField.initString("");
        public final PBRepeatMessageField<hw_submit_homework$HwExamAnswer> answer = PBField.initRepeatMessage(hw_submit_homework$HwExamAnswer.class);
    };
    public final PBStringField openId = PBField.initString("");
}

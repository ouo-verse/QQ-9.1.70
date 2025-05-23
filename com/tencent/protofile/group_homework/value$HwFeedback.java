package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class value$HwFeedback extends MessageMicro<value$HwFeedback> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56, 82, 88, 96, 106, 162, 168}, new String[]{"uin", "nick", "head", "status", "remind_ts", "review_ts", "feedback_ts", "content", "content_storage", "correct_rate", "openId", "relation", "user_status"}, new Object[]{0L, "", "", 0, 0L, 0L, 0L, null, 0, 0, "", null, 0}, value$HwFeedback.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField head = PBField.initString("");
    public final PBInt32Field status = PBField.initInt32(0);
    public final PBUInt64Field remind_ts = PBField.initUInt64(0);
    public final PBUInt64Field review_ts = PBField.initUInt64(0);
    public final PBUInt64Field feedback_ts = PBField.initUInt64(0);
    public FbContent content = new FbContent();
    public final PBInt32Field content_storage = PBField.initInt32(0);
    public final PBUInt32Field correct_rate = PBField.initUInt32(0);
    public final PBStringField openId = PBField.initString("");
    public final PBRepeatMessageField<Relation> relation = PBField.initRepeatMessage(Relation.class);
    public final PBUInt32Field user_status = PBField.initUInt32(0);

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class FbContent extends MessageMicro<FbContent> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"main", "comment", "examination"}, new Object[]{null, null, null}, FbContent.class);
        public final PBRepeatMessageField<value$HwCommentInfo> main = PBField.initRepeatMessage(value$HwCommentInfo.class);
        public final PBRepeatMessageField<value$HwCommentInfo> comment = PBField.initRepeatMessage(value$HwCommentInfo.class);
        public value$HwExamination examination = new MessageMicro<value$HwExamination>() { // from class: com.tencent.protofile.group_homework.value$HwExamination
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 82, 90, 402}, new String[]{"total_count", "correct_count", "error_count", "undone_count", "total_score", "elapsed_time", "avg_elapsed_time", "difficult", "answer_status", "answer_analyse", "difficult_desc", "answer"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, "", "", null}, value$HwExamination.class);
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
            public final PBRepeatMessageField<value$HwExamAnswer> answer = PBField.initRepeatMessage(value$HwExamAnswer.class);
        };
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class Relation extends MessageMicro<Relation> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uin", "status", "nick"}, new Object[]{0L, 0, ""}, Relation.class);
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBInt32Field status = PBField.initInt32(0);
        public final PBStringField nick = PBField.initString("");
    }
}

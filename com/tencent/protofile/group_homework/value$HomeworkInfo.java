package com.tencent.protofile.group_homework;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class value$HomeworkInfo extends MessageMicro<value$HomeworkInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field course_id = PBField.initUInt32(0);
    public final PBStringField course_name = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField date = PBField.initString("");
    public final PBBoolField need_feedback = PBField.initBool(false);
    public final PBUInt64Field push_time = PBField.initUInt64(0);
    public final PBUInt64Field feedback_ts = PBField.initUInt64(0);
    public value$MultiMedia multi_media = new value$MultiMedia();
    public final PBUInt64Field team_id = PBField.initUInt64(0);
    public final PBUInt32Field hw_type = PBField.initUInt32(0);
    public value$ExamMsg exam_msg = new MessageMicro<value$ExamMsg>() { // from class: com.tencent.protofile.group_homework.value$ExamMsg
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBStringField difficulty_desc;
        public final PBStringField grade;
        public final PBBytesField key_point;
        public final PBBytesField question_list;
        public final PBUInt32Field sp_id = PBField.initUInt32(0);
        public final PBStringField sp_hw_id = PBField.initString("");
        public final PBStringField material_id = PBField.initString("");
        public final PBUInt32Field difficulty = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 58, 66}, new String[]{"sp_id", "sp_hw_id", "material_id", "difficulty", "key_point", "question_list", "difficulty_desc", "grade"}, new Object[]{0, "", "", 0, byteStringMicro, byteStringMicro, "", ""}, value$ExamMsg.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.key_point = PBField.initBytes(byteStringMicro);
            this.question_list = PBField.initBytes(byteStringMicro);
            this.difficulty_desc = PBField.initString("");
            this.grade = PBField.initString("");
        }
    };
    public final PBRepeatField<Long> syncgids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field hw_id = PBField.initUInt64(0);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt32Field feedback_num = PBField.initUInt32(0);
    public final PBBoolField is_read = PBField.initBool(false);
    public final PBUInt32Field feedback = PBField.initUInt32(0);
    public final PBUInt64Field create_ts = PBField.initUInt64(0);

    static {
        String[] strArr = {"group_id", "uin", "course_id", Element.ELEMENT_NAME_COURSE_NAME, "title", "content", "date", "need_feedback", "push_time", "feedback_ts", "multi_media", "team_id", "hw_type", "exam_msg", "syncgids", "hw_id", "appid", "feedback_num", "is_read", "feedback", "create_ts"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 64, 72, 80, 90, 96, 104, 114, 120, 128, 136, 144, 152, 160, 168}, strArr, new Object[]{0L, 0L, 0, "", "", ByteStringMicro.EMPTY, "", bool, 0L, 0L, null, 0L, 0, null, 0L, 0L, 0, 0, bool, 0, 0L}, value$HomeworkInfo.class);
    }
}

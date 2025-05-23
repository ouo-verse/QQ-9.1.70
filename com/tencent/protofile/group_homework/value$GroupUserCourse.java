package com.tencent.protofile.group_homework;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class value$GroupUserCourse extends MessageMicro<value$GroupUserCourse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"course_list", "last_course", "default_exclude"}, new Object[]{null, null, null}, value$GroupUserCourse.class);
    public value$CourseList course_list = new MessageMicro<value$CourseList>() { // from class: com.tencent.protofile.group_homework.value$CourseList
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"course_info"}, new Object[]{null}, value$CourseList.class);
        public final PBRepeatMessageField<value$CourseInfo> course_info = PBField.initRepeatMessage(value$CourseInfo.class);
    };
    public value$CourseInfo last_course = new MessageMicro<value$CourseInfo>() { // from class: com.tencent.protofile.group_homework.value$CourseInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"course_id", Element.ELEMENT_NAME_COURSE_NAME}, new Object[]{0, ""}, value$CourseInfo.class);
        public final PBUInt32Field course_id = PBField.initUInt32(0);
        public final PBStringField course_name = PBField.initString("");
    };
    public value$CourseList default_exclude = new MessageMicro<value$CourseList>() { // from class: com.tencent.protofile.group_homework.value$CourseList
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"course_info"}, new Object[]{null}, value$CourseList.class);
        public final PBRepeatMessageField<value$CourseInfo> course_info = PBField.initRepeatMessage(value$CourseInfo.class);
    };
}

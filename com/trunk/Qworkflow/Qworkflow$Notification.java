package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Qworkflow$Notification extends MessageMicro<Qworkflow$Notification> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"msg_appid", "msg_workflow_change", "msg_schedule_change", "msg_todoitem_change", "msg_timtodo_notice"}, new Object[]{null, null, null, null, null}, Qworkflow$Notification.class);
    public Qworkflow$AppID msg_appid = new Qworkflow$AppID();
    public Qworkflow$WorkflowChangeNotification msg_workflow_change = new Qworkflow$WorkflowChangeNotification();
    public Qworkflow$ScheduleChangeNotification msg_schedule_change = new MessageMicro<Qworkflow$ScheduleChangeNotification>() { // from class: com.trunk.Qworkflow.Qworkflow$ScheduleChangeNotification
        public static final int ACCEPT = 7;
        public static final int CREATE = 5;
        public static final int DELETE = 3;
        public static final int EXPIRED = 1;
        public static final int RECALL = 4;
        public static final int SHARE_RECVD = 2;
        public static final int UPDATE = 6;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_title;
        public final PBBytesField bytes_workflow_id;
        public final PBEnumField enum_change_type;
        public final PBEnumField enum_repeated_type;
        public Qworkflow$BusinessInfo msg_busi_info;
        public Qworkflow$Timespan msg_changed_timespan;
        public Qworkflow$Text msg_summary;
        public final PBRepeatMessageField<Qworkflow$Timespan> rpt_msg_repeated_effective_timespan;
        public final PBUInt32Field uint32_main_type;
        public final PBUInt32Field uint32_remind_bell_switch;
        public final PBUInt32Field uint32_sub_type;
        public final PBUInt64Field uint64_author_uin;
        public final PBUInt64Field uint64_end_time;
        public final PBUInt64Field uint64_start_time;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 24, 32, 40, 50, 58, 64, 72, 80, 90, 98, 104, 112, 122}, new String[]{"bytes_workflow_id", "uint32_main_type", "uint32_sub_type", "uint64_author_uin", "bytes_title", "msg_summary", "enum_change_type", "uint32_remind_bell_switch", "enum_repeated_type", "msg_changed_timespan", "rpt_msg_repeated_effective_timespan", "uint64_start_time", "uint64_end_time", "msg_busi_info"}, new Object[]{byteStringMicro, 0, 0, 0L, byteStringMicro, null, 1, 0, 1, null, null, 0L, 0L, null}, Qworkflow$ScheduleChangeNotification.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_workflow_id = PBField.initBytes(byteStringMicro);
            this.uint32_main_type = PBField.initUInt32(0);
            this.uint32_sub_type = PBField.initUInt32(0);
            this.uint64_author_uin = PBField.initUInt64(0L);
            this.bytes_title = PBField.initBytes(byteStringMicro);
            this.msg_summary = new Qworkflow$Text();
            this.enum_change_type = PBField.initEnum(1);
            this.uint32_remind_bell_switch = PBField.initUInt32(0);
            this.enum_repeated_type = PBField.initEnum(1);
            this.msg_changed_timespan = new Qworkflow$Timespan();
            this.rpt_msg_repeated_effective_timespan = PBField.initRepeatMessage(Qworkflow$Timespan.class);
            this.uint64_start_time = PBField.initUInt64(0L);
            this.uint64_end_time = PBField.initUInt64(0L);
            this.msg_busi_info = new Qworkflow$BusinessInfo();
        }
    };
    public Qworkflow$TodoChangeNotification msg_todoitem_change = new MessageMicro<Qworkflow$TodoChangeNotification>() { // from class: com.trunk.Qworkflow.Qworkflow$TodoChangeNotification
        public static final int ADD_NEW = 1;
        public static final int CONFIRM_READ = 4;
        public static final int DELETE = 2;
        public static final int DELETE_ALL = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"enum_change_type", "rpt_change_item_list"}, new Object[]{1, null}, Qworkflow$TodoChangeNotification.class);
        public final PBEnumField enum_change_type = PBField.initEnum(1);
        public final PBRepeatMessageField<Qworkflow$TodoChangeItem> rpt_change_item_list = PBField.initRepeatMessage(Qworkflow$TodoChangeItem.class);
    };
    public Qworkflow$TimTodoNotification msg_timtodo_notice = new MessageMicro<Qworkflow$TimTodoNotification>() { // from class: com.trunk.Qworkflow.Qworkflow$TimTodoNotification
        public static final int SHARE_TODO = 1;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_title;
        public final PBBytesField bytes_todo_id;
        public final PBEnumField enum_notice_type = PBField.initEnum(1);
        public final PBUInt64Field uint64_author_uin;
        public final PBUInt64Field uint64_remind_end;
        public final PBUInt64Field uint64_remind_start;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48}, new String[]{"enum_notice_type", "bytes_todo_id", "uint64_author_uin", "bytes_title", "uint64_remind_start", "uint64_remind_end"}, new Object[]{1, byteStringMicro, 0L, byteStringMicro, 0L, 0L}, Qworkflow$TimTodoNotification.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_todo_id = PBField.initBytes(byteStringMicro);
            this.uint64_author_uin = PBField.initUInt64(0L);
            this.bytes_title = PBField.initBytes(byteStringMicro);
            this.uint64_remind_start = PBField.initUInt64(0L);
            this.uint64_remind_end = PBField.initUInt64(0L);
        }
    };
}

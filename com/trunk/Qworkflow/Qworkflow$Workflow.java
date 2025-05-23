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
public final class Qworkflow$Workflow extends MessageMicro<Qworkflow$Workflow> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 58, 66, 74, 82, 90, 96, 106, 112, 122, 130, 138, 144, 154, 162}, new String[]{"bytes_workflow_id", "uint64_author_uin", "uint32_main_type", "uint32_sub_type", "uint64_create_time", "uint64_last_modify_time", "msg_current_state", "msg_workflow_content", "rpt_msg_workflow_state_with_approver", "rpt_msg_observers", "msg_workflow_extend_state", "uint32_data_version", "msg_remind_timer", "uint64_recv_time", "msg_online_push_content", "msg_todo_info", "related_source_id", "uint32_remind_bell_switch", "msg_busi_info", "rpt_noticed_users"}, new Object[]{ByteStringMicro.EMPTY, 0L, 0, 0, 0L, 0L, null, null, null, null, null, 0, null, 0L, null, null, null, 0, null, null}, Qworkflow$Workflow.class);
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_create_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_last_modify_time = PBField.initUInt64(0);
    public Qworkflow$WorkflowState msg_current_state = new Qworkflow$WorkflowState();
    public Qworkflow$WorkflowContent msg_workflow_content = new MessageMicro<Qworkflow$WorkflowContent>() { // from class: com.trunk.Qworkflow.Qworkflow$WorkflowContent
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_title;
        public final PBBytesField bytes_userdef;
        public final PBRepeatMessageField<Qworkflow$ContentElement> rpt_content_list;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"bytes_title", "rpt_content_list", "bytes_userdef"}, new Object[]{byteStringMicro, null, byteStringMicro}, Qworkflow$WorkflowContent.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_title = PBField.initBytes(byteStringMicro);
            this.rpt_content_list = PBField.initRepeatMessage(Qworkflow$ContentElement.class);
            this.bytes_userdef = PBField.initBytes(byteStringMicro);
        }
    };
    public final PBRepeatMessageField<Qworkflow$WorkflowStateWithApprover> rpt_msg_workflow_state_with_approver = PBField.initRepeatMessage(Qworkflow$WorkflowStateWithApprover.class);
    public final PBRepeatMessageField<Qworkflow$Observer> rpt_msg_observers = PBField.initRepeatMessage(Qworkflow$Observer.class);
    public Qworkflow$WorkflowExtendState msg_workflow_extend_state = new Qworkflow$WorkflowExtendState();
    public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
    public Qworkflow$RemindTimer msg_remind_timer = new MessageMicro<Qworkflow$RemindTimer>() { // from class: com.trunk.Qworkflow.Qworkflow$RemindTimer
        public static final int AFTER_START_TIME = 2;
        public static final int BEFORE_START_TIME = 1;
        public static final int EVERY_DAY = 2;
        public static final int EVERY_FORTNIGHT = 4;
        public static final int EVERY_MONTH = 5;
        public static final int EVERY_WEEK = 3;
        public static final int EVERY_WORKDAY = 6;
        public static final int EVERY_YEAR = 7;
        public static final int NO_REPEATE = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 66}, new String[]{"uint64_start_time", "uint64_end_time", "enum_remind_offset_type", "uint32_remind_offset", "rpt_msg_observers", "enum_repeat_type", "uint32_remind_flag", "rpt_msg_repeated_effective_timespan"}, new Object[]{0L, 0L, 1, 0, null, 1, 0, null}, Qworkflow$RemindTimer.class);
        public final PBUInt64Field uint64_start_time = PBField.initUInt64(0);
        public final PBUInt64Field uint64_end_time = PBField.initUInt64(0);
        public final PBEnumField enum_remind_offset_type = PBField.initEnum(1);
        public final PBUInt32Field uint32_remind_offset = PBField.initUInt32(0);
        public final PBRepeatMessageField<Qworkflow$Observer> rpt_msg_observers = PBField.initRepeatMessage(Qworkflow$Observer.class);
        public final PBEnumField enum_repeat_type = PBField.initEnum(1);
        public final PBUInt32Field uint32_remind_flag = PBField.initUInt32(0);
        public final PBRepeatMessageField<Qworkflow$Timespan> rpt_msg_repeated_effective_timespan = PBField.initRepeatMessage(Qworkflow$Timespan.class);
    };
    public final PBUInt64Field uint64_recv_time = PBField.initUInt64(0);
    public Qworkflow$Text msg_online_push_content = new Qworkflow$Text();
    public Qworkflow$TodoInfo msg_todo_info = new MessageMicro<Qworkflow$TodoInfo>() { // from class: com.trunk.Qworkflow.Qworkflow$TodoInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"msg_todo_title", "msg_todo_content", "uint32_template_type", "msg_default_button", "rpt_button_list"}, new Object[]{null, null, 0, null, null}, Qworkflow$TodoInfo.class);
        public Qworkflow$Text msg_todo_title = new Qworkflow$Text();
        public Qworkflow$Text msg_todo_content = new Qworkflow$Text();
        public final PBUInt32Field uint32_template_type = PBField.initUInt32(0);
        public Qworkflow$Button msg_default_button = new MessageMicro<Qworkflow$Button>() { // from class: com.trunk.Qworkflow.Qworkflow$Button
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_id", "bytes_title", "msg_on_click_operation"}, new Object[]{0, ByteStringMicro.EMPTY, null}, Qworkflow$Button.class);
            public final PBUInt32Field uint32_id = PBField.initUInt32(0);
            public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
            public Qworkflow$Operation msg_on_click_operation = new MessageMicro<Qworkflow$Operation>() { // from class: com.trunk.Qworkflow.Qworkflow$Operation
                public static final int LOCAL = 1;
                public static final int URL_BACKGROUND = 3;
                public static final int URL_IN_NEW_WINDOW = 2;
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 26}, new String[]{"enum_operation_act", "bytes_command"}, new Object[]{1, ByteStringMicro.EMPTY}, Qworkflow$Operation.class);
                public final PBEnumField enum_operation_act = PBField.initEnum(1);
                public final PBBytesField bytes_command = PBField.initBytes(ByteStringMicro.EMPTY);
            };
        };
        public final PBRepeatMessageField<Qworkflow$Button> rpt_button_list = PBField.initRepeatMessage(Qworkflow$Button.class);
    };
    public Qworkflow$AppID related_source_id = new Qworkflow$AppID();
    public final PBUInt32Field uint32_remind_bell_switch = PBField.initUInt32(0);
    public Qworkflow$BusinessInfo msg_busi_info = new Qworkflow$BusinessInfo();
    public final PBRepeatMessageField<Qworkflow$NoticedUser> rpt_noticed_users = PBField.initRepeatMessage(Qworkflow$NoticedUser.class);
}

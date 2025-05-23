package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Qworkflow$WorkflowChangeNotification extends MessageMicro<Qworkflow$WorkflowChangeNotification> {
    public static final int DENY_END = 3;
    public static final int HASTEN_RECVED = 4;
    public static final int NEED_APPROVE = 7;
    public static final int NEED_OBSERVE = 8;
    public static final int PERMIT_END = 2;
    public static final int READED = 6;
    public static final int RECALLED = 1;
    public static final int SHARE_RECVD = 5;
    public static final int UPDATED = 9;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_title;
    public final PBBytesField bytes_workflow_id;
    public final PBEnumField enum_change_type;
    public Qworkflow$WorkflowState msg_current_state;
    public Qworkflow$Text msg_summary;
    public final PBUInt32Field uint32_data_version;
    public final PBUInt32Field uint32_main_type;
    public final PBUInt32Field uint32_sub_type;
    public final PBUInt64Field uint64_author_uin;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 24, 32, 40, 50, 58, 64, 74, 80}, new String[]{"bytes_workflow_id", "uint32_main_type", "uint32_sub_type", "uint64_author_uin", "bytes_title", "msg_summary", "enum_change_type", "msg_current_state", "uint32_data_version"}, new Object[]{byteStringMicro, 0, 0, 0L, byteStringMicro, null, 1, null, 0}, Qworkflow$WorkflowChangeNotification.class);
    }

    public Qworkflow$WorkflowChangeNotification() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_workflow_id = PBField.initBytes(byteStringMicro);
        this.uint32_main_type = PBField.initUInt32(0);
        this.uint32_sub_type = PBField.initUInt32(0);
        this.uint64_author_uin = PBField.initUInt64(0L);
        this.bytes_title = PBField.initBytes(byteStringMicro);
        this.msg_summary = new Qworkflow$Text();
        this.enum_change_type = PBField.initEnum(1);
        this.msg_current_state = new Qworkflow$WorkflowState();
        this.uint32_data_version = PBField.initUInt32(0);
    }
}

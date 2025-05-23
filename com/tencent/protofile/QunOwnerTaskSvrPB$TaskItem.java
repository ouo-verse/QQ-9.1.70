package com.tencent.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* loaded from: classes22.dex */
public final class QunOwnerTaskSvrPB$TaskItem extends MessageMicro<QunOwnerTaskSvrPB$TaskItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"base_info", "group_info", "user_info", "button_info"}, new Object[]{null, null, null, null}, QunOwnerTaskSvrPB$TaskItem.class);
    public QunOwnerTaskSvrPB$TaskInfo base_info = new MessageMicro<QunOwnerTaskSvrPB$TaskInfo>() { // from class: com.tencent.protofile.QunOwnerTaskSvrPB$TaskInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50, 58, 66, 74, 80, 88}, new String[]{"id", "name", "start_time", "end_time", "content", "detail_desc", "partner", "cover", "address", "is_expired", "status"}, new Object[]{"", "", 0L, 0L, "", "", "", "", "", 0, 0}, QunOwnerTaskSvrPB$TaskInfo.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBStringField f342185id = PBField.initString("");
        public final PBStringField name = PBField.initString("");
        public final PBInt64Field start_time = PBField.initInt64(0);
        public final PBInt64Field end_time = PBField.initInt64(0);
        public final PBStringField content = PBField.initString("");
        public final PBStringField detail_desc = PBField.initString("");
        public final PBStringField partner = PBField.initString("");
        public final PBStringField cover = PBField.initString("");
        public final PBStringField address = PBField.initString("");
        public final PBUInt32Field is_expired = PBField.initUInt32(0);
        public final PBUInt32Field status = PBField.initUInt32(0);
    };
    public QunOwnerTaskSvrPB$GroupInfo group_info = new MessageMicro<QunOwnerTaskSvrPB$GroupInfo>() { // from class: com.tencent.protofile.QunOwnerTaskSvrPB$GroupInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"group_id", "group_head", "group_nick"}, new Object[]{0L, "", ""}, QunOwnerTaskSvrPB$GroupInfo.class);
        public final PBUInt64Field group_id = PBField.initUInt64(0);
        public final PBStringField group_head = PBField.initString("");
        public final PBStringField group_nick = PBField.initString("");
    };
    public QunOwnerTaskSvrPB$UserInfo user_info = new MessageMicro<QunOwnerTaskSvrPB$UserInfo>() { // from class: com.tencent.protofile.QunOwnerTaskSvrPB$UserInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"user_id", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, "head_url"}, new Object[]{0L, "", ""}, QunOwnerTaskSvrPB$UserInfo.class);
        public final PBUInt64Field user_id = PBField.initUInt64(0);
        public final PBStringField nick_name = PBField.initString("");
        public final PBStringField head_url = PBField.initString("");
    };
    public QunOwnerTaskSvrPB$ButtonInfo button_info = new MessageMicro<QunOwnerTaskSvrPB$ButtonInfo>() { // from class: com.tencent.protofile.QunOwnerTaskSvrPB$ButtonInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"text", "group_num"}, new Object[]{"", 0}, QunOwnerTaskSvrPB$ButtonInfo.class);
        public final PBStringField text = PBField.initString("");
        public final PBUInt32Field group_num = PBField.initUInt32(0);
    };
}

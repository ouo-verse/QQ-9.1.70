package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes7.dex */
public final class QQProtectUpdate$UpdateQueryRequest extends MessageMicro<QQProtectUpdate$UpdateQueryRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"head_update_query", "body_update_query"}, new Object[]{null, null}, QQProtectUpdate$UpdateQueryRequest.class);
    public QQProtectCommon$QQProtectQueryHead head_update_query = new QQProtectCommon$QQProtectQueryHead();
    public QQProtectUpdate$UpdateQueryBody body_update_query = new MessageMicro<QQProtectUpdate$UpdateQueryBody>() { // from class: com.tencent.ims.QQProtectUpdate$UpdateQueryBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_file_id", "uint32_file_local_version"}, new Object[]{0, 0}, QQProtectUpdate$UpdateQueryBody.class);
        public final PBUInt32Field uint32_file_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_file_local_version = PBField.initUInt32(0);
    };
}

package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class QSecControlBitsQuery$QSecCbQuery extends MessageMicro<QSecControlBitsQuery$QSecCbQuery> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"cb_query_head", "cb_query_body"}, new Object[]{null, null}, QSecControlBitsQuery$QSecCbQuery.class);
    public QQProtectCommon$QQProtectQueryHead cb_query_head = new QQProtectCommon$QQProtectQueryHead();
    public QSecControlBitsQuery$QSecCbQueryBody cb_query_body = new MessageMicro<QSecControlBitsQuery$QSecCbQueryBody>() { // from class: com.tencent.ims.QSecControlBitsQuery$QSecCbQueryBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"u32_cfg_id", "u32_qsec_ver"}, new Object[]{0, 0}, QSecControlBitsQuery$QSecCbQueryBody.class);
        public final PBUInt32Field u32_cfg_id = PBField.initUInt32(0);
        public final PBUInt32Field u32_qsec_ver = PBField.initUInt32(0);
    };
}

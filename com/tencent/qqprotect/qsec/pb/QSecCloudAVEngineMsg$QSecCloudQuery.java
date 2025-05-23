package com.tencent.qqprotect.qsec.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqprotect.common.pb.QQProtectCommon$QQProtectQueryHead;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class QSecCloudAVEngineMsg$QSecCloudQuery extends MessageMicro<QSecCloudAVEngineMsg$QSecCloudQuery> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"head", "body"}, new Object[]{null, null}, QSecCloudAVEngineMsg$QSecCloudQuery.class);
    public QQProtectCommon$QQProtectQueryHead head = new QQProtectCommon$QQProtectQueryHead();
    public QSecCloudAVEngineMsg$QSecCloudQueryBody body = new MessageMicro<QSecCloudAVEngineMsg$QSecCloudQueryBody>() { // from class: com.tencent.qqprotect.qsec.pb.QSecCloudAVEngineMsg$QSecCloudQueryBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"version", "queryEntry"}, new Object[]{0, null}, QSecCloudAVEngineMsg$QSecCloudQueryBody.class);
        public final PBUInt32Field version = PBField.initUInt32(0);
        public final PBRepeatMessageField<QSecCloudAVEngineMsg$QSecCloudQueryEntry> queryEntry = PBField.initRepeatMessage(QSecCloudAVEngineMsg$QSecCloudQueryEntry.class);
    };
}

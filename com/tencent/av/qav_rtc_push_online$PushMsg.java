package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes3.dex */
public final class qav_rtc_push_online$PushMsg extends MessageMicro<qav_rtc_push_online$PushMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 26}, new String[]{"multi_sync_msg", "login_push_msg"}, new Object[]{null, null}, qav_rtc_push_online$PushMsg.class);
    public qav_rtc_push_online$MultiTerminalSyncMsg multi_sync_msg = new MessageMicro<qav_rtc_push_online$MultiTerminalSyncMsg>() { // from class: com.tencent.av.qav_rtc_push_online$MultiTerminalSyncMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56}, new String[]{"term_type", "opereation", "client_seq", "business_type", "relation_type", "relation_id", "av_sdk_version"}, new Object[]{0, 0, 0, 0, 0, 0L, 0}, qav_rtc_push_online$MultiTerminalSyncMsg.class);
        public final PBUInt32Field term_type = PBField.initUInt32(0);
        public final PBUInt32Field opereation = PBField.initUInt32(0);
        public final PBUInt32Field client_seq = PBField.initUInt32(0);
        public final PBUInt32Field business_type = PBField.initUInt32(0);
        public final PBUInt32Field relation_type = PBField.initUInt32(0);
        public final PBUInt64Field relation_id = PBField.initUInt64(0);
        public final PBUInt32Field av_sdk_version = PBField.initUInt32(0);
    };
    public qav_rtc_push_online$LoginPushMsg login_push_msg = new qav_rtc_push_online$LoginPushMsg();
}

package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class PendantOuterClass$PendantMsgContent extends MessageMicro<PendantOuterClass$PendantMsgContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"redpacket", "sub_script", "power"}, new Object[]{null, null, null}, PendantOuterClass$PendantMsgContent.class);
    public PendantOuterClass$PendantMsgRedpacket redpacket = new MessageMicro<PendantOuterClass$PendantMsgRedpacket>() { // from class: com.tencent.icgame.trpc.yes.common.PendantOuterClass$PendantMsgRedpacket
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 56}, new String[]{"activity_id", "status", "init_pic", "active_pic", "anchor_hint_text", "audience_hint_text", "progress_full_time"}, new Object[]{"", 0, null, null, "", "", 0L}, PendantOuterClass$PendantMsgRedpacket.class);
        public final PBStringField activity_id = PBField.initString("");
        public final PBInt32Field status = PBField.initInt32(0);
        public CommonOuterClass$ImageItem init_pic = new CommonOuterClass$ImageItem();
        public CommonOuterClass$ImageItem active_pic = new CommonOuterClass$ImageItem();
        public final PBStringField anchor_hint_text = PBField.initString("");
        public final PBStringField audience_hint_text = PBField.initString("");
        public final PBUInt64Field progress_full_time = PBField.initUInt64(0);
    };
    public PendantOuterClass$PendantMsgSubscript sub_script = new PendantOuterClass$PendantMsgSubscript();
    public PendantOuterClass$PendantMsgPower power = new MessageMicro<PendantOuterClass$PendantMsgPower>() { // from class: com.tencent.icgame.trpc.yes.common.PendantOuterClass$PendantMsgPower
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"recent_task_watch_time", "prepare_recv_task_total", "day_task_status", "prepare_recv_power_total"}, new Object[]{0, 0, 0, 0}, PendantOuterClass$PendantMsgPower.class);
        public final PBInt32Field recent_task_watch_time = PBField.initInt32(0);
        public final PBInt32Field prepare_recv_task_total = PBField.initInt32(0);
        public final PBInt32Field day_task_status = PBField.initInt32(0);
        public final PBInt32Field prepare_recv_power_total = PBField.initInt32(0);
    };
}

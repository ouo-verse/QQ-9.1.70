package com.tencent.pb.now;

import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_short_video_label$VideoStatus extends MessageMicro<ilive_short_video_label$VideoStatus> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 69, 72, 80, 88}, new String[]{AudienceReportConst.ROOM_ID, "root_room_id", "stat", "live_type", "timestamp", AudienceReportConst.CLIENT_TYPE, "uin", "video_begin_timestamp", HianalyticsBaseData.SDK_TYPE, "master_uin", "co_play_uin"}, new Object[]{0, 0, 0, 0, 0, 0, 0L, 0, 0, 0L, 0L}, ilive_short_video_label$VideoStatus.class);
    public final PBUInt32Field room_id = PBField.initUInt32(0);
    public final PBUInt32Field root_room_id = PBField.initUInt32(0);
    public final PBUInt32Field stat = PBField.initUInt32(0);
    public final PBUInt32Field live_type = PBField.initUInt32(0);
    public final PBUInt32Field timestamp = PBField.initUInt32(0);
    public final PBUInt32Field client_type = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBFixed32Field video_begin_timestamp = PBField.initFixed32(0);
    public final PBUInt32Field sdk_type = PBField.initUInt32(0);
    public final PBUInt64Field master_uin = PBField.initUInt64(0);
    public final PBRepeatField<Long> co_play_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}

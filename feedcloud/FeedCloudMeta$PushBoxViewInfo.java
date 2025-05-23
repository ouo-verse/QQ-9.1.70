package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqmini.sdk.widget.ToastView;

/* loaded from: classes28.dex */
public final class FeedCloudMeta$PushBoxViewInfo extends MessageMicro<FeedCloudMeta$PushBoxViewInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 21, 24, 32, 42, 48, 58, 66, 74, 80, 88, 96, 104, 112, 120, 130}, new String[]{"viewType", ToastView.ICON_LOADING, "boxType", "drawCount", "desc", "available_box_cnt", "rules_jump_url", "push_time", "task_center_jump_url", "total_heat_num", "normal_box_draw_count", "super_box_draw_count", "normal_box_heat_num", "super_box_heat_num", "push_timestamp", "rocket_consume_id"}, new Object[]{0, Float.valueOf(0.0f), 0, 0L, "", 0, "", "", "", 0L, 0L, 0L, 0L, 0L, 0L, ""}, FeedCloudMeta$PushBoxViewInfo.class);
    public final PBUInt32Field viewType = PBField.initUInt32(0);
    public final PBFloatField loading = PBField.initFloat(0.0f);
    public final PBUInt32Field boxType = PBField.initUInt32(0);
    public final PBUInt64Field drawCount = PBField.initUInt64(0);
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field available_box_cnt = PBField.initUInt32(0);
    public final PBStringField rules_jump_url = PBField.initString("");
    public final PBStringField push_time = PBField.initString("");
    public final PBStringField task_center_jump_url = PBField.initString("");
    public final PBInt64Field total_heat_num = PBField.initInt64(0);
    public final PBInt64Field normal_box_draw_count = PBField.initInt64(0);
    public final PBInt64Field super_box_draw_count = PBField.initInt64(0);
    public final PBInt64Field normal_box_heat_num = PBField.initInt64(0);
    public final PBInt64Field super_box_heat_num = PBField.initInt64(0);
    public final PBInt64Field push_timestamp = PBField.initInt64(0);
    public final PBStringField rocket_consume_id = PBField.initString("");
}

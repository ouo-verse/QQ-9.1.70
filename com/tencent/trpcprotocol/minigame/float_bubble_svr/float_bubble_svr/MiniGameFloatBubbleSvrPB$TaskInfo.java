package com.tencent.trpcprotocol.minigame.float_bubble_svr.float_bubble_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class MiniGameFloatBubbleSvrPB$TaskInfo extends MessageMicro<MiniGameFloatBubbleSvrPB$TaskInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"task_id", "task_type", "is_finished", "progress"}, new Object[]{"", 0, Boolean.FALSE, 0}, MiniGameFloatBubbleSvrPB$TaskInfo.class);
    public final PBStringField task_id = PBField.initString("");
    public final PBEnumField task_type = PBField.initEnum(0);
    public final PBBoolField is_finished = PBField.initBool(false);
    public final PBInt32Field progress = PBField.initInt32(0);
}

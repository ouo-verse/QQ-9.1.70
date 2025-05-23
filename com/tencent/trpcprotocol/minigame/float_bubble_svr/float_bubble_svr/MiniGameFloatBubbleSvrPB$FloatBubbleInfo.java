package com.tencent.trpcprotocol.minigame.float_bubble_svr.float_bubble_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class MiniGameFloatBubbleSvrPB$FloatBubbleInfo extends MessageMicro<MiniGameFloatBubbleSvrPB$FloatBubbleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"is_valid", "bubble_config", "task_info", "adward_info"}, new Object[]{Boolean.FALSE, null, null, null}, MiniGameFloatBubbleSvrPB$FloatBubbleInfo.class);
    public final PBBoolField is_valid = PBField.initBool(false);
    public MiniGameFloatBubbleSvrPB$BubbleConfig bubble_config = new MiniGameFloatBubbleSvrPB$BubbleConfig();
    public MiniGameFloatBubbleSvrPB$TaskInfo task_info = new MiniGameFloatBubbleSvrPB$TaskInfo();
    public MiniGameFloatBubbleSvrPB$AdwardInfo adward_info = new MessageMicro<MiniGameFloatBubbleSvrPB$AdwardInfo>() { // from class: com.tencent.trpcprotocol.minigame.float_bubble_svr.float_bubble_svr.MiniGameFloatBubbleSvrPB$AdwardInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"name", "desc", "icon", "is_received"}, new Object[]{"", "", "", Boolean.FALSE}, MiniGameFloatBubbleSvrPB$AdwardInfo.class);
        public final PBStringField name = PBField.initString("");
        public final PBStringField desc = PBField.initString("");
        public final PBStringField icon = PBField.initString("");
        public final PBBoolField is_received = PBField.initBool(false);
    };
}

package com.tencent.trpcprotocol.minigame.float_bubble_svr.float_bubble_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class MiniGameFloatBubbleSvrPB$CloseBubbleReq extends MessageMicro<MiniGameFloatBubbleSvrPB$CloseBubbleReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"appid", "task_id"}, new Object[]{"", ""}, MiniGameFloatBubbleSvrPB$CloseBubbleReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField task_id = PBField.initString("");
}

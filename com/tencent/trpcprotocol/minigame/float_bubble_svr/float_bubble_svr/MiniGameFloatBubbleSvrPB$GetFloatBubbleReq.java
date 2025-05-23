package com.tencent.trpcprotocol.minigame.float_bubble_svr.float_bubble_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class MiniGameFloatBubbleSvrPB$GetFloatBubbleReq extends MessageMicro<MiniGameFloatBubbleSvrPB$GetFloatBubbleReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"appid"}, new Object[]{""}, MiniGameFloatBubbleSvrPB$GetFloatBubbleReq.class);
    public final PBStringField appid = PBField.initString("");
}

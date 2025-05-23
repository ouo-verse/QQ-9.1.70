package com.tencent.trpcprotocol.minigame.float_bubble_svr.float_bubble_svr;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes38.dex */
public final class MiniGameFloatBubbleSvrPB$GetFloatBubbleRsp extends MessageMicro<MiniGameFloatBubbleSvrPB$GetFloatBubbleRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bubble_info", WidgetCacheConstellationData.INTERVAL}, new Object[]{null, 0L}, MiniGameFloatBubbleSvrPB$GetFloatBubbleRsp.class);
    public MiniGameFloatBubbleSvrPB$FloatBubbleInfo bubble_info = new MiniGameFloatBubbleSvrPB$FloatBubbleInfo();
    public final PBInt64Field interval = PBField.initInt64(0);
}

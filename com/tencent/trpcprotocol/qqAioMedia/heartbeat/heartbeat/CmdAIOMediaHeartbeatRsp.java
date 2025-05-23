package com.tencent.trpcprotocol.qqAioMedia.heartbeat.heartbeat;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.aio.media.aio_media$ResultInfo;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class CmdAIOMediaHeartbeatRsp extends MessageMicro<CmdAIOMediaHeartbeatRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"msg_result", WidgetCacheConstellationData.INTERVAL}, new Object[]{null, 0}, CmdAIOMediaHeartbeatRsp.class);
    public aio_media$ResultInfo msg_result = new aio_media$ResultInfo();
    public final PBUInt32Field interval = PBField.initUInt32(0);
}

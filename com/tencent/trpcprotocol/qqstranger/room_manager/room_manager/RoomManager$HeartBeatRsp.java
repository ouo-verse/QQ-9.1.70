package com.tencent.trpcprotocol.qqstranger.room_manager.room_manager;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomManager$HeartBeatRsp extends MessageMicro<RoomManager$HeartBeatRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{WidgetCacheConstellationData.INTERVAL}, new Object[]{0L}, RoomManager$HeartBeatRsp.class);
    public final PBUInt64Field interval = PBField.initUInt64(0);
}

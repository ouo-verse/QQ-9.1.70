package com.tencent.trpcprotocol.qqAioMedia.heartbeat.heartbeat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class CmdAIOMediaHeartbeatReq extends MessageMicro<CmdAIOMediaHeartbeatReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"enum_aio_type", "uint64_id", "enum_media_type"}, new Object[]{1, 0L, 1}, CmdAIOMediaHeartbeatReq.class);
    public final PBEnumField enum_aio_type = PBField.initEnum(1);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0);
    public final PBEnumField enum_media_type = PBField.initEnum(1);
}

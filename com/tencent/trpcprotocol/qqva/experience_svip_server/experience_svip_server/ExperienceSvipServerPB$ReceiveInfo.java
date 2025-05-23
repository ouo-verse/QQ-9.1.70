package com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class ExperienceSvipServerPB$ReceiveInfo extends MessageMicro<ExperienceSvipServerPB$ReceiveInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"can_receive", "reason", "auto_receive_delay_sec"}, new Object[]{Boolean.FALSE, "", 0L}, ExperienceSvipServerPB$ReceiveInfo.class);
    public final PBBoolField can_receive = PBField.initBool(false);
    public final PBStringField reason = PBField.initString("");
    public final PBInt64Field auto_receive_delay_sec = PBField.initInt64(0);
}

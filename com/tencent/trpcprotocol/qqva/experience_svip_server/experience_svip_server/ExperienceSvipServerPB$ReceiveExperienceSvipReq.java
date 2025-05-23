package com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class ExperienceSvipServerPB$ReceiveExperienceSvipReq extends MessageMicro<ExperienceSvipServerPB$ReceiveExperienceSvipReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"enterance_id"}, new Object[]{""}, ExperienceSvipServerPB$ReceiveExperienceSvipReq.class);
    public final PBStringField enterance_id = PBField.initString("");
}

package com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class ExperienceSvipServerPB$Tianxuan extends MessageMicro<ExperienceSvipServerPB$Tianxuan> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"buy_num", "item_id", "card_id"}, new Object[]{0, "", ""}, ExperienceSvipServerPB$Tianxuan.class);
    public final PBInt32Field buy_num = PBField.initInt32(0);
    public final PBStringField item_id = PBField.initString("");
    public final PBStringField card_id = PBField.initString("");
}

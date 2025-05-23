package com.tencent.trpcprotocol.minigame.pc_guide;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class GetPCGuideReq extends MessageMicro<GetPCGuideReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"appid"}, new Object[]{""}, GetPCGuideReq.class);
    public final PBStringField appid = PBField.initString("");
}

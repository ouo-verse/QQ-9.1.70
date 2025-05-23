package com.tencent.filament.zplanservice.pbjava;

import com.tencent.filament.zplanservice.pbjava.avatar_info.AvatarDressInfo$AvatarCharacter;
import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes6.dex */
public final class ZPlanInfoChannel$GetNowAvatarInfoResponse extends MessageMicro<ZPlanInfoChannel$GetNowAvatarInfoResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"avatar_info", "error"}, new Object[]{null, null}, ZPlanInfoChannel$GetNowAvatarInfoResponse.class);
    public AvatarDressInfo$AvatarCharacter avatar_info = new AvatarDressInfo$AvatarCharacter();
    public ZPlanError error = new ZPlanError();
}
